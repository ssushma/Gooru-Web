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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.uc.AppPopUpCentury;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.StandardPreferenceTooltip;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.StandardFo;
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
import com.google.gwt.user.client.ui.Anchor;
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
	@UiField Button addCenturyBtn,cancelBtn;
	
	private AppPopUpCentury appPopUp;
	
	String selectedCodeVal = "";
	Integer selectedCodeId = 0;
	String selectedCodeDesc = "";
	LiPanel liPanel;
	static MessageProperties i18n = GWT.create(MessageProperties.class);
	private static final String TITLE_THIS_COLLECTION = i18n.GL0322();
	final StandardPreferenceTooltip standardPreferenceTooltip=new StandardPreferenceTooltip();
	Map<Long,String> selectedValues=new HashMap<Long,String>();

	@UiTemplate("AddCenturyView.ui.xml")
	interface AddCenturyViewUiBinder extends UiBinder<Widget, AddCenturyView> {
	}
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
				resetPopupHilightedData();
				appPopUp.hide();
				selectedValues.clear();
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
		/*resetPopupHilightedData();*/
		appPopUp.hide();
		selectedValues.clear();
	}
	/**
	 * This method is used for to reset the style for the title widgets
	 */
	private void resetPopupHilightedData() {
		Iterator<Widget> widgets=ulCongitiveAndStrategies.iterator();
		while (widgets.hasNext()){
			final Widget widget = widgets.next();
			if (widget instanceof LiPanel){
				Iterator<Widget> childWidgets=((LiPanel) widget).iterator();
				while (childWidgets.hasNext()){
					final Widget childWidget = childWidgets.next();
					if(childWidget instanceof HTMLPanel){
						((HTMLPanel) childWidget).getWidget(0).removeStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
					}
				}
			}
		}
		Iterator<Widget> widgets1=ulKeyContentKnowledge.iterator();
		while (widgets1.hasNext()){
			final Widget widget = widgets1.next();
			if (widget instanceof LiPanel){
				Iterator<Widget> childWidgets=((LiPanel) widget).iterator();
				while (childWidgets.hasNext()){
					final Widget childWidget = childWidgets.next();
					if(childWidget instanceof HTMLPanel){
						((HTMLPanel) childWidget).getWidget(0).removeStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
					}
				}
			}
		}
		Iterator<Widget> widgets2=ulKeyLearningSkills.iterator();
		while (widgets2.hasNext()){
			final Widget widget = widgets2.next();
			if (widget instanceof LiPanel){
				Iterator<Widget> childWidgets=((LiPanel) widget).iterator();
				while (childWidgets.hasNext()){
					final Widget childWidget = childWidgets.next();
					if(childWidget instanceof HTMLPanel){
						((HTMLPanel) childWidget).getWidget(0).removeStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
					}
				}
			}
		}
	}
	/**
	 * This method will set the data when add popup clicked and removing the 21 century skills values
	 * @param codeList
	 */
	private void setPopupAddHilightData(Map<Long, String> codeList) {
		selectedValues.clear();
		resetPopupHilightedData();	
		if(codeList!=null && codeList.size()>0){
			Iterator<Widget> widgets=ulCongitiveAndStrategies.iterator();
			while (widgets.hasNext()){
				final Widget widget = widgets.next();
				if (widget instanceof LiPanel){
					for (Map.Entry<Long, String> standardFo : codeList.entrySet()){
							if(Long.toString(((LiPanel) widget).getCodeId()).equalsIgnoreCase(standardFo.getKey().toString())){
								selectedValues.put(Long.parseLong(standardFo.getKey()+""), standardFo.getValue());
								Iterator<Widget> childWidgets=((LiPanel) widget).iterator();
								while (childWidgets.hasNext()){
								final Widget childWidget = childWidgets.next();
								if(childWidget instanceof HTMLPanel){
								 ((HTMLPanel) childWidget).getWidget(0).addStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
								}
							}
						}
					}
				}
			}
			Iterator<Widget> widgets1=ulKeyContentKnowledge.iterator();
			while (widgets1.hasNext()){
				final Widget widget = widgets1.next();
				if (widget instanceof LiPanel){
					for (Map.Entry<Long, String> standardFo : codeList.entrySet()){
							if(Long.toString(((LiPanel) widget).getCodeId()).equalsIgnoreCase(standardFo.getKey().toString())){
								selectedValues.put(Long.parseLong(standardFo.getKey()+""), standardFo.getValue());
								Iterator<Widget> childWidgets=((LiPanel) widget).iterator();
								while (childWidgets.hasNext()){
								final Widget childWidget = childWidgets.next();
								if(childWidget instanceof HTMLPanel){
								 ((HTMLPanel) childWidget).getWidget(0).addStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
								}
							}
						}
					}
				}
			}
			Iterator<Widget> widgets2=ulKeyLearningSkills.iterator();
			while (widgets2.hasNext()){
				final Widget widget = widgets2.next();
				if (widget instanceof LiPanel){
					for (Map.Entry<Long, String> standardFo : codeList.entrySet()){
							if(Long.toString(((LiPanel) widget).getCodeId()).equalsIgnoreCase(standardFo.getKey().toString())){
								selectedValues.put(Long.parseLong(standardFo.getKey()+""), standardFo.getValue());
								Iterator<Widget> childWidgets=((LiPanel) widget).iterator();
								while (childWidgets.hasNext()){
								final Widget childWidget = childWidgets.next();
								if(childWidget instanceof HTMLPanel){
								 ((HTMLPanel) childWidget).getWidget(0).addStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
								}
							}
						}
					}
				}
			}
		}
	}
	/**
	 * This method is used for to reset the style for the title widgets
	 */
	private void setPopupEditHilightedData(List<StandardFo> codeList) {
		selectedValues.clear();
		resetPopupHilightedData();
		Iterator<Widget> widgets=ulCongitiveAndStrategies.iterator();
		while (widgets.hasNext()){
			final Widget widget = widgets.next();
			if (widget instanceof LiPanel){
				 for (StandardFo standardFo : codeList) {
						if(Long.toString(((LiPanel) widget).getCodeId()).equalsIgnoreCase(standardFo.getCodeId().toString())){
							selectedValues.put(Long.parseLong(standardFo.getCodeId()+""), standardFo.getLabel());
							Iterator<Widget> childWidgets=((LiPanel) widget).iterator();
							while (childWidgets.hasNext()){
							final Widget childWidget = childWidgets.next();
							if(childWidget instanceof HTMLPanel){
							 ((HTMLPanel) childWidget).getWidget(0).addStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
							}
						}
					}
				}
			}
		}
		Iterator<Widget> widgets1=ulKeyContentKnowledge.iterator();
		while (widgets1.hasNext()){
			final Widget widget = widgets1.next();
			if (widget instanceof LiPanel){
				 for (StandardFo standardFo : codeList) {
						if(Long.toString(((LiPanel) widget).getCodeId()).equalsIgnoreCase(standardFo.getCodeId().toString())){
							selectedValues.put(Long.parseLong(standardFo.getCodeId()+""), standardFo.getLabel());
							Iterator<Widget> childWidgets=((LiPanel) widget).iterator();
							while (childWidgets.hasNext()){
							final Widget childWidget = childWidgets.next();
							if(childWidget instanceof HTMLPanel){
							 ((HTMLPanel) childWidget).getWidget(0).addStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
							}
						}
					}
				}
			}
		}
		Iterator<Widget> widgets2=ulKeyLearningSkills.iterator();
		while (widgets2.hasNext()){
			final Widget widget = widgets2.next();
			if (widget instanceof LiPanel){
				 for (StandardFo standardFo : codeList) {
						if(Long.toString(((LiPanel) widget).getCodeId()).equalsIgnoreCase(standardFo.getCodeId().toString())){
							selectedValues.put(Long.parseLong(standardFo.getCodeId()+""), standardFo.getLabel());
							Iterator<Widget> childWidgets=((LiPanel) widget).iterator();
							while (childWidgets.hasNext()){
							final Widget childWidget = childWidgets.next();
							if(childWidget instanceof HTMLPanel){
							 ((HTMLPanel) childWidget).getWidget(0).addStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
							}
						}
					}
				}
			}
		}
	}

	@UiHandler("addCenturyBtn")
	public void clickOnAddCenturyBtn(ClickEvent clickEvent){
		//Add century event here..
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
	/**
	 * This will set the 21 century data based passed parameters
	 * @param nodeList
	 * @param ulPanel
	 */
	public void setPanelData(List<NodeDo> nodeList,UlPanel ulPanel){
		for (final NodeDo nodeObj : nodeList) {
			liPanel=new LiPanel();
			if(!StringUtil.isEmpty(nodeObj.getCode())){
				liPanel.setCodeId(nodeObj.getCodeId());
				AddCenturyColorPanelWidget addCenturyColorPanelWidget=new AddCenturyColorPanelWidget(nodeObj.getCode());
				liPanel.add(addCenturyColorPanelWidget);
			}
			HTMLPanel pnlTitle=new HTMLPanel("");
			pnlTitle.setStyleName(AddCenturyBundle.INSTANCE.css().listText());
			final InlineLabel titleText=new InlineLabel(nodeObj.getLabel());
			titleText.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if(titleText.getElement().getClassName().contains(AddCenturyBundle.INSTANCE.css().hilighTitleText())){
						titleText.removeStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
						if(selectedValues.containsKey(nodeObj.getCodeId())){
							selectedValues.remove(nodeObj.getCodeId());
						}
					}else{
						selectedValues.put(nodeObj.getCodeId(), nodeObj.getLabel());
						titleText.addStyleName(AddCenturyBundle.INSTANCE.css().hilighTitleText());
					}
				}
			});
			pnlTitle.add(titleText);
			liPanel.add(pnlTitle);
			ulPanel.add(liPanel);
		}
	}
	
	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void onLoad() {
		reset();
	}

	@Override
	public void onUnload() {}

	@Override
	public void hidePopup(){
		appPopUp.hide();
	}

	@Override
	public void reset() {}

	@Override
	public Button getAddBtn() {
		return addCenturyBtn;
	}
	@Override
	public Button getCancelBtn() {
		return cancelBtn;
	}
	@Override
	public Anchor getCloseBtn(){
		return appPopUp.getCloseBtn();
	}
	@Override
	public Map<Long, String> getSelectedValues() {
			return selectedValues;
	}

	@Override
	public void setEditResourceData(List<StandardFo> codeList) {
		setPopupEditHilightedData(codeList);
	}

	@Override
	public void setAddResourceData(Map<Long, String> codeList) {
		setPopupAddHilightData(codeList);
	}
}
