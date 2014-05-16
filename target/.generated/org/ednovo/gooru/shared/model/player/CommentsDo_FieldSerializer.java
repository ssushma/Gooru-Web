package org.ednovo.gooru.shared.model.player;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CommentsDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getComment(org.ednovo.gooru.shared.model.player.CommentsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "comment");
  }
  
  private static void setComment(org.ednovo.gooru.shared.model.player.CommentsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "comment", value);
  }
  
  private static java.lang.String getCommentUid(org.ednovo.gooru.shared.model.player.CommentsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "commentUid");
  }
  
  private static void setCommentUid(org.ednovo.gooru.shared.model.player.CommentsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "commentUid", value);
  }
  
  private static org.ednovo.gooru.shared.model.player.CommentsUserInfoDo getCommentorUid(org.ednovo.gooru.shared.model.player.CommentsDo instance) {
    return (org.ednovo.gooru.shared.model.player.CommentsUserInfoDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "commentorUid");
  }
  
  private static void setCommentorUid(org.ednovo.gooru.shared.model.player.CommentsDo instance, org.ednovo.gooru.shared.model.player.CommentsUserInfoDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "commentorUid", value);
  }
  
  private static java.lang.String getCreatedOn(org.ednovo.gooru.shared.model.player.CommentsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "createdOn");
  }
  
  private static void setCreatedOn(org.ednovo.gooru.shared.model.player.CommentsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "createdOn", value);
  }
  
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.player.CommentsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.player.CommentsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "gooruOid", value);
  }
  
  private static java.lang.String getLastModifiedOn(org.ednovo.gooru.shared.model.player.CommentsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "lastModifiedOn");
  }
  
  private static void setLastModifiedOn(org.ednovo.gooru.shared.model.player.CommentsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "lastModifiedOn", value);
  }
  
  private static java.lang.Integer getStatusCode(org.ednovo.gooru.shared.model.player.CommentsDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "statusCode");
  }
  
  private static void setStatusCode(org.ednovo.gooru.shared.model.player.CommentsDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsDo.class, instance, "statusCode", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.player.CommentsDo instance) throws SerializationException {
    setComment(instance, streamReader.readString());
    setCommentUid(instance, streamReader.readString());
    setCommentorUid(instance, (org.ednovo.gooru.shared.model.player.CommentsUserInfoDo) streamReader.readObject());
    setCreatedOn(instance, streamReader.readString());
    setGooruOid(instance, streamReader.readString());
    setLastModifiedOn(instance, streamReader.readString());
    setStatusCode(instance, (java.lang.Integer) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.player.CommentsDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.player.CommentsDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.player.CommentsDo instance) throws SerializationException {
    streamWriter.writeString(getComment(instance));
    streamWriter.writeString(getCommentUid(instance));
    streamWriter.writeObject(getCommentorUid(instance));
    streamWriter.writeString(getCreatedOn(instance));
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeString(getLastModifiedOn(instance));
    streamWriter.writeObject(getStatusCode(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.player.CommentsDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.player.CommentsDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.player.CommentsDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.player.CommentsDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.player.CommentsDo)object);
  }
  
}
