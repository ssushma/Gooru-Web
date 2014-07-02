package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.drive;

import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.event.GetEditPageHeightEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.AppSuggestBox;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.drive.DriveDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class GoogleDocsResourceView extends Composite implements MessageProperties{
	private static GoogleDocsResourceViewUiBinder uiBinder = GWT.create(GoogleDocsResourceViewUiBinder.class);

	interface GoogleDocsResourceViewUiBinder extends
			UiBinder<Widget, GoogleDocsResourceView> {
		
	}
	protected AppPopUp appPopUp;

	String id;
	String alternateLink;
	
	@UiField
	public Label mandatoryEducationalLbl, cancelResourcePopupBtnLbl, generateImageLbl,agreeText,andText,additionalText,mandatorymomentsOfLearninglLbl;
	@UiField
	public BlueButtonUc addResourceBtnLbl;

	@UiField
	Label  mandatoryTitleLbl,rightsLbl;

	@UiField
	Label mandatoryCategoryLbl;
	@UiField
	HTMLEventPanel refreshLbl,lblContentRights,resourceTypePanel,videoResourcePanel;
	@UiField
	Label leftArrowLbl, rightArrowLbl, uploadImageLbl;

	@UiField
	public TextBox  titleTextBox;

	@UiField
	public TextArea descriptionTxtAera;
	
	@UiField
	Label titleTextLabel,descriptionTextLabel,resourceFormatLabel;

	// @UiField public ListBox resourceTypeListBox;

	@UiField
	public Image setThumbnailImage;
	// Drop down for Resource Type//
	@UiField
	HTMLPanel descCharcterLimit,contentPanel,panelContentRights,titleText,categoryTitle,educationalTitle,momentsOfLearningTitle,orText,refreshText;

	@UiField
	public HTMLPanel addResourceBtnPanel,descriptionLabel,videoLabel,interactiveText,websiteText,imagesText,audioText;//otherText

	@UiField
	HTMLPanel categorypanel, video, interactive, website,thumbnailText,audio,image;//other

	@UiField
	HTMLPanel  resourceDescriptionContainer,buttonsPanel;

	@UiField
	Label resoureDropDownLbl, resourceCategoryLabel, loadingTextLbl,mandatoryDescLblForSwareWords,mandatoryTitleLblForSwareWords;
	
	@UiField   
	CheckBox rightsChkBox;
	@UiField
	Anchor copyRightAnr;
	
	@UiField
	Anchor termsAndPolicyAnr,privacyAnr;
	
	@UiField
	Anchor commuGuideLinesAnr;
	
		
	
	
	
	
	public GoogleDocsResourceView( DriveDo driveDo){
		initWidget(uiBinder.createAndBindUi(this));
		addResourceBtnLbl.setText(GL0590);
		cancelResourcePopupBtnLbl.setText(GL0142);
		cancelResourcePopupBtnLbl.addClickHandler(new CloseClickHandler());
		
		thumbnailText.getElement().setInnerText(GL0922);
		titleTextLabel.setText("Title");
		videoLabel.getElement().setInnerText("Slides");
		descriptionTextLabel.setText("Description");
		resourceFormatLabel.setText("Resource Format*");
		uploadImageLbl.setText("Upload Image");
		resourceTypePanel.setVisible(false);
		panelContentRights.setVisible(false);
		titleTextBox.setText(driveDo.getTitle());
		thumbnailText.getElement().setInnerText("");
		descriptionTxtAera.setText(driveDo.getDescription());
	}
	@UiHandler("videoResourcePanel")
	void videoResourcePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_video_selected");
		resourceCategoryLabel.setText("Slides");
		categorypanel.setStyleName(video.getStyleName());
		resourceTypePanel.setVisible(false);
		mandatoryCategoryLbl.setVisible(false);
	}

	
	
	@UiHandler("resoureDropDownLbl")
	public  void displayDropDown(ClickEvent event){
		
		resourceTypePanel.setVisible(resourceTypePanel.isVisible() ? false : true);
		System.out.println("entring the condition  resource panle type");
	}
	
	
	@UiHandler("addResourceBtnLbl")
	public void addResource(ClickEvent event){
		DriveDo driveObject=new DriveDo();
		driveObject.setId(id);
		driveObject.setAlternateLink(alternateLink);
		AppClientFactory.getInjector().getResourceService().updatePermissions( driveObject,new SimpleAsyncCallback<DriveDo>(){

			@Override
			public void onSuccess(DriveDo result) {
				// TODO Auto-generated method stub
				
			}

			
		});
	
	}	
	
	private class CloseClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			clearFields();
			hidePopup();
		}
	}
	
	
	public void clearFields() {
		titleTextBox.setText("");

		// if(tinyMce!=null){
		// tinyMce.setEmptyContent("");
		// }
		// try {
		// tinyMce.setEmptyContent("");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }

		descriptionTxtAera.setText("");
		// resourceTypeListBox.setSelectedIndex(0);
		generateImageLbl.setVisible(true);
		setThumbnailImage.setUrl("");
		/*if (thumbnailImages != null) {
			thumbnailImages.clear();
		}*/
		resourceCategoryLabel.setText(GL0360);
		categorypanel.setStyleName("");

		mandatoryCategoryLbl.setVisible(false);
		mandatoryTitleLbl.setVisible(false);
		descCharcterLimit.setVisible(false);
		loadingTextLbl.getElement().getStyle().setDisplay(Display.NONE);
		buttonsPanel.getElement().getStyle().setDisplay(Display.BLOCK);
//		buttonsPanel.setVisible(true);
//		loadingTextLbl.setVisible(false);
		setVisible(true);
	}

	public void hidePopup(){
		closeAddResourcePopup();
	}


	
	
	public void closeAddResourcePopup(){
		AppClientFactory.fireEvent(new GetEditPageHeightEvent(appPopUp, true));
		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		appPopUp.hide();
	}
}