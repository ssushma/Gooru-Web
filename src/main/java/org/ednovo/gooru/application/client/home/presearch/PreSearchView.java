package org.ednovo.gooru.application.client.home.presearch;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.search.SearchFilterDo;
import org.ednovo.gooru.client.SimpleRunAsyncCallback;
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsOfUse;
import org.ednovo.gooru.client.mvp.gsearch.events.UpdateFilterEvent;
import org.ednovo.gooru.client.mvp.gsearch.events.UpdateFilterHandler;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;
import org.ednovo.gooru.client.mvp.home.SampleReportView;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.shared.util.ClientConstants;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 *
 * @fileName : ViewMorePeopleView.java
 *
 * @description :
 *
 *
 * @version : 1.0
 *
 * @date: 16-Jun-2015
 *
 * @Author tumbalam
 *
 * @Reviewer:
 */
public class PreSearchView extends BaseViewWithHandlers<PreSearchUiHandlers> implements IsPreSearchView,ClientConstants {

	private static PreSearchViewUiBinder uiBinder = GWT
			.create(PreSearchViewUiBinder.class);

	interface PreSearchViewUiBinder extends
			UiBinder<Widget, PreSearchView> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	private HandlerRegistration handlerRegistration=null;

	@UiField Button btnStudentSignUp, btnGrades, btnSubjects, btnBrowseContent, btnBrowseStandard, btnGradesCaret, btnSubjectCaret;
	@UiField Anchor ancLogin, lblSampleReports,btnLearnAboutApproach;
	@UiField HTMLPanel panelAlreadyHave, panelGrades, buttonGroup, panelGradeGroup, panelSubjectGroup;
	@UiField Anchor achTerms, achPrivacy,achCopyright;
	@UiField UlPanel ulSubjectPanel;
	@UiField Label lblErrorMessage;

	private final String QUERY = "query";
	private final String FLT_SUBJECTNAME = "flt.subjectName";
	private final String FLT_GRADE = "flt.grade";
	private final String CATEGORY = "category";
	private final String FLT_COLLECTIONTYPE = "flt.collectionType";
	private final String ALL = "all";
	private final String COLLECTION = "collection";

	TreeMap<Integer, Integer> selectedGrades = new TreeMap<Integer, Integer>();
	HashMap<String, String> selectedSubjects = new HashMap<String, String>();

	public PreSearchView() {
		setWidget(uiBinder.createAndBindUi(this));

		setDebugIds();

//		RootPanel.get().addDomHandler(rootHandler, ClickEvent.getType());

		AppClientFactory.getEventBus().addHandler(UpdateFilterEvent.TYPE, updatefilter);

		Event.addNativePreviewHandler(new NativePreviewHandler() {
	        public void onPreviewNativeEvent(NativePreviewEvent event) {
	        	hidePopup(event);
	          }
	    });

	}


	protected void hidePopup(NativePreviewEvent event) {
		if(event.getTypeInt()==Event.ONCLICK){
    		Event nativeEvent = Event.as(event.getNativeEvent());
        	boolean target=eventTargetsPopup(nativeEvent);
        	if(!target)
        	{
        		if (panelGrades !=null && panelGrades.isVisible()){
        			panelGrades.setVisible(false);
        		}
        		if (ulSubjectPanel !=null && ulSubjectPanel.isVisible()){
        			ulSubjectPanel.setVisible(false);
        		}
        	}
    	}
	}

	private boolean eventTargetsPopup(NativeEvent event) {
		EventTarget target = event.getEventTarget();
		if (Element.is(target)) {
			return  panelSubjectGroup.getElement().isOrHasChild(Element.as(target)) || panelGradeGroup.getElement().isOrHasChild(Element.as(target)) || panelGrades.getElement().isOrHasChild(Element.as(target))||ulSubjectPanel.getElement().isOrHasChild(Element.as(target));
		}
		return false;
	}

