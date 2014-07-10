/**
 * 
 */
package org.ednovo.gooru.client.mvp.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.StandardSgItemVc;
import org.ednovo.gooru.client.uc.ToolTipPopUp;
import org.ednovo.gooru.shared.i18n.CopyOfMessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.StandardFo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.util.InfoUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author ibc
 *
 */
public class CollectionInfo extends Composite {

	private static CollectionInfoUiBinder uiBinder = GWT
			.create(CollectionInfoUiBinder.class);
	
	private static CopyOfMessageProperties i18n = GWT.create(CopyOfMessageProperties.class);

	interface CollectionInfoUiBinder extends UiBinder<Widget, CollectionInfo> {
	}

	@UiField 
	Label lblGradeTitle, gradesText;

	@UiField
    Label lblStandrads;

	@UiField
    Label lblStandardsText;

	@UiField
	Label lblLanguage,lblLearningSkills,lblAudience,lblAudienceValue;

	@UiField
	Label lblLanguageText;

	@UiField
	Label lblDepthKnowledge,lblOer,lblOerValue,lblInstructionalValue,lblInstructional;

	@UiField
	HTMLPanel panelStandrads,panelDesc,loadingImagePanel,panelOer;

	@UiField
	HTMLPanel gradesPanel,panelAudience,panelInstructional;

	@UiField
	HTMLPanel dKnowledgePanel,learningSkillsMainPanel;

	@UiField
	HTMLPanel dKnowledgeType,learningSkillsPanel;

	@UiField
	FlowPanel standardsInfoConatiner;

	CollectionSearchResultDo collectionSearchResultDo;

	CollectionDo collectionDo;

	ToolTipPopUp toolTip ; 

	public static final String STANDARD_CODE = "code";
	public static final String STANDARD_DESCRIPTION = "description";

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public CollectionInfo() {
		initWidget(uiBinder.createAndBindUi(this));
		setStaticText();
	}


	private void setStaticText() {
		lblGradeTitle.setText(i18n.GL0325()+i18n.GL_SPL_SEMICOLON());
		lblStandrads.setText(i18n.GL0575()+i18n.GL_SPL_SEMICOLON());
		lblLanguage.setText(i18n.GL1721()+i18n.GL_SPL_SEMICOLON());
		lblDepthKnowledge.setText(i18n.GL1693()+i18n.GL_SPL_SEMICOLON());
		lblLearningSkills.setText(i18n.GL1722()+i18n.GL_SPL_SEMICOLON());
		lblAudience.setText(i18n.GL1723()+i18n.GL_SPL_SEMICOLON());
		lblInstructional.setText(i18n.GL1724()+i18n.GL_SPL_SEMICOLON());
    	lblOer.setText(i18n.GL1834()+i18n.GL_SPL_SEMICOLON());
	}


