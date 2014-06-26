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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsOfUse;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;
import org.ednovo.gooru.client.mvp.shelf.event.GetEditPageHeightEvent;
import org.ednovo.gooru.client.uc.AppMultiWordSuggestOracle;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.AppSuggestBox;
import org.ednovo.gooru.client.uc.CloseLabel;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.StandardsPreferenceOrganizeToolTip;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo;
import org.ednovo.gooru.shared.model.content.checkboxSelectedDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.ResourceImageUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class EditResourcePopupVc extends AppPopUp implements SelectionHandler<SuggestOracle.Suggestion>,MessageProperties{

	CollectionItemDo collectionItemDo;
	CollectionItemDo collectionOriginalItemDo;
	

	@UiField
	public Button addResourceBtn;
	
	@UiField
	public Label generateImageLbl;

	@UiField
	Label resourcemomentsOfLearningLabel,standardMaxMsg,mandatoryEducationalLbl,resourceEducationalLabel,mandatoryUrlLbl, mandatoryTitleLbl,agreeText,additionalText;

	@UiField
	Label mandatoryCategoryLbl, urlTextLbl,andText;

	@UiField
	Label leftArrowLbl, rightArrowLbl, uploadImageLbl,mandatoryDescLblForSwareWords,mandatoryTitleLblForSwareWords;

	@UiField
	public TextBox titleTextBox;

	@UiField
	public TextArea descriptionTxtAera;
	
	@UiField HTMLEventPanel videoResourcePanel,lblContentRights;

	/*@UiField
	public ListBox resourceTypeListBox;*/

	@UiField
	Image setThumbnailImage;
	
	// Drop down for Resource Type//
	@UiField
	HTMLPanel momentsOfLearningPanel,momentsOfLearningTitle,extendingUnderstandingText,interactingWithTheTextText,preparingTheLearningText,educationalUsePanel,educationalTitle,homeworkText,gameText,presentationText,referenceMaterialText,quizText,curriculumPlanText,lessonPlanText,
	unitPlanText,projectPlanText,readingText,textbookText,articleText,bookText,activityText,handoutText,descCharcterLimit,saveButtonContainer,panelContentRights,rightsContainer,videoPanel,interactivePanel,websitePanel,imagePanel,textsPanel,audioPanel;//otherPanel
	
	@UiField Label mandatorymomentsOfLearninglLbl,standardsDefaultText,resourceCategoryLabel,loadingTextLbl,rightsLbl;
	
	 @UiField HTMLPanel categorypanel,video,interactive,website,resourceTypePanel,image,texts,audio,resourceFormat,resDescription,urlTextPanel,titleTextPanel,thumbnailLbl,orLbl,refreshLblPanel;//other,
	 @UiField CheckBox rightsChkBox;
	 @UiField Anchor copyRightAnr;
	 @UiField Anchor termsAndPolicyAnr,privacyAnr;
	@UiField Anchor commuGuideLinesAnr,cancelResourcePopupBtnLbl;
	@UiField(provided = true)
	AppSuggestBox standardSgstBox;
	
	@UiField FlowPanel standardContainer,standardsPanel;
	private static final String USER_META_ACTIVE_FLAG = "0";
	ResourceMetaInfoDo resMetaInfoDo = null;
	private CopyRightPolicyVc copyRightPolicy;
	
	private TermsAndPolicyVc termsAndPolicyVc;
	private TermsOfUse termsOfUse;
	private int activeImageIndex = 0;
	protected List<String> thumbnailImagesLink;
	
	private String thumbnailUrlStr = null;
	
	String fileNameWithOutRespUrl = null;
	
	public boolean resoureDropDownLblOpen = false,educationalDropDownLblOpen=false,momentsOfLearningOpen=false;
	
	private static final String DEFULT_IMAGE_PREFIX = "images/default-";

	private static final String PNG = ".png";
	boolean isHavingBadWordsInTextbox=false,isHavingBadWordsInRichText=false;
	
	String courseCode="";
	private AppMultiWordSuggestOracle standardSuggestOracle;
	private SearchDo<CodeDo> standardSearchDo = new SearchDo<CodeDo>();
	private static final String FLT_CODE_ID = "id";
	List<String> standardPreflist;
	private Map<String, String> standardCodesMap = new HashMap<String, String>();
	Set<CodeDo> standardsDo=new HashSet<CodeDo>();
	Set<CodeDo> deletedStandardsDo=new HashSet<CodeDo>();
	
	StandardsPreferenceOrganizeToolTip standardsPreferenceOrganizeToolTip=new StandardsPreferenceOrganizeToolTip();
	
	private static EditResourcePopupVcUiBinder uiBinder = GWT
			.create(EditResourcePopupVcUiBinder.class);

	interface EditResourcePopupVcUiBinder extends
			UiBinder<Widget, EditResourcePopupVc> {
	}

	public abstract void updateResource(CollectionItemDo collectionItemDo);

	public EditResourcePopupVc(CollectionItemDo collectionItemDo) {
		super();
		
		standardSuggestOracle = new AppMultiWordSuggestOracle(true);
		standardSearchDo.setPageSize(10);
		standardSgstBox = new AppSuggestBox(standardSuggestOracle) {
			
			@Override
			public void keyAction(String text) {
				text=text.toUpperCase();
				standardsPreferenceOrganizeToolTip.hide();
				standardSearchDo.setSearchResults(null);
				boolean standardsPrefDisplayPopup = false;
				standardSgstBox.hideSuggestionList();
				if(!courseCode.isEmpty()) {
					Map<String,String> filters = new HashMap<String, String>();
					filters.put(FLT_CODE_ID,courseCode);
					standardSearchDo.setFilters(filters);
				}
				standardSearchDo.setQuery(text);
				if (text != null && text.trim().length() > 0) {
					standardsPreferenceOrganizeToolTip.hide();
					if(standardPreflist!=null){
						for(int count=0; count<standardPreflist.size();count++) {
							if(text.contains(standardPreflist.get(count))) {
								standardsPrefDisplayPopup = true;
								break;
							} else {
								standardsPrefDisplayPopup = false;
							}
						}						
					}
					
					if(standardsPrefDisplayPopup){
						standardsPreferenceOrganizeToolTip.hide();
						AppClientFactory.getInjector().getSearchService().getSuggestStandardByFilterCourseId(standardSearchDo, new AsyncCallback<SearchDo<CodeDo>>() {
							
							@Override
							public void onSuccess(SearchDo<CodeDo> result) {
								setStandardSuggestions(result);
								
							}
							
							@Override
							public void onFailure(Throwable caught) {
							}
						});
						
						standardSgstBox.showSuggestionList();
						}
					else{
						standardSgstBox.hideSuggestionList();
						standardSuggestOracle.clear();
						standardsPreferenceOrganizeToolTip.show();
						standardsPreferenceOrganizeToolTip.setPopupPosition(standardSgstBox.getAbsoluteLeft()+3, standardSgstBox.getAbsoluteTop()+33);
						standardsPreferenceOrganizeToolTip.getElement().getStyle().setZIndex(1111);
						//standardSuggestOracle.add(GL1613);
						
					}
					}
			}

			@Override
			public HandlerRegistration addClickHandler(ClickHandler handler) {
				return null;
			}
		};
		BlurHandler blurHandler=new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if(standardsPreferenceOrganizeToolTip.isShowing()){
				standardsPreferenceOrganizeToolTip.hide();
				}
			}
		};
		standardSgstBox.addDomHandler(blurHandler, BlurEvent.getType());
		standardSgstBox.addSelectionHandler(this);
		// this.getElement().getStyle().setWidth(450, Unit.PX);
		// this.getElement().getStyle().setHeight(788, Unit.PX);
		this.collectionItemDo = collectionItemDo;
		this.collectionOriginalItemDo = collectionItemDo;
		setContent(GL0949, uiBinder.createAndBindUi(this));

		addResourceBtn.addClickHandler(new AddClickHandler());
		addResourceBtn.getElement().getStyle().setFloat(Float.LEFT);
		uploadImageLbl.addClickHandler(new OnEditImageClick());

		titleTextBox.addKeyUpHandler(new TitleKeyUpHandler());
		descriptionTxtAera.addKeyUpHandler(new DescriptionKeyUpHandler());
		titleTextBox.getElement().setAttribute("maxlength", "50");
		descriptionTxtAera.getElement().setAttribute("maxlength", "300");
		mandatoryUrlLbl.setVisible(false);
		mandatoryTitleLbl.setVisible(false);
		mandatoryCategoryLbl.setVisible(false);
		descCharcterLimit.setVisible(false);
		leftArrowLbl.setVisible(false);
		rightArrowLbl.setVisible(false);
		setThumbnailImage.setVisible(true);
		resourceTypePanel.setVisible(false);
		loadingTextLbl.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		generateImageLbl.setVisible(false);
		saveButtonContainer.setVisible(true);
		loadingTextLbl.setVisible(false);
		panelContentRights.setVisible(false);
		mandatoryTitleLblForSwareWords.setVisible(false);
		mandatoryDescLblForSwareWords.setVisible(false);
		rightsChkBox.addClickHandler(new rightsChecked());
		rightsChkBox.getElement().setId("chkRights");
		setModal(true);
		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
        mandatoryTitleLbl.setText(GL0173);
        descCharcterLimit.getElement().setInnerText(GL0143);
        mandatoryCategoryLbl.setText(GL1515);
        thumbnailLbl.getElement().setInnerText(GL0911);
        titleTextPanel.getElement().setInnerText(GL0318+GL_SPL_STAR);
        videoPanel.getElement().setInnerHTML(GL0918);
        interactivePanel.getElement().setInnerHTML(GL0919);
		websitePanel.getElement().setInnerHTML(GL1396);
		textsPanel.getElement().setInnerHTML(GL1044);
		audioPanel.getElement().setInnerHTML(GL1045);
		imagePanel.getElement().setInnerHTML(GL1046);
		generateImageLbl.setText(GL0922);
		orLbl.getElement().setInnerText(GL_GRR_Hyphen+GL0209.toLowerCase()+GL_GRR_Hyphen);
		uploadImageLbl.setText(GL0912);
		refreshLblPanel.getElement().setInnerText(GL0923);
		rightsLbl.setText(GL0869);
		agreeText.setText(GL0870);
		commuGuideLinesAnr.setText(GL0871);
		termsAndPolicyAnr.setText(" "+GL0872+GL_GRR_COMMA);
		privacyAnr.setText(" "+GL0873);
		andText.setText(" "+GL_GRR_AND+" ");
		copyRightAnr.setText(" "+GL0875);
		additionalText.setText(GL0874);
		addResourceBtn.setText(GL0141);
		cancelResourcePopupBtnLbl.setText(GL0142);
		loadingTextLbl.setText(GL0808.toLowerCase());
