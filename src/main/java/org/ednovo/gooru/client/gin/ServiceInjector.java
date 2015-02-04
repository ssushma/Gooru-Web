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

import org.ednovo.gooru.client.service.AnalyticsServiceAsync;
import org.ednovo.gooru.client.service.AppServiceAsync;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.client.service.CollaboratorsServiceAsync;
import org.ednovo.gooru.client.service.FolderServiceAsync;
import org.ednovo.gooru.client.service.HomeServiceAsync;
import org.ednovo.gooru.client.service.LibraryServiceAsync;
import org.ednovo.gooru.client.service.MediaUploadServiceAsync;
import org.ednovo.gooru.client.service.PlayerAppServiceAsync;
import org.ednovo.gooru.client.service.ProfilePageServiceAsync;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.client.service.SearchServiceAsync;
import org.ednovo.gooru.client.service.ShelfServiceAsync;
import org.ednovo.gooru.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.client.service.UserServiceAsync;

import com.google.gwt.inject.client.Ginjector;
/**
 * 
 * @fileName : ServiceInjector.java
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
public interface ServiceInjector extends Ginjector {

	AppServiceAsync getAppService();

	SearchServiceAsync getSearchService();

	HomeServiceAsync getHomeService();
	
	ShelfServiceAsync getShelfService();
	
	ResourceServiceAsync getResourceService();
	
	TaxonomyServiceAsync getTaxonomyService();
	
	UserServiceAsync getUserService();
	
	MediaUploadServiceAsync  getMediaUploadService();
	
	ClasspageServiceAsync getClasspageService();
	
	FolderServiceAsync getfolderService();
	
	ProfilePageServiceAsync getProfilePageService();
	
	PlayerAppServiceAsync getPlayerAppService();

	LibraryServiceAsync getLibraryService();
	
	CollaboratorsServiceAsync getCollaboratorsService();
	
	AnalyticsServiceAsync getAnalyticsService();

}