package org.ednovo.gooru.shared.model.player;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CommentsUserInfoDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCreatedOn(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "createdOn");
  }
  
  private static void setCreatedOn(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "createdOn", value);
  }
  
  private static java.lang.String getFirstName(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "firstName");
  }
  
  private static void setFirstName(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "firstName", value);
  }
  
  private static java.lang.String getGooruUId(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "gooruUId");
  }
  
  private static void setGooruUId(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "gooruUId", value);
  }
  
  private static java.lang.Boolean getIsDeleted(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance) {
    return (java.lang.Boolean) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "isDeleted");
  }
  
  private static void setIsDeleted(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance, java.lang.Boolean value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "isDeleted", value);
  }
  
  private static java.lang.String getLastName(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "lastName");
  }
  
  private static void setLastName(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "lastName", value);
  }
  
  private static java.lang.String getUsername(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "username");
  }
  
  private static void setUsername(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "username", value);
  }
  
  private static java.lang.String getUsernameDisplay(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "usernameDisplay");
  }
  
  private static void setUsernameDisplay(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsUserInfoDo.class, instance, "usernameDisplay", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance) throws SerializationException {
    setCreatedOn(instance, streamReader.readString());
    setFirstName(instance, streamReader.readString());
    setGooruUId(instance, streamReader.readString());
    setIsDeleted(instance, (java.lang.Boolean) streamReader.readObject());
    setLastName(instance, streamReader.readString());
    setUsername(instance, streamReader.readString());
    setUsernameDisplay(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.player.CommentsUserInfoDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.player.CommentsUserInfoDo instance) throws SerializationException {
    streamWriter.writeString(getCreatedOn(instance));
    streamWriter.writeString(getFirstName(instance));
    streamWriter.writeString(getGooruUId(instance));
    streamWriter.writeObject(getIsDeleted(instance));
    streamWriter.writeString(getLastName(instance));
    streamWriter.writeString(getUsername(instance));
    streamWriter.writeString(getUsernameDisplay(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.player.CommentsUserInfoDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.player.CommentsUserInfoDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.player.CommentsUserInfoDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.player.CommentsUserInfoDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.player.CommentsUserInfoDo)object);
  }
  
}
