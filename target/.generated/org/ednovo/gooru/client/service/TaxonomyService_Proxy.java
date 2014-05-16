package org.ednovo.gooru.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class TaxonomyService_Proxy extends RemoteServiceProxy implements org.ednovo.gooru.client.service.TaxonomyServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.ednovo.gooru.client.service.TaxonomyService";
  private static final String SERIALIZATION_POLICY ="9B57CCF917EB65142A840B7CF62FC726";
  private static final org.ednovo.gooru.client.service.TaxonomyService_TypeSerializer SERIALIZER = new org.ednovo.gooru.client.service.TaxonomyService_TypeSerializer();
  
  public TaxonomyService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "gwt-service/taxonomyService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void getCourse(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("TaxonomyService_Proxy", "getCourse");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
