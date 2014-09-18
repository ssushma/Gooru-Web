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
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ThumbnailDo;
import org.ednovo.gooru.shared.model.library.CourseDo;
import org.ednovo.gooru.shared.model.library.LibraryUserDo;
import org.ednovo.gooru.shared.model.library.PartnerFolderDo;

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
public class PartnerLibraryView extends BaseViewWithHandlers<PartnerLibraryUiHandlers> implements IsPartnerLibraryView{

	@UiField HTMLPanel partnerPanel;
	
	LibraryView libraryView = null;
	
	private static final String FOLDERID = "id";
	
	@UiField LibraryStyleBundle libraryStyleUc;
	
	private String unitListId = "";
	
	private static final String LIBRARY_PAGE = "partner-page";

	private static PartnerLibraryViewUiBinder uiBinder = GWT.create(PartnerLibraryViewUiBinder.class);

	interface PartnerLibraryViewUiBinder extends UiBinder<Widget, PartnerLibraryView> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	/**
	 * Class constructor
	 */
	public PartnerLibraryView() {
		setWidget(uiBinder.createAndBindUi(this));
		libraryView = new LibraryView(PlaceTokens.DISCOVER);
		partnerPanel.add(libraryView);
		partnerPanel.getElement().setId("pnlPartnerPanel");
	}

	@Override
	public void loadPartnersPage(String callBack, String placeToken) {
		libraryView.loadContributorsPage(callBack,placeToken);
	}

	@Override
	public void setUnitList(final ArrayList<PartnerFolderDo> folderList) {
		if(folderList.size()==0 && AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.CORE_LIBRARY)){
			loadingPanel(false);
			getComingSoonText(true);
		}else{
			getComingSoonText(false);
		}
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
			
			courseDo.setLabel(i18n.GL2027());
			thumbnailDo.setUrl("../images/library/partners/autodesk.png");
			libraryUserDo.setPartnerName(i18n.GL1566());
			libraryUserDo.setPartnerUrl(i18n.GL1567());
			
		} else if(partnerPlace.equals(PlaceTokens.ONR)) {
			
			courseDo.setLabel(i18n.GL2028());
			thumbnailDo.setUrl("../images/library/partners/onr.png");
			libraryUserDo.setPartnerName(i18n.GL1568());
			libraryUserDo.setPartnerUrl(i18n.GL1569());
			
		} else if(partnerPlace.equals(PlaceTokens.FTE)) {
			courseDo.setLabel(i18n.GL2029());
			thumbnailDo.setUrl("../images/library/partners/fte.png");
			libraryUserDo.setPartnerName(i18n.GL1570());
			libraryUserDo.setPartnerUrl(i18n.GL1571());
			
		} else if(partnerPlace.equals(PlaceTokens.NGC)) {
			
			courseDo.setLabel(i18n.GL2030());
			thumbnailDo.setUrl("../images/library/partners/ngc.png");
			libraryUserDo.setPartnerName(i18n.GL1572());
			libraryUserDo.setPartnerUrl(i18n.GL1573());

		} else if(partnerPlace.equals(PlaceTokens.WSPWH)) {
			
			courseDo.setLabel(i18n.GL2031());
			thumbnailDo.setUrl("../images/library/partners/wspwh.png");
			libraryUserDo.setPartnerName(i18n.GL1574());
			libraryUserDo.setPartnerUrl(i18n.GL1575());

		} else if(partnerPlace.equals(PlaceTokens.LESSONOPOLY)) {
			
			courseDo.setLabel(i18n.GL2032());
			thumbnailDo.setUrl("../images/library/partners/lessonopoly.png");
			libraryUserDo.setPartnerName(i18n.GL1576());
			libraryUserDo.setPartnerUrl(i18n.GL1577());

		} else if(partnerPlace.equals(PlaceTokens.FINCAPINC)) {
			
			courseDo.setLabel(i18n.GL2033());
			thumbnailDo.setUrl("../images/library/partners/cfci.png");
			libraryUserDo.setPartnerName(i18n.GL1765());
			libraryUserDo.setPartnerUrl(i18n.GL1766());

		} else if(partnerPlace.equals(PlaceTokens.PSDPAL)) {
			
			courseDo.setLabel(i18n.GL2034());
			thumbnailDo.setUrl("../images/library/partners/psd.png");
			libraryUserDo.setPartnerName(i18n.GL1763());
			libraryUserDo.setPartnerUrl(i18n.GL1764());

		}else if(partnerPlace.equals(PlaceTokens.YOUTHVOICES)) {
			
			courseDo.setLabel(i18n.GL2040());
			thumbnailDo.setUrl("../images/library/partners/youthvoices.png");
			libraryUserDo.setPartnerName(i18n.GL2042());
			libraryUserDo.setPartnerUrl(i18n.GL2043());

		}else if(partnerPlace.equals(PlaceTokens.GEOEDUCATION)) {
			
			courseDo.setLabel(i18n.GL2041());
			thumbnailDo.setUrl("../images/library/partners/natgeo.png");
			libraryUserDo.setPartnerName(i18n.GL2044());
			libraryUserDo.setPartnerUrl(i18n.GL2045());

		}else if(partnerPlace.equals(PlaceTokens.LPS)) {
			
			courseDo.setLabel(i18n.GL2053());
			thumbnailDo.setUrl("../images/library/district/landing-image-lps.png");
			libraryUserDo.setPartnerName(i18n.GL2065());
			libraryUserDo.setPartnerUrl(i18n.GL2066());

		}else if(partnerPlace.equals(PlaceTokens.CORE_LIBRARY)) {
			
			courseDo.setLabel(i18n.GL2108());
			thumbnailDo.setUrl("../images/library/district/landing-image-rusd_orange.png");
			libraryUserDo.setPartnerName(i18n.GL2110());
			libraryUserDo.setPartnerUrl(i18n.GL2111());

		}
		else if(partnerPlace.equals(PlaceTokens.ESYP)) {
				courseDo.setLabel(i18n.GL2186());
				thumbnailDo.setUrl("../images/library/partners/esyp.jpg");
				
				libraryUserDo.setPartnerName(i18n.GL2187());
				libraryUserDo.setPartnerUrl(i18n.GL2188());
			}
		else if(partnerPlace.equals(PlaceTokens.CCST_Cal_TAC)) {
				courseDo.setLabel(i18n.GL2191());
				thumbnailDo.setUrl("../images/library/partners/ccst.png");
				libraryUserDo.setPartnerName(i18n.GL2189());
				libraryUserDo.setPartnerUrl(i18n.GL2190());
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
	public void getComingSoonText(boolean isVisible) {
		libraryView.getComingSoonLabel().setVisible(isVisible);
	}

	@Override
	public void clearPanels() {
		libraryView.getContentScroll().clear();
		libraryView.getLeftNav().clear();
	}
	
	
	
}
