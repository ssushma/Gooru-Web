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
package org.ednovo.gooru.client.mvp.classpage.teach.edit;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.mvp.gsearch.util.GooruGradesPresenter;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.uc.SpanPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


/**
 * @fileName : EditClassSettingsView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 01-Jul-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class EditClassSettingsView extends BaseViewWithHandlers<EditClassSettingsViewUiHandler> implements IsEditClassSettingsView {
	
	@UiField HTMLPanel gradeWidget,gradeBlock;
	
	@UiField HTMLEventPanel publicPanel,privatePanel;
	
	@UiField Label anyonwwithLink,privateLbl,privateLblTxt,anyonwwithLinkTxt;
	
	@UiField PPanel classTitleLbl,gradePanel,bannerImagePanel,classCodePanel,sharePanel,visiblityPanel;
	
	@UiField SpanPanel uploadImagePanel,classCodeTxtPanel;
	
	@UiField TextBox classTitleTextLbl,shareUrlTxtLbl;
	
	@UiField Button saveBtn;
	
	GooruGradesPresenter gooruGradesPresenterWidget = AppClientFactory.getInjector().getGooruGradePresenter();
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String QUESTIONIMAGE = "images/question.png";
	
	private static EditClassSettingsViewUiBinder uiBinder = GWT.create(EditClassSettingsViewUiBinder.class);

	interface EditClassSettingsViewUiBinder extends
			UiBinder<Widget, EditClassSettingsView> {
	}

	
	public EditClassSettingsView() {
		setWidget(uiBinder.createAndBindUi(this));
		setIds();
		
	}
	
	public void setIds(){
		
		gradeWidget.getElement().setId("gooruSearchMainContainer");
		gooruGradesPresenterWidget.getView().getGradeHeader().setVisible(false);
		gradeBlock.add(gooruGradesPresenterWidget.getWidget());
		
		publicPanel.getElement().setId("panelPublic");
		publicPanel.getElement().setAttribute("alt","public");
		publicPanel.getElement().setAttribute("title","public");
		
		privatePanel.getElement().setId("panelPrivate");
		publicPanel.getElement().setAttribute("alt","public");
		publicPanel.getElement().setAttribute("title","public");
		
		anyonwwithLink.getElement().setInnerText(i18n.GL3338());
		anyonwwithLinkTxt.getElement().setInnerText(i18n.GL3339());
		privateLbl.getElement().setInnerText(i18n.GL3340());
		privateLblTxt.getElement().setInnerText(i18n.GL3341());
		
		classTitleLbl.setText(i18n.GL3347());
		classTitleLbl.getElement().setId("classTitleLblId");
		classTitleLbl.getElement().setAttribute("alt",i18n.GL3347());
		classTitleLbl.getElement().setAttribute("title",i18n.GL3347());
		
		gradePanel.setText(i18n.GL0325());
		gradePanel.getElement().setId("classGradeLblId");
		gradePanel.getElement().setAttribute("alt",i18n.GL0325());
		gradePanel.getElement().setAttribute("title",i18n.GL0325());
		
		
		bannerImagePanel.setText(i18n.GL3348());
		bannerImagePanel.getElement().setId("baneerImageLblId");
		bannerImagePanel.getElement().setAttribute("alt",i18n.GL3348());
		bannerImagePanel.getElement().setAttribute("title",i18n.GL3348());
		
		uploadImagePanel.setText(i18n.GL0912());
		uploadImagePanel.getElement().setId("uploadImageLblId");
		uploadImagePanel.getElement().setAttribute("alt",i18n.GL0912());
		uploadImagePanel.getElement().setAttribute("title",i18n.GL0912());
		
		
		classCodePanel.setText(i18n.GL1592());
		classCodePanel.getElement().setId("classCodeLblId");
		classCodePanel.getElement().setAttribute("alt",i18n.GL1592());
		classCodePanel.getElement().setAttribute("title",i18n.GL1592());
		
		
		
		sharePanel.setText(i18n.GL1594());
		sharePanel.getElement().setId("sharePanelId");
		sharePanel.getElement().setAttribute("alt",i18n.GL1594());
		sharePanel.getElement().setAttribute("title",i18n.GL1594());
		
		visiblityPanel.setText(i18n.GL3342());
		visiblityPanel.getElement().setId("sharePanelId");
		visiblityPanel.getElement().setAttribute("alt",i18n.GL3342());
		visiblityPanel.getElement().setAttribute("title",i18n.GL3342());
		
		Image image = new Image(QUESTIONIMAGE);
		Image shareImage = new Image(QUESTIONIMAGE);
		
		saveBtn.setText(i18n.GL0141());
		saveBtn.getElement().setId("saveBtnId");
		saveBtn.getElement().setAttribute("alt",i18n.GL0141());
		saveBtn.getElement().setAttribute("title",i18n.GL0141());
		
		classCodeTxtPanel.setText("XYZRS");
		
		
		classCodePanel.add(image);
		sharePanel.add(shareImage);
		
	}

}
