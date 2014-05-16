package org.ednovo.gooru.client.mvp.faq;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class TermsAndPolicyVc_TermsAndPolicyVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc>, org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc.TermsAndPolicyVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<div class='{0}'> <div class='{1}'> <div class='{2}'> <span class='{3}'>Privacy Policy</span> </div> <div class='{4}'> <div class='{5}'> <div class='lastUpdated'>Last Updated Date: April 28, 2014</div> <div class='policyTextLinePrivacy' style='text-align:center;'> <span> <b>GOORU PRIVACY POLICY</b> </span> </div> <span class='{6}'>Effective April 28, 2014</span> <span> Ednovo, Inc.( <b>\"Ednovo\", \"our\" \"us\"</b> or <b>\"we\"</b> ) provides this Privacy Policy to inform you of our policies and procedures regarding the collection, use and disclosure of personal information we receive from users of <a class='privacyLinkText' href='http://www.goorulearning.org' target='_blank'>http://www.goorulearning.org</a> (this \" <b>Site</b> \") or our application for tablet computing devices such as the Apple iPad (the \" <b>Application</b> \").This Privacy Policy applies only to information that you provide to us through this Site and Application. Unless otherwise defined in this Privacy Policy, terms used in this Privacy Policy have the same meanings as in our Ednovo Terms of Use, accessible at <b>http://www.goorulearning.org</b>. </span> <br> <br> <span class='{7}'> <b>I. Information Collection and Use</b> </span> <span class='{8}'> As a not-for-profit education technology company, our goal is to collect only the information about our users and their use of our services that will help us provide the best online experience possible. Our primary goals in collecting information are to provide and improve our Site, Application, services, features and content, to administer your use thereof (together, the (\"<b>Gooru Service</b>\") and to enable users to enjoy and easily navigate the Site and Application. </span> <span class='{9}'> <u><b>A. Personally Identifiable Information</b></u> </span> <span class='policyTextLineNew'> <div class='{10}'><b>Information You Provide to Us.</b> When you register to create an account on the Site and Application we will ask you for personally identifiable information. This refers to information about you that can be used to contact or identify you (\"<b>Personal Information</b>\"). Personal Information includes, but is not limited to, your name, email address, age, username and password, date of birth, gender and grade level in school. We will only ask about your grade level if you are age 13 or older.<br></div> <br> <div class='{11}'><b>What Is Done With Your Personal Information?</b> We use your Personal Information to contact you with newsletters or other information that may be of interest to you. If you decide at any time that you no longer wish to receive such communications from us, please follow the unsubscribe instructions provided in any of the communications. (See \"<b>Changing or Deleting Information,</b>\" below.)</div> </span> <span class='{12}'> <b><u>B. Non-Identifying Information</u></b> <br> </span> <span class='policyTextLineNew'> <div class='{13}'><b>What is Non-Identifying Information?</b> We collect information that you provide in connection with your use of the Site and Application (e.g., without limitation, search terms entered, pages viewed, and school network information) (\"Non-Identifying Information \").<br></div> <br> <div class='{14}'><b>What Is Done With Non-Identifying Information?</b> We use your Personal Information (in some cases, in conjunction with your Non-Identifying Information) to provide the Gooru Service and administer your inquiries. Certain Non-Identifying Information would be considered a part of your Personal Information if it were combined with other identifiers (for example, combining your IP address with your school network information) in a way that enables you to be identified. But the same pieces of information are considered Non-Identifying Information when they are taken alone or combined only with other non-identifying information (for example, your viewing preferences). We may combine your Personal Information with Non-Identifying Information and aggregate it with information collected from other Gooru Users (defined below) to provide you with a better experience, to improve the quality and value of the Gooru Service and to analyze and understand how our Site and Application and Gooru Service are used. We may also use the combined information without aggregating it to serve you specifically, for instance to deliver a product to you according to your preferences or restrictions.</div> </span> <span class='{15}'> <b><u>C. Log Data</u></b> <br> </span> <span class='policyTextLineNew'> <div class='{16}'>When you visit the Site and Application, whether you are a customer of Ednovo or are just browsing the Site and Application (any of these, a \" Gooru User\"), our servers automatically record information that your browser sends whenever you visit a website (\"Log Data\").This Log Data may include information such as your computer’s Internet Protocol (\"IP\") address, browser type or the webpage you were visiting before you came to our Site and Application, pages of our Site and Application that you visit, the time spent on those pages, information you search for on our Site and Application, access times and dates, and other statistics. We use this information to monitor and analyze use of the Site and Application and the Gooru Service and for the Site and Application’s technical administration, to increase our Site and Application’s functionality and user-friendliness, and to better tailor it to our visitors’ needs. We also use this information to verify that visitors to the Site and Application meet the criteria required to process their requests. We do not treat Log Data as Personal Information or use it in association with other Personal Information, though we may aggregate, analyze and evaluate such information for the same purposes as stated above regarding other Non-Identifying Information.<br></div> </span> <span class='{17}'> <b><u>D. Cookies</u></b> <br> </span> <span class='policyTextLineNew'> <div class='{18}'>Like many websites, we use \"cookies\" to collect information. A cookie is a small data file that we transfer to your computer’s hard disk for record-keeping purposes. We use cookies for two purposes. First, we utilize persistent cookies to save your registration ID and login password for future logins to the Site. Second, we utilize session ID cookies to enable certain features of the Site, to better understand how you interact with the Site and to monitor aggregate usage and web traffic routing on the Site. Unlike persistent cookies, session cookies are deleted from your computer when you log off from the Site and Service and then close your browser. Third parties providing services on Ednovo’s behalf may also place or read cookies on your browser.<br></div> </span> <span class='{19}'> <b><u>E. How Does Ednovo Respond to Do-Not-Track Signals</u></b> <br> </span> <span class='policyTextLineNew'> <div class='{20}'>Many web browsers such as Chrome, Mozilla Firefox and Internet Explorer give users the ability to disable, reject, or turn off cookies and other tracking technologies. You can instruct your browser, by changing its options, to stop accepting cookies or to prompt you before accepting a cookie from the websites you visit. If you do not accept cookies, however, you may not be able to use all portions of the Site or all functionality of the Gooru Service.<br></div> </span> <span class='{21}'> <b><u>F. Phishing</u></b> <br> </span> <span class='policyTextLineNew'> <div class='{22}'>Identity theft and the practice currently known as \"phishing\" are of great concern to Ednovo. Safeguarding information to help protect you from identity theft is a top priority. We do not and will not, at any time, request your identification in a non-secure or unsolicited e-mail or telephone communication. For more information about phishing, visit the Federal Trade Commission’s website.<br></div> </span> <br><br> <span class='{23}'> <b>II. Information Sharing and Disclosure</b> </span> <span class='{24}'> <b><u>A. Aggregate Information and Non-Identifying Information</u></b> <br> </span> <span class='policyTextLineNew'> <div class='{25}'>We may share aggregated information that does not include Personal Information and we may otherwise disclose Non-Identifying Information and Log Data with third parties for industry analysis, demographic profiling and other purposes. Any aggregated information shared in these contexts will not contain your Personal Information. If you access the Gooru Services via a third party, that third party may have provided us with Personal Information about you. In such instances we may share Non-Identifying Information that we collect about you with the third party.<br></div> </span> <span class='{26}'> <b><u>B. Service Providers </u></b> <br> </span> <span class='policyTextLineNew'> <div class='{27}'>We may employ third party companies and individuals to facilitate our Gooru Service, to provide the Gooru Service on our behalf, to perform Site-related services (e.g., without limitation, maintenance services, database management, web analytics and improvement of the Site’s features) or to assist us in analyzing how our Site and Application and Gooru Service are used. These third parties have access to your Personal Information only to perform these tasks on our behalf and are obligated not to disclose or use it for any other purpose.<br></div> </span> <span class='{28}'> <b><u>C. Compliance with Laws and Law Enforcement</u></b> <br> </span> <span class='policyTextLineNew'> <div class='{29}'>Ednovo cooperates with government and law enforcement officials and private parties to enforce and comply with the law. We will disclose any information about you to government or law enforcement officials or private parties as we, in our sole discretion, believe necessary or appropriate to respond to claims and legal process (including but not limited to subpoenas), to protect the property and rights of Ednovo or a third party, to protect the safety of the public or any person, or to prevent or stop activity we may consider to be, or to pose a risk of being, illegal, unethical or legally actionable activity.<br></div> </span> <span class='{30}'> <b><u>D. Business Transfers</u></b> <br> </span> <span class='policyTextLineNew'> <div class='{31}'>Ednovo may sell, transfer or otherwise share some or all of its assets, in connection with a merger, acquisition, reorganization or sale of assets or in the event of bankruptcy.<br></div> </span> <br><br> <span class='{32}'> <b>III. Changing or Deleting Your Information</b> <br> </span> <span class='policyTextLineNew'> <br> <div class='{33}'>All Ednovo Users may delete the Personal Information provided via the Site and Application by contacting us. If you would like us to delete your account in our system, please contact us at <a href='mailto:support@goorulearning.org'>support@goorulearning.org</a> with a request that we delete your Personal Information from our database. We will use commercially reasonable efforts to honor your request. We may retain an archived copy of your records as required by law or for legitimate business purposes. Ednovo also allows its user to delete comments and collections created. <br></div> </span> <br><br> <span class='{34}'> <b>IV. Security</b> <br> </span> <span class='policyTextLineNew'> <br> <div class='{35}'>Ednovo places high importance with safeguarding your information. Ednovo uses SSL (Secure Socket Layer) to encrypt information transmitted over the internet. We employ reasonable physical, technological, and administrative security measures and attempt to ensure they are applicable under the circumstances. No method of transmission over the Internet, or method of electronic storage, is 100% secure, however. Therefore, while we strive to use commercially acceptable means to protect your personal information, we cannot guarantee its absolute security.We will make any legally required disclosures of any breach of the security, confidentiality, or integrity of your unencrypted electronically stored \"personal data\" (as defined in applicable state statutes on security breach notification) to you via email or conspicuous posting on this Site in the most expedient time possible and without unreasonable delay, insofar as consistent with (i) the legitimate needs of law enforcement or (ii) any measures necessary to determine the scope of the breach and restore the reasonable integrity of the data system.<br></div> </span> <br><br> <span class='{36}'> <b>V. International Transfer</b> <br> </span> <span class='policyTextLineNew'> <br> <div class='{37}'>Your information may be transferred to — and maintained on — computers located outside of your state, province, country or other governmental jurisdiction where the privacy laws may not be as protective as those in your jurisdiction. If you are located outside the United States and choose to provide information to us, Ednovo transfers Personal Information to the United States and processes it there. Your consent to this Privacy Policy followed by your submission of such information represents your agreement to that transfer.<br></div> </span> <br><br> <span class='{38}'> <b>VI. Links to Other Sites</b> <br> </span> <span class='policyTextLineNew'> <br> <div class='{39}'>Our Site and Application contains links to other websites. If you choose to click on a third party link, you will be directed to that third party’s website. The fact that we link to a website is not an endorsement, authorization or representation of our affiliation with that third party, nor is it an endorsement of their privacy or information security policies or practices. We do not exercise control over third party websites. These other websites may place their own cookies or other files on your computer, or collect data or solicit personal information from you. Other sites follow different rules regarding the use or disclosure of the personal information you submit to them. We encourage you to read the privacy policies or statements of the other websites you visit.<br></div> </span> <br><br> <span class='{40}'> <b>VII. Children's Privacy</b> <br> </span> <span class='{41}'> We understand how important privacy is to you, which is why we are committed to creating a safe and secure environment that children of all ages can enjoy when learning. </span> <span class='{42}'> <b><u>A. How Children's Personal Information is Collected</u></b> <br> </span> <span class='policyTextLineNew'> <br> <div class='{43}'>We do not collect information about children unless they attempt to register for an Account. When registering for an Account, the child will be directly asked for his or her date of birth (to determine age) and a parent or guardian’s email address. We will send an email to the parent or guardian’s email address with instructions about how to register for an Account and to create a child’s Account. If the parent or guardian does not respond, all information collected from the child is deleted. Once the parent or guardian registers, he or she can set up a child Account and create a username, password and, optionally, provide the gender of the child.<br></div> </span> <span class='{44}'> <b><u>B. How Personal Information about Children is Used</u></b> <br> </span> <span class='policyTextLineNew'> <br> <div class='{45}'>To the extent any Personal Information is collected about children, it is used for the internal operations of the website and online services, i.e., to provide the Gooru Service and administer inquiries, and as permitted by law.<br></div> </span> <span class='{46}'> <b><u>C. Parental Notification and Consent</u></b> <br> </span> <span class='policyTextLineNew'> <br> <div class='{47}'>If a parent or guardian consents and later decides to revoke his or her consent, the child’s information and Account can be deleted or deactivated by emailing a request to <a href='mailto:support@goorulearning.org'>support@goorulearning.org</a><br></div> </span> <span class='{48}'> <b><u>D. Parental/Guardian Review</u></b> <br> </span> <span class='policyTextLineNew'> <br> <div class='{49}'>As a parent or guardian, you may review your child’s activity on the Site, Services or Application by logging into the child Account or by sending a written request to Ednovo at the physical address below.<br></div> </span> <br><br> <span class='{50}'> <b>VIII. Changes To This Privacy Policy</b> <br> </span> <span class='{51}'> This Privacy Policy may be updated from time to time. We will notify you of any material changes by posting the new Privacy Policy on the Site. You are advised to consult this policy regularly for any changes. </span> <br><br> <span class='{52}'> <b>IX. Contacting Us</b> <br> </span> <span class='{53}'> If you have any questions about this Privacy Policy, please contact us at: </span> <span class='{54}'>Ednovo</span> <span class='{55}'>1032 Elwell Court, Suite 210</span> <span class='{56}'>Palo Alto, CA 94304</span> <span class='{57}'>650-331-0219</span> <span class='{58}'> <a href='mailto:legal@goorulearning.org'>legal@goorulearning.org</a> </span> </div> </div> </div> </div>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22, String arg23, String arg24, String arg25, String arg26, String arg27, String arg28, String arg29, String arg30, String arg31, String arg32, String arg33, String arg34, String arg35, String arg36, String arg37, String arg38, String arg39, String arg40, String arg41, String arg42, String arg43, String arg44, String arg45, String arg46, String arg47, String arg48, String arg49, String arg50, String arg51, String arg52, String arg53, String arg54, String arg55, String arg56, String arg57, String arg58);
     
    @Template("OK")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.privacyCloseButtonClick(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1("" + get_style().termsOfUseDiv() + "", "" + get_style().termsOfUserContainer() + "", "" + get_style().termsOfHeaderTitleDiv() + "", "" + get_style().termsOfUserHeaderText() + "", "" + get_style().termsBodyContainerDiv() + "", "" + get_style().termsContentDiv() + "", "" + get_style().policyTextLine() + "", "" + get_style().policyTextLine() + "", "" + get_style().policyTextLine() + " " + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().policyTextLine() + " " + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().policyTextLine() + " " + get_style().paragraph() + "", "" + get_style().policyTextLine() + "", "" + get_style().policyTextLine() + " " + get_style().paragraph() + "", "" + get_style().contactUs() + "", "" + get_style().contactUs() + "", "" + get_style().contactUs() + "", "" + get_style().contactUs() + "", "" + get_style().contactUs() + "");
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3(get_domId0(), get_domId1());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc_TermsAndPolicyVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc_TermsAndPolicyVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc_TermsAndPolicyVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc_TermsAndPolicyVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc_TermsAndPolicyVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 66 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc_TermsAndPolicyVcUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc_TermsAndPolicyVcUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc_TermsAndPolicyVcUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1902 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();

      // Detach section.
      attachRecord1902.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_HTML2(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_FlowPanel3(), get_domId1Element().get());

      return f_HTMLPanel1;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId0;
    }

    /**
     * Getter for f_HTML2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTML get_f_HTML2() {
      return build_f_HTML2();
    }
    private com.google.gwt.user.client.ui.HTML build_f_HTML2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML f_HTML2 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      f_HTML2.setHTML(template_html1().asString());


      return f_HTML2;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.


      return domId0Element;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId1;
    }

    /**
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_privacyCloseBtn());
      f_FlowPanel3.setStyleName("" + get_style().termsButtonDiv() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for privacyCloseBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_privacyCloseBtn() {
      return build_privacyCloseBtn();
    }
    private com.google.gwt.user.client.ui.Button build_privacyCloseBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button privacyCloseBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      privacyCloseBtn.setHTML(template_html2().asString());
      privacyCloseBtn.setStyleName("" + get_style().privacyCloseButton() + " " + get_style().termsButtonText() + "");
      privacyCloseBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.privacyCloseBtn = privacyCloseBtn;

      return privacyCloseBtn;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.


      return domId1Element;
    }
  }
}
