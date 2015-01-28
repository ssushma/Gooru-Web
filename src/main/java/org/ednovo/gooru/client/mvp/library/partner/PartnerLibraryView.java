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




import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.library.LibraryStyleBundle;
import org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView;
import org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView;
import org.ednovo.gooru.client.mvp.home.library.LibraryView;
import org.ednovo.gooru.client.util.PlayerDataLogEvents;
import org.ednovo.gooru.player.collection.client.util.GwtUUIDGenerator;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ThumbnailDo;
import org.ednovo.gooru.shared.model.library.CourseDo;
import org.ednovo.gooru.shared.model.library.LibraryUserDo;
import org.ednovo.gooru.shared.model.library.PartnerFolderDo;
import org.ednovo.gooru.shared.util.Constants;
import org.ednovo.gooru.shared.util.StringUtil;


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
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

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
		if(folderList.size()==0 && AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.ASPIRE_EPACS)){
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
				PlayerDataLogEvents.triggerLibraryViewEvent(folderList.get(i).getParentGooruOid());
				LibraryUnitMenuView libraryUnitMenuView = new LibraryUnitMenuView(folderList.get(i));
				libraryView.getLeftNav().add(libraryUnitMenuView);
				if(j==0&&folderId==null) {
					j++;
					loadingPanel(true);
					libraryUnitMenuView.addStyleName(libraryStyleUc.unitLiActive());
					unitListId = folderList.get(i).getGooruOid();
					setTopicListData(folderList.get(i).getFolderItems(), unitListId,folderList.get(i).getParentGooruOid());
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
						setTopicListData(folderList.get(finalWidgetCount).getFolderItems(), unitListId,libraryUnitMenuView.getLibraryGooruOid());
					} else {
						getUiHandlers().getPartnerChildFolderItems(unitListId, 1,libraryUnitMenuView.getLibraryGooruOid());
					}
				}
			});
			widgetCount++;
		}
	}

	@Override
	public void setTopicListData(ArrayList<PartnerFolderDo> folderListDo, String folderId,String libraryGooruOid) {
		libraryView.getContentScroll().clear();
		try {
			int count = 0;
			for(int i = 0; i <folderListDo.size(); i++) {
				count++;
				libraryView.getContentScroll().add(new LibraryTopicListView(folderListDo.get(i), count, AppClientFactory.getCurrentPlaceToken(),libraryGooruOid));
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
		Map<String, LoadBannerActionInterface> libraryVal = new HashMap<String,LoadBannerActionInterface>();
		libraryVal = addAllPartnerLibraries();
		
		
		try {
			LoadBannerActionInterface actionInterface = libraryVal.get(partnerPlace); 
			actionInterface.loadLibBanner(courseDo, thumbnailDo, libraryUserDo); 
		} catch (Exception e) {
			System.out.println("-- "+e); 
		}
		
		
		/*if(partnerPlace.equals(PlaceTokens.AUTODESK)) {
			
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

		}else if(partnerPlace.equals(PlaceTokens.ESYP)) {
			courseDo.setLabel(i18n.GL2174());
			thumbnailDo.setUrl("../images/library/partners/esyp.jpg");
			libraryUserDo.setPartnerName(i18n.GL2175());
			libraryUserDo.setPartnerUrl(i18n.GL2176());
		}else if(partnerPlace.equals(PlaceTokens.CCST_Cal_TAC)) {
			courseDo.setLabel(i18n.GL2179());
			thumbnailDo.setUrl("../images/library/partners/ccst.png");
			libraryUserDo.setPartnerName(i18n.GL2177());
			libraryUserDo.setPartnerUrl(i18n.GL2178());
		}else if(partnerPlace.equals(PlaceTokens.TICAL)) {
			courseDo.setLabel(i18n.GL2186());
			thumbnailDo.setUrl("../images/library/partners/tical.png");
			libraryUserDo.setPartnerName(i18n.GL2187());
			libraryUserDo.setPartnerUrl(i18n.GL2188());
		}else if(partnerPlace.equals(PlaceTokens.ASPIRE_EPACS)) {
			courseDo.setLabel(i18n.GL3107());  
			thumbnailDo.setUrl("../images/library/partners/EPACS_banner.png");
			libraryUserDo.setPartnerName(i18n.GL3108());
			libraryUserDo.setPartnerUrl(i18n.GL3109());
		}*/
		
		courseDo.setThumbnails(thumbnailDo);
		courseDo.setCreator(libraryUserDo);
		return courseDo;
	}
	
	public Map<String, LoadBannerActionInterface> addAllPartnerLibraries() {

		Map<String, LoadBannerActionInterface> map = new HashMap<String,LoadBannerActionInterface>();
		map.put(PlaceTokens.AUTODESK,AutodeskBanner.getAutodeskInstance());
		map.put(PlaceTokens.ONR,ONRBanner.getOnrInstance());
		map.put(PlaceTokens.NGC,NgcBanner.getNgcInstance());
		map.put(PlaceTokens.FTE,FteBanner.getFteInstance());
		map.put(PlaceTokens.WSPWH,WspwhBanner.getWsphInstance());
		map.put(PlaceTokens.LESSONOPOLY,LessonopolyBanner.getLessonpolyInstance());
		map.put(PlaceTokens.FINCAPINC,FincapIncBanner.getfincapInstance());
		map.put(PlaceTokens.PSDPAL,PsdlBanner.getPsdpalIstance());
		map.put(PlaceTokens.YOUTHVOICES, YouthVoicesBanner.getYouthVoicesIstance());
		map.put(PlaceTokens.GEOEDUCATION, GeoEduBanner.getGeoEduIstance());
		map.put(PlaceTokens.LPS, LpsBanner.getLpsIstance());
		map.put(PlaceTokens.CORE_LIBRARY, CoreBanner.getcoreIstance());
		map.put(PlaceTokens.ESYP, EsypBanner.getEsypIstance());
		map.put(PlaceTokens.CCST_Cal_TAC, CcstBanner.getCcstIstance());
		map.put(PlaceTokens.TICAL, TicalBanner.getTicalInstance());
		map.put(PlaceTokens.ASPIRE_EPACS, AspireBanner.getAspireInstance());

		return map;

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
	
	
	private static class AutodeskBanner implements LoadBannerActionInterface{
		
		private static AutodeskBanner autodeskBannerInstance;
	    // SingletonExample prevents any other class from instantiating
	    private AutodeskBanner() {
	    }
	 
	    // Providing Global point of access
	    public static AutodeskBanner getAutodeskInstance() {
	        if (null == autodeskBannerInstance) { 
	        	autodeskBannerInstance = new AutodeskBanner();
	        }
	        return autodeskBannerInstance;
	    }
		
		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2027());
			thumbnailDo.setUrl(Constants.AUTODESK_BANNER);
			libraryUserDo.setPartnerName(i18n.GL1566());
			libraryUserDo.setPartnerUrl(i18n.GL1567());
		}
	}
	
	private static class ONRBanner implements LoadBannerActionInterface{
		
		private static ONRBanner ONRBannerInstance;
		 
	    // SingletonExample prevents any other class from instantiating
	    private ONRBanner() {
	    }
	 
	    // Providing Global point of access
	    public static ONRBanner getOnrInstance() {
	        if (null == ONRBannerInstance) { 
	        	ONRBannerInstance = new ONRBanner();
	        }
	        return ONRBannerInstance;
	    }

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2028());
			thumbnailDo.setUrl(Constants.ONR_BANNER);
			libraryUserDo.setPartnerName(i18n.GL1568());
			libraryUserDo.setPartnerUrl(i18n.GL1569());		}
	}
	
	private static class NgcBanner implements LoadBannerActionInterface{
		
		private static NgcBanner ngcBannerInstance;
		 
	    // SingletonExample prevents any other class from instantiating
	    private NgcBanner() {
	    }
	 
	    // Providing Global point of access
	    public static NgcBanner getNgcInstance() {
	        if (null == ngcBannerInstance) { 
	        	ngcBannerInstance = new NgcBanner();
	        }
	        return ngcBannerInstance;
	    }

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2030());
			thumbnailDo.setUrl(Constants.NGC_BANNER);
			libraryUserDo.setPartnerName(i18n.GL1572());
			libraryUserDo.setPartnerUrl(i18n.GL1573());
		}
	}
	
	private static class FteBanner implements LoadBannerActionInterface{

		private static FteBanner fteBannerInstance;
		 
	    // SingletonExample prevents any other class from instantiating
	    private FteBanner() {
	    }
	 
	    // Providing Global point of access
	    public static FteBanner getFteInstance() {
	        if (null == fteBannerInstance) { 
	        	fteBannerInstance = new FteBanner();
	        }
	        return fteBannerInstance;
	    }

		
		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2029());
			thumbnailDo.setUrl(Constants.FTE_BANNER);
			libraryUserDo.setPartnerName(i18n.GL1570());
			libraryUserDo.setPartnerUrl(i18n.GL1571());
		}
	}
	
	private static class WspwhBanner implements LoadBannerActionInterface{

		private static WspwhBanner wsphBannerInstance;
		 
	    // SingletonExample prevents any other class from instantiating
	    private WspwhBanner() {
	    }
	 
	    // Providing Global point of access
	    public static WspwhBanner getWsphInstance() {
	        if (null == wsphBannerInstance) { 
	        	wsphBannerInstance = new WspwhBanner();
	        }
	        return wsphBannerInstance;
	    }
		
		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2031());
			thumbnailDo.setUrl(Constants.WSPH_BANNER);
			libraryUserDo.setPartnerName(i18n.GL1574());
			libraryUserDo.setPartnerUrl(i18n.GL1575());
		}
	}
	
	private static class LessonopolyBanner implements LoadBannerActionInterface{

		private static LessonopolyBanner lessonopolyBannerInstance;
		 
	    // SingletonExample prevents any other class from instantiating
	    private LessonopolyBanner() {
	    }
	 
	    // Providing Global point of access
	    public static LessonopolyBanner getLessonpolyInstance() {
	        if (null == lessonopolyBannerInstance) { 
	        	lessonopolyBannerInstance = new LessonopolyBanner();
	        }
	        return lessonopolyBannerInstance;
	    }
		
		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2032());
			thumbnailDo.setUrl(Constants.LESSONOPOLY_BANNER);
			libraryUserDo.setPartnerName(i18n.GL1576());
			libraryUserDo.setPartnerUrl(i18n.GL1577());
		}
	}
	
	private static class FincapIncBanner implements LoadBannerActionInterface{


		private static FincapIncBanner fincapIncBannerInstance;
		 
	    // SingletonExample prevents any other class from instantiating
	    private FincapIncBanner() {
	    }
	 
	    // Providing Global point of access
	    public static FincapIncBanner getfincapInstance() {
	        if (null == fincapIncBannerInstance) { 
	        	fincapIncBannerInstance = new FincapIncBanner();
	        }
	        return fincapIncBannerInstance;
	    }
		
		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2033());
			thumbnailDo.setUrl(Constants.FINCAP_BANNER);
			libraryUserDo.setPartnerName(i18n.GL1765());
			libraryUserDo.setPartnerUrl(i18n.GL1766());
		}
	}
	
	private static class PsdlBanner implements LoadBannerActionInterface{

		private static PsdlBanner psdlBannerInstance;
		// SingletonExample prevents any other class from instantiating
		private PsdlBanner() {
		}

		// Providing Global point of access
		public static PsdlBanner getPsdpalIstance() {
			if (null == psdlBannerInstance) { 
				psdlBannerInstance = new PsdlBanner();
			}
			return psdlBannerInstance;
		}

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2034());
			thumbnailDo.setUrl(Constants.PSDPAL_BANNER);
			libraryUserDo.setPartnerName(i18n.GL1763());
			libraryUserDo.setPartnerUrl(i18n.GL1764());
		}
	}
	
	private static class YouthVoicesBanner implements LoadBannerActionInterface{

		private static YouthVoicesBanner youthVoiceBannerInstance;
		// SingletonExample prevents any other class from instantiating
		private YouthVoicesBanner() {
		}

		// Providing Global point of access
		public static YouthVoicesBanner getYouthVoicesIstance() {
			if (null == youthVoiceBannerInstance) { 
				youthVoiceBannerInstance = new YouthVoicesBanner();
			}
			return youthVoiceBannerInstance;
		}

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2040());
			thumbnailDo.setUrl(Constants.YOUTH_VOICES_BANNER);
			libraryUserDo.setPartnerName(i18n.GL2042());
			libraryUserDo.setPartnerUrl(i18n.GL2043());
		}
	}

	private static class GeoEduBanner implements LoadBannerActionInterface{

		private static GeoEduBanner geoEduBannerInstance;
		// SingletonExample prevents any other class from instantiating
		private GeoEduBanner() {
		}

		// Providing Global point of access
		public static GeoEduBanner getGeoEduIstance() {
			if (null == geoEduBannerInstance) { 
				geoEduBannerInstance = new GeoEduBanner();
			}
			return geoEduBannerInstance;
		}

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2041());
			thumbnailDo.setUrl(Constants.GEOEDU_BANNER);
			libraryUserDo.setPartnerName(i18n.GL2044());
			libraryUserDo.setPartnerUrl(i18n.GL2045());
		}
	}
	
	private static class LpsBanner implements LoadBannerActionInterface{

		private static LpsBanner lpsBannerInstance;
		// SingletonExample prevents any other class from instantiating
		private LpsBanner() {
		}

		// Providing Global point of access
		public static LpsBanner getLpsIstance() {
			if (null == lpsBannerInstance) { 
				lpsBannerInstance = new LpsBanner();
			}
			return lpsBannerInstance;
		}

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2053());
			thumbnailDo.setUrl(Constants.LPS_BANNER);
			libraryUserDo.setPartnerName(i18n.GL2065());
			libraryUserDo.setPartnerUrl(i18n.GL2066());
		}
	}
	
	private static class CoreBanner implements LoadBannerActionInterface{

		private static CoreBanner coreBannerInstance;
		// SingletonExample prevents any other class from instantiating
		private CoreBanner() {
		}

		// Providing Global point of access
		public static CoreBanner getcoreIstance() {
			if (null == coreBannerInstance) { 
				coreBannerInstance = new CoreBanner();
			}
			return coreBannerInstance;
		}

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2108());
			thumbnailDo.setUrl(Constants.CORE_BANNER);
			libraryUserDo.setPartnerName(i18n.GL2110());
			libraryUserDo.setPartnerUrl(i18n.GL2111());
		}
	}
	
	private static class EsypBanner implements LoadBannerActionInterface{

		private static EsypBanner esypBannerInstance;
		// SingletonExample prevents any other class from instantiating
		private EsypBanner() {
		}

		// Providing Global point of access
		public static EsypBanner getEsypIstance() {
			if (null == esypBannerInstance) { 
				esypBannerInstance = new EsypBanner();
			}
			return esypBannerInstance;
		}

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2174());
			thumbnailDo.setUrl(Constants.ESYP_BANNER);
			libraryUserDo.setPartnerName(i18n.GL2175());
			libraryUserDo.setPartnerUrl(i18n.GL2176());
		}
	}

	private static class CcstBanner implements LoadBannerActionInterface{

		private static CcstBanner ccstBannerInstance;
		// SingletonExample prevents any other class from instantiating
		private CcstBanner() {
		}

		// Providing Global point of access
		public static CcstBanner getCcstIstance() {
			if (null == ccstBannerInstance) { 
				ccstBannerInstance = new CcstBanner();
			}
			return ccstBannerInstance;
		}

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2179());
			thumbnailDo.setUrl(Constants.CCST_BANNER);
			libraryUserDo.setPartnerName(i18n.GL2177());
			libraryUserDo.setPartnerUrl(i18n.GL2178());
		}
	}

	private static class TicalBanner implements LoadBannerActionInterface{

		private static TicalBanner ticalBannerInstance;
		// SingletonExample prevents any other class from instantiating
		private TicalBanner() {
		}

		// Providing Global point of access
		public static TicalBanner getTicalInstance() {
			if (null == ticalBannerInstance) { 
				ticalBannerInstance = new TicalBanner();
			}
			return ticalBannerInstance;
		}

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL2186());
			thumbnailDo.setUrl(Constants.TICAL_BANNER);
			libraryUserDo.setPartnerName(i18n.GL2187());
			libraryUserDo.setPartnerUrl(i18n.GL2188());
		}
	}

	private static class AspireBanner implements LoadBannerActionInterface{

		private static AspireBanner aspireBannerInstance;
		// SingletonExample prevents any other class from instantiating
		private AspireBanner() {
		}

		// Providing Global point of access
		public static AspireBanner getAspireInstance() {
			if (null == aspireBannerInstance) { 
				aspireBannerInstance = new AspireBanner();
			}
			return aspireBannerInstance;
		}

		@Override
		public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo,LibraryUserDo libraryUserDo) {
			courseDo.setLabel(i18n.GL3107());  
			thumbnailDo.setUrl(Constants.ASPIRE_BANNER);
			libraryUserDo.setPartnerName(i18n.GL3108());
			libraryUserDo.setPartnerUrl(i18n.GL3109());
		}
	}
}
