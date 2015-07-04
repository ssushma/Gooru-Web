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

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.mvp.gsearch.events.UpdateFilterEvent;
import org.ednovo.gooru.client.mvp.gsearch.events.UpdateFilterHandler;
import org.ednovo.gooru.client.mvp.gsearch.util.GooruGradesPresenter;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.uc.SpanPanel;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
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
	
	@UiField SpanPanel classCodeTxtPanel;
	
	@UiField TextBox classTitleTextLbl,shareUrlTxtLbl;
	
	@UiField Button saveBtn,uploadImagePanel;
	
	GooruGradesPresenter gooruGradesPresenterWidget = AppClientFactory.getInjector().getGooruGradePresenter();
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String QUESTIONIMAGE = "images/question.png";
	
	private PopupPanel toolTipPopupPanelNew = new PopupPanel();
	
	private PopupPanel toolTipPopupPanelNew1 = new PopupPanel();
	
	private static final List<String> gradeList = new ArrayList<String>();
	
	private static EditClassSettingsViewUiBinder uiBinder = GWT.create(EditClassSettingsViewUiBinder.class);

	interface EditClassSettingsViewUiBinder extends
			UiBinder<Widget, EditClassSettingsView> {
	}

	
	public EditClassSettingsView() {
		setWidget(uiBinder.createAndBindUi(this));
		AppClientFactory.getEventBus().addHandler(UpdateFilterEvent.TYPE, updatefilter);
		setIds();
		
		uploadImagePanel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MixpanelUtil.ClickOnEditImage();
				getUiHandlers().showImageUploadWidget();
			}
		});
		publicPanel.addClickHandler(new SharingVisiblityClickHandler(publicPanel));
		privatePanel.addClickHandler(new SharingVisiblityClickHandler(privatePanel));
		
	}
	
	UpdateFilterHandler updatefilter = new UpdateFilterHandler() {
		@Override
		public void updateFilters(String filterValue, String addOrRemove) {
			if("add".equals(addOrRemove)){
				gradeList.add(filterValue);
			}else{
				gradeList.remove(filterValue);
			}
		}
	};
	
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
		
		classTitleLbl.setText(i18n.GL3401());
		classTitleLbl.getElement().setId("classTitleLblId");
		classTitleLbl.getElement().setAttribute("alt",i18n.GL3401());
		classTitleLbl.getElement().setAttribute("title",i18n.GL3401());
		
		gradePanel.setText(i18n.GL0325());
		gradePanel.getElement().setId("classGradeLblId");
		gradePanel.getElement().setAttribute("alt",i18n.GL0325());
		gradePanel.getElement().setAttribute("title",i18n.GL0325());
		
		
		bannerImagePanel.setText(i18n.GL3402());
		bannerImagePanel.getElement().setId("baneerImageLblId");
		bannerImagePanel.getElement().setAttribute("alt",i18n.GL3402());
		bannerImagePanel.getElement().setAttribute("title",i18n.GL3402());
		
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
		
		visiblityPanel.setText(i18n.GL3342());
		visiblityPanel.getElement().setId("sharePanelId");
		visiblityPanel.getElement().setAttribute("alt",i18n.GL3342());
		
		Image image = new Image(QUESTIONIMAGE);
		image.addMouseOverHandler(new MouseOverShowClassCodeToolTip1());
		image.addMouseOutHandler(new MouseOutHideToolTip1());
		
		Image shareImage = new Image(QUESTIONIMAGE);
		shareImage.addMouseOverHandler(new MouseOverShowClassCodeToolTip2());
		shareImage.addMouseOutHandler(new MouseOutHideToolTip2());
		
		saveBtn.setText(i18n.GL0141());
		saveBtn.getElement().setId("saveBtnId");
		saveBtn.getElement().setAttribute("alt",i18n.GL0141());
		saveBtn.getElement().setAttribute("title",i18n.GL0141());
		
		classCodeTxtPanel.setText("XYZRS");
		
		
		classCodePanel.add(image);
		sharePanel.add(shareImage);
		
	}
	
	/**
	 * 
	 * @fileName : EditClassSettingsView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jul-2015
	 *
	 * @Author tumbalam
	 *
	 * @Reviewer:
	 */
	
	public class MouseOverShowClassCodeToolTip1 implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanelNew.clear();
			toolTipPopupPanelNew.setWidget(new GlobalToolTip(i18n.GL2090()));
			toolTipPopupPanelNew.setStyleName("");
			toolTipPopupPanelNew.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 14, event.getRelativeElement().getAbsoluteTop());
			toolTipPopupPanelNew.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanelNew.show();
		}

	}
	
	/**
	 * 
	 * @fileName : EditClassSettingsView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jul-2015
	 *
	 * @Author tumbalam
	 *
	 * @Reviewer:
	 */
	
	public class MouseOutHideToolTip1 implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanelNew.hide();
		}
	}
	/**
	 * 
	 * @fileName : EditClassSettingsView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jul-2015
	 *
	 * @Author tumbalam
	 *
	 * @Reviewer:
	 */
	public class MouseOverShowClassCodeToolTip2 implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanelNew1.clear();
			toolTipPopupPanelNew1.setWidget(new GlobalToolTip(i18n.GL2091()));
			toolTipPopupPanelNew1.setStyleName("");
			toolTipPopupPanelNew1.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 14, event.getRelativeElement().getAbsoluteTop());
			toolTipPopupPanelNew1.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanelNew1.show();
		}

	}
	/**
	 * 
	 * @fileName : EditClassSettingsView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jul-2015
	 *
	 * @Author tumbalam
	 *
	 * @Reviewer:
	 */
	public class MouseOutHideToolTip2 implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanelNew1.hide();
		}
	}
	
	private class SharingVisiblityClickHandler implements ClickHandler{
		   
		 HTMLEventPanel eventPanel;
		 
		 public SharingVisiblityClickHandler(HTMLEventPanel eventPanel){
			 this.eventPanel=eventPanel;
		 }

		/* (non-Javadoc)
		 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
		 */
		@Override
		public void onClick(ClickEvent event) {
				String id = eventPanel.getElement().getId();
				if(!eventPanel.getStyleName().contains("active")){
					if(id.equalsIgnoreCase("panelPublic")){
						publicPanel.addStyleName("active");
						privatePanel.removeStyleName("active");
					}else{
						privatePanel.addStyleName("active");
						publicPanel.removeStyleName("active");
					}
			}
		}
	}

}
