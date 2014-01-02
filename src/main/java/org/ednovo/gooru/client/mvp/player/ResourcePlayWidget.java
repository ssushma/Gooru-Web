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
package org.ednovo.gooru.client.mvp.player;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;
import org.ednovo.gooru.player.resource.client.view.resourceplayer.GooruResourcePlayerImpl;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class ResourcePlayWidget extends GooruResourcePlayerImpl{
	public ResourcePlayWidget(){
		super.getAddResourceButton().addClickHandler(new onAddResourceButton());
		super.getLikeButton().addClickHandler(new onLikeLabel());
		super.getDislikeButton().addClickHandler(new onDislikeLabel());
		super.getFrameBreakFlagreResourceButton().addClickHandler(new onFrameBreakFlagreResourceButton());
	}
	private class onAddResourceButton implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(AppClientFactory.isAnonymous()){
				/*LoginPopupInPlay popup = new LoginPopupInPlay();
				popup.setGlassEnabled(true);
				popup.show();
				popup.center();*/
				LoginPopupUc popup =new LoginPopupUc();
				popup.setMixPanelEvent("resourceadd");
				popup.setGlassEnabled(true);
				/*popup.show();
				popup.center();*/
				
			}else{
				showAddResourceToCollectionWidget();
			}
		}
	}
	private class onLikeLabel implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(AppClientFactory.isAnonymous()){
				/*LoginPopupInPlay popup = new LoginPopupInPlay();
				popup.setGlassEnabled(true);
				popup.show();
				popup.center();*/
				LoginPopupUc popup =new LoginPopupUc();
				popup.setGlassEnabled(true);
				/*popup.show();
				popup.center();*/
			}else{
				clickOnThumbsupOnResourcePlay(event);
		 
			}
		}
		
		 
	}
	private class onFrameBreakFlagreResourceButton implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(AppClientFactory.isAnonymous()){
				/*LoginPopupInPlay popup = new LoginPopupInPlay();
				popup.setGlassEnabled(true);
				popup.show();
				popup.center();*/
				LoginPopupUc popup =new LoginPopupUc();
				popup.setGlassEnabled(true);
				/*popup.show();
				popup.center();*/
			}else{
				showFrameBreakFlagResourceWidget();
		 
			}
		}
		
		 
	}
	private class onDislikeLabel implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(AppClientFactory.isAnonymous()){
				/*LoginPopupInPlay popup = new LoginPopupInPlay();
				popup.setGlassEnabled(true);
				popup.show();
				popup.center();*/
				LoginPopupUc popup =new LoginPopupUc();
				popup.setGlassEnabled(true);
			/*	popup.show();
				popup.center();*/
			}else{			
				clickOnThumbsDownOnResourcePlay(event);	 
			}
		}
	}


	public void showAddResourceToCollectionWidget(){
		super.showAddResourceToCollectionWidget();
	}
	public void showFrameBreakFlagResourceWidget(){
		super.showFrameBreakFlagResourceWidget();
	}

	private void clickOnThumbsDownOnResourcePlay(ClickEvent event){
		 super.clickOnThumbsDown(event);
	}
	
	private void clickOnThumbsupOnResourcePlay(ClickEvent event){
		 super.clickOnThumbsUp(event);
	}
 
	
}

