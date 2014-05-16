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

public class ResourceService_Proxy extends RemoteServiceProxy implements org.ednovo.gooru.client.service.ResourceServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.ednovo.gooru.client.service.ResourceService";
  private static final String SERIALIZATION_POLICY ="F6AEEFF0041C0B608277A4F15E65AE87";
  private static final org.ednovo.gooru.client.service.ResourceService_TypeSerializer SERIALIZER = new org.ednovo.gooru.client.service.ResourceService_TypeSerializer();
  
  public ResourceService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "gwt-service/resourceService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void UpdateResourceTaxonomy(java.lang.String resourceId, java.util.Set taxonomyObj, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "UpdateResourceTaxonomy");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.util.Set");
      streamWriter.writeString(resourceId);
      streamWriter.writeObject(taxonomyObj);
      helper.finish(asyncCallback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void addCollaborator(java.lang.String gooruOid, java.lang.String collaboratorId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "addCollaborator");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(gooruOid);
      streamWriter.writeString(collaboratorId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void addNewResource(java.lang.String gooruOid, java.lang.String idStr, java.lang.String urlStr, java.lang.String titleStr, java.lang.String descriptionStr, java.lang.String categoryStr, java.lang.String thumbnailImgSrcStr, java.lang.Integer endTime, java.lang.String edcuationalUse, java.lang.String momentsOfLearning, java.util.List standards, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "addNewResource");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 11);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.util.List");
      streamWriter.writeString(gooruOid);
      streamWriter.writeString(idStr);
      streamWriter.writeString(urlStr);
      streamWriter.writeString(titleStr);
      streamWriter.writeString(descriptionStr);
      streamWriter.writeString(categoryStr);
      streamWriter.writeString(thumbnailImgSrcStr);
      streamWriter.writeObject(endTime);
      streamWriter.writeString(edcuationalUse);
      streamWriter.writeString(momentsOfLearning);
      streamWriter.writeObject(standards);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void addNewUserResource(java.lang.String jsonString, java.lang.String gooruOid, com.google.gwt.user.client.rpc.AsyncCallback userResourceCollectionItemAsyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "addNewUserResource");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(jsonString);
      streamWriter.writeString(gooruOid);
      helper.finish(userResourceCollectionItemAsyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      userResourceCollectionItemAsyncCallback.onFailure(ex);
    }
  }
  
  public void addQuestionResource(java.lang.String collectionId, java.lang.String mediafileName, org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo collectionQuestionItemDo, com.google.gwt.user.client.rpc.AsyncCallback addQuestionResourceAsyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "addQuestionResource");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo/4142923319");
      streamWriter.writeString(collectionId);
      streamWriter.writeString(mediafileName);
      streamWriter.writeObject(collectionQuestionItemDo);
      helper.finish(addQuestionResourceAsyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      addQuestionResourceAsyncCallback.onFailure(ex);
    }
  }
  
  public void checkProfanity(java.util.Map parms, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "checkProfanity");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.util.Map");
      streamWriter.writeObject(parms);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void checkProfanityForList(java.util.List parms, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "checkProfanityForList");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.util.List");
      streamWriter.writeObject(parms);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void checkResourceExists(java.lang.String url, com.google.gwt.user.client.rpc.AsyncCallback resoureCheckAsyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "checkResourceExists");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(url);
      helper.finish(resoureCheckAsyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      resoureCheckAsyncCallback.onFailure(ex);
    }
  }
  
  public void checkShortenUrl(java.lang.String url, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "checkShortenUrl");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(url);
      helper.finish(asyncCallback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void copyCollection(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String addToShelf, java.lang.String taxonomyCode, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "copyCollection");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(addToShelf);
      streamWriter.writeString(taxonomyCode);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void copyCollectionItem(java.lang.String collectionId, java.lang.String resourceId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "copyCollectionItem");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionId);
      streamWriter.writeString(resourceId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void createCollection(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String codeId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "createCollection");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(codeId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void createCollectionItem(java.lang.String collectionId, java.lang.String resourceId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "createCollectionItem");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionId);
      streamWriter.writeString(resourceId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void createCollectionWithItem(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String codeId, java.lang.String resourceId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "createCollectionWithItem");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(codeId);
      streamWriter.writeString(resourceId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void createContentReport(java.lang.String assocGooruOid, java.lang.String targetValue, java.lang.String typesvalue1, java.lang.String typesvalue2, java.lang.String typesvalue3, java.lang.String typesvalue4, java.lang.String otherDescription, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "createContentReport");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 7);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(assocGooruOid);
      streamWriter.writeString(targetValue);
      streamWriter.writeString(typesvalue1);
      streamWriter.writeString(typesvalue2);
      streamWriter.writeString(typesvalue3);
      streamWriter.writeString(typesvalue4);
      streamWriter.writeString(otherDescription);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteCollaborators(java.lang.String gooruOid, java.lang.String collaboratorId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "deleteCollaborators");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(gooruOid);
      streamWriter.writeString(collaboratorId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteCollection(java.lang.String collectionId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "deleteCollection");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionId);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteCollectionItem(java.lang.String collectionItemId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "deleteCollectionItem");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionItemId);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteContentReport(java.lang.String gooruOid, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "deleteContentReport");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(gooruOid);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteTaxonomyResource(java.lang.String resourceId, java.lang.Integer codeId, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "deleteTaxonomyResource");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeString(resourceId);
      streamWriter.writeObject(codeId);
      helper.finish(asyncCallback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void getCollaborators(java.lang.String gooruOid, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "getCollaborators");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(gooruOid);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getCollection(java.lang.String collectionGooruOid, boolean skipCollectionItem, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "getCollection");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("Z");
      streamWriter.writeString(collectionGooruOid);
      streamWriter.writeBoolean(skipCollectionItem);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getCollectionInfoV2API(java.lang.String collectionId, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "getCollectionInfoV2API");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionId);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void getContentReport(java.lang.String assocGooruOid, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "getContentReport");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(assocGooruOid);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getFolderWorkspace(int offset, int limit, java.lang.String sharingType, java.lang.String collectionType, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "getFolderWorkspace");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 4);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeInt(offset);
      streamWriter.writeInt(limit);
      streamWriter.writeString(sharingType);
      streamWriter.writeString(collectionType);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getPermissions(java.lang.String CollectionId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "getPermissions");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(CollectionId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getResourceMetaInfo(java.lang.String url, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "getResourceMetaInfo");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(url);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getUserCollection(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "getUserCollection");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getUserCollectionList(java.lang.Integer pageSize, java.lang.Integer pageNum, boolean isSharable, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "getUserCollectionList");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeString("Z");
      streamWriter.writeObject(pageSize);
      streamWriter.writeObject(pageNum);
      streamWriter.writeBoolean(isSharable);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getYoutubeDuration(java.lang.String videoId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "getYoutubeDuration");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(videoId);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void removeQuestionImage(java.lang.String collectionQuestionId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "removeQuestionImage");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionQuestionId);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void reorderCollectionItem(org.ednovo.gooru.shared.model.content.CollectionItemDo collectionItemDo, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "reorderCollectionItem");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionItemDo/1047684462");
      streamWriter.writeObject(collectionItemDo);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveUserOwnResource(java.lang.String filePath, com.google.gwt.user.client.rpc.AsyncCallback simpleAsyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "saveUserOwnResource");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(filePath);
      helper.finish(simpleAsyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      simpleAsyncCallback.onFailure(ex);
    }
  }
  
  public void updateCollectionAudience(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String instructionMethod, java.lang.Boolean selectedVal, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateCollectionAudience");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.Boolean/476441737");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(instructionMethod);
      streamWriter.writeObject(selectedVal);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void updateCollectionDepthOfKnowledge(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String depthOfKnowledge, java.lang.Boolean selectedVal, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateCollectionDepthOfKnowledge");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.Boolean/476441737");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(depthOfKnowledge);
      streamWriter.writeObject(selectedVal);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void updateCollectionInfo(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String teacherTips, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateCollectionInfo");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(teacherTips);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void updateCollectionInstructionalMethod(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String instructionMethod, java.lang.Boolean selectedVal, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateCollectionInstructionalMethod");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.Boolean/476441737");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(instructionMethod);
      streamWriter.writeObject(selectedVal);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void updateCollectionItemMetadata(java.lang.String collectionItemId, java.lang.String narration, java.lang.String narrationType, java.lang.String start, java.lang.String stop, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateCollectionItemMetadata");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 5);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionItemId);
      streamWriter.writeString(narration);
      streamWriter.writeString(narrationType);
      streamWriter.writeString(start);
      streamWriter.writeString(stop);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void updateCollectionLanguageObjective(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String languageObjective, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateCollectionLanguageObjective");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(languageObjective);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void updateCollectionLearningSkills(org.ednovo.gooru.shared.model.content.CollectionDo collectionDo, java.lang.String depthOfKnowledge, java.lang.Boolean selectedVal, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateCollectionLearningSkills");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.Boolean/476441737");
      streamWriter.writeObject(collectionDo);
      streamWriter.writeString(depthOfKnowledge);
      streamWriter.writeObject(selectedVal);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void updateCollectionMetadata(java.lang.String collectionId, java.lang.String title, java.lang.String description, java.lang.String grade, java.lang.String sharing, java.lang.String vocabulary, java.lang.String taxonomyCode, java.lang.String updateTaxonomyByCode, java.lang.String mediaType, java.lang.String action, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateCollectionMetadata");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 10);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionId);
      streamWriter.writeString(title);
      streamWriter.writeString(description);
      streamWriter.writeString(grade);
      streamWriter.writeString(sharing);
      streamWriter.writeString(vocabulary);
      streamWriter.writeString(taxonomyCode);
      streamWriter.writeString(updateTaxonomyByCode);
      streamWriter.writeString(mediaType);
      streamWriter.writeString(action);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void updateNarrationMetadata(java.lang.String collectionItemId, java.lang.String narration, java.lang.String narrationType, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateNarrationMetadata");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionItemId);
      streamWriter.writeString(narration);
      streamWriter.writeString(narrationType);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void updateQuestionImage(java.lang.String collectionItemId, java.lang.String fileName, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateQuestionImage");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(collectionItemId);
      streamWriter.writeString(fileName);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void updateQuestionResource(org.ednovo.gooru.shared.model.content.CollectionItemDo collectionItemDo, org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo collectionQuestionItemDo, java.lang.String thumbnailUrl, com.google.gwt.user.client.rpc.AsyncCallback updateQuestionItemResourceAsyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateQuestionResource");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionItemDo/1047684462");
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo/4142923319");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(collectionItemDo);
      streamWriter.writeObject(collectionQuestionItemDo);
      streamWriter.writeString(thumbnailUrl);
      helper.finish(updateQuestionItemResourceAsyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      updateQuestionItemResourceAsyncCallback.onFailure(ex);
    }
  }
  
  public void updateReport(java.lang.String gooruOid, java.lang.String freeText, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateReport");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(gooruOid);
      streamWriter.writeString(freeText);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void updateResourceInfo(org.ednovo.gooru.shared.model.content.CollectionItemDo collectionItemDo, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateResourceInfo");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("org.ednovo.gooru.shared.model.content.CollectionItemDo/1047684462");
      streamWriter.writeObject(collectionItemDo);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void updateUserOwnResource(java.lang.String jsonString, java.lang.String gooruOid, com.google.gwt.user.client.rpc.AsyncCallback simpleAsyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ResourceService_Proxy", "updateUserOwnResource");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(jsonString);
      streamWriter.writeString(gooruOid);
      helper.finish(simpleAsyncCallback, ResponseReader.OBJECT);
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
