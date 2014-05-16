package org.ednovo.gooru.client.mvp.folders.edit;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.proxy.NotifyingAsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.common.client.StandardProvider;
import com.gwtplatform.common.client.CodeSplitProvider;
import com.gwtplatform.common.client.CodeSplitBundleProvider;
import com.gwtplatform.mvp.client.proxy.ProxyImpl;
import com.gwtplatform.mvp.client.proxy.ProxyPlaceImpl;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.DelayedBind;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlaceImpl;
import com.gwtplatform.mvp.client.DelayedBindRegistry;
import com.google.gwt.inject.client.Ginjector;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.TabDataBasic;

public class EditFolderPresenterIsEditFolderProxyImpl extends com.gwtplatform.mvp.client.proxy.ProxyPlaceImpl<EditFolderPresenter> implements org.ednovo.gooru.client.mvp.folders.edit.EditFolderPresenter.IsEditFolderProxy, com.gwtplatform.mvp.client.DelayedBind {
  
  private org.ednovo.gooru.client.gin.AppInjector ginjector;
  
  public static class WrappedProxy
  extends com.gwtplatform.mvp.client.proxy.ProxyImpl<EditFolderPresenter> implements com.gwtplatform.mvp.client.DelayedBind {
    
    private org.ednovo.gooru.client.gin.AppInjector ginjector;
    
    public WrappedProxy() {
    }
    
    @Override
    public void delayedBind(Ginjector baseGinjector) {
      ginjector = (org.ednovo.gooru.client.gin.AppInjector)baseGinjector;
      bind(ginjector.getPlaceManager(),
          ginjector.getEventBus());
      presenter = new CodeSplitProvider<EditFolderPresenter>( ginjector.getEditFolderPresenter() );
      
      RevealContentHandler<EditFolderPresenter> revealContentHandler = new RevealContentHandler<EditFolderPresenter>( eventBus, this );
      getEventBus().addHandler( EditFolderPresenter.TYPE_FOLDER_INFO_TAB, revealContentHandler );
      getEventBus().addHandler( EditFolderPresenter.TYPE_FOLDER_CONTENT_TAB, revealContentHandler );
      getEventBus().addHandler( EditFolderPresenter.TYPE_FOLDERS_SHELF_VIEW, revealContentHandler );
    }
  }
  
  public EditFolderPresenterIsEditFolderProxyImpl() {
    DelayedBindRegistry.register(this);
  }
  
  @Override
  public void delayedBind(Ginjector baseGinjector) {
    ginjector = (org.ednovo.gooru.client.gin.AppInjector)baseGinjector;
    bind(ginjector.getPlaceManager(),
        ginjector.getEventBus());
    WrappedProxy wrappedProxy = GWT.create(WrappedProxy.class);
    wrappedProxy.delayedBind( ginjector ); 
    proxy = wrappedProxy; 
    String nameToken = "organize-folder"; 
    place = new com.gwtplatform.mvp.client.proxy.PlaceWithGatekeeper( nameToken, ginjector.getAppPlaceKeeper() );
  }
}
