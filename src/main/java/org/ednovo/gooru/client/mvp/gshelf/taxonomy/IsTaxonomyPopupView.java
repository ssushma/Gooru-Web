package org.ednovo.gooru.client.mvp.gshelf.taxonomy;

import java.util.List;

import org.ednovo.gooru.application.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.application.shared.model.code.CourseSubjectDo;

import com.gwtplatform.mvp.client.PopupView;

public interface IsTaxonomyPopupView extends PopupView, IsViewWithHandlers<TaxonomyPopupUiHandlers> {

	void addTaxonomySubjects(List<CourseSubjectDo> result); 

	void addTaxonomyCourses(List<CourseSubjectDo> taxonomyCourseList); 

	void addTaxonomyDomains(List<CourseSubjectDo> taxonomyDomainList);

	void addTaxonomyStandards();

	void setCurrentTypeView(String viewType);  
 
}
