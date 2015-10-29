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
package org.ednovo.gooru.client.mvp.gshelf.righttabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.SimpleAsyncCallback;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.gshelf.ShelfTreeWidget;
import org.ednovo.gooru.client.mvp.gshelf.util.FolderInfoWidget;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.vc.DeletePopupViewVc;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.DeleteContentPopup;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.ClientConstants;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class MyCollectionsRightClusterView extends BaseViewWithHandlers<MyCollectionsRightClusterUiHandlers> implements IsMyCollectionsRightClusterView,ClientConstants  {

    private static MyCollectionsRightViewUiBinder uiBinder = GWT.create(MyCollectionsRightViewUiBinder.class);

    interface MyCollectionsRightViewUiBinder extends UiBinder<Widget, MyCollectionsRightClusterView> {
    }

    public MessageProperties i18n = GWT.create(MessageProperties.class);

    @UiField HTMLPanel mainPanel,pnlSlotInnerContent,/*toggleButton,deletePnl,*/glassPanelDiv;

    @UiField Anchor lnkInfo,lnkContent,lnkshare,lnkPreview,lnkPublish/*,lnkDeleteButton*/;
    //@UiField HTMLEventPanel /*popupPanelDropDwn,*/copyPopupPanel;
    @UiField HTMLEventPanel copyLbl,moveLbl,myCollDelLbl,tootltipContainer;

    @UiField FlowPanel pnlBreadCrumbMain;

    FolderDo folderObj;
    FolderDo courseFolderObj = new FolderDo();

    DeletePopupViewVc deletePopup = null;

    DeleteContentPopup deleteContentPopup = null;

    ArrayList<ClasspageDo> classesList = new ArrayList<>();

    final String ACTIVE="active";
    private static final String O1_LEVEL = "o1";
    private static final String O2_LEVEL = "o2";
    private static final String O3_LEVEL = "o3";

    private static final String COURSE = "Course";
    private static final String UNIT = "Unit";
    private static final String LESSON = "Lesson";
    private static final String COLLECTION = "collection";
    private static final String ASSESSMENT = "assessment";
    private static final String ASSESSMENT_URL = "assessment/url";

    private String LTI_URL = "";

    private static final String LTI="illuminateed.com";
    final String PASTEURL="Paste URL here";

    private String currentTypeView;
    String o1,o2,o3;
    String oldO1Value=null,oldO2Value=null,oldO3Value=null;

    ArrayList<String> breadCumsSting=new ArrayList<String>();
    private boolean isCopySelected= false;
    private boolean isMoveSelected= false;

    private boolean isCollaborator= false;
	private HandlerRegistration handlerRegistration=null;
	private HandlerRegistration handlerRegistrationHover=null;
	
	AddCollectionToClassView addtoClassPopup = null;


    public MyCollectionsRightClusterView() {
        setWidget(uiBinder.createAndBindUi(this));
        setIds();

        lnkInfo.setVisible(true);
        lnkContent.setVisible(false);
        lnkshare.setVisible(false);

        lnkInfo.addClickHandler(new TabClickHandler(1,lnkInfo));
        lnkContent.addClickHandler(new TabClickHandler(2,lnkContent));
        lnkshare.addClickHandler(new TabClickHandler(3,lnkshare));
        lnkPreview.addClickHandler(new PreviewClickHandler());
        handlerRegistration = lnkPublish.addClickHandler(new PublishClickHandler());
      

        copyLbl.addClickHandler(new onCopyClickHandler());
        moveLbl.addClickHandler(new onMoveClickHandler());
        myCollDelLbl.addClickHandler(new DeleteContentData());

        lnkPreview.setVisible(false);
        lnkPublish.setVisible(false);
        lnkshare.setText(i18n.GL0536());
        moveLbl.setVisible(false);
        copyLbl.setVisible(false);
        myCollDelLbl.setVisible(false);
        
        GlobalToolTip gblTlp = new GlobalToolTip(StringUtil.generateMessage(i18n.GL3601(),""),"here",true);
        gblTlp.getLinkLbl().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// here
				tootltipContainer.setVisible(false);
				if(getUiHandlers().getCurrentTreeItem().getParentItem()!=null && getUiHandlers().getCurrentTreeItem().getParentItem().getParentItem()!=null && getUiHandlers().getCurrentTreeItem().getParentItem().getParentItem().getParentItem()!=null)
				{
				final TreeItem shelfTreeWidget = getUiHandlers().getCurrentTreeItem().getParentItem().getParentItem().getParentItem();
				TreeItem unitshelfTreeWidget = getUiHandlers().getCurrentTreeItem().getParentItem().getParentItem();
				TreeItem lessonshelfTreeWidget = getUiHandlers().getCurrentTreeItem().getParentItem();
				TreeItem oldshelfTreeWidget = getUiHandlers().getCurrentTreeItem();				
				final ShelfTreeWidget widget = (ShelfTreeWidget)shelfTreeWidget.getWidget();
				final ShelfTreeWidget fromWidget = (ShelfTreeWidget) oldshelfTreeWidget.getWidget();
				final List<FolderDo> folderListDoChild=new ArrayList<>();				
				int childWidgetsCount=shelfTreeWidget.getChildCount();
				for (int i = 0; i < childWidgetsCount; i++) {
					ShelfTreeWidget widget1 = (ShelfTreeWidget)shelfTreeWidget.getChild(i).getWidget();
					if(widget1.getCollectionDo()!=null){
						folderListDoChild.add(widget1.getCollectionDo());
					}
				}
				unitshelfTreeWidget.removeItems();
				lessonshelfTreeWidget.removeItems();				
				getUiHandlers().getShelfMainPresenter().setBreadCrumbs(widget.getUrlParams());
				getUiHandlers().getShelfMainPresenter().setFolderActiveStatus();
				if(widget.getFolderDo()!=null)
				{
				getUiHandlers().getShelfMainPresenter().updateTitleOfTreeWidget(widget.getFolderDo(),true,shelfTreeWidget);
				getUiHandlers().getShelfMainPresenter().setRightPanelData(widget.getFolderDo(), COURSE, folderListDoChild);
				}
				else
				{
					//here
					final String courseId=AppClientFactory.getPlaceManager().getRequestParameter("o1",null);

					AppClientFactory.getInjector().getfolderService().getCourseDetails(courseId, null, null, new SimpleAsyncCallback<FolderDo>() {
						@Override
						public void onSuccess(FolderDo result) {
							courseFolderObj = result;
							getUiHandlers().getShelfMainPresenter().updateTitleOfTreeWidget(result,true,shelfTreeWidget);
							getUiHandlers().getShelfMainPresenter().setRightPanelData(result, COURSE, folderListDoChild);
							HashMap<String,String> params = new HashMap<String,String>();
							params.put("o1", courseId);
							params.put("view", "Course");
							AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT, params);
							fromWidget.setActiveStyle(false);
							fromWidget.setFolderOpenedStatus(false);
							widget.setActiveStyle(true);
							widget.setFolderOpenedStatus(false);
							widget.getTitleFocPanel().addStyleName("course");				
							getUiHandlers().getShelfMainPresenter().getOrganizeRootPnl().setStyleName("active");
							widget.getTitleFocPanel().removeStyleName("open");				
							shelfTreeWidget.removeItems();				
							shelfTreeWidget.setState(false);				
							widget.openFolderInShelfFromCourse(result);
							getUiHandlers().setTabItems(3, COURSE, result);
						}
					});
				}
				if(widget.getFolderDo()!=null)
				{			
				fromWidget.setActiveStyle(false);
				fromWidget.setFolderOpenedStatus(false);
				widget.setActiveStyle(true);
				widget.setFolderOpenedStatus(false);
				widget.getTitleFocPanel().addStyleName("course");				
				getUiHandlers().getShelfMainPresenter().getOrganizeRootPnl().setStyleName("active");
				widget.getTitleFocPanel().removeStyleName("open");				
				shelfTreeWidget.removeItems();				
				shelfTreeWidget.setState(false);				
				widget.openFolderInShelfFromCourse(widget.getFolderDo());
				getUiHandlers().setTabItems(3, COURSE, widget.getFolderDo());
				}
				}
			}
		});
        tootltipContainer.add(gblTlp);
        tootltipContainer.setVisible(false);
        copyLbl.setTitle(i18n.GL0827());
        moveLbl.setTitle(i18n.GL1261());   
        
    	glassPanelDiv.getElement().setAttribute("style", "position: absolute; left: 0px; top: 0px;");
		glassPanelDiv.getElement().getStyle().setWidth(Window.getClientWidth(), Unit.PX);
		glassPanelDiv.getElement().getStyle().setHeight(Window.getClientHeight(), Unit.PX);
		glassPanelDiv.setStyleName("gwt-PopupPanelGlass");
		glassPanelDiv.setVisible(false);
    }
    public void setIds(){
        mainPanel.getElement().setId("gShelfCourseInfo");
        pnlSlotInnerContent.getElement().setId("pnlSlotInnerContent");
        lnkInfo.getElement().setId("lnkInfo");
        lnkContent.getElement().setId("lnkContent");
        lnkshare.getElement().setId("lnkshare");
        pnlBreadCrumbMain.getElement().setId("pnlBreadCrumbMain");

    }
	@Override
	public void hideglassPanel() {
		glassPanelDiv.setVisible(false);
	}
    /**
     * This inner class will handle the click event on the info,content and share tab.
     */
    class TabClickHandler implements ClickHandler{
        int index;
        Anchor selectedTab;
        TabClickHandler(int index,Anchor selectedTab){
            this.index=index;
            this.selectedTab=selectedTab;
        }
        @Override
        public void onClick(ClickEvent event) {
            resetHilightStyles();
            selectedTab.setStyleName(ACTIVE);
            getUiHandlers().setTabItems(index, currentTypeView,folderObj);
        }
    }
    @Override
    public void resetHilightStyles(){
        lnkInfo.removeStyleName(ACTIVE);
        lnkContent.removeStyleName(ACTIVE);
        lnkshare.removeStyleName(ACTIVE);
    }
    @Override
    public void setInSlot(Object slot, Widget content) {
        pnlSlotInnerContent.clear();
        if(content!=null){
          if(slot==MyCollectionsRightClusterPresenter.INNER_SLOT){
                pnlSlotInnerContent.add(content);
            }
        }
    }
    @Override
    public void setBreadCrumbSlot(FolderDo folderObj, String type, HashMap<String, String> selectedWidgetsTitleType){
        this.folderObj=folderObj;
        if(folderObj!=null && folderObj.getUrl() != null)
        {
            AppClientFactory.getInjector().getHomeService().getLTIAssessmentUrl(folderObj.getUrl(), folderObj.getGooruOid(), new SimpleAsyncCallback<String>() {

                @Override
                public void onSuccess(String result) {
                    LTI_URL= result;
                }
            });
        }
    }


    /**
     * Used to set the Bread crumbs.
     * @param title
     * @param type
     */
    public void setBreadCrumbs(String title, String type) {
        getUiHandlers().setViewTitleWthicon(title,type);
    }

    /**
     * gets the current bread crumbs item and updates the title.
     * @param title {@link String}
     * @param type {@link String}
     * @param index {@link int}
     */
    public void getBreadCrumbs(String title,String type,int index){
        Iterator<Widget> breadCrumbswidgets = pnlBreadCrumbMain.iterator();
        while(breadCrumbswidgets.hasNext()){
            Widget widget = breadCrumbswidgets.next();
            if(widget instanceof BreadcrumbItem && ((BreadcrumbItem) widget).getType().equalsIgnoreCase(type)){
                BreadcrumbItem breadCrumbItem=(BreadcrumbItem)widget;
                breadCrumbItem.getLabel().setText(title);
                removeBreadCrumbs(index);
            }
        }
    }

    /**
     * Removes the the bread crumbs.
     * @param index
     */
    private void removeBreadCrumbs(int index) {
        int widgetCount=pnlBreadCrumbMain.getWidgetCount();
        for(int i=index;i<widgetCount;){
            BreadcrumbItem breadCrumbItem=(BreadcrumbItem)pnlBreadCrumbMain.getWidget(i);
            breadCrumbItem.removeFromParent();
            widgetCount=pnlBreadCrumbMain.getWidgetCount();
        }
    }


    @Override
    public void setDefaultActiveTab(int tabIndex){
        resetHilightStyles();
        if(tabIndex==2){
            lnkContent.addStyleName(ACTIVE);
        }else if(tabIndex==3){
            lnkshare.addStyleName(ACTIVE);
        }else{
            lnkInfo.addStyleName(ACTIVE);
        }

    }
    /**
     * This inner class is used to generate breadcum item widget
     */
    class BreadcrumbItem extends Composite {
         Label lblTitle;
         private String type;
         public BreadcrumbItem(String title,String type,String imageStyle) {
             this.type = type;
             HTMLPanel panel=new HTMLPanel("");
             panel.setStyleName("active");
             InlineLabel spnIcon=new InlineLabel();
             spnIcon.setStyleName(imageStyle);
             lblTitle=new Label(title);
             lblTitle.setStyleName("breadCrumbTitle");
             panel.add(spnIcon);
             panel.add(lblTitle);
             initWidget(panel);
         }
         public Label getLabel(){
             return  lblTitle;
         }

         public String getType(){
             return  type;
         }
    }

    public void setRequestParams(){
        o1=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
        o2=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
        o3=AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL,null);
        if(oldO1Value==null){
            oldO1Value=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
        }
        if(oldO2Value==null){
            oldO2Value=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
        }
        if(oldO3Value==null){
            oldO3Value=AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL,null);
        }
    }
    @Override
    public void setCurrentTypeView(String currentTypeView,String o1Course) {
        this.currentTypeView =currentTypeView;
//		enableAndHideTabs(true);
//		enableOrHidePreviewBtn();
//		enableOrHideShareTab();
        enableTabItems(o1Course);
        enableActionButtons();
    }
    private void enableActionButtons(){
    	String view = AppClientFactory.getPlaceManager().getRequestParameter("view", null);
    	if (currentTypeView == null) {
    		myCollDelLbl.setVisible(false);
	    	moveLbl.setVisible(false);
	    	copyLbl.setVisible(false);
	    	lnkPreview.setVisible(false);
	    	lnkPublish.setVisible(false);
	    	lnkshare.setText(i18n.GL0536());
	        lnkContent.setVisible(true);
    	}else{
	    	myCollDelLbl.setVisible(true);
	    	copyLbl.setVisible(true);
	    	 lnkContent.setVisible(true);
	        if (COURSE.equalsIgnoreCase(currentTypeView)){
	        	lnkPreview.setVisible(false);
		    	lnkPublish.setVisible(false);
		    	lnkshare.setText(i18n.GL3602());
	        	moveLbl.setVisible(false);
	        	lnkPreview.getElement().getStyle().clearFloat();
	        }else if (UNIT.equalsIgnoreCase(currentTypeView) || LESSON.equalsIgnoreCase(currentTypeView)){
	        	lnkPreview.setVisible(false);
	        	lnkPublish.setVisible(false);
	        	lnkshare.setText(i18n.GL0536());
	        	moveLbl.setVisible(true);
	        	lnkPreview.getElement().getStyle().clearFloat();
	        }else if (ASSESSMENT_URL.equalsIgnoreCase(currentTypeView)){
	        	moveLbl.setVisible(true);
	        	lnkPreview.setVisible(true);
	        	   lnkshare.setText(i18n.GL0536());
	        	   lnkshare.setVisible(false);
		        	if(view==null || view.equalsIgnoreCase("course"))
	                {
		        	lnkPublish.setVisible(true);
		            }
		        	else
		        	{
		        	lnkPublish.setVisible(false);
		        	}
	            lnkContent.setVisible(false);
	            
	        	lnkPreview.getElement().getStyle().setFloat(Float.RIGHT);
	        }else if (COLLECTION.equalsIgnoreCase(currentTypeView) || ASSESSMENT.equalsIgnoreCase(currentTypeView)){
	        	moveLbl.setVisible(true);
	        	lnkPreview.setVisible(true);
	        	lnkshare.setText(i18n.GL0536());
	        	lnkPreview.getElement().getStyle().clearFloat();
	        	if(view==null || view.equalsIgnoreCase("course"))
                {
	        	lnkPublish.setVisible(true);
	            }
	        	else
	        	{
	        	lnkPublish.setVisible(false);
	        	}
	        }
	        else if(FOLDER.equalsIgnoreCase(currentTypeView))
	        {
	        	lnkPreview.setVisible(false);
		    	lnkPublish.setVisible(false);
		    	lnkshare.setText(i18n.GL0536());
		    	lnkshare.setVisible(false);
	        	moveLbl.setVisible(false);
	        	copyLbl.setVisible(false);
	        	lnkPreview.getElement().getStyle().clearFloat();
	        }
    	}
    }

    private void enableTabItems(String o1Course) {
    	String view = AppClientFactory.getPlaceManager().getRequestParameter("view", null);
    	if((o1Course!=null && !o1Course.isEmpty()) && (view==null || view.equalsIgnoreCase("course")))
    	{
    	  	AppClientFactory.getInjector().getfolderService().getClassesAssociatedWithCourse(o1Course, new SimpleAsyncCallback<Integer>() {
			@Override
			public void onSuccess(Integer result) {
				if(result>0){
					 lnkPublish.setStyleName("disabled");
			        lnkPublish.getElement().getStyle().setColor("#1076bb");
			        
			        if(handlerRegistration!=null){
			        	 handlerRegistration = lnkPublish.addClickHandler(new PublishClickHandler());
					}
			        handlerRegistrationHover = lnkPublish.addMouseOverHandler(new MouseOverHandler() {
						@Override
						public void onMouseOver(MouseOverEvent event) {
							tootltipContainer.setVisible(false);
						}
					});
			        
				}else{
				     lnkPublish.getElement().getStyle().setColor("#ddd");
				     lnkPublish.removeStyleName("disabled");
				     if(handlerRegistration!=null){
							handlerRegistration.removeHandler();
						}
				     handlerRegistrationHover = lnkPublish.addMouseOverHandler(new MouseOverHandler() {
							@Override
							public void onMouseOver(MouseOverEvent event) {
								tootltipContainer.setVisible(true);
							}
						});
				     lnkPublish.addMouseOutHandler(new MouseOutHandler() {
							@Override
							public void onMouseOut(MouseOutEvent event) {
								tootltipContainer.setVisible(false);
							}
						});
				    	MouseOutHandler mouseOutHandler=new MouseOutHandler() {
							@Override
							public void onMouseOut(MouseOutEvent event) {
								tootltipContainer.setVisible(false);
							}
						};
						tootltipContainer.addDomHandler(mouseOutHandler, MouseOutEvent.getType());
						MouseOverHandler mouseOverHandler=new MouseOverHandler() {
							@Override
							public void onMouseOver(MouseOverEvent event) {
								tootltipContainer.setVisible(true);
								
							}
						};
						tootltipContainer.addDomHandler(mouseOverHandler, MouseOverEvent.getType());
				    
				     
				     
				}
			}
		});
    	}
    	else
    	{
    		lnkPublish.setVisible(false);
    	}
    	if(COURSE.equalsIgnoreCase(currentTypeView))
    	{
    		lnkshare.setText(i18n.GL3602());
    	}
    	else
    	{
    		lnkshare.setText(i18n.GL0536());
    	}
        if (COURSE.equalsIgnoreCase(currentTypeView) || COLLECTION.equalsIgnoreCase(currentTypeView) || ASSESSMENT.equalsIgnoreCase(currentTypeView)){
            lnkInfo.setVisible(true);
            lnkContent.setVisible(true);
            lnkshare.setVisible(true);
        }else if (UNIT.equalsIgnoreCase(currentTypeView) || LESSON.equalsIgnoreCase(currentTypeView)){
            lnkInfo.setVisible(true);
            lnkContent.setVisible(true);
            lnkshare.setVisible(false);
        }else if (ASSESSMENT_URL.equalsIgnoreCase(currentTypeView)){
            lnkInfo.setVisible(true);
            lnkContent.setVisible(false);
            lnkshare.setVisible(false);
        }
        else if(FOLDER.equalsIgnoreCase(currentTypeView))
        {
        	lnkPreview.setVisible(false);
	    	lnkPublish.setVisible(false);
	    	lnkshare.setText(i18n.GL0536());
	    	lnkshare.setVisible(false);
        	moveLbl.setVisible(false);
        	copyLbl.setVisible(false);
        	lnkPreview.getElement().getStyle().clearFloat();
        }
    }
    public void onpublishHover(MouseOverEvent event)
    {

/*    		toolTipPopupPanel.clear();
			toolTipPopupPanel.setWidget(new GlobalToolTip("text sample data"));
			toolTipPopupPanel.setStyleName("");
			toolTipPopupPanel.setPopupPosition(publishContainer.getElement().getAbsoluteLeft()+18, publishContainer.getElement().getAbsoluteTop()+10);
			toolTipPopupPanel.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanel.show();*/

    	tootltipContainer.setVisible(true);


    }
    /**
     * To enable and disable the share tab based on type.
     */
    private void enableOrHideShareTab() {
        if(COURSE.equalsIgnoreCase(currentTypeView)||UNIT.equalsIgnoreCase(currentTypeView)|| LESSON.equalsIgnoreCase(currentTypeView) || FOLDER.equalsIgnoreCase(currentTypeView)){
            lnkshare.setVisible(false);
            moveLbl.setVisible(false);
            copyLbl.setVisible(false);
            myCollDelLbl.setVisible(false);
            lnkshare.setText(i18n.GL0536());
        }else{
            lnkshare.setVisible(true);
            lnkshare.setText(i18n.GL3602());
            copyLbl.setVisible(true);
            myCollDelLbl.setVisible(true);
        }
    }
    /**
     * Hiding preview button when type is course/unit/lesson/folder
     */
    private void enableOrHidePreviewBtn() {
     	String view = AppClientFactory.getPlaceManager().getRequestParameter("view", null);
        if(currentTypeView!=null){
            if(COLLECTION.equalsIgnoreCase(currentTypeView)|| currentTypeView.contains(ASSESSMENT)){
                lnkPreview.setVisible(true);
                if(view==null || view.equalsIgnoreCase("course"))
                {
                lnkPublish.setVisible(true);
                }
                else
                {
                lnkPublish.setVisible(false);
                }
                moveLbl.setVisible(true);
//				deletePnl.setVisible(false);
                copyLbl.setVisible(true);
                myCollDelLbl.setVisible(false);
                disableCollabaratorOptions(isCollaborator);
            }else{
                lnkPreview.setVisible(false);
                lnkPublish.setVisible(false);
                lnkshare.setText(i18n.GL0536());
                boolean isVisible=(FOLDER.equalsIgnoreCase(currentTypeView))?false:true;
                copyLbl.setVisible(isVisible);
                moveLbl.setVisible(false);
                myCollDelLbl.setVisible(true);
//				deletePnl.setVisible(false);
            }
        }else{
            lnkPreview.setVisible(false);
            lnkPublish.setVisible(false);
            moveLbl.setVisible(false);
            copyLbl.setVisible(false);
            myCollDelLbl.setVisible(false);

        }
    }
    @Override
    public void enableAndHideTabs(boolean isVisible){
    	String view = AppClientFactory.getPlaceManager().getRequestParameter("view", null);
        lnkContent.setVisible(isVisible);
        if(COURSE.equalsIgnoreCase(currentTypeView))
        {
        	lnkshare.setText(i18n.GL3602());
        }
        else
        {
        	lnkshare.setText(i18n.GL0536());
        }
        if(COURSE.equalsIgnoreCase(currentTypeView) || COLLECTION.equalsIgnoreCase(currentTypeView)|| currentTypeView.contains(ASSESSMENT)){
            lnkshare.setVisible(isVisible);
        }

        if(COURSE.equalsIgnoreCase(currentTypeView) || UNIT.equalsIgnoreCase(currentTypeView) || LESSON.equalsIgnoreCase(currentTypeView)){
            moveLbl.setVisible(false);
        }else if(FOLDER.equalsIgnoreCase(currentTypeView)){
        	   moveLbl.setVisible(false);
        }
        else{
        	moveLbl.setVisible(isVisible);
        }
        if(ASSESSMENT_URL.equalsIgnoreCase(currentTypeView) || COLLECTION.equalsIgnoreCase(currentTypeView)|| currentTypeView.contains(ASSESSMENT)){
            lnkPreview.setVisible(isVisible);
            if(view==null || view.equalsIgnoreCase("course"))
            {
            	if(ASSESSMENT_URL.equalsIgnoreCase(currentTypeView))
            	{
            		 lnkPublish.setVisible(isVisible);
            		  lnkshare.setVisible(false);
            		  lnkContent.setVisible(false);
            	}
            	else
            	{
            		 lnkPublish.setVisible(isVisible);
            	}
            }
            else
            {
        	if(ASSESSMENT_URL.equalsIgnoreCase(currentTypeView))
        	{
        		  lnkshare.setVisible(false);
        		  lnkContent.setVisible(false);
        	}
            lnkPublish.setVisible(false);	
            }
        }

        if(FOLDER.equalsIgnoreCase(currentTypeView)){
        	copyLbl.setVisible(false);
        }
        else
        {
            copyLbl.setVisible(isVisible);	
        }
   
        myCollDelLbl.setVisible(isVisible);
    }
    /**
     *
     * This inner class is used to delete the user content like C/U/L and Collection.
     *
     */
    private class DeleteContent implements ClickHandler{
        DeleteContent(){
        }
        @Override
        public void onClick(ClickEvent event) {
            initiateDelete();
        }
    }

    private class DeleteContentData implements ClickHandler{
        @Override
        public void onClick(ClickEvent event) {
            /*copyLbl.getElement().removeClassName("selected");
            moveLbl.getElement().removeClassName("selected");
            myCollDelLbl.getElement().addClassName("selected");*/
            initiateDelete();

        }

    }


    /**
     * This inner class is used to Open the respective collection/Assessment player
     *  when click on preview.
     *
     */
    private class PreviewClickHandler implements ClickHandler{
        @Override
        public void onClick(ClickEvent event) {
            String placeToken,folderId;
            if(AppClientFactory.getPlaceManager().getRequestParameter("o3")!=null){
                folderId=AppClientFactory.getPlaceManager().getRequestParameter("o3");
            }else if(AppClientFactory.getPlaceManager().getRequestParameter("o2")!=null){
                folderId=AppClientFactory.getPlaceManager().getRequestParameter("o2");
            }else if(AppClientFactory.getPlaceManager().getRequestParameter("o1")!=null){
                folderId=AppClientFactory.getPlaceManager().getRequestParameter("o1");
            }else{
                folderId="";
            }
            String type = folderObj==null?null:StringUtil.isEmpty(folderObj.getType())?null:folderObj.getType();
            HashMap<String,String> params = new HashMap<String,String>();
            params.put("id", folderObj.getGooruOid());
            if(!folderId.isEmpty()){
                params.put("folderId", folderId);
            }
            if(type!=null){
                placeToken=COLLECTION.equalsIgnoreCase(type)?PlaceTokens.COLLECTION_PLAY:ASSESSMENT.equalsIgnoreCase(type)?PlaceTokens.ASSESSMENT_PLAY:"";
                if(!placeToken.isEmpty()){
                    PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(placeToken, params);
                    AppClientFactory.getPlaceManager().revealPlace(false,placeRequest,true);
                }else{
                    if(!folderObj.getUrl().isEmpty() && !folderObj.getUrl().equalsIgnoreCase(PASTEURL)){
                        if(folderObj.getUrl().contains(LTI)){
                            Window.open(LTI_URL, "", "");
                        }else{
                            Window.open(folderObj.getUrl(), "", "");
                        }

                    }
                }
            }
        }
    }
    
    /**
     * This inner class is used to Open the respective collection/Assessment player
     *  when click on preview.
     *
     */
    private class PublishClickHandler implements ClickHandler{
        @Override
        public void onClick(ClickEvent event) {
        	if(addtoClassPopup==null)
        	{
        	final String o1CourseId = AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
        	final String o2UnitId = AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
        	final String o3LessonId = AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL,null);
        	final String assessmentCollectionId = AppClientFactory.getPlaceManager().getRequestParameter("id",null);
            String view = AppClientFactory.getPlaceManager().getRequestParameter("view",null);
            if(view==null || view.equalsIgnoreCase("course"))
        	if(lnkPublish.getStyleName().contains("disabled"))
        	{
        		addtoClassPopup = new AddCollectionToClassView(o1CourseId,o2UnitId,o3LessonId,assessmentCollectionId) {
    				@Override
    				public void onClickPositiveButton(ClickEvent event) {
    					if(addtoClassPopup.getClassId().size()==0) {
    						addtoClassPopup.getErrorLabel().setVisible(true);
    					} else {
    						addtoClassPopup.getErrorLabel().setVisible(false);    					
    						getUiHandlers().updateContentVisibilityData(o1CourseId,o2UnitId,o3LessonId,assessmentCollectionId,addtoClassPopup.getClassId());
    				
    					}
    				}
    			};
    			addtoClassPopup.getCancelResourcePopupBtnLbl().addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						closePublishPopup();
						
					}
				});
    			addtoClassPopup.getElement().getStyle().setZIndex(9999999);
    			addtoClassPopup.show();
    			addtoClassPopup.center();
        	}
        }
        }
    }
    
	@Override
	public void closePublishPopup() {
		Window.enableScrolling(true);
		if(addtoClassPopup!=null){
			addtoClassPopup.hide();
			addtoClassPopup = null;
	
		}
	}


    /**
     * Invokes the delete course popup.
     *
     * @param currentTypeView {@link String}
     * @param o1CourseId {@link String}
     * @param o2UnitId {@link String}
     * @param o3LessonId {@link String}
     * @param assessmentCollectionId
     * @param deletePopup {@link DeletePopupViewVc}
     */
    public void invokeDeletePopup(final String currentTypeView,final String o1CourseId,final String o2UnitId,final String o3LessonId, final String assessmentCollectionId) {

        deleteContentPopup = new DeleteContentPopup() {

            @Override
            public void onClickPositiveButton(ClickEvent event) {
                if(!StringUtil.isEmpty(o2UnitId) && UNIT.equalsIgnoreCase(currentTypeView)){
                    getUiHandlers().deleteUnitContent(o1CourseId,o2UnitId);
                }else if(!StringUtil.isEmpty(o1CourseId) && COURSE.equalsIgnoreCase(currentTypeView)){
                    getUiHandlers().deleteCourseContent(o1CourseId);
                }else if(!StringUtil.isEmpty(o3LessonId) && LESSON.equalsIgnoreCase(currentTypeView)){
                    getUiHandlers().deleteLessonContent(o1CourseId,o2UnitId,o3LessonId);
                }else if("Folder".equalsIgnoreCase(AppClientFactory.getPlaceManager().getRequestParameter("view",null))){
                    if((AppClientFactory.getPlaceManager().getRequestParameter("id",null)!=null)){
                        getUiHandlers().deleteMyCollectionContent((AppClientFactory.getPlaceManager().getRequestParameter("id",null)),"folderCollection");
                    }else{
                        if(AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL)!=null){
                            String parentId = AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL);
                            getUiHandlers().deleteMyCollectionContent(parentId,LESSON);
                        } else if(AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL)!=null){
                            String parentId = AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL);
                            getUiHandlers().deleteMyCollectionContent(parentId,UNIT);
                        } else {
                            String parentId = AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL);
                            getUiHandlers().deleteMyCollectionContent(parentId,COURSE);
                        }
                    }
                }else{
                    getUiHandlers().deleteCollectionContent(o1CourseId,o2UnitId,o3LessonId,assessmentCollectionId);
                }
            }

            @Override
            public void onClickNegitiveButton(ClickEvent event) {
                hide();
                Window.enableScrolling(true);
            }
        };
        deleteContentPopup.getElement().getStyle().setZIndex(9999999);
        deleteContentPopup.setPopupTitle(i18n.GL0748());
        String title=folderObj.getTitle().trim();
        if(title.length()>50){
            title=title.substring(0, 50)+"...";
        }
        deleteContentPopup.setNotes(StringUtil.generateMessage(i18n.GL3456(),title));
        deleteContentPopup.setDeleteValidate("delete");
        deleteContentPopup.setPositiveButtonText("Delete Forever");
        deleteContentPopup.setNegitiveButtonText(i18n.GL0142());
        deleteContentPopup.setPleaseWaitText(i18n.GL0339());
        deleteContentPopup.show();
        deleteContentPopup.center();
    }


    /**
     * This method defines functionality after deleting the course.
     */
    @Override
    public void onDeleteCourseSuccess(String o1CourseId) {
        hideDeletePopup();
        Map<String, String> params= new HashMap<String, String>();
        if("Folder".equalsIgnoreCase(AppClientFactory.getPlaceManager().getRequestParameter("view", null))){
            params.put("view", "Folder");
            getUiHandlers().setRightClusterContent(o1CourseId,COURSE);
            AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);
        }else{
            params.put("view", COURSE);
            getUiHandlers().setRightClusterContent(o1CourseId,currentTypeView);
            AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);
        }

    }


    /**
     * On deleting the Unit, reveals the my content and loads the respective right cluster.
     */

    @Override
    public void onDeleteUnitSuccess(String o1CourseId, String o2DeletedUnitId) {
        hideDeletePopup();
        Map<String, String> params= new HashMap<String, String>();
        if("Folder".equalsIgnoreCase(AppClientFactory.getPlaceManager().getRequestParameter("view", null))){
            params.put("view", "Folder");
            params.put(O1_LEVEL, AppClientFactory.getPlaceManager().getRequestParameter("o1",null));
            getUiHandlers().setUnitsListOnRightCluster(o1CourseId,o2DeletedUnitId,UNIT);
            AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);

        }else{
            params.put("view", COURSE);
            params.put(O1_LEVEL, o1CourseId);
            getUiHandlers().setUnitsListOnRightCluster(o1CourseId,o2DeletedUnitId,currentTypeView);
            AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);
        }
    }

    private void hideDeletePopup() {
        if(deleteContentPopup!=null){
            deleteContentPopup.hide();
        }
        if(deletePopup !=null && deletePopup.isShowing()){
            deletePopup.hide();
        }
        Window.enableScrolling(true);
    }
    private class onCopyClickHandler implements ClickHandler{
        @Override
        public void onClick(ClickEvent event) {
        	Window.enableScrolling(false);
            if(!(COURSE.equalsIgnoreCase(currentTypeView))){
                getUiHandlers().disableCopyPopupTabs((LESSON.equalsIgnoreCase(currentTypeView)||UNIT.equalsIgnoreCase(currentTypeView))?false:true,currentTypeView);
                getUiHandlers().EnableMyCollectionsTreeData(folderObj.getGooruOid(),folderObj.getTitle());
                isCopySelected= true;
                isMoveSelected=false;
                lnkshare.setText(i18n.GL0536());
                getUiHandlers().checkCopyOrMoveStatus(isCopySelected,isMoveSelected,folderObj.getType());
                getUiHandlers().enableAddButton();

            }else if((COURSE.equalsIgnoreCase(currentTypeView))){
    			Element element = Document.get().getDocumentElement();
    			element.appendChild(glassPanelDiv.getElement());
            	lnkshare.setText(i18n.GL3602());
                getUiHandlers().copyCourse(folderObj.getGooruOid());
            }
        	Window.enableScrolling(false);
        }
    }

    private class onMoveClickHandler implements ClickHandler{
        @Override
        public void onClick(ClickEvent event) {
        	Window.enableScrolling(false);
            isCopySelected= false;
            isMoveSelected= true;
            getUiHandlers().enableAddButton();
            getUiHandlers().checkCopyOrMoveStatus(isCopySelected,isMoveSelected,folderObj.getType());
            String NameTokenValue= AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
            if(NameTokenValue.equalsIgnoreCase(PlaceTokens.MYCONTENT)){
                String viewParamVal= AppClientFactory.getPlaceManager().getRequestParameter("view",null);

                if(viewParamVal!=null && viewParamVal.equalsIgnoreCase("folder")){
                    getUiHandlers().EnableMyCollectionsTreeData(folderObj.getGooruOid(),folderObj.getTitle());
                }else{
                    getUiHandlers().DisableMyCollectionsTreeData(folderObj.getGooruOid(),folderObj.getTitle());
                }
            }

        }

    }

    @Override
    public void setOnDeleteBreadCrumbs(String title, String type) {
        setBreadCrumbs(title,type);
    }

    /**
     * On deleting the lesson, reveals the my content and loads the respective right cluster.
     */
    @Override
    public void onDeleteLessonSuccess(String o1CourseId, String o2UnitId,String o3LessDeletedonId) {
        hideDeletePopup();
        Map<String, String> params= new HashMap<String, String>();
        if("Folder".equalsIgnoreCase(AppClientFactory.getPlaceManager().getRequestParameter("view", null))){
            params.put("view", COURSE);
            params.put(O1_LEVEL, AppClientFactory.getPlaceManager().getRequestParameter("o1",null));
            params.put(O2_LEVEL, AppClientFactory.getPlaceManager().getRequestParameter("o2",null));
            getUiHandlers().setLessonsListOnRightCluster(o1CourseId,o2UnitId,o3LessDeletedonId,LESSON);
            AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);
        }else{
            params.put("view", COURSE);
            params.put(O1_LEVEL, o1CourseId);
            params.put(O2_LEVEL, o2UnitId);
            getUiHandlers().setLessonsListOnRightCluster(o1CourseId,o2UnitId,o3LessDeletedonId,currentTypeView);
            AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);
        }
    }


    /**
     * On deleting the collection/assessment, reveals the my content and loads the respective right cluster.
     */
    @Override
    public void onDeleteCollectionAssessmentSuccess(String o1CourseId,String o2UnitId, String o3LessonId, String deletedAssessmentCollectionId) {
        hideDeletePopup();
        if("Folder".equalsIgnoreCase(AppClientFactory.getPlaceManager().getRequestParameter("view", null))){
        	lnkshare.setText(i18n.GL0536());
            Map<String, String> params = new HashMap<String, String>();
            if(AppClientFactory.getPlaceManager().getRequestParameter("o3")!=null){
                params.put("view", "Folder");
                params.put("o1",AppClientFactory.getPlaceManager().getRequestParameter("o1"));
                params.put("o2",AppClientFactory.getPlaceManager().getRequestParameter("o2"));
                params.put("o3",AppClientFactory.getPlaceManager().getRequestParameter("o3"));
                getUiHandlers().setCollectionsListOnRightCluster(o1CourseId,o2UnitId,o3LessonId,deletedAssessmentCollectionId,COLLECTION);
                AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);
            }else if(AppClientFactory.getPlaceManager().getRequestParameter("o2")!=null){
                params.put("view", "Folder");
                params.put("o1",AppClientFactory.getPlaceManager().getRequestParameter("o1"));
                params.put("o2",AppClientFactory.getPlaceManager().getRequestParameter("o2"));
                getUiHandlers().setLessonsListOnRightCluster(o1CourseId,o2UnitId,deletedAssessmentCollectionId,LESSON);
                AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);
            }else if(AppClientFactory.getPlaceManager().getRequestParameter("o1")!=null){
                params.put("view", "Folder");
                params.put("o1",AppClientFactory.getPlaceManager().getRequestParameter("o1"));
                getUiHandlers().setUnitsListOnRightCluster(o1CourseId,deletedAssessmentCollectionId,UNIT);
                AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);
            }else{
                params.put("view", "Folder");
                getUiHandlers().setRightClusterContent(o1CourseId,COURSE);
//				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);
            }
        }else{
            Map<String, String> params= new HashMap<String, String>();
            params.put("view", COURSE);
            params.put(O1_LEVEL, o1CourseId);
            params.put(O2_LEVEL, o2UnitId);
            params.put(O3_LEVEL, o3LessonId);
            lnkshare.setText(i18n.GL3602());
            getUiHandlers().setCollectionsListOnRightCluster(o1CourseId,o2UnitId,o3LessonId,deletedAssessmentCollectionId,currentTypeView);
            AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT,params);
        }
    }

    /**
     * Invokes the delete functionality if the course is not associated with class.
     */
    @Override
    public void invokeContentDeletePopup(String o1CourseId, String o2UnitId,String o3LessonId,String assessmentCollectionId,ArrayList<ClasspageDo> classesList) {
        this.classesList = classesList;
        if(classesList.size()>0){
            invokeMyCollDeletePopUp(currentTypeView,o1CourseId, o2UnitId, o3LessonId,assessmentCollectionId,true);
        }else{
            invokeMyCollDeletePopUp(currentTypeView,o1CourseId, o2UnitId, o3LessonId,assessmentCollectionId,false);
        }
    }
    /**
     * This method is used to hide the bread cums panel
     */
    @Override
    public void disableAndEnableBreadCums(boolean isVisible){
        pnlBreadCrumbMain.setVisible(isVisible);
    }
    @Override
    public void setFolderInfoWidget(FolderDo folderObj,MyCollectionsRightClusterPresenter rightPresenter) {
        FolderInfoWidget folderInfoWidget = new FolderInfoWidget();
        pnlSlotInnerContent.add(folderInfoWidget);
        folderInfoWidget.setData(folderObj,rightPresenter);
    }

    public void initiateDelete() {
        String o1CourseId = AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
        String o2UnitId = AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
        String o3LessonId = AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL,null);
        String assessmentCollectionId = AppClientFactory.getPlaceManager().getRequestParameter("id",null);
        String view = AppClientFactory.getPlaceManager().getRequestParameter("view",null);
        if(currentTypeView.equalsIgnoreCase(COLLECTION) || currentTypeView.contains(ASSESSMENT)){
            if(FOLDER.equalsIgnoreCase(view)){
                invokeMyCollDeletePopUp(currentTypeView,o1CourseId, o2UnitId, o3LessonId,assessmentCollectionId,false);
            }else{
                getUiHandlers().isAssignedToClassPage(currentTypeView,o1CourseId,o2UnitId,o3LessonId,assessmentCollectionId);
            }
        }else{
            if(COURSE.equalsIgnoreCase(currentTypeView)){
            	lnkshare.setText(i18n.GL3602());
                getUiHandlers().isStudentDataAvailable(currentTypeView,o1CourseId,o2UnitId, o3LessonId,assessmentCollectionId);
            }else{
            	lnkshare.setText(i18n.GL0536());
                invokeDeletePopup(currentTypeView,o1CourseId, o2UnitId, o3LessonId,assessmentCollectionId);
            }
        }
    }


    /**
     * This method invokes for Collection/assessment delete at my collections/ my content.
     * @param currentTypeView
     * @param o1CourseId
     * @param o2UnitId
     * @param o3LessonId
     * @param assessmentCollectionId
     * @param isTiedWithClasses
     * 
     */
    private void invokeMyCollDeletePopUp(String currentTypeView, final String o1CourseId, final String o2UnitId, final String o3LessonId, final String assessmentCollectionId, boolean isTiedWithClasses) {
        deletePopup = new DeletePopupViewVc() {

            @Override
            public void onClickPositiveButton(ClickEvent event) {
                if("Folder".equalsIgnoreCase(AppClientFactory.getPlaceManager().getRequestParameter("view",null))){
                    getUiHandlers().deleteMyCollectionColl((AppClientFactory.getPlaceManager().getRequestParameter("id",null)));
                }else{
                    getUiHandlers().deleteCollectionContent(o1CourseId,o2UnitId,o3LessonId,assessmentCollectionId);
                }
            }

            @Override
            public void onClickNegitiveButton(ClickEvent event) {
                hide();
                Window.enableScrolling(true);
            }
        };

        deletePopup.setPopupTitle(i18n.GL0748());
        if(isTiedWithClasses && (currentTypeView.equalsIgnoreCase(COLLECTION) || currentTypeView.equalsIgnoreCase(ASSESSMENT))){
            StringBuffer sb = new StringBuffer();
            String anchString = "<a href=\"{0}\" target=\"_blank\">{1}</a>";
            String classpageUrl = "#newteach&c-id={0}&report-type=course-view&classpageId={1}&subpage-view=reports&page-view=teach-dashboard";
            int count = classesList.size();
            for (int i=0; i<count;i++){
                String url = StringUtil.generateMessage(classpageUrl,o1CourseId, classesList.get(i).getClassUid());
                if (count==1){
                    sb.append(StringUtil.generateMessage(anchString, url,classesList.get(i).getName()));
                }else{
                    if (i == (count-1)){
                        sb.append(i18n.GL_GRR_AND()+" "+StringUtil.generateMessage(anchString, url,classesList.get(i).getName()));
                    }else{
                        sb.append(StringUtil.generateMessage(anchString, url,classesList.get(i).getName()) + ", ");
                    }
                }
            }

            String remaining = count==1?(" "+i18n.GL1155()):(" "+i18n.GL1154()+i18n.GL_SPL_EXCLAMATION());
            if(currentTypeView.contains(ASSESSMENT)){
                deletePopup.setNotes("This assessment is currently being used in your"+" "+sb.toString()+" "+remaining);
                deletePopup.setDescText(i18n.GL3039());
            }else{
                deletePopup.setNotes(i18n.GL1156()+" "+sb.toString()+" "+remaining);
                deletePopup.setDescText(i18n.GL1238());
            }

        }else{
            if(currentTypeView.contains(ASSESSMENT)){
                deletePopup.setNotes(StringUtil.generateMessage(i18n.GL3038(), folderObj.getTitle().trim()));
                deletePopup.setDescText(i18n.GL3039());
            }else{
                deletePopup.setNotes(StringUtil.generateMessage(i18n.GL1020(), folderObj.getTitle().trim()));
                deletePopup.setDescText(i18n.GL1238());
            }
        }
        deletePopup.setDeleteValidate("delete");
        deletePopup.setPositiveButtonText(i18n.GL0190());
        deletePopup.setNegitiveButtonText(i18n.GL0142());
        deletePopup.setPleaseWaitText(i18n.GL0339());
        deletePopup.show();
        deletePopup.center();
    }


    /*public void hideDropDown(NativePreviewEvent event){
        if(event.getTypeInt()==Event.ONCLICK){
            Event nativeEvent = Event.as(event.getNativeEvent());
            boolean target=eventTargetsPopup(nativeEvent);
            if(!target){
                copyPopupPanel.setVisible(false);
            }
        }
     }
    private boolean eventTargetsPopup(NativeEvent event) {
        EventTarget target = event.getEventTarget();
        if (Element.is(target)) {
            return copyPopupPanel.getElement().isOrHasChild(Element.as(target))||copyPopupPanel.getElement().isOrHasChild(Element.as(target));
        }
        return false;
    }*/


    public void removeActiveStyle() {
        copyLbl.getElement().removeClassName("selected");
        moveLbl.getElement().removeClassName("selected");
        myCollDelLbl.getElement().removeClassName("selected");
    }

    @Override
    public void disableCollabaratorOptions(boolean hide){
        hide = ASSESSMENT_URL.equalsIgnoreCase(currentTypeView)?true:hide;
        if(COURSE.equalsIgnoreCase(currentTypeView) || UNIT.equalsIgnoreCase(currentTypeView) || LESSON.equalsIgnoreCase(currentTypeView)){
            moveLbl.setVisible(false);
        }else{
            moveLbl.setVisible(hide);
        }
        myCollDelLbl.setVisible(hide);
    }
    @Override
    public void setIsCollaboratorValue(boolean isHide) {
        this.isCollaborator=isHide;
    }
    public void disableButtons(boolean isTrue){
        //toggleButton.setVisible(isTrue);
    	String view = AppClientFactory.getPlaceManager().getRequestParameter("view", null);
        lnkPreview.setVisible(isTrue);
        if(view==null || view.equalsIgnoreCase("course"))
        {
        lnkPublish.setVisible(isTrue);
        }
        else
        {
        lnkPublish.setVisible(false);	
        }
    }


    @Override
    public void isCourseDeleteStatus(Boolean status, String type, String o1CourseId, String o2UnitId, String o3LessonId, String assessmentCollectionId) {
        if(!status){
            invokeDeletePopup(type,o1CourseId, o2UnitId, o3LessonId,assessmentCollectionId);
        }else{
            new AlertContentUc(i18n.GL0061(),"Sorry this Course is tied with student data, you cannot delete the course");
        }
    }
    @Override
    public void showCopyErrorMsg() {
        new AlertContentUc(i18n.GL0061(),i18n.GL3567());
    }
}
