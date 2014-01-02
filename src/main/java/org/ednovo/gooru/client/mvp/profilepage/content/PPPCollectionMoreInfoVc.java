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
package org.ednovo.gooru.client.mvp.profilepage.content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc;
import org.ednovo.gooru.client.mvp.search.SearchMoreInfoVc;
import org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle;
import org.ednovo.gooru.client.mvp.search.SearchResultWrapperCBundle;
import org.ednovo.gooru.client.mvp.search.SimpleResourceVc;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.ErrorMessagePanel;
import org.ednovo.gooru.client.uc.StandardSgItemVc;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.TagDo;
import org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : PPPCollectionMoreInfoVc.java
 *
 * @description : This file is used to Set PPP meta data and styles for widget
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */

public class PPPCollectionMoreInfoVc extends SearchMoreInfoVc<CollectionItemDo, CollectionItemSearchResultDo> implements MessageProperties {
	
	private static PPPCollectionMoreInfoVcUiBinder uiBinder = GWT.create(PPPCollectionMoreInfoVcUiBinder.class);

	interface PPPCollectionMoreInfoVcUiBinder extends UiBinder<Widget, PPPCollectionMoreInfoVc> {
	}
	private static final String NO_RESOURCES_IN_THIS_COLLECTION = "There are no resources in this collection.";
	private static final String RESOURCES_IN_THIS_COLLECTION= "Resources in this Collection";
	
	@UiField
	MoreInfoFieldVc gradeFieldVc, tagsFieldVc, timeFieldVc, rightsFieldVc,
			likesFieldVc,resourceSearchGradeFieldVc,resourceSearchRightsFieldVc,shareField;

	@UiField
	Label countLbl, countLblTxt,rightsLbl;

	@UiField
	ScrollPanel resourceScrPanel;

	@UiField
	ErrorMessagePanel messageInfo;
	
	@UiField
	VerticalPanel profileusedInResourcesPanel;
	
	@UiField
	FlowPanel metaInfoFloPanel,resourceMoreInfoRightPanel;

	
	@UiField Image imgQuestionImage;
	
	@UiField Label lblNotFriendly;
	
	@UiField(provided = true)
	SearchMoreInfoVcCBundle res;

	protected static final String LICENSE_FOLDER = "images/license/";

	private SimpleAsyncCallback<SearchDo<CollectionItemSearchResultDo>> usedInResourcesAsyncCallback;

	private CollectionItemDo searchResultDo;

	private SearchDo<CollectionItemSearchResultDo> usedInSearchDo;

	protected static final String OER_DESCRIPTION = "The term Open Educational Resources (OER) refers to educational materials that are freely available and licensed in a way that gives users the legal permission to reuse, revise, remix, and redistribute.";

	protected static final String OER_TITLE = "Open Education Resources";

	private static final String OER_PNG_IMG = "oer.png";

	private static final String OERCOMMONS_ORG = "oercommons.org";

	private static final String OER = "OER";

	private static final String NULL = "null";

	private String collectionId;
	
