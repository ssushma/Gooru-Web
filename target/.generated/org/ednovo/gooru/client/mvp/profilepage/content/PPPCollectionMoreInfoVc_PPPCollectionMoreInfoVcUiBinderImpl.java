package org.ednovo.gooru.client.mvp.profilepage.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class PPPCollectionMoreInfoVc_PPPCollectionMoreInfoVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionMoreInfoVc>, org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionMoreInfoVc.PPPCollectionMoreInfoVcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionMoreInfoVc owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionMoreInfoVc owner;


    public Widgets(final org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionMoreInfoVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionMoreInfoVc_PPPCollectionMoreInfoVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionMoreInfoVc_PPPCollectionMoreInfoVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionMoreInfoVc_PPPCollectionMoreInfoVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionMoreInfoVc_PPPCollectionMoreInfoVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionMoreInfoVc_PPPCollectionMoreInfoVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 16 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle res;
    private org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_metaInfoFloPanel());
      f_FlowPanel1.add(get_rightsLbl());
      f_FlowPanel1.add(get_resourceSearchRightsFieldVc());
      f_FlowPanel1.add(get_resourceScrPanel());


      return f_FlowPanel1;
    }

    /**
     * Getter for metaInfoFloPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_metaInfoFloPanel() {
      return build_metaInfoFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_metaInfoFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel metaInfoFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      metaInfoFloPanel.add(get_moreInfotext());
      metaInfoFloPanel.add(get_gradeFieldVc());
      metaInfoFloPanel.add(get_tagsFieldVc());
      metaInfoFloPanel.add(get_timeFieldVc());
      metaInfoFloPanel.add(get_likesFieldVc());
      metaInfoFloPanel.add(get_shareField());
      metaInfoFloPanel.add(get_rightsFieldVc());
      metaInfoFloPanel.setStyleName("" + get_res().css().moreInfoMetaData() + "");


      owner.metaInfoFloPanel = metaInfoFloPanel;

      return metaInfoFloPanel;
    }

    /**
     * Getter for moreInfotext called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_moreInfotext() {
      return build_moreInfotext();
    }
    private com.google.gwt.user.client.ui.Label build_moreInfotext() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label moreInfotext = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      moreInfotext.setStyleName("" + get_res().css().moreInfoTitle() + "");


      owner.moreInfotext = moreInfotext;

      return moreInfotext;
    }

    /**
     * Getter for gradeFieldVc called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc get_gradeFieldVc() {
      return build_gradeFieldVc();
    }
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc build_gradeFieldVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc gradeFieldVc = (org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc) GWT.create(org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc.class);
      // Setup section.
      gradeFieldVc.setImageStyle("" + get_res().css().gradeIcon() + "");


      owner.gradeFieldVc = gradeFieldVc;

      return gradeFieldVc;
    }

    /**
     * Getter for tagsFieldVc called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc get_tagsFieldVc() {
      return build_tagsFieldVc();
    }
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc build_tagsFieldVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc tagsFieldVc = (org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc) GWT.create(org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc.class);
      // Setup section.
      tagsFieldVc.setVisible(false);
      tagsFieldVc.setImageStyle("" + get_res().css().tagIcon() + "");


      owner.tagsFieldVc = tagsFieldVc;

      return tagsFieldVc;
    }

    /**
     * Getter for timeFieldVc called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc get_timeFieldVc() {
      return build_timeFieldVc();
    }
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc build_timeFieldVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc timeFieldVc = (org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc) GWT.create(org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc.class);
      // Setup section.
      timeFieldVc.setVisible(false);
      timeFieldVc.setImageStyle("" + get_res().css().timeIcon() + "");


      owner.timeFieldVc = timeFieldVc;

      return timeFieldVc;
    }

    /**
     * Getter for likesFieldVc called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc get_likesFieldVc() {
      return build_likesFieldVc();
    }
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc build_likesFieldVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc likesFieldVc = (org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc) GWT.create(org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc.class);
      // Setup section.
      likesFieldVc.setImageStyle("" + get_res().css().likesIcon() + "");


      owner.likesFieldVc = likesFieldVc;

      return likesFieldVc;
    }

    /**
     * Getter for shareField called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc get_shareField() {
      return build_shareField();
    }
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc build_shareField() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc shareField = (org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc) GWT.create(org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc.class);
      // Setup section.
      shareField.setImageStyle("" + get_res().css().shareIcon() + "");


      owner.shareField = shareField;

      return shareField;
    }

    /**
     * Getter for rightsFieldVc called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc get_rightsFieldVc() {
      return build_rightsFieldVc();
    }
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc build_rightsFieldVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc rightsFieldVc = (org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc) GWT.create(org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc.class);
      // Setup section.
      rightsFieldVc.setImageStyle("" + get_res().css().rightsIcon() + "");


      owner.rightsFieldVc = rightsFieldVc;

      return rightsFieldVc;
    }

    /**
     * Getter for rightsLbl called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_rightsLbl() {
      return build_rightsLbl();
    }
    private com.google.gwt.user.client.ui.Label build_rightsLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label rightsLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      rightsLbl.setStyleName("" + get_res().css().moreInfoRightsLbl() + "");


      owner.rightsLbl = rightsLbl;

      return rightsLbl;
    }

    /**
     * Getter for resourceSearchRightsFieldVc called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc get_resourceSearchRightsFieldVc() {
      return build_resourceSearchRightsFieldVc();
    }
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc build_resourceSearchRightsFieldVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc resourceSearchRightsFieldVc = (org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc) GWT.create(org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc.class);
      // Setup section.
      resourceSearchRightsFieldVc.setImageStyle("" + get_res().css().rightsIcon() + "");


      owner.resourceSearchRightsFieldVc = resourceSearchRightsFieldVc;

      return resourceSearchRightsFieldVc;
    }

    /**
     * Getter for resourceScrPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_resourceScrPanel() {
      return build_resourceScrPanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_resourceScrPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel resourceScrPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      resourceScrPanel.add(get_resourceMoreInfoRightPanel());
      resourceScrPanel.setStyleName("" + get_res().css().publicPPMoreInfoRightScrollPanel() + "");


      owner.resourceScrPanel = resourceScrPanel;

      return resourceScrPanel;
    }

    /**
     * Getter for resourceMoreInfoRightPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_resourceMoreInfoRightPanel() {
      return build_resourceMoreInfoRightPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_resourceMoreInfoRightPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel resourceMoreInfoRightPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      resourceMoreInfoRightPanel.add(get_countLblTxt());
      resourceMoreInfoRightPanel.add(get_countLbl());
      resourceMoreInfoRightPanel.add(get_lblNotFriendly());
      resourceMoreInfoRightPanel.add(get_imgQuestionImage());
      resourceMoreInfoRightPanel.add(get_resourceSearchGradeFieldVc());
      resourceMoreInfoRightPanel.add(get_messageInfo());
      resourceMoreInfoRightPanel.add(get_usedInResourcesPanel());
      resourceMoreInfoRightPanel.add(get_profileusedInResourcesPanel());
      resourceMoreInfoRightPanel.setStyleName("" + get_res().css().moreInfoRightPanel() + "");


      owner.resourceMoreInfoRightPanel = resourceMoreInfoRightPanel;

      return resourceMoreInfoRightPanel;
    }

    /**
     * Getter for countLblTxt called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_countLblTxt() {
      return build_countLblTxt();
    }
    private com.google.gwt.user.client.ui.Label build_countLblTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label countLblTxt = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      countLblTxt.setStyleName("" + get_res().css().moreInfoResourcesCountLblTxt() + "");


      owner.countLblTxt = countLblTxt;

      return countLblTxt;
    }

    /**
     * Getter for countLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_countLbl() {
      return build_countLbl();
    }
    private com.google.gwt.user.client.ui.Label build_countLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label countLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      countLbl.setStyleName("" + get_res().css().moreInfoResourcesCountLblTxt() + "");


      owner.countLbl = countLbl;

      return countLbl;
    }

    /**
     * Getter for lblNotFriendly called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblNotFriendly() {
      return build_lblNotFriendly();
    }
    private com.google.gwt.user.client.ui.Label build_lblNotFriendly() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblNotFriendly = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblNotFriendly.setStyleName("" + get_res().css().notFriendly() + "");


      owner.lblNotFriendly = lblNotFriendly;

      return lblNotFriendly;
    }

    /**
     * Getter for imgQuestionImage called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Image get_imgQuestionImage() {
      return build_imgQuestionImage();
    }
    private com.google.gwt.user.client.ui.Image build_imgQuestionImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image imgQuestionImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      imgQuestionImage.setStyleName("" + get_res().css().questionMark() + "");


      owner.imgQuestionImage = imgQuestionImage;

      return imgQuestionImage;
    }

    /**
     * Getter for resourceSearchGradeFieldVc called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc get_resourceSearchGradeFieldVc() {
      return build_resourceSearchGradeFieldVc();
    }
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc build_resourceSearchGradeFieldVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc resourceSearchGradeFieldVc = (org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc) GWT.create(org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc.class);
      // Setup section.


      owner.resourceSearchGradeFieldVc = resourceSearchGradeFieldVc;

      return resourceSearchGradeFieldVc;
    }

    /**
     * Getter for messageInfo called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.ErrorMessagePanel get_messageInfo() {
      return build_messageInfo();
    }
    private org.ednovo.gooru.client.uc.ErrorMessagePanel build_messageInfo() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ErrorMessagePanel messageInfo = (org.ednovo.gooru.client.uc.ErrorMessagePanel) GWT.create(org.ednovo.gooru.client.uc.ErrorMessagePanel.class);
      // Setup section.


      owner.messageInfo = messageInfo;

      return messageInfo;
    }

    /**
     * Getter for usedInResourcesPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.mvp.dnd.AppMirageDragContainer get_usedInResourcesPanel() {
      return build_usedInResourcesPanel();
    }
    private org.ednovo.gooru.client.mvp.dnd.AppMirageDragContainer build_usedInResourcesPanel() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.dnd.AppMirageDragContainer usedInResourcesPanel = owner.usedInResourcesPanel;
      assert usedInResourcesPanel != null : "UiField usedInResourcesPanel with 'provided = true' was null";
      // Setup section.


      return usedInResourcesPanel;
    }

    /**
     * Getter for profileusedInResourcesPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_profileusedInResourcesPanel() {
      return build_profileusedInResourcesPanel();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_profileusedInResourcesPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel profileusedInResourcesPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.


      owner.profileusedInResourcesPanel = profileusedInResourcesPanel;

      return profileusedInResourcesPanel;
    }
  }
}
