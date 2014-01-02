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
package org.ednovo.gooru.client.mvp.play.collection.header;



import org.ednovo.gooru.client.uc.PlayerBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CollectionPlayerHeaderView extends Composite{
	
	@UiField HTML resourceTitle;
	
	@UiField Button infoButton,shareButton,narrationButton,navigationButton,addButton;
	
	@UiField Label closeButtonForCollection,thumbsDownButton,thumbsUpButton;
	
	
	private boolean isInfoButtonEnabled=false;
	private boolean isShareButtonEnabled=false;
	private boolean isNarrationButtonEnabled=false;
	private boolean isNavigationButtonEnabled=false;
	private boolean isAddButtonEnabled=false;
	
	private static CollectionPlayerHeaderViewUiBinder uiBinder = GWT.create(CollectionPlayerHeaderViewUiBinder.class);

	interface CollectionPlayerHeaderViewUiBinder extends UiBinder<Widget, CollectionPlayerHeaderView> {
	}
	
	public CollectionPlayerHeaderView(){
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
	}

	public void setResourceTitle(String title){
		resourceTitle.setHTML(title);
	}

	public Button getInfoButton() {
		return infoButton;
	}

	public Button getShareButton() {
		return shareButton;
	}

	public Button getNarrationButton() {
		return narrationButton;
	}

	public Button getNavigationButton() {
		return navigationButton;
	}
	public Button getAddButton() {
		return addButton;
	}
	
	public Label getThumbsDownButton(){
		return thumbsDownButton;
	}
	
	public Label getThumbsUpButton(){
		return thumbsUpButton;
	}
	
	public void makeButtonActive(boolean makeAddButtonActive,boolean makeInfoButtionActive, boolean  makeShareButtonActive, boolean makeNarrationButtonActive, boolean makeNavigationButtonActive){
		if(makeAddButtonActive){
			makeAddButtonActive();
		}
		else if(makeInfoButtionActive){
			makeInfoButtonActive();
		}else if(makeShareButtonActive){
			makeShareButtonActive();
		}else if(makeNarrationButtonActive){
			makeNarrationButtonActive();
		}else if(makeNavigationButtonActive){
			makeNavigationButtonActive();
		}
	}
	public void enableButtons(boolean isAddButtonEnable,boolean isInfoButtonEnable, boolean isShareButtonEnable, boolean isNarrationButtonEnable, boolean isNavigationButtonEnable){
		enableAddButton(isAddButtonEnable);
		enableInfoButton(isInfoButtonEnable);
		enableShareButton(isShareButtonEnable);
		enableNarrationButton(isNarrationButtonEnable);
		enableNavigationButton(isNavigationButtonEnable);
	}

	public void enableAddButton(boolean isAddButtonEnable){
		setAddButtonEnabled(isAddButtonEnable);
		getAddButton().getElement().removeAttribute("button");
		if(isAddButtonEnable){
			getAddButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonDisabled());
			getAddButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonActive());
			getAddButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonNormal());
		}else{
			getAddButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonActive());
			getAddButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonNormal());
			getAddButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonDisabled());
		}		
	}
	
	public void enableInfoButton(boolean isInfoButtonEnable){
		setInfoButtonEnabled(isInfoButtonEnable);
		getInfoButton().getElement().removeAttribute("button");
		if(isInfoButtonEnable){
			getInfoButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonDisabled());
			getInfoButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonActive());
			getInfoButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonNormal());
		}else{
			getInfoButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonActive());
			getInfoButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonNormal());
			getInfoButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonDisabled());
		}		
	}
	public void enableShareButton(boolean isShareButtonEnable){
		setShareButtonEnabled(isShareButtonEnable);
		getShareButton().getElement().removeAttribute("button");
		if(isShareButtonEnable){
			getShareButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonDisabled());
			getShareButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonActive());
			getShareButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonNormal());
		}else{
			getShareButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonActive());
			getShareButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonNormal());
			getShareButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonDisabled());
		}		
	}
	public void enableNarrationButton(boolean isNarrationButtonEnable){
		setNarrationButtonEnabled(isNarrationButtonEnable);
		getNarrationButton().getElement().removeAttribute("button");
		if(isNarrationButtonEnable){
			getNarrationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonDisabled());
			getNarrationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonActive());
			getNarrationButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonNormal());
		}else{
			getNarrationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonActive());
			getNarrationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonNormal());
			getNarrationButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonDisabled());
		}		
	}
	
	public void enableNavigationButton(boolean isNavigationButtonEnable){
		setNavigationButtonEnabled(isNavigationButtonEnable);
		getNavigationButton().getElement().removeAttribute("button");
		if(isNavigationButtonEnable){
			getNavigationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonDisabled());
			getNavigationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonActive());
			getNavigationButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonNormal());
		}else{
			getNavigationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonActive());
			getNavigationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonNormal());
			getNavigationButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonDisabled());
		}		
	}
	
	public void makeAddButtonActive(){
		String button=getAddButton().getElement().getAttribute("button");
		if(button!=null&&button.equalsIgnoreCase("active")){
			getAddButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonActive());
			getAddButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonNormal());
			getAddButton().getElement().removeAttribute("button");
		}else{
			getAddButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonNormal());
			getAddButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonActive());
			getAddButton().getElement().setAttribute("button","active");
		}	
	}
	
	public void makeInfoButtonActive(){
		String button=getInfoButton().getElement().getAttribute("button");
		if(button!=null&&button.equalsIgnoreCase("active")){
			getInfoButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonActive());
			getInfoButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonNormal());
			getInfoButton().getElement().removeAttribute("button");
		}else{
			getInfoButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonNormal());
			getInfoButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonActive());
			getInfoButton().getElement().setAttribute("button","active");
		}	
	}
	public void makeShareButtonActive(){
		String button=getShareButton().getElement().getAttribute("button");
		if(button!=null&&button.equalsIgnoreCase("active")){
			getShareButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonActive());
			getShareButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonNormal());
			getShareButton().getElement().removeAttribute("button");
		}else{
			getShareButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonNormal());
			getShareButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonActive());
			getShareButton().getElement().setAttribute("button","active");
		}	
	}
	public void makeNarrationButtonActive(){
		String button=getNarrationButton().getElement().getAttribute("button");
		if(button!=null&&button.equalsIgnoreCase("active")){
			getNarrationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonActive());
			getNarrationButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonNormal());
			getNarrationButton().getElement().removeAttribute("button");
		}else{
			getNarrationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonNormal());
			getNarrationButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonActive());
			getNarrationButton().getElement().setAttribute("button","active");
		}	
	}
	public void makeNavigationButtonActive(){
		String button=getNavigationButton().getElement().getAttribute("button");
		if(button!=null&&button.equalsIgnoreCase("active")){
			getNavigationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonActive());
			getNavigationButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonNormal());
			getNavigationButton().getElement().removeAttribute("button");
		}else{
			getNavigationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonNormal());
			getNavigationButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonActive());
			getNavigationButton().getElement().setAttribute("button","active");
		}	
	}
	
	public void clearActiveButton(boolean deselectAddButton,boolean deselectInfoButton,boolean deselectShareButtion,boolean deselectNarrationButton,boolean deselectNavigationButton){
		if(deselectAddButton){
			deselectAddButton();
		}
		if(deselectInfoButton){
			deselectInfoButton();
		}
		if(deselectShareButtion){
			deselectShareButton();
		}
		if(deselectNarrationButton){
			deselectNarrationButton();
		}
		if(deselectNavigationButton){
			deselectNavigationButton();
		}
		
	}
	public void deselectAddButton(){
		String button=getAddButton().getElement().getAttribute("button");
		if(button!=null&&button.equalsIgnoreCase("active")&&isAddButtonEnabled()){
			getAddButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonActive());
			getAddButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().addButtonNormal());
			getAddButton().getElement().removeAttribute("button");
		}
	}
	
	public void deselectInfoButton(){
		String button=getInfoButton().getElement().getAttribute("button");
		if(button!=null&&button.equalsIgnoreCase("active")&&isInfoButtonEnabled()){
			getInfoButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonActive());
			getInfoButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().infoButtonNormal());
			getInfoButton().getElement().removeAttribute("button");
		}
	}
	public void deselectShareButton(){
		String shareButtonVal=getShareButton().getElement().getAttribute("button");
		if(shareButtonVal!=null&&shareButtonVal.equalsIgnoreCase("active")&&isShareButtonEnabled()){
			getShareButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonActive());
			getShareButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().shareButtonNormal());
			getShareButton().getElement().removeAttribute("button");
		}
	}
	public void deselectNarrationButton(){
		String narrtionButtonVal=getNarrationButton().getElement().getAttribute("button");
		if(narrtionButtonVal!=null&&narrtionButtonVal.equalsIgnoreCase("active")&&isNarrationButtonEnabled){
			getNarrationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonActive());
			getNarrationButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().narrationButtonNormal());
			getNarrationButton().getElement().removeAttribute("button");
		}
	}
	public void deselectNavigationButton(){
		String navigationButtonVal=getNavigationButton().getElement().getAttribute("button");
		if(navigationButtonVal!=null&&navigationButtonVal.equalsIgnoreCase("active")&&isNavigationButtonEnabled()){
			getNavigationButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonActive());
			getNavigationButton().addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().navigationButtonNormal());
			getNavigationButton().getElement().removeAttribute("button");
		}
	}
	public boolean isInfoButtonEnabled() {
		return isInfoButtonEnabled;
	}
	public void setInfoButtonEnabled(boolean isInfoButtonEnabled) {
		this.isInfoButtonEnabled = isInfoButtonEnabled;
	}

	public boolean isShareButtonEnabled() {
		return isShareButtonEnabled;
	}

	public void setShareButtonEnabled(boolean isShareButtonEnabled) {
		this.isShareButtonEnabled = isShareButtonEnabled;
	}

	public boolean isNarrationButtonEnabled() {
		return isNarrationButtonEnabled;
	}

	public void setNarrationButtonEnabled(boolean isNarrationButtonEnabled) {
		this.isNarrationButtonEnabled = isNarrationButtonEnabled;
	}

	public boolean isNavigationButtonEnabled() {
		return isNavigationButtonEnabled;
	}

	public void setNavigationButtonEnabled(boolean isNavigationButtonEnabled) {
		this.isNavigationButtonEnabled = isNavigationButtonEnabled;
	}
	
	public Label getCloseButton(){
		return closeButtonForCollection;
	}
	public boolean isAddButtonEnabled() {
		return isAddButtonEnabled;
	}

	public void setAddButtonEnabled(boolean isAddButtonEnabled) {
		this.isAddButtonEnabled = isAddButtonEnabled;
	}
}
