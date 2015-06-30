
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpage.teach;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BasePlacePresenter;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.classpage.teach.TeachClassPresenter.IsTeachClassProxy;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.EditClassPresenter;
import org.ednovo.gooru.client.mvp.shelf.ErrorPopup;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;


/**
 * @fileName : TeachClassPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 26-Jun-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class TeachClassPresenter extends BasePlacePresenter<IsTeachClassView, IsTeachClassProxy> implements TeachClassViewUiHandlers{
	
	
	EditClassPresenter editClassPresenter;
	
	String classpageId="";
	
	private boolean isApiCalled = false;
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.EDIT_CLASS)
	public interface IsTeachClassProxy extends ProxyPlace<TeachClassPresenter> {
	}

	@Inject
	public TeachClassPresenter(IsTeachClassView view,IsTeachClassProxy proxy,EditClassPresenter editClassPresenter){
		super(view, proxy);
		getView().setUiHandlers(this);
		this.editClassPresenter=editClassPresenter;
		
	}
	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;
	
	@Override
	public String getViewToken() {
		throw new RuntimeException("Not implemented");
	}
	
	@Override
	protected void onReveal() {
		super.onReveal();
		setInSlot(SLOT_BODYMENU, editClassPresenter);
		getClassDetails();
	}
	
	@Override
	public void onBind() {
		super.onBind();
		/*setCollectionAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo collectionDo) {
				try{
					if (collectionDo.getMeta().getPermissions().toString().contains("edit")){
						isApiCalled = true;
						getView().setData(collectionDo);
					}else{
						isApiCalled = false;
						ErrorPopup error = new ErrorPopup(i18n.GL0341());
						error.center();
						error.show();
					}
				}catch(Exception e){
					AppClientFactory.printSevereLogger(e.getMessage());
				}
			}
		});*/
	}
	
	@Override
	protected void onReset() {
       super.onReset();
	}
	
	public void getClassDetails(){
		classpageId = getPlaceManager().getRequestParameter("classpageid");
		String pageSize = getPlaceManager().getRequestParameter("pageSize");
		String pageNum = getPlaceManager().getRequestParameter("pageNum");
		String pos = getPlaceManager().getRequestParameter("pos");
		//getView().setClasspageId(classpageId);
		//getView().getClasspageById(classpageId, pageSize, pageNum, pos);
		//getClasspageService.getCl
		
	}

	/** 
	 * This method is to get the collectionAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionDo> getCollectionAsyncCallback() {
		return collectionAsyncCallback;
	}

	/** 
	 * This method is to set the collectionAsyncCallback
	 */
	public void setCollectionAsyncCallback(SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}

}