	/**
	 *
	 * @function setDebugIds
	 *
	 * @created_date : 25-Jun-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) :
	 *
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	private void setDebugIds() {
		btnStudentSignUp.setText(i18n.GL0186());

		StringUtil.setAttributes(btnStudentSignUp.getElement(), "btnStudentSignUp", i18n.GL0186(), i18n.GL0186());
		StringUtil.setAttributes(btnLearnAboutApproach.getElement(), "btnLearnAboutApproach", i18n.GL3315(), i18n.GL3315());

//		btnGradesCaret.getElement().setAttribute("aria-expanded", "false");
//		btnGradesCaret.getElement().setAttribute("data-toggle", "dropdown");

//		btnSubjectCaret.getElement().setAttribute("aria-expanded", "false");
//		btnSubjectCaret.getElement().setAttribute("data-toggle", "dropdown");

		panelGrades.setVisible(false);

		StringUtil.setAttributes(buttonGroup.getElement(), "gooruSearchMainContainer", "", "");
	}

	/* */
	@Override
	public void setButtonVisibility(){
		btnStudentSignUp.setVisible(AppClientFactory.isAnonymous());
		panelAlreadyHave.setVisible(AppClientFactory.isAnonymous());
	}


	/* UI Handlers...*/

	@UiHandler("btnStudentSignUp")
	public void onClickStudentSignUp(ClickEvent event){
		openSignUp();
	}

	@UiHandler("btnLearnAboutApproach")
	public void onClickLearnAboutApproach(ClickEvent event){

	}

	@UiHandler("btnGrades")
	public void onClickGrades(ClickEvent event){
		setGradeVisibility();
		if (ulSubjectPanel.isVisible()){
			setSubjectVisibility();
		}
	}

	@UiHandler("btnGradesCaret")
	public void onClickGradeCaret(ClickEvent event){
		setGradeVisibility();
		if (ulSubjectPanel.isVisible()){
			setSubjectVisibility();
		}
	}

	@UiHandler("btnSubjects")
	public void onClickSubject(ClickEvent event){
		setSubjectVisibility();
		if (panelGrades.isVisible()){
			setGradeVisibility();
		}
	}

	@UiHandler("btnSubjectCaret")
	public void onClickSubjectCaret(ClickEvent event){
		setSubjectVisibility();
		if (panelGrades.isVisible()){
			setGradeVisibility();
		}
	}

	@UiHandler("lblSampleReports")
	public void onClickSampleReports(ClickEvent event){
		GWT.runAsync(new SimpleRunAsyncCallback() {
			@Override
			public void onSuccess() {
				Window.scrollTo(0, 0);
				SampleReportView sampleReportView= new SampleReportView();
			}
		});
	}

	@UiHandler("ancLogin")
	public void onClickLogin(ClickEvent event){
		GWT.runAsync(new SimpleRunAsyncCallback() {
			@Override
			public void onSuccess() {
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
				LoginPopupUc popup = new LoginPopupUc() {
					@Override
					public void onLoginSuccess() {

					}
				};
				popup.setGlassEnabled(true);
				popup.center();
				popup.show();
			}
		});

	}

