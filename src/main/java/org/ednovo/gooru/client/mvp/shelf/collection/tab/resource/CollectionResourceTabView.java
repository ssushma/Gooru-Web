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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle.CollectionEditResourceCss;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditQuestionPopupVc;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditUserOwnResourcePopupVc;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.UpdateQuestionImageView;
import org.ednovo.gooru.client.mvp.shelf.event.GetEditPageHeightEvent;
import org.ednovo.gooru.client.mvp.shelf.event.InsertCollectionItemInAddResourceEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionItemInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.mvp.shelf.event.UpdateResourceCountEvent;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.ConfirmationPopupVc;
import org.ednovo.gooru.client.uc.tooltip.AddResourceToolTip;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class CollectionResourceTabView extends
		BaseViewWithHandlers<CollectionResourceTabUiHandlers> implements
		IsCollectionResourceTabView {

	private static CollectionResourceTabViewUiBinder uiBinder = GWT
			.create(CollectionResourceTabViewUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface CollectionResourceTabViewUiBinder extends
			UiBinder<Widget, CollectionResourceTabView> {
	}

	@UiField
	VerticalPanel sequenceVerPanel;

	@UiField
	CollectionResourcePanelVc collectionResourcePanelVc; 

	@UiField
	Label dragAndDropLabel;

	/*
	 * @UiField HTMLEventPanel downArrowPanel,popupPanel;
	 */

	@UiField
	Label noResourceLineOneLabel, noResourceLineTwoLabel,
			noResourceLineThreeLabel, noResourceLineFourLabel,noResourceLineFiveLabel,noResourceLineSixLabel;

	@UiField
	HTMLPanel panelNoResourceContainer,panelLoading,contentPanel;

	@UiField
	Button buttonContainer, buttonContainerForQuestion, buttonContainerAddGray,buttonContainerForQuestionGreay ;

	private CollectionDo collectionDo;

	private CollectionEditResourceCss css;
	
	ShelfCollectionResourceChildView shelfCollectionResourceVc;

	private EditQuestionPopupWidget editQuestionPopupWidget;

	private EditResourcePopupVc editResoruce;
	
	private EditUserOwnResourcePopupVc ownResourcePopupVc;
	
	ConfirmationPopupVc deleteConfirmationPopupVc = null;

	private String refreshType = "insert";
	
	String title,description,category,thumbnailUrl;
	private CollectionItemDo collectionItemDo;
	
	private boolean isFlag=false;
	
	private String clickType;
	private PopupPanel toolTipPopupPanel = new PopupPanel();

	private static final String MESSAGE_HEADER = i18n.GL0748();
	private static final String MESSAGE_CONTENT = i18n.GL0891();
	private HandlerRegistration handlerRegistration=null;

	/**
	 * Class constructor
	 */
	public CollectionResourceTabView() {
		setWidget(uiBinder.createAndBindUi(this));
		buttonContainer.setText(i18n.GL0851());
		buttonContainer.getElement().setId("btnNewResource");
		buttonContainer.getElement().setAttribute("alt",i18n.GL0851());
		buttonContainer.getElement().setAttribute("title",i18n.GL0851());
		
		buttonContainerAddGray.setText(i18n.GL0851());
		buttonContainerAddGray.getElement().setId("btnButtonContainerAddGray");
		buttonContainerAddGray.getElement().setAttribute("alt",i18n.GL0851());
		buttonContainerAddGray.getElement().setAttribute("title",i18n.GL0851());
		
		buttonContainerForQuestion.setText(i18n.GL0852());
		buttonContainerForQuestion.getElement().setId("btnNewQuestion");
		buttonContainerForQuestion.getElement().setAttribute("alt",i18n.GL0852());
		buttonContainerForQuestion.getElement().setAttribute("title",i18n.GL0852());
		
		buttonContainerForQuestionGreay.setText(i18n.GL0852());
		buttonContainerForQuestionGreay.getElement().setId("btnButtonContainerForQuestionGreay");
		buttonContainerForQuestionGreay.getElement().setAttribute("alt",i18n.GL0852());
		buttonContainerForQuestionGreay.getElement().setAttribute("title",i18n.GL0852());
		
		dragAndDropLabel.setText(i18n.GL0853());
		dragAndDropLabel.getElement().setId("lblDragAndDropLabel");
		dragAndDropLabel.getElement().setAttribute("alt",i18n.GL0853());
		dragAndDropLabel.getElement().setAttribute("title",i18n.GL0853());
		
		noResourceLineOneLabel.setText(i18n.GL0854());
		noResourceLineOneLabel.getElement().setId("lblNoResourceLineOneLabel");
		noResourceLineOneLabel.getElement().setAttribute("alt",i18n.GL0854());
		noResourceLineOneLabel.getElement().setAttribute("title",i18n.GL0854());
		
		
		noResourceLineTwoLabel.setText(i18n.GL0855());
		noResourceLineTwoLabel.getElement().setId("lblNoResourceLineTwoLabel");
		noResourceLineTwoLabel.getElement().setAttribute("alt",i18n.GL0855());
		noResourceLineTwoLabel.getElement().setAttribute("title",i18n.GL0855());
		
		noResourceLineThreeLabel.setText(" "+i18n.GL0856());
		noResourceLineThreeLabel.getElement().setId("lblNoResourceLineThreeLabel");
		noResourceLineThreeLabel.getElement().setAttribute("alt",i18n.GL0856());
		noResourceLineThreeLabel.getElement().setAttribute("title",i18n.GL0856());
		
		noResourceLineSixLabel.setText(" "+i18n.GL0209()+" ");
		noResourceLineSixLabel.getElement().setId("lblNoResourceLineSixLabel");
		noResourceLineSixLabel.getElement().setAttribute("alt",i18n.GL0209());
		noResourceLineSixLabel.getElement().setAttribute("title",i18n.GL0209());
		
		noResourceLineFiveLabel.setText(" "+i18n.GL0857());
		noResourceLineFiveLabel.getElement().setId("lblNoResourceLineFiveLabel");
		noResourceLineFiveLabel.getElement().setAttribute("alt",i18n.GL0857());
		noResourceLineFiveLabel.getElement().setAttribute("title",i18n.GL0857());
		
		noResourceLineFourLabel.setText(" "+i18n.GL0858());
		noResourceLineFourLabel.getElement().setId("lblNoResourceLineFourLabel");
		noResourceLineFourLabel.getElement().setAttribute("alt",i18n.GL0858());
		noResourceLineFourLabel.getElement().setAttribute("title",i18n.GL0858());
		
		CollectionEditResourceCBundle.INSTANCE.css().ensureInjected();
		css = CollectionEditResourceCBundle.INSTANCE.css();

		noResourceLineOneLabel.setVisible(false);
		panelNoResourceContainer.setVisible(false);
		noResourceLineTwoLabel.setVisible(false);
		noResourceLineThreeLabel.setVisible(false);
		noResourceLineFourLabel.setVisible(false);
		// popupPanel.setVisible(false);
		
		
		buttonContainer.addClickHandler(new NewResourceClickEvent());
		buttonContainerForQuestion.addClickHandler(new NewQuestionClickEvent());
		// searchLabel.addClickHandler(new NewSearchResourceClickEvent());
		dragAndDropLabel.setVisible(true);
		buttonContainerAddGray.setVisible(false);
		contentPanel.setVisible(false);
		panelLoading.getElement().getStyle().setDisplay(Display.BLOCK);
		// downArrowPanel.addClickHandler(new ShowPopupClickHandler());
		collectionResourcePanelVc.getElement().setId("editPanelShelf");
		panelLoading.getElement().setId("pnlPanelLoading");
		contentPanel.getElement().setId("pnlContentPanel");
		sequenceVerPanel.getElement().setId("vpnlSequenceVerPanel");
		panelNoResourceContainer.getElement().setId("pnlPanelNoResourceContainer");
		
		
		
	}

	@Override
	public void reset() {
		super.reset();
		collectionDo = null;
		sequenceVerPanel.clear();
		collectionResourcePanelVc.clear();
	}

	@Override
	public void setData(CollectionDo collectionDo) {
		if (this.collectionDo == null) {
			this.collectionDo = collectionDo;
			Label label = new Label("");
			label.setStyleName(getCss().shelfResourceDragdropSpacer());
			collectionResourcePanelVc.superAdd(label);
			Label toplabel = new Label("");
			toplabel.setStyleName(getCss().shelfResourceDragdropSpacer());
			collectionResourcePanelVc.add(toplabel);
			Label prelabel = new Label("");
			prelabel.setStyleName(getCss().shelfResourceSequenceSpacer());
			sequenceVerPanel.add(prelabel);
			Label postlabel = new Label("");
			postlabel.setStyleName(getCss().shelfResourceSequenceSpacer());
			sequenceVerPanel.add(postlabel);
			if (collectionDo.getCollectionItems().size() <= 0) {
				noResourceLineOneLabel.setVisible(true);
				panelNoResourceContainer.setVisible(true);
				noResourceLineTwoLabel.setVisible(true);
				noResourceLineThreeLabel.setVisible(true);
				noResourceLineFourLabel.setVisible(true);
				// dragAndDropLabel.setVisible(false);
			}
			for (CollectionItemDo collectionItem : collectionDo
					.getCollectionItems()) {
				insertColectionItem(collectionItem, false);
			}
			hideNoResourceMsg();

			if (collectionDo.getCollectionItems().size() >= 25) {
				buttonContainerForQuestionGreay.setVisible(true);
				buttonContainerAddGray.setVisible(true);
				buttonContainer.setVisible(false);
				buttonContainerForQuestion.setVisible(false);
				buttonContainerAddGray.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {

						// showMaximumCollectionItemsPopup();
					}
				});
				buttonContainerForQuestionGreay
						.addClickHandler(new ClickHandler() {

							@Override
							public void onClick(ClickEvent event) {
								// showMaximumCollectionItemsPopup();

							}
						});
				buttonContainerAddGray
						.addMouseOverHandler(new MouseOverHandler() {

							@Override
							public void onMouseOver(MouseOverEvent event) {
								toolTipPopupPanel.clear();
								toolTipPopupPanel
										.setWidget(new AddResourceToolTip());
								toolTipPopupPanel.setPopupPosition(
										event.getRelativeElement()
												.getAbsoluteLeft() - 1, event
												.getRelativeElement()
												.getAbsoluteTop() + 22);
								toolTipPopupPanel
										.removeStyleName("gwt-PopupPanel");
								toolTipPopupPanel.show();
							}

						});
				buttonContainerAddGray
						.addMouseOutHandler(new MouseOutHandler() {

							@Override
							public void onMouseOut(MouseOutEvent event) {
								toolTipPopupPanel.hide();

							}
						});
				buttonContainerForQuestionGreay
						.addMouseOverHandler(new MouseOverHandler() {

							@Override
							public void onMouseOver(MouseOverEvent event) {
								toolTipPopupPanel.clear();
								toolTipPopupPanel
										.setWidget(new AddResourceToolTip());
								toolTipPopupPanel.setPopupPosition(
										event.getRelativeElement()
												.getAbsoluteLeft() - 1, event
												.getRelativeElement()
												.getAbsoluteTop() + 22);
								toolTipPopupPanel
										.removeStyleName("gwt-PopupPanel");
								toolTipPopupPanel.show();

							}
						});
				buttonContainerForQuestionGreay
						.addMouseOutHandler(new MouseOutHandler() {

							@Override
							public void onMouseOut(MouseOutEvent event) {
								toolTipPopupPanel.hide();

							}
						});

			} else {
				toolTipPopupPanel.clear();
				buttonContainerForQuestionGreay.setVisible(false);
				buttonContainerAddGray.setVisible(false);
				buttonContainer.setVisible(true);
				buttonContainerForQuestion.setVisible(true);

				// newResourceLabel.setVisible(true);
			}
		}
		panelLoading.getElement().getStyle().setDisplay(Display.NONE);
		contentPanel.setVisible(true);
	}
	
	public void modifyExistingCollectionItemWidget(final CollectionItemDo collectionItemDo){
		collectionItemDo.setCollection(collectionDo);
		shelfCollectionResourceVc = new ShelfCollectionResourceChildView(this, collectionItemDo);
		shelfCollectionResourceVc.getEditInfoLbl().addClickHandler(
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						shelfCollectionResourceVc.getResourceEditButtonContainer().getElement().getStyle().setVisibility(Visibility.HIDDEN);
						shelfCollectionResourceVc.getEditButton().setVisible(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99,false));
						if (collectionItemDo.getResource().getCategory().equalsIgnoreCase("Question")) {
							getUiHandlers().showEditQuestionResourcePopup(collectionItemDo);
						} 
					}
				});
		collectionResourcePanelVc.remove(collectionItemDo.getItemSequence());
		//sequenceVerPanel.remove(collectionItemDo.getItemSequence()-1);
		collectionResourcePanelVc.addDraggable(shelfCollectionResourceVc,collectionItemDo.getItemSequence());	
	}

	@Override
	public void insertColectionItem(final CollectionItemDo collectionItemDo,boolean newFlag) {
		this.collectionItemDo = collectionItemDo;
		if (collectionDo.getCollectionItems().size() >= 25) {
			buttonContainerForQuestionGreay.setVisible(true);
			buttonContainerAddGray.setVisible(true);
			buttonContainer.setVisible(false);
			buttonContainerForQuestion.setVisible(false);
			buttonContainerAddGray.addMouseOverHandler(new MouseOverHandler() {
				@Override
				public void onMouseOver(MouseOverEvent event) {
					toolTipPopupPanel.clear();
					toolTipPopupPanel.setWidget(new AddResourceToolTip());
					toolTipPopupPanel.setPopupPosition(event
							.getRelativeElement().getAbsoluteLeft() - 1, event
							.getRelativeElement().getAbsoluteTop() + 22);
					toolTipPopupPanel.removeStyleName("gwt-PopupPanel");
					toolTipPopupPanel.show();
				}

			});
			buttonContainerAddGray.addMouseOutHandler(new MouseOutHandler() {
				@Override
				public void onMouseOut(MouseOutEvent event) {
					toolTipPopupPanel.hide();
				}
			});
			buttonContainerForQuestionGreay.addMouseOverHandler(new MouseOverHandler() {
						@Override
						public void onMouseOver(MouseOverEvent event) {
							toolTipPopupPanel.clear();
							toolTipPopupPanel.setWidget(new AddResourceToolTip());
							toolTipPopupPanel.setPopupPosition(
									event.getRelativeElement()
											.getAbsoluteLeft() - 1, event
											.getRelativeElement()
											.getAbsoluteTop() + 22);
							toolTipPopupPanel.removeStyleName("gwt-PopupPanel");
							toolTipPopupPanel.show();

						}
					});
			buttonContainerForQuestionGreay
					.addMouseOutHandler(new MouseOutHandler() {

						@Override
						public void onMouseOut(MouseOutEvent event) {
							toolTipPopupPanel.hide();

						}
					});

		} else {
			toolTipPopupPanel.clear();
			buttonContainerForQuestionGreay.setVisible(false);
			buttonContainerAddGray.setVisible(false);
			buttonContainer.setVisible(true);
			buttonContainerForQuestion.setVisible(true);
		}
		if (newFlag) {
			if (collectionDo.getCollectionItems() == null) {
				collectionDo
						.setCollectionItems(new ArrayList<CollectionItemDo>());
			}
			if (!collectionDo.getCollectionItems().contains(collectionItemDo)) {
				collectionDo.getCollectionItems().add(collectionItemDo);
			}

			AppClientFactory
					.fireEvent(new RefreshCollectionItemInShelfListEvent(
							collectionItemDo, RefreshType.INSERT));
			noResourceLineOneLabel.setVisible(false);
			panelNoResourceContainer.setVisible(false);
			noResourceLineTwoLabel.setVisible(false);
			noResourceLineThreeLabel.setVisible(false);
			noResourceLineFourLabel.setVisible(false);
			dragAndDropLabel.setVisible(true);

		} else {
			collectionItemDo.setCollection(collectionDo);
			Label sequenceLbl = new Label(collectionItemDo.getItemSequence()
					+ "");
			sequenceLbl.setStyleName(getCss().shelfResourceSequenceNumber());
			int sequencePostion = collectionItemDo.getItemSequence();
			sequencePostion = sequencePostion >= sequenceVerPanel
					.getWidgetCount() ? sequenceVerPanel.getWidgetCount() - 1
					: sequencePostion;
			sequenceVerPanel.insert(sequenceLbl, sequencePostion);
			resetSequence();
			shelfCollectionResourceVc = new ShelfCollectionResourceChildView(this, collectionItemDo);
			if(isFlag){
				isFlag=false;
//				Window.scrollTo(0, (0 + (sequencePostion-1)*113));
				shelfCollectionResourceVc.addNewResource();
			}
			shelfCollectionResourceVc.getEditInfoLbl().addClickHandler(	new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							shelfCollectionResourceVc.getResourceEditButtonContainer().getElement().getStyle().setVisibility(Visibility.HIDDEN);
							shelfCollectionResourceVc.getEditButton().setVisible(false);
							AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99,false));
							if (collectionItemDo.getResource().getCategory().equalsIgnoreCase("Question")) {
								getUiHandlers().showEditQuestionResourcePopup(collectionItemDo);
							} else if(collectionItemDo.getResource().getResourceType().getName().equals("resource/url") || collectionItemDo.getResource().getResourceType().getName().equals("video/youtube")){
								editResoruce = new EditResourcePopupVc(collectionItemDo) {
	
								@Override
								public void updateResource(CollectionItemDo collectionItemDo,List<String> tagList) {
									getUiHandlers().updateResourceInfo(collectionItemDo,tagList);
								}
	
								@Override
								public void resourceImageUpload() {
									getUiHandlers().imageEditResourceUpload();
								}

								@Override
								public void onSelection(
										SelectionEvent<Suggestion> event) {
									super.onSelection(event);		
								}

								@Override
								public void browseStandardsInfo(boolean val) {
									getUiHandlers().getBrowseStandardsInfo(val);
								}

								@Override
								public void closeStandardsPopup() {
									getUiHandlers().closeBrowseStandardsPopup();
								}
								};
							}
							else {
								MixpanelUtil.Resource_Action_Edit_Info();
								ownResourcePopupVc = new EditUserOwnResourcePopupVc(collectionItemDo) {
									@Override
									public void resourceImageUpload() {
										getUiHandlers().imageEditUserOwnResourceUpload();
									}
									@Override
									public void updateUserOwnResource(String resourceFilePath,String resMediaFileName,String resOriginalFileName,String titleStr, String desc,String categoryStr,	String thumbnailUrlStr) {
										title=titleStr;
										description = desc;
										category = categoryStr;
										thumbnailUrl = thumbnailUrlStr;
//										if(category.contains("Image")||category.contains("Text"))
//										{
//											category=category.substring(0, category.length()-1);
//											/* if(category.contains("Image")||category.contains("Images")){
//												 category="Slide";
//											 }*/
//										}
										
										JSONObject jsonObject = setEditUserResourceJsonObject(resOriginalFileName,resMediaFileName, title, desc, category, thumbnailUrlStr);
									
										getUiHandlers().editUserOwnResource(jsonObject.toString(),collectionItemDo.getResource().getGooruOid());
//										getUiHandlers().getUserResourceMediaFileName(resourceFilePath);
									}
								};
							}

						}
					});
			collectionResourcePanelVc.addDraggable(shelfCollectionResourceVc,
					collectionItemDo.getItemSequence());
			AppClientFactory.fireEvent(new UpdateResourceCountEvent(
					collectionDo.getCollectionItems().size()));
		}
		hideNoResourceMsg();