//		otherPanel.getElement().setInnerHTML(MessageProperties.GL1047);  
		resourceFormat.getElement().setInnerHTML(GL0906); 
		resDescription.getElement().setInnerHTML(GL0904); 
		urlTextPanel.getElement().setInnerHTML(GL0915);
		mandatoryUrlLbl.setText(GL0916);
		momentsOfLearningPanel.setVisible(false);
		
		educationalTitle.getElement().setInnerHTML(GL1664);
		activityText.getElement().setInnerHTML(GL1665);
		handoutText.getElement().setInnerHTML(GL0907);
		homeworkText.getElement().setInnerHTML(GL1666);
		gameText.getElement().setInnerHTML(GL1667);
		presentationText.getElement().setInnerHTML(GL1668);
		referenceMaterialText.getElement().setInnerHTML(GL1669);
		quizText.getElement().setInnerHTML(GL1670);
		curriculumPlanText.getElement().setInnerHTML(GL1671);
		lessonPlanText.getElement().setInnerHTML(GL1672);
		unitPlanText.getElement().setInnerHTML(GL1673);
		projectPlanText.getElement().setInnerHTML(GL1674);
		readingText.getElement().setInnerHTML(GL1675);
		textbookText.getElement().setInnerHTML(GL0909);
		articleText.getElement().setInnerHTML(GL1676);
		bookText.getElement().setInnerHTML(GL1677);
		educationalUsePanel.setVisible(false);
		standardsDefaultText.setText(GL1682);
		momentsOfLearningTitle.getElement().setInnerHTML(GL1678);
		preparingTheLearningText.getElement().setInnerHTML(GL1679);
		interactingWithTheTextText.getElement().setInnerHTML(GL1680);
		extendingUnderstandingText.getElement().setInnerHTML(GL1681);
		resourceEducationalLabel.setText(GL1684);
		resourcemomentsOfLearningLabel.setText(GL1684);
		displayResourceInfo();
		show();
		center();
		AppClientFactory.fireEvent(new GetEditPageHeightEvent(this, false));
		getResourceMetaInfo(collectionItemDo.getResource().getUrl());
		copyRightAnr.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				copyRightPolicy = new  CopyRightPolicyVc() {
					@Override
					public void openParentPopup() {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98,false));
					}
				};
				
				copyRightPolicy.show();
				copyRightPolicy.setSize("902px", "300px");
				copyRightPolicy.center();
				copyRightPolicy.getElement().getStyle().setZIndex(999);
				
			}
		});
		
		

		
		termsAndPolicyAnr.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				termsOfUse = new TermsOfUse() {
					@Override
					public void openParentPopup() {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98,false));
					}
				};
				
				termsOfUse.show();
				termsOfUse.setSize("902px", "300px");
				termsOfUse.center();
				termsOfUse.getElement().getStyle().setZIndex(999);
			}
			
		});
		privacyAnr.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				termsAndPolicyVc = new TermsAndPolicyVc(false) {
					@Override
					public void openParentPopup() {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98,false));
					}
				};
				
				termsAndPolicyVc.show();
				termsAndPolicyVc.setSize("902px", "300px");
				termsAndPolicyVc.center();
				termsAndPolicyVc.getElement().getStyle().setZIndex(999);
			}
			
		});
		commuGuideLinesAnr.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.open("http://support.goorulearning.org/hc/en-us/articles/200688506","_blank",""); 
			}
		});
		titleTextBox.addBlurHandler(new CheckProfanityInOnBlur(titleTextBox, null, mandatoryTitleLblForSwareWords));
		descriptionTxtAera.addBlurHandler(new CheckProfanityInOnBlur(null, descriptionTxtAera, mandatoryDescLblForSwareWords));
		AppClientFactory.getInjector().getUserService().getUserProfileV2Details(AppClientFactory.getGooruUid(),USER_META_ACTIVE_FLAG,new SimpleAsyncCallback<ProfileDo>() {

			@Override
			public void onSuccess(ProfileDo profileObj) {
			if(profileObj.getUser().getMeta().getTaxonomyPreference().getCodeId()!=null){
					if(profileObj.getUser().getMeta().getTaxonomyPreference().getCodeId().size()==0){
						standardContainer.setVisible(false);
					}else
					{
						standardContainer.setVisible(true);
						standardPreflist=new ArrayList<String>();
						for (String code : profileObj.getUser().getMeta().getTaxonomyPreference().getCode()) {
							standardPreflist.add(code);
							standardPreflist.add(code.substring(0, 2));
						 }
						
					}
				}else{
					standardContainer.setVisible(false);
				}
			}

		});
	}
	public void onLoad(){
		super.onLoad();
		Scheduler.get().scheduleDeferred(new ScheduledCommand(){

			@Override
			public void execute() {
				setResourceDescription();
			}
        });
	}
	@UiHandler("lblContentRights")
	public void onMouseOver(MouseOverEvent event){
		panelContentRights.setVisible(true);
	}
	
	@UiHandler("lblContentRights")
	public void onMouseOut(MouseOutEvent event){
		panelContentRights.setVisible(false);
	}

	@UiHandler("cancelResourcePopupBtnLbl")
	public void cancelPopUp(ClickEvent clickEvent) {
		AppClientFactory.fireEvent(new GetEditPageHeightEvent(this, true));

		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
        if(deletedStandardsDo.size()>0){
        	AppClientFactory.getInjector().getResourceService().UpdateResourceTaxonomy(collectionItemDo.getResource().getGooruOid(), deletedStandardsDo, new SimpleAsyncCallback<Void>() {
				
				@Override
				public void onSuccess(Void result) {
					deletedStandardsDo.clear();
				}
			});
        }
		hide();
	}
	public void setStandardSuggestions(SearchDo<CodeDo> standardSearchDo) {
		standardSuggestOracle.clear();
		this.standardSearchDo = standardSearchDo;
		if (this.standardSearchDo.getSearchResults() != null) {
			List<String> sources = getAddedStandards(standardsPanel);
			for (CodeDo code : standardSearchDo.getSearchResults()) {
				if (!sources.contains(code.getCode())) {
					standardSuggestOracle.add(code.getCode());
				}
				standardCodesMap.put(code.getCodeId() + "", code.getLabel());
			}
		}
		standardSgstBox.showSuggestionList();
	}
	/**
	 * get the standards are added for collection
	 * 
	 * @param flowPanel
	 *            having all added standards label
	 * @return standards text in list which are added for the collection
	 */
	private List<String> getAddedStandards(FlowPanel flowPanel) {
		List<String> suggestions = new ArrayList<String>();
		for (Widget widget : flowPanel) {
			if (widget instanceof DownToolTipWidgetUc) {
				suggestions.add(((CloseLabel) ((DownToolTipWidgetUc) widget).getWidget()).getSourceText());
			}
		}
		return suggestions;
	}
	public void getResourceMetaInfo(String url) {
		AppClientFactory
				.getInjector()
				.getResourceService()
				.getResourceMetaInfo(url,
						new SimpleAsyncCallback<ResourceMetaInfoDo>() {

							@Override
							public void onSuccess(ResourceMetaInfoDo result) {
								setData(result);
							}
						});
	}

	public void setData(ResourceMetaInfoDo result) {
		setResMetaInfo(result);
		setThumbnailImages(result.getImages());
		updateUi();
		rightArrowLbl.setVisible(true);
	}
	private class rightsChecked implements ClickHandler {
			@Override
			public void onClick(ClickEvent event) {
				if(rightsChkBox.getValue()){
					rightsLbl.getElement().getStyle().setColor("black");
				}
				else{
					rightsLbl.getElement().getStyle().setColor("orange");
				}
				
			}
	}
	private void setThumbnailImages(List<String> images) {
		thumbnailImagesLink = images;
	}

	private void setResMetaInfo(ResourceMetaInfoDo result) {
		this.resMetaInfoDo = result;
	}
	
	public void setResourceDescription(){
		descriptionTxtAera.setText(collectionItemDo.getResource().getDescription());
	}

	public void displayResourceInfo() {
		
		String url = collectionItemDo.getResource().getUrl();
		urlTextLbl.setText(url);
		if (collectionItemDo.getResource().getDescription().length() >= 300) {
			descriptionTxtAera.setText(collectionItemDo.getResource()
					.getDescription().substring(0, 300));
		} else {
			descriptionTxtAera.setText(collectionItemDo.getResource()
					.getDescription());
		}
		if (collectionItemDo.getResource().getTitle().length() >= 50) {
			titleTextBox.setText(collectionItemDo.getResource().getTitle()
					.substring(0, 50));
		} else {
			titleTextBox.setText(collectionItemDo.getResource().getTitle());
		}

		setThumbnailImage.setVisible(true);
		String category = collectionItemDo.getResource().getCategory();
		
		if (category.equalsIgnoreCase("Video")||category.equalsIgnoreCase("Videos")) {
			resourceCategoryLabel.setText(GL0918);
			categorypanel.setStyleName(video.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
			
		} else if (category.equalsIgnoreCase("Interactive")) {
			resourceCategoryLabel.setText(GL0919);
			categorypanel.setStyleName(interactive.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Website")||category.equalsIgnoreCase("websites")||category.equalsIgnoreCase("webpage")) {
			resourceCategoryLabel.setText(GL1396);
			categorypanel.setStyleName(website.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}
		else if(category.equalsIgnoreCase("audio")) {
			resourceCategoryLabel.setText(GL1045);
			categorypanel.setStyleName(audio.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}
	//	else if((category.equalsIgnoreCase("texts")||(category.equalsIgnoreCase("Slide")||(category.equalsIgnoreCase("Handout")||(category.equalsIgnoreCase("Textbook")||(category.equalsIgnoreCase("Lesson")) {
		else if(category.equalsIgnoreCase("texts")||category.equalsIgnoreCase("text")) {
				resourceCategoryLabel.setText(GL1044);
			categorypanel.setStyleName(texts.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}
		else if (category.equalsIgnoreCase("image")) {
			resourceCategoryLabel.setText(GL1046);
			categorypanel.setStyleName(image.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}
//		else if (category.equalsIgnoreCase("other")) {
//			resourceCategoryLabel.setText(MessageProperties.GL1047);
//			categorypanel.setStyleName(other.getStyleName());
//			resourceTypePanel.setVisible(false);
//			resoureDropDownLblOpen=false;
//		} 
		else if (category.equalsIgnoreCase("Slide")) {
			resourceCategoryLabel.setText(GL1046);
			categorypanel.setStyleName(image.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Handout")) {
			resourceCategoryLabel.setText(GL1044);
			categorypanel.setStyleName(texts.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Textbook")) {
			resourceCategoryLabel.setText(GL1044);
			categorypanel.setStyleName(texts.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Lesson")) {
			resourceCategoryLabel.setText(GL1044);
			categorypanel.setStyleName(texts.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
//		} else if (category.equalsIgnoreCase("Question")) {
//			resourceCategoryLabel.setText("Question");
//			categorypanel.setStyleName(question.getStyleName());
//			resourceTypePanel.setVisible(false);
//			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Exam")) {
			resourceCategoryLabel.setText(GL1396);
			categorypanel.setStyleName(website.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}

		thumbnailUrlStr = collectionItemDo.getResource().getThumbnailUrl();
		setImage(url, category);
		if( collectionItemDo.getResource().getEducationalUse()!=null){
			for (checkboxSelectedDo item : collectionItemDo.getResource().getEducationalUse()) {			
				   if(item.isSelected()){
					    resourceEducationalLabel.setText(item.getValue());
						educationalUsePanel.setVisible(false);
						educationalDropDownLblOpen = false;
						mandatoryEducationalLbl.setVisible(false);
				   }
				}
		}
		if(collectionItemDo.getResource().getMomentsOfLearning()!=null){
			for (checkboxSelectedDo item : collectionItemDo.getResource().getMomentsOfLearning()) {			
				   if(item.isSelected()){
					   resourcemomentsOfLearningLabel.setText(item.getValue());
					   momentsOfLearningPanel.setVisible(false);
					   momentsOfLearningOpen = false;
					   mandatorymomentsOfLearninglLbl.setVisible(false);
				   }
				}
		}
		if(collectionItemDo.getStandards()!=null){
			standardsPanel.clear();
			standardsDo.clear();
			String codeID="",code="",label="";
			for (Map<String, String> map: collectionItemDo.getStandards()) {
				 CodeDo codeObj=new CodeDo();
				for (Map.Entry<String, String> entry : map.entrySet()) {
					String key = entry.getKey();
					String values = entry.getValue();
					 if(key.contains("codeId")){
						 codeID=values;
						 codeObj.setCodeId(Integer.parseInt(values));
					 }
					 if(key.contains("code")){
						 code=values;
						 codeObj.setCode(values);
					 }
					 if(key.contains("description")){
						 label=values;
						 codeObj.setLabel(values);
					 }
					}
				 standardsDo.add(codeObj);
				 standardsPanel.add(createStandardLabel(code, codeID,label));
			}
		}
		
	}

	public void setImage(String url, String category){
		if (thumbnailUrlStr.endsWith("null")) {
			if (url.indexOf("youtube") >0){
				String youTubeIbStr = ResourceImageUtil.getYoutubeVideoId(url);
				thumbnailUrlStr = "http://img.youtube.com/vi/"+youTubeIbStr+"/1.jpg";
			}else{
				thumbnailUrlStr = DEFULT_IMAGE_PREFIX + category.toLowerCase() + PNG;
			}
		} 
		setThumbnailImage.setUrl(thumbnailUrlStr);
	}
	public void updateUi() {
		generateImageLbl.setVisible(false);
		setThumbnailImage.setVisible(true);

		if (urlTextLbl.getText().indexOf("youtube") != -1) {
			rightArrowLbl.setVisible(false);
		}
	}

	private class AddClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			final Map<String, String> parms = new HashMap<String, String>();
			parms.put("text", titleTextBox.getValue());
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
				@Override
				public void onSuccess(Boolean value) {
						isHavingBadWordsInTextbox = value;
						if(value){
							SetStyleForProfanity.SetStyleForProfanityForTextBox(titleTextBox, mandatoryTitleLblForSwareWords,value);
						}else{
							parms.put("text", descriptionTxtAera.getText());
							AppClientFactory.getInjector().getResourceService().checkProfanity(parms,new SimpleAsyncCallback<Boolean>() {
								
								@Override
								public void onSuccess(Boolean result) {
									isHavingBadWordsInRichText=result;
									if(result){
										SetStyleForProfanity.SetStyleForProfanityForTextArea(descriptionTxtAera, mandatoryDescLblForSwareWords, result);
									}else{
										if (!isHavingBadWordsInRichText && !isHavingBadWordsInTextbox) {
											boolean isValidate = true;
											
											String titleStr = titleTextBox.getText().trim();
											String categoryStr =resourceCategoryLabel.getText();// resourceTypeListBox.getItemText(resourceTypeListBox.getSelectedIndex());
											
											String urlStr = urlTextLbl.getText().trim();
											String youTubeId = getYoutubeVideoId(urlStr);

											
											if (titleStr.toLowerCase().contains("http://") || titleStr.toLowerCase().contains("https://") || titleStr.toLowerCase().contains("ftp://")){
												mandatoryTitleLbl.setText(GL0323);
												mandatoryTitleLbl.setVisible(true);
												isValidate = false;
											}
											
											if(!rightsChkBox.getValue()){
												rightsLbl.getElement().getStyle().setColor("orange");
												isValidate = false;
											}
											if (titleStr == null || titleStr.equalsIgnoreCase("")) {
												mandatoryTitleLbl.setText(GL0173);
												mandatoryTitleLbl.setVisible(true);
												isValidate = false;
											}
											if (categoryStr == null
													|| categoryStr.equalsIgnoreCase("-1")
													|| categoryStr
															.equalsIgnoreCase("Choose a resource format")) {
												mandatoryCategoryLbl.setText(GL0917);
												mandatoryCategoryLbl.setVisible(true);
												isValidate = false;
											}
											
											if(urlStr.indexOf("youtube")!=-1){
												if(youTubeId==null || youTubeId.equalsIgnoreCase("null") || youTubeId.equalsIgnoreCase("")){
													if(!categoryStr.equalsIgnoreCase("Webpage")){
														mandatoryCategoryLbl.setText(GL0927);
														mandatoryCategoryLbl.setVisible(true);
														isValidate = false;
													}else{
														isValidate = true;
													}
												}
											}

											if (isValidate) {
												saveButtonContainer.setVisible(false);
												loadingTextLbl.setVisible(true);
												collectionItemDo.getResource().setTitle(titleStr);
												collectionItemDo.getResource().setDescription(descriptionTxtAera.getText().trim());
												if(categoryStr.contains("Videos")||categoryStr.contains("Interactives")||categoryStr.contains("Images")||categoryStr.contains("Texts"))
												{
													categoryStr=categoryStr.substring(0, categoryStr.length()-1);
													/* if(categoryStr.contains("Image")||categoryStr.contains("Images")){
														 categoryStr="Slide";
													 }*/
												}
												collectionItemDo.getResource().setCategory(categoryStr);
												
												if (thumbnailUrlStr!=null){
													collectionItemDo.getResource().getThumbnails().setUrl(thumbnailUrlStr);
												}else{
													collectionItemDo.getResource().getThumbnails().setUrl(null);
												}
												collectionItemDo.getResource().setUrl(urlStr);
												
												if(!resourceEducationalLabel.getText().equalsIgnoreCase(GL1684)){
													ArrayList<checkboxSelectedDo> arrayOfEducational=new ArrayList<checkboxSelectedDo>();
													checkboxSelectedDo educationalOfObj=new checkboxSelectedDo();
													educationalOfObj.setSelected(true);
													educationalOfObj.setValue(resourceEducationalLabel.getText());
													arrayOfEducational.add(educationalOfObj);
													
													if(collectionOriginalItemDo.getResource().getEducationalUse() != null)
													{
													for(int eduI=0; eduI<collectionOriginalItemDo.getResource().getEducationalUse().size(); eduI++)
													{
														if(!resourceEducationalLabel.getText().equalsIgnoreCase(collectionOriginalItemDo.getResource().getEducationalUse().get(eduI).getValue()))
														{
															checkboxSelectedDo eduUseObjPrevious=new checkboxSelectedDo();
															eduUseObjPrevious.setSelected(false);
															eduUseObjPrevious.setValue(collectionOriginalItemDo.getResource().getEducationalUse().get(eduI).getValue());
															arrayOfEducational.add(eduUseObjPrevious);
														}
													}
													}
													
													
													
													collectionItemDo.getResource().setEducationalUse(arrayOfEducational);
												}
												if(!resourcemomentsOfLearningLabel.getText().equalsIgnoreCase(GL1684)){
													ArrayList<checkboxSelectedDo> arrayOfMoments=new ArrayList<checkboxSelectedDo>();
													checkboxSelectedDo momentsOfObj=new checkboxSelectedDo();
													momentsOfObj.setSelected(true);
													momentsOfObj.setValue(resourcemomentsOfLearningLabel.getText());
													arrayOfMoments.add(momentsOfObj);
													
													if(collectionOriginalItemDo.getResource().getMomentsOfLearning() != null)
													{
													for(int momentsI=0; momentsI<collectionOriginalItemDo.getResource().getMomentsOfLearning().size(); momentsI++)
													{
														if(!resourcemomentsOfLearningLabel.getText().equalsIgnoreCase(collectionOriginalItemDo.getResource().getMomentsOfLearning().get(momentsI).getValue()))
														{
															checkboxSelectedDo momentsOfObjPrevious=new checkboxSelectedDo();
															momentsOfObjPrevious.setSelected(false);
															momentsOfObjPrevious.setValue(collectionOriginalItemDo.getResource().getMomentsOfLearning().get(momentsI).getValue());
															arrayOfMoments.add(momentsOfObjPrevious);
														}
													}
													}
													collectionItemDo.getResource().setMomentsOfLearning(arrayOfMoments);
												}
												collectionItemDo.getResource().setTaxonomySet(standardsDo);
												updateResource(collectionItemDo);
											}
										}
									}
								}
							});
						}
				}
			});
		}
	}

	private class OnEditImageClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			resourceImageUpload();
		}
	}

	public abstract void resourceImageUpload();

	private class TitleKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			mandatoryTitleLbl.setVisible(false);
			if (titleTextBox.getText().length() >= 50) {
				mandatoryTitleLbl.setText(GL0143);
				mandatoryTitleLbl.setVisible(true);
			}
		}
	}

	private class DescriptionKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			descCharcterLimit.setVisible(false);
			if (descriptionTxtAera.getText().length() >= 300) {
				descriptionTxtAera.setText(descriptionTxtAera.getText().trim().substring(0,300));
				descCharcterLimit.setVisible(true);
			}
		}
	}

	@UiHandler("leftArrowLbl")
	void leftArrowClick(ClickEvent event) {
		activeImageIndex--;
		setImageThumbnail();
	}

	@UiHandler("rightArrowLbl")
	void rightArrowClick(ClickEvent event) {
		activeImageIndex++;
		setImageThumbnail();
	}
	@UiHandler("videoResourcePanel")
	void videoResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText(GL0918);
		//resourceCategoryLabel.setStyleName(video.getStyleName());
		categorypanel.setStyleName(video.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("interactiveResourcePanel")
	void interactiveResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText(GL0919);
		categorypanel.setStyleName(interactive.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("websiteResourcePanel")
	void websiteResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText(GL1396);
		categorypanel.setStyleName(website.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("imageResourcePanel")
	void slideResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText(GL1046);
		categorypanel.setStyleName(image.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

	@UiHandler("textResourcePanel")
	void handoutResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText(GL1044);
		categorypanel.setStyleName(texts.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

	@UiHandler("audioResourcePanel")
	void textbookResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText(GL1045);
		categorypanel.setStyleName(audio.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

//	@UiHandler("otherResourcePanel")
//	void lessonResourcePanel(ClickEvent event) {
//		resourceCategoryLabel.setText(MessageProperties.GL1047);
//		categorypanel.setStyleName(other.getStyleName());
//		resourceTypePanel.setVisible(false);
//		resoureDropDownLblOpen = false;
//		mandatoryCategoryLbl.setVisible(false);
//	}
	/*@UiHandler("slideResourcePanel")
	void slideResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Slide");
		categorypanel.setStyleName(slide.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("handoutResourcePanel")
	void handoutResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Handout");
		categorypanel.setStyleName(handout.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("textbookResourcePanel")
	void textbookResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Textbook");
		categorypanel.setStyleName(textbook.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("lessonResourcePanel")
	void lessonResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Lesson");
		categorypanel.setStyleName(lesson.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
//	@UiHandler("questionResourcePanel")
//	void questionResourcePanel(ClickEvent event){
//		resourceCategoryLabel.setText("Question");
//		categorypanel.setStyleName(question.getStyleName());
//		resourceTypePanel.setVisible(false);
//		resoureDropDownLblOpen=false;
//	}
	@UiHandler("examResourcePanel")
	void examResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Exam");
		categorypanel.setStyleName(exam.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}*/
	@UiHandler("resoureDropDownLbl")
	public void dropDownClick(ClickEvent event){
		if(resoureDropDownLblOpen==false){
			resourceTypePanel.setVisible(true);
			resoureDropDownLblOpen=true;
			
		} else {
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}
		
	}

	public void setImageThumbnail() {
		if (activeImageIndex == 0) {
			leftArrowLbl.setVisible(false);
		} else {
			leftArrowLbl.setVisible(true);
		}
		if (activeImageIndex == thumbnailImagesLink.size()) {
			rightArrowLbl.setVisible(false);
		} else {
			rightArrowLbl.setVisible(true);
		}
		setThumbnailImage.setUrl(thumbnailImagesLink.get(activeImageIndex));
		thumbnailUrlStr = thumbnailImagesLink.get(activeImageIndex);
	}

	@UiHandler("refreshLbl")
	void refreshClick(ClickEvent event) {
		
		setImage(collectionItemDo.getResource()
				.getThumbnailUrl(), collectionItemDo.getResource().getCategory());
		
		leftArrowLbl.setVisible(false);
		if (urlTextLbl.getText().contains("youtube")) {
			rightArrowLbl.setVisible(false);
		}
	}

	/*public void clearFields() {
		titleTextBox.setText("");
		descriptionTxtAera.setText("");
		//resourceTypeListBox.setSelectedIndex(0);
		generateImageLbl.setVisible(true);
		setThumbnailImage.setUrl("");
	}
*/
	/*private RegExp urlValidator;
	private RegExp urlPlusTldValidator;
*/
	
	/** 
	 * This method is to get the setThumbnailImage
	 */
	public Image getSetThumbnailImage() {
		return setThumbnailImage;
	}

	/** 
	 * This method is to set the setThumbnailImage
	 */
	public void setSetThumbnailImage(Image setThumbnailImage) {
		this.setThumbnailImage = setThumbnailImage;
	}
	
	/** 
	 * This method is to get the thumbnailUrlStr
	 */
	public String getThumbnailUrlStr() {
		return thumbnailUrlStr;
	}

	/** 
	 * This method is to set the thumbnailUrlStr
	 */
	public void setThumbnailUrlStr(String thumbnailUrlStr) {
		this.thumbnailUrlStr = thumbnailUrlStr;
	}
	
	public void setFileNameWithOutRespUrl(String fileNameWithOutRespUrl ){
		this.fileNameWithOutRespUrl = fileNameWithOutRespUrl;
		rightArrowLbl.setVisible(false);
	}
	
	
	public String getYoutubeVideoId(String youtubeUrl) {

		youtubeUrl=youtubeUrl.replaceAll("feature=player_detailpage&", "");
		youtubeUrl=youtubeUrl.replaceAll("feature=player_embedded&","");


			String pattern = "^.*((youtu.be"+ "\\/)" + "|(v\\/)|(\\/u\\/w\\/)|(embed\\/)|(watch\\?))\\??v?=?([^#\\&\\?]*).*";
			String videoId = null; 
		    try {
		    	RegExp reg = RegExp.compile(pattern, "gi");
		    	MatchResult res = reg.exec(youtubeUrl);
		    	videoId = res.getGroup(7);
		    } catch (Exception e) {
		    	
			}
			return videoId;
	
	}
	public class CheckProfanityInOnBlur implements BlurHandler{
		private TextBox textBox;
		private Label label;
		private TextArea textArea;
		public CheckProfanityInOnBlur(TextBox textBox,TextArea textArea,Label label){
			this.textBox=textBox;
			this.label=label;
			this.textArea=textArea;
		}
		@Override
		public void onBlur(BlurEvent event) {
			Map<String, String> parms = new HashMap<String, String>();
			if(textBox!=null){
				parms.put("text", textBox.getValue());
			}else{
				parms.put("text", textArea.getText());
			}
			addResourceBtn.setEnabled(false);
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {

				@Override
				public void onSuccess(Boolean value) {
					addResourceBtn.setEnabled(true);
					if(textBox!=null){
						isHavingBadWordsInTextbox = value;
						SetStyleForProfanity.SetStyleForProfanityForTextBox(textBox, label, value);
					}else{
						isHavingBadWordsInRichText=value;
						SetStyleForProfanity.SetStyleForProfanityForTextArea(textArea, label, value);
					}
					
				}
			});
		}
	}
	@UiHandler("activityPanel")
	void activityPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_activity_selected");
		resourceEducationalLabel.setText(GL1665);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("handoutPanel")
	void handoutPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_handout_selected");
		resourceEducationalLabel.setText(GL0907);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("homeworkPanel")
	void homeworkPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_homework_selected");
		resourceEducationalLabel.setText(GL1666);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("gamePanel")
	void gamePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_game_selected");
		resourceEducationalLabel.setText(GL1667);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("presentationPanel")
	void presentationPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_presentation_selected");
		resourceEducationalLabel.setText(GL1668);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("referenceMaterialPanel")
	void referenceMaterialPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_reference_material_selected");
		resourceEducationalLabel.setText(GL1669);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("quizPanel")
	void quizPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_quiz_selected");
		resourceEducationalLabel.setText(GL1670);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("curriculumPlanPanel")
	void curriculumPlanPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_curriculum_plan_selected");
		resourceEducationalLabel.setText(GL1671);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("lessonPlanPanel")
	void lessonPlanPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_lesson_plan_selected");
		resourceEducationalLabel.setText(GL1672);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("unitPlanPanel")
	void unitPlanPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_unit_plan_selected");
		resourceEducationalLabel.setText(GL1673);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("projectPlanPanel")
	void projectPlanPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_project_plan_selected");
		resourceEducationalLabel.setText(GL1674);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("readingPanel")
	void readingPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_reading_selected");
		resourceEducationalLabel.setText(GL1675);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("textbookPanel")
	void textbookPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_textbook_selected");
		resourceEducationalLabel.setText(GL0909);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("articlePanel")
	void articlePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_article_selected");
		resourceEducationalLabel.setText(GL1676);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	@UiHandler("bookPanel")
	void bookPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_book_selected");
		resourceEducationalLabel.setText(GL1677);
		educationalUsePanel.setVisible(false);
		educationalDropDownLblOpen = false;
		mandatoryEducationalLbl.setVisible(false);
	}
	
	@UiHandler("educationalDropDownLbl")
	public void educationalDropDownClick(ClickEvent event) {
		if (educationalDropDownLblOpen == false) {
			educationalUsePanel.setVisible(true);
			educationalDropDownLblOpen = true;
		} else {
			educationalUsePanel.setVisible(false);
			educationalDropDownLblOpen = false;
		}
	}
	@UiHandler("preparingTheLearningPanel")
	void preparingTheLearningPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_preparing_the_learning_selected");
		resourcemomentsOfLearningLabel.setText(GL1679);
		momentsOfLearningPanel.setVisible(false);
		momentsOfLearningOpen = false;
		mandatorymomentsOfLearninglLbl.setVisible(false);
	}
	@UiHandler("interactingWithTheTextPanel")
	void interactingWithTheTextPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_interacting_with_the_text_selected");
		resourcemomentsOfLearningLabel.setText(GL1680);
		momentsOfLearningPanel.setVisible(false);
		momentsOfLearningOpen = false;
		mandatorymomentsOfLearninglLbl.setVisible(false);
	}
	@UiHandler("extendingUnderstandingPanel")
	void extendingUnderstandingPanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_extending_Understanding_selected");
		resourcemomentsOfLearningLabel.setText(GL1681);
		momentsOfLearningPanel.setVisible(false);
		momentsOfLearningOpen = false;
		mandatorymomentsOfLearninglLbl.setVisible(false);
	}
	@UiHandler("momentsOfLearningDropDownLbl")
	public void momentsOfLearningDropDownClick(ClickEvent event) {
		if (momentsOfLearningOpen == false) {
			momentsOfLearningPanel.setVisible(true);
			momentsOfLearningOpen = true;
		} else {
			momentsOfLearningPanel.setVisible(false);
			momentsOfLearningOpen = false;
		}
	}
	@Override
	public void onSelection(SelectionEvent<Suggestion> event) {
		
		addStandard(standardSgstBox.getValue(), getCodeIdByCode(standardSgstBox.getValue(), standardSearchDo.getSearchResults()));
		standardSgstBox.setText("");
		standardSuggestOracle.clear();
	}
	/**
	 * Adding new standard for the collection , will check it has more than
	 * fifteen standards
	 * 
	 * @param standard
	 *            which to be added for the collection
	 */
	public void addStandard(String standard, String id) {
		if (standardsPanel.getWidgetCount() <5) {
			if (standard != null && !standard.isEmpty()) {
				CodeDo codeObj=new CodeDo();
				codeObj.setCodeId(Integer.parseInt(id));
				codeObj.setCode(standard);
				standardsDo.add(codeObj);
				standardsPanel.add(createStandardLabel(standard, id, standardCodesMap.get(id)));
			}
		} else {
			standardMaxShow();
			standardSgstBox.setText("");
		}
	}
	public void standardMaxShow() {
		standardSgstBox.addStyleName(CollectionCBundle.INSTANCE.css().standardTxtBox());
		standardMaxMsg.setStyleName(CollectionCBundle.INSTANCE.css().standardMax());
		standardsPanel.addStyleName(CollectionCBundle.INSTANCE.css().floatLeftNeeded());
		new FadeInAndOut(standardMaxMsg.getElement(), 5000, 5000);
	}
	/**
	 * new label is created for the standard which needs to be added
	 * 
	 * @param standardCode
	 *            update standard code
	 * @return instance of {@link DownToolTipWidgetUc}
	 */
	public DownToolTipWidgetUc createStandardLabel(final String standardCode, final String id, String description) {
		CloseLabel closeLabel = new CloseLabel(standardCode) {

			@Override
			public void onCloseLabelClick(ClickEvent event) {
				for(final CodeDo codeObj:standardsDo){
					if(codeObj.getCodeId()==Integer.parseInt(id)){
						//standardsDo.remove(codeObj);
						AppClientFactory.getInjector().getResourceService().deleteTaxonomyResource(collectionItemDo.getResource().getGooruOid(), codeObj.getCodeId(), new SimpleAsyncCallback<Void>() {
							@Override
							public void onSuccess(Void result) {
								CodeDo deletedObj=new CodeDo();
								deletedObj.setCodeId(codeObj.getCodeId());
								deletedStandardsDo.add(deletedObj);
								standardsDo.remove(codeObj);								
							}
						});
						
					}
				}
				this.getParent().removeFromParent();
			}
		};
		return new DownToolTipWidgetUc(closeLabel, description);
	}
	private static String getCodeIdByCode(String code, List<CodeDo> codes) {
		if (codes != null) {
			for (CodeDo codeDo : codes) {
				if (code.equals(codeDo.getCode())) {
					return codeDo.getCodeId() + "";
				}
			}
		}
		return null;
	}
}