	@UiHandler("achTerms")
	public void onClickTermsLink(ClickEvent envent){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));

				TermsOfUse termsOfUse = new TermsOfUse(){

					@Override
					public void openParentPopup() {


					}

				};
				termsOfUse.show();
				termsOfUse.center();

			}
		});
	}
	@UiHandler("achPrivacy")
	public void onClickPrivacyLink(ClickEvent envent){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
				TermsAndPolicyVc termsAndPolicyVc = new TermsAndPolicyVc(false) {

					@Override
					public void openParentPopup() {

					}
				};
				termsAndPolicyVc.show();
				termsAndPolicyVc.center();

			}
		});
	}

	@UiHandler("achCopyright")
	public void onClickCopyrightLink(ClickEvent envent){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));

				CopyRightPolicyVc copyRightPolicy = new CopyRightPolicyVc() {

					@Override
					public void openParentPopup() {
						//No need to set.
					}
				};
				copyRightPolicy.center();
				copyRightPolicy.show();
			}
		});
	}

	@UiHandler("btnBrowseStandard")
	public void onClickBrowseStandards(ClickEvent event){
		getUiHandlers().getAddStandards();
	}

	@UiHandler("btnBrowseContent")
	public void onClickBrowseContent(ClickEvent event){
		if (selectedSubjects.size() <= 0 && selectedGrades.size() <= 0){
			lblErrorMessage.setText(i18n.GL3329());
			lblErrorMessage.setVisible(true);
		}else if (selectedSubjects.size() <= 0){
			lblErrorMessage.setText(i18n.GL3331());
			lblErrorMessage.setVisible(true);
		}else if (selectedGrades.size() <= 0){
			lblErrorMessage.setText(i18n.GL3330());
			lblErrorMessage.setVisible(true);
		}else{
			lblErrorMessage.setVisible(false);
			Map<String, String> params = new HashMap<String, String>();
			params.put(FLT_GRADE, getSelectedGrades());
			params.put(FLT_SUBJECTNAME, getSelectedSubjects());
			params.put(CATEGORY,ALL);
			params.put(FLT_COLLECTIONTYPE,COLLECTION);

			params.put(QUERY, "*");
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SEARCH_COLLECTION, params, true);
		}

	}


	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == PreSearchPresenter.GRADES){
			panelGrades.add(content);
		}
	}


	/**
	 *
	 * @function openSignUp
	 *
	 * @created_date : 22-Jun-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) :
	 *
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	private void openSignUp(){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {
				Map<String, String> map = StringUtil.splitQuery(Window.Location
						.getHref());
				map.put("callback", "signup");
				map.put("type", "1");
				AppClientFactory.getPlaceManager().revealPlace(
						AppClientFactory.getCurrentPlaceToken(), map);
			}
		});
	}

	/**
	 *
	 * @function setGradeVisibility
	 *
	 * @created_date : 22-Jun-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) :
	 *
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	private void setGradeVisibility(){
		lblErrorMessage.setVisible(false);

		if (panelGrades.isVisible()){
			panelGrades.getElement().getStyle().setDisplay(Display.NONE);
		}else{
			panelGrades.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		}
	}

	/**
	 *
	 * @function setSubjectVisibility
	 *
	 * @created_date : 23-Jun-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) :
	 *
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	private void setSubjectVisibility(){
		lblErrorMessage.setVisible(false);

		if (ulSubjectPanel.isVisible()){
			ulSubjectPanel.getElement().getStyle().setDisplay(Display.NONE);
		}else{
			ulSubjectPanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		}
	}

	ClickHandler rootHandler= new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			GWT.runAsync(new SimpleRunAsyncCallback() {

				@Override
				public void onSuccess() {

				}
			});
		}
	};


	/* Browse Standards */
	public void OnStandardsClickEvent(Button standardsButtonClicked)
	{
		if(handlerRegistration!=null){
			handlerRegistration.removeHandler();
		}
		handlerRegistration=standardsButtonClicked.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getUiHandlers().setUpdatedStandards();
			}
		});
	}

	@Override
	public void setUpdatedStandards(List<Map<String, String>> standsListArray){
		StringBuffer filterStd= new StringBuffer();
		getUiHandlers().closeStandardsPopup();
		if(standsListArray.size()!=0){
			for(int i=0; i<standsListArray.size(); i++){
				if (i==0){
					filterStd.append(standsListArray.get(i).get("selectedCodeVal"));
				}else{
					filterStd.append(","+standsListArray.get(i).get("selectedCodeVal"));
				}
			}
			callSearch(filterStd.toString());
		}
	}

	/**
	 *
	 * @function callSearch
	 *
	 * @created_date : 23-Jun-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) :
	 *
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	public void callSearch(String stdFilter){
		getUiHandlers().refreshSearch("*", stdFilter);
	}

	/**
	 *
	 */
	UpdateFilterHandler updatefilter = new UpdateFilterHandler() {
		@Override
		public void updateFilters(String filterValue, String addOrRemove) {
			filterValue = filterValue.replaceAll("Grade", "").replaceAll(" " , "");
			int value = 0;
			if (filterValue.equalsIgnoreCase("k")){
				value = 0;
			}else if (filterValue.equalsIgnoreCase("pre-k")){
				value =-1;
			}else if (filterValue.equalsIgnoreCase("HigherEd")){
				value =13;
			}else{
				value = Integer.parseInt(filterValue);
			}

			if("add".equals(addOrRemove)){
				selectedGrades.put(value, value);
			}else{
				selectedGrades.remove(value);
			}
			displaySelectedGrades(addOrRemove);
		}
	};

	/**
	 *
	 * @function displaySelectedGrades
	 *
	 * @created_date : 24-Jun-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) : @param addOrRemove
	 *
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	private void displaySelectedGrades(String addOrRemove) {
		int count=0;
		StringBuffer selectedGrade = new StringBuffer();
		Iterator it = selectedGrades.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Integer,Integer> pair = (Map.Entry<Integer,Integer>)it.next();
	        String pairValue = "";

	        if (pair.getValue() == -1){
	        	pairValue = "Pre-K";
	        }else if (pair.getValue() == 0){
	        	pairValue = "K";
	        }else if (pair.getValue() == 13){
	        	pairValue = "Higher Ed";
	        }else{
	        	pairValue = String.valueOf(pair.getValue());
	        }

	        if (count==0){
	        	selectedGrade.append(pairValue);
	        }else{
	        	selectedGrade.append(", "+pairValue);
	        }
	        count++;
	    }
	    if (selectedGrades.size() > 0){
	    	btnGrades.setText(selectedGrade.toString());
	    }else{
	    	btnGrades.setText(i18n.GL3289());
	    }
	    if ("add".equalsIgnoreCase(addOrRemove)){
	    	if (selectedGrades.size() > 1){
	    		btnGrades.getElement().addClassName("ellipsis");
	    	}
	    }else{
	    	if (selectedGrades.size() <= 2){
	    		btnGrades.getElement().removeClassName("ellipsis");
	    	}
	    }
	}
	/**
	 *
	 * @function renderSubjects
	 *
	 * @created_date : 23-Jun-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) : @param list
	 *
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	public void renderSubjects(List<String> list){
		InlineLabel text=new InlineLabel(i18n.GL3234()+i18n.GL_SPL_SEMICOLON());
		ulSubjectPanel.add(text);
		for (String subject : list) {
			LiPanel liPanel = new LiPanel();
			Anchor lblSubject=new Anchor(subject);
			liPanel.add(lblSubject);
			liPanel.addClickHandler(new SubjectItemClickHandler(subject,liPanel));
			ulSubjectPanel.add(liPanel);
		}
	}

	/**
	 *
	 * @fileName : PreSearchView.java
	 *
	 * @description :
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 23-Jun-2015
	 *
	 * @Author tumbalam
	 *
	 * @Reviewer:
	 */
	public class SubjectItemClickHandler implements ClickHandler{
		String subjectVal;
		LiPanel liPanel;
		SubjectItemClickHandler(String subjectVal,LiPanel liPanel){
			this.subjectVal=subjectVal;
			this.liPanel=liPanel;
		}
		@Override
		public void onClick(ClickEvent event) {
			GWT.runAsync(new RunAsyncCallback() {
				@Override
				public void onFailure(Throwable reason) {
				}
				@Override
				public void onSuccess() {
					if(liPanel.getStyleName().equals("active")){
						liPanel.removeStyleName("active");
						selectedSubjects.remove(subjectVal);
						displaySelectedSbujects("remove");
					}else{
						liPanel.setStyleName("active");
						selectedSubjects.put(subjectVal, subjectVal);
						displaySelectedSbujects("add");
					}


				}

			});
		}
	}
	/**
	 *
	 * @function displaySelectedSbujects
	 *
	 * @created_date : 24-Jun-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) : @param action
	 *
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	private void displaySelectedSbujects(String action) {
		int count=0;
		StringBuffer selectedSubject = new StringBuffer();
		Iterator it = selectedSubjects.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String,String> pair = (Map.Entry<String,String>)it.next();
	        String pairValue = pair.getValue().trim();

	        if (count==0){
	        	selectedSubject.append(pairValue);
	        }else{
	        	selectedSubject.append(", "+pairValue);
	        }
	        count++;
	    }
	    if (selectedSubjects.size() > 0){
	    	btnSubjects.setText(selectedSubject.toString());
	    }else{
	    	btnSubjects.setText(i18n.GL3291());
	    }
	    if ("add".equalsIgnoreCase(action)){
	    	btnSubjects.getElement().addClassName("ellipsis");
	    }else{
	    	if (selectedSubjects.size() <= 2){
	    		btnSubjects.getElement().removeClassName("ellipsis");
	    	}
	    }
	}

	@Override
	public void setSearchFilter(SearchFilterDo searchFilterDo) {
		if(searchFilterDo.getSubjects()!=null && searchFilterDo.getSubjects().size()>=0){
			renderSubjects(searchFilterDo.getSubjects());
		}
	}

	/**
	 *
	 * @function getSelectedGrades
	 *
	 * @created_date : 23-Jun-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) : @return
	 *
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	public String getSelectedGrades(){
		int count=0;
		StringBuffer selectedGrade = new StringBuffer();
		Iterator it = selectedGrades.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Integer,Integer> pair = (Map.Entry<Integer,Integer>)it.next();
	        String pairValue = "";

	        if (pair.getValue() == -1){
	        	pairValue = "Pre-K";
	        }else if (pair.getValue() == 0){
	        	pairValue = "K";
	        }else if (pair.getValue() == 13){
	        	pairValue = "Higher Ed";
	        }else{
	        	pairValue = String.valueOf(pair.getValue());
	        }

	        if (count==0){
	        	selectedGrade.append(pairValue);
	        }else{
	        	selectedGrade.append(","+pairValue);
	        }
	        count++;
	    }
	    return selectedGrade.toString();
	}
	/**
	 *
	 * @function getSelectedSubjects
	 *
	 * @created_date : 23-Jun-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) : @return
	 *
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	public String getSelectedSubjects(){
		int count=0;
		StringBuffer selectedSubject = new StringBuffer();
		Iterator it = selectedSubjects.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String,String> pair = (Map.Entry<String,String>)it.next();
	        String pairValue = pair.getValue().trim();

	        if (count==0){
	        	selectedSubject.append(pairValue);
	        }else{
	        	selectedSubject.append("~~"+pairValue);
	        }
	        count++;
	    }
	    return selectedSubject.toString();
	}

	@Override
	public void setDefaults(){
		lblErrorMessage.setVisible(false);
		btnGrades.setText(i18n.GL3289());
		btnSubjects.setText(i18n.GL3291());
	}

	private void parseSelectedGrades(String selected){

		if ("pre-k".equalsIgnoreCase(selected)){

		}else if ("higher ed".equalsIgnoreCase(selected)){

		}else{
			if ("k".equalsIgnoreCase(selected)){

			}else{
				int grade = Integer.parseInt(selected.replaceAll("Grade", "").trim());
				if (grade <= 5){

				}else if (grade > 5 && grade <= 8){

				}else {

				}
			}
		}

	}

	@Override
	public HTMLPanel getPanelGrades() {
		return panelGrades;
	}

}