//		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
	}

	/*public void insertCollectionItemForCopy(
			final CollectionItemDo collectionItemDo,
			boolean isBeingCopiedToSameCollection) {

		if (collectionDo.getCollectionItems() == null) {
			collectionDo.setCollectionItems(new ArrayList<CollectionItemDo>());
		}
		if (!collectionDo.getCollectionItems().contains(collectionItemDo)) {
			collectionDo.getCollectionItems().add(collectionItemDo);
		}

		AppClientFactory.fireEvent(new RefreshCollectionItemInShelfListEvent(
				collectionItemDo, RefreshType.INSERT));
		noResourceLineOneLabel.setVisible(false);
		panelNoResourceContainer.setVisible(true);
		noResourceLineTwoLabel.setVisible(false);
		noResourceLineThreeLabel.setVisible(false);
		noResourceLineFourLabel.setVisible(false);
		dragAndDropLabel.setVisible(true);

		if (isBeingCopiedToSameCollection) {
			setNewResourcePanel(collectionItemDo);
		}
	}*/

	public void setNewResourcePanel(final CollectionItemDo collectionItemDo) {
		this.collectionItemDo = collectionItemDo;
		// Refresh on adding : Shelf refreshes but the code below throws an
		// index out of bouds exception. If this is fixed. New resources will
		// get added
		collectionItemDo.setCollection(this.collectionDo);
		Label sequenceLbl = new Label(collectionItemDo.getItemSequence() + "");
		sequenceLbl.setStyleName(getCss().shelfResourceSequenceNumber());
		int sequencePostion = collectionItemDo.getItemSequence();
		sequencePostion = sequencePostion >= sequenceVerPanel.getWidgetCount() ? sequenceVerPanel.getWidgetCount() - 1 : sequencePostion;
		sequenceVerPanel.insert(sequenceLbl, sequencePostion);
		resetSequence();
		final ShelfCollectionResourceChildView shelfCollectionResourceVc = new ShelfCollectionResourceChildView(this, collectionItemDo);
		Window.Location.reload();
		shelfCollectionResourceVc.getEditInfoLbl().addClickHandler(	new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						shelfCollectionResourceVc.getResourceEditButtonContainer().getElement().getStyle().setVisibility(Visibility.HIDDEN);
						shelfCollectionResourceVc.getEditButton().setVisible(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99,false));
						if (collectionItemDo.getResource().getCategory().equalsIgnoreCase("Question")) {
							editQuestionPopupWidget = new EditQuestionPopupWidget(collectionItemDo);
							editQuestionPopupWidget.getAddQuestion().getElement().getStyle().setDisplay(Display.NONE);
							editQuestionPopupWidget.getUpdateQuestionImageView().getUploadImage().addClickHandler(new ClickHandler() {
										@Override
										public void onClick(ClickEvent event) {
											getUiHandlers().updateQustionImage(collectionItemDo.getCollectionItemId());
										}
									});
							editQuestionPopupWidget
									.getUpdateQuestionImageView()
									.getRemoveImage()
									.addClickHandler(new ClickHandler() {

										@Override
										public void onClick(ClickEvent event) {
											editQuestionPopupWidget.hide();
											deleteConfirmationPopupVc = new ConfirmationPopupVc(
													MESSAGE_HEADER,
													MESSAGE_CONTENT) {

												@Override
												public void onDelete(
														ClickEvent clickEvent) {

													getUiHandlers()
															.removeQuestionImage(
																	collectionItemDo
																			.getResource()
																			.getGooruOid());
												}

												public void hide() {
													super.hide();

													Window.enableScrolling(true);
													AppClientFactory
															.fireEvent(new SetHeaderZIndexEvent(
																	0, true));

													editQuestionPopupWidget
															.show();
												}
											};
										}
									});

							editQuestionPopupWidget.getAddQuestion()
									.addClickHandler(new ClickHandler() {

										@Override
										public void onClick(ClickEvent event) {
											getUiHandlers().updateQustionImage(
													collectionItemDo
															.getCollectionItemId());
										}
									});
//						} else if(collectionItemDo.getResource().getResourceType().getDescription().equals("web resource") || collectionItemDo.getResource().getResourceType().getDescription().equals("video")){
						} else if(collectionItemDo.getResource().getResourceType().getName().equals("resource/url") || collectionItemDo.getResource().getResourceType().getName().equals("video/youtube")){
							editResoruce = new EditResourcePopupVc(collectionItemDo) {

							@Override
							public void updateResource(CollectionItemDo collectionItemDo,List<String> tagList) {
								getUiHandlers().updateResourceInfo(collectionItemDo,tagList);
							}

							@Override
							public void resourceImageUpload() {
								getUiHandlers().imageEditResourceUpload();
								}

							@Override
							public void onSelection(
									SelectionEvent<Suggestion> event) {
								super.onSelection(event);
								
							}

							@Override
							public void browseStandardsInfo(boolean val) {
								getUiHandlers().getBrowseStandardsInfo(val);
							}

							@Override
							public void closeStandardsPopup() {
								getUiHandlers().closeBrowseStandardsPopup();
							}
							};
						}

						else {
							MixpanelUtil.Resource_Action_Edit_Info();
							ownResourcePopupVc = new EditUserOwnResourcePopupVc(collectionItemDo) {
								@Override
								public void resourceImageUpload() {
									getUiHandlers().imageEditUserOwnResourceUpload();
								}

								@Override
								public void updateUserOwnResource(String resourceFilePath,String resMediaFileName,String resOriginalFileName,String titleStr, String desc,String categoryStr,String thumbnailUrlStr) {
									title=titleStr;
									description = desc;
									category = categoryStr;
									thumbnailUrl = thumbnailUrlStr;
									JSONObject jsonObject = setEditUserResourceJsonObject(resOriginalFileName,resMediaFileName, title, desc, category, thumbnailUrlStr);
									getUiHandlers().editUserOwnResource(jsonObject.toString(),collectionItemDo.getResource().getGooruOid());
//									getUiHandlers().getUserResourceMediaFileName(resourceFilePath);
								}
							};
						}

					}
				});
		collectionResourcePanelVc.addDraggable(shelfCollectionResourceVc,collectionItemDo.getItemSequence());
	}

	public class EditQuestionPopupWidget extends EditQuestionPopupVc {
		private String collectionItemId;

		public EditQuestionPopupWidget(CollectionItemDo collectionItemDo) {
			super(collectionItemDo);
			this.collectionItemId = collectionItemDo.getCollectionItemId();
			AppClientFactory.fireEvent(new GetEditPageHeightEvent(this, false));
		}

		public void show() {
			super.show();
			this.center();
			// this.getElement().getStyle().setTop(100, Unit.PX);
		}

		@Override
		public void updateQuestionResource(String collectionItemId,
				CollectionQuestionItemDo collectionQuestionItemDo) {
			// getUiHandlers().updateQuestionResource(collectionItemId,
			// collectionQuestionItemDo);
			if (editQuestionPopupWidget.getQuestionImageContainer()
					.getElement().hasChildNodes()) {
				UpdateQuestionImageView updateQuestionImage = (UpdateQuestionImageView) editQuestionPopupWidget
						.getQuestionImageContainer().getWidget(0);
				String thumbnailUrl = updateQuestionImage
						.getThumbnailImageUrl();
				if (thumbnailUrl != null) {
					// getUiHandlers().updateQuestionImage(collectionItemId,
					// "asset-question_"+thumbnailUrl);
					getUiHandlers().updateQuestionResource(collectionItemId,
							collectionQuestionItemDo,
							"asset-question_" + thumbnailUrl);

				} else {
					getUiHandlers().updateQuestionResource(collectionItemId,
							collectionQuestionItemDo, null);
				}

			} else {
				getUiHandlers().updateQuestionResource(collectionItemId,
						collectionQuestionItemDo, null);
			}

		}

		@Override
		public void callBrowseStandardsInfo(boolean val) {
			getUiHandlers().getBrowseStandardsInfo(val);
		}

		public void setUpdatedBrowseStandardsVal(String setStandardsVal,Integer codeId, String setStandardDesc) {
			super.setUpdatedBrowseStandards(setStandardsVal,codeId,setStandardDesc);
			
		}

		@Override
		public void closeBrowseStandardsPopup() {
		getUiHandlers().closeBrowseStandardsPopup();
		}

	}

	@Override
	public void removeCollectionItem(CollectionItemDo collectionItemDo,
			ShelfCollectionResourceChildView resourceChildView) {
		int sequence = collectionResourcePanelVc
				.getWidgetIndex(resourceChildView.getParent());
		collectionResourcePanelVc.remove(sequence);
		sequenceVerPanel.remove(sequence);
		resetSequence();
		collectionDo.getCollectionItems().remove(collectionItemDo);

		if (collectionDo.getCollectionItems().size() >= 25) {
			// newResourceLabel.setVisible(false);

			buttonContainerForQuestionGreay.setVisible(true);
			buttonContainerAddGray.setVisible(true);
			buttonContainer.setVisible(false);
			buttonContainerForQuestion.setVisible(false);
			buttonContainerAddGray.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					// showMaximumCollectionItemsPopup();
				}
			});
			buttonContainerForQuestionGreay.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					// showMaximumCollectionItemsPopup();

				}
			});
			buttonContainerAddGray.addMouseOverHandler(new MouseOverHandler() {

				@Override
				public void onMouseOver(MouseOverEvent event) {
					toolTipPopupPanel.clear();
					toolTipPopupPanel.setWidget(new AddResourceToolTip());
					toolTipPopupPanel.setPopupPosition(event
							.getRelativeElement().getAbsoluteLeft() - 1, event
							.getRelativeElement().getAbsoluteTop() + 22);
					toolTipPopupPanel.removeStyleName("gwt-PopupPanel");
					toolTipPopupPanel.show();
				}

			});
			buttonContainerAddGray.addMouseOutHandler(new MouseOutHandler() {

				@Override
				public void onMouseOut(MouseOutEvent event) {
					toolTipPopupPanel.hide();

				}
			});
			buttonContainerForQuestionGreay
					.addMouseOverHandler(new MouseOverHandler() {

						@Override
						public void onMouseOver(MouseOverEvent event) {
							toolTipPopupPanel.clear();
							toolTipPopupPanel
									.setWidget(new AddResourceToolTip());
							toolTipPopupPanel.setPopupPosition(
									event.getRelativeElement()
											.getAbsoluteLeft() - 1, event
											.getRelativeElement()
											.getAbsoluteTop() + 22);
							toolTipPopupPanel.removeStyleName("gwt-PopupPanel");
							toolTipPopupPanel.show();

						}
					});
			buttonContainerForQuestionGreay
					.addMouseOutHandler(new MouseOutHandler() {

						@Override
						public void onMouseOut(MouseOutEvent event) {
							toolTipPopupPanel.hide();

						}
					});
		} else {

			toolTipPopupPanel.clear();
			buttonContainerForQuestionGreay.setVisible(false);
			buttonContainerAddGray.setVisible(false);
			buttonContainer.setVisible(true);
			buttonContainerForQuestion.setVisible(true);
			// newResourceLabel.setVisible(true);
		}
		if (collectionDo.getCollectionItems().size() <= 0) {
			noResourceLineOneLabel.setVisible(true);
			panelNoResourceContainer.setVisible(true);
			noResourceLineTwoLabel.setVisible(true);
			noResourceLineThreeLabel.setVisible(true);
			noResourceLineFourLabel.setVisible(true);
			// dragAndDropLabel.setVisible(false);
		}
		AppClientFactory.fireEvent(new UpdateResourceCountEvent(collectionDo.getCollectionItems().size()));

	}

	/**
	 * Reorder the collection item , and change collection item order view
	 */
	private void resetSequence() {
		Iterator<Widget> widgets = sequenceVerPanel.iterator();
		int sequence = 1;
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof Label
					&& ((Label) widget).getText().length() > 0) {
				((Label) widget).setText(sequence++ + "");
			}
		}
	}

	@Override
	public void setEditMode(boolean editMode, Widget resourceWidget) {
		Widget sequenceWidget = sequenceVerPanel
				.getWidget(collectionResourcePanelVc
						.getWidgetIndex(resourceWidget.getParent()));
		collectionResourcePanelVc.makeChildrenDraggable(!editMode);
		sequenceWidget.setHeight((resourceWidget.getOffsetHeight() - 7) + "px");
	}

	/**
	 * @return css instance of {@link CollectionEditResourceCss}
	 */
	public CollectionEditResourceCss getCss() {
		return css;
	}

	/**
	 * @param css
	 *            name the styles to set
	 */
	public void setCss(CollectionEditResourceCss css) {
		this.css = css;
	}

	/*
	 * To handle click event for New Resource
	 */
	private class NewResourceClickEvent implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.Click_On_AddResource();
			clickType = "Url";
			hidePopup();
			if (collectionDo.getCollectionItems().size() >= 25) {

				// showMaximumCollectionItemsPopup();

			} else {
				MixpanelUtil.Click_Add_NewResource();
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
				displayNewResourcePopup();
			}

		}
	}

	/*
	 * To handle click event for New Resource
	 */
	private class NewQuestionClickEvent implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			try{
			MixpanelUtil.Click_On_AddQuestion();
			clickType = "Question";
			// popupPanel.setVisible(false);
			hidePopup();
			if (collectionDo.getCollectionItems().size() >= 25) {
				// showMaximumCollectionItemsPopup();

			} else {
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
				displayNewResourcePopup();
			}
		}catch(Exception e){
			
		}
			

		}

	}
	
	/*
	 * To hide the Popup
	 */
	private void hidePopup() {
		// popupPanel.setVisible(false);
		// popupPanel.getElement().getStyle().setDisplay(Display.NONE);
	}


	/*private class NewSearchResourceClickEvent implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			clickType = "Search";
			// popupPanel.setVisible(false);
			hidePopup();
			if (collectionDo.getCollectionItems().size() >= 25) {
				// showMaximumCollectionItemsPopup();
			} else {
				MixpanelUtil.Click_Add_NewResource();
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
				displayNewResourcePopup();
			}
		}
	}*/

	/*
	 * private class ShowPopupClickHandler implements ClickHandler{
	 * 
	 * @Override public void onClick(ClickEvent event) {
	 * if(popupPanel.isVisible()) { popupPanel.setVisible(false); } else {
	 * popupPanel.setVisible(true); } } }
	 */

	public void showMaximumCollectionItemsPopup() {

		AlertContentUc alertContentUc = new AlertContentUc(
				i18n.GL0061(),
				i18n.GL0302());

	}

	/*public int getCollectionItemSize() {
		return collectionDo.getCollectionItems().size();
	}*/

	@Override
	public void displayNewResourcePopup() {
		getUiHandlers().addResourcePopup(collectionDo, clickType);
	}


	@Override
	public void insertData(CollectionItemDo collectionItem) {
		AppClientFactory.fireEvent(new RefreshCollectionItemInShelfListEvent(
				collectionItem, RefreshType.INSERT));
		AppClientFactory.fireEvent(new InsertCollectionItemInAddResourceEvent(
				collectionItem, RefreshType.INSERT));
	}
	@Override
	public void updateCollectionItem(CollectionItemDo collectionItem) {
		if(collectionItem != null)
		{
		AppClientFactory.fireEvent(new RefreshCollectionItemInShelfListEvent(collectionItem, RefreshType.UPDATE));
		AppClientFactory.fireEvent(new InsertCollectionItemInAddResourceEvent(collectionItem, RefreshType.UPDATE));
		}
	}
	

	native void redirect(String url)
	/*-{
		$wnd.location.reload();
	}-*/;


	@Override
	public void hideUpdateResourcePopup() {
		
			editResoruce.hide();

			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	
		

	}
	
	@Override
	public void hideUpdateOwnResourcePopup() {
		
			ownResourcePopupVc.hide();

			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	
		

	}

	@Override
	public void hideUpdateResourceQuestionPopup() {
			AppClientFactory.fireEvent(new GetEditPageHeightEvent(editQuestionPopupWidget, true));
			editQuestionPopupWidget.hide();

			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		
		

	}

	@Override
	public void updateCollectionItemImage(String imageUrl,
			String fileNameWithOutRepository) {

		// editQuestionPopupWidget.getUpdateQuestionImage().setUrl(imageUrl+"?"+Math.random());
		if (editQuestionPopupWidget.getQuestionImageContainer().getElement()
				.hasChildNodes()) {
			UpdateQuestionImageView updateQuestionImage = (UpdateQuestionImageView) editQuestionPopupWidget
					.getQuestionImageContainer().getWidget(0);
			updateQuestionImage.getUpdateQuestionImage().setUrl(imageUrl);
			updateQuestionImage.setThumbnailImageUrl(fileNameWithOutRepository);
		} else {
			displayUpdateQuestionView(imageUrl, fileNameWithOutRepository);
		}

	}

	public void displayUpdateQuestionView(String imageUrl,
			String fileNameWithOutRepository) {
		UpdateQuestionImageView updateQuestionImage = new UpdateQuestionImageView();
		updateQuestionImage.getUpdateQuestionImage().setUrl(imageUrl);
		updateQuestionImage.setThumbnailImageUrl(fileNameWithOutRepository);
		editQuestionPopupWidget.getQuestionImageContainer().clear();
		editQuestionPopupWidget.getQuestionImageContainer().add(
				updateQuestionImage);
		updateQuestionImage.getUploadImage().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						getUiHandlers().updateQustionImage(
								editQuestionPopupWidget.collectionItemId);
					}
				});
		updateQuestionImage.getRemoveImage().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						editQuestionPopupWidget.hide();
						deleteConfirmationPopupVc = new ConfirmationPopupVc(
								MESSAGE_HEADER, MESSAGE_CONTENT) {

							@Override
							public void onDelete(ClickEvent clickEvent) {

								getUiHandlers()
										.removeQuestionImage(
												editQuestionPopupWidget.collectionItemId);
							}

							public void hide() {
								super.hide();

								Window.enableScrolling(true);
								AppClientFactory
										.fireEvent(new SetHeaderZIndexEvent(0,
												true));

								editQuestionPopupWidget.show();
							}
						};
					}
				});
	}

	@Override
	public void removeUpdateQuestionView() {
		deleteConfirmationPopupVc.hide();

		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

		editQuestionPopupWidget.show();
		editQuestionPopupWidget.getUpdateQuestionImageView().removeFromParent();
		editQuestionPopupWidget.getAddQuestion().getElement().getStyle()
				.setDisplay(Display.BLOCK);
	}

	@Override
	public void updateResouceItemImage(String imageUrl,String fileNameWithOutRespUrl, boolean isEditUserOwnResourceImage) {
		if(isEditUserOwnResourceImage){
			ownResourcePopupVc.getSetThumbnailImage().setUrl(imageUrl + "?" + Math.random());
			ownResourcePopupVc.setThumbnailUrlStr(imageUrl);
			ownResourcePopupVc.setFileNameWithOutRespUrl(fileNameWithOutRespUrl);
		}
		else{
			editResoruce.getSetThumbnailImage().setUrl(imageUrl + "?" + Math.random());
			editResoruce.setThumbnailUrlStr(imageUrl);
			editResoruce.setFileNameWithOutRespUrl(fileNameWithOutRespUrl);
		}
		
	}

	@Override
	public void hideNoResourceMsg() {
		if (this.collectionDo.getCollectionItems().size() > 0) {
			noResourceLineOneLabel.setVisible(false);
			panelNoResourceContainer.setVisible(false);
			noResourceLineTwoLabel.setVisible(false);
			noResourceLineThreeLabel.setVisible(false);
			noResourceLineFourLabel.setVisible(false);
		}
	}

	@Override
	public void insertCollectionItemInAddResource(
			CollectionItemDo collectionItem, RefreshType refreshType) {
		this.refreshType = refreshType.toString();
		if (this.refreshType.equalsIgnoreCase("insert")) {
			collectionDo.getCollectionItems().add(collectionItem);
			isFlag=true;
			insertColectionItem(collectionItem, false);
		} else if(refreshType.toString().equalsIgnoreCase("update")){
			collectionDo.getCollectionItems().set(collectionItem.getItemSequence()-1, collectionItem);
			modifyExistingCollectionItemWidget(collectionItem);
		}
		else {
			insertColectionItem(collectionItem, false);
		}
	}

	@Override
	public void closeAllOpenedPopUp() {
		if(editResoruce!=null && editResoruce.isShowing()){
			editResoruce.hide();

		}
		if(editQuestionPopupWidget!=null && editQuestionPopupWidget.isShowing()){
			editQuestionPopupWidget.hide();
		}
	}

	@Override
	public void uploadResource(MediaUploadDo result) {
		JSONObject jsonObject = setEditUserResourceJsonObject(result.getOriginalFilename(),result.getName(), title, description, category, thumbnailUrl);
		getUiHandlers().editUserOwnResource(jsonObject.toString(),collectionItemDo.getResource().getGooruOid());
		
	}

	private JSONObject setEditUserResourceJsonObject(String originalFilename,String mediaFileName, String editedTitle, String editedDescription, String editedCategory,String editedThumbnailUrl) {
		JSONObject file = new JSONObject();
		 if(originalFilename!=null && mediaFileName!=null){
			 file.put("filename", new JSONString(originalFilename));
			 file.put("mediaFilename", new JSONString(mediaFileName));
		 }
		
		     
		 JSONObject attach = new JSONObject();
        attach.put("title", new JSONString(editedTitle));
        attach.put("description", new JSONString(editedDescription));
        JSONObject resourceFormat = new JSONObject();
        resourceFormat.put("value", new JSONString(editedCategory));
        attach.put("resourceFormat", resourceFormat);
        if(editedThumbnailUrl!=null){
        	 attach.put("thumbnail", new JSONString(editedThumbnailUrl));
        }
        if(originalFilename!=null && mediaFileName!=null){
        	 attach.put("attach", file);
             
        }
       
        JSONObject resource = new JSONObject();
        resource.put("resource", attach);
        
		return resource;
	}

	@Override
	public void OnBrowseStandardsClickEvent(Button addStandardsBtn) {
		// TODO Auto-generated method stub
		if(handlerRegistration!=null){
			handlerRegistration.removeHandler();
		}
		handlerRegistration=addStandardsBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getUiHandlers().addUpdatedBrowseStandards();
			}
		});
	}

	@Override
	public void setUpdatedStandardsCode(String setStandardsVal, Integer codeId,String setStandardDesc, boolean value) {
		if(value == false){
			editResoruce.setUpdatedBrowseStandardsVal(setStandardsVal,codeId,setStandardDesc);
		}else{
			editQuestionPopupWidget.setUpdatedBrowseStandardsVal(setStandardsVal,codeId,setStandardDesc);
		}
		
	}
}