	ToolTip toolTip=null;
	/**
	 * Class constructor
	 */
	public PPPCollectionMoreInfoVc(String collectionId) {
		
		this.res = SearchMoreInfoVcCBundle.INSTANCE;
		res.css().ensureInjected();
		usedInSearchDo = new SearchDo<CollectionItemSearchResultDo>();
		usedInSearchDo.setPageSize(20);
		setWidget(uiBinder.createAndBindUi(this));
		setUsedInResourcesAsyncCallback(new SimpleAsyncCallback<SearchDo<CollectionItemSearchResultDo>>() {

			@Override
			public void onSuccess(SearchDo<CollectionItemSearchResultDo> result) {
				profileusedInResourcesPanel.clear();
				usedInSearchDo = result;
				setUsedInResources(result.getSearchResults());
			}
		});
		this.collectionId=collectionId;
		getRightsField().setVisible(false);
		getLikesField().setVisible(false);
		resourceSearchGradeFieldVc.setVisible(false);
		resourceSearchRightsFieldVc.setVisible(false);
		rightsLbl.setVisible(false);
		shareField.setVisible(false);
		
		imgQuestionImage.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				toolTip = new ToolTip();
				
				toolTip.getElement().getStyle().setBackgroundColor("transparent");
				toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
				toolTip.setPopupPosition(imgQuestionImage.getAbsoluteLeft()-(150+22), imgQuestionImage.getAbsoluteTop()+22);
				toolTip.show();
			}
		});
		imgQuestionImage.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				
				EventTarget target = event.getRelatedTarget();
				  if (Element.is(target)) {
					  if (!toolTip.getElement().isOrHasChild(Element.as(target))){
						  toolTip.hide();
					  }
				  }
			}
		});
		imgQuestionImage.setVisible(false);
	}
	/**
	 * This is used to reset few of the fileds.
	 */
	public void reset() {
		usedInSearchDo.setPageNum(1);
		usedInSearchDo.setSearchResults(null);
		getMessageInfo().setVisible(false);
		profileusedInResourcesPanel.clear();
		setResourceCountTxt("");
		setResourceCount("");
		requestUsedInResources();
	}

	/**
	 * @return type of SearchResultDo
	 */
	public CollectionItemDo getSearchResultDo() {
		return searchResultDo;
	}

	/**
	 * @return the usedInSearchDo
	 */
	public SearchDo<CollectionItemSearchResultDo> getUsedInSearchDo() {
		return usedInSearchDo;
	}

	/**
	 * Set PPP meta data and styles for widget
	 * 
	 * @param collectionItemDo
	 *            type of CollectionItemDo
	 */
	public void setData(CollectionItemDo searchResultDo) {
		usedInSearchDo.setQuery(searchResultDo.getGooruOid());
		this.searchResultDo = searchResultDo;
		String grade = searchResultDo.getGrade();
		if (grade != null) { 
			grade = grade.replace("null,", "").replace("null ,", "")
					.replace("null", "");
		}
		if (StringUtil.hasValidString(grade)) {

			boolean isKindergarten = false;
			boolean isHigherEducation = false;

			if (grade.indexOf("Kindergarten") != -1) {
				isKindergarten = true;
			}

			if (grade.indexOf("Higher Education") != -1) {
				isHigherEducation = true;
			}
			if (grade.indexOf("-") > 0) {
				if (grade.indexOf(",") == -1) {
					grade = generateGradeIfHypen(grade);
				}
			}

			List<String> gradeList = Arrays.asList(grade.split(","));

			int gradeListSize = gradeList.size();

			StringBuilder finalGradeStringB = new StringBuilder();

			if (isKindergarten) {
				finalGradeStringB.append("Kindergarten, ");
			}

			List<Integer> gradeListInt = new ArrayList<Integer>();
			finalGradeStringB.append(gradeListSize > 1 ? "Grades " : "Grade ");

			for (String eachGrade1 : gradeList) {
				if (!eachGrade1.equalsIgnoreCase("Kindergarten")
						&& !eachGrade1.equalsIgnoreCase("Higher Education")) {

					eachGrade1 = eachGrade1.replaceAll("th", "")
							.replaceAll("TH", "").replaceAll("st", "")
							.replaceAll("ST", "").replaceAll("nd", "")
							.replaceAll("ND", "").replaceAll("rd", "")
							.replaceAll("RD", "");
					eachGrade1 = eachGrade1.toLowerCase()
							.replaceAll("Grade", "").replaceAll("grade", "");
					eachGrade1 = eachGrade1.toLowerCase().replaceAll("K-", "")
							.replaceAll("k-", "");
					eachGrade1 = eachGrade1.toLowerCase().replaceAll("K", "")
							.replaceAll("k", "");
					try {

						
						 
						gradeListInt.clear();
						String grad[] = generateGradeIfHypen(eachGrade1).trim()
								.split(",");
						for (int i = 0; i < grad.length; i++) {
 
							gradeListInt.add(Integer.parseInt(grad[i]));
						}

					} catch (Exception e) {
						gradeListInt.add(0);
						e.printStackTrace();
					}
				}
			}
			gradeListInt = sortList(gradeListInt);

			int count = 1;
			for (int eachGrade : gradeListInt) {
				finalGradeStringB.append(eachGrade);
				if (count < gradeListInt.size()) {
					finalGradeStringB.append(", ");
				}

				count++;
			}

			if (isHigherEducation) {
				finalGradeStringB.append(", Higher Education");
			}

			grade = finalGradeStringB.toString();

			// gradeFieldVc.setHtmlTxt((grade.split(",").length > 1 ? "Grades "
			// : "Grade ") + grade);
			if(!(gradeFieldVc.getElement().toString().contains("Kinder")||gradeFieldVc.getElement().toString().contains("Higher")||gradeFieldVc.getElement().toString().contains("Grades"))) {
				gradeFieldVc.setHtmlTxt(grade);
			}
		} else {
			gradeFieldVc.setHtmlTxt(null);
		}
		timeFieldVc.setHtmlTxt(StringUtil.getValidString(searchResultDo.getAverageTime(), null));
		//timeFieldVc.getElement().getStyle().setDisplay(Display.NONE);\
		if(!likesFieldVc.getElement().toString().contains(" likes")) {
			likesFieldVc.setHtmlTxt(StringUtil.getValidStringWithSuffix(searchResultDo.getVotesUp() + "", "0", " likes"));
		}
		likesFieldVc.getElement().getStyle().setDisplay(Display.BLOCK);
		if (searchResultDo.getLicense() != null	&& searchResultDo.getLicense().getIcon() != null&& searchResultDo.getLicense().getIcon().isEmpty()) {

			rightsFieldVc.contentFloPanel.setVisible(false);
			rightsFieldVc.imageIconSimPanel.setVisible(false);

		}
		if (searchResultDo.getLicense() != null	&& searchResultDo.getLicense().getIcon() != null&& !searchResultDo.getLicense().getIcon().equals(NULL)) {
			Image image = new Image(searchResultDo.getAssetURI()+ searchResultDo.getLicense().getIcon());
			image.setAltText("License");
			image.setTitle("License");
			StandardSgItemVc standardItem = null;
			if (searchResultDo.getLicense().getCode() != null&& !searchResultDo.getLicense().getCode().equalsIgnoreCase(NULL)) {
				standardItem = new StandardSgItemVc(searchResultDo.getLicense().getCode(), searchResultDo.getLicense().getDefinition());
			}
			DownToolTipWidgetUc widget = new DownToolTipWidgetUc(image,standardItem);
			widget.setStyleName("rightsToolTip");
			rightsFieldVc.addWidget(widget);
		} else if (searchResultDo.getLicense() != null	&& searchResultDo.getLicense().getTag() == OER|| (searchResultDo.getUrl() != null && searchResultDo.getUrl().indexOf(OERCOMMONS_ORG) >= 0)) {
			Image image = new Image(LICENSE_FOLDER + OER_PNG_IMG);
			image.setAltText("OER License");
			image.setTitle("OER License");
			StandardSgItemVc standardItem = new StandardSgItemVc(OER_TITLE,	OER_DESCRIPTION);
			standardItem.setHeight("100px");
			DownToolTipWidgetUc widget = new DownToolTipWidgetUc(image,	standardItem);
			widget.setStyleName("rightsToolTip");
			rightsFieldVc.addWidget(widget);
		} else {
			rightsFieldVc.setHtmlTxt(null);
		}
		if (searchResultDo.getTagSet() != null	&& !searchResultDo.getTagSet().equals(null)	&& !searchResultDo.getTagSet().equals("")) {
			int tagIndex = 0;
			int tagLength = 0;
			StringBuilder tagList = new StringBuilder();
			for (TagDo tag : searchResultDo.getTagSet()) {
				tagLength += tag.getLabel().length();
				Label label = new Label((tagIndex > 0 ? "," : "")+ tag.getLabel());
				label.setStyleName(SearchResultWrapperCBundle.INSTANCE.css().tagText());
				label.setStyleName("tagToolStyle");
				tagList.append((tagIndex > 0 ? ", " : "") + tag.getLabel());
				if (tagIndex < 4) {
					tagsFieldVc.addWidget(label);
				}
				tagIndex++;
			}

			if (tagLength > 50) {
				Label toolTipInfo = new Label(tagList.toString());
				toolTipInfo.setWidth("100px");
				DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(
						new Label("+" + (tagIndex - 4)), toolTipInfo);
				toolTipUc.setStyleName(SearchResultWrapperCBundle.INSTANCE.css().blueLink());
				tagsFieldVc.addWidget(toolTipUc);
			} else {
				tagsFieldVc.setHtmlTxt(null);
			}

		} else {
			tagsFieldVc.setHtmlTxt(null);
		}
		//tagsFieldVc.getElement().getStyle().setDisplay(Display.NONE);
	}
	
	/**
	 * 
	 * @function generateGradeIfHypen 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This method is used to generate the grade.
	 * 
	 * 
	 * @parm(s) : @param grade
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private String generateGradeIfHypen(String grade) {
		String gradeList[];
	 
		StringBuilder gradeStr = new StringBuilder();
		gradeList = grade.split("-");
		try {
			if (gradeList.length >= 2) {
				int start = Integer.parseInt(gradeList[0].trim());
				int end = Integer.parseInt(gradeList[1].trim());
				if (start < end) {
					for (int i = start; i <= end; i++) {
						if (i == end) {
							gradeStr.append(i);
						} else {
							gradeStr.append(i).append(",");
						}
					}
				}
			} else {
				gradeStr.append(Integer.parseInt(gradeList[0]));
				/*gradeStr.append(Integer.parseInt("0"));*/
			}
		} catch (Exception e) {}
		return gradeStr.toString();
	}
	/**
	 * This method is used to sort the list.
	 */
	public List<Integer> sortList(List<Integer> list) {

		int listSize = list.size();

		for (int i = 0; i < listSize; i++) {

			for (int j = 1; j < listSize - i; j++) {
				if (list.get(j - 1) > list.get(j)) {
					int temp = list.get(j - 1);
					list.set(j - 1, list.get(j));
					list.set(j, temp);
				}
			}
		}

		return list;
	}

	/**
	 * Set resource that used in any collection
	 * 
	 * @param childResources
	 *            used resource
	 */
	public void setUsedInResources(List<CollectionItemSearchResultDo> childResources) {
		gradeFieldVc = new MoreInfoFieldVc();
		if (childResources.size() == 0) {
			getMessageInfo().setMessage(NO_RESOURCES_IN_THIS_COLLECTION, "");
			getMessageInfo().getElement().getStyle().setDisplay(Display.BLOCK);
		} else {
			setResourceCountTxt(RESOURCES_IN_THIS_COLLECTION);
			setResourceCount("(" + getUsedInSearchDo().getCollectionItemsCount()+ ")");
		}
		if (childResources != null) {
			for (CollectionItemSearchResultDo resource : childResources) {
				renderUsedInResource(resource);
			}
		}
	}
	/**
	 * returns usedInResourcesAsyncCallback.
	 */
	public SimpleAsyncCallback<SearchDo<CollectionItemSearchResultDo>> getUsedInResourcesAsyncCallback() {
		return usedInResourcesAsyncCallback;
	}
	/**
	 * To set usedInResourcesAsyncCallback
	 */
	public void setUsedInResourcesAsyncCallback(
			SimpleAsyncCallback<SearchDo<CollectionItemSearchResultDo>> usedInResourcesAsyncCallback) {
		this.usedInResourcesAsyncCallback = usedInResourcesAsyncCallback;
	}

	/**
	 * Add instance of {@link MoreInfoFieldVc} to metaInfoPanel widget
	 * 
	 * @param moreInfoField
	 *            instance of {@link MoreInfoFieldVc}
	 */
	public void addMoreInfoField(MoreInfoFieldVc moreInfoField) {
		metaInfoFloPanel.add(moreInfoField);
	}

	/**
	 * Set resource count
	 * 
	 * @param text
	 *            count of the resource
	 */
	public void setResourceCount(String text) {
		countLbl.setText(text);
	}

	/**
	 * Set resource count text
	 * 
	 * @param text
	 *            count text
	 */
	public void setResourceCountTxt(String text) {
		countLblTxt.setText(text);
	}

	/**
	 * @return messageInfo instance of {@link ErrorMessagePanel}
	 */
	public ErrorMessagePanel getMessageInfo() {
		return messageInfo;
	}

	
	/**
	 * @return rightsFiled instance of {@link MoreInfoFieldVc}
	 */
	public MoreInfoFieldVc getRightsField() {
		return rightsFieldVc;
	}

	/**
	 * @return likesFiled instance of {@link MoreInfoFieldVc}
	 */
	public MoreInfoFieldVc getLikesField() {
		return likesFieldVc;
	}
		
	/**
	 * This is used to render userid in resource.
	 */
	public void renderUsedInResource(CollectionItemSearchResultDo usedInResource) {
			profileusedInResourcesPanel.add(new SimpleResourceVc(usedInResource, profileusedInResourcesPanel.getWidgetCount() + 1));
	}
	/**
	 * This method is used to request for used  in resources.
	 */
	public void requestUsedInResources() {
		AppClientFactory.getInjector().getSearchService().getCollectionItems(collectionId, getUsedInResourcesAsyncCallback());
	}
	/**
	 * This is used to set notfriendly text.
	 */
	public void setNotFriendly(String text){
		lblNotFriendly.setText(text);
	}
	/**
	 * This is used to show not friendly image.
	 */
	public void showNotFriendly(boolean visibility){
		lblNotFriendly.setVisible(visibility);
		imgQuestionImage.setVisible(visibility);
	}
}
