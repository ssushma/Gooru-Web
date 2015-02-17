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

import org.ednovo.gooru.client.uc.AppPopUpCentury;
import org.ednovo.gooru.client.uc.StandardPreferenceTooltip;
import org.ednovo.gooru.client.uc.tooltip.BrowseStandardsTooltip;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.code.StandardsLevel1DO;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

/**
 * @author Search Team
 *
 */
public class AddCenturyView extends PopupViewWithUiHandlers<AddCenturyUiHandlers> implements IsAddCenturyView {
	

	private AppPopUpCentury appPopUp;
	
/*	ToolTip toolTip;
	
	@UiField Button commonStandards,texasKnowledge,ngss,californiaStandards,addBtn;
	@UiField Label subjects,grade,course,standard;
	@UiField UlPanel levelOneStandards,levelTwoStandards,levelThreeStandards,levelFourStandards;*/
	
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
	String selectedCodeDesc = "";
	private static AddCenturyViewUiBinder uiBinder = GWT.create(AddCenturyViewUiBinder.class);
	
	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String TITLE_THIS_COLLECTION = i18n.GL0322();
	
	
	
	private static String CONFIRM_MESSAGE = i18n.GL1490()+i18n.GL_SPL_EXCLAMATION();
	
	boolean isHavingBadWords;
	
	final StandardPreferenceTooltip standardPreferenceTooltip=new StandardPreferenceTooltip();
	
	private boolean isCCSSAvailable =false;
	private boolean isNGSSAvailable =false;
	private boolean isTEKSAvailable =false;
	private boolean isCAAvailable =false;
	
	 BrowseStandardsTooltip browseStandardsTooltip = new BrowseStandardsTooltip(i18n.GL3050(),i18n.GL0192());
	private boolean isBrowseStandardsToolTip = false;
	
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
		/*this.res = CollectionCBundle.INSTANCE;
		res.css().ensureInjected();*/

		appPopUp = new AppPopUpCentury();
		appPopUp.getCloseBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				appPopUp.hide();
				
			}
		});
