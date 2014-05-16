package org.ednovo.gooru.client.mvp.shelf;

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

public class ShelfPresenterIsShelfProxyImpl extends com.gwtplatform.mvp.client.proxy.ProxyPlaceImpl<ShelfPresenter> implements org.ednovo.gooru.client.mvp.shelf.ShelfPresenter.IsShelfProxy, com.gwtplatform.mvp.client.DelayedBind {
  
  private org.ednovo.gooru.client.gin.AppInjector ginjector;
  
  public static class WrappedProxy
  extends com.gwtplatform.mvp.client.proxy.ProxyImpl<ShelfPresenter> implements com.gwtplatform.mvp.client.DelayedBind {
    
    private org.ednovo.gooru.client.gin.AppInjector ginjector;
    
    public WrappedProxy() {
    }
    
    @Override
    public void delayedBind(Ginjector baseGinjector) {
      ginjector = (org.ednovo.gooru.client.gin.AppInjector)baseGinjector;
      bind(ginjector.getPlaceManager(),
          ginjector.getEventBus());
      presenter = new CodeSplitProvider<ShelfPresenter>( ginjector.getShelfPresenter() );
      
      RevealContentHandler<ShelfPresenter> revealContentHandler = new RevealContentHandler<ShelfPresenter>( eventBus, this );
      getEventBus().addHandler( ShelfPresenter.TYPE_SHELF_TAB, revealContentHandler );
      getEventBus().addHandler( ShelfPresenter.TYPE_COLLECTION_RESOURCE_TAB, revealContentHandler );
      getEventBus().addHandler( ShelfPresenter.TYPE_COLLECTION_INFO_TAB, revealContentHandler );
      getEventBus().addHandler( ShelfPresenter.TYPE_ASSIGN_INFO_TAB, revealContentHandler );
      getEventBus().addHandler( ShelfPresenter.TYPE_COLLABORATOR_TAB, revealContentHandler );
      getEventBus().addHandler( ShelfPresenter.TYPE_FOLDERS_SLOT, revealContentHandler );
    }
  }
  
  public ShelfPresenterIsShelfProxyImpl() {
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
    String nameToken = "organize"; 
    place = new com.gwtplatform.mvp.client.proxy.PlaceWithGatekeeper( nameToken, ginjector.getAppPlaceKeeper() );
  }
}
