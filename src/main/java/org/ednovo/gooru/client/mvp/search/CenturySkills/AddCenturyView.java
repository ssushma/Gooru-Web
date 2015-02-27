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
package org.ednovo.gooru.client.mvp.search.CenturySkills;

import java.util.List;

import org.ednovo.gooru.client.uc.AppPopUpCentury;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.StandardPreferenceTooltip;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.skils.CenturySkilsDo;
import org.ednovo.gooru.shared.model.skils.NodeDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

/**
 * @author Search Team
 *
 */
public class AddCenturyView extends PopupViewWithUiHandlers<AddCenturyUiHandlers> implements IsAddCenturyView {

	private static AddCenturyViewUiBinder uiBinder = GWT.create(AddCenturyViewUiBinder.class);
	
	@UiField UlPanel ulCongitiveAndStrategies,ulKeyContentKnowledge,ulKeyLearningSkills;
	@UiField InlineLabel spnHewlettDeeperLearningModel,spnConley4Keys,spnP21Framework,spnNationalResearchCenter,spnKeyCongitiveAndStrategiesTitle,spnKeyContentKnowledgeTitle,spnKeyLearningSkillsTitle;
	
	private AppPopUpCentury appPopUp;
	
	String selectedCodeVal = "";
	Integer selectedCodeId = 0;
	String selectedCodeDesc = "";
	
	static MessageProperties i18n = GWT.create(MessageProperties.class);
	private static final String TITLE_THIS_COLLECTION = i18n.GL0322();
	final StandardPreferenceTooltip standardPreferenceTooltip=new StandardPreferenceTooltip();
	

	@UiTemplate("AddCenturyView.ui.xml")
	interface AddCenturyViewUiBinder extends UiBinder<Widget, AddCenturyView> {
	}
	
	@UiField Button cancelBtn,addCenturyBtn;

	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public AddCenturyView(EventBus eventBus) {
		super(eventBus);
		appPopUp = new AppPopUpCentury();
		appPopUp.getCloseBtn().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				appPopUp.hide();
			}
		});
	
		appPopUp.setContent(TITLE_THIS_COLLECTION, uiBinder.createAndBindUi(this));
		appPopUp.setGlassStyleName(AddCenturyBundle.INSTANCE.css().gwtGlassPanel());
		appPopUp.getElement().getStyle().setZIndex(99999);
		AddCenturyBundle.INSTANCE.css().ensureInjected();
		appPopUp.setViewTitle(i18n.GL3121_1());
	}
	
	@UiHandler("cancelBtn")
	public void clickOnCancelBtn(ClickEvent clickEvent){
		appPopUp.hide();
	}
	
	@UiHandler("addCenturyBtn")
	public void clickOnAddCenturyBtn(ClickEvent clickEvent){
		//Add century event here..
	}
	
	@Override
	public void loadData(){
		//API call to load data to be integrated here
	}
	
	@Override
	public void SetData(CenturySkilsDo centurySkilsDo){
		//This will set the top header data in the popup
		if(centurySkilsDo.getModel()!=null && centurySkilsDo.getModel().size()>0){
			spnHewlettDeeperLearningModel.setText(centurySkilsDo.getModel().get(0).getLabel());
			spnConley4Keys.setText(centurySkilsDo.getModel().get(1).getLabel());
			spnP21Framework.setText(centurySkilsDo.getModel().get(2).getLabel());
			spnNationalResearchCenter.setText(centurySkilsDo.getModel().get(3).getLabel());
		}
		//This is used to set popup data
		if(centurySkilsDo.getKey()!=null && centurySkilsDo.getKey().size()>0){
			ulCongitiveAndStrategies.clear();
			if(centurySkilsDo.getKey().get(0)!=null){
				spnKeyCongitiveAndStrategiesTitle.setText(centurySkilsDo.getKey().get(0).getLabel());
				setPanelData(centurySkilsDo.getKey().get(0).getNode(),ulCongitiveAndStrategies);
			}
			ulKeyContentKnowledge.clear();
			if(centurySkilsDo.getKey().get(1)!=null){
				spnKeyContentKnowledgeTitle.setText(centurySkilsDo.getKey().get(1).getLabel());
				setPanelData(centurySkilsDo.getKey().get(1).getNode(),ulKeyContentKnowledge);
			}
			ulKeyLearningSkills.clear();
			if(centurySkilsDo.getKey().get(2)!=null){
				spnKeyLearningSkillsTitle.setText(centurySkilsDo.getKey().get(2).getLabel());
				setPanelData(centurySkilsDo.getKey().get(2).getNode(),ulKeyLearningSkills);
			}
		}
	}
	public void setPanelData(List<NodeDo> nodeList,UlPanel ulPanel){
		for (NodeDo nodeObj : nodeList) {
			LiPanel liPanel=new LiPanel();
			if(!StringUtil.isEmpty(nodeObj.getCode())){
				AddCenturyColorPanelWidget addCenturyColorPanelWidget=new AddCenturyColorPanelWidget(nodeObj.getCode());
				liPanel.add(addCenturyColorPanelWidget);
			}
			HTMLPanel pnlTitle=new HTMLPanel("");
			pnlTitle.setStyleName(AddCenturyBundle.INSTANCE.css().listText());
			InlineLabel title=new InlineLabel(nodeObj.getLabel());
			pnlTitle.add(title);
			liPanel.add(pnlTitle);
			ulPanel.add(liPanel);
		}
	}
	
	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void reset() {
		//reset or clear fields here
	}
	@Override
	public void onLoad() {
		reset();
	}

	@Override
	public void onUnload() {
		
	}

	@Override
	public void hidePopup(){
		appPopUp.hide();
	}
}
