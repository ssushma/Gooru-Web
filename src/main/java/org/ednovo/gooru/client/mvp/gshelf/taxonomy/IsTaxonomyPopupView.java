package org.ednovo.gooru.client.mvp.gshelf.taxonomy;

import org.ednovo.gooru.application.client.gin.IsViewWithHandlers;

import com.gwtplatform.mvp.client.PopupView;

public interface IsTaxonomyPopupView extends PopupView, IsViewWithHandlers<TaxonomyPopupUiHandlers> {

	void addTaxonomySubjects();

	void addTaxonomyCourses();

	void addTaxonomyDomains();

	void addTaxonomyStandards();  

}
