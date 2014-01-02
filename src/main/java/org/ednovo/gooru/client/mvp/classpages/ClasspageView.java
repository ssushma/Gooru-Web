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
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpages;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupView;
import org.ednovo.gooru.client.mvp.classpages.resource.item.ClasspageResourceItemChildView;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
/**
 * @fileName : ClasspageView.java
 *
 * @description : Top-level view for Class page.
 *
 * @version : 1.0
 *
 * @date: 26-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ClasspageView extends BaseViewWithHandlers<ClasspageUiHandlers> implements IsClasspageView{

	
	@UiField(provided = true)
	ClasspageCBundle res;
	
	NewClasspagePopupView newPopup=null;
	
	
	@UiField FlowPanel mainFlowPanel;

	@UiField Button btnNewClasspage;
	
	@UiField HTMLPanel classpageListPanel;
	
	@UiField HTMLPanel placeHolderForEmptyTeach;
	
	@UiField HTMLPanel loadingPanel;
	
	@UiField ScrollPanel classPageScrollPanel;
	
	/** 
	 * This method is to get the loadingPanel
	 */
	public HTMLPanel getLoadingPanel() {
		return loadingPanel;
	}

	/** 
	 * This method is to set the loadingPanel
	 */
	public void setLoadingPanel(HTMLPanel loadingPanel) {
		this.loadingPanel = loadingPanel;
	}

	/**
	 * Hide classpageListPanel
	 */
	public void clearClasspageListPanel(){
		
		classpageListPanel.clear();
		
	}
	
	/**
	 * Show/Hide placeHolderForEmptyTeach
	 */
	public void showPlaceHolderForEmptyTeach(boolean visibility){
		placeHolderForEmptyTeach.setVisible(true);
	}


	private static ClasspageViewUiBinder uiBinder = GWT.create(ClasspageViewUiBinder.class);
	interface ClasspageViewUiBinder extends UiBinder<Widget, ClasspageView>{
		
	}
	/**
	 * class constructor.
	 */
	@Inject
	public ClasspageView(){
		this.res = ClasspageCBundle.INSTANCE;
		res.css().ensureInjected();
		
		setWidget(uiBinder.createAndBindUi(this));
		loadingPanel.setVisible(false);		
		classPageScrollPanel.setVisible(false);
		placeHolderForEmptyTeach.setVisible(true);
		btnNewClasspage.getElement().setId("btnNewClasspage");
	}
	
	/**
	 * @function OnClickNewClasspage 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This will hanlde the click event for the NewClasspage button.
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("btnNewClasspage")
	public void OnClickNewClasspage(ClickEvent event){
		MixpanelUtil.Click_Add_NewClasspage();
		newPopup = new NewClasspagePopupView() {
			
			@Override
			public void createNewClasspage(String title) {
				MixpanelUtil.Create_NewClasspage();
				CollectionDo collectionDo =new CollectionDo();
				collectionDo.setTitle(title);
				collectionDo.setCollectionType("classpage");
				getUiHandlers().createClasspage(collectionDo);
			}
		};
	}
	/**
	 * This method is used to open a class page in edit mode.
	 */
	@Override
	public void OpenClasspageEdit(String gooruOId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("classpageid", gooruOId);
		params.put("pageNum", "0");
		params.put("pageSize", "10");
		params.put("pos", "1");
		AppClientFactory.getPlaceManager().revealPlace(
				PlaceTokens.EDIT_CLASSPAGE, params);
	}
	/**
	 * This method is used to insert class page.
	 */
	@Override
	public void insertClasspage(CollectionDo collectionDo, boolean newFlag) {
		
		ClasspageResourceItemChildView classpageResourceItemChildView = new ClasspageResourceItemChildView(collectionDo);
		classpageListPanel.add(classpageResourceItemChildView);
	}
	/**
	 * This method is used to get the class page scroll panel.
	 */
	public ScrollPanel getClassPageScrollPanel() {
		return classPageScrollPanel;
	}
	/**
	 * This method is used to set the class page scroll panel.
	 */
	public void setClassPageScrollPanel(ScrollPanel classPageScrollPanel) {
		this.classPageScrollPanel = classPageScrollPanel;
	}
	/**
	 * This method is used to get the list of class pages.
	 */
	@Override
	public HTMLPanel getClasspageListPanel() {
		return classpageListPanel;
	}

	/** 
	 * This method is to get the newPopup
	 */
	@Override
	public NewClasspagePopupView getNewPopup() {
		return newPopup;
	}

	/** 
	 * This method is to set the newPopup
	 */
	public void setNewPopup(NewClasspagePopupView newPopup) {
		this.newPopup = newPopup;
	}
}
