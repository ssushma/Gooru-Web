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
package org.ednovo.gooru.client.mvp.dashboard;

/**
 * @fileName : UserSettingsPresenter.java 
 *
 * @description : 
 *
 * @version :1.0
 *
 * @date: APR 18 2013

 * @Author Gooru Team 
 * 
 * Reviewer Gooru Team
 *
 */
import java.util.Date;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.service.UserServiceAsync;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.code.UserDashBoardCommonInfoDO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class UserDashBoardPresenter	extends	BasePlacePresenter<IsUserDashBoardView, UserDashBoardPresenter.IsUserDashBoardProxy>
		implements UserDashBoardUiHandlers {
	
	@Inject
	private UserServiceAsync userService;
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.DASHBOARD)
	public interface IsUserDashBoardProxy extends
			ProxyPlace<UserDashBoardPresenter> {

	}
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String DATE_FORMAT="yyyy-MM-dd";
	private static final String FLAGGED="item.flag";
	private static final String SHARED="item.share";
	private static final String ADDCOLLECTION="item.create";
	private static final String VIEWS="collection.resource.play,resource.play";
	private static final String EQ_OPERATOR="eq";
	private static final String IN_OPERATOR="in";
	
	@Inject
	public UserDashBoardPresenter(final IsUserDashBoardView view,
			final IsUserDashBoardProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
		Window.enableScrolling(true);
	}

	@Override
	public void onReveal() {
		Window.enableScrolling(true);
	}

	void displayDashBoardPage() {
		AppClientFactory.getInjector().getUserService().getUsersPublishedCollectionsCount(new AsyncCallback<UserDashBoardCommonInfoDO>() {
			@Override
			public void onSuccess(UserDashBoardCommonInfoDO result) {
				getView().setPublishedCollectionData(result);
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});
		getView().dispalyDashBoardHomePage();
	}

	@Override
	public void onBind() {
		super.onBind();
		Window.enableScrolling(true);
		displayDashBoardPage();
		setData();
	}
	public void setData(){
	    	DateTimeFormat fmt = DateTimeFormat.getFormat (DATE_FORMAT);
	    	String endDate = fmt.format(new Date());
	    	Date date = new Date();
	    	date.setMonth(date.getMonth()-12);
	    	String startDate =fmt.format(date);
	    	
		AppClientFactory.getInjector().getUserService().getTheAnalyticsFlaggedMonthlyData(FLAGGED,startDate,endDate,EQ_OPERATOR,new AsyncCallback<Map<String,Integer>>() {
				
				@Override
				public void onSuccess(Map<String, Integer> result) {
					getView().setProfileAnalyticsFlaggedChatData(result);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					
				}
			});
		AppClientFactory.getInjector().getUserService().getTheAnalyticsFlaggedMonthlyData(SHARED,startDate,endDate,EQ_OPERATOR,new AsyncCallback<Map<String,Integer>>() {
			
			@Override
			public void onSuccess(Map<String, Integer> result) {
				getView().setProfileAnalyticsSharedChatData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
		AppClientFactory.getInjector().getUserService().getTheAnalyticsFlaggedMonthlyData(ADDCOLLECTION,startDate,endDate,EQ_OPERATOR,new AsyncCallback<Map<String,Integer>>() {
			
			@Override
			public void onSuccess(Map<String, Integer> result) {
				getView().setProfileAnalyticsAddedCollectionChatData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
		AppClientFactory.getInjector().getUserService().getTheAnalyticsFlaggedMonthlyData(VIEWS,startDate,endDate,IN_OPERATOR,new AsyncCallback<Map<String,Integer>>() {
			
			@Override
			public void onSuccess(Map<String, Integer> result) {
				getView().setProfileAnalyticsViewsChatData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	}
	@Override
	protected void onHide() {
		super.onHide();
	}
	@Override
	public String getViewToken() {
		return null;
	}

	public UserServiceAsync getUserService() {
		return userService;
	}

	public void setUserService(UserServiceAsync userService) {
		this.userService = userService;
	}
}