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

package org.ednovo.gooru.application.client.gin;


import org.ednovo.gooru.application.client.AppPlaceKeeper;
import org.ednovo.gooru.application.client.newhome.NewHomePresenter;
import org.ednovo.gooru.application.client.wrap.WrapPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.AssessmentsPlayerPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.preview.AssessmentsPreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.resource.AssessmentsResourcePlayerPresenter;
import org.ednovo.gooru.client.mvp.classpage.studentclassview.StudentClassPresenter;
import org.ednovo.gooru.client.mvp.classpage.teach.TeachClassPresenter;
import org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter;
import org.ednovo.gooru.client.mvp.classpages.home.ClassHomePresenter;
import org.ednovo.gooru.client.mvp.classpages.studentView.StudentAssignmentPresenter;
import org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter;
import org.ednovo.gooru.client.mvp.community.CommunityPresenter;
import org.ednovo.gooru.client.mvp.error.ErrorPresenter;
import org.ednovo.gooru.client.mvp.folder.toc.FolderTocPresenter;
import org.ednovo.gooru.client.mvp.gsearch.SearchMainPresenter;
import org.ednovo.gooru.client.mvp.gsearch.addResourcePopup.SearchAddResourceToCollectionPresenter;
import org.ednovo.gooru.client.mvp.gsearch.collection.SearchCollectionPresenter;
import org.ednovo.gooru.client.mvp.gsearch.resource.SearchResourcePresenter;
import org.ednovo.gooru.client.mvp.gsearch.util.GooruGradesPresenter;
import org.ednovo.gooru.client.mvp.gshelf.ShelfMainPresenter;
import org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter;
import org.ednovo.gooru.client.mvp.library.district.DistrictPresenter;
import org.ednovo.gooru.client.mvp.library.district.episd.EpisdLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.lifeboard.LifeboardLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.lusd.LusdLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.rusd.RusdLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.sausd.SausdLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.susd.SusdLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.valverde.ValVerdeLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.ycl.YumaCountryLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.autodesk.AutodeskLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.ccstcaltac.CcstCalTacLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.corelibrary.CoreLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.epapa.EpapaLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.esyp.EsypLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.fincapinc.CfciLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.fte.FteLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.lps.LpsLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.natgeo.NatGeoLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.ngc.NgcLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.onr.OnrLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.psdpal.PsdpalLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.tical.TicalLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.wspwh.WspwhLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.yesdlibrary.YesdLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.youthvoices.YouthVoicesLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.rusd.RusdPresenter;
import org.ednovo.gooru.client.mvp.play.collection.CollectionPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerPresenter;
import org.ednovo.gooru.client.mvp.prime.PrimePresenter;
import org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter;
import org.ednovo.gooru.client.mvp.search.CenturySkills.AddCenturyPresenter;
import org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.drive.DrivePresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl;

