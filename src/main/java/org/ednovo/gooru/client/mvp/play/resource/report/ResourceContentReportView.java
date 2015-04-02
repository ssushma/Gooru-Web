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
package org.ednovo.gooru.client.mvp.play.resource.report;


import java.util.ArrayList;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.player.resource.client.ResourcePlayerComponentService;
import org.ednovo.gooru.player.resource.client.ResourcePlayerComponentServiceAsync;
import org.ednovo.gooru.player.resource.client.presenter.ResourcePlayerPresenter;
import org.ednovo.gooru.player.resource.client.ui.HTMLEventPanel;
import org.ednovo.gooru.player.resource.client.view.resourceplayer.QuestionResourceImageBundle;
import org.ednovo.gooru.player.resource.shared.GetFlagContentDO;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class ResourceContentReportView extends PopupPanel{

	private static ResourceFlagToolTipUiBinder uiBinder = GWT
			.create(ResourceFlagToolTipUiBinder.class);

	interface ResourceFlagToolTipUiBinder extends
			UiBinder<Widget, ResourceContentReportView> {
	}
	
	
	private ResourcePlayerComponentServiceAsync  playerRpcService = GWT.create(ResourcePlayerComponentService.class);
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	ResourceContentReportView resourceFlagToolTip;
	@UiField HTMLEventPanel closeButton;
	@UiField Button cancelButton,submitButton,submitButtonGray;
	@UiField Image popUpCloseButton;
	@UiField TextArea descriptionTextArea;
	@UiField CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
	@UiField HTML titleText;
	@UiField Label flagText,inappropriateText,unavailableText,inaccurateText,otherReasonText,provideMoreText;
	private String restEndPoint;
	private String session;
	private String assocGooruOid;
	int formateSize=0;
	HTMLEventPanel resourceflagButton=new HTMLEventPanel("");
//	private static final String HEADER_LINK = i18n.GL1430;
	String gooruOid="";
	String contentResourceGooruOid="";
	String formatting1="";
	String formatting2="";
	String formatting3="";
	String formatting4="";
	private static ResourcePlayerPresenter resourcePlayerPresenter = null;
	ArrayList<String> gooruOidList=new ArrayList<String>();

	public ResourceContentReportView(String restEndPoint,String session,String assocGooruOid,final HTMLEventPanel resourceflagButton,String resourceTitle) {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle().ensureInjected();
		this.getElement().getStyle().setZIndex(999999);
		this.setGlassStyleName(FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle().glassStyle());
		setGlassEnabled(true);
		flagText.setText(i18n.GL0600());
		flagText.getElement().setId("lblFlagText");
		flagText.getElement().setAttribute("alt",i18n.GL0600());
		flagText.getElement().setAttribute("title",i18n.GL0600());
		
		inappropriateText.setText(i18n.GL0612());
		inappropriateText.getElement().setId("lblInappropriateText");
		inappropriateText.getElement().setAttribute("alt",i18n.GL0612());
		inappropriateText.getElement().setAttribute("title",i18n.GL0612());
		
		unavailableText.setText(i18n.GL0613());
		unavailableText.getElement().setId("lblUnavailableText");
		unavailableText.getElement().setAttribute("alt",i18n.GL0613());
		unavailableText.getElement().setAttribute("title",i18n.GL0613());
		
		inaccurateText.setText(i18n.GL0614());
		inaccurateText.getElement().setId("lblInaccurateText");
		inaccurateText.getElement().setAttribute("alt",i18n.GL0614());
		inaccurateText.getElement().setAttribute("title",i18n.GL0614());
		
		otherReasonText.setText(i18n.GL0606());
		otherReasonText.getElement().setId("lblOtherReasonText");
		otherReasonText.getElement().setAttribute("alt",i18n.GL0606());
		otherReasonText.getElement().setAttribute("title",i18n.GL0606());
		
		provideMoreText.setText(i18n.GL0607());
		provideMoreText.getElement().setId("lblProvideMoreText");
		provideMoreText.getElement().setAttribute("alt",i18n.GL0607());
		provideMoreText.getElement().setAttribute("title",i18n.GL0607());
		
		cancelButton.setText(i18n.GL0608());
		cancelButton.getElement().setAttribute("id", "cancelButton");
		cancelButton.getElement().setAttribute("alt",i18n.GL0608());
		cancelButton.getElement().setAttribute("title",i18n.GL0608());
		
		submitButton.setText(i18n.GL0486());
		submitButton.getElement().setAttribute("id", "SubmitButton");
		submitButton.getElement().setAttribute("alt",i18n.GL0486());
		submitButton.getElement().setAttribute("title",i18n.GL0486());
		
		submitButtonGray.setText(i18n.GL0486());
		submitButtonGray.getElement().setAttribute("id", "SubmitButtonInactive");
		submitButtonGray.getElement().setAttribute("alt",i18n.GL0486());
		submitButtonGray.getElement().setAttribute("title",i18n.GL0486());
		
		this.restEndPoint=restEndPoint;
		this.session=session;
		this.assocGooruOid=assocGooruOid;
		this.resourceflagButton=resourceflagButton;
		if(!StringUtil.isEmpty(resourceTitle)){
			resourceTitle=resourceTitle.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
			titleText.setHTML(i18n.GL1430() +resourceTitle+" \" "+i18n.GL1431()+"");
			titleText.getElement().setAttribute("alt",i18n.GL1430() +resourceTitle+" \" "+i18n.GL1431()+"");
			titleText.getElement().setAttribute("title",i18n.GL1430() +resourceTitle+" \" "+i18n.GL1431()+"");
		}
		
		submitButtonGray.setVisible(true);
		submitButton.setVisible(false);
		
	
	
		resourcePlayerPresenter=new ResourcePlayerPresenter();
		popUpCloseButton.setResource(FlagBundle.IMAGEBUNDLEINSTANCE.closeFlagPopUpImages());

		playerRpcService.getContentReport(restEndPoint, session, assocGooruOid, new SimpleAsyncCallback<GetFlagContentDO>() {

			@Override
			public void onSuccess(GetFlagContentDO result) {
			ArrayList<String> formateType=new ArrayList<String>();
			if(result!=null&&result.getGetTypeList()!=null) {
				if(result.getGetTypeList().size()>0){
					formateType.addAll(result.getGetTypeList());
					gooruOidList.addAll(result.getGetAsscociatedId());
					for(int i=0;i<gooruOidList.size();i++)
					{
						gooruOid+=gooruOidList.get(i)+",";
					}
					}
					formateSize=formateType.size();
			}
			}
		});
		
		closeButton.getElement().setId("epnlCloseButton");
		popUpCloseButton.getElement().setId("imgPopUpCloseButton");
		titleText.getElement().setId("htmlTitleText");
		checkBox4.getElement().setId("chkCheckBox4");
		checkBox3.getElement().setId("chkCheckBox3");
		checkBox2.getElement().setId("chkCheckBox2");
		checkBox1.getElement().setId("chkCheckBox1");
		descriptionTextArea.getElement().setId("tatDescriptionTextArea");
		StringUtil.setAttributes(descriptionTextArea, true);
	}

	@UiHandler("closeButton")
	public void onClickOfcloseButton(ClickEvent event)
	{
	this.hide();
	}
	@UiHandler("cancelButton")
	public void onClickOfCancelButton(ClickEvent event)
	{
	checkBox1.setValue(false);
	checkBox2.setValue(false);
	checkBox3.setValue(false);
	checkBox4.setValue(false);
	descriptionTextArea.setText("");
	
	}
	@UiHandler("checkBox1")
	public void onClickOfcheckBox1(ClickEvent event)
	{
	if(checkBox1.getValue()||checkBox2.getValue()||checkBox3.getValue()||checkBox4.getValue())
		{
			submitButtonGray.setVisible(false);
			submitButton.setVisible(true);
		}
		else
		{
			submitButtonGray.setVisible(true);
			submitButton.setVisible(false);
		}
		
	}
	@UiHandler("checkBox2")
	public void onClickOfcheckBox2(ClickEvent event)
	{
		if(checkBox2.getValue()||checkBox3.getValue()||checkBox4.getValue()||checkBox1.getValue())
		{
			submitButtonGray.setVisible(false);
			submitButton.setVisible(true);
		}
		else
		{
			submitButtonGray.setVisible(true);
			submitButton.setVisible(false);
		}
		
	}
	@UiHandler("checkBox3")
	public void onClickOfcheckBox3(ClickEvent event)
	{
		if(checkBox3.getValue()||checkBox4.getValue()||checkBox2.getValue()||checkBox1.getValue())
		{
			submitButtonGray.setVisible(false);
			submitButton.setVisible(true);
		}
		else
		{
			submitButtonGray.setVisible(true);
			submitButton.setVisible(false);
		}
		
	}
	
	@UiHandler("checkBox4")
	public void onClickOfcheckBox4(ClickEvent event)
	{
		if(checkBox4.getValue()||checkBox3.getValue()||checkBox2.getValue()||checkBox1.getValue())
		{
			submitButtonGray.setVisible(false);
			submitButton.setVisible(true);
		}
		else
		{
			submitButtonGray.setVisible(true);
			submitButton.setVisible(false);
		}
	
	}
	@UiHandler("submitButton")
	public void onClicksubmitButton(ClickEvent event)
	{
		
		if(checkBox1.getValue())
		{
			formatting1="missing-concept";
		}
		if(checkBox2.getValue())
		{
			formatting2="not-loading";
		}
		if(checkBox3.getValue())
		{
			formatting3="inappropriate";
		}
		if(checkBox4.getValue())
		{
		
			formatting4="other";
		}
	
		if(formateSize==0){
			resourcePlayerPresenter.createContentReportData(restEndPoint,session,assocGooruOid,"content",formatting1,formatting2,formatting3,formatting4,descriptionTextArea.getText());
		}
		
		if(formateSize>0){	
			playerRpcService.deleteContentReport(restEndPoint, session, gooruOid, new SimpleAsyncCallback<String>() {

				@Override
				public void onSuccess(String result) {
					if(result==null){
					resourcePlayerPresenter.createContentReportData(restEndPoint,session,assocGooruOid,"content",formatting1,formatting2,formatting3,formatting4,descriptionTextArea.getText());
					
					}
				}
				
			});
			if(!descriptionTextArea.getText().equals("")){
				resourcePlayerPresenter.updateReport(restEndPoint,session,gooruOid,descriptionTextArea.getText());
			}
	}
	getThankYouPopUp();
	}
		
	public void getThankYouPopUp()
	{
	this.hide();
	resourceflagButton.removeStyleName(QuestionResourceImageBundle.IMAGEBUNDLEINSTANCE.questionResourcesStyleImages().flagImageResource());
	resourceflagButton.setStyleName(QuestionResourceImageBundle.IMAGEBUNDLEINSTANCE.questionResourcesStyleImages().flagImageOrange());
	submitButtonGray.setVisible(true);
	submitButton.setVisible(false);
}
}



