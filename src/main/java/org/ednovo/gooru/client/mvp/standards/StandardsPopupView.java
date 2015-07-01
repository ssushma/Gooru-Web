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
package org.ednovo.gooru.client.mvp.standards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.code.StandardsLevel1DO;
import org.ednovo.gooru.application.shared.model.code.StandardsLevel2DO;
import org.ednovo.gooru.application.shared.model.code.StandardsLevel3DO;
import org.ednovo.gooru.application.shared.model.code.StandardsLevel4DO;
import org.ednovo.gooru.client.mvp.gshelf.util.LiPanelWithClose;
import org.ednovo.gooru.client.mvp.search.standards.AddStandardsBundle;
import org.ednovo.gooru.client.uc.AppPopUpStandards;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.StandardPreferenceTooltip;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.client.uc.tooltip.BrowseStandardsTooltip;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

/**
 * @author Search Team
 *
 */
public class StandardsPopupView extends PopupViewWithUiHandlers<StandardsPopupUiHandlers> implements IsStandardsPopupView {

	private static StandardsPopupViewUiBinder uiBinder = GWT.create(StandardsPopupViewUiBinder.class);
	
	@UiTemplate("StandardsPopupView.ui.xml")
	interface StandardsPopupViewUiBinder extends UiBinder<Widget, StandardsPopupView> {
	}	

	@UiField HTMLPanel mainContainer;

	private AppPopUpStandards appPopUp;
	
	ToolTip toolTip;
	
	@UiField Button addBtn;	
	@UiField UlPanel levelOneStandards,levelTwoStandards,levelThreeStandards,levelFourStandards;
	@UiField UlPanel ulSelectedItems;

	
	private boolean scienceCodeVal, instantVal = false;

	private String scienceStrCode = "";

	private static final String GOORU_UID = "gooruuid";
	
	String selectedCodeVal = "";
	
	Integer selectedCodeId = 0;
	String selectedCodeDesc = "";
	
	List<Map<String, String>> standListArray= new ArrayList<Map<String,String>>();
	
	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	boolean isHavingBadWords;
	
	final StandardPreferenceTooltip standardPreferenceTooltip=new StandardPreferenceTooltip();

	
	 BrowseStandardsTooltip browseStandardsTooltip = new BrowseStandardsTooltip(i18n.GL3050(),i18n.GL0192());
		
