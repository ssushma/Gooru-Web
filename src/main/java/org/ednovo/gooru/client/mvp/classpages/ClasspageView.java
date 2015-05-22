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
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @fileName : ClasspageView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Apr 17, 2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
 */
public class ClasspageView extends BaseViewWithHandlers<ClasspageUiHandlers> implements IsClasspageView{

	
	@UiField(provided = true)
	ClasspageCBundle res;
	
	NewClasspagePopupView newPopup=null;
	
	@UiField Button btnNewClasspage;
	
	@UiField HTMLPanel classpageListPanel,classPageLbl,teachLbl,assignLbl,createLbl;
	
	@UiField HTMLPanel placeHolderForEmptyTeach,createClasspageLbl,assignLblClassPage;
	
	@UiField HTMLPanel loadingPanel,addToAssignLbl,shareLbl,shareClassPageText;
	
	@UiField ScrollPanel classPageScrollPanel;
	
	@UiField Image roundOneLbl,addClassPageLbl,roundTwoLbl,addAssignImgLbl,roundThreeLbl,shareImageLbl;
	
	@UiField Label needHelpText;
	
	@UiField Anchor supportCenterLbl;
	
	
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
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	interface ClasspageViewUiBinder extends UiBinder<Widget, ClasspageView>{
		
	}
	@Inject
	public ClasspageView(){
		this.res = ClasspageCBundle.INSTANCE;
		res.css().ensureInjected();
		
		setWidget(uiBinder.createAndBindUi(this));
		classPageLbl.getElement().setInnerText(i18n.GL1397());
		classPageLbl.getElement().setId("pnlClassPage");
		classPageLbl.getElement().setAttribute("alt",i18n.GL1397());
		classPageLbl.getElement().setAttribute("title",i18n.GL1397());
		
		teachLbl.getElement().setInnerText(i18n.GL1382()+i18n.GL_SPL_EXCLAMATION());
		teachLbl.getElement().setId("pnlTeach");
		teachLbl.getElement().setAttribute("alt",i18n.GL1382());
		teachLbl.getElement().setAttribute("title",i18n.GL1382());
		
		assignLbl.getElement().setInnerText(i18n.GL1383());
		assignLbl.getElement().setId("pnlAssign");
		assignLbl.getElement().setAttribute("alt",i18n.GL1383());
		assignLbl.getElement().setAttribute("title",i18n.GL1383());
		
		roundOneLbl.setTitle(i18n.GL1398());
		roundOneLbl.getElement().setId("imgRoundOne");
		roundOneLbl.getElement().setAttribute("title",i18n.GL1398());
		roundOneLbl.setAltText(i18n.GL1398());
		roundOneLbl.setUrl("images/rounded-one.png");
		
		createLbl.getElement().setInnerText(i18n.GL1335());
		createLbl.getElement().setId("pnlCreate");
		createLbl.getElement().setAttribute("alt",i18n.GL1335());
		createLbl.getElement().setAttribute("title",i18n.GL1335());
		
		createClasspageLbl.getElement().setInnerText(i18n.GL1399());
		createClasspageLbl.getElement().setId("pnlCreateClassPage");
		createClasspageLbl.getElement().setAttribute("alt",i18n.GL1399());
		createClasspageLbl.getElement().setAttribute("title",i18n.GL1399());
		
		addClassPageLbl.setTitle(i18n.GL1381());
		addClassPageLbl.setAltText(i18n.GL1381());
		addClassPageLbl.setUrl("images/Classpage/classpage-image.png");
		addClassPageLbl.getElement().setId("imgAddClassPage");
		
		roundTwoLbl.setTitle(i18n.GL1400());
		roundOneLbl.getElement().setId("imgRoundTwo");
		roundOneLbl.getElement().setAttribute("title",i18n.GL1400());
		roundTwoLbl.setAltText(i18n.GL1400());
		roundTwoLbl.setUrl("images/rounded-two.png");
		
		assignLblClassPage.getElement().setInnerText(i18n.GL1401());
		assignLblClassPage.getElement().setId("pnlAssignClassPage");
		assignLblClassPage.getElement().setAttribute("alt",i18n.GL1401());
		assignLblClassPage.getElement().setAttribute("title",i18n.GL1401());
		
		addToAssignLbl.getElement().setInnerText(i18n.GL1402());
		addToAssignLbl.getElement().setId("pnlAddToAssign");
		addToAssignLbl.getElement().setAttribute("alt",i18n.GL1402());
		addToAssignLbl.getElement().setAttribute("title",i18n.GL1402());
		
		addAssignImgLbl.setTitle(i18n.GL1401());
		addAssignImgLbl.setAltText(i18n.GL1401());
		addAssignImgLbl.getElement().setId("imgAssAssignImg");
		addAssignImgLbl.setUrl("images/Classpage/add-assignment-image.png");
		
		roundThreeLbl.setTitle(i18n.GL1403());
		roundThreeLbl.setAltText(i18n.GL1403());
		roundThreeLbl.getElement().setId("imgRoundThree");
		roundThreeLbl.setUrl("images/rounded-three.png");
		
		shareLbl.getElement().setInnerText(i18n.GL0536());
		shareLbl.getElement().setId("pnlShare");
		shareLbl.getElement().setAttribute("alt",i18n.GL0536());
		shareLbl.getElement().setAttribute("title",i18n.GL0536());
		
		shareClassPageText.getElement().setInnerText(i18n.GL1404());
		shareClassPageText.getElement().setId("pnlShareClassPageText");
		shareClassPageText.getElement().setAttribute("alt",i18n.GL1404());
		shareClassPageText.getElement().setAttribute("title",i18n.GL1404());
		
		shareImageLbl.setTitle(i18n.GL0526());
		shareImageLbl.setAltText(i18n.GL0526());
		shareImageLbl.getElement().setId("imgShareImage");
		shareImageLbl.setUrl("images/Classpage/share-image.png");
		
		needHelpText.setText(i18n.GL1405());
		needHelpText.getElement().setId("lblNeedHelp");
		needHelpText.getElement().setAttribute("alt",i18n.GL1405());
		needHelpText.getElement().setAttribute("title",i18n.GL1405());
		
		supportCenterLbl.setText(i18n.GL1406());
		supportCenterLbl.getElement().setId("lnkSupportCenter");
		supportCenterLbl.getElement().setAttribute("alt",i18n.GL1406());
		supportCenterLbl.getElement().setAttribute("title",i18n.GL1406());
		supportCenterLbl.setHref("http://support.goorulearning.org/forums");
		
		loadingPanel.setVisible(false);		
		loadingPanel.getElement().setId("pnlLoading");
		
		classPageScrollPanel.setVisible(false);
		classPageScrollPanel.getElement().setId("sbClassPageScrollBar");
		classpageListPanel.getElement().setId("pnlClassPageList");
		
		placeHolderForEmptyTeach.setVisible(true);
		placeHolderForEmptyTeach.getElement().setId("pnlPlaceHolderForEmptyTeach");
		
		btnNewClasspage.setText(i18n.GL1381());
		btnNewClasspage.getElement().setId("btnNewClasspage");
		btnNewClasspage.getElement().setAttribute("alt",i18n.GL1381());
		btnNewClasspage.getElement().setAttribute("title",i18n.GL1381());
	}
	
	
	@UiHandler("btnNewClasspage")
	public void OnClickNewClasspage(ClickEvent event){
		MixpanelUtil.Click_Add_NewClasspage();
		newPopup = new NewClasspagePopupView() {

			@Override
			public void createNewClasspage(String title) {
				MixpanelUtil.Create_NewClasspage();
				CollectionDo collectionDo = new CollectionDo();
				collectionDo.setTitle(title);
				collectionDo.setCollectionType("classpage");
				getUiHandlers().createClasspage(collectionDo);
			}
		};
	}
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
	@Override
	public void insertClasspage(CollectionDo collectionDo, boolean newFlag) {
		
		ClasspageResourceItemChildView classpageResourceItemChildView = new ClasspageResourceItemChildView(collectionDo);
		classpageListPanel.add(classpageResourceItemChildView);
	}


	public ScrollPanel getClassPageScrollPanel() {
		return classPageScrollPanel;
	}

	public void setClassPageScrollPanel(ScrollPanel classPageScrollPanel) {
		this.classPageScrollPanel = classPageScrollPanel;
	}

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
