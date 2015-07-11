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

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class TaxonomyPopupPresenter extends PresenterWidget<IsTaxonomyPopupView> implements TaxonomyPopupUiHandlers{
	
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


	public void getTaxonomySubjects() { 
		getView().addTaxonomySubjects();
	}


	@Override
	public void getCoursesBasedOnSelectedSub() {
		getView().addTaxonomyCourses();
	}


	@Override
	public void getDomainsBasedOnSelectedCourse() {
		getView().addTaxonomyDomains();
	}


	@Override
	public void getSubjectsBasedOnSelectedDomain() {
		getView().addTaxonomyStandards();
	}
	
	

}
