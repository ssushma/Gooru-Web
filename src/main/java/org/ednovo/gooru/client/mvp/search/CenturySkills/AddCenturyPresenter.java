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
package org.ednovo.gooru.client.mvp.search.CenturySkills;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.client.service.ShelfServiceAsync;
import org.ednovo.gooru.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.shared.model.skils.CenturySkilsDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * @author Search Team
 *
 */
public class AddCenturyPresenter extends PresenterWidget<IsAddCenturyView> implements AddCenturyUiHandlers {

	@Inject
	private ShelfServiceAsync shelfService;

	@Inject
	private ResourceServiceAsync resourceService;

	@Inject
	private TaxonomyServiceAsync taxonomyService;

	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public AddCenturyPresenter( EventBus eventBus,IsAddCenturyView view) {
		super(eventBus,view);
		getView().setUiHandlers(this);
	}

	/* (non-Javadoc)
	 * @see com.gwtplatform.mvp.client.HandlerContainerImpl#onBind()
	 */
	@Override
	public void onBind() {
		super.onBind();
	
	}
	
	public void callDefaultStandardsLoad(){
		getView().loadData();
		getView().reset();
	}
	
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.search.CenturySkills.AddCenturyUiHandlers#loadStateStandards()
	 */
	@Override
	public void loadStateStandards(){
		getView().reset();
		/*AppClientFactory.getInjector().getSearchService().getFirstLevelStandards("0", stateCode, new SimpleAsyncCallback<ArrayList<StandardsLevel1DO>>() {
			@Override
			public void onSuccess(ArrayList<StandardsLevel1DO> result) {
				for(int i=0;i<result.size();i++) {
					getView().SetData(result.get(i),i);
				}
			}
		});*/
		AppClientFactory.getInjector().getSearchService().getCenturySkilsRestuls(new SimpleAsyncCallback<CenturySkilsDo>() {
			@Override
			public void onSuccess(CenturySkilsDo result) {
				if(result!=null){
					getView().SetData(result);
				}
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.gwtplatform.mvp.client.PresenterWidget#onReveal()
	 */
	@Override
	protected void onReveal(){
		super.onReveal();
		callDefaultStandardsLoad();
		loadStateStandards();
	}
	
	@Override
	public void hidePopup() {
		getView().hidePopup();
	}

	private String resourceOid;

	public String getResourceUid() {
		return resourceOid;
	}
	
	public String setPlayerType(String playerType){
		return playerType;
	}

	public void setResourceUid(String resourceUid) {
		this.resourceOid = resourceUid;
	}
}
