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
package org.ednovo.gooru.client.mvp.library.partner;

import java.util.ArrayList;
import java.util.Iterator;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.library.LibraryStyleBundle;
import org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView;
import org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView;
import org.ednovo.gooru.client.mvp.home.library.LibraryView;
import org.ednovo.gooru.shared.model.content.ThumbnailDo;
import org.ednovo.gooru.shared.model.library.CourseDo;
import org.ednovo.gooru.shared.model.library.LibraryUserDo;
import org.ednovo.gooru.shared.model.library.PartnerFolderDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
` * 
 */
public class PartnerLibraryView extends BaseViewWithHandlers<PartnerLibraryUiHandlers> implements IsPartnerLibraryView, MessageProperties {

	@UiField HTMLPanel partnerPanel;
	
	LibraryView libraryView = null;
	
	private static final String FOLDERID = "id";
	
	@UiField LibraryStyleBundle libraryStyleUc;
	
	private String unitListId = "";
	
	private static final String LIBRARY_PAGE = "partner-page";

	private static PartnerLibraryViewUiBinder uiBinder = GWT.create(PartnerLibraryViewUiBinder.class);

	interface PartnerLibraryViewUiBinder extends UiBinder<Widget, PartnerLibraryView> {
	}

	/**
	 * Class constructor
	 */
	public PartnerLibraryView() {
		setWidget(uiBinder.createAndBindUi(this));
		libraryView = new LibraryView(PlaceTokens.HOME);
		partnerPanel.add(libraryView);
		partnerPanel.getElement().setId("pnlPartnerPanel");
	}

	@Override
	public void loadPartnersPage(String callBack, String placeToken) {
		libraryView.loadContributorsPage(callBack,placeToken);
	}

	@Override
	public void setUnitList(final ArrayList<PartnerFolderDo> folderList) {
		setCourseImageData();
		libraryView.getLeftNav().clear();
		libraryView.getContentScroll().clear();
		String folderId = AppClientFactory.getPlaceManager().getRequestParameter(FOLDERID);
		int j = 0;
		for(int i = 0; i<folderList.size(); i++) {
			if(folderList.get(i).getType().equalsIgnoreCase("folder")) {
				LibraryUnitMenuView libraryUnitMenuView = new LibraryUnitMenuView(folderList.get(i));
				libraryView.getLeftNav().add(libraryUnitMenuView);
				if(j==0&&folderId==null) {
					j++;
					loadingPanel(true);
					libraryUnitMenuView.addStyleName(libraryStyleUc.unitLiActive());
					unitListId = folderList.get(i).getGooruOid();
					setTopicListData(folderList.get(i).getFolderItems(), unitListId);
					//getUiHandlers().getPartnerChildFolderItems(unitListId, 1);
				}
			}
		}
		
		final Iterator<Widget> widgets = libraryView.getLeftNav().iterator();
		int widgetCount = 0;
		while (widgets.hasNext()) {
			final Widget widget = widgets.next();
			final LibraryUnitMenuView libraryUnitMenuView = ((LibraryUnitMenuView) widget);
			final int finalWidgetCount = widgetCount;
			libraryUnitMenuView.getUnitMenuItemPanel().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					libraryView.getContentScroll().setVisible(false);
					loadingPanel(true);
					final Iterator<Widget> widgetsPanel = libraryView.getLeftNav().iterator();
					while (widgetsPanel.hasNext()) {
						widgetsPanel.next().removeStyleName(libraryStyleUc.unitLiActive());
					}
					widget.addStyleName(libraryStyleUc.unitLiActive());
					unitListId = libraryUnitMenuView.getUnitId();
					if(finalWidgetCount==0) {
						setTopicListData(folderList.get(finalWidgetCount).getFolderItems(), unitListId);
					} else {
						getUiHandlers().getPartnerChildFolderItems(unitListId, 1);
					}
				}
			});
			widgetCount++;
		}
	}

	@Override
	public void setTopicListData(ArrayList<PartnerFolderDo> folderListDo, String folderId) {
		libraryView.getContentScroll().clear();
		try {
			int count = 0;
			for(int i = 0; i <folderListDo.size(); i++) {
				count++;
				libraryView.getContentScroll().add(new LibraryTopicListView(folderListDo.get(i), count, AppClientFactory.getCurrentPlaceToken()));
			}
			libraryView.getContentScroll().setVisible(true);
			loadingPanel(false);
		} catch (Exception e) {
			e.printStackTrace();
			loadingPanel(false);
		}
	}
	
	private void setCourseImageData() {
		libraryView.setCourseData(getPartnerName());
	}
	
	private CourseDo getPartnerName() {
		String partnerPlace = AppClientFactory.getCurrentPlaceToken();
		CourseDo courseDo = new CourseDo();
		ThumbnailDo thumbnailDo = new ThumbnailDo();
		LibraryUserDo libraryUserDo = new LibraryUserDo();
		
		if(partnerPlace.equals(PlaceTokens.AUTODESK)) {
			
			courseDo.setLabel("Autodesk® Digital STEAM Workshop");
			thumbnailDo.setUrl("../images/library/partners/autodesk.png");
			libraryUserDo.setPartnerName(GL1566);
			libraryUserDo.setPartnerUrl(GL1567);
			
		} else if(partnerPlace.equals(PlaceTokens.ONR)) {
			
			courseDo.setLabel("Oceanography & Space Sciences");
			thumbnailDo.setUrl("../images/library/partners/onr.png");
			libraryUserDo.setPartnerName(GL1568);
			libraryUserDo.setPartnerUrl(GL1569);
			
		} else if(partnerPlace.equals(PlaceTokens.FTE)) {
			courseDo.setLabel("Introduction to Economics & Hot Topics");
			thumbnailDo.setUrl("../images/library/partners/fte.png");
			libraryUserDo.setPartnerName(GL1570);
			libraryUserDo.setPartnerUrl(GL1571);
			
		} else if(partnerPlace.equals(PlaceTokens.NGC)) {
			
			courseDo.setLabel("NGC Global Issues");
			thumbnailDo.setUrl("../images/library/partners/ngc.png");
			libraryUserDo.setPartnerName(GL1572);
			libraryUserDo.setPartnerUrl(GL1573);

		} else if(partnerPlace.equals(PlaceTokens.WSPWH)) {
			
			courseDo.setLabel("Literary-Based Civic Education");
			thumbnailDo.setUrl("../images/library/partners/wspwh.png");
			libraryUserDo.setPartnerName(GL1574);
			libraryUserDo.setPartnerUrl(GL1575);

		} else if(partnerPlace.equals(PlaceTokens.LESSONOPOLY)) {
			
			courseDo.setLabel("Lessonopoly");
			thumbnailDo.setUrl("../images/library/partners/lessonopoly.png");
			libraryUserDo.setPartnerName(GL1576);
			libraryUserDo.setPartnerUrl(GL1577);

		} else if(partnerPlace.equals(PlaceTokens.FINCAPINC)) {
			
			courseDo.setLabel("Personal Finance");
			thumbnailDo.setUrl("../images/library/partners/cfci.png");
			libraryUserDo.setPartnerName(GL1765);
			libraryUserDo.setPartnerUrl(GL1766);

		} else if(partnerPlace.equals(PlaceTokens.PSDPAL)) {
			
			courseDo.setLabel("K-12 Arabic lessons");
			thumbnailDo.setUrl("../images/library/partners/psd.png");
			libraryUserDo.setPartnerName(GL1763);
			libraryUserDo.setPartnerUrl(GL1764);

		}
		
		courseDo.setThumbnails(thumbnailDo);
		courseDo.setCreator(libraryUserDo);
		return courseDo;
	}

	@Override
	public void loadingPanel(boolean isVisible) {
		libraryView.getContainer().getElement().getStyle().setMarginTop(-50, Unit.PX);
		libraryView.getCourseTabs().setVisible(false);
		libraryView.getLoadingIconPanel().setVisible(isVisible);
	}

	@Override
	public void clearPanels() {
		libraryView.getContentScroll().clear();
		libraryView.getLeftNav().clear();
	}
	
	
	
}
