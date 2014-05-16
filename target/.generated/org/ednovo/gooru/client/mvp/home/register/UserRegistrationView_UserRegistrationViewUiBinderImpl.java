package org.ednovo.gooru.client.mvp.home.register;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class UserRegistrationView_UserRegistrationViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.register.UserRegistrationView>, org.ednovo.gooru.client.mvp.home.register.UserRegistrationView.UserRegistrationViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.register.UserRegistrationView owner) {


    return new Widgets(owner).get_userRegisterFloPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.register.UserRegistrationView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCancelClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onUpdateUserClick(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.home.register.UserRegistrationView owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.register.UserRegistrationView_UserRegistrationViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.home.register.UserRegistrationView_UserRegistrationViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.register.UserRegistrationView_UserRegistrationViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.register.UserRegistrationView_UserRegistrationViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.register.UserRegistrationView_UserRegistrationViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 49 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.register.RegisterCBundle res;
    private org.ednovo.gooru.client.mvp.home.register.RegisterCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.home.register.RegisterCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.mvp.home.register.RegisterCBundle) GWT.create(org.ednovo.gooru.client.mvp.home.register.RegisterCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for userRegisterFloPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_userRegisterFloPanel() {
      return build_userRegisterFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_userRegisterFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel userRegisterFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      userRegisterFloPanel.add(get_f_FlowPanel1());
      userRegisterFloPanel.add(get_f_FlowPanel2());
      userRegisterFloPanel.setStyleName("" + get_res().css().registerContentDiv() + "");


      owner.userRegisterFloPanel = userRegisterFloPanel;

      return userRegisterFloPanel;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_welcomeMessageHtml());
      f_FlowPanel1.setStyleName("" + get_res().css().registerMessageDiv() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for welcomeMessageHtml called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_welcomeMessageHtml() {
      return build_welcomeMessageHtml();
    }
    private com.google.gwt.user.client.ui.HTML build_welcomeMessageHtml() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML welcomeMessageHtml = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.


      owner.welcomeMessageHtml = welcomeMessageHtml;

      return welcomeMessageHtml;
    }

    /**
     * Getter for f_FlowPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel2() {
      return build_f_FlowPanel2();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel2.add(get_f_FlowPanel3());
      f_FlowPanel2.add(get_f_FlowPanel4());
      f_FlowPanel2.add(get_f_FlowPanel5());
      f_FlowPanel2.add(get_termsAndConditionFloPanel());
      f_FlowPanel2.add(get_f_FlowPanel14());
      f_FlowPanel2.setStyleName("" + get_res().css().registerFieldsContainer() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_accountTypeFieldLbl());
      f_FlowPanel3.setStyleName("" + get_res().css().registerLeftContainer() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for accountTypeFieldLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_accountTypeFieldLbl() {
      return build_accountTypeFieldLbl();
    }
    private com.google.gwt.user.client.ui.Label build_accountTypeFieldLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label accountTypeFieldLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      accountTypeFieldLbl.setStyleName("" + get_res().css().containerText() + "");


      owner.accountTypeFieldLbl = accountTypeFieldLbl;

      return accountTypeFieldLbl;
    }

    /**
     * Getter for f_FlowPanel4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel4() {
      return build_f_FlowPanel4();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel4 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel4.add(get_accountInformationLbl());
      f_FlowPanel4.setStyleName("" + get_res().css().registerRightContainer() + "");


      return f_FlowPanel4;
    }

    /**
     * Getter for accountInformationLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_accountInformationLbl() {
      return build_accountInformationLbl();
    }
    private com.google.gwt.user.client.ui.Label build_accountInformationLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label accountInformationLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      accountInformationLbl.setStyleName("" + get_res().css().containerText() + "");


      owner.accountInformationLbl = accountInformationLbl;

      return accountInformationLbl;
    }

    /**
     * Getter for f_FlowPanel5 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel5() {
      return build_f_FlowPanel5();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel5 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel5.add(get_f_FlowPanel6());
      f_FlowPanel5.add(get_f_FlowPanel10());
      f_FlowPanel5.setStyleName("" + get_res().css().registerFieldsContainer() + "");


      return f_FlowPanel5;
    }

    /**
     * Getter for f_FlowPanel6 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel6() {
      return build_f_FlowPanel6();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel6 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel6.add(get_firstnameFloPanel());
      f_FlowPanel6.add(get_lastnameFloPanel());
      f_FlowPanel6.add(get_f_FlowPanel7());
      f_FlowPanel6.add(get_f_FlowPanel8());
      f_FlowPanel6.add(get_f_FlowPanel9());
      f_FlowPanel6.setStyleName("" + get_res().css().registerLeftContainer() + "");


      return f_FlowPanel6;
    }

    /**
     * Getter for firstnameFloPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_firstnameFloPanel() {
      return build_firstnameFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_firstnameFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel firstnameFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      firstnameFloPanel.add(get_fName());
      firstnameFloPanel.add(get_firstNameFieldUc());
      firstnameFloPanel.setStyleName("" + get_res().css().registerFormField() + "");


      owner.firstnameFloPanel = firstnameFloPanel;

      return firstnameFloPanel;
    }

    /**
     * Getter for fName called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_fName() {
      return build_fName();
    }
    private com.google.gwt.user.client.ui.Label build_fName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label fName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      fName.setStyleName("" + get_res().css().registerFormInputs() + "");


      owner.fName = fName;

      return fName;
    }

    /**
     * Getter for firstNameFieldUc called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.ValidTextUc get_firstNameFieldUc() {
      return build_firstNameFieldUc();
    }
    private org.ednovo.gooru.client.uc.ValidTextUc build_firstNameFieldUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ValidTextUc firstNameFieldUc = (org.ednovo.gooru.client.uc.ValidTextUc) GWT.create(org.ednovo.gooru.client.uc.ValidTextUc.class);
      // Setup section.
      firstNameFieldUc.setStyleName("" + get_res().css().validationTextBox() + "");


      owner.firstNameFieldUc = firstNameFieldUc;

      return firstNameFieldUc;
    }

    /**
     * Getter for lastnameFloPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_lastnameFloPanel() {
      return build_lastnameFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_lastnameFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel lastnameFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      lastnameFloPanel.add(get_lName());
      lastnameFloPanel.add(get_lastNameFieldUc());
      lastnameFloPanel.setStyleName("" + get_res().css().registerFormField() + "");


      owner.lastnameFloPanel = lastnameFloPanel;

      return lastnameFloPanel;
    }

    /**
     * Getter for lName called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_lName() {
      return build_lName();
    }
    private com.google.gwt.user.client.ui.Label build_lName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lName.setStyleName("" + get_res().css().registerFormInputs() + "");


      owner.lName = lName;

      return lName;
    }

    /**
     * Getter for lastNameFieldUc called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.ValidTextUc get_lastNameFieldUc() {
      return build_lastNameFieldUc();
    }
    private org.ednovo.gooru.client.uc.ValidTextUc build_lastNameFieldUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ValidTextUc lastNameFieldUc = (org.ednovo.gooru.client.uc.ValidTextUc) GWT.create(org.ednovo.gooru.client.uc.ValidTextUc.class);
      // Setup section.
      lastNameFieldUc.setStyleName("" + get_res().css().validationTextBox() + "");


      owner.lastNameFieldUc = lastNameFieldUc;

      return lastNameFieldUc;
    }

    /**
     * Getter for f_FlowPanel7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel7() {
      return build_f_FlowPanel7();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel7 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel7.add(get_uName());
      f_FlowPanel7.add(get_userNameFieldTxtBox());
      f_FlowPanel7.add(get_userNameValidUc());
      f_FlowPanel7.setStyleName("" + get_res().css().registerFormField() + "");


      return f_FlowPanel7;
    }

    /**
     * Getter for uName called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_uName() {
      return build_uName();
    }
    private com.google.gwt.user.client.ui.Label build_uName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label uName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      uName.setStyleName("" + get_res().css().registerFormInputs() + "");


      owner.uName = uName;

      return uName;
    }

    /**
     * Getter for userNameFieldTxtBox called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextBox get_userNameFieldTxtBox() {
      return build_userNameFieldTxtBox();
    }
    private com.google.gwt.user.client.ui.TextBox build_userNameFieldTxtBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox userNameFieldTxtBox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      userNameFieldTxtBox.setStyleName("" + get_res().css().registerFormFields() + "");


      owner.userNameFieldTxtBox = userNameFieldTxtBox;

      return userNameFieldTxtBox;
    }

    /**
     * Getter for userNameValidUc called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.ErrorLabelUc get_userNameValidUc() {
      return build_userNameValidUc();
    }
    private org.ednovo.gooru.client.uc.ErrorLabelUc build_userNameValidUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ErrorLabelUc userNameValidUc = (org.ednovo.gooru.client.uc.ErrorLabelUc) GWT.create(org.ednovo.gooru.client.uc.ErrorLabelUc.class);
      // Setup section.


      owner.userNameValidUc = userNameValidUc;

      return userNameValidUc;
    }

    /**
     * Getter for f_FlowPanel8 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel8() {
      return build_f_FlowPanel8();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel8 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel8.add(get_pWord());
      f_FlowPanel8.add(get_passwordFieldTxtBox());
      f_FlowPanel8.add(get_passwordValidUc());
      f_FlowPanel8.setStyleName("" + get_res().css().registerFormField() + "");


      return f_FlowPanel8;
    }

    /**
     * Getter for pWord called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_pWord() {
      return build_pWord();
    }
    private com.google.gwt.user.client.ui.Label build_pWord() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label pWord = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      pWord.setStyleName("" + get_res().css().registerFormInputs() + "");


      owner.pWord = pWord;

      return pWord;
    }

    /**
     * Getter for passwordFieldTxtBox called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.PasswordTextBox get_passwordFieldTxtBox() {
      return build_passwordFieldTxtBox();
    }
    private com.google.gwt.user.client.ui.PasswordTextBox build_passwordFieldTxtBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.PasswordTextBox passwordFieldTxtBox = (com.google.gwt.user.client.ui.PasswordTextBox) GWT.create(com.google.gwt.user.client.ui.PasswordTextBox.class);
      // Setup section.
      passwordFieldTxtBox.setStyleName("" + get_res().css().registerFormFields() + "");


      owner.passwordFieldTxtBox = passwordFieldTxtBox;

      return passwordFieldTxtBox;
    }

    /**
     * Getter for passwordValidUc called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.ErrorLabelUc get_passwordValidUc() {
      return build_passwordValidUc();
    }
    private org.ednovo.gooru.client.uc.ErrorLabelUc build_passwordValidUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ErrorLabelUc passwordValidUc = (org.ednovo.gooru.client.uc.ErrorLabelUc) GWT.create(org.ednovo.gooru.client.uc.ErrorLabelUc.class);
      // Setup section.


      owner.passwordValidUc = passwordValidUc;

      return passwordValidUc;
    }

    /**
     * Getter for f_FlowPanel9 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel9() {
      return build_f_FlowPanel9();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel9 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel9.add(get_cPword());
      f_FlowPanel9.add(get_confirmPasswordFieldTxtBox());
      f_FlowPanel9.add(get_confirmPasswordValidUc());
      f_FlowPanel9.setStyleName("" + get_res().css().registerFormField() + "");


      return f_FlowPanel9;
    }

    /**
     * Getter for cPword called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_cPword() {
      return build_cPword();
    }
    private com.google.gwt.user.client.ui.Label build_cPword() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label cPword = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      cPword.setStyleName("" + get_res().css().registerFormInputs() + "");


      owner.cPword = cPword;

      return cPword;
    }

    /**
     * Getter for confirmPasswordFieldTxtBox called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.PasswordTextBox get_confirmPasswordFieldTxtBox() {
      return build_confirmPasswordFieldTxtBox();
    }
    private com.google.gwt.user.client.ui.PasswordTextBox build_confirmPasswordFieldTxtBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.PasswordTextBox confirmPasswordFieldTxtBox = (com.google.gwt.user.client.ui.PasswordTextBox) GWT.create(com.google.gwt.user.client.ui.PasswordTextBox.class);
      // Setup section.
      confirmPasswordFieldTxtBox.setStyleName("" + get_res().css().registerFormFields() + "");


      owner.confirmPasswordFieldTxtBox = confirmPasswordFieldTxtBox;

      return confirmPasswordFieldTxtBox;
    }

    /**
     * Getter for confirmPasswordValidUc called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.ErrorLabelUc get_confirmPasswordValidUc() {
      return build_confirmPasswordValidUc();
    }
    private org.ednovo.gooru.client.uc.ErrorLabelUc build_confirmPasswordValidUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ErrorLabelUc confirmPasswordValidUc = (org.ednovo.gooru.client.uc.ErrorLabelUc) GWT.create(org.ednovo.gooru.client.uc.ErrorLabelUc.class);
      // Setup section.


      owner.confirmPasswordValidUc = confirmPasswordValidUc;

      return confirmPasswordValidUc;
    }

    /**
     * Getter for f_FlowPanel10 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel10() {
      return build_f_FlowPanel10();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel10 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel10.add(get_birthdayFloPanel());
      f_FlowPanel10.add(get_f_FlowPanel11());
      f_FlowPanel10.add(get_f_FlowPanel12());
      f_FlowPanel10.add(get_userCategoryFloPanel());
      f_FlowPanel10.setStyleName("" + get_res().css().registerRightContainer() + "");


      return f_FlowPanel10;
    }

    /**
     * Getter for birthdayFloPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_birthdayFloPanel() {
      return build_birthdayFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_birthdayFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel birthdayFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      birthdayFloPanel.add(get_bdLbl());
      birthdayFloPanel.add(get_dateSimPanel());
      birthdayFloPanel.add(get_dateValidationUc());
      birthdayFloPanel.setStyleName("" + get_res().css().registerFormField() + "");


      owner.birthdayFloPanel = birthdayFloPanel;

      return birthdayFloPanel;
    }

    /**
     * Getter for bdLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_bdLbl() {
      return build_bdLbl();
    }
    private com.google.gwt.user.client.ui.Label build_bdLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label bdLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      bdLbl.setStyleName("" + get_res().css().registerRightFormInputs() + "");


      owner.bdLbl = bdLbl;

      return bdLbl;
    }

    /**
     * Getter for dateSimPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_dateSimPanel() {
      return build_dateSimPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_dateSimPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel dateSimPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.


      owner.dateSimPanel = dateSimPanel;

      return dateSimPanel;
    }

    /**
     * Getter for dateValidationUc called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.ErrorLabelUc get_dateValidationUc() {
      return build_dateValidationUc();
    }
    private org.ednovo.gooru.client.uc.ErrorLabelUc build_dateValidationUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ErrorLabelUc dateValidationUc = (org.ednovo.gooru.client.uc.ErrorLabelUc) GWT.create(org.ednovo.gooru.client.uc.ErrorLabelUc.class);
      // Setup section.


      owner.dateValidationUc = dateValidationUc;

      return dateValidationUc;
    }

    /**
     * Getter for f_FlowPanel11 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel11() {
      return build_f_FlowPanel11();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel11 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel11.add(get_emailText());
      f_FlowPanel11.add(get_userEmailFieldLbl());
      f_FlowPanel11.setStyleName("" + get_res().css().registerRightsFormFields() + "");


      return f_FlowPanel11;
    }

    /**
     * Getter for emailText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_emailText() {
      return build_emailText();
    }
    private com.google.gwt.user.client.ui.Label build_emailText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label emailText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      emailText.setStyleName("" + get_res().css().registerRightFormField() + "");


      owner.emailText = emailText;

      return emailText;
    }

    /**
     * Getter for userEmailFieldLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_userEmailFieldLbl() {
      return build_userEmailFieldLbl();
    }
    private com.google.gwt.user.client.ui.Label build_userEmailFieldLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label userEmailFieldLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      userEmailFieldLbl.setStyleName("" + get_res().css().registerRightFormField() + "");


      owner.userEmailFieldLbl = userEmailFieldLbl;

      return userEmailFieldLbl;
    }

    /**
     * Getter for f_FlowPanel12 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel12() {
      return build_f_FlowPanel12();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel12 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel12.add(get_f_FlowPanel13());
      f_FlowPanel12.add(get_genderFocusFocPanel());
      f_FlowPanel12.add(get_genderValidUc());
      f_FlowPanel12.setStyleName("" + get_res().css().registerFormField() + "");


      return f_FlowPanel12;
    }

    /**
     * Getter for f_FlowPanel13 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel13() {
      return build_f_FlowPanel13();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel13 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel13.add(get_genderText());
      f_FlowPanel13.setStyleName("" + get_res().css().genderInputField() + "");


      return f_FlowPanel13;
    }

    /**
     * Getter for genderText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_genderText() {
      return build_genderText();
    }
    private com.google.gwt.user.client.ui.Label build_genderText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label genderText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.genderText = genderText;

      return genderText;
    }

    /**
     * Getter for genderFocusFocPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_genderFocusFocPanel() {
      return build_genderFocusFocPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_genderFocusFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel genderFocusFocPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      genderFocusFocPanel.add(get_genderFieldsFloPanel());


      owner.genderFocusFocPanel = genderFocusFocPanel;

      return genderFocusFocPanel;
    }

    /**
     * Getter for genderFieldsFloPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_genderFieldsFloPanel() {
      return build_genderFieldsFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_genderFieldsFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel genderFieldsFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      genderFieldsFloPanel.add(get_female());
      genderFieldsFloPanel.add(get_male());
      genderFieldsFloPanel.add(get_other());
      genderFieldsFloPanel.add(get_donot());
      genderFieldsFloPanel.setStyleName("" + get_res().css().registerGenderRow() + "");


      owner.genderFieldsFloPanel = genderFieldsFloPanel;

      return genderFieldsFloPanel;
    }

    /**
     * Getter for female called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private org.ednovo.gooru.client.uc.GenderRadioButton get_female() {
      return build_female();
    }
    private org.ednovo.gooru.client.uc.GenderRadioButton build_female() {
      // Creation section.
      final org.ednovo.gooru.client.uc.GenderRadioButton female = new org.ednovo.gooru.client.uc.GenderRadioButton("gender");
      // Setup section.
      female.setStyleName("" + get_res().css().genderoptions() + "");
      female.setGenderValue("F");


      owner.female = female;

      return female;
    }

    /**
     * Getter for male called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private org.ednovo.gooru.client.uc.GenderRadioButton get_male() {
      return build_male();
    }
    private org.ednovo.gooru.client.uc.GenderRadioButton build_male() {
      // Creation section.
      final org.ednovo.gooru.client.uc.GenderRadioButton male = new org.ednovo.gooru.client.uc.GenderRadioButton("gender");
      // Setup section.
      male.setStyleName("" + get_res().css().genderoptions() + "");
      male.setGenderValue("M");


      owner.male = male;

      return male;
    }

    /**
     * Getter for other called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private org.ednovo.gooru.client.uc.GenderRadioButton get_other() {
      return build_other();
    }
    private org.ednovo.gooru.client.uc.GenderRadioButton build_other() {
      // Creation section.
      final org.ednovo.gooru.client.uc.GenderRadioButton other = new org.ednovo.gooru.client.uc.GenderRadioButton("gender");
      // Setup section.
      other.setStyleName("" + get_res().css().genderoptions() + "");
      other.setGenderValue("O");


      owner.other = other;

      return other;
    }

    /**
     * Getter for donot called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private org.ednovo.gooru.client.uc.GenderRadioButton get_donot() {
      return build_donot();
    }
    private org.ednovo.gooru.client.uc.GenderRadioButton build_donot() {
      // Creation section.
      final org.ednovo.gooru.client.uc.GenderRadioButton donot = new org.ednovo.gooru.client.uc.GenderRadioButton("gender");
      // Setup section.
      donot.setStyleName("" + get_res().css().genderoptions() + "");
      donot.setGenderValue("X");


      owner.donot = donot;

      return donot;
    }

    /**
     * Getter for genderValidUc called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.ErrorLabelUc get_genderValidUc() {
      return build_genderValidUc();
    }
    private org.ednovo.gooru.client.uc.ErrorLabelUc build_genderValidUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ErrorLabelUc genderValidUc = (org.ednovo.gooru.client.uc.ErrorLabelUc) GWT.create(org.ednovo.gooru.client.uc.ErrorLabelUc.class);
      // Setup section.


      owner.genderValidUc = genderValidUc;

      return genderValidUc;
    }

    /**
     * Getter for userCategoryFloPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_userCategoryFloPanel() {
      return build_userCategoryFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_userCategoryFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel userCategoryFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      userCategoryFloPanel.add(get_aboutMe());
      userCategoryFloPanel.add(get_userCategoryLisBox());
      userCategoryFloPanel.setStyleName("" + get_res().css().registerFormField() + "");


      owner.userCategoryFloPanel = userCategoryFloPanel;

      return userCategoryFloPanel;
    }

    /**
     * Getter for aboutMe called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_aboutMe() {
      return build_aboutMe();
    }
    private com.google.gwt.user.client.ui.Label build_aboutMe() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label aboutMe = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      aboutMe.setStyleName("" + get_res().css().registerRightFormField() + "");


      owner.aboutMe = aboutMe;

      return aboutMe;
    }

    /**
     * Getter for userCategoryLisBox called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.ListBox get_userCategoryLisBox() {
      return build_userCategoryLisBox();
    }
    private com.google.gwt.user.client.ui.ListBox build_userCategoryLisBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.ListBox userCategoryLisBox = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
      // Setup section.
      userCategoryLisBox.setStyleName("" + get_res().css().listBoxAlign() + "");


      owner.userCategoryLisBox = userCategoryLisBox;

      return userCategoryLisBox;
    }

    /**
     * Getter for termsAndConditionFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_termsAndConditionFloPanel() {
      return build_termsAndConditionFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_termsAndConditionFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel termsAndConditionFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      termsAndConditionFloPanel.add(get_conditionsText());
      termsAndConditionFloPanel.add(get_termsAndConditionsAnr());
      termsAndConditionFloPanel.add(get_andText());
      termsAndConditionFloPanel.add(get_copyRightPolicyAnr());
      termsAndConditionFloPanel.add(get_gooruText());
      termsAndConditionFloPanel.setStyleName("" + get_res().css().registerTermsAndCondtion() + "");


      owner.termsAndConditionFloPanel = termsAndConditionFloPanel;

      return termsAndConditionFloPanel;
    }

    /**
     * Getter for conditionsText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_conditionsText() {
      return build_conditionsText();
    }
    private com.google.gwt.user.client.ui.Label build_conditionsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label conditionsText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      conditionsText.setStyleName("" + get_res().css().footerDiv() + "");


      owner.conditionsText = conditionsText;

      return conditionsText;
    }

    /**
     * Getter for termsAndConditionsAnr called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_termsAndConditionsAnr() {
      return build_termsAndConditionsAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_termsAndConditionsAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor termsAndConditionsAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      termsAndConditionsAnr.setStyleName("" + get_res().css().supportText() + "");


      owner.termsAndConditionsAnr = termsAndConditionsAnr;

      return termsAndConditionsAnr;
    }

    /**
     * Getter for andText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_andText() {
      return build_andText();
    }
    private com.google.gwt.user.client.ui.Label build_andText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label andText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      andText.setStyleName("" + get_res().css().footerDiv() + "");


      owner.andText = andText;

      return andText;
    }

    /**
     * Getter for copyRightPolicyAnr called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_copyRightPolicyAnr() {
      return build_copyRightPolicyAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_copyRightPolicyAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor copyRightPolicyAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      copyRightPolicyAnr.setStyleName("" + get_res().css().supportText() + "");


      owner.copyRightPolicyAnr = copyRightPolicyAnr;

      return copyRightPolicyAnr;
    }

    /**
     * Getter for gooruText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_gooruText() {
      return build_gooruText();
    }
    private com.google.gwt.user.client.ui.Label build_gooruText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gooruText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gooruText.setStyleName("" + get_res().css().footerDiv() + "");


      owner.gooruText = gooruText;

      return gooruText;
    }

    /**
     * Getter for f_FlowPanel14 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel14() {
      return build_f_FlowPanel14();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel14() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel14 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel14.add(get_updateUserDetailsUc());
      f_FlowPanel14.add(get_cancelAnr());
      f_FlowPanel14.setStyleName("" + get_res().css().actionField() + "");


      return f_FlowPanel14;
    }

    /**
     * Getter for updateUserDetailsUc called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.BlueButtonUc get_updateUserDetailsUc() {
      return build_updateUserDetailsUc();
    }
    private org.ednovo.gooru.client.uc.BlueButtonUc build_updateUserDetailsUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.BlueButtonUc updateUserDetailsUc = (org.ednovo.gooru.client.uc.BlueButtonUc) GWT.create(org.ednovo.gooru.client.uc.BlueButtonUc.class);
      // Setup section.
      updateUserDetailsUc.setStyleName("" + get_res().css().overRideBlueButton() + "");
      updateUserDetailsUc.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.updateUserDetailsUc = updateUserDetailsUc;

      return updateUserDetailsUc;
    }

    /**
     * Getter for cancelAnr called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_cancelAnr() {
      return build_cancelAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_cancelAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor cancelAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      cancelAnr.setStyleName("" + get_res().css().collectionFormCancelButton() + "");
      cancelAnr.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.cancelAnr = cancelAnr;

      return cancelAnr;
    }
  }
}
