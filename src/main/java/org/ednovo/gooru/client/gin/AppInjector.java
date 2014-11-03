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

package org.ednovo.gooru.client.gin;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.mvp.authentication.SignUpPresenter;
import org.ednovo.gooru.client.mvp.authentication.afterthirteen.SignUpCompleteProfilePresenter;
import org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter;
import org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter;
import org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter;
import org.ednovo.gooru.client.mvp.classpages.home.ClassHomePresenter;
import org.ednovo.gooru.client.mvp.classpages.studentView.StudentAssignmentPresenter;
import org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter;
import org.ednovo.gooru.client.mvp.community.CommunityPresenter;
import org.ednovo.gooru.client.mvp.community.contributors.ContributorsPresenter;
import org.ednovo.gooru.client.mvp.devicesupport.DeviceSupportPresenter;
import org.ednovo.gooru.client.mvp.error.ErrorPresenter;
import org.ednovo.gooru.client.mvp.folders.FoldersPresenter;
import org.ednovo.gooru.client.mvp.folders.edit.EditFolderPresenter;
import org.ednovo.gooru.client.mvp.folders.newfolder.FolderFormViewPresenter;
import org.ednovo.gooru.client.mvp.home.HomePresenter;
import org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.client.mvp.library.district.DistrictPresenter;
import org.ednovo.gooru.client.mvp.library.district.lifeboard.LifeboardLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.lusd.LusdLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.rusd.RusdLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.sausd.SausdLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.susd.SusdLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.district.valverde.ValVerdeLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.autodesk.AutodeskLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.ccstcaltac.CcstCalTacLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.partner.corelibrary.CoreLibraryPresenter;
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
import org.ednovo.gooru.client.mvp.library.partner.youthvoices.YouthVoicesLibraryPresenter;
import org.ednovo.gooru.client.mvp.library.rusd.RusdPresenter;
import org.ednovo.gooru.client.mvp.play.collection.CollectionPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerPresenter;
import org.ednovo.gooru.client.mvp.player.CollectionPlayPresenter;
import org.ednovo.gooru.client.mvp.player.ResourcePlayPresenter;
import org.ednovo.gooru.client.mvp.prime.PrimePresenter;
import org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter;
import org.ednovo.gooru.client.mvp.rating.RatingAndReviewPopupPresenter;
import org.ednovo.gooru.client.mvp.register.RegisterPresenter;
import org.ednovo.gooru.client.mvp.search.AddResourceContainerPresenter;
import org.ednovo.gooru.client.mvp.search.SearchRootPresenter;
import org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter;
import org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter;
import org.ednovo.gooru.client.mvp.search.standards.AddStandardsPresenter;
import org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter;
import org.ednovo.gooru.client.mvp.shelf.ShelfPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.drive.DrivePresenter;
import org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter;
import org.ednovo.gooru.client.mvp.wrap.WrapPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl;

/**
 * @author Search Team
 * 
 */
@GinModules({ AppModule.class, ServiceModule.class })
public interface AppInjector extends ServiceInjector {

	AppPlaceManager getPlaceManager();

	EventBus getEventBus();

	AppClientFactory getAppClientShop();

	AppPlaceKeeper getAppPlaceKeeper();
	
	GoogleAnalyticsImpl getGoogleAnalytics();

	Provider<WrapPresenter> getWrapPresenter();

	Provider<PrimePresenter> getPrimePresenter();

	Provider<HomePresenter> getHomePresenter();

	AsyncProvider<SearchRootPresenter> getSearchRootPresenter();

	AsyncProvider<CollectionSearchPresenter> getCollectionSearchPresenter();

	AsyncProvider<ResourceSearchPresenter> getResourceSearchPresenter();

	AsyncProvider<ErrorPresenter> getErrorPresenter();

	AsyncProvider<ShelfPresenter> getShelfPresenter();
	
	AsyncProvider<CollectionResourceTabPresenter> getCollectionResourceTabPresenter();
	
	AsyncProvider<CollectionInfoTabPresenter> getCollectionInfoTabPresenter();

