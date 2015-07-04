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
package org.ednovo.gooru.client.mvp.gshelf.righttabs;

import java.util.ArrayList;
import java.util.Iterator;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.drive.DriveView.BreadCrumbLabel;
import org.ednovo.gooru.shared.util.ClientConstants;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MyCollectionsRightClusterView extends BaseViewWithHandlers<MyCollectionsRightClusterUiHandlers> implements IsMyCollectionsRightClusterView,ClientConstants  {

	private static MyCollectionsRightViewUiBinder uiBinder = GWT.create(MyCollectionsRightViewUiBinder.class);

	interface MyCollectionsRightViewUiBinder extends UiBinder<Widget, MyCollectionsRightClusterView> {
	}
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField HTMLPanel mainPanel,pnlSlotInnerContent;
	@UiField Anchor lnkInfo,lnkContent,lnkshare;
	
	@UiField FlowPanel pnlBreadCrumbMain;
	
	FolderDo folderObj;
	
	final String ACTIVE="active";
	private static final String O1_LEVEL = "o1";
	private static final String O2_LEVEL = "o2";
	private static final String O3_LEVEL = "o3";
	
	private static final String COURSE = "Course";
	private static final String UNIT = "Unit";
	private static final String LESSON = "Lesson";
	
	private String currentTypeView;
	String o1,o2,o3;
	String oldO1Value=null,oldO2Value=null,oldO3Value=null;
	
	ArrayList<String> breadCumsSting=new ArrayList<String>();
	
	
	public MyCollectionsRightClusterView() {
		setWidget(uiBinder.createAndBindUi(this));
		setIds();
		lnkInfo.addClickHandler(new TabClickHandler(1,lnkInfo));
		lnkContent.addClickHandler(new TabClickHandler(2,lnkContent));
		lnkshare.addClickHandler(new TabClickHandler(3,lnkshare));
	}
	public void setIds(){
		mainPanel.getElement().setId("gShelfCourseInfo");
		pnlSlotInnerContent.getElement().setId("pnlSlotInnerContent");
		lnkInfo.getElement().setId("lnkInfo");
		lnkContent.getElement().setId("lnkContent");
		lnkshare.getElement().setId("lnkshare");
		pnlBreadCrumbMain.getElement().setId("pnlBreadCrumbMain");
	}
	/**
	 * This inner class will handle the click event on the info,content and share tab.
	 */
	class TabClickHandler implements ClickHandler{
		int index;
		Anchor selectedTab;
		TabClickHandler(int index,Anchor selectedTab){
			this.index=index;
			this.selectedTab=selectedTab;
		}
		@Override
		public void onClick(ClickEvent event) {
			resetHilightStyles();
			selectedTab.setStyleName(ACTIVE);
			getUiHandlers().setTabItems(index, currentTypeView,folderObj);
		}
	}
	@Override
	public void resetHilightStyles(){
		lnkInfo.removeStyleName(ACTIVE);
		lnkContent.removeStyleName(ACTIVE);
		lnkshare.removeStyleName(ACTIVE);
	}
	@Override
	public void setInSlot(Object slot, Widget content) {
		pnlSlotInnerContent.clear();
		if(content!=null){
		  if(slot==MyCollectionsRightClusterPresenter.INNER_SLOT){
				pnlSlotInnerContent.add(content);
			}
		}
	}
	@Override
	public void setBreadCrumbSlot(FolderDo folderObj, String type){
		if(folderObj!=null){
			this.folderObj=folderObj;
		}
		 String title=folderObj!=null?folderObj.getTitle():"";
		 setBreadCrumbs(title,type);
		 
	}
	
	/**
	 * Used to set the Bread crumbs.
	 * @param title
	 * @param type
	 */
	private void setBreadCrumbs(String title, String type) {
		
		if(COURSE.equalsIgnoreCase(type)){
			pnlBreadCrumbMain.clear();
			pnlBreadCrumbMain.add(new BreadcrumbItem(StringUtil.isEmpty(title)?i18n.GL3347():title, type));
		}else if(UNIT.equalsIgnoreCase(type)){
			if(pnlBreadCrumbMain.getWidgetCount()<2){
				pnlBreadCrumbMain.add(new BreadcrumbItem(StringUtil.isEmpty(title)?i18n.GL3364():title, type));
			}else{
				getBreadCrumbs(title,type,2);
			}
		}else if(LESSON.equalsIgnoreCase(type)){
			if(pnlBreadCrumbMain.getWidgetCount()<3){
				pnlBreadCrumbMain.add(new BreadcrumbItem(StringUtil.isEmpty(title)?i18n.GL3365():title, type));
			}else{
				getBreadCrumbs(title,type,3);
			}
		}else{
			
		}
	}
	
	/**
	 * gets the current bread crumbs item and updates the title.
	 * @param title {@link String}
	 * @param type {@link String}
	 * @param index {@link int}
	 */
	public void getBreadCrumbs(String title,String type,int index){
		Iterator<Widget> breadCrumbswidgets = pnlBreadCrumbMain.iterator();
		while(breadCrumbswidgets.hasNext()){
			Widget widget = breadCrumbswidgets.next();
			if(widget instanceof BreadcrumbItem && ((BreadcrumbItem) widget).getType().equalsIgnoreCase(type)){ 
				BreadcrumbItem breadCrumbItem=(BreadcrumbItem)widget;
				breadCrumbItem.getLabel().setText(title);
				removeBreadCrumbs(index);
			}
		}
	}
	
	/**
	 * Removes the the bread crumbs.
	 * @param index
	 */
	private void removeBreadCrumbs(int index) {
		int widgetCount=pnlBreadCrumbMain.getWidgetCount();
		for(int i=index;i<widgetCount;){
			BreadcrumbItem breadCrumbItem=(BreadcrumbItem)pnlBreadCrumbMain.getWidget(i);
			breadCrumbItem.removeFromParent();
			widgetCount=pnlBreadCrumbMain.getWidgetCount();
		}
	}
	/**
	 * This method is used to set breadcums
	 * @param title
	 */
	public void setBreadCums(String title){
		setRequestParams();
		if(o1==null || !oldO1Value.equals(o1)){
			breadCumsSting.clear();
			pnlBreadCrumbMain.clear();
		}
		if(!breadCumsSting.contains(title)){
			breadCumsSting.add(title);
			pnlBreadCrumbMain.add(new BreadcrumbItem(title, folderObj.getCollectionType()));
		}else{
			int index= breadCumsSting.indexOf(title);
			if(index!=-1){
				for(int i=pnlBreadCrumbMain.getWidgetCount();i>(index+1);i--){
					pnlBreadCrumbMain.getWidget(i-1).removeFromParent();
					breadCumsSting.remove(i-1);
				}
			}
		}
	}
	
	@Override
	public void setDefaultActiveTab(int tabIndex){
		resetHilightStyles();
		if(tabIndex==2){
			lnkContent.addStyleName(ACTIVE);
		}else if(tabIndex==3){
			lnkshare.addStyleName(ACTIVE);
		}else{
			lnkInfo.addStyleName(ACTIVE);
		}
		
	}
	/**
	 * This inner class is used to generate breadcum item widget
	 */
	class BreadcrumbItem extends Composite {
		 Label lblTitle;
		 private String type;
		 public BreadcrumbItem(String title,String type) {
			 this.type = type;
			 HTMLPanel panel=new HTMLPanel("");
			 panel.setStyleName("active");
			 InlineLabel spnIcon=new InlineLabel();
			 if(COURSE.equalsIgnoreCase(type)){
				 spnIcon.setStyleName("courseFolderCloseIcon");
			 }else if(UNIT.equalsIgnoreCase(type)){
				 spnIcon.setStyleName("unitFolderCloseIcon");
			 }else{
				 spnIcon.setStyleName("lessonFolderCloseIcon");
			 }
			 lblTitle=new Label(title);
			 lblTitle.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
			 panel.add(spnIcon);
			 panel.add(lblTitle);
			 initWidget(panel);
		 }
		 public Label getLabel(){
			 return  lblTitle;
		 }
		 
		 public String getType(){
			 return  type;
		 }
	}
	
	public void setRequestParams(){
		o1=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
		o2=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
		o3=AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL,null);
		if(oldO1Value==null){
			oldO1Value=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
		}
		if(oldO2Value==null){
			oldO2Value=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
		}
		if(oldO3Value==null){
			oldO3Value=AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL,null);
		}
	}
	@Override
	public void setCurrentTypeView(String currentTypeView) {
		this.currentTypeView =currentTypeView;
	}
}
