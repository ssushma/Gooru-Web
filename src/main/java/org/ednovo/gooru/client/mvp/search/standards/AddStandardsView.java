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
package org.ednovo.gooru.client.mvp.search.standards;

import java.util.ArrayList;

import org.ednovo.gooru.client.mvp.addTagesPopup.AddTagesCBundle;
import org.ednovo.gooru.client.uc.AppPopUpStandards;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.code.StandardsLevel1DO;
import org.ednovo.gooru.shared.model.code.StandardsLevel2DO;
import org.ednovo.gooru.shared.model.code.StandardsLevel3DO;
import org.ednovo.gooru.shared.model.code.StandardsLevel4DO;
import org.ednovo.gooru.shared.model.content.CollectionDo;

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
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

/**
 * @author Search Team
 *
 */
public class AddStandardsView extends PopupViewWithUiHandlers<AddStandardsUiHandlers> implements IsAddStandardsView {
	

	private AppPopUpStandards appPopUp;
	
	ToolTip toolTip;
	
	@UiField Button commonStandards,texasKnowledge,ngss,californiaStandards,addBtn;
	
	@UiField HTMLPanel levelOneStandards,levelTwoStandards,levelThreeStandards,levelFourStandards;
	
	private boolean isCheckedValue;
	
	private boolean scienceCodeVal, instantVal = false;

	private String scienceStrCode = "";
	private CollectionDo collectionDo;
	
	private PopupPanel toolTipPopupPanel=new PopupPanel();
	
//	public static final String GRADE_INFO = MessageProperties.GL0320;

//	public static final String COURSE_INFO = MessageProperties.GL0321;

	private static final String GOORU_UID = "gooruuid";
	
	String selectedCodeVal = "";
	
	Integer selectedCodeId = 0;
	
	private static AddStandardsViewUiBinder uiBinder = GWT.create(AddStandardsViewUiBinder.class);
	
	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String TITLE_THIS_COLLECTION = i18n.GL0322();
	
	private static String CONFIRM_MESSAGE = i18n.GL1490()+i18n.GL_SPL_EXCLAMATION();
	
	boolean isHavingBadWords;
	
