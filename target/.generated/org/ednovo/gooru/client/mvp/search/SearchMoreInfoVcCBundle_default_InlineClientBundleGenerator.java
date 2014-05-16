package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class SearchMoreInfoVcCBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle {
  private static SearchMoreInfoVcCBundle_default_InlineClientBundleGenerator _instance0 = new SearchMoreInfoVcCBundle_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle.SearchMoreInfoVcCss() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "css";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoMetaData {\n  width : " + ("160px")  + ";\n  float : " + ("right")  + ";\n  border-left : " + ("2px"+ " " +"dashed"+ " " +"#ddd")  + ";\n  height : " + ("230px")  + ";\n  overflow : " + ("auto")  + ";\n  padding-left : " + ("10px")  + ";\n  padding-right : " + ("11px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoTitle {\n  color : " + ("#515151")  + ";\n  font-weight : " + ("bold")  + ";\n  margin-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-gradeIcon, .org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-tagIcon, .org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-likesIcon, .org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-timeIcon, .org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-shareIcon, .org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-rightsIcon {\n  background : ") + (("url(images/Collection-Search/icon-sprite.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"transparent")  + ";\n  display : " + ("block")  + ";\n  float : " + ("right")  + ";\n  cursor : " + ("pointer")  + ";\n  margin-right : " + ("3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-gradeIcon {\n  background-position : " + ("-70px"+ " " +"-44px")  + ";\n  height : " + ("21px")  + ";\n  margin-left : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-tagIcon {\n  background-position : " + ("-69px"+ " " +"-366px")  + ";\n  height : " + ("18px") ) + (";\n  margin-left : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-likesIcon {\n  background-position : " + ("-39px"+ " " +"-180px")  + ";\n  height : " + ("18px")  + ";\n  margin-left : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-timeIcon {\n  background-position : " + ("-39px"+ " " +"-206px")  + ";\n  height : " + ("18px")  + ";\n  margin-left : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-shareIcon {\n  background-position : ") + (("-39px"+ " " +"-230px")  + ";\n  height : " + ("18px")  + ";\n  margin-left : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-rightsIcon {\n  background-position : " + ("-67px"+ " " +"-344px")  + ";\n  height : " + ("18px")  + ";\n  margin-left : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel {\n  width : " + ("365px")  + ";\n  height : " + ("212px")  + ";\n  float : " + ("right") ) + (";\n  padding-right : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoResourceSearceRightScrollPanel {\n  width : " + ("549px")  + ";\n  height : " + ("212px")  + ";\n  float : " + ("right")  + ";\n  padding-right : " + ("10px")  + ";\n  overflow-x : " + ("hidden")  + " !important;\n  overflow-y : " + ("auto")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightsLbl {\n  float : " + ("right")  + ";\n  padding-right : " + ("372px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel::-webkit-scrollbar {\n  width : " + ("8px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel::-webkit-scrollbar-track {\n  background-color : ") + (("white")  + ";\n  width : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel::-webkit-scrollbar-thumb {\n  background-color : " + ("rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.2" + ")")  + ";\n  width : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel::-webkit-scrollbar-button {\n  background-color : " + ("#ddd")  + ";\n  width : " + ("0")  + ";\n  height : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel::-webkit-scrollbar-corner {\n  background-color : " + ("red")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightPanel {\n  width : " + ("345px")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoResourceSearchRightPanel {\n  width : " + ("488px") ) + (";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoResourcesCountLblTxt {\n  color : " + ("#515151")  + ";\n  float : " + ("right")  + ";\n  font-weight : " + ("bold")  + ";\n  margin-bottom : " + ("10px")  + ";\n  margin-left : " + ("7px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-imageIcon {\n  width : " + ("19px")  + ";\n  height : " + ("14px")  + ";\n  float : " + ("right")  + ";\n  margin-left : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-imageIcon img {\n  display : ") + (("block")  + ";\n  margin : " + ("auto")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-htmlTxt {\n  display : " + ("block")  + ";\n  float : " + ("right")  + ";\n  width : " + ("115px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-resourceSearchHtmlTxt {\n  float : " + ("left")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("70px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-resourceCollectionThumbnailPanel {\n  padding-top : " + ("10px") ) + (";\n  padding-bottom : " + ("10px")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#999")  + ";\n  width : " + ("534px")  + ";\n  position : " + ("relative")  + ";\n  height : " + ("94px")  + ";\n  clear : " + ("both")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-resourceCollectionTitlePanel {\n  float : " + ("right")  + ";\n  height : " + ("70px")  + ";\n  max-width : " + ("275px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-clear {\n  clear : " + ("both")  + ";\n  height : ") + (("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButtonContainer {\n  float : " + ("right")  + ";\n  width : " + ("120px")  + ";\n  margin-right : " + ("5px")  + ";\n  margin-top : " + ("3px")  + ";\n  margin-bottom : " + ("3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButton {\n  background : " + ("url(images/settings/radio.png)"+ " " +"no-repeat")  + ";\n  width : " + ("19px")  + ";\n  height : " + ("17px")  + ";\n  display : " + ("inline-block")  + ";\n  margin-bottom : " + ("-5px") ) + (";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButton:hover {\n  background-position : " + ("0"+ " " +"-17px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButtonSelected:hover {\n  background-position : " + ("0"+ " " +"-51px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButtonSelected {\n  background : " + ("url(images/settings/radio.png)"+ " " +"no-repeat")  + ";\n  width : " + ("19px")  + ";\n  height : " + ("17px")  + ";\n  display : " + ("inline-block")  + ";\n  margin-bottom : " + ("-5px")  + ";\n  background-position : " + ("0"+ " " +"-34px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButtonSelected:hover {\n  background : ") + (("url(images/settings/radio.png)"+ " " +"no-repeat")  + ";\n  width : " + ("19px")  + ";\n  height : " + ("17px")  + ";\n  display : " + ("inline-block")  + ";\n  margin-bottom : " + ("-5px")  + ";\n  background-position : " + ("0"+ " " +"-51px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-publicPPMoreInfoRightScrollPanel {\n  width : " + ("500px")  + ";\n  height : " + ("212px")  + ";\n  float : " + ("right")  + ";\n  padding-right : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-notFriendly {\n  font-style : " + ("italic") ) + (";\n  color : " + ("#999")  + ";\n  float : " + ("right")  + ";\n  font-size : " + ("12px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionMark {\n  float : " + ("right")  + ";\n  cursor : " + ("pointer")  + ";\n  position : " + ("absolute")  + ";\n  top : " + ("39px")  + ";\n  right : " + ("50px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-imageHeight {\n  margin-top : " + ("20px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoMetaData {\n  width : " + ("160px")  + ";\n  float : " + ("left")  + ";\n  border-right : " + ("2px"+ " " +"dashed"+ " " +"#ddd")  + ";\n  height : " + ("230px")  + ";\n  overflow : " + ("auto")  + ";\n  padding-right : " + ("10px")  + ";\n  padding-left : " + ("11px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoTitle {\n  color : " + ("#515151")  + ";\n  font-weight : " + ("bold")  + ";\n  margin-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-gradeIcon, .org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-tagIcon, .org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-likesIcon, .org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-timeIcon, .org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-shareIcon, .org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-rightsIcon {\n  background : ") + (("url(images/Collection-Search/icon-sprite.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"transparent")  + ";\n  display : " + ("block")  + ";\n  float : " + ("left")  + ";\n  cursor : " + ("pointer")  + ";\n  margin-left : " + ("3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-gradeIcon {\n  background-position : " + ("-70px"+ " " +"-44px")  + ";\n  height : " + ("21px")  + ";\n  margin-right : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-tagIcon {\n  background-position : " + ("-69px"+ " " +"-366px")  + ";\n  height : " + ("18px") ) + (";\n  margin-right : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-likesIcon {\n  background-position : " + ("-39px"+ " " +"-180px")  + ";\n  height : " + ("18px")  + ";\n  margin-right : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-timeIcon {\n  background-position : " + ("-39px"+ " " +"-206px")  + ";\n  height : " + ("18px")  + ";\n  margin-right : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-shareIcon {\n  background-position : ") + (("-39px"+ " " +"-230px")  + ";\n  height : " + ("18px")  + ";\n  margin-right : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-rightsIcon {\n  background-position : " + ("-67px"+ " " +"-344px")  + ";\n  height : " + ("18px")  + ";\n  margin-right : " + ("11px")  + ";\n  width : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel {\n  width : " + ("365px")  + ";\n  height : " + ("212px")  + ";\n  float : " + ("left") ) + (";\n  padding-left : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoResourceSearceRightScrollPanel {\n  width : " + ("549px")  + ";\n  height : " + ("212px")  + ";\n  float : " + ("left")  + ";\n  padding-left : " + ("10px")  + ";\n  overflow-x : " + ("hidden")  + " !important;\n  overflow-y : " + ("auto")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightsLbl {\n  float : " + ("left")  + ";\n  padding-left : " + ("372px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel::-webkit-scrollbar {\n  width : " + ("8px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel::-webkit-scrollbar-track {\n  background-color : ") + (("white")  + ";\n  width : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel::-webkit-scrollbar-thumb {\n  background-color : " + ("rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.2" + ")")  + ";\n  width : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel::-webkit-scrollbar-button {\n  background-color : " + ("#ddd")  + ";\n  width : " + ("0")  + ";\n  height : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel::-webkit-scrollbar-corner {\n  background-color : " + ("red")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightPanel {\n  width : " + ("345px")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoResourceSearchRightPanel {\n  width : " + ("488px") ) + (";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoResourcesCountLblTxt {\n  color : " + ("#515151")  + ";\n  float : " + ("left")  + ";\n  font-weight : " + ("bold")  + ";\n  margin-bottom : " + ("10px")  + ";\n  margin-right : " + ("7px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-imageIcon {\n  width : " + ("19px")  + ";\n  height : " + ("14px")  + ";\n  float : " + ("left")  + ";\n  margin-right : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-imageIcon img {\n  display : ") + (("block")  + ";\n  margin : " + ("auto")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-htmlTxt {\n  display : " + ("block")  + ";\n  float : " + ("left")  + ";\n  width : " + ("115px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-resourceSearchHtmlTxt {\n  float : " + ("right")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("70px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-resourceCollectionThumbnailPanel {\n  padding-top : " + ("10px") ) + (";\n  padding-bottom : " + ("10px")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#999")  + ";\n  width : " + ("534px")  + ";\n  position : " + ("relative")  + ";\n  height : " + ("94px")  + ";\n  clear : " + ("both")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-resourceCollectionTitlePanel {\n  float : " + ("left")  + ";\n  height : " + ("70px")  + ";\n  max-width : " + ("275px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-clear {\n  clear : " + ("both")  + ";\n  height : ") + (("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButtonContainer {\n  float : " + ("left")  + ";\n  width : " + ("120px")  + ";\n  margin-left : " + ("5px")  + ";\n  margin-top : " + ("3px")  + ";\n  margin-bottom : " + ("3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButton {\n  background : " + ("url(images/settings/radio.png)"+ " " +"no-repeat")  + ";\n  width : " + ("19px")  + ";\n  height : " + ("17px")  + ";\n  display : " + ("inline-block")  + ";\n  margin-bottom : " + ("-5px") ) + (";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButton:hover {\n  background-position : " + ("0"+ " " +"-17px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButtonSelected:hover {\n  background-position : " + ("0"+ " " +"-51px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButtonSelected {\n  background : " + ("url(images/settings/radio.png)"+ " " +"no-repeat")  + ";\n  width : " + ("19px")  + ";\n  height : " + ("17px")  + ";\n  display : " + ("inline-block")  + ";\n  margin-bottom : " + ("-5px")  + ";\n  background-position : " + ("0"+ " " +"-34px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButtonSelected:hover {\n  background : ") + (("url(images/settings/radio.png)"+ " " +"no-repeat")  + ";\n  width : " + ("19px")  + ";\n  height : " + ("17px")  + ";\n  display : " + ("inline-block")  + ";\n  margin-bottom : " + ("-5px")  + ";\n  background-position : " + ("0"+ " " +"-51px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-publicPPMoreInfoRightScrollPanel {\n  width : " + ("500px")  + ";\n  height : " + ("212px")  + ";\n  float : " + ("left")  + ";\n  padding-left : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-notFriendly {\n  font-style : " + ("italic") ) + (";\n  color : " + ("#999")  + ";\n  float : " + ("left")  + ";\n  font-size : " + ("12px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionMark {\n  float : " + ("left")  + ";\n  cursor : " + ("pointer")  + ";\n  position : " + ("absolute")  + ";\n  top : " + ("39px")  + ";\n  left : " + ("50px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-imageHeight {\n  margin-top : " + ("20px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n"));
      }
      public java.lang.String clear(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-clear";
      }
      public java.lang.String gradeIcon(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-gradeIcon";
      }
      public java.lang.String htmlTxt(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-htmlTxt";
      }
      public java.lang.String imageHeight(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-imageHeight";
      }
      public java.lang.String imageIcon(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-imageIcon";
      }
      public java.lang.String likesIcon(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-likesIcon";
      }
      public java.lang.String moreInfoMetaData(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoMetaData";
      }
      public java.lang.String moreInfoResourceSearceRightScrollPanel(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoResourceSearceRightScrollPanel";
      }
      public java.lang.String moreInfoResourceSearchRightPanel(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoResourceSearchRightPanel";
      }
      public java.lang.String moreInfoResourcesCountLblTxt(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoResourcesCountLblTxt";
      }
      public java.lang.String moreInfoRightPanel(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightPanel";
      }
      public java.lang.String moreInfoRightScrollPanel(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightScrollPanel";
      }
      public java.lang.String moreInfoRightsLbl(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoRightsLbl";
      }
      public java.lang.String moreInfoTitle(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-moreInfoTitle";
      }
      public java.lang.String notFriendly(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-notFriendly";
      }
      public java.lang.String publicPPMoreInfoRightScrollPanel(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-publicPPMoreInfoRightScrollPanel";
      }
      public java.lang.String questionMark(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionMark";
      }
      public java.lang.String questionRadioButton(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButton";
      }
      public java.lang.String questionRadioButtonContainer(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButtonContainer";
      }
      public java.lang.String questionRadioButtonSelected(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-questionRadioButtonSelected";
      }
      public java.lang.String resourceCollectionThumbnailPanel(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-resourceCollectionThumbnailPanel";
      }
      public java.lang.String resourceCollectionTitlePanel(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-resourceCollectionTitlePanel";
      }
      public java.lang.String resourceSearchHtmlTxt(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-resourceSearchHtmlTxt";
      }
      public java.lang.String rightsIcon(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-rightsIcon";
      }
      public java.lang.String shareIcon(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-shareIcon";
      }
      public java.lang.String tagIcon(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-tagIcon";
      }
      public java.lang.String timeIcon(){
        return "org-ednovo-gooru-client-mvp-search-SearchMoreInfoVcCBundle-SearchMoreInfoVcCss-timeIcon";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle.SearchMoreInfoVcCss get() {
      return css;
    }
  }
  public org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle.SearchMoreInfoVcCss css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle.SearchMoreInfoVcCss css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle::css()();
    }
    return null;
  }-*/;
}
