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
package org.ednovo.gooru.client.mvp.shelf.list;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.mvp.shelf.FolderStyleBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class NoResourceInShelfListView extends Composite {

	

	interface NoResourceInShelfListViewUiBinder extends UiBinder<Widget, NoResourceInShelfListView> {
	}
	private static NoResourceInShelfListViewUiBinder uiBinder = GWT.create(NoResourceInShelfListViewUiBinder.class);
	
	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String  infoMsg_1 =i18n.GL0982();
	private static final String  infoMsg_2 =i18n.GL0983();
	
	private static final String  congratsMsg_1 = i18n.GL0984();
	private static final String  congratsMsg_2 = i18n.GL0985();
	private final String CONGRATS_MSG = i18n.GL0483().toLowerCase();
	private final String INFO_MSG = i18n.GL0986();
	private final String MSG_NO_IMG = i18n.GL0987();
	private final String CONGRATS_NO_IMG = i18n.GL0988();
	
	@UiField
	Label userInfoMsg_1,userInfoMsg_2,emptyCollMsg_1,emptyCollMsg_2;
	
	@UiField
	SimplePanel resourceUgArrowImg,resourceImageOneImg,resourceImageTwoImg,resourceImageThreeImg;
	
	@UiField FolderStyleBundle folderStyle;
	
	String msgInfo=null;

	/**
	 * Class constructor
	 * @param msg 
	 */
	public NoResourceInShelfListView(String msg) { 
		initWidget(uiBinder.createAndBindUi(this));
		this.msgInfo=msg;
		resourceUgArrowImg.getElement().setId("spnlResourceUgArrowImg");
		emptyCollMsg_1.getElement().setId("lblEmptyCollMsg_1");
		emptyCollMsg_2.getElement().setId("lblEmptyCollMsg_2");	
		resourceImageOneImg.getElement().setId("spnlResourceImageOneImg");
		resourceImageTwoImg.getElement().setId("spnlResourceImageTwoImg");
		resourceImageThreeImg.getElement().setId("spnlResourceImageThreeImg");
		userInfoMsg_1.getElement().setId("lblUserInfoMsg_1");
		userInfoMsg_2.getElement().setId("lblUserInfoMsg_2");
		
		resourceImageOneImg.getElement().getStyle().setDisplay(Display.NONE);
		resourceImageTwoImg.getElement().getStyle().setDisplay(Display.NONE);
		resourceImageThreeImg.getElement().getStyle().setDisplay(Display.NONE);
		
		displayUserInfoMsg(msgInfo);
		
	}
	
	
	public void displayUserInfoMsg(String msg){
		if(msg.equals(INFO_MSG)){
			emptyCollMsg_1.getElement().getStyle().setDisplay(Display.NONE);
			emptyCollMsg_2.getElement().getStyle().setDisplay(Display.NONE);
			userInfoMsg_1.setText(infoMsg_1);
			userInfoMsg_1.getElement().setAttribute("alt", infoMsg_1);
			userInfoMsg_1.getElement().setAttribute("title", infoMsg_1);

			userInfoMsg_2.setText(infoMsg_2);
			userInfoMsg_2.getElement().setAttribute("alt", infoMsg_2);
			userInfoMsg_2.getElement().setAttribute("title", infoMsg_2);
		}
		else if(msg.equals(CONGRATS_MSG)){ 
			emptyCollMsg_1.getElement().getStyle().setDisplay(Display.NONE);
			emptyCollMsg_2.getElement().getStyle().setDisplay(Display.NONE);
			resourceUgArrowImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			resourceImageOneImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			resourceImageTwoImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			resourceImageThreeImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			userInfoMsg_1.setText(congratsMsg_1);
			userInfoMsg_1.getElement().setAttribute("alt", congratsMsg_1);
			userInfoMsg_1.getElement().setAttribute("title", congratsMsg_1);
			userInfoMsg_2.setText(congratsMsg_2);
			userInfoMsg_2.getElement().setAttribute("alt", congratsMsg_2);
			userInfoMsg_2.getElement().setAttribute("title", congratsMsg_2);
			new FadeInAndOut(userInfoMsg_1.getElement(), 5000);
			new FadeInAndOut(userInfoMsg_2.getElement(), 5000);
			Timer shelfUserInfoMsg=new Timer(){
				public void run() {
					/*resourceUgArrowImg.getElement().getStyle().setVisibility(Visibility.VISIBLE);
					resourceImageOneImg.getElement().getStyle().setVisibility(Visibility.VISIBLE);
					resourceImageTwoImg.getElement().getStyle().setVisibility(Visibility.VISIBLE);
					resourceImageThreeImg.getElement().getStyle().setVisibility(Visibility.VISIBLE);*/
					
				}
			};
			shelfUserInfoMsg.schedule(5000);
			
			
		}
		else if(msg.equals(MSG_NO_IMG)){
			emptyCollMsg_1.getElement().getStyle().setDisplay(Display.NONE);
			emptyCollMsg_2.getElement().getStyle().setDisplay(Display.NONE);
			resourceUgArrowImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			resourceImageOneImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			resourceImageTwoImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			resourceImageThreeImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			userInfoMsg_1.setText(infoMsg_1);
			userInfoMsg_1.getElement().setAttribute("alt", infoMsg_1);
			userInfoMsg_1.getElement().setAttribute("title", infoMsg_1);
			userInfoMsg_2.setText(infoMsg_2);
			userInfoMsg_2.getElement().setAttribute("alt", infoMsg_2);
			userInfoMsg_2.getElement().setAttribute("title", infoMsg_2);
			
		}else if(msg.equals(CONGRATS_NO_IMG)){
			emptyCollMsg_1.getElement().getStyle().setDisplay(Display.NONE);
			emptyCollMsg_2.getElement().getStyle().setDisplay(Display.NONE);
			resourceUgArrowImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			resourceImageOneImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			resourceImageTwoImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			resourceImageThreeImg.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			userInfoMsg_1.setText(congratsMsg_1);
			userInfoMsg_1.getElement().setAttribute("alt", congratsMsg_1);
			userInfoMsg_1.getElement().setAttribute("title", congratsMsg_1);
			userInfoMsg_2.setText(congratsMsg_2);
			userInfoMsg_2.getElement().setAttribute("alt", congratsMsg_2);
			userInfoMsg_2.getElement().setAttribute("title", congratsMsg_2);
			new FadeInAndOut(userInfoMsg_1.getElement(), 5000);
			new FadeInAndOut(userInfoMsg_2.getElement(), 5000);
			Timer shelfUserInfoMsg=new Timer(){
				public void run() {
					userInfoMsg_1.setText(infoMsg_1);
					userInfoMsg_1.getElement().setAttribute("alt", infoMsg_1);
					userInfoMsg_1.getElement().setAttribute("title", infoMsg_1);
					userInfoMsg_2.setText(infoMsg_2);
					userInfoMsg_2.getElement().setAttribute("alt", infoMsg_2);
					userInfoMsg_2.getElement().setAttribute("title", infoMsg_2);
					userInfoMsg_1.getElement().getStyle().setOpacity(1.0);
					userInfoMsg_2.getElement().getStyle().setOpacity(1.0);
				}
			};
			shelfUserInfoMsg.schedule(5000);
			
		}else{
			emptyCollMsg_1.setText(i18n.GL1056());
			emptyCollMsg_1.getElement().setAttribute("alt", i18n.GL1056());
			emptyCollMsg_1.getElement().setAttribute("title", i18n.GL1056());

			emptyCollMsg_2.setText(" "+i18n.GL1057());
			emptyCollMsg_2.getElement().setAttribute("alt", i18n.GL1057());
			emptyCollMsg_2.getElement().setAttribute("title", i18n.GL1057());
		}
		
		
	}

}
