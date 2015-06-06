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
package org.ednovo.gooru.client.mvp.home;

import org.ednovo.gooru.application.client.home.HomeCBundle;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class FeaturedContentVc extends Composite implements MouseOverHandler, MouseOutHandler{

	private static FeaturedContentVcUiBinder uiBinder = GWT.create(FeaturedContentVcUiBinder.class);

	private final int slideMaxHeight = 220;

	interface FeaturedContentVcUiBinder extends UiBinder<Widget, FeaturedContentVc> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField
	FlowPanel featuredSlideFloPanel;

	@UiField
	FlowPanel featuredContentTitleFloPanel;

	@UiField(provided = true)
	HomeCBundle res;


	 public static Timer elapsedTimer;
	 private int countOfChild=0;

	 @UiField Label featuredLbl;

	/**
	 * Class Constructor
	 */
	public FeaturedContentVc() {
		this.res = HomeCBundle.INSTANCE;
		res.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		featuredLbl.setText(i18n.GL1240());
		featuredLbl.getElement().setId("lblFeatured");
		featuredLbl.getElement().setAttribute("alt",i18n.GL1240());
		featuredLbl.getElement().setAttribute("title",i18n.GL1240());
		featuredContentTitleFloPanel.getElement().setId("fpnlFeaturedContentTitleFloPanel");
		featuredSlideFloPanel.getElement().setId("fpnlFeaturedSlideFloPanel");
		 elapsedTimer = new Timer () {
		      public void run() {
		    	  if(countOfChild>3){
		  			countOfChild=0;
		  		}
		        showElapsed(countOfChild);
		        countOfChild++;
		      }

		    };


		    // Schedule the timer for every 1/2 second (500 milliseconds)
		    elapsedTimer.scheduleRepeating(500*6);

	}

	/**
	 * Set featured collection in home page
	 * @param featuredContents instance of {@link FeaturedContentDo}
	 */
	/*public void renderFeatureContent(List<FeaturedContentDo> featuredContents) {
		featuredSlideFloPanel.clear();
		featuredContentTitleFloPanel.clear();
		int sequence = 0;

		for (FeaturedContentDo featuredContentDo : featuredContents) {
			HTMLPanel featuredContectContainer=new HTMLPanel("");
			final Anchor featuredContentTitle= new Anchor();
			final HTMLPanel landingPagesliderArrow=new HTMLPanel("");
			landingPagesliderArrow.setStyleName(res.css().landingPagesliderArrow());

			Label landingPageSliderArrowBackground=new Label();
			landingPageSliderArrowBackground.setStyleName(res.css().landingPageSliderArrowBackground());

			Label landingPageSliderArrowSpan=new Label();
			landingPageSliderArrowSpan.setStyleName(res.css().landingPageSliderArrowSpan());
			landingPagesliderArrow.add(landingPageSliderArrowBackground);
			landingPagesliderArrow.add(landingPageSliderArrowSpan);
			featuredContentTitle.setHTML("<div>" + featuredContentDo.getContentTitle() + "</div>");
			featuredContentTitle.getElement().setAttribute("slideIndex", (sequence++) + "");
			landingPagesliderArrow.getElement().getStyle().setDisplay(Display.NONE);
			featuredContentTitle.addMouseOverHandler(new MouseOverHandler() {
				@Override

				public void onMouseOver(MouseOverEvent event) {
					int countOfChild=featuredContentTitleFloPanel.getElement().getChildCount();
			         for(int i=0;i<countOfChild;i++)
			         {
			        	 ((Element)featuredContentTitleFloPanel.getElement().getChild(i).getFirstChild()).getStyle().setBackgroundColor("#999999");
			        	 ((Element)featuredContentTitleFloPanel.getElement().getChild(i).getLastChild()).getStyle().setDisplay(Display.NONE);
			         }

					landingPagesliderArrow.getElement().getStyle().setDisplay(Display.BLOCK);
					elapsedTimer.cancel();
					String scrollTop = (Integer.parseInt(featuredContentTitle.getElement().getAttribute("slideIndex")) * slideMaxHeight) + "";
					featuredSlideFloPanel.getElement().setAttribute("style", "margin-top:-" + scrollTop + "px");
				}

			});
			featuredContentTitle.addMouseOutHandler(new MouseOutHandler() {


				@Override
				public void onMouseOut(MouseOutEvent event) {
					int countOfChild=featuredContentTitleFloPanel.getElement().getChildCount();
			         for(int i=0;i<countOfChild;i++)
			         {
			        	 ((Element)featuredContentTitleFloPanel.getElement().getChild(i).getFirstChild()).getStyle().setBackgroundColor("#999999");
			        	 ((Element)featuredContentTitleFloPanel.getElement().getChild(i).getLastChild()).getStyle().setDisplay(Display.NONE);
			         }
					elapsedTimer.scheduleRepeating(500*6);
					countOfChild=(Integer.parseInt(featuredContentTitle.getElement().getAttribute("slideIndex")));
					showElapsed(countOfChild);
					landingPagesliderArrow.getElement().getStyle().setDisplay(Display.BLOCK);
				}
			});
			featuredContectContainer.add(featuredContentTitle);
			featuredContectContainer.add(landingPagesliderArrow);
			featuredContentTitleFloPanel.add(featuredContectContainer);
			featuredSlideFloPanel.add(new FeaturedSlideVc(featuredContentDo));
		}

	}
*/
	/**
	   * Show the current elapsed time in the elapsedLabel widget.
	   */
	  private void showElapsed (int countOfChild1) {

		  	int countOfChild=featuredContentTitleFloPanel.getElement().getChildCount();
	         for(int i=0;i<countOfChild;i++)
	         {
	        	 ((Element)featuredContentTitleFloPanel.getElement().getChild(i).getFirstChild()).getStyle().setBackgroundColor("#999999");
	        	 ((Element)featuredContentTitleFloPanel.getElement().getChild(i).getLastChild()).getStyle().setDisplay(Display.NONE);
	         }
			 String scrollTop = (Integer.parseInt(((Element)featuredContentTitleFloPanel.getElement().getChild(countOfChild1).getFirstChild()).getAttribute("slideIndex")) * slideMaxHeight) + "";
			 ((Element)featuredContentTitleFloPanel.getElement().getChild(countOfChild1).getFirstChild()).getStyle().setBackgroundColor("#515151");
			 ((Element)featuredContentTitleFloPanel.getElement().getChild(countOfChild1).getLastChild()).getStyle().setDisplay(Display.BLOCK);
			 featuredSlideFloPanel.getElement().setAttribute("style", "margin-top:-" + scrollTop + "px");


			 /*String scrollTop = (Integer.parseInt(featuredContentTitle.getElement().getAttribute("slideIndex")) * slideMaxHeight) + "";
		featuredSlideFloPanel.getElement().setAttribute("style", "margin-top:-" + scrollTop + "px");
	  */ }
	@Override
	public void onMouseOut(MouseOutEvent event) {

	}

	@Override
	public void onMouseOver(MouseOverEvent event) {


	}

}
