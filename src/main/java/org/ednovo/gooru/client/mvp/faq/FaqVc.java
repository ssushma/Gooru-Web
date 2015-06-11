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
package org.ednovo.gooru.client.mvp.faq;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class FaqVc extends Composite {
	
	@UiField Label organizeText,createCollectionText,reOrganizeText,
	editCollectionText,shareResourceLbl,shareResourceText,needHelpLbl,moreAnsweretext,helpText;
	
	@UiField Anchor supportLbl,contactUsText;

	private static faqUiBinder uiBinder = GWT.create(faqUiBinder.class);

	interface faqUiBinder extends UiBinder<Widget, FaqVc> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	/**
	 * Class constructor
	 */
	public FaqVc() {
		initWidget(uiBinder.createAndBindUi(this));
		organizeText.setText(i18n.GL1350()+i18n.GL_SPL_QUESTION());
		organizeText.getElement().setId("lblOrganizeText");
		organizeText.getElement().setAttribute("alt",i18n.GL1350());
		organizeText.getElement().setAttribute("title",i18n.GL1350());
		
		createCollectionText.setText(i18n.GL1351()+i18n.GL_SPL_FULLSTOP());
		createCollectionText.getElement().setId("lblCreateCollectionText");
		createCollectionText.getElement().setAttribute("alt",i18n.GL1351());
		createCollectionText.getElement().setAttribute("title",i18n.GL1351());
		
		reOrganizeText.setText(i18n.GL1352()+i18n.GL_SPL_QUESTION());
		reOrganizeText.getElement().setId("lblReOrganizeText");
		reOrganizeText.getElement().setAttribute("alt",i18n.GL1352());
		reOrganizeText.getElement().setAttribute("title",i18n.GL1352());
		
		editCollectionText.setText(i18n.GL1353());
		editCollectionText.getElement().setId("lblEditCollectionText");
		editCollectionText.getElement().setAttribute("alt",i18n.GL1353());
		editCollectionText.getElement().setAttribute("title",i18n.GL1353());
		
		shareResourceLbl.setText(i18n.GL1354()+i18n.GL_SPL_QUESTION());
		shareResourceLbl.getElement().setId("lblShareResourceLbl");
		shareResourceLbl.getElement().setAttribute("alt",i18n.GL1354());
		shareResourceLbl.getElement().setAttribute("title",i18n.GL1354());
		
		shareResourceText.setText(i18n.GL1355());
		shareResourceText.getElement().setId("lblShareResourceText");
		shareResourceText.getElement().setAttribute("alt",i18n.GL1355());
		shareResourceText.getElement().setAttribute("title",i18n.GL1355());
		
		needHelpLbl.setText(i18n.GL1356()+i18n.GL_SPL_QUESTION());
		needHelpLbl.getElement().setId("lblNeedHelp");
		needHelpLbl.getElement().setAttribute("alt",i18n.GL1356());
		needHelpLbl.getElement().setAttribute("title",i18n.GL1356());
		
		supportLbl.setText(i18n.GL1357());
		supportLbl.getElement().setId("lnkSupport");
		supportLbl.getElement().setAttribute("alt",i18n.GL1357());
		supportLbl.getElement().setAttribute("title",i18n.GL1357());
		supportLbl.setHref("http://support.goorulearning.org/forums");
		
		moreAnsweretext.setText(i18n.GL1358());
		moreAnsweretext.getElement().setId("lblMoreAnsweretext");
		moreAnsweretext.getElement().setAttribute("alt",i18n.GL1358());
		moreAnsweretext.getElement().setAttribute("title",i18n.GL1358());
		
		contactUsText.setText(" "+i18n.GL1245());
		contactUsText.getElement().setId("lnkContactUsText");
		contactUsText.getElement().setAttribute("alt"," "+i18n.GL1245());
		contactUsText.getElement().setAttribute("title"," "+i18n.GL1245());
		contactUsText.setHref("http://support.goorulearning.org/anonymous_requests/new");
	
		helpText.setText(" "+i18n.GL1359()+i18n.GL_SPL_EXCLAMATION());
		helpText.getElement().setId("lblHelpText");
		helpText.getElement().setAttribute("alt"," "+i18n.GL1359()+i18n.GL_SPL_EXCLAMATION());
		helpText.getElement().setAttribute("title"," "+i18n.GL1359()+i18n.GL_SPL_EXCLAMATION());
	}

}
