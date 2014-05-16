package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CollaboratorsDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAssociatedDate(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "associatedDate");
  }
  
  private static void setAssociatedDate(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "associatedDate", value);
  }
  
  private static java.lang.String getEmail(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "email");
  }
  
  private static void setEmail(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "email", value);
  }
  
  private static java.lang.String getEmailId(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "emailId");
  }
  
  private static void setEmailId(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "emailId", value);
  }
  
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "gooruOid", value);
  }
  
  private static java.lang.String getGooruUid(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "gooruUid");
  }
  
  private static void setGooruUid(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "gooruUid", value);
  }
  
  private static java.lang.String getProfileImageUrl(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "profileImageUrl");
  }
  
  private static void setProfileImageUrl(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "profileImageUrl", value);
  }
  
  private static java.lang.String getStatus(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "status");
  }
  
  private static void setStatus(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "status", value);
  }
  
  private static java.lang.String getUsername(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "username");
  }
  
  private static void setUsername(org.ednovo.gooru.shared.model.content.CollaboratorsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollaboratorsDo.class, instance, "username", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.CollaboratorsDo instance) throws SerializationException {
    setAssociatedDate(instance, streamReader.readString());
    setEmail(instance, streamReader.readString());
    setEmailId(instance, streamReader.readString());
    setGooruOid(instance, streamReader.readString());
    setGooruUid(instance, streamReader.readString());
    setProfileImageUrl(instance, streamReader.readString());
    setStatus(instance, streamReader.readString());
    setUsername(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.CollaboratorsDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.CollaboratorsDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.CollaboratorsDo instance) throws SerializationException {
    streamWriter.writeString(getAssociatedDate(instance));
    streamWriter.writeString(getEmail(instance));
    streamWriter.writeString(getEmailId(instance));
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeString(getGooruUid(instance));
    streamWriter.writeString(getProfileImageUrl(instance));
    streamWriter.writeString(getStatus(instance));
    streamWriter.writeString(getUsername(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.CollaboratorsDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.CollaboratorsDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.CollaboratorsDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.CollaboratorsDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.CollaboratorsDo)object);
  }
  
}
