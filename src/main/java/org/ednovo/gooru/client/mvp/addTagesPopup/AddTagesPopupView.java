package org.ednovo.gooru.client.mvp.addTagesPopup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle;
import org.ednovo.gooru.client.uc.AppMultiWordSuggestOracle;
import org.ednovo.gooru.client.uc.AppSuggestBox;
import org.ednovo.gooru.client.uc.CloseLabel;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.StandardsPreferenceOrganizeToolTip;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.ResourceTagsDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.Widget;

public class AddTagesPopupView extends PopupPanel implements SelectionHandler<SuggestOracle.Suggestion>,MessageProperties{

	public PopupPanel appPopUp;
	
	private static AddTagesPopupViewUiBinder uiBinder = GWT
			.create(AddTagesPopupViewUiBinder.class);

	interface AddTagesPopupViewUiBinder extends
			UiBinder<Widget, AddTagesPopupView> {
	}

	@UiField(provided = true)
	AddTagesCBundle res;
	
	@UiField Label lexileHeader,AdsHeader, kindergarden, level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, level11, level12;
	
	@UiField Label headerEducationalUse, handout, homework, game, presentation, refMaterial, quiz, currPlan, lessonPlan, unitPlan, projectPlan, reading, textbook, article, book, activity;
	
	@UiField Button cancelBtn,addTagsBtn,mobileYes,mobileNo;
	
	@UiField HTMLPanel htmlMediaFeatureListContainer;
	
	@UiField ScrollPanel spanelMediaFeaturePanel;
	
	@UiField Label mediaLabel,lblMediaPlaceHolder,lblMediaFeatureArrow;
	
	@UiField Label noAds,modAds,aggreAds,standardMaxMsg,standardsDefaultText;
	
	@UiField Label accessHazard,flashing,flashingHazard,motionSimulation,motionSimulationHazard,sound,soundHazard;
	
	List<String> tagListGlobal = new ArrayList<String>();
	
	@UiField(provided = true)
	AppSuggestBox standardSgstBox;
	
	@UiField FlowPanel standardContainer,standardsPanel;
	private AppMultiWordSuggestOracle standardSuggestOracle;
	private SearchDo<CodeDo> standardSearchDo = new SearchDo<CodeDo>();
	private static final String FLT_CODE_ID = "id";
	List<String> standardPreflist;
	private Map<String, String> standardCodesMap = new HashMap<String, String>();
	String courseCode="";
	boolean isEditResource=true;
	ArrayList<String> standardsDo=new ArrayList<String>();
	Set<CodeDo> deletedStandardsDo=new HashSet<CodeDo>();
	final StandardsPreferenceOrganizeToolTip standardsPreferenceOrganizeToolTip=new StandardsPreferenceOrganizeToolTip();
	private static final String USER_META_ACTIVE_FLAG = "0";

	
	String mediaFeatureStr = GL1767;
	String resourceId=null;


