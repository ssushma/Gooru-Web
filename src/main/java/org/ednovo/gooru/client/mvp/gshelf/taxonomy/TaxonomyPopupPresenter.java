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


package org.ednovo.gooru.client.mvp.gshelf.taxonomy;

import java.util.List;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.code.CourseSubjectDo;
import org.ednovo.gooru.application.shared.model.library.DomainStandardsDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.gshelf.unitdetails.UnitInfoPresenter;
import org.ednovo.gooru.client.uc.UlPanel;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class TaxonomyPopupPresenter extends PresenterWidget<IsTaxonomyPopupView> implements TaxonomyPopupUiHandlers{
	
	private String viewType;
	
	private UnitInfoPresenter unitInfoPresenter;
	
	
	
	@Inject
	public TaxonomyPopupPresenter(EventBus eventBus, IsTaxonomyPopupView view){
		super(eventBus,view);
		getView().setUiHandlers(this);
	}
	
	
	@Override
	public void onBind() {
		super.onBind();
	}

	@Override
	protected void onReveal(){
		super.onReveal();
	}
	
	@Override
	protected void onReset() {
		super.onReset();
	}


	/**
	 * 
	 * @param viewType
	 * @param classification
	 * @param taxonomyType
	 * @param offSet 
	 * @param limit
	 */
	public void getTaxonomySubjects(String viewType, int classification,String taxonomyType,int offSet,int limit) {  
		this.viewType = viewType;
		getView().setCurrentTypeView(viewType); 
		AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(classification, taxonomyType, offSet, limit, new SimpleAsyncCallback<List<CourseSubjectDo>>() {

			@Override
			public void onSuccess(List<CourseSubjectDo> result) {
				getView().addTaxonomySubjects(result);
				AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(result.get(0).getSubjectId(), "course", 0, 20, new SimpleAsyncCallback<List<CourseSubjectDo>>() {

					@Override
					public void onSuccess(List<CourseSubjectDo> taxonomyCourseList) {
						getView().addTaxonomyCourses(taxonomyCourseList);
						
						AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(taxonomyCourseList.get(0).getCourseId(),"domain", 0, 20,new SimpleAsyncCallback<List<CourseSubjectDo>>() {

							@Override
							public void onSuccess(List<CourseSubjectDo> taxonomyDomainList) {
								getView().addTaxonomyDomains(taxonomyDomainList);
								if(TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("Lesson")||TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("collection")||TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("assessment")){
									AppClientFactory.getInjector().getTaxonomyService().getStandardsList(taxonomyDomainList.get(0).getSubdomainId(), new SimpleAsyncCallback<List<DomainStandardsDo>>() {

										@Override
										public void onSuccess(List<DomainStandardsDo> result) {
											getView().addTaxonomyStandards(result); 
										}
									});
								}
							}
						});
					}
				});
			}
		});
	}


	@Override
	public void getCoursesBasedOnSelectedSub(int classification, String taxonomyType, int offset, int limit) { 
		
		AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(classification, "course", 0, 20, new SimpleAsyncCallback<List<CourseSubjectDo>>() {

			@Override
			public void onSuccess(List<CourseSubjectDo> taxonomyCourseList) {
				if(taxonomyCourseList.size()>0){
					getView().addTaxonomyCourses(taxonomyCourseList);
					AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(taxonomyCourseList.get(0).getCourseId(),"domain", 0, 20,new SimpleAsyncCallback<List<CourseSubjectDo>>() {
						
						@Override
						public void onSuccess(List<CourseSubjectDo> taxonomyDomainList) {
							if(taxonomyDomainList.size()>0){
								getView().addTaxonomyDomains(taxonomyDomainList);
								if(TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("Lesson")||TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("Collection")||TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("assessment")){
									AppClientFactory.getInjector().getTaxonomyService().getStandardsList(taxonomyDomainList.get(0).getSubdomainId(), new SimpleAsyncCallback<List<DomainStandardsDo>>() {
										
										@Override
										public void onSuccess(List<DomainStandardsDo> result) {
											getView().addTaxonomyStandards(result);
										}
									});
								}
							}
							
						}
					});
				}
			}
		});
	}


	@Override
	public void getDomainsBasedOnSelectedCourse(int classification, String taxonomyType, int offset, int limit) {
		AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(classification, taxonomyType, offset, limit, new SimpleAsyncCallback<List<CourseSubjectDo>>() {

			@Override
			public void onSuccess(List<CourseSubjectDo> result) {
				if(result.size()>0){
					getView().addTaxonomyDomains(result);
					if(TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("Lesson")||TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("Collection")||TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("assessment")){
						AppClientFactory.getInjector().getTaxonomyService().getStandardsList(result.get(0).getSubdomainId(), new SimpleAsyncCallback<List<DomainStandardsDo>>() {
							
							@Override
							public void onSuccess(List<DomainStandardsDo> result) {
								if(result.size()>0){
									getView().addTaxonomyStandards(result);
								}
							}
						});
					}
				}
			}
		});
	}

	
	@Override
	public void getStdBasedOnSelectedDomain(int subDomainId) { 
		if("Lesson".equalsIgnoreCase(viewType)){
			AppClientFactory.getInjector().getTaxonomyService().getStandardsList(subDomainId, new SimpleAsyncCallback<List<DomainStandardsDo>>() {

				@Override
				public void onSuccess(List<DomainStandardsDo> result) {
					if(result.size()>0){
						getView().addTaxonomyStandards(result);
					}
				}
			});
		}
	}


	@Override
	public void populateK12TaxonomyData(int classification,String taxonomyType,int offSet,int limit) { 
		populateInitialTaxonomyData(classification,taxonomyType,offSet,limit);
/*		AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(classification, taxonomyType, offSet, limit, new SimpleAsyncCallback<List<CourseSubjectDo>>() {

			@Override
			public void onSuccess(List<CourseSubjectDo> result) {
				getView().addTaxonomySubjects(result);
				AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(result.get(0).getSubjectId(), "course", 0, 20, new SimpleAsyncCallback<List<CourseSubjectDo>>() {

					@Override
					public void onSuccess(List<CourseSubjectDo> taxonomyCourseList) {
						getView().addTaxonomyCourses(taxonomyCourseList);
						
						AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(taxonomyCourseList.get(0).getCourseId(),"domain", 0, 20,new SimpleAsyncCallback<List<CourseSubjectDo>>() {

							@Override
							public void onSuccess(List<CourseSubjectDo> taxonomyDomainList) {
								getView().addTaxonomyDomains(taxonomyDomainList);
								if(TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("Lesson")){
									AppClientFactory.getInjector().getTaxonomyService().getStandardsList(taxonomyDomainList.get(0).getSubdomainId(), new SimpleAsyncCallback<List<DomainStandardsDo>>() {

										@Override
										public void onSuccess(List<DomainStandardsDo> result) {
											getView().addTaxonomyStandards(result);
										}
									});
								}
							}
						});
					}
				});
			}
		});*/
	}
	
	
	/**
	 * Populates the sub, course, domain and standards for Higher Edu.
	 */
	@Override
	public void getPopulateHigherEduData(int classification,String taxonomyType,int offSet,int limit) {
		populateInitialTaxonomyData(classification,taxonomyType,offSet,limit);
	}


	private void populateInitialTaxonomyData(int classification,String taxonomyType,int offSet,int limit) {
		AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(classification, taxonomyType, offSet, limit, new SimpleAsyncCallback<List<CourseSubjectDo>>() {

			@Override
			public void onSuccess(List<CourseSubjectDo> result) {
				if(result.size()>0){
					getView().addTaxonomySubjects(result);
					AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(result.get(0).getSubjectId(), "course", 0, 20, new SimpleAsyncCallback<List<CourseSubjectDo>>() {

						@Override
						public void onSuccess(List<CourseSubjectDo> taxonomyCourseList) {
							if(taxonomyCourseList.size()>0){
								getView().addTaxonomyCourses(taxonomyCourseList);
								AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(taxonomyCourseList.get(0).getCourseId(),"domain", 0, 20,new SimpleAsyncCallback<List<CourseSubjectDo>>() {
									@Override
									public void onSuccess(List<CourseSubjectDo> taxonomyDomainList) {
										if(taxonomyDomainList.size()>0){
											getView().addTaxonomyDomains(taxonomyDomainList);
											if(TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("Lesson")||TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("Collection") || TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("assessment")){
												AppClientFactory.getInjector().getTaxonomyService().getStandardsList(taxonomyDomainList.get(0).getSubdomainId(), new SimpleAsyncCallback<List<DomainStandardsDo>>() {
													
													@Override
													public void onSuccess(List<DomainStandardsDo> result) {
														if(result.size()>0){
															getView().addTaxonomyStandards(result);
														}
													}
												});
											}
										}
									}
								});
							}
						}
					});
				}
			}
		});
	}


	@Override
	public void populateProfLearningData(int classification,String taxonomyType,int offSet,int limit) {
		populateInitialTaxonomyData(classification,taxonomyType,offSet,limit);
		/*AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(classification, taxonomyType, offSet, limit, new SimpleAsyncCallback<List<CourseSubjectDo>>() {

			@Override
			public void onSuccess(List<CourseSubjectDo> result) {
				getView().addTaxonomySubjects(result);
				AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(result.get(0).getSubjectId(), "course", 0, 20, new SimpleAsyncCallback<List<CourseSubjectDo>>() {

					@Override
					public void onSuccess(List<CourseSubjectDo> taxonomyCourseList) {
						getView().addTaxonomyCourses(taxonomyCourseList);
						
						AppClientFactory.getInjector().getTaxonomyService().getSubjectsList(taxonomyCourseList.get(0).getCourseId(),"domain", 0, 20,new SimpleAsyncCallback<List<CourseSubjectDo>>() {

							@Override
							public void onSuccess(List<CourseSubjectDo> taxonomyDomainList) {
								getView().addTaxonomyDomains(taxonomyDomainList);
								if(TaxonomyPopupPresenter.this.viewType.equalsIgnoreCase("Lesson")){
									AppClientFactory.getInjector().getTaxonomyService().getStandardsList(taxonomyDomainList.get(0).getSubdomainId(), new SimpleAsyncCallback<List<DomainStandardsDo>>() {

										@Override
										public void onSuccess(List<DomainStandardsDo> result) {
											getView().addTaxonomyStandards(result);
										}
									});
								}
							}
						});
					}
				});
			}
		});*/
	}


	@Override
	public void addTaxonomyData(UlPanel selectedUlContainer) {
		if("Unit".equalsIgnoreCase(viewType)){
			unitInfoPresenter.addTaxonomy(selectedUlContainer);
		}
	}



	public void setUnitInfoPresenterInstance(UnitInfoPresenter unitInfoPresenter) { 
		this.unitInfoPresenter = unitInfoPresenter;
	}
	
	

}
