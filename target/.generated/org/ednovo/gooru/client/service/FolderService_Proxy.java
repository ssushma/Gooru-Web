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

public class FolderService_Proxy extends RemoteServiceProxy implements org.ednovo.gooru.client.service.FolderServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.ednovo.gooru.client.service.FolderService";
  private static final String SERIALIZATION_POLICY ="ACC151AA8DAB668309CFA85301681BDF";
  private static final org.ednovo.gooru.client.service.FolderService_TypeSerializer SERIALIZER = new org.ednovo.gooru.client.service.FolderService_TypeSerializer();
  
  public FolderService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "gwt-service/folderService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void copyDraggedCollectionIntoFolder(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String courseCodeId, java.lang.String parentId, boolean addToShelf, com.google.gwt.user.client.rpc.AsyncCallback simpleAsyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "copyDraggedCollectionIntoFolder");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 4);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("Z");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(courseCodeId);
      streamWriter.writeString(parentId);
      streamWriter.writeBoolean(addToShelf);
      helper.finish(simpleAsyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      simpleAsyncCallback.onFailure(ex);
    }
  }
  
  public void createCollectionInParent(org.ednovo.gooru.shared.model.content.CollectionDo data, java.lang.String courseCodeId, java.lang.String folderId, com.google.gwt.user.client.rpc.AsyncCallback simpleAsyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "createCollectionInParent");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(data);
      streamWriter.writeString(courseCodeId);
      streamWriter.writeString(folderId);
      helper.finish(simpleAsyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      simpleAsyncCallback.onFailure(ex);
    }
  }
  
  public void createFolder(java.lang.String folderName, java.lang.String parentId, boolean addToShelf, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "createFolder");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("Z");
      streamWriter.writeString(folderName);
      streamWriter.writeString(parentId);
      streamWriter.writeBoolean(addToShelf);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void createFolder(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "createFolder");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeObject(collectionDo);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void createFolderToParentFolder(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String parentId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "createFolderToParentFolder");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(parentId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteCollectionsFolder(java.lang.String folderId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "deleteCollectionsFolder");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(folderId);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteFolder(java.lang.String collectionId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "deleteFolder");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionId);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getAllFolders(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "getAllFolders");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getChildFolders(int offset, int limit, java.lang.String parentId, java.lang.String sharingType, java.lang.String collectionType, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "getChildFolders");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 5);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeInt(offset);
      streamWriter.writeInt(limit);
      streamWriter.writeString(parentId);
      streamWriter.writeString(sharingType);
      streamWriter.writeString(collectionType);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getCollectionResources(java.lang.String parentId, java.lang.String sharingType, java.lang.String collectionType, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "getCollectionResources");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(parentId);
      streamWriter.writeString(sharingType);
      streamWriter.writeString(collectionType);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getFolderInformation(java.lang.String folderId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "getFolderInformation");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(folderId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getFolders(java.lang.String collectionId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "getFolders");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void moveCollectionIntoFolder(java.lang.String sourceId, java.lang.String targetId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "moveCollectionIntoFolder");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(sourceId);
      streamWriter.writeString(targetId);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void updateFolder(java.lang.String folderId, java.lang.String title, java.lang.String ideas, java.lang.String questions, java.lang.String performance, com.google.gwt.user.client.rpc.AsyncCallback simpleAsyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("FolderService_Proxy", "updateFolder");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 5);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(folderId);
      streamWriter.writeString(title);
      streamWriter.writeString(ideas);
      streamWriter.writeString(questions);
      streamWriter.writeString(performance);
      helper.finish(simpleAsyncCallback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      simpleAsyncCallback.onFailure(ex);
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