/*		addBtn= new Button();
		commonStandards = new Button();
		texasKnowledge = new Button();
		ngss = new Button();
		californiaStandards = new Button();*/
	
		
		appPopUp.setContent(TITLE_THIS_COLLECTION, uiBinder.createAndBindUi(this));
		appPopUp.setGlassStyleName(AddCenturyBundle.INSTANCE.css().gwtGlassPanel());
		appPopUp.getElement().getStyle().setZIndex(99999);
		
		AddCenturyBundle.INSTANCE.css().ensureInjected();

		appPopUp.setViewTitle(i18n.GL3121());
		
	/*	commonStandards.setStyleName("primary");

//		commonStandards.addStyleName(AddStandardsBundle.INSTANCE.css().btnStandardsStyle());
	
		commonStandards.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(isCCSSAvailable==false){
					browseStandardsTooltip.show();
					browseStandardsTooltip.setPopupPosition(commonStandards.getAbsoluteLeft()+3, commonStandards.getAbsoluteTop()+33);
					browseStandardsTooltip.getConfirmationPanel().getElement().getStyle().setLeft(0, Unit.PX);
					browseStandardsTooltip.getElement().getStyle().setZIndex(999999);
					isBrowseStandardsToolTip= true;
				}
			}
		});*/
		Event.addNativePreviewHandler(new NativePreviewHandler() {
	        public void onPreviewNativeEvent(NativePreviewEvent event) {
	        	hideBrowseStandardsPopup(event);
	          }
	    });
	/*	ngss.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(isNGSSAvailable==false){
					browseStandardsTooltip.show();
					browseStandardsTooltip.setPopupPosition(ngss.getAbsoluteLeft()+3, ngss.getAbsoluteTop()+33);
					browseStandardsTooltip.getConfirmationPanel().getElement().getStyle().setLeft(0, Unit.PX);
					browseStandardsTooltip.getElement().getStyle().setZIndex(999999);
					isBrowseStandardsToolTip= true;
				}
			}
		});
		texasKnowledge.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(isTEKSAvailable==false){
					browseStandardsTooltip.show();
					browseStandardsTooltip.setPopupPosition(texasKnowledge.getAbsoluteLeft()+3, texasKnowledge.getAbsoluteTop()+33);
					browseStandardsTooltip.getConfirmationPanel().getElement().getStyle().setLeft(0, Unit.PX);
					browseStandardsTooltip.getElement().getStyle().setZIndex(999999);
					isBrowseStandardsToolTip= true;
				}
			}
		});
		californiaStandards.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(isCAAvailable==false){
					browseStandardsTooltip.show();
					browseStandardsTooltip.setPopupPosition(californiaStandards.getAbsoluteLeft()+3, californiaStandards.getAbsoluteTop()+33);
					browseStandardsTooltip.getConfirmationPanel().getElement().getStyle().setLeft(0, Unit.PX);
					browseStandardsTooltip.getElement().getStyle().setZIndex(999999);
					isBrowseStandardsToolTip= true;
				}
				
			}
		});*/
	}
	
	@Override
	public void loadData()
	{
		/*addBtn.setText("Add");
		addBtn.setEnabled(false);
		addBtn.removeStyleName("primary");
		addBtn.addStyleName("secondary");
		commonStandards.setText("Common Core State Standards");
		texasKnowledge.setText("Texas Essential Knowledge and Skills");
		ngss.setText("Next Generation Science Standards");
		californiaStandards.setText("California State Standards");*/
	}
	
	@Override
	public void SetData(final StandardsLevel1DO levelOneData, int valArr)
	{
		instantVal = false;
		
	
	//	appPopUp.getElement().setAttribute("style", "width:1000px;height:599px;z-index:99999;visibility: visible;position: absolute;left: 0 !important;right: 0 !important;margin:auto;top:0 !important;bottom:0 !important;");
	}
	
	/*public void getFirstLevelObjects(String levelOrder, String standardCodeSelected)
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
	}*/
	
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
/*		levelOneStandards.clear();
		levelTwoStandards.clear();
		levelThreeStandards.clear();
		levelFourStandards.clear();*/
		scienceCodeVal = false;
	}
	
	@Override
	public void setDefaultCCSS() {
	/*	texasKnowledge.removeStyleName("primary");
		texasKnowledge.addStyleName("secondary");
		ngss.removeStyleName("primary");
		ngss.addStyleName("secondary");
		californiaStandards.removeStyleName("primary");
		californiaStandards.addStyleName("secondary");
		commonStandards.removeStyleName("secondary");
		commonStandards.addStyleName("primary");*/
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
/*	@Override
	public Button getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(Button addBtn) {
		this.addBtn = addBtn;
	}*/
	
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
	
	@Override
	public String setStandardsDesc() {
			return selectedCodeDesc;
	}

	public void setDefaultTEKS() {
	/*	commonStandards.removeStyleName("primary");
		commonStandards.addStyleName("secondary");
		ngss.removeStyleName("primary");
		ngss.addStyleName("secondary");
		californiaStandards.removeStyleName("primary");
		californiaStandards.addStyleName("secondary");
		texasKnowledge.removeStyleName("secondary");
		texasKnowledge.addStyleName("primary");*/
	}
	
	public void setDefaultNGSS() {
	/*	texasKnowledge.removeStyleName("primary");
		texasKnowledge.addStyleName("secondary");
		commonStandards.removeStyleName("primary");
		commonStandards.addStyleName("secondary");
		californiaStandards.removeStyleName("primary");
		californiaStandards.addStyleName("secondary");
		ngss.removeStyleName("secondary");
		ngss.addStyleName("primary");*/
	}
	
	public void setDefaultCA() {
	/*	texasKnowledge.removeStyleName("primary");
		texasKnowledge.addStyleName("secondary");
		commonStandards.removeStyleName("primary");
		commonStandards.addStyleName("secondary");
		ngss.removeStyleName("primary");
		ngss.addStyleName("secondary");
		californiaStandards.removeStyleName("secondary");
		californiaStandards.addStyleName("primary");*/
	}
	
	@Override
	public void setEnableStandardButtons(boolean isCCSSAvailable,
			boolean isNGSSAvailable, boolean isTEKSAvailable,
			boolean isCAAvailable) {
		this.isCCSSAvailable = isCCSSAvailable;
		this.isNGSSAvailable = isNGSSAvailable;
		this.isTEKSAvailable = isTEKSAvailable;
		this.isCAAvailable = isCAAvailable;
		
/*		if(isCCSSAvailable == true){
			commonStandards.getElement().getStyle().clearColor();
			commonStandards.getElement().removeClassName("disabled");
		}else{
			commonStandards.getElement().getStyle().setColor("#999");
			commonStandards.getElement().addClassName("disabled");
		}
		if(isNGSSAvailable == true){
			ngss.getElement().getStyle().clearColor();
			ngss.getElement().removeClassName("disabled");
		}else{
			ngss.getElement().getStyle().setColor("#999");
			ngss.getElement().addClassName("disabled");
		}
		
		if(isTEKSAvailable == true){
			texasKnowledge.getElement().getStyle().clearColor();
			texasKnowledge.getElement().removeClassName("disabled");
		}else{
			texasKnowledge.getElement().getStyle().setColor("#999");
			texasKnowledge.getElement().addClassName("disabled");
		}
		
		if(isCAAvailable == true){
			californiaStandards.getElement().getStyle().clearColor();
			californiaStandards.getElement().removeClassName("disabled");
		}else{
			californiaStandards.getElement().getStyle().setColor("#999");
			californiaStandards.getElement().addClassName("disabled");
		}*/
		
	}

	@Override
	public void setStandardsStyles(String standardVal) {
		// TODO Auto-generated method stub
		if(standardVal.equalsIgnoreCase("CCSS")){
			setDefaultCCSS();
		}else if(standardVal.equalsIgnoreCase("TEKS")){
			setDefaultTEKS();
		}else if(standardVal.equalsIgnoreCase("NGSS")){
			setDefaultNGSS();
		}else if(standardVal.equalsIgnoreCase("CA")){
			setDefaultCA();
		}
	}
	
	public void hideBrowseStandardsPopup(NativePreviewEvent event){
		try{
			if(event.getTypeInt()==Event.ONMOUSEOVER){
				Event nativeEvent = Event.as(event.getNativeEvent());
				boolean target=eventTargetsPopup(nativeEvent);
				if(!target)
				{
					if(isBrowseStandardsToolTip){
						browseStandardsTooltip.hide();
					}
				}
			}
		}catch(Exception ex){ex.printStackTrace();}
	}
	
	private boolean eventTargetsPopup(NativeEvent event) {
		EventTarget target = event.getEventTarget();
		if (Element.is(target)) {
			try{
				return browseStandardsTooltip.getElement().isOrHasChild(Element.as(target));
			}catch(Exception ex){}
		}
		return false;
	}
	
	
	
	public static native void invokestandrs1() /*-{
		
		$wnd.searchStandard1();
	}-*/;
	
	public static native void invokestandrs2() /*-{
		
		$wnd.searchStandard2();
	}-*/;
	
	public static native void invokestandrs3() /*-{
		
		$wnd.searchStandard3();
	}-*/;
	public static native void invokestandrs4() /*-{
	
		$wnd.searchStandard4();
	}-*/;


}
