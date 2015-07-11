package org.ednovo.gooru.client.mvp.gshelf.taxonomy;

import org.ednovo.gooru.application.client.gin.BaseUiHandlers;

public interface TaxonomyPopupUiHandlers extends BaseUiHandlers {

	void getCoursesBasedOnSelectedSub();

	void getDomainsBasedOnSelectedCourse();

	void getSubjectsBasedOnSelectedDomain();   

}
