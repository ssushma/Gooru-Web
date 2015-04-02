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
package org.ednovo.gooru.client.mvp.shelf;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * @author Search Team
 *
 */
public interface ShelfCBundle extends ClientBundle{
	
	static final ShelfCBundle INSTANCE = GWT.create(ShelfCBundle.class);
	
	public interface  ShelfCss extends CssResource{
		
		//-------------Folders-------//
		
		String folderDragdropSpacer();

		String collectionDescriptionTxtAreaForFolders();
		String collectionDescriptionHtmlForFolders();
		String userCollectionInfoForFolders();
		String myFoldersIcon();
		String myScollectionsIcon();
		//-------------Folders-------//		
		String userShelfViewMainContainer();
		
		String userShelfViewContainer();
		
		String userShelfViewList();
		
		String userCollectionInShelfContainer();
		
		String userCollectionInShelf();
		
		String userCollectionInfo();
		
		String collectionTitle();
		
		String collectionDescription();
		
		String collectionDescriptionTxtArea();
		
		String collectionDescriptionHtml();
		
		String collectionEditImage();
		
		String userCollectionMetaDataInfoContainer();
		
		String userCollectionMetaInfo();
		
		String userCollectionMetaInfoImage();
		
		String collectionMetaDataTabTitle();
		
		String collectionMetaDataTabTitleActive();
		
		String userCollectionMetaResourceImage();
		
		String profileMetaDataTabTitleActive();
		
		String userCollectionMetaCollaboratorImage();
		
		String userCollectionMetaAssignImage();
		
		String userCollectionMetaShareImage();
		
		String userCollectionMetaStatisticsImage();
		
		String userCollectionMetaShelfFtLft();
		
		String metaInfo();

		String folderMetaInfo();
		/*AddShelfResource*/
		
		String resourceDragCursorPosition();
		
		String plusImage();
		
		String resourceDrag();
		
		String resourceDragWithImg();
		
		String resourceDragImage();
		
		String resourceDragTitle();
		
		String minusImage();
		
		String examSmall();
		
		String challengeSmall();
		
		String videoSmall();
		
		String questionSmall();
		
		String interactiveSmall();
		
		String websiteSmall();
		
		String webpageSmall();
		
		String textbookSmall();
		
		String handoutSmall();
		
		String lessonSmall();
		
		String slideSmall();
		
		String imageSmall();
		
		String audioSmall();
		
		String otherSmall();
		
		String collectionSmall();
		
		String backToSearch();
		
		String backToSearchPanel();
		
		String preBackToSearch();
		
		String howToDo();
		
		String howToDoSeperator();
		
		String userCopyCollection();
		
		String showShareInnerDiv();
		
		String showShareCointainer();
		
		String shareLinkContainer();
		
		String shareLink();
		
		String shareLinkFlowPanel();
		
		String shareLinkBoxContainer();
		
		String shareLinkBox();

		String floatShelfTabLeft();
		
		String linkImage();
		
		String linkImageShare();
		
		String privateImage();
		
		String publicImage();
		
		String loadingImageForShare();
		
		String loadingImageMainDivShare();
	
		/*StatisticsItemUc*/
		
		String addsImageStyle();
		
		String viewsImageStyle();
		
		String likesImageStyle();
		
		String sharesImageStyle();
		
		String avgTimeImageStyle();
		
		String itemTextStyle();
		
		String itemValueStyle();
		
		String imagePanel();
		
		String itemPanel();
		
		String outerPanel();
		
		String headerLabel();
		
		String showShareSubTitles();
		
		String inActiveClass();
			
		String userDeleteCollection();
		
		String shelfItemPopUp();
		
		String shelfItemShortenUrlPopUp();
		
		String shelfItemSucessPopUp();
		
		String shelfItemPopUpOuterDiv();
		
		String shelfItemHeaderText();
		
		String collectionDescriptionTitle();
		
		String collectionOwner();	
		
