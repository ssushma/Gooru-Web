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
import org.ednovo.gooru.application.client.home.banner.HomeBannerPresenter;
import org.ednovo.gooru.application.client.home.presearch.PreSearchPresenter;
import org.ednovo.gooru.application.client.newhome.NewHomePresenter;
import org.ednovo.gooru.application.client.wrap.WrapPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.AssessmentsPlayerPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.preview.AssessmentsPreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.resource.AssessmentsResourcePlayerPresenter;
import org.ednovo.gooru.client.mvp.authentication.SignUpPresenter;
import org.ednovo.gooru.client.mvp.authentication.afterthirteen.SignUpCompleteProfilePresenter;
import org.ednovo.gooru.client.mvp.classpage.studentclassview.StudentClassPresenter;
import org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.StudentClassLearningMapPresenter;
import org.ednovo.gooru.client.mvp.classpage.studentclassview.reports.StudentClassReportPresenter;
import org.ednovo.gooru.client.mvp.classpage.teach.TeachClassPresenter;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.EditClassPresenter;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.EditClassSettingsPresenter;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.content.EditClassContentPresenter;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.coursePopup.AddCourseToClassPresenter;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.student.EditClassStudentPresenter;
import org.ednovo.gooru.client.mvp.classpage.teach.reports.TeachStudentDashboardPresenter;
import org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter;
import org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter;
import org.ednovo.gooru.client.mvp.classpages.home.ClassHomePresenter;
import org.ednovo.gooru.client.mvp.classpages.studentView.StudentAssignmentPresenter;
import org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter;
import org.ednovo.gooru.client.mvp.community.CommunityPresenter;
import org.ednovo.gooru.client.mvp.community.contributors.ContributorsPresenter;
import org.ednovo.gooru.client.mvp.error.ErrorPresenter;
import org.ednovo.gooru.client.mvp.folder.toc.FolderTocPresenter;
import org.ednovo.gooru.client.mvp.gsearch.SearchMainPresenter;
import org.ednovo.gooru.client.mvp.gsearch.addResourcePopup.SearchAddResourceToCollectionPresenter;
import org.ednovo.gooru.client.mvp.gsearch.collection.SearchCollectionPresenter;
import org.ednovo.gooru.client.mvp.gsearch.resource.SearchResourcePresenter;
import org.ednovo.gooru.client.mvp.gsearch.util.GooruGradesPresenter;
import org.ednovo.gooru.client.mvp.gshelf.ShelfMainPresenter;
import org.ednovo.gooru.client.mvp.gshelf.courselist.MyCollectionsListPresenter;
import org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
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
import org.ednovo.gooru.client.mvp.rating.RatingAndReviewPopupPresenter;
import org.ednovo.gooru.client.mvp.search.TagsTabPresenter;
import org.ednovo.gooru.client.mvp.search.CenturySkills.AddCenturyPresenter;
import org.ednovo.gooru.client.mvp.search.standards.AddStandardsPresenter;
import org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.drive.DrivePresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.addquestion.QuestionTypePresenter;

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

	Provider<WrapPresenter> getWrapPresenter();

	Provider<PrimePresenter> getPrimePresenter();

	AsyncProvider<SearchMainPresenter> getSearchMainPresenter();

	AsyncProvider<SearchCollectionPresenter> getSearchCollectionPresenter();

	AsyncProvider<SearchResourcePresenter> getSearchResourcePresenter();

	AsyncProvider<ErrorPresenter> getErrorPresenter();

	AsyncProvider<ImageUploadPresenter> getImageUploadPresenter();

	AsyncProvider<UserRegistrationPresenter> getUserRegistrationPresenter();

	AsyncProvider<UserSettingsPresenter> getUserSettingsPresenter();

	AsyncProvider<EditClasspagePresenter> getEditClasspagePresenter();

	AsyncProvider<NewHomePresenter> getTestPresenter();

	AsyncProvider<ClassCodePresenter> getClassCodePresenter();

	AsyncProvider<ClassHomePresenter> getClassHomePresenter();

	AsyncProvider<StudentAssignmentPresenter> getStudentAssignmentPresenter();

	AsyncProvider<ProfilePagePresenter> getProfilePagePresenter();

	AsyncProvider<SignUpPresenter> getSignUpPresenter();

	AsyncProvider<CollectionPlayerPresenter> getCollectionPlayerPresenter();

	AsyncProvider<AssessmentsPlayerPresenter> getAssessmentsPlayerPresenter();

	AsyncProvider<FolderTocPresenter> getFolderTocPresenter();

	AsyncProvider<ResourcePlayerPresenter> getResourcePlayerPresenter();

	AsyncProvider<SignUpCompleteProfilePresenter> getSignUpCompleteProfilePresenter();

	AsyncProvider<RusdPresenter> getRusdPresenter();

	AsyncProvider<CommunityPresenter> getLandingPagePresenter();

	AsyncProvider<PreviewPlayerPresenter> getPreviewPlayerPresenter();

	AsyncProvider<CollectionCollaboratorsTabPresenter> getCollectionCollaboratorsTabPresenter();

	AsyncProvider<ClassListPresenter> getclassListPresenter();

	AsyncProvider<FteLibraryPresenter> getFteLibraryPresenter();

	AsyncProvider<AutodeskLibraryPresenter> getAutodeskLibraryPresenter();

	AsyncProvider<OnrLibraryPresenter> getOnrLibraryPresenter();

	AsyncProvider<LessonopolyLibraryPresenter> getLessonopolyLibraryPresenter();

	AsyncProvider<NgcLibraryPresenter> getNgcLibraryPresenter();

	AsyncProvider<WspwhLibraryPresenter> getWspwhLibraryPresenter();

	AsyncProvider<RatingAndReviewPopupPresenter> getRatingAndReviewPopupPresenter();

	AsyncProvider<PsdpalLibraryPresenter> getPsdpalLibraryPresenter();

	AsyncProvider<CfciLibraryPresenter> getCfciLibraryPresenter();

	AsyncProvider<DistrictPresenter> getDistrictPresenter();

	AsyncProvider<DrivePresenter> getDrivePresenter();

	AsyncProvider<NatGeoLibraryPresenter> getNatGeoLibraryPresenter();

	AsyncProvider<YouthVoicesLibraryPresenter> getYouthVoicesLibraryPresenter();

	AsyncProvider<SausdLibraryPresenter> getSausdPresenter();

	AsyncProvider<LifeboardLibraryPresenter> getLifeboardPresenter();

	AsyncProvider<AddStandardsPresenter> getAddStandardsPresenter();

	AsyncProvider<AddCenturyPresenter> getAddCenturyPresenter();

	AsyncProvider<GooruGradesPresenter> getGooruGradesPresenter();

	AsyncProvider<ContributorsPresenter> getContributorsPresenter();

	AsyncProvider<SusdLibraryPresenter> getSusdLibraryPresenter();

	AsyncProvider<ValVerdeLibraryPresenter> getValVerdeLibraryPresenter();

	AsyncProvider<RusdLibraryPresenter> getRusdLibraryPresenter();

	AsyncProvider<YumaCountryLibraryPresenter> getYumaCountryLibraryPresenter();

	AsyncProvider<LpsLibraryPresenter> getLpsLibraryPresenter();

	AsyncProvider<CoreLibraryPresenter> getCoreLibraryPresenter();

	AsyncProvider<YesdLibraryPresenter> getYesdLibraryPresenter();

	AsyncProvider<EsypLibraryPresenter> getEsypLibraryPresenter();

	AsyncProvider<CcstCalTacLibraryPresenter> getCcstCalTacLibraryPresenter();

	AsyncProvider<LusdLibraryPresenter> getLusdLibraryPresenter();

	AsyncProvider<TicalLibraryPresenter> getTicalLibraryPresenter();

	AsyncProvider<TagsTabPresenter> getTagsTabPresenter();

	AsyncProvider<EpapaLibraryPresenter> getEpapaPresenter();

	AddCenturyPresenter getAddCenturyPresenterWidget();

	GooruGradesPresenter getGooruGradePresenter();

	SearchAddResourceToCollectionPresenter getRemixPresenterWidget();

	AsyncProvider<QuestionTypePresenter> getQuestionTypePresenter();

	MyCollectionsListPresenter getMyCollectionsListPresenter();

	AsyncProvider<HomeBannerPresenter> getHomeBannerPresenter();

	AsyncProvider<PreSearchPresenter> getPreSearchPresenter();

	AsyncProvider<StudentClassPresenter> getStudentClassPresenter();

	AsyncProvider<StudentClassLearningMapPresenter> getStudentClassLearningMapPresenter();

	AsyncProvider<StudentClassReportPresenter> getStudentClassReportPresenter();

	AsyncProvider<TeachClassPresenter> getTeachClassPresenter();

	AsyncProvider<EditClassPresenter>  getEditClassPresenter();

	AsyncProvider<EditClassSettingsPresenter> getEditClassSettingsPresenter();

	AsyncProvider<EditClassContentPresenter> getEditClassContentPresenter();

	AsyncProvider<EditClassStudentPresenter> getEditClassStudentPresenter();

	AsyncProvider<TeachStudentDashboardPresenter> getTeachStudentDashboardPresenter();

	AsyncProvider<AddCourseToClassPresenter> getAddCourseToClassPresenter();

	AsyncProvider<AssessmentsPreviewPlayerPresenter> getAssessmentsPreviewPlayerPresenter();

	AsyncProvider<AssessmentsResourcePlayerPresenter> getAssessmentsResourcePlayerPresenter();

	AsyncProvider<ShelfMainPresenter> getShelfMainPresenter();
	
	AsyncProvider<EpisdLibraryPresenter> getEpisdPresenter();
 }
