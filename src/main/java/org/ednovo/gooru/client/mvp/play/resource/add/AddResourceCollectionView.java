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
package org.ednovo.gooru.client.mvp.play.resource.add;

import java.util.ArrayList;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.settings.CustomAnimation;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionItemsList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class AddResourceCollectionView extends BaseViewWithHandlers<AddResourceCollectionUiHandlers> implements IsAddResourceCollectionView{


	private static ResourceShareViewUiBinder uiBinder = GWT.create(ResourceShareViewUiBinder.class);

	interface ResourceShareViewUiBinder extends UiBinder<Widget, AddResourceCollectionView> {

	}
		
	@Inject
	public AddResourceCollectionView(){
		setWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		dropdownListContainerScrollPanel.getElement().getStyle().setDisplay(Display.NONE);
		dropdownListPlaceHolder.addClickHandler(new OnDropdownListPlaceHolderClick());
		dropdownListContainerScrollPanel.addScrollHandler(new ScrollDropdownListContainer());
		getAddResourceToCollectionButton().addClickHandler(new OnAddResourceButtonClick());
		resourceAddedSuccessMessageContainer.setVisible(false);
	}
	@UiField HTMLPanel dropdownListContainer,resourceImageContainerInAddResource,addCollectionInsteadLabelContainer,addCollectionContainer;
	@UiField InlineLabel dropdownListPlaceHolder;
	@UiField ScrollPanel dropdownListContainerScrollPanel;
	@UiField Image resourceImageWidget;
	@UiField Button addResourceToCollectionButton;
	@UiField Label addingLabel,successMessageAddedCollection,resourceTypeSmallImage,addToExistingColl,errorMessage,
					sizeMessage,successMessageLabelText,addCollectionInsteadLabelText,createCollectionButton;
	@UiField FlowPanel resourceAddedSuccessMessageContainer;
	@UiField Anchor workSpaceLink;
	@UiField Label addButtonHideLbl;
	
	private String collectionItemId=null;
	
	private CollectionItemDo collectionItemDo;
	
	private boolean isAllUserShelfCollectionsLoaded=false;
	
	
	public Label getResourceTypeSmallImage() {
		return resourceTypeSmallImage;
	}

	public void setResourceTypeSmallImage(Label resourceTypeSmallImage) {
		this.resourceTypeSmallImage = resourceTypeSmallImage;
	}

	public Label getAddingLabel() {
		return addingLabel;
	}

	public void setAddingLabel(Label addingLabel) {
		this.addingLabel = addingLabel;
	}

	public HTMLPanel getDropdownListContainer() {
		return dropdownListContainer;
	}

	public void setDropdownListContainer(HTMLPanel dropdownListContainer) {
		this.dropdownListContainer = dropdownListContainer;
	}
	public InlineLabel getDropdownListPlaceHolder() {
		return dropdownListPlaceHolder;
	}

	public void setDropdownListPlaceHolder(InlineLabel dropdownListPlaceHolder) {
		this.dropdownListPlaceHolder = dropdownListPlaceHolder;
	}

	public Button getAddResourceToCollectionButton() {
		return addResourceToCollectionButton;
	}

	public void setAddResourceToCollectionButton(
			Button addResourceToCollectionButton) {
		this.addResourceToCollectionButton = addResourceToCollectionButton;
	}

	public ScrollPanel getDropdownListContainerScrollPanel() {
		return dropdownListContainerScrollPanel;
	}
	
	public void displaySuccessLabel(){
		successMessageAddedCollection.getElement().getStyle().setDisplay(Display.BLOCK);
	}
	
	public void hideSuccessLabel(){
		successMessageAddedCollection.getElement().getStyle().clearDisplay();
	}

	public void setDropdownListContainerScrollPanel(
			ScrollPanel dropdownListContainerScrollPanel) {
		this.dropdownListContainerScrollPanel = dropdownListContainerScrollPanel;
	}


	public void addDropDownListItem(String collectionName,String collectionId,int collectionItemsSize){
		Label dropDownListItem=new Label(collectionName);
		dropDownListItem.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().dropdownListItemContainer());
		dropdownListContainer.add(dropDownListItem);
		dropDownListItem.addClickHandler(new OnDropdownItemClick(collectionName,collectionId,collectionItemsSize));
	}
	
	public Image getResourceImageWidget() {
		return resourceImageWidget;
	}

	public void setResourceImageWidget(Image resourceImageWidget) {
		this.resourceImageWidget = resourceImageWidget;
	}
	public Label getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(Label errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Label getSizeMessage() {
		return sizeMessage;
	}
	
	
	public void getUserShelfCollections(int dropdownListContainertWidgetCount){
		if(!isAllUserShelfCollectionsLoaded){
			getUiHandlers().getUserShelfCollections(dropdownListContainertWidgetCount);
		}
	}
	

	/** 
	 * This method is to get the addToExistingColl
	 */
	public Label getAddCollectionViewButton() {
		return addToExistingColl;
	}

	/** 
	 * This method is to set the addToExistingColl
	 */
	public void setAddToExistingColl(Label addToExistingColl) {
		this.addToExistingColl = addToExistingColl;
	}


	private class OnDropdownListPlaceHolderClick implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			new CustomAnimation(dropdownListContainerScrollPanel).run(300);
		}
	}
	private class OnDropdownItemClick implements ClickHandler{
		private String collectionName="";
		private String collectionId="";
		private int collectionItemsSize;
		public OnDropdownItemClick(String collectionName,String collectionId,int collectionItemsSize){
			this.collectionName=collectionName;
			this.collectionId=collectionId;
			this.collectionItemsSize=collectionItemsSize;
		}
		@Override
		public void onClick(ClickEvent event) {
			dropdownListPlaceHolder.setText(collectionName);
			dropdownListPlaceHolder.getElement().setAttribute("id", collectionId);
			dropdownListPlaceHolder.getElement().setAttribute("itemsSize", ""+collectionItemsSize);
			new CustomAnimation(dropdownListContainerScrollPanel).run(300);
		}
	}
	
	private class ScrollDropdownListContainer implements ScrollHandler{
		@Override
		public void onScroll(ScrollEvent event) {
			if (dropdownListContainerScrollPanel.getVerticalScrollPosition() == dropdownListContainerScrollPanel.getMaximumVerticalScrollPosition()){
					getUserShelfCollections(dropdownListContainer.getWidgetCount());
				}
			}
	}

	public HTMLPanel getResourceImageContainerInAddResource() {
		return resourceImageContainerInAddResource;
	}

	public void setResourceImageContainerInAddResource(
			HTMLPanel resourceImageContainerInAddResource) {
		this.resourceImageContainerInAddResource = resourceImageContainerInAddResource;
	}

	public Label getAddButtonHideLbl() {
		return addButtonHideLbl;
	}

	public HTMLPanel getAddCollectionInsteadLabelContainer() {
		return addCollectionInsteadLabelContainer;
	}

	public void setAddCollectionInsteadLabelContainer(
			HTMLPanel addCollectionInsteadLabelContainer) {
		this.addCollectionInsteadLabelContainer = addCollectionInsteadLabelContainer;
	}

	public Label getSuccessMessageLabelText() {
		return successMessageLabelText;
	}

	public void setSuccessMessageLabelText(Label successMessageLabelText) {
		this.successMessageLabelText = successMessageLabelText;
	}

	public FlowPanel getResourceAddedSuccessMessageContainer() {
		return resourceAddedSuccessMessageContainer;
	}

	public void setResourceAddedSuccessMessageContainer(
			FlowPanel resourceAddedSuccessMessageContainer) {
		this.resourceAddedSuccessMessageContainer = resourceAddedSuccessMessageContainer;
	}

	public Anchor getWorkSpaceLink() {
		return workSpaceLink;
	}

	public void setWorkSpaceLink(Anchor workSpaceLink) {
		this.workSpaceLink = workSpaceLink;
	}

	public Label getAddCollectionInsteadLabelText() {
		return addCollectionInsteadLabelText;
	}

	public void setAddCollectionInsteadLabelText(Label addCollectionInsteadLabelText) {
		this.addCollectionInsteadLabelText = addCollectionInsteadLabelText;
	}
	public void updateWorkSpaceLink(String collectionId){
		getAddResourceToCollectionButton().getElement().getStyle().setDisplay(Display.BLOCK);
		getAddingLabel().getElement().getStyle().setDisplay(Display.NONE);
		getResourceAddedSuccessMessageContainer().setVisible(true);
		getResourceImageContainerInAddResource().setVisible(false);
		if(getAddResourceToCollectionButton().getText().equalsIgnoreCase("Add Again")){
			successMessageLabelText.setText("This resource has been added to your collection, again!");
		}else{
			successMessageLabelText.setText("This resource has been added to your collection!");
			addResourceToCollectionButton.setText("Add Again");
		}
		workSpaceLink.setHref("#organize&id="+collectionId+"&eventType=refresh");
		addCollectionInsteadLabelContainer.clear();
		Label colletionIsteadButton=getAddCollectionViewButton();
		colletionIsteadButton.getElement().getStyle().setMarginRight(138, Unit.PX);
		colletionIsteadButton.getElement().getStyle().setMarginTop(-15, Unit.PX);
		addCollectionInsteadLabelContainer.add(colletionIsteadButton);
		
	}
	public void changeButtonText(){
		getResourceAddedSuccessMessageContainer().setVisible(false);
		getResourceImageContainerInAddResource().setVisible(true);
		addResourceToCollectionButton.setText("Add");
		addCollectionContainer.clear();
		Label colletionIsteadButton=getAddCollectionViewButton();
		colletionIsteadButton.getElement().getStyle().clearMarginRight();
		colletionIsteadButton.getElement().getStyle().clearMarginTop();
		addCollectionContainer.add(colletionIsteadButton);
	}

	@Override
	public void setCollectionItemData(String collectionId,CollectionItemDo collectionItemDo) {
		this.collectionItemDo=collectionItemDo;
		this.collectionItemId=collectionItemDo.getResource().getGooruOid();
		getDropdownListPlaceHolder().setText("Choose one of the following...");
		getDropdownListPlaceHolder().getElement().removeAttribute("id");
		getDropdownListContainer().clear();
		changeButtonText();
		if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
			resourceImageWidget.setUrl(getQuestionImage());
		}else{
			resourceImageWidget.setUrl(collectionItemDo.getResource().getThumbnails().getUrl());
		}
		resourceTypeSmallImage.addStyleName(getResourceTypeImage(collectionItemDo.getResource().getCategory()));
		// TODO  need to implement logic for display resource thumbnail.
		
	}
	private class OnAddResourceButtonClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			getSizeMessage().getElement().getStyle().setDisplay(Display.NONE);
			getErrorMessage().getElement().getStyle().setDisplay(Display.NONE);
			if (getDropdownListPlaceHolder().getText().equalsIgnoreCase("Choose one of the following...")) {
				getSizeMessage().getElement().getStyle().setDisplay(Display.NONE);
				getErrorMessage().getElement().getStyle().setDisplay(Display.BLOCK);
			} else {
				String collectionId = getDropdownListPlaceHolder().getElement().getAttribute("id");
				String collectionItemsSize=getDropdownListPlaceHolder().getElement().getAttribute("itemssize");
				int itemsSize=collectionItemsSize!=null&&!collectionItemsSize.equals("")?Integer.parseInt(collectionItemsSize):0;
				if(itemsSize>=25){
					getErrorMessage().getElement().getStyle().setDisplay(Display.NONE);
					getSizeMessage().getElement().getStyle().setDisplay(Display.BLOCK);
				}else{
					getAddResourceToCollectionButton().getElement().getStyle().setDisplay(Display.NONE);
					getAddingLabel().getElement().getStyle().setDisplay(Display.BLOCK);
					copyCollectionItem(collectionItemId, collectionId);
				}
			}
		}
	}
	
	public void copyCollectionItem(String collectionItemId,String collectionId){
		getUiHandlers().copyCollectionItem(collectionItemId, collectionId);
	}
	
	public void addCollectionItems(ArrayList<CollectionItemsList> userCollectionsList,boolean isClearPanel) {
			if (isClearPanel) {
				isAllUserShelfCollectionsLoaded = false;
				getDropdownListContainer().clear();
			}
			if (userCollectionsList.size() > 0) {
				for (CollectionItemsList userCollection : userCollectionsList) {
					addDropDownListItem(userCollection.getCollectionTitle(),userCollection.getCollectionId(),userCollection.getCollectionItemsListSize());
				}
			} else {
				isAllUserShelfCollectionsLoaded = true;
			}
	}
	
	@UiHandler("resourceImageWidget")
	public void onErrorResourceImage(ErrorEvent errorEvent){
		resourceImageWidget.setUrl("images/resource_trans.png");
		resourceImageWidget.setStyleName(getResourceDefaultImage(collectionItemDo.getResource().getCategory()));
	}
	
	private String getQuestionImage(){
		String thumbnailImage="";
		String assetName="";
		try{
			if(collectionItemDo.getResource().getAssets()!=null&&collectionItemDo.getResource().getAssets().size()>0){
				assetName=collectionItemDo.getResource().getAssets().get(0).getAsset().getName();
				thumbnailImage=collectionItemDo.getResource().getAssetURI()+collectionItemDo.getResource().getFolder()+assetName;
			}else{
				thumbnailImage=collectionItemDo.getResource().getThumbnails().getUrl();
			}
		}catch(Exception e){
			
		}
		return thumbnailImage;
	}
	
	public String getResourceTypeImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceType();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Website")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceType();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")){
			return PlayerBundle.INSTANCE.getPlayerStyle().slideResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textbookResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceType();
		}
		else if(resourceType.equalsIgnoreCase("lesson")){
			return PlayerBundle.INSTANCE.getPlayerStyle().lessonResourceType();
		}else if(resourceType.equalsIgnoreCase("Handout")){
			return PlayerBundle.INSTANCE.getPlayerStyle().handoutResourceType();
		}else {
			return PlayerBundle.INSTANCE.getPlayerStyle().examResourceType();
		}
	}
	
	public String getResourceDefaultImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceDefault();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Website")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceDefault();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")){
			return PlayerBundle.INSTANCE.getPlayerStyle().slideResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textbookResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("lesson")){
			return PlayerBundle.INSTANCE.getPlayerStyle().lessonResourceDefault();
		}else if(resourceType.equalsIgnoreCase("Handout")){
			return PlayerBundle.INSTANCE.getPlayerStyle().handoutResourceDefault();
		}else {
			return PlayerBundle.INSTANCE.getPlayerStyle().examResourceDefault();
		}
	}

	@Override
	public Label getAddNewCollectionButton() {
		return createCollectionButton;
	}
	
}