	public AddTagesPopupView(String resourceId) {
		super(false);

		initializeAutoSuggestedBox();
		this.res = AddTagesCBundle.INSTANCE;
		res.css().ensureInjected();
		add(uiBinder.createAndBindUi(this));
		this.resourceId=resourceId;
		this.setGlassEnabled(true);
		this.center();
		Window.enableScrolling(false);
		standardsDefaultText.setText(GL1682);
		CollectionAssignCBundle.INSTANCE.css().ensureInjected();
		spanelMediaFeaturePanel.setVisible(false);
		mediaLabel.setText("Media Feature");
		lblMediaPlaceHolder.setText("Choose a Media Feature Option:");
		lblMediaFeatureArrow.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				OpenMediaFeatureDropdown();
			}
		});
		lblMediaPlaceHolder.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				OpenMediaFeatureDropdown();
			}
		});
		getTagsServiceRequest(resourceId);

		
		List<String> mediaFeatureList = Arrays.asList(mediaFeatureStr.split(","));
		for(int n=0; n<mediaFeatureList.size(); n++)
		{
				String mediaTitleVal = mediaFeatureList.get(n);
				
				final Label titleLabel = new Label(mediaTitleVal);
				titleLabel.setStyleName(CollectionAssignCBundle.INSTANCE.css().classpageTitleText());
				titleLabel.getElement().setAttribute("id", mediaTitleVal);
				//Set Click event for title
				titleLabel.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {		
						String optionSelected = titleLabel.getElement().getId();
						lblMediaPlaceHolder.setText(optionSelected);
						spanelMediaFeaturePanel.setVisible(false);
						lblMediaPlaceHolder.getElement().setId(titleLabel.getElement().getId());
						lblMediaPlaceHolder.setStyleName(CollectionAssignCBundle.INSTANCE.css().selectedClasspageText());
						lblMediaPlaceHolder.setText(optionSelected);
					}
				});
				htmlMediaFeatureListContainer.add(titleLabel);
		}
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
	public void initializeAutoSuggestedBox(){
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
		standardSgstBox.addSelectionHandler(this);
		BlurHandler blurHandler=new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if(standardsPreferenceOrganizeToolTip.isShowing())
				standardsPreferenceOrganizeToolTip.show();
			}
		};
		standardSgstBox.addDomHandler(blurHandler, BlurEvent.getType());
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
				standardsDo.add(standard);
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
				for(final String codeObj:standardsDo){
					if(codeObj==standardCode){
						String standardDelete="[\"" +standardsDefaultText.getText()+"  :"+codeObj+"\"]";
						standardsDo.remove(codeObj);
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
	@UiHandler("kindergarden")
	public void onKindergardenClick(ClickEvent click){
		if(kindergarden.getStyleName().toString().contains("selected"))
		{
			kindergarden.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			kindergarden.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level1")
	public void onLevel1Click(ClickEvent click){
		if(level1.getStyleName().toString().contains("selected"))
		{
			level1.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level1.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level2")
	public void onLevel2Click(ClickEvent click){
		if(level2.getStyleName().toString().contains("selected"))
		{
			level2.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level2.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level3")
	public void onLevel3Click(ClickEvent click){
		if(level3.getStyleName().toString().contains("selected"))
		{
			level3.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level3.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level4")
	public void onLevel4Click(ClickEvent click){
		if(level4.getStyleName().toString().contains("selected"))
		{
			level4.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level4.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level5")
	public void onLevel5Click(ClickEvent click){
		if(level5.getStyleName().toString().contains("selected"))
		{
			level5.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level5.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level6")
	public void onLevel6Click(ClickEvent click){
		if(level6.getStyleName().toString().contains("selected"))
		{
			level6.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level6.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level7")
	public void onLevel7Click(ClickEvent click){
		if(level7.getStyleName().toString().contains("selected"))
		{
			level7.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level7.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level8")
	public void onLevel8Click(ClickEvent click){
		if(level8.getStyleName().toString().contains("selected"))
		{
			level8.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level8.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level9")
	public void onLevel9Click(ClickEvent click){
		if(level9.getStyleName().toString().contains("selected"))
		{
			level9.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level9.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level10")
	public void onLevel10Click(ClickEvent click){
		if(level10.getStyleName().toString().contains("selected"))
		{
			level10.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level10.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level11")
	public void onLevel11Click(ClickEvent click){
		if(level11.getStyleName().toString().contains("selected"))
		{
			level11.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level11.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level12")
	public void onLevel12Click(ClickEvent click){
		if(level12.getStyleName().toString().contains("selected"))
		{
			level12.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level12.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	public void removeClassNameForAllEducationalUse(){
		 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
		 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
	}
	
	@UiHandler("activity")
	public void onactivityClick(ClickEvent click){
		if(activity.getStyleName().toString().contains("selected"))
		{
			activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		 else if (handout.getStyleName().toString().contains("selected")
						|| homework.getStyleName().toString().contains("selected")
						|| game.getStyleName().toString().contains("selected")
						|| presentation.getStyleName().toString().contains("selected")
						|| refMaterial.getStyleName().toString().contains("selected")
						|| quiz.getStyleName().toString().contains("selected")
						|| currPlan.getStyleName().toString().contains("selected")
						|| lessonPlan.getStyleName().toString().contains("selected")
						|| unitPlan.getStyleName().toString().contains("selected")
						|| projectPlan.getStyleName().toString().contains("selected")
						|| reading.getStyleName().toString().contains("selected")
						|| textbook.getStyleName().toString().contains("selected")
						|| article.getStyleName().toString().contains("selected")
						|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			 activity.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			activity.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("handout")
	public void onhandoutClick(ClickEvent click){
		if(handout.getStyleName().toString().contains("selected"))
		{
			handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		 else if (activity.getStyleName().toString().contains("selected")
					|| homework.getStyleName().toString().contains("selected")
					|| game.getStyleName().toString().contains("selected")
					|| presentation.getStyleName().toString().contains("selected")
					|| refMaterial.getStyleName().toString().contains("selected")
					|| quiz.getStyleName().toString().contains("selected")
					|| currPlan.getStyleName().toString().contains("selected")
					|| lessonPlan.getStyleName().toString().contains("selected")
					|| unitPlan.getStyleName().toString().contains("selected")
					|| projectPlan.getStyleName().toString().contains("selected")
					|| reading.getStyleName().toString().contains("selected")
					|| textbook.getStyleName().toString().contains("selected")
					|| article.getStyleName().toString().contains("selected")
					|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			 handout.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		 }
		else
		{
			handout.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("homework")
	public void onhomeworkClick(ClickEvent click){
		if(homework.getStyleName().toString().contains("selected"))
		{
			homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		 else if (activity.getStyleName().toString().contains("selected")
					|| handout.getStyleName().toString().contains("selected")
					|| game.getStyleName().toString().contains("selected")
					|| presentation.getStyleName().toString().contains("selected")
					|| refMaterial.getStyleName().toString().contains("selected")
					|| quiz.getStyleName().toString().contains("selected")
					|| currPlan.getStyleName().toString().contains("selected")
					|| lessonPlan.getStyleName().toString().contains("selected")
					|| unitPlan.getStyleName().toString().contains("selected")
					|| projectPlan.getStyleName().toString().contains("selected")
					|| reading.getStyleName().toString().contains("selected")
					|| textbook.getStyleName().toString().contains("selected")
					|| article.getStyleName().toString().contains("selected")
					|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
		     homework.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		 }
		else
		{
			homework.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("game")
	public void ongameClick(ClickEvent click){
		if(game.getStyleName().toString().contains("selected"))
		{
			game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		 else if (activity.getStyleName().toString().contains("selected")
					|| handout.getStyleName().toString().contains("selected")
					|| homework.getStyleName().toString().contains("selected")
					|| presentation.getStyleName().toString().contains("selected")
					|| refMaterial.getStyleName().toString().contains("selected")
					|| quiz.getStyleName().toString().contains("selected")
					|| currPlan.getStyleName().toString().contains("selected")
					|| lessonPlan.getStyleName().toString().contains("selected")
					|| unitPlan.getStyleName().toString().contains("selected")
					|| projectPlan.getStyleName().toString().contains("selected")
					|| reading.getStyleName().toString().contains("selected")
					|| textbook.getStyleName().toString().contains("selected")
					|| article.getStyleName().toString().contains("selected")
					|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
		 game.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		 }
		else
		{
			game.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("presentation")
	public void onpresentationClick(ClickEvent click){
		if(presentation.getStyleName().toString().contains("selected"))
		{
			presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		 else if (activity.getStyleName().toString().contains("selected")
					|| handout.getStyleName().toString().contains("selected")
					|| homework.getStyleName().toString().contains("selected")
					|| game.getStyleName().toString().contains("selected")
					|| refMaterial.getStyleName().toString().contains("selected")
					|| quiz.getStyleName().toString().contains("selected")
					|| currPlan.getStyleName().toString().contains("selected")
					|| lessonPlan.getStyleName().toString().contains("selected")
					|| unitPlan.getStyleName().toString().contains("selected")
					|| projectPlan.getStyleName().toString().contains("selected")
					|| reading.getStyleName().toString().contains("selected")
					|| textbook.getStyleName().toString().contains("selected")
					|| article.getStyleName().toString().contains("selected")
					|| book.getStyleName().toString().contains("selected")) {
			
	     removeClassNameForAllEducationalUse();
		 presentation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		 }
		else
		{
			presentation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("refMaterial")
	public void onrefMaterialClick(ClickEvent click){
		if(refMaterial.getStyleName().toString().contains("selected"))
		{
			refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
					|| handout.getStyleName().toString().contains("selected")
					|| homework.getStyleName().toString().contains("selected")
					|| game.getStyleName().toString().contains("selected")
					|| presentation.getStyleName().toString().contains("selected")
					|| quiz.getStyleName().toString().contains("selected")
					|| currPlan.getStyleName().toString().contains("selected")
					|| lessonPlan.getStyleName().toString().contains("selected")
					|| unitPlan.getStyleName().toString().contains("selected")
					|| projectPlan.getStyleName().toString().contains("selected")
					|| reading.getStyleName().toString().contains("selected")
					|| textbook.getStyleName().toString().contains("selected")
					|| article.getStyleName().toString().contains("selected")
					|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
		 refMaterial.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		 }
		else
		{
			refMaterial.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("quiz")
	public void onquizClick(ClickEvent click){
		if(quiz.getStyleName().toString().contains("selected"))
		{
			quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			 quiz.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			quiz.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("currPlan")
	public void oncurrPlanClick(ClickEvent click){
		if(currPlan.getStyleName().toString().contains("selected"))
		{
			currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			 currPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			currPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("lessonPlan")
	public void onlessonPlanClick(ClickEvent click){
		if(lessonPlan.getStyleName().toString().contains("selected"))
		{
			lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			 lessonPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			lessonPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("unitPlan")
	public void onunitPlanClick(ClickEvent click){
		if(unitPlan.getStyleName().toString().contains("selected"))
		{
			unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			 unitPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			unitPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("projectPlan")
	public void onprojectPlanClick(ClickEvent click){
		if(projectPlan.getStyleName().toString().contains("selected"))
		{
			projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());

		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			 projectPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			projectPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("reading")
	public void onreadingClick(ClickEvent click){
		if(reading.getStyleName().toString().contains("selected"))
		{
			reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			 reading.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			reading.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("textbook")
	public void ontextbookClick(ClickEvent click){
		if(textbook.getStyleName().toString().contains("selected"))
		{
			textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			textbook.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			textbook.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("article")
	public void onarticleClick(ClickEvent click){
		if(article.getStyleName().toString().contains("selected"))
		{
			article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			 article.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			article.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("book")
	public void onbookClick(ClickEvent click){
		if(book.getStyleName().toString().contains("selected"))
		{
			book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")) {
			 removeClassNameForAllEducationalUse();
			 book.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			book.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	public void closeFunction()
	{
		this.hide();
		if(standardsPreferenceOrganizeToolTip.isShowing())
			standardsPreferenceOrganizeToolTip.hide();
		Window.enableScrolling(true);
	}
	
	@UiHandler("cancelBtn")
	public void onCancelClick(ClickEvent click)
	{
		this.hide();
		if(standardsPreferenceOrganizeToolTip.isShowing())
			standardsPreferenceOrganizeToolTip.hide();
		Window.enableScrolling(true);
	}
	
	private void OpenMediaFeatureDropdown() {
		if (spanelMediaFeaturePanel.isVisible()){
			spanelMediaFeaturePanel.setVisible(false);
		}else{
			spanelMediaFeaturePanel.setVisible(true);
		}
	}
	public void removeClassNameForAllAds(){
		noAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		modAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		aggreAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
	}
	@UiHandler("noAds")
	public void onnoAdsClick(ClickEvent click){
		if(noAds.getStyleName().toString().contains("selected"))
		{
			noAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(modAds.getStyleName().toString().contains("selected") || aggreAds.getStyleName().toString().contains("selected"))
		{
			removeClassNameForAllAds();
			noAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			noAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("modAds")
	public void onmodAdsClick(ClickEvent click){
		if(modAds.getStyleName().toString().contains("selected"))
		{
			modAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(noAds.getStyleName().toString().contains("selected") || aggreAds.getStyleName().toString().contains("selected"))
		{
			removeClassNameForAllAds();
			modAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());

		}
		else
		{
			modAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("aggreAds")
	public void onaggreAdsClick(ClickEvent click){
		if(aggreAds.getStyleName().toString().contains("selected"))
		{
			aggreAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(noAds.getStyleName().toString().contains("selected") || modAds.getStyleName().toString().contains("selected"))
		{
			removeClassNameForAllAds();
			aggreAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			aggreAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());		
		}
	}
	
	public void removeClassNamesForAllAccessHazard(){
		flashing.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		soundHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		sound.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		flashingHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		motionSimulation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		motionSimulationHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
	}
	@UiHandler("flashing")
	public void onflashingClick(ClickEvent click){
		if(flashing.getStyleName().toString().contains("select"))
		{
			flashing.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(soundHazard.getStyleName().toString().contains("select") ||sound.getStyleName().toString().contains("select") ||motionSimulationHazard.getStyleName().toString().contains("select") || flashingHazard.getStyleName().toString().contains("select") || motionSimulation.getStyleName().toString().contains("select"))
		{
			removeClassNamesForAllAccessHazard();
			flashing.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			flashing.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	@UiHandler("flashingHazard")
	public void onflashingHazardClick(ClickEvent click){
		if(flashingHazard.getStyleName().toString().contains("select"))
		{
			flashingHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(soundHazard.getStyleName().toString().contains("select") ||sound.getStyleName().toString().contains("select") ||motionSimulationHazard.getStyleName().toString().contains("select") || flashing.getStyleName().toString().contains("select") || motionSimulation.getStyleName().toString().contains("select"))
		{
			removeClassNamesForAllAccessHazard();
			flashingHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			flashingHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	@UiHandler("motionSimulation")
	public void onmotionSimulationClick(ClickEvent click){
		if(motionSimulation.getStyleName().toString().contains("select"))
		{
			motionSimulation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(soundHazard.getStyleName().toString().contains("select") ||sound.getStyleName().toString().contains("select") ||motionSimulationHazard.getStyleName().toString().contains("select") || flashing.getStyleName().toString().contains("select") || flashingHazard.getStyleName().toString().contains("select"))
		{
			removeClassNamesForAllAccessHazard();
			motionSimulation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			motionSimulation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	@UiHandler("motionSimulationHazard")
	public void onmotionSimulationHazardClick(ClickEvent click){
		if(motionSimulationHazard.getStyleName().toString().contains("select"))
		{
			motionSimulationHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(soundHazard.getStyleName().toString().contains("select") ||sound.getStyleName().toString().contains("select") ||motionSimulation.getStyleName().toString().contains("select") || flashing.getStyleName().toString().contains("select") || flashingHazard.getStyleName().toString().contains("select"))
		{
			removeClassNamesForAllAccessHazard();
			motionSimulationHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			motionSimulationHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	@UiHandler("sound")
	public void onsoundClick(ClickEvent click){
		if(sound.getStyleName().toString().contains("select"))
		{
			sound.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(soundHazard.getStyleName().toString().contains("select") ||motionSimulationHazard.getStyleName().toString().contains("select") ||motionSimulation.getStyleName().toString().contains("select") || flashing.getStyleName().toString().contains("select") || flashingHazard.getStyleName().toString().contains("select"))
		{
			removeClassNamesForAllAccessHazard();
			sound.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			sound.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	@UiHandler("soundHazard")
	public void onsoundHazardClick(ClickEvent click){
		if(soundHazard.getStyleName().toString().contains("select"))
		{
			soundHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(sound.getStyleName().toString().contains("select") ||motionSimulationHazard.getStyleName().toString().contains("select") ||motionSimulation.getStyleName().toString().contains("select") || flashing.getStyleName().toString().contains("select") || flashingHazard.getStyleName().toString().contains("select"))
		{
			removeClassNamesForAllAccessHazard();
			soundHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			soundHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	
	@UiHandler("addTagsBtn")
	public void onaddTagsBtnClick(ClickEvent click)
	{
		String frameTagsStr = "";
		String educationStr = "";
		String adsStr = "";
		String hazardStr = "";
		List<String> tagList = new ArrayList<String>();
		educationStr = setEducationalUseString();
		if(!educationStr.isEmpty())
		{
			frameTagsStr = educationStr;
			tagList.add("\"" + frameTagsStr +"\"");
		}
		String[] lexileMainarr = setLexileLevel();
		if(lexileMainarr != null)
		{
			for(int i=0;i<lexileMainarr.length;i++)
			{
				tagList.add("\"" + lexileMainarr[i].toString() +"\"");
			}
		}
		adsStr = setAdsString();
		
		if(!adsStr.isEmpty())
		{
			tagList.add("\"" + adsStr +"\"");
		}
		
		hazardStr = setAccessHazards();
		
		if(!hazardStr.isEmpty())
		{
			tagList.add("\"" + hazardStr +"\"");
		}
		
		for(final String codeObj:standardsDo){
			tagList.add("\"" +standardsDefaultText.getText()+"  :"+codeObj+"\"");
		}
		
		if(!lblMediaPlaceHolder.getText().equalsIgnoreCase("Choose a Media Feature Option:"))
		{
			tagList.add("\"" +mediaLabel.getText()+" : "+lblMediaPlaceHolder.getText() +"\"");
		}
		
		if(mobileYes.getStyleName().contains(AddTagesCBundle.INSTANCE.css().OffButtonsActive()))
		{
			tagList.add("\"" +"Mobile Friendly"+" : "+mobileYes.getText() +"\"");
		}
		else if(mobileNo.getStyleName().contains(AddTagesCBundle.INSTANCE.css().OffButtonsActive()))
		{
			tagList.add("\"" +"Mobile Friendly"+" : "+mobileNo.getText() +"\"");
		}
		
		deleteTagsServiceRequest(tagListGlobal.toString(), tagList.toString());
		

	}
	
	public void addTagsServiceRequest(String frameTagsStr, String resourceId)
	{
		
		AppClientFactory.getInjector().getResourceService().addTagsToResource(resourceId, frameTagsStr, new SimpleAsyncCallback<List<ResourceTagsDo>>() {
			@Override
			public void onSuccess(List<ResourceTagsDo> result) {
			//	bindObjectsToUI(result);
				closeFunction();
			}
		});
	
	}
	public void deleteTagsServiceRequest(String frameTagsStr, final String addingNewTags)
	{
		AppClientFactory.getInjector().getResourceService().deleteTagsServiceRequest(resourceId, frameTagsStr, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				addTagsServiceRequest(addingNewTags.toString(), resourceId);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	public void getTagsServiceRequest(String resourceId)
	{
		AppClientFactory.getInjector().getResourceService().getTagsToResource(resourceId, new SimpleAsyncCallback<List<ResourceTagsDo>>() {
			@Override
			public void onSuccess(List<ResourceTagsDo> result) {
				bindObjectsToUI(result);
			}
		});
	}
	public void bindObjectsToUI(List<ResourceTagsDo> resultResourceTags)
	{
		tagListGlobal.clear();
		for(int objVal=0;objVal<resultResourceTags.size();objVal++)
		{
			tagListGlobal.add("\"" +resultResourceTags.get(objVal).getLabel() +"\"");
			if(resultResourceTags.get(objVal).getLabel().contains(headerEducationalUse.getText()))
			{
				setEducationalObjectVal(resultResourceTags.get(objVal).getLabel());
			}
			if(resultResourceTags.get(objVal).getLabel().contains(lexileHeader.getText()))
			{
				setLexileObjectVal(resultResourceTags.get(objVal).getLabel());
			}
			if(resultResourceTags.get(objVal).getLabel().contains(AdsHeader.getText()))
			{
				setAdsObjectVal(resultResourceTags.get(objVal).getLabel());
			}
			if(resultResourceTags.get(objVal).getLabel().contains(accessHazard.getText()))
			{
				setAccessHazardObjectVal(resultResourceTags.get(objVal).getLabel());
			}
			if(resultResourceTags.get(objVal).getLabel().contains(standardsDefaultText.getText()))
			{
				setStandardObjectVal(resultResourceTags.get(objVal).getLabel());
			}
			if(resultResourceTags.get(objVal).getLabel().contains(mediaLabel.getText()))
			{
				setMediaFeatureObjectVal(resultResourceTags.get(objVal).getLabel());
			}
			if(resultResourceTags.get(objVal).getLabel().contains("Mobile Friendly"))
			{
				setMobileFriendlyObjectVal(resultResourceTags.get(objVal).getLabel());
			}
		}
	}
	public void setMobileFriendlyObjectVal(String mobileFriendlyVal)
	{
		if(mobileFriendlyVal.contains(mobileYes.getText()))
		{
			mobileYes.getElement().setClassName(AddTagesCBundle.INSTANCE.css().OffButtonsActive());
			mobileNo.getElement().setClassName(AddTagesCBundle.INSTANCE.css().OnButtonDeActive());
		}
		else if(mobileFriendlyVal.contains(mobileNo.getText()))
		{
			mobileNo.getElement().setClassName(AddTagesCBundle.INSTANCE.css().OffButtonsActive());
			mobileYes.getElement().setClassName(AddTagesCBundle.INSTANCE.css().OnButtonDeActive());
		}
	}
	public void setMediaFeatureObjectVal(String mediaFeatureVal)
	{
		if(mediaFeatureVal != null)
		{
			mediaFeatureVal = mediaFeatureVal.replace(mediaLabel.getText()+" : ", "");
			lblMediaPlaceHolder.setText(mediaFeatureVal);
		}
	}
	public void setStandardObjectVal(String standardStr)
	{
		String[] standardArray=standardStr.split(":");
		standardsDo.add(standardArray[1]);
		addStandard(standardArray[1], "0");
	}
	public void setAccessHazardObjectVal(String accessHazardStr)
	{
		if(accessHazardStr.contains(flashingHazard.getText()))
		{
			flashingHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(accessHazardStr.contains(flashing.getText()))
		{
			flashing.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(accessHazardStr.contains(motionSimulation.getText()))
		{
			motionSimulation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(accessHazardStr.contains(motionSimulationHazard.getText()))
		{
			motionSimulationHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(accessHazardStr.contains(sound.getText()))
		{
			sound.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(accessHazardStr.contains(soundHazard.getText()))
		{
			soundHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	public void setAdsObjectVal(String adsStr)
	{
		if(adsStr.contains(noAds.getText()))
		{
			noAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(adsStr.contains(modAds.getText()))
		{
			modAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(adsStr.contains(aggreAds.getText()))
		{
			aggreAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	public void setLexileObjectVal(String lexileStr)
	{
		if(lexileStr.contains(kindergarden.getText()))
		{
			kindergarden.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level1.getText()))
		{
			level1.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level2.getText()))
		{
			level2.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level3.getText()))
		{
			level3.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level4.getText()))
		{
			level4.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level5.getText()))
		{
			level5.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level6.getText()))
		{
			level6.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level7.getText()))
		{
			level7.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level8.getText()))
		{
			level8.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level9.getText()))
		{
			level9.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level10.getText()))
		{
			level10.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level11.getText()))
		{
			level11.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(lexileStr.contains(level12.getText()))
		{
			level12.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	
	public void setEducationalObjectVal(String educationalStr)
	{
		if(educationalStr.contains(activity.getText()))
		{
			activity.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(handout.getText()))
		{
			handout.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());	
		}
		else if(educationalStr .contains(homework.getText()))
		{
			homework.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if( educationalStr.contains(game.getText()))
		{
			game.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(presentation.getText()))
		{
			presentation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(refMaterial.getText()))
		{
			refMaterial.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(quiz.getText()))
		{
			quiz.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(currPlan.getText()))
		{
			currPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(lessonPlan.getText()))
		{
			lessonPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(unitPlan.getText()))
		{
			unitPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(projectPlan.getText()))
		{
			projectPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(reading.getText()))
		{
			reading.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(textbook.getText()))
		{
			textbook.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(article.getText()))
		{
			article.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(educationalStr.contains(book.getText()))
		{
			book.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	
	public String setAdsString()
	{
		String adsStr = "";
		
		if(noAds.getElement().getClassName().contains("selected"))
		{
			adsStr = AdsHeader.getText()+" : "+noAds.getText();
		}
		else if(modAds.getElement().getClassName().contains("selected"))
		{
			adsStr = AdsHeader.getText()+" : "+modAds.getText();
		}
		else if(aggreAds.getElement().getClassName().contains("selected"))
		{
			adsStr = AdsHeader.getText()+" : "+aggreAds.getText();
		}
		
		return adsStr;
	}
	
	public String setAccessHazards()
	{
		String hazardsStr = "";
		
		if(flashing.getElement().getClassName().contains("select"))
		{
			hazardsStr = accessHazard.getText()+" : "+flashing.getText();
		}
		else if(flashingHazard.getElement().getClassName().contains("select"))
		{
			hazardsStr = accessHazard.getText()+" : "+flashingHazard.getText();
		}
		else if(motionSimulation.getElement().getClassName().contains("select"))
		{
			hazardsStr = accessHazard.getText()+" : "+motionSimulation.getText();
		}
		else if(motionSimulationHazard.getElement().getClassName().contains("select"))
		{
			hazardsStr = accessHazard.getText()+" : "+motionSimulationHazard.getText();
		}
		else if(sound.getElement().getClassName().contains("select"))
		{
			hazardsStr = accessHazard.getText()+" : "+sound.getText();
		}
		else if(soundHazard.getElement().getClassName().contains("select"))
		{
			hazardsStr = accessHazard.getText()+" : "+soundHazard.getText();
		}
		
		return hazardsStr;
	}
	
	public String setEducationalUseString()
	{
		String educationalUse = "";
		if(activity.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + activity.getText();
		}
		else if(handout.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + handout.getText();	
		}
		else if(homework.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + homework.getText();	
		}
		else if(game.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + game.getText();
		}
		else if(presentation.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + presentation.getText();
		}
		else if(refMaterial.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + refMaterial.getText();
		}
		else if(quiz.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + quiz.getText();
		}
		else if(currPlan.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + currPlan.getText();
		}
		else if(lessonPlan.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + lessonPlan.getText();
		}
		else if(unitPlan.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + unitPlan.getText();
		}
		else if(projectPlan.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + projectPlan.getText();
		}
		else if(reading.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + reading.getText();
		}
		else if(textbook.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + textbook.getText();
		}
		else if(article.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + article.getText();
		}
		else if(book.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + book.getText();
		}
		return educationalUse;
	}
	
	public String[] setLexileLevel()
	{
		String[] lexileLevelArr = null;
		List<String> lexileSelectedOptions = new ArrayList<String>();
		
		if(kindergarden.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + kindergarden.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level1.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level1.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level2.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level2.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level3.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level3.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level4.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level4.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level5.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level5.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level6.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level6.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level7.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level7.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level8.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level8.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level9.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level9.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level10.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level10.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level11.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level11.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level12.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level12.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		lexileLevelArr = lexileSelectedOptions.toArray(new String[lexileSelectedOptions.size()]);
		return lexileLevelArr;
		
	}
	
	@UiHandler("mobileYes")
	public void onmobileYesClick(ClickEvent click)
	{
		mobileYes.getElement().setClassName(AddTagesCBundle.INSTANCE.css().OffButtonsActive());
		mobileNo.getElement().setClassName(AddTagesCBundle.INSTANCE.css().OnButtonDeActive());
	}
	
	@UiHandler("mobileNo")
	public void onmobileNoClick(ClickEvent click)
	{
		mobileNo.getElement().setClassName(AddTagesCBundle.INSTANCE.css().OffButtonsActive());
		mobileYes.getElement().setClassName(AddTagesCBundle.INSTANCE.css().OnButtonDeActive());
	}
	
	
	
	@Override
	public Widget asWidget() {
		
		return null;
	}
}