	AsyncProvider<ShelfListPresenter> getShelfTabPresenter();

	AsyncProvider<CollectionFormPresenter> getCollectionFormPresenter();

	AsyncProvider<ResourcePlayPresenter> getResourcePlayPresenter();

	AsyncProvider<CollectionPlayPresenter> getCollectionPlayPresenter();
	
	AsyncProvider<ImageUploadPresenter> getImageUploadPresenter();
	
	AsyncProvider<UserRegistrationPresenter> getUserRegistrationPresenter();
	
	AsyncProvider<ClasspagePresenter> getClasspagePresenter();
	
	AsyncProvider<FoldersPresenter> getFoldersPresenter();

	AsyncProvider<UserSettingsPresenter> getUserSettingsPresenter();
	
	AsyncProvider<FolderFormViewPresenter> getFolderFormViewPresenter();
	
	AsyncProvider<EditClasspagePresenter> getEditClasspagePresenter();

	AsyncProvider<EditFolderPresenter> getEditFolderPresenter();
	
	AsyncProvider<RegisterPresenter> getRegisterPresenter();
	
	AsyncProvider<ClassCodePresenter> getClassCodePresenter();
	
	AsyncProvider<ClassHomePresenter> getClassHomePresenter();
	
	AsyncProvider<StudentAssignmentPresenter> getStudentAssignmentPresenter();
	
	AsyncProvider<CollectionFormInPlayPresenter> getCollectionFormInPlayPresenter();

	AsyncProvider<ProfilePagePresenter> getProfilePagePresenter();

	AsyncProvider<DeviceSupportPresenter> getDeviceSupportPresenter();
	
	AsyncProvider<CollectionAssignTabPresenter> getCollectionAssignViewTabPresenter();
	
	AsyncProvider<SignUpPresenter> getSignUpPresenter();
	
	AsyncProvider<CollectionPlayerPresenter> getCollectionPlayerPresenter();
	
	AsyncProvider<ResourcePlayerPresenter> getResourcePlayerPresenter();
	
	AsyncProvider<SignUpCompleteProfilePresenter> getSignUpCompleteProfilePresenter();
	
	AsyncProvider<RusdPresenter> getRusdPresenter();
	
	AsyncProvider<CommunityPresenter> getLandingPagePresenter();
	
	AsyncProvider<PreviewPlayerPresenter> getPreviewPlayerPresenter();
	
	AsyncProvider<CollectionCollaboratorsTabPresenter> getCollectionCollaboratorsTabPresenter();

	AsyncProvider<FolderItemTabPresenter> getFolderItemTabPresenter();
	
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
	
	AsyncProvider<AddResourceContainerPresenter> getAddResourceContainerPresenter();

	AsyncProvider<NatGeoLibraryPresenter> getNatGeoLibraryPresenter();

	AsyncProvider<YouthVoicesLibraryPresenter> getYouthVoicesLibraryPresenter();
	
	AsyncProvider<SausdLibraryPresenter> getSausdPresenter();

	AsyncProvider<LifeboardLibraryPresenter> getLifeboardPresenter();

	AsyncProvider<AddStandardsPresenter> getAddStandardsPresenter();

	AsyncProvider<ContributorsPresenter> getContributorsPresenter();

	AsyncProvider<SusdLibraryPresenter> getSusdLibraryPresenter();

	AsyncProvider<ValVerdeLibraryPresenter> getValVerdeLibraryPresenter();

	AsyncProvider<RusdLibraryPresenter> getRusdLibraryPresenter();

	AsyncProvider<LpsLibraryPresenter> getLpsLibraryPresenter();

	AsyncProvider<CoreLibraryPresenter> getCoreLibraryPresenter();
	
	AsyncProvider<EsypLibraryPresenter> getEsypLibraryPresenter();
	
	AsyncProvider<CcstCalTacLibraryPresenter> getCcstCalTacLibraryPresenter();
	
	AsyncProvider<LusdLibraryPresenter> getLusdLibraryPresenter();
	
	AsyncProvider<TicalLibraryPresenter> getTicalLibraryPresenter();
}
