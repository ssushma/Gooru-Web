/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.gin;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.ClosingHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.gwtplatform.mvp.client.proxy.GetPlaceTitleEvent;
import com.gwtplatform.mvp.client.proxy.LockInteractionEvent;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.NavigationRefusedEvent;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.SetPlaceTitleHandler;
import com.gwtplatform.mvp.client.proxy.TokenFormatException;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;
/**
 * 
 * @fileName : GooruPlaceManagerImpl.java
 *
 * @description : This is the default implementation of the {@link PlaceManager}.
 *
 * @version : 1.0
 *
 * @date: 26-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class GooruPlaceManagerImpl extends PlaceManagerImpl implements PlaceManager,
    ValueChangeHandler<String>, ClosingHandler {

  private final EventBus eventBus;
  private String currentHistoryToken = "";

  private boolean internalError;
  private String onLeaveQuestion;
  private List<PlaceRequest> placeHierarchy = new ArrayList<PlaceRequest>();

  private final TokenFormatter tokenFormatter;

  private HandlerRegistration windowClosingHandlerRegistration;
  private boolean locked;
  private Command defferedNavigation;
	/**
	 * Parameterized constructor for two intlization.
	 * @param eventBus
	 * @param tokenFormatter
	 */
  public GooruPlaceManagerImpl(EventBus eventBus, TokenFormatter tokenFormatter) {
	  super(eventBus,tokenFormatter);
    this.eventBus = eventBus;
    this.tokenFormatter = tokenFormatter;
    registerTowardsHistory();
  }
  /**
   * This method is used to build the history token.
   */
  @Override
  public String buildHistoryToken(PlaceRequest request) {
    return tokenFormatter.toPlaceToken(request);
  }
  /**
   * This method is used to build the Relative history token based on the passed level.
   */
  @Override
  public String buildRelativeHistoryToken(int level) {
    List<PlaceRequest> placeHierarchyCopy = truncatePlaceHierarchy(level);
    if (placeHierarchyCopy.size() == 0) {
      return "";
    }
    return tokenFormatter.toHistoryToken(placeHierarchyCopy);
  }
  /**
   * This method is used to build the Relative history token based on the passed Place Request.
   */
  @Override
  public String buildRelativeHistoryToken(PlaceRequest request) {
    return buildRelativeHistoryToken(request, 0);
  }
  /**
   * This method is used to build the Relative history token based on the passed Place Request and level.
   */
  @Override
  public String buildRelativeHistoryToken(PlaceRequest request, int level) {
    List<PlaceRequest> placeHierarchyCopy = truncatePlaceHierarchy(level);
    placeHierarchyCopy.add(request);
    return tokenFormatter.toHistoryToken(placeHierarchyCopy);
  }

  /**
   * If a confirmation question is set (see
   * {@link #setOnLeaveConfirmation(String)}), this asks the user if he wants to
   * leave the current page.
   *
   * @return true if the user accepts to leave. false if he refuses.
   */
  private boolean confirmLeaveState() {
    if (onLeaveQuestion == null) {
      return true;
    }
    boolean confirmed = Window.confirm(onLeaveQuestion);
    if (confirmed) {
      // User has confirmed, don't ask any more question.
      setOnLeaveConfirmation(null);
    } else {
      NavigationRefusedEvent.fire(this);
      setBrowserHistoryToken(currentHistoryToken, false);
    }
    return confirmed;
  }

  /**
   * Fires the {@link PlaceRequestInternalEvent} for the given
   * {@link PlaceRequest}. Do not call this method directly,
   * instead call {@link #revealPlace(PlaceRequest)} or a related method.
   *
   * @param request The {@link PlaceRequest} to fire.
   * @param updateBrowserUrl {@code true} If the browser URL should be updated, {@code false}
   *          otherwise.
   */