		String titleAlertContainer();
		
		String titleAlertMessage();
		
		String descriptionAlertMessage();
		
		String logoutPopup();
		
		String previewButton();
		
		/************** Delete Confirmation Popup*******************/
		
		String deletePopupContainer();
		
		String confirmMessageContainer();
		
		String confirmMessage();
		
		String resourceIndex();
		
		String inlineText();
		
		String actionField();
		
		String shareLinkBoxDisabled();
		
		String shareContentText();
		
		String shareContentTextContainer();
		
		String sharePublicOrLinked();
		
		String collectionShareTooltip();
		
		String confirmMessageTitle();
		
		String confirmMessages();
		
		String confirmMessageDelete();
		
		String confirmMessageOk();
		
		String simplePencil();
		
		String collectionMetaDataTabTitleDisabled();
		
		String panelAlignRight();
		
		String deleteIcon();
		
		String inputText();
		
		/* Comming soon popup */
		String hoverPopupContainer();
		
		String hoverPopupArrow();
		
		String hoverPopupTextContainer ();
		
		String share();
		
		String shareActive();
		
		String objPosition();
		
		String noCollectionMessage();
		
		String loadingImageForSelfEdit();
		
		String loadingImageMainDiv();
		
		String mySelfCollectionEditTitlePreviewCancelButton();
		
		String cursor();
		
		String mySelfCollectionEditTitleSaveButton();
		
		String mySelfCollectionrEditTitle();
		
		String collectionDescriptionTitleContainer();
		
		String collectionTitleContainer();
		
		String mySelfCollectionEditDescPreviewCancelButton();
		
		String buttonContainer();
		
		String buttonContainerDesc();
		String mySelfCollectionEditDescSaveButton();

		/*collection share new correction*/
		
		String collectionShareLineSeparator();
		
		String smallLine();
		
		String CollectionshareThisLinkVia();
		
		String userShelfViewMainCenterContainer();

		String embedContainer();
		
		String tabsLi();
		
		String tabsLiDeactivated();
		
		String noCollectionMessageRight();
		
		String tabsLiActive();
		
		String embedTextAreaForCollectionSearch();
		
		String embedTextAreaForShelf();

		String directLinkTextArea();
		
		String directLinkContainer();
		
		String collectionVisibilityMain();
		
		String collectionVisibility();
		
		String collectionVisibleShareLineSeparator();
		
		String collectionVisibilityMainDiv();
		
		String shareLinkSwitchUrl();
		
		String shareLinkSwitchEmbed();
		
		String editButtonText();
		
		String editButtonContainer();
		
		String shareVisibilityRadioBtnStyle();
		
		String visibilityRadioButton();
		
		String visibilityRadioButtonSelected();

		String publicVisibleIcon();
		
		String privateVisibleIcon();
		
		String linkVisibleIcon();
		
		String publicVisibleIconBottom();
		
		String shareableVisibleIconBottom();
		
		String privateVisibleIconBottom();
		
		String folderBorderColor();
		
		String objectFloat();
		String friendlyDiv();
		String objectFontType();		
		String analyticsStyle();
		String lastEditedBy();
		String deleteDiv();
		
		String shareLink2();
		String deleteOkayButton();
		
		String aleartDescText();
		String aleartDescTextForNotLoggedInUser();
		String shelfItemSucessPopUpWithOutWidth();
		String collectionEditImageTeacherTip();
		
		String publishPanel();
		String publishButton();
		String shelfPublishTab();
		String publishPending();
		String published();
		
		String userprofilecount();
		
		String profileMetaDataTabTitle();
		
		String profileMetaDataTabTitleDisabled();
		
		String standardsBrowsePopup();
		
		String assignSprite();
		String assignCloseMark();
		String assignCloseMarker();
		String charLimit();
		
		String shelfPublishTabText();
	}
	
	@Source("Shelf.css")
	ShelfCss css();
	
}
