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

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.util.ClientConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MyCollectionsRightClusterView extends BaseViewWithHandlers<MyCollectionsRightClusterUiHandlers> implements IsMyCollectionsRightClusterView,ClientConstants  {

	private static MyCollectionsRightViewUiBinder uiBinder = GWT.create(MyCollectionsRightViewUiBinder.class);

	interface MyCollectionsRightViewUiBinder extends UiBinder<Widget, MyCollectionsRightClusterView> {
	}
	
	@UiField HTMLPanel mainPanel,pnlSlotInnerContent,pnlBreadCrumbMain;
	@UiField Anchor lnkInfo,lnkContent,lnkshare;
	
	HTMLPanel slotPanel;
	FolderDo folderObj;
	
	final String ACTIVE="active";
	private static final String O1_LEVEL = "o1";
	
	String oldO1Value=null;
	
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
			getUiHandlers().setTabItems(index, "Unit",slotPanel,folderObj);
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
	public void setSlotPanel(HTMLPanel slotPanel,FolderDo folderObj){
		 this.slotPanel=slotPanel;
		 this.folderObj=folderObj;
		 String title=folderObj.getTitle();
		 setBreadCums(title);
	}
	/**
	 * This method is used to set breadcums
	 * @param title
	 */
	public void setBreadCums(String title){
		 if(oldO1Value==null){
			 oldO1Value=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
		 }else{
			 if(!oldO1Value.equalsIgnoreCase(AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,""))){
				 breadCumsSting.clear();
				 pnlBreadCrumbMain.clear();
				 oldO1Value=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
			 }
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
	public void setDefaultActiveTab(){
		lnkInfo.addStyleName(ACTIVE);
	}
	/**
	 * This inner class is used to generate breadcum item widget
	 */
	class BreadcrumbItem extends Composite {
		 Label lblTitle;
		 public BreadcrumbItem(String title,String type) {
			 HTMLPanel panel=new HTMLPanel("");
			 panel.setStyleName("active");
			 InlineLabel spnIcon=new InlineLabel();
			 spnIcon.setStyleName("courseFolderCloseIcon");
			 lblTitle=new Label(title);
			 lblTitle.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
			 panel.add(spnIcon);
			 panel.add(lblTitle);
			 initWidget(panel);
		 }
		 public Label getLabel(){
			 return  lblTitle;
		 }
	}
}
