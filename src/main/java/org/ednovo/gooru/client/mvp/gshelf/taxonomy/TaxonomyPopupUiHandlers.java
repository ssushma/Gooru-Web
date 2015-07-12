package org.ednovo.gooru.client.mvp.gshelf.taxonomy;

import org.ednovo.gooru.application.client.gin.BaseUiHandlers;

public interface TaxonomyPopupUiHandlers extends BaseUiHandlers {

	void getCoursesBasedOnSelectedSub(int classification, String taxonomyType, int offset, int limit);

	void getDomainsBasedOnSelectedCourse(int classification, String taxonomyType, int offset, int limit);

	void getStdBasedOnSelectedDomain();

//	void getTaxonomySubjects();

	void getPopulateHigherEduData(int classification, String taxonomyType, int offset, int limit);

	void populateProfLearningData(int classification,String taxonomyType,int offSet,int limit);

	void populateK12TaxonomyData(int classification, String taxonomyType, int offset, int limit);      

}