/*  protected void doRevealPlace(PlaceRequest request, boolean updateBrowserUrl) {
    PlaceRequestInternalEvent requestEvent = new PlaceRequestInternalEvent(request,
        updateBrowserUrl);
    fireEvent(requestEvent);
    if (!requestEvent.isHandled()) {
      unlock();
      error(tokenFormatter.toHistoryToken(placeHierarchy));
    } else if (!requestEvent.isAuthorized()) {
      unlock();
      illegalAccess(tokenFormatter.toHistoryToken(placeHierarchy));
    }
  }*/

  /**
   * Called whenever an error occurred that requires the error page to be shown
   * to the user. This method will detect infinite reveal loops and throw an
   * {@link RuntimeException} in that case.
   *
   * @param invalidHistoryToken The history token that was not recognised.
   */
  private void error(String invalidHistoryToken) {
    startError();
    revealErrorPlace(invalidHistoryToken);
    stopError();
  }
  /**
   * This method is used to fire the Gwt events.
   */
  @Override
  public void fireEvent(GwtEvent<?> event) {
    getEventBus().fireEventFromSource(event, this);
  }
  /**
   * This method is used to get the browser history token.
   */
  String getBrowserHistoryToken() {
    return History.getToken();
  }
  /**
   * This method is used to get all the current Place Hierarchy.
   */
  @Override
  public List<PlaceRequest> getCurrentPlaceHierarchy() {
    return placeHierarchy;
  }
  /**
   * This method is used to get the current Place Request.
   */
  @Override
  public PlaceRequest getCurrentPlaceRequest() {
    if (placeHierarchy.size() > 0) {
      return placeHierarchy.get(placeHierarchy.size() - 1);
    } else {
      return new PlaceRequest();
    }
  }
  /**
   * This method is used to get the current title.
   */
  @Override
  public void getCurrentTitle(SetPlaceTitleHandler handler) {
    getTitle(placeHierarchy.size() - 1, handler);
  }
  /**
   * This method is used to get the Event bus.
   */
  @Override
  public EventBus getEventBus() {
    return eventBus;
  }
  /**
   * This method is used to get the Hierarchy Depth.
   */
  @Override
  public int getHierarchyDepth() {
    return placeHierarchy.size();
  }

  /**
   * Checks that the place manager is not locked and that the user allows the
   * application to navigate (see {@link #confirmLeaveState()}. If the
   * application is allowed to navigate, this method locks navigation.
   *
   * @return true if the place manager can get the lock false otherwise.
   */
  private boolean getLock() {
    if (locked) {
      return false;
    }
    if (!confirmLeaveState()) {
      return false;
    }
    lock();
    return true;
  }
  /**
   * This method is used to get the title.
   */
  @Override
  public void getTitle(int index, SetPlaceTitleHandler handler)
      throws IndexOutOfBoundsException {
    GetPlaceTitleEvent event = new GetPlaceTitleEvent(
        placeHierarchy.get(index), handler);
    fireEvent(event);
    // If nobody took care of the title, indicate it's null
    if (!event.isHandled()) {
      handler.onSetPlaceTitle(null);
    }
  }
  /**
   * This method is used to check the navigation status.
   */
  @Override
  public boolean hasPendingNavigation() {
    return defferedNavigation != null;
  }

  /**
   * Called whenever the user tries to access an page to which he doesn't have
   * access, and we need to reveal the user-defined unauthorized place. This
   * method will detect infinite reveal loops and throw an
   * {@link RuntimeException} in that case.
   *
   * @param historyToken The history token that was not recognised.
   */
  private void illegalAccess(String historyToken) {
    startError();
    revealUnauthorizedPlace(historyToken);
    stopError();
  }

  private void lock() {
    if (!locked) {
      locked = true;
      LockInteractionEvent.fire(this, true);
    }
  }
  /**
   * This method is used to navigate to back form the current place.
   */
  @Override
  public void navigateBack() {
    History.back();
  }

  /**
   * Handles change events from {@link History}.
   */
  @Override
  public void onValueChange(final ValueChangeEvent<String> event) {
    if (locked) {
      defferedNavigation = new Command() {
        @Override
        public void execute() {
          onValueChange(event);
        }
      };
      return;
    }
    if (!getLock()) {
      return;
    }
    String historyToken = event.getValue();
    try {
      if (historyToken.trim().equals("")) {
        unlock();
        revealDefaultPlace();
      } else {
    	  historyToken=modifyNameToken(historyToken);
        placeHierarchy = tokenFormatter.toPlaceRequestHierarchy(historyToken);
        doRevealPlace(getCurrentPlaceRequest(), true);
      }
    } catch (TokenFormatException e) {
      unlock();
      error(historyToken);
      NavigationEvent.fire(this, null);
    }
  }

  @Override
  public void onWindowClosing(ClosingEvent event) {
    // The current implementation has a few bugs described below. However these are browser
    // bugs, and the workarounds we've experimented with gave worst results than the bug itself.
    //
    // Here are the current behaviours of different browsers after cancelling navigation
    // * Chrome
    //    - URL bar shows new website (FAIL)
    //    - Bookmarking uses the title of the webapp, but url of new website (FAIL)
    //    - Navigating away and then back goes back to the correct webapp page (WORKS)
    // * Firefox
    //    - URL bar shows new website (FAIL)
    //    - Bookmarking uses the title of the webapp, and url of webapp (WORKS)
    //    - Navigating away and then back goes back to the correct webapp page (WORKS)
    // * IE
    //    - Untested
    //
    // Options are to report that upstream in the browsers or to go back to our workarounds in a
    // browser-dependent fashion using deferred binding. The workarounds we've experimented with
    // consisted of adding a deferred command that used Window.Location.replace to reset the URL
    // to the current page. However, this caused infinite loops in some browsers.
    //
    // See this issue:
    //   http://code.google.com/p/gwt-platform/issues/detail?id=315

    event.setMessage(onLeaveQuestion);
  }
  /**
   * This method is used to register towards history.
   */
  void registerTowardsHistory() {
    History.addValueChangeHandler(this);
  }
  /**
   * This method is used to load the current place again.
   */
  @Override
  public void revealCurrentPlace() {
    History.fireCurrentHistoryState();
  }
  /**
   * This method is used to redirect default palce.
   */
  @Override
  public void revealErrorPlace(String invalidHistoryToken) {
    revealDefaultPlace();
  }
  /**
   * This method is used to redirect to passed  Palce request.
   */
  @Override
  public void revealPlace(final PlaceRequest request) {
    revealPlace(request, true);
  }
  /**
   *   Programmatically reveals the specified place.
   */
  @Override
  public void revealPlace(final PlaceRequest request, final boolean updateBrowserUrl) {
    if (locked) {
      defferedNavigation = new Command() {
        @Override
        public void execute() {
          revealPlace(request, updateBrowserUrl);
        }
      };
      return;
    }
    if (!getLock()) {
      return;
    }
    placeHierarchy.clear();
    placeHierarchy.add(request);
    doRevealPlace(request, updateBrowserUrl);
  }
  /**
   *   Programmatically reveals the specified hierarchy of places place, updating the browser URL in the process.
   */
  @Override
  public void revealPlaceHierarchy(
      final List<PlaceRequest> placeRequestHierarchy) {
    if (locked) {
      defferedNavigation = new Command() {
        @Override
        public void execute() {
          revealPlaceHierarchy(placeRequestHierarchy);
        }
      };
      return;
    }
    if (!getLock()) {
      return;
    }
    if (placeRequestHierarchy.size() == 0) {
      unlock();
      revealDefaultPlace();
    } else {
      placeHierarchy = placeRequestHierarchy;
      doRevealPlace(getCurrentPlaceRequest(), true);
    }
  }
	/**
	 *    Programmatically reveals the specified place from the current place hierarchy.
	 */
  @Override
  public void revealRelativePlace(final int level) {
    if (locked) {
      defferedNavigation = new Command() {
        @Override
        public void execute() {
          revealRelativePlace(level);
        }
      };
      return;
    }
    if (!getLock()) {
      return;
    }
    placeHierarchy = truncatePlaceHierarchy(level);
    int hierarchySize = placeHierarchy.size();
    if (hierarchySize == 0) {
      unlock();
      revealDefaultPlace();
    } else {
      PlaceRequest request = placeHierarchy.get(hierarchySize - 1);
      doRevealPlace(request, true);
    }
  }
  /**
   *    Programmatically reveals the specified place as a child of the current place hierarchy.
   */
  @Override
  public void revealRelativePlace(PlaceRequest request) {
    revealRelativePlace(request, 0);
  }
  /**
   *   Programmatically reveals the specified place relative to the other places in the current place hierarchy.
   */
  @Override
  public void revealRelativePlace(final PlaceRequest request, final int level) {
    if (locked) {
      defferedNavigation = new Command() {
        @Override
        public void execute() {
          revealRelativePlace(request, level);
        }
      };
      return;
    }
    if (!getLock()) {
      return;
    }
    placeHierarchy = truncatePlaceHierarchy(level);
    placeHierarchy.add(request);
    doRevealPlace(request, true);
  }
	/**
	 *     Reveals the place to display when a user has been refused the access to a specific place.
	 */
  @Override
  public void revealUnauthorizedPlace(String unauthorizedHistoryToken) {
    revealErrorPlace(unauthorizedHistoryToken);
  }

  /**
   * This method saves the history token, making it possible to correctly restore the browser's
   * URL if the user refuses to navigate. (See {@link #onWindowClosing(ClosingEvent)})
   *
   * @param historyToken The current history token, a string.
   */
  private void saveHistoryToken(String historyToken) {
    currentHistoryToken = historyToken;
  }
	/**
	 *This mehtod is used to set the Browset history tokens.
	 */
  void setBrowserHistoryToken(String historyToken, boolean issueEvent) {
    History.newItem(historyToken, issueEvent);
  }
  /**
   * Sets the question that will be displayed whenever the user tries to navigate away from the current page. 
   * Navigating away can happen either occur by changing the program state (the history token), by entering an external URL or by closing the window. 
   * All cases will be handled.
   */
  @Override
  public void setOnLeaveConfirmation(String question) {
    if (question == null && onLeaveQuestion == null) {
      return;
    }
    if (question != null && onLeaveQuestion == null) {
      windowClosingHandlerRegistration = Window.addWindowClosingHandler(this);
    }
    if (question == null && onLeaveQuestion != null) {
      windowClosingHandlerRegistration.removeHandler();
    }
    onLeaveQuestion = question;
  }

  /**
   * Start revealing an error or unauthorized page. This method will throw an
   * exception if an infinite loop is detected.
   *
   * @see #stopError()
   */
  private void startError() {
    if (this.internalError) {
      throw new RuntimeException(
          "Encountered repeated errors resulting in an infinite loop. Make sure all users have access "
              + "to the pages revealed by revealErrorPlace and revealUnauthorizedPlace. (Note that the default "
              + "implementations call revealDefaultPlace)");
    }
    internalError = true;
  }

  /**
   * Indicates that an error page has successfully been revealed. Makes it
   * possible to detect infinite loops.
   *
   * @see #startError()
   */
  private void stopError() {
    internalError = false;
  }
  /**
   *  Resets the navigation lock if it is currently set.
   */
  @Override
  public void unlock() {
    if (locked) {
      locked = false;
      LockInteractionEvent.fire(this, false);
      if (hasPendingNavigation()) {
        Command navigation = defferedNavigation;
        defferedNavigation = null;
        navigation.execute();
      }
    }
  }
  /**
   *  Updates History without firing a ValueChangeEvent.
   */
  @Override
  public void updateHistory(PlaceRequest request, boolean updateBrowserUrl) {
    try {
      // Make sure the request match
      assert request.hasSameNameToken(getCurrentPlaceRequest()) : "Internal error, PlaceRequest passed to updateHistory doesn't match the tail of the place hierarchy.";
      placeHierarchy.set(placeHierarchy.size() - 1, request);
      if (updateBrowserUrl) {
        String historyToken = tokenFormatter.toHistoryToken(placeHierarchy);
        String browserHistoryToken = getBrowserHistoryToken();
        if (browserHistoryToken == null
            || !browserHistoryToken.equals(historyToken)) {
          setBrowserHistoryToken(historyToken, false);
        }
        saveHistoryToken(historyToken);
      }
    } catch (TokenFormatException e) {
      // Do nothing.
    }
  }

  /**
   * Returns a modified copy of the place hierarchy based on the specified
   * {@code level}.
   *
   * @param level If negative, take back that many elements from the tail of the
   *          hierarchy. If positive, keep only that many elements from the head
   *          of the hierarchy. Passing {@code 0} leaves the hierarchy
   *          untouched.
   */
  private List<PlaceRequest> truncatePlaceHierarchy(int level) {
    int size = placeHierarchy.size();
    if (level < 0) {
      if (-level >= size) {
        return new ArrayList<PlaceRequest>();
      } else {
        return new ArrayList<PlaceRequest>(placeHierarchy.subList(0, size
            + level));
      }
    } else if (level > 0) {
      if (level >= size) {
        return new ArrayList<PlaceRequest>(placeHierarchy);
      } else {
        return new ArrayList<PlaceRequest>(placeHierarchy.subList(0, level));
      }
    }
    return new ArrayList<PlaceRequest>(placeHierarchy);
  }
  /*
   * This method is used to modify the name tokens.
   */
  public String modifyNameToken(String historyToken){
	  String unescapedHistoryToken = URL.decodeQueryString(historyToken);
	  if(unescapedHistoryToken.startsWith("!")){
		  unescapedHistoryToken=unescapedHistoryToken.substring(1);
	  }	  
	  return unescapedHistoryToken;
  }
}