	public void setInfoData(String gooruOid){
		
		AppClientFactory.getInjector().getPlayerAppService().getSimpleCollectionDetils(null, gooruOid, null, null, null, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				collectionDo=result;
				loadingImagePanel.setVisible(false);
				setGradeText(collectionDo.getGrade());
				if(collectionDo.getMetaInfo()!=null && collectionDo.getMetaInfo().getStandards()!=null){
					renderStandards(standardsInfoConatiner,getStandardsMap(collectionDo.getMetaInfo().getStandards()));
				}
				setDepthOfKnlze();
				setLearningSkills();
				setAudienceInfo();
				setInstructionalInfo();
				setLanguageObjectiveText();
				setOerInfo();

			}

		});

	}

	protected void setLanguageObjectiveText() {
		if(collectionDo.getLanguageObjective()!=null){
			lblLanguageText.setText(collectionDo.getLanguageObjective());
		}else{
			panelDesc.setVisible(false);
		}
		if(lblLanguageText.getText().equals("")){
			panelDesc.setVisible(false);
		}
	}


	protected void setGradeText(String gradesText) {

		if(gradesText!=null&&!gradesText.equalsIgnoreCase("")&&!gradesText.equalsIgnoreCase("null")){
			this.gradesText.setText(InfoUtil.getGrades(gradesText));
			gradesPanel.setVisible(true);
		}else{
			gradesPanel.setVisible(false);
			//this.gradesText.setText(i18n.GL0977());
		}
	}

	protected void setDepthOfKnlze() {
		List<String> depthofknowledgedetails = new ArrayList<String>();

		if(collectionDo.getDepthOfKnowledges()!=null){
			if(collectionDo.getDepthOfKnowledges().size()>0){
				for(int i=0;i<collectionDo.getDepthOfKnowledges().size();i++){
					if(collectionDo.getDepthOfKnowledges().get(i).isSelected())
					{
						depthofknowledgedetails.add(collectionDo.getDepthOfKnowledges().get(i).getValue());
					}
				}
				InfoUtil.setDepthofknowledgeDetails(depthofknowledgedetails, dKnowledgeType, lblDepthKnowledge, dKnowledgePanel);
				//dKnowledgePanel.setVisible(true);
			}else{
				dKnowledgePanel.setVisible(false);
			}
		}else{
			dKnowledgePanel.setVisible(false);
		}

	}


	public List<Map<String,String>> getStandardsMap(List<StandardFo> standareds){
		List<Map<String,String>> standardsList=new ArrayList<Map<String,String>>();
		for(int i=0;i<standareds.size();i++){
			Map<String, String> standardMap=new HashMap<String, String>();
			standardMap.put(STANDARD_CODE, standareds.get(i).getCode());
			standardMap.put(STANDARD_DESCRIPTION, standareds.get(i).getDescription());
			standardsList.add(standardMap);
		}
		return standardsList;
	}

	public void renderStandards(FlowPanel standardsContainer, List<Map<String,String>> standardsList) {
		standardsContainer.clear();

		if (standardsList != null) {
			lblStandrads.setVisible(true);
//			lblStandardsText.setVisible(false);
			panelStandrads.setVisible(true);
			//List<Map<String, String>> standards = searchResultDo.getStandards();
			Iterator<Map<String, String>> iterator = standardsList.iterator();
			int count = 0;
			FlowPanel toolTipwidgets = new FlowPanel();
			while (iterator.hasNext()) {
				Map<String, String> standard = iterator.next();
				String stdCode = standard.get(STANDARD_CODE);
				String stdDec = standard.get(STANDARD_DESCRIPTION);
				if (count > 2) {
					if (count < 18){
						StandardSgItemVc standardItem = new StandardSgItemVc(stdCode, stdDec);
						toolTipwidgets.add(standardItem);
					}
				} else {
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label(stdCode), new Label(stdDec), standardsList);
					toolTipUc.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getstandardMoreInfo());
					standardsContainer.add(toolTipUc);
				}
				count++;
			}
			if (standardsList.size()>18){
				final Label left = new Label("+"+(standardsList.size() - 18));
				toolTipwidgets.add(left);
				panelStandrads.setVisible(true);
			}
			if (standardsList.size() > 2) {
				Integer moreStandardsCount = standardsList.size() - 3;
				if (moreStandardsCount >0){
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label("+" + moreStandardsCount), toolTipwidgets, standardsList);
					toolTipUc.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getstandardMoreLink());
					standardsContainer.add(toolTipUc);
					panelStandrads.setVisible(true);
				}
			}
			if(standardsList.isEmpty())
			{
				panelStandrads.getElement().getStyle().setDisplay(Display.NONE);
				lblStandrads.setVisible(false);
			}
		}
		else{
			panelStandrads.getElement().getStyle().setDisplay(Display.NONE);
			lblStandrads.setVisible(false);
		}
	}


	protected void setLearningSkills() {
		List<String> learningSkillsDetails = new ArrayList<String>();

		if(collectionDo.getLearningSkills()!=null){
			if(collectionDo.getDepthOfKnowledges().size()>0){
				for(int i=0;i<collectionDo.getLearningSkills().size();i++){
					if(collectionDo.getLearningSkills().get(i).isSelected())
					{
						learningSkillsDetails.add(collectionDo.getLearningSkills().get(i).getValue());
					}
				}
				InfoUtil.setDepthofknowledgeDetails(learningSkillsDetails, learningSkillsPanel, lblLearningSkills, learningSkillsMainPanel);
				//dKnowledgePanel.setVisible(true);
			}else{
				learningSkillsMainPanel.setVisible(false);
			}
		}else{
			learningSkillsMainPanel.setVisible(false);
		}

	}
	
	protected void setAudienceInfo(){
		  lblAudience.setVisible(true);
		if(collectionDo.getAudience()!=null){
			if(collectionDo.getAudience().size()>0){
				for(int i=0;i<collectionDo.getAudience().size();i++){
					if(collectionDo.getAudience().get(i).isSelected())
					{
						lblAudienceValue.setText(collectionDo.getAudience().get(i).getValue());
					}
				}
				if(lblAudienceValue.getText().equalsIgnoreCase("")){
					panelAudience.setVisible(false);
				}
			}else{
				panelAudience.setVisible(false);
				lblAudience.setVisible(false);
			}
		}else{
			panelAudience.setVisible(false);
			lblAudience.setVisible(false);
		}
	}
	
	protected void setInstructionalInfo(){
		panelInstructional.setVisible(true);
		if(collectionDo.getInstructionalMethod()!=null){
			if(collectionDo.getInstructionalMethod().size()>0){
				for(int i=0;i<collectionDo.getInstructionalMethod().size();i++){
					if(collectionDo.getInstructionalMethod().get(i).isSelected())
					{
						lblInstructionalValue.setText(collectionDo.getInstructionalMethod().get(i).getValue());
					}
				}
				if(lblInstructionalValue.getText().equalsIgnoreCase("")){
					panelInstructional.setVisible(false);
				}
				
			}else{
				
				panelInstructional.setVisible(false);
			}
		}else{
			panelInstructional.setVisible(false);
		}
	}
	
	protected void setOerInfo() {
		
		if(collectionDo.getCustomFieldValues()!=null && collectionDo.getCustomFieldValues().getCfOER()!=null){
			lblOerValue.setText(collectionDo.getCustomFieldValues().getCfOER());
			panelOer.setVisible(true);
		}else{
			panelOer.setVisible(false);
		}
		
	}

}
