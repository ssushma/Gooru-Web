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
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.StandardFo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.util.InfoUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
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
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface CollectionInfoUiBinder extends UiBinder<Widget, CollectionInfo> {
	}

	@UiField 
	Label lblGradeTitle, gradesText;

	@UiField
    Label lblStandrads;

	@UiField
    Label lblStandardsText;

	@UiField
	Label lblLanguage,lblLearningSkills,lblAudience,lblAudienceValue,noInfoAvailable;

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
	
	private boolean isGradesInfo = false;
	private boolean isStandardsInfo = false;
	private boolean isDepthOfKnlzeInfo = false;
	private boolean isLearningSkillsInfo = false;
	private boolean	isAudienceInfo= false;
	private boolean isInstructionalInfo= false;
	private boolean isLanguageObjectiveInfo = false;
	private boolean isOerInfo = false;
	

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
		lblGradeTitle.setText(i18n.GL0325()+i18n.GL_SPL_SEMICOLON()+" ");
		lblGradeTitle.getElement().setId("lblGradeTitle");
		lblGradeTitle.getElement().setAttribute("alt",i18n.GL0325()+i18n.GL_SPL_SEMICOLON()+" ");
		lblGradeTitle.getElement().setAttribute("title",i18n.GL0325()+i18n.GL_SPL_SEMICOLON()+" ");
		
		lblStandrads.setText(i18n.GL0575()+i18n.GL_SPL_SEMICOLON()+" ");
		lblStandrads.getElement().setId("lblStandrads");
		lblStandrads.getElement().setAttribute("alt",i18n.GL0575()+i18n.GL_SPL_SEMICOLON()+" ");
		lblStandrads.getElement().setAttribute("title",i18n.GL0575()+i18n.GL_SPL_SEMICOLON()+" ");
		
		lblLanguage.setText(i18n.GL1721()+i18n.GL_SPL_SEMICOLON()+" ");
		lblLanguage.getElement().setId("lblLanguage");
		lblLanguage.getElement().setAttribute("alt",i18n.GL1721()+i18n.GL_SPL_SEMICOLON()+" ");
		lblLanguage.getElement().setAttribute("title",i18n.GL1721()+i18n.GL_SPL_SEMICOLON()+" ");
		
		lblDepthKnowledge.setText(i18n.GL1693()+i18n.GL_SPL_SEMICOLON()+" ");
		lblDepthKnowledge.getElement().setId("lblDepthKnowledge");
		lblDepthKnowledge.getElement().setAttribute("alt",i18n.GL1693()+i18n.GL_SPL_SEMICOLON()+" ");
		lblDepthKnowledge.getElement().setAttribute("title",i18n.GL1693()+i18n.GL_SPL_SEMICOLON()+" ");
		
		lblLearningSkills.setText(i18n.GL1722()+i18n.GL_SPL_SEMICOLON()+" ");
		lblLearningSkills.getElement().setId("lblLearningSkills");
		lblLearningSkills.getElement().setAttribute("alt",i18n.GL1722()+i18n.GL_SPL_SEMICOLON()+" ");
		lblLearningSkills.getElement().setAttribute("title",i18n.GL1722()+i18n.GL_SPL_SEMICOLON()+" ");
		
		lblAudience.setText(i18n.GL1723()+i18n.GL_SPL_SEMICOLON()+" ");
		lblAudience.getElement().setId("lblAudience");
		lblAudience.getElement().setAttribute("alt",i18n.GL1723()+i18n.GL_SPL_SEMICOLON()+" ");
		lblAudience.getElement().setAttribute("title",i18n.GL1723()+i18n.GL_SPL_SEMICOLON()+" ");
		
		lblInstructional.setText(i18n.GL1724()+i18n.GL_SPL_SEMICOLON()+" ");
		lblInstructional.getElement().setId("lblInstructional");
		lblInstructional.getElement().setAttribute("alt",i18n.GL1724()+i18n.GL_SPL_SEMICOLON()+" ");
		lblInstructional.getElement().setAttribute("title",i18n.GL1724()+i18n.GL_SPL_SEMICOLON()+" ");
		
    	lblOer.setText(i18n.GL1834()+i18n.GL_SPL_SEMICOLON()+" ");
    	lblOer.getElement().setId("lblOer");
    	lblOer.getElement().setAttribute("alt",i18n.GL1834()+i18n.GL_SPL_SEMICOLON()+" ");
    	lblOer.getElement().setAttribute("title",i18n.GL1834()+i18n.GL_SPL_SEMICOLON()+" ");
    	
    	loadingImagePanel.getElement().setId("pnlLoadingImagePanel");
    	gradesPanel.getElement().setId("pnlGradesPanel");
    	gradesText.getElement().setId("pnlGradesText");
    	panelStandrads.getElement().setId("pnlPanelStandrads");
    	lblStandardsText.getElement().setId("lblStandardsText");
    	standardsInfoConatiner.getElement().setId("fpnlStandardsInfoConatiner");
    	panelDesc.getElement().setId("pnlPanelDesc");
    	lblLanguageText.getElement().setId("lblLanguageText");
    	dKnowledgePanel.getElement().setId("pnlDKnowledgePanel");
    	dKnowledgeType.getElement().setId("htmlDKnowledgeType");
    	learningSkillsMainPanel.getElement().setId("pnlLearningSkillsMainPanel");
    	learningSkillsPanel.getElement().setId("pnlLearningSkillsPanel");
    	panelAudience.getElement().setId("pnlPanelAudience");
    	lblAudienceValue.getElement().setId("lblAudienceValue");
    	panelInstructional.getElement().setId("pnlPanelInstructional");
    	lblInstructionalValue.getElement().setId("lblInstructionalValue");
    	panelOer.getElement().setId("pnlPanelOer");
    	lblOerValue.getElement().setId("lblOerValue");
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
					if(isGradesInfo==false && isStandardsInfo==false
						&& isDepthOfKnlzeInfo==false && isLearningSkillsInfo==false
						&& isAudienceInfo==false && isInstructionalInfo==false
						&& isLanguageObjectiveInfo==false && isOerInfo==false){
						noInfoAvailable.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().noresourcesAvailable());
						noInfoAvailable.setText("No information available for this Collection.");
						noInfoAvailable.setVisible(true);
						noInfoAvailable.getElement().getStyle().setPaddingTop(10, Unit.PX);
					}else{
						noInfoAvailable.setVisible(false);
					}
			}

		});

	}

	protected void setLanguageObjectiveText() {
		if(collectionDo.getLanguageObjective()!=null){
			lblLanguageText.setText(collectionDo.getLanguageObjective());
			lblLanguageText.getElement().setAttribute("alt",collectionDo.getLanguageObjective());
			lblLanguageText.getElement().setAttribute("title",collectionDo.getLanguageObjective());
			isLanguageObjectiveInfo = true;
		}else{
			panelDesc.setVisible(false);
			isLanguageObjectiveInfo = false;
		}
		if(lblLanguageText.getText().equals("")){
			panelDesc.setVisible(false);
			isLanguageObjectiveInfo = false;
		}
	}


	protected void setGradeText(String gradesText) {

		if(gradesText!=null&&!gradesText.equalsIgnoreCase("")&&!gradesText.equalsIgnoreCase("null")){
			this.gradesText.setText(InfoUtil.getGrades(gradesText));
			this.gradesText.getElement().setAttribute("alt",InfoUtil.getGrades(gradesText));
			this.gradesText.getElement().setAttribute("title",InfoUtil.getGrades(gradesText));
			gradesPanel.setVisible(true);
			isGradesInfo =true;
		}else{
			gradesPanel.setVisible(false);
			isGradesInfo =false;
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
						isDepthOfKnlzeInfo = true;
					}
				}
				InfoUtil.setDepthofknowledgeDetails(depthofknowledgedetails, dKnowledgeType, lblDepthKnowledge, dKnowledgePanel);
				//dKnowledgePanel.setVisible(true);
			}else{
				dKnowledgePanel.setVisible(false);
				isDepthOfKnlzeInfo = false;
			}
		}else{
			dKnowledgePanel.setVisible(false);
			isDepthOfKnlzeInfo = false;
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
			isStandardsInfo = true;
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
					isStandardsInfo = true;
				} else {
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label(stdCode), new Label(stdDec), standardsList);
					toolTipUc.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getstandardMoreInfo());
					standardsContainer.add(toolTipUc);
					isStandardsInfo = true;
				}
				count++;
			}
			if (standardsList.size()>18){
				final Label left = new Label("+"+(standardsList.size() - 18));
				toolTipwidgets.add(left);
				panelStandrads.setVisible(true);
				isStandardsInfo = true;
			}
			if (standardsList.size() > 2) {
				Integer moreStandardsCount = standardsList.size() - 3;
				if (moreStandardsCount >0){
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label("+" + moreStandardsCount), toolTipwidgets, standardsList);
					toolTipUc.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getstandardMoreLink());
					standardsContainer.add(toolTipUc);
					panelStandrads.setVisible(true);
					isStandardsInfo = true;
				}
			}
			if(standardsList.isEmpty())
			{
				panelStandrads.getElement().getStyle().setDisplay(Display.NONE);
				lblStandrads.setVisible(false);
				isStandardsInfo = false;
			}
		}
		else{
			panelStandrads.getElement().getStyle().setDisplay(Display.NONE);
			lblStandrads.setVisible(false);
			isStandardsInfo = false;
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
						isLearningSkillsInfo = true;
					}
				}
				InfoUtil.setDepthofknowledgeDetails(learningSkillsDetails, learningSkillsPanel, lblLearningSkills, learningSkillsMainPanel);
				//dKnowledgePanel.setVisible(true);
			}else{
				learningSkillsMainPanel.setVisible(false);
				isLearningSkillsInfo = false;
			}
		}else{
			learningSkillsMainPanel.setVisible(false);
			isLearningSkillsInfo = false;
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
						lblAudienceValue.getElement().setAttribute("alt",collectionDo.getAudience().get(i).getValue());
						lblAudienceValue.getElement().setAttribute("title",collectionDo.getAudience().get(i).getValue());
						isAudienceInfo= true;
					}
				}
				if(lblAudienceValue.getText().equalsIgnoreCase("")){
					panelAudience.setVisible(false);
					isAudienceInfo= false;
				}
			}else{
				panelAudience.setVisible(false);
				lblAudience.setVisible(false);
				isAudienceInfo= false;
			}
		}else{
			panelAudience.setVisible(false);
			lblAudience.setVisible(false);
			isAudienceInfo= false;
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
						lblInstructionalValue.getElement().setAttribute("alt",collectionDo.getInstructionalMethod().get(i).getValue());
						lblInstructionalValue.getElement().setAttribute("title",collectionDo.getInstructionalMethod().get(i).getValue());
						isInstructionalInfo= true;
					}
				}
				if(lblInstructionalValue.getText().equalsIgnoreCase("")){
					panelInstructional.setVisible(false);
					isInstructionalInfo= false;
				}
				
			}else{
				
				panelInstructional.setVisible(false);
				isInstructionalInfo= false;
			}
		}else{
			panelInstructional.setVisible(false);
			isInstructionalInfo= false;
		}
	}
	
	protected void setOerInfo() {
		
		if(collectionDo.getCustomFieldValues()!=null && collectionDo.getCustomFieldValues().getCfOER()!=null){
			lblOerValue.setText(collectionDo.getCustomFieldValues().getCfOER());
			lblOerValue.getElement().setAttribute("alt",collectionDo.getCustomFieldValues().getCfOER());
			lblOerValue.getElement().setAttribute("title",collectionDo.getCustomFieldValues().getCfOER());
			panelOer.setVisible(true);
			isOerInfo = true;
		}else{
			panelOer.setVisible(false);
			isOerInfo = false;
		}
		
	}

}