	private static final String TITLE_THIS_COLLECTION = i18n.GL0322();
	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public StandardsPopupView(EventBus eventBus) {
		super(eventBus);


		appPopUp = new AppPopUpStandards();
		appPopUp.setContent(TITLE_THIS_COLLECTION, uiBinder.createAndBindUi(this));
		appPopUp.getCloseBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				appPopUp.hide();
				
			}
		});



		
		
		appPopUp.setGlassEnabled(true);
		//appPopUp.setGlassStyleName(AddStandardsBundle.INSTANCE.css().gwtGlassPanel());
		appPopUp.getElement().getStyle().setZIndex(99999);
		
	

		appPopUp.setViewTitle(i18n.GL0575());
		mainContainer.getElement().setId("standardsDetails");

	}
	@Override
	public void loadData() {
		addBtn.setText("Add");
		addBtn.setEnabled(false);
		addBtn.removeStyleName("primary");
		addBtn.addStyleName("secondary");
		
	}
	@Override
	public void SetData(final StandardsLevel1DO levelOneData, int valArr)
	{
		instantVal = false;
		LiPanel liPanel=new LiPanel();
		Anchor levelOneStandardsInner = new Anchor();
		liPanel.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
		levelOneStandardsInner.getElement().setInnerHTML(levelOneData.getLabel());
		liPanel.getElement().setAttribute("id", levelOneData.getCodeId().toString());
		if(levelOneData.getCode()!= null)
		{
		if(levelOneData.getCode().equalsIgnoreCase("CA.SCI") && !scienceCodeVal)
		{
			scienceStrCode = levelOneData.getCodeId().toString();
			instantVal = true;
			scienceCodeVal = true;	
		}
		}
		if(!scienceStrCode.isEmpty())
		{			
			liPanel.getElement().setAttribute("dupid", scienceStrCode);
		}
		if(valArr==0)
		{
			liPanel.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());	
		}
		liPanel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				LiPanel clickedElement = (LiPanel)event.getSource();
				String codeStandardsVal = clickedElement.getElement().getAttribute("id");
				if(levelOneData.getCode() != null)
				{
				if(levelOneData.getCode().equalsIgnoreCase("CA.SCI"))
				{
					codeStandardsVal = clickedElement.getElement().getAttribute("dupid")+","+clickedElement.getElement().getAttribute("id");
					getFirstLevelObjects("1",codeStandardsVal);
				}
				else
				{
					getFirstLevelObjects("1",codeStandardsVal);
				}
				}
				else
				{
					getFirstLevelObjects("1",codeStandardsVal);
				}
				for(int l=0;l<levelOneStandards.getWidgetCount();l++)
				{
					levelOneStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
				}
				clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());	
			}
		});

		liPanel.add(levelOneStandardsInner);
		if(!instantVal)
		{
		levelOneStandards.add(liPanel.asWidget());
		}
		
		if(valArr == 0)
		{
		for(int i=0;i<levelOneData.getNode().size();i++)
		{
			LiPanel liPanel2=new LiPanel();
			Anchor levelOneStandardsInner2 = new Anchor();
			liPanel2.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
			levelOneStandardsInner2.getElement().setInnerHTML(levelOneData.getNode().get(i).getLabel());
			liPanel2.getElement().setAttribute("id", levelOneData.getNode().get(i).getCodeId().toString());
			if(i==0)
			{
				liPanel2.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());				
			}
			liPanel2.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					LiPanel clickedElement = (LiPanel)event.getSource();
					String codeStandardsVal = clickedElement.getElement().getAttribute("id");
					getSecondLevelObjects("2",codeStandardsVal);
					for(int l=0;l<levelTwoStandards.getWidgetCount();l++)
					{
						levelTwoStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					}
					clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());	
					
				}
			});
			liPanel2.add(levelOneStandardsInner2);
			levelTwoStandards.add(liPanel2.asWidget());
			if(i==0)
			{
			for(int j=0;j<levelOneData.getNode().get(i).getNode().size();j++)
			{
				LiPanel  liPanel3=new LiPanel();
				Anchor levelOneStandardsInner3 = new Anchor();
				liPanel3.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
				levelOneStandardsInner3.getElement().setInnerHTML(levelOneData.getNode().get(i).getNode().get(j).getLabel());
				liPanel3.getElement().setAttribute("id", levelOneData.getNode().get(i).getNode().get(j).getCodeId().toString());
				if(j==0)
				{
					liPanel3.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());				
				}
				liPanel3.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						LiPanel clickedElement = (LiPanel)event.getSource();
						String codeStandardsVal = clickedElement.getElement().getAttribute("id");
						getThirdLevelObjects("3",codeStandardsVal);
						for(int l=0;l<levelThreeStandards.getWidgetCount();l++)
						{
							levelThreeStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
						}
						clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
						
					}
				});
				liPanel3.add(levelOneStandardsInner3);
				levelThreeStandards.add(liPanel3.asWidget());
				if(j==0){
				for(int k=0;k<levelOneData.getNode().get(i).getNode().get(j).getNode().size();k++)
				{
					LiPanel levelOneStandardsInner4Outer = new LiPanel();
					HTMLEventPanel levelOneStandardsInner4 = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4Code = new HTMLEventPanel("");
					levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					levelOneStandardsInner4Code.getElement().setInnerHTML(levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getCode());
					levelOneStandardsInner4.getElement().setInnerHTML(levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getLabel());
					final String codeVal = levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getCode();
					final Integer codeIdVal = levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getCodeId();
					final String codeDesc = levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getLabel();
				
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4Code);
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4);	
					levelOneStandardsInner4Outer.getElement().setAttribute("id", levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getCodeId().toString());
					for(int r=0; r<ulSelectedItems.getWidgetCount(); r++){
						if(ulSelectedItems.getWidget(r).getElement().getInnerText().equals(codeVal)){
							levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
						}
					}
					levelOneStandardsInner4Outer.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
							LiPanel clickedObject = (LiPanel)event.getSource();
							if(clickedObject.getStyleName().contains("dropMenuSelected")){
								for(int i=0; i<standListArray.size(); i++){
									if(standListArray.get(i).get("selectedCodeVal").equals(codeVal)){
										standListArray.remove(i);
									}
								}
								clickedObject.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
							}else{
								Map<String,String> selectedStadDetails= new HashMap<String,String>();
								selectedStadDetails.put("selectedCodeId", String.valueOf(codeIdVal));
								selectedStadDetails.put("selectedCodeVal", codeVal);
								selectedStadDetails.put("selectedCodeDesc", codeDesc);
								standListArray.add(selectedStadDetails);
								
								LiPanelWithClose liPanelWithClose=new LiPanelWithClose(codeVal);
								liPanelWithClose.setId(codeIdVal);
								ulSelectedItems.add(liPanelWithClose);
							
								
								clickedObject.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
							}
							if(standListArray.size()!=0){
								addBtn.setEnabled(true);
								addBtn.removeStyleName("secondary");
								addBtn.addStyleName("primary");
							}else{
								addBtn.setEnabled(false);
								addBtn.removeStyleName("primary");
								addBtn.addStyleName("secondary");
							}
						}
					});
					levelFourStandards.add(levelOneStandardsInner4Outer.asWidget());
				}
				}
			}
			}
		}
	}
	//	appPopUp.getElement().setAttribute("style", "width:1000px;height:599px;z-index:99999;visibility: visible;position: absolute;left: 0 !important;right: 0 !important;margin:auto;top:0 !important;bottom:0 !important;");
	}
	

	public void getFirstLevelObjects(String levelOrder, String standardCodeSelected)
	{
		selectedCodeVal = "";
		selectedCodeId = 0;
		addBtn.setEnabled(false);
		addBtn.removeStyleName("primary");
		addBtn.addStyleName("secondary");
		getUiHandlers().getFirstLevelObjects(levelOrder,standardCodeSelected);
	}
	public void getSecondLevelObjects(String levelOrder, String standardCodeSelected)
	{
		selectedCodeVal = "";
		selectedCodeId = 0;
		addBtn.setEnabled(false);
		addBtn.removeStyleName("primary");
		addBtn.addStyleName("secondary");
		getUiHandlers().getSecondLevelObjects(levelOrder,standardCodeSelected);
	}
	public void getThirdLevelObjects(String levelOrder, String standardCodeSelected)
	{
		selectedCodeVal = "";
		selectedCodeId = 0;
		addBtn.setEnabled(false);
		addBtn.removeStyleName("primary");
		addBtn.addStyleName("secondary");
		getUiHandlers().getThirdLevelObjects(levelOrder,standardCodeSelected);
	}
	
	public void loadSecondLevelContianerObjects(ArrayList<StandardsLevel2DO> levelOneData)
	{
		levelTwoStandards.clear();
		levelThreeStandards.clear();
		levelFourStandards.clear();
		standListArray.clear();
		
		for(int i=0;i<levelOneData.size();i++)
		{
			try
			{
			LiPanel liPanel1=new LiPanel();	
			Anchor levelOneStandardsInner2 = new Anchor();
			liPanel1.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
			levelOneStandardsInner2.getElement().setInnerHTML(levelOneData.get(i).getLabel());
			liPanel1.getElement().setAttribute("id", levelOneData.get(i).getCodeId().toString());
			if(i==0)
			{
				liPanel1.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());				
			}
			liPanel1.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					LiPanel clickedElement = (LiPanel)event.getSource();
					String codeStandardsVal = clickedElement.getElement().getAttribute("id");
					getSecondLevelObjects("2",codeStandardsVal);
					for(int l=0;l<levelTwoStandards.getWidgetCount();l++)
					{
						levelTwoStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					}
					clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
					
				}
			});
			liPanel1.add(levelOneStandardsInner2);
			levelTwoStandards.add(liPanel1.asWidget());
			if(i==0)
			{
			for(int j=0;j<levelOneData.get(i).getNode().size();j++)
			{
				LiPanel liPanel=new LiPanel();
				Anchor levelOneStandardsInner3 = new Anchor();
				liPanel.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
				levelOneStandardsInner3.getElement().setInnerHTML(levelOneData.get(i).getNode().get(j).getLabel());
				liPanel.getElement().setAttribute("id", levelOneData.get(i).getNode().get(j).getCodeId().toString());
				if(j==0)
				{
					liPanel.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());				
				}
				liPanel.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						LiPanel clickedElement = (LiPanel)event.getSource();
						String codeStandardsVal = clickedElement.getElement().getAttribute("id");
						getThirdLevelObjects("3",codeStandardsVal);
						for(int l=0;l<levelThreeStandards.getWidgetCount();l++)
						{
							levelThreeStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
						}
						clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
						
					}
				});
				liPanel.add(levelOneStandardsInner3);
				levelThreeStandards.add(liPanel.asWidget());
				if(j==0)
				{
				for(int k=0;k<levelOneData.get(i).getNode().get(j).getNode().size();k++)
				{
					LiPanel levelOneStandardsInner4Outer = new LiPanel();
					HTMLEventPanel levelOneStandardsInner4 = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4Code = new HTMLEventPanel("");
					levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					levelOneStandardsInner4Code.getElement().setInnerHTML(levelOneData.get(i).getNode().get(j).getNode().get(k).getCode());
					levelOneStandardsInner4.getElement().setInnerHTML(levelOneData.get(i).getNode().get(j).getNode().get(k).getLabel());
					final String codeVal = levelOneData.get(i).getNode().get(j).getNode().get(k).getCode();
					final Integer codeIdVal = levelOneData.get(i).getNode().get(j).getNode().get(k).getCodeId();
					final String codeDesc = levelOneData.get(i).getNode().get(j).getNode().get(k).getLabel();
					
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4Code);
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4);	
					levelOneStandardsInner4Outer.getElement().setAttribute("id", levelOneData.get(i).getNode().get(j).getNode().get(k).getCodeId().toString());
					for(int r=0; r<ulSelectedItems.getWidgetCount(); r++){
						if(ulSelectedItems.getWidget(r).getElement().getInnerText().equals(codeVal)){
							levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
						}
					}
					levelOneStandardsInner4Outer.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
							LiPanel clickedObject = (LiPanel)event.getSource();
							if(clickedObject.getStyleName().contains("dropMenuSelected")){
								for(int i=0; i<standListArray.size(); i++){
									if(standListArray.get(i).get("selectedCodeVal").equals(codeVal)){
										standListArray.remove(i);
									}
								}
								clickedObject.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
							}else{
								Map<String,String> selectedStadDetails= new HashMap<String,String>();
								selectedStadDetails.put("selectedCodeId", String.valueOf(codeIdVal));
								selectedStadDetails.put("selectedCodeVal", codeVal);
								selectedStadDetails.put("selectedCodeDesc", codeDesc);
								standListArray.add(selectedStadDetails);
								
								LiPanelWithClose liPanelWithClose=new LiPanelWithClose(codeVal);
								liPanelWithClose.setId(codeIdVal);
								ulSelectedItems.add(liPanelWithClose);
								
								clickedObject.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
							}
							if(standListArray.size()!=0){
								addBtn.setEnabled(true);
								addBtn.removeStyleName("secondary");
								addBtn.addStyleName("primary");
							}else{
								addBtn.setEnabled(false);
								addBtn.removeStyleName("primary");
								addBtn.addStyleName("secondary");
							}
						}
					});
					levelFourStandards.add(levelOneStandardsInner4Outer.asWidget());
				}
				}
			}
			}
			}
			catch(Exception ex)
			{
				AppClientFactory.printSevereLogger(ex.getMessage());
			}
		}
	}
	
	public void loadThirdLevelContianerObjects(ArrayList<StandardsLevel3DO> levelOneData)
	{
		levelThreeStandards.clear();
		levelFourStandards.clear();
		standListArray.clear();
		
			for(int j=0;j<levelOneData.size();j++)
			{
				try{
				LiPanel liPanel=new LiPanel();	
				Anchor levelOneStandardsInner3 = new Anchor();
				liPanel.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
				levelOneStandardsInner3.getElement().setInnerHTML(levelOneData.get(j).getLabel());
				liPanel.getElement().setAttribute("id", levelOneData.get(j).getCodeId().toString());
				if(j==0)
				{
					liPanel.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());				
				}
				liPanel.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						LiPanel clickedElement = (LiPanel)event.getSource();
						String codeStandardsVal = clickedElement.getElement().getAttribute("id");
						getThirdLevelObjects("3",codeStandardsVal);
						for(int l=0;l<levelThreeStandards.getWidgetCount();l++)
						{
							levelThreeStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
						}
						clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
						
					}
				});
				liPanel.add(levelOneStandardsInner3);
				levelThreeStandards.add(liPanel.asWidget());
				if(j==0)
				{
				for(int k=0;k<levelOneData.get(j).getNode().size();k++)
				{
					LiPanel levelOneStandardsInner4Outer = new LiPanel();
					HTMLEventPanel levelOneStandardsInner4 = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4Code = new HTMLEventPanel("");
					levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					levelOneStandardsInner4Code.getElement().setInnerHTML(levelOneData.get(j).getNode().get(k).getCode());
					levelOneStandardsInner4.getElement().setInnerHTML(levelOneData.get(j).getNode().get(k).getLabel());
					final String codeVal = levelOneData.get(j).getNode().get(k).getCode();
					final Integer codeIdVal = levelOneData.get(j).getNode().get(k).getCodeId();
					final String codeDesc = levelOneData.get(j).getNode().get(k).getLabel();
					
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4Code);
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4);	
					levelOneStandardsInner4Outer.getElement().setAttribute("id", levelOneData.get(j).getNode().get(k).getCodeId().toString());
					for(int r=0; r<ulSelectedItems.getWidgetCount(); r++){
						if(ulSelectedItems.getWidget(r).getElement().getInnerText().equals(codeVal)){
							levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
						}
					}
					levelOneStandardsInner4Outer.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							LiPanel clickedObject = (LiPanel)event.getSource();
							
							if(clickedObject.getStyleName().contains("dropMenuSelected")){
								for(int i=0; i<standListArray.size(); i++){
									if(standListArray.get(i).get("selectedCodeVal").equals(codeVal)){
										standListArray.remove(i);
									}
								}
								clickedObject.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
							}else{
								Map<String,String> selectedStadDetails= new HashMap<String,String>();
								selectedStadDetails.put("selectedCodeId", String.valueOf(codeIdVal));
								selectedStadDetails.put("selectedCodeVal", codeVal);
								selectedStadDetails.put("selectedCodeDesc", codeDesc);
								standListArray.add(selectedStadDetails);
								
								LiPanelWithClose liPanelWithClose=new LiPanelWithClose(codeVal);
								liPanelWithClose.setId(codeIdVal);
								ulSelectedItems.add(liPanelWithClose);
								
								clickedObject.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
							}
							if(standListArray.size()!=0){
								addBtn.setEnabled(true);
								addBtn.removeStyleName("secondary");
								addBtn.addStyleName("primary");
							}else{
								addBtn.setEnabled(false);
								addBtn.removeStyleName("primary");
								addBtn.addStyleName("secondary");
							}
						}
					});
					levelFourStandards.add(levelOneStandardsInner4Outer.asWidget());
				}
				}
				}
				catch(Exception ex)
				{
					AppClientFactory.printSevereLogger(ex.getMessage());
				}
				}

	}
	
	public void loadFourthLevelContianerObjects(ArrayList<StandardsLevel4DO> levelOneData)
	{
		levelFourStandards.clear();
		standListArray.clear();
		

				for(int k=0;k<levelOneData.size();k++)
				{
					try{
					LiPanel levelOneStandardsInner4Outer = new LiPanel();
					HTMLEventPanel levelOneStandardsInner4 = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4Code = new HTMLEventPanel("");
					levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					levelOneStandardsInner4Code.getElement().setInnerHTML(levelOneData.get(k).getCode());
					levelOneStandardsInner4.getElement().setInnerHTML(levelOneData.get(k).getLabel());
					final String codeVal = levelOneData.get(k).getCode();
					final Integer codeIdVal = levelOneData.get(k).getCodeId();
					final String codeDesc = levelOneData.get(k).getLabel();
					
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4Code);
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4);	
					levelOneStandardsInner4Outer.getElement().setAttribute("id", levelOneData.get(k).getCodeId().toString());
					for(int r=0; r<ulSelectedItems.getWidgetCount(); r++){
						if(ulSelectedItems.getWidget(r).getElement().getInnerText().substring(0,(ulSelectedItems.getWidget(r).getElement().getInnerText().length()-1)).equalsIgnoreCase(codeVal)){
							levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
						}
					}
					levelOneStandardsInner4Outer.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
							LiPanel clickedObject = (LiPanel)event.getSource();
							if(clickedObject.getStyleName().contains("dropMenuSelected")){
								for(int i=0; i<standListArray.size(); i++){
									if(standListArray.get(i).get("selectedCodeVal").equals(codeVal)){
										standListArray.remove(i);
									}
								}
								clickedObject.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
							}else{
								Map<String,String> selectedStadDetails= new HashMap<String,String>();
								selectedStadDetails.put("selectedCodeId", String.valueOf(codeIdVal));
								selectedStadDetails.put("selectedCodeVal", codeVal);
								selectedStadDetails.put("selectedCodeDesc", codeDesc);
								standListArray.add(selectedStadDetails);
								
								LiPanelWithClose liPanelWithClose=new LiPanelWithClose(codeVal);
								liPanelWithClose.setId(codeIdVal);
								ulSelectedItems.add(liPanelWithClose);
								
								clickedObject.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
							}
							if(standListArray.size()!=0){
								addBtn.setEnabled(true);
								addBtn.removeStyleName("secondary");
								addBtn.addStyleName("primary");
							}else{
								addBtn.setEnabled(false);
								addBtn.removeStyleName("primary");
								addBtn.addStyleName("secondary");
							}
						}
					});
					levelFourStandards.add(levelOneStandardsInner4Outer.asWidget());
				}
					catch(Exception ex)
					{
						AppClientFactory.printSevereLogger(ex.getMessage());
					}
				}
				

	}
	
	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		//collectionTitleTxtBox.setFocus(true);
		return appPopUp;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		addBtn.setText("Add");
		standListArray.clear();
		ulSelectedItems.clear();
		levelOneStandards.clear();
		levelTwoStandards.clear();
		levelThreeStandards.clear();
		levelFourStandards.clear();
		scienceCodeVal = false;
	}
	@Override
	public void hidePopup()
	{
		appPopUp.hide();
	}
	@Override
	public void onLoad() {
		reset();
		
	}
	@Override
	public void onUnload() {
	
		
	}

	
	

}