/**
 *
 * @fileName : AppInjector.java
 *
 * @description :
 *
 *
 * @version : 1.0
 *
 * @date: 06-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
@GinModules({ AppModule.class, ServiceModule.class })
public interface AppInjector extends ServiceInjector {

	final AppInjector appInjector = GWT.create(AppInjector.class);

	AppPlaceManager getPlaceManager();

	EventBus getEventBus();

	AppClientFactory getAppClientShop();

	AppPlaceKeeper getAppPlaceKeeper();

	GoogleAnalyticsImpl getGoogleAnalytics();	

	AsyncProvider<SearchMainPresenter> getSearchMainPresenter();

	AsyncProvider<SearchCollectionPresenter> getSearchCollectionPresenter();

	Provider<WrapPresenter> getWrapPresenter();

	Provider<PrimePresenter> getPrimePresenter();
	
	AsyncProvider<EditClasspagePresenter> getEditClasspagePresenter();
	
	AsyncProvider<RusdPresenter> getRusdPresenter();
	
	AsyncProvider<DrivePresenter> getDrivePresenter();

	AddCenturyPresenter getAddCenturyPresenterWidget();

	SearchAddResourceToCollectionPresenter getRemixPresenterWidget();	

	AsyncProvider<UserSettingsPresenter> getUserSettingsPresenter();
	
	GooruGradesPresenter getGooruGradePresenter();	

	AsyncProvider<NewHomePresenter> getTestPresenter();

	AsyncProvider<ShelfMainPresenter> getShelfMainPresenter();

	AsyncProvider<UserRegistrationPresenter> getUserRegistrationPresenter();	

	AsyncProvider<SearchResourcePresenter> getSearchResourcePresenter();

	AsyncProvider<ErrorPresenter> getErrorPresenter();

	AsyncProvider<ProfilePagePresenter> getProfilePagePresenter();
	
	AsyncProvider<ClassCodePresenter> getClassCodePresenter();
	
	AsyncProvider<ClassHomePresenter> getClassHomePresenter();	

	AsyncProvider<StudentAssignmentPresenter> getStudentAssignmentPresenter();	

	AsyncProvider<CollectionPlayerPresenter> getCollectionPlayerPresenter();

	AsyncProvider<AssessmentsPlayerPresenter> getAssessmentsPlayerPresenter();
	
	AsyncProvider<FolderTocPresenter> getFolderTocPresenter();

	AsyncProvider<ResourcePlayerPresenter> getResourcePlayerPresenter();
	
	AsyncProvider<EpisdLibraryPresenter> getEpisdPresenter();

	AsyncProvider<CommunityPresenter> getLandingPagePresenter();

	AsyncProvider<PreviewPlayerPresenter> getPreviewPlayerPresenter();

	AsyncProvider<FteLibraryPresenter> getFteLibraryPresenter();

	AsyncProvider<AutodeskLibraryPresenter> getAutodeskLibraryPresenter();

	AsyncProvider<OnrLibraryPresenter> getOnrLibraryPresenter();	

	AsyncProvider<LessonopolyLibraryPresenter> getLessonopolyLibraryPresenter();

	AsyncProvider<NgcLibraryPresenter> getNgcLibraryPresenter();	

	AsyncProvider<WspwhLibraryPresenter> getWspwhLibraryPresenter();
	AsyncProvider<PsdpalLibraryPresenter> getPsdpalLibraryPresenter();

	AsyncProvider<CfciLibraryPresenter> getCfciLibraryPresenter();

	AsyncProvider<DistrictPresenter> getDistrictPresenter();
	
	AsyncProvider<NatGeoLibraryPresenter> getNatGeoLibraryPresenter();

	AsyncProvider<YouthVoicesLibraryPresenter> getYouthVoicesLibraryPresenter();

	AsyncProvider<SausdLibraryPresenter> getSausdPresenter();

	AsyncProvider<LifeboardLibraryPresenter> getLifeboardPresenter();
	
	AsyncProvider<SusdLibraryPresenter> getSusdLibraryPresenter();

	AsyncProvider<ValVerdeLibraryPresenter> getValVerdeLibraryPresenter();
	
	AsyncProvider<YumaCountryLibraryPresenter> getYumaCountryLibraryPresenter();

	AsyncProvider<LpsLibraryPresenter> getLpsLibraryPresenter();

	AsyncProvider<CoreLibraryPresenter> getCoreLibraryPresenter();

	AsyncProvider<YesdLibraryPresenter> getYesdLibraryPresenter();

	AsyncProvider<EsypLibraryPresenter> getEsypLibraryPresenter();

	AsyncProvider<CcstCalTacLibraryPresenter> getCcstCalTacLibraryPresenter();

	AsyncProvider<LusdLibraryPresenter> getLusdLibraryPresenter();

	AsyncProvider<TicalLibraryPresenter> getTicalLibraryPresenter();
	
	AsyncProvider<RusdLibraryPresenter> getRusdLibraryPresenter();

	AsyncProvider<EpapaLibraryPresenter> getEpapaPresenter();

	AsyncProvider<TeachClassPresenter> getTeachClassPresenter();	

	AsyncProvider<StudentClassPresenter> getStudentClassPresenter();
	
	AsyncProvider<AssessmentsPreviewPlayerPresenter> getAssessmentsPreviewPlayerPresenter();

	AsyncProvider<AssessmentsResourcePlayerPresenter> getAssessmentsResourcePlayerPresenter();
 }