	@UiTemplate("AddStandardsView.ui.xml")
	interface AddStandardsViewUiBinder extends UiBinder<Widget, AddStandardsView> {
	}

	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public AddStandardsView(EventBus eventBus) {
		super(eventBus);
		/*this.res = CollectionCBundle.INSTANCE;
		res.css().ensureInjected();*/

		appPopUp = new AppPopUpStandards();
		appPopUp.getCloseBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				appPopUp.hide();
				
			}
		});
		addBtn= new Button();
		commonStandards = new Button();
		texasKnowledge = new Button();
		ngss = new Button();
		californiaStandards = new Button();
	
		
		appPopUp.setContent(TITLE_THIS_COLLECTION, uiBinder.createAndBindUi(this));
		appPopUp.setGlassStyleName(AddStandardsBundle.INSTANCE.css().gwtGlassPanel());
		appPopUp.getElement().getStyle().setZIndex(99999);
		AddStandardsBundle.INSTANCE.css().ensureInjected();

		appPopUp.setViewTitle(i18n.GL0575());
		
		commonStandards.setStyleName("primary");
		commonStandards.addStyleName(AddStandardsBundle.INSTANCE.css().btnStandardsStyle());
	
	}
	
	@Override
	public void loadData()
	{
		addBtn.setText("Add");
		commonStandards.setText("Common Core State Standards");
		texasKnowledge.setText("Texas Essential Knowledge and Skills");
		ngss.setText("Next Generation Science Standards");
		californiaStandards.setText("California State Standards");
	}
	
	@Override
	public void SetData(final StandardsLevel1DO levelOneData, int valArr)
	{
		instantVal = false;
		HTMLEventPanel levelOneStandardsInner = new HTMLEventPanel("");
		levelOneStandardsInner.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
		levelOneStandardsInner.getElement().setInnerHTML(levelOneData.getLabel());
		levelOneStandardsInner.getElement().setAttribute("id", levelOneData.getCodeId().toString());
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
			levelOneStandardsInner.getElement().setAttribute("dupid", scienceStrCode);
		}
		if(valArr==0)
		{
			levelOneStandardsInner.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());	
		}
		levelOneStandardsInner.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				HTMLEventPanel clickedElement = (HTMLEventPanel)event.getSource();
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

		if(!instantVal)
		{
		levelOneStandards.add(levelOneStandardsInner.asWidget());
		}
		
		if(valArr == 0)
		{
		for(int i=0;i<levelOneData.getNode().size();i++)
		{
			HTMLEventPanel levelOneStandardsInner2 = new HTMLEventPanel("");
			levelOneStandardsInner2.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
			levelOneStandardsInner2.getElement().setInnerHTML(levelOneData.getNode().get(i).getLabel());
			levelOneStandardsInner2.getElement().setAttribute("id", levelOneData.getNode().get(i).getCodeId().toString());
			if(i==0)
			{
				levelOneStandardsInner2.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());				
			}
			levelOneStandardsInner2.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					HTMLEventPanel clickedElement = (HTMLEventPanel)event.getSource();
					String codeStandardsVal = clickedElement.getElement().getAttribute("id");
					getSecondLevelObjects("2",codeStandardsVal);
					for(int l=0;l<levelTwoStandards.getWidgetCount();l++)
					{
						levelTwoStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					}
					clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());	
					
				}
			});
			levelTwoStandards.add(levelOneStandardsInner2.asWidget());
			if(i==0)
			{
			for(int j=0;j<levelOneData.getNode().get(i).getNode().size();j++)
			{
				HTMLEventPanel levelOneStandardsInner3 = new HTMLEventPanel("");
				levelOneStandardsInner3.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
				levelOneStandardsInner3.getElement().setInnerHTML(levelOneData.getNode().get(i).getNode().get(j).getLabel());
				levelOneStandardsInner3.getElement().setAttribute("id", levelOneData.getNode().get(i).getNode().get(j).getCodeId().toString());
				if(j==0)
				{
					levelOneStandardsInner3.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());				
				}
				levelOneStandardsInner3.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						HTMLEventPanel clickedElement = (HTMLEventPanel)event.getSource();
						String codeStandardsVal = clickedElement.getElement().getAttribute("id");
						getThirdLevelObjects("3",codeStandardsVal);
						for(int l=0;l<levelThreeStandards.getWidgetCount();l++)
						{
							levelThreeStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
						}
						clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
						
					}
				});
				levelThreeStandards.add(levelOneStandardsInner3.asWidget());
				if(j==0)
				{
				for(int k=0;k<levelOneData.getNode().get(i).getNode().get(j).getNode().size();k++)
				{
					HTMLEventPanel levelOneStandardsInner4Outer = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4 = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4Code = new HTMLEventPanel("");
					levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					levelOneStandardsInner4Code.getElement().setInnerHTML(levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getCode());
					levelOneStandardsInner4.getElement().setInnerHTML(levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getLabel());
					final String codeVal = levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getCode();
					final Integer codeIdVal = levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getCodeId();
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4Code);
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4);	
					levelOneStandardsInner4Outer.getElement().setAttribute("id", levelOneData.getNode().get(i).getNode().get(j).getNode().get(k).getCodeId().toString());
					levelOneStandardsInner4Outer.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
							HTMLEventPanel clickedObject = (HTMLEventPanel)event.getSource();
							selectedCodeVal = codeVal;
							selectedCodeId=codeIdVal;
							for(int l=0;l<levelFourStandards.getWidgetCount();l++)
							{
								levelFourStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
							}
							clickedObject.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());		
						}
					});
					levelFourStandards.add(levelOneStandardsInner4Outer.asWidget());
				}
				}
			}
			}
		}
	}
	}
	
	public void getFirstLevelObjects(String levelOrder, String standardCodeSelected)
	{
		getUiHandlers().getFirstLevelObjects(levelOrder,standardCodeSelected);
	}
	public void getSecondLevelObjects(String levelOrder, String standardCodeSelected)
	{
		getUiHandlers().getSecondLevelObjects(levelOrder,standardCodeSelected);
	}
	public void getThirdLevelObjects(String levelOrder, String standardCodeSelected)
	{
		getUiHandlers().getThirdLevelObjects(levelOrder,standardCodeSelected);
	}
	
	public void loadSecondLevelContianerObjects(ArrayList<StandardsLevel2DO> levelOneData)
	{
		levelTwoStandards.clear();
		levelThreeStandards.clear();
		levelFourStandards.clear();
		
		for(int i=0;i<levelOneData.size();i++)
		{
			try
			{
			HTMLEventPanel levelOneStandardsInner2 = new HTMLEventPanel("");
			levelOneStandardsInner2.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
			levelOneStandardsInner2.getElement().setInnerHTML(levelOneData.get(i).getLabel());
			levelOneStandardsInner2.getElement().setAttribute("id", levelOneData.get(i).getCodeId().toString());
			if(i==0)
			{
				levelOneStandardsInner2.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());				
			}
			levelOneStandardsInner2.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					HTMLEventPanel clickedElement = (HTMLEventPanel)event.getSource();
					String codeStandardsVal = clickedElement.getElement().getAttribute("id");
					getSecondLevelObjects("2",codeStandardsVal);
					for(int l=0;l<levelTwoStandards.getWidgetCount();l++)
					{
						levelTwoStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					}
					clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
					
				}
			});
			levelTwoStandards.add(levelOneStandardsInner2.asWidget());
			if(i==0)
			{
			for(int j=0;j<levelOneData.get(i).getNode().size();j++)
			{
				HTMLEventPanel levelOneStandardsInner3 = new HTMLEventPanel("");
				levelOneStandardsInner3.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
				levelOneStandardsInner3.getElement().setInnerHTML(levelOneData.get(i).getNode().get(j).getLabel());
				levelOneStandardsInner3.getElement().setAttribute("id", levelOneData.get(i).getNode().get(j).getCodeId().toString());
				if(j==0)
				{
					levelOneStandardsInner3.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());				
				}
				levelOneStandardsInner3.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						HTMLEventPanel clickedElement = (HTMLEventPanel)event.getSource();
						String codeStandardsVal = clickedElement.getElement().getAttribute("id");
						getThirdLevelObjects("3",codeStandardsVal);
						for(int l=0;l<levelThreeStandards.getWidgetCount();l++)
						{
							levelThreeStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
						}
						clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
						
					}
				});
				levelThreeStandards.add(levelOneStandardsInner3.asWidget());
				if(j==0)
				{
				for(int k=0;k<levelOneData.get(i).getNode().get(j).getNode().size();k++)
				{
					HTMLEventPanel levelOneStandardsInner4Outer = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4 = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4Code = new HTMLEventPanel("");
					levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					levelOneStandardsInner4Code.getElement().setInnerHTML(levelOneData.get(i).getNode().get(j).getNode().get(k).getCode());
					levelOneStandardsInner4.getElement().setInnerHTML(levelOneData.get(i).getNode().get(j).getNode().get(k).getLabel());
					final String codeVal = levelOneData.get(i).getNode().get(j).getNode().get(k).getCode();
					final Integer codeIdVal = levelOneData.get(i).getNode().get(j).getNode().get(k).getCodeId();
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4Code);
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4);	
					levelOneStandardsInner4Outer.getElement().setAttribute("id", levelOneData.get(i).getNode().get(j).getNode().get(k).getCodeId().toString());
					levelOneStandardsInner4Outer.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
							HTMLEventPanel clickedObject = (HTMLEventPanel)event.getSource();
							selectedCodeVal = codeVal;
							selectedCodeId=codeIdVal;
							for(int l=0;l<levelFourStandards.getWidgetCount();l++)
							{
								levelFourStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
							}
							clickedObject.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());		
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
				ex.printStackTrace();
			}
		}
	}
	
	public void loadThirdLevelContianerObjects(ArrayList<StandardsLevel3DO> levelOneData)
	{
		levelThreeStandards.clear();
		levelFourStandards.clear();
		
			for(int j=0;j<levelOneData.size();j++)
			{
				try{
				HTMLEventPanel levelOneStandardsInner3 = new HTMLEventPanel("");
				levelOneStandardsInner3.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
				levelOneStandardsInner3.getElement().setInnerHTML(levelOneData.get(j).getLabel());
				levelOneStandardsInner3.getElement().setAttribute("id", levelOneData.get(j).getCodeId().toString());
				if(j==0)
				{
					levelOneStandardsInner3.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());				
				}
				levelOneStandardsInner3.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						HTMLEventPanel clickedElement = (HTMLEventPanel)event.getSource();
						String codeStandardsVal = clickedElement.getElement().getAttribute("id");
						getThirdLevelObjects("3",codeStandardsVal);
						for(int l=0;l<levelThreeStandards.getWidgetCount();l++)
						{
							levelThreeStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
						}
						clickedElement.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());
						
					}
				});
				levelThreeStandards.add(levelOneStandardsInner3.asWidget());
				if(j==0)
				{
				for(int k=0;k<levelOneData.get(j).getNode().size();k++)
				{
					HTMLEventPanel levelOneStandardsInner4Outer = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4 = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4Code = new HTMLEventPanel("");
					levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					levelOneStandardsInner4Code.getElement().setInnerHTML(levelOneData.get(j).getNode().get(k).getCode());
					levelOneStandardsInner4.getElement().setInnerHTML(levelOneData.get(j).getNode().get(k).getLabel());
					final String codeVal = levelOneData.get(j).getNode().get(k).getCode();
					final Integer codeIdVal = levelOneData.get(j).getNode().get(k).getCodeId();
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4Code);
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4);	
					levelOneStandardsInner4Outer.getElement().setAttribute("id", levelOneData.get(j).getNode().get(k).getCodeId().toString());
					levelOneStandardsInner4Outer.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							HTMLEventPanel clickedObject = (HTMLEventPanel)event.getSource();
							selectedCodeVal = codeVal;
							selectedCodeId=codeIdVal;
							for(int l=0;l<levelFourStandards.getWidgetCount();l++)
							{
								levelFourStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
							}
							clickedObject.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());		
						}
					});
					levelFourStandards.add(levelOneStandardsInner4Outer.asWidget());
				}
				}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				}

	}
	
	public void loadFourthLevelContianerObjects(ArrayList<StandardsLevel4DO> levelOneData)
	{
		levelFourStandards.clear();
		

				for(int k=0;k<levelOneData.size();k++)
				{
					try{
					HTMLEventPanel levelOneStandardsInner4Outer = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4 = new HTMLEventPanel("");
					HTMLEventPanel levelOneStandardsInner4Code = new HTMLEventPanel("");
					levelOneStandardsInner4Outer.setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
					levelOneStandardsInner4Code.getElement().setInnerHTML(levelOneData.get(k).getCode());
					levelOneStandardsInner4.getElement().setInnerHTML(levelOneData.get(k).getLabel());
					final String codeVal = levelOneData.get(k).getCode();
					final Integer codeIdVal = levelOneData.get(k).getCodeId();
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4Code);
					levelOneStandardsInner4Outer.add(levelOneStandardsInner4);	
					levelOneStandardsInner4Outer.getElement().setAttribute("id", levelOneData.get(k).getCodeId().toString());
					levelOneStandardsInner4Outer.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
							HTMLEventPanel clickedObject = (HTMLEventPanel)event.getSource();
							selectedCodeVal = codeVal;
							selectedCodeId=codeIdVal;
							for(int l=0;l<levelFourStandards.getWidgetCount();l++)
							{
								levelFourStandards.getWidget(l).setStyleName(AddStandardsBundle.INSTANCE.css().dropMenu());
							}
							clickedObject.addStyleName(AddStandardsBundle.INSTANCE.css().dropMenuSelected());		
						}
					});
					levelFourStandards.add(levelOneStandardsInner4Outer.asWidget());
				}
					catch(Exception ex)
					{
						ex.printStackTrace();
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
		//addBtn.setText("Add");
		levelOneStandards.clear();
		levelTwoStandards.clear();
		levelThreeStandards.clear();
		levelFourStandards.clear();
		scienceCodeVal = false;
	}
	
	@Override
	public void setDefaultCCSS() {
		texasKnowledge.removeStyleName("primary");
		texasKnowledge.addStyleName("secondary");
		ngss.removeStyleName("primary");
		ngss.addStyleName("secondary");
		californiaStandards.removeStyleName("primary");
		californiaStandards.addStyleName("secondary");
		commonStandards.removeStyleName("secondary");
		commonStandards.addStyleName("primary");
	}

	@Override
	public void onLoad() {
		reset();
		//getUiHandlers().callDefaultStandardsLoad();
		//default load for the widget to be here
		//getUiHandlers().callDefaultStandardsLoad();
		//addBtn.setText("Add");
	}

	@Override
	public void onUnload() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Button getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(Button addBtn) {
		this.addBtn = addBtn;
	}
	
	@Override
	public String setStandardsVal()
	{
		String standardVal = selectedCodeVal;
		return standardVal;
	}
	@Override
	public Integer setStandardsIdVal()
	{
		Integer standardVal = selectedCodeId;
		return standardVal;
	}
	@Override
	public void hidePopup()
	{
		appPopUp.hide();
	}
	
	@UiHandler("texasKnowledge")
	public void ontexasKnowledgeClick(ClickEvent click){
		scienceCodeVal = false;
		instantVal = false;
		commonStandards.removeStyleName("primary");
		commonStandards.addStyleName("secondary");
		ngss.removeStyleName("primary");
		ngss.addStyleName("secondary");
		californiaStandards.removeStyleName("primary");
		californiaStandards.addStyleName("secondary");
		texasKnowledge.removeStyleName("secondary");
		texasKnowledge.addStyleName("primary");

	getUiHandlers().loadStateStandards("TEKS");
	}
	
	@UiHandler("commonStandards")
	public void oncommonStandardsClick(ClickEvent click){
		scienceCodeVal = false;
		instantVal = false;
		texasKnowledge.removeStyleName("primary");
		texasKnowledge.addStyleName("secondary");
		ngss.removeStyleName("primary");
		ngss.addStyleName("secondary");
		californiaStandards.removeStyleName("primary");
		californiaStandards.addStyleName("secondary");
		commonStandards.removeStyleName("secondary");
		commonStandards.addStyleName("primary");

	getUiHandlers().loadStateStandards("CCSS");
	}
	
	@UiHandler("ngss")
	public void onngssClick(ClickEvent click){
		scienceCodeVal = false;
		instantVal = false;
		texasKnowledge.removeStyleName("primary");
		texasKnowledge.addStyleName("secondary");
		commonStandards.removeStyleName("primary");
		commonStandards.addStyleName("secondary");
		californiaStandards.removeStyleName("primary");
		californiaStandards.addStyleName("secondary");
		ngss.removeStyleName("secondary");
		ngss.addStyleName("primary");

	getUiHandlers().loadStateStandards("NGSS");
	}
	
	@UiHandler("californiaStandards")
	public void oncaliforniaStandardsClick(ClickEvent click){
		scienceCodeVal = false;
		instantVal = false;
		texasKnowledge.removeStyleName("primary");
		texasKnowledge.addStyleName("secondary");
		commonStandards.removeStyleName("primary");
		commonStandards.addStyleName("secondary");
		ngss.removeStyleName("primary");
		ngss.addStyleName("secondary");
		californiaStandards.removeStyleName("secondary");
		californiaStandards.addStyleName("primary");

	getUiHandlers().loadStateStandards("CA");
	}
	
}
