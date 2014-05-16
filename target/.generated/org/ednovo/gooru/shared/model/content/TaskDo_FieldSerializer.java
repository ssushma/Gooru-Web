package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TaskDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCreatedOn(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "createdOn");
  }
  
  private static void setCreatedOn(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "createdOn", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.UserDo getCreator(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (org.ednovo.gooru.shared.model.user.UserDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "creator");
  }
  
  private static void setCreator(org.ednovo.gooru.shared.model.content.TaskDo instance, org.ednovo.gooru.shared.model.user.UserDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "creator", value);
  }
  
  private static java.lang.String getDescription(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "description");
  }
  
  private static void setDescription(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "description", value);
  }
  
  private static java.lang.String getEstimatedEffort(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "estimatedEffort");
  }
  
  private static void setEstimatedEffort(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "estimatedEffort", value);
  }
  
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "gooruOid", value);
  }
  
  private static java.lang.String getLastModified(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "lastModified");
  }
  
  private static void setLastModified(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "lastModified", value);
  }
  
  private static java.lang.String getLastUpdatedUserUid(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "lastUpdatedUserUid");
  }
  
  private static void setLastUpdatedUserUid(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "lastUpdatedUserUid", value);
  }
  
  private static java.lang.String getPlannedEndDate(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "plannedEndDate");
  }
  
  private static void setPlannedEndDate(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "plannedEndDate", value);
  }
  
  private static java.lang.String getPlannedStartDate(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "plannedStartDate");
  }
  
  private static void setPlannedStartDate(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "plannedStartDate", value);
  }
  
  private static java.lang.String getSharing(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "sharing");
  }
  
  private static void setSharing(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "sharing", value);
  }
  
  private static java.lang.String getStatus(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "status");
  }
  
  private static void setStatus(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "status", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "title", value);
  }
  
  private static java.lang.String getTypeName(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "typeName");
  }
  
  private static void setTypeName(org.ednovo.gooru.shared.model.content.TaskDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "typeName", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.UserDo getUser(org.ednovo.gooru.shared.model.content.TaskDo instance) {
    return (org.ednovo.gooru.shared.model.user.UserDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "user");
  }
  
  private static void setUser(org.ednovo.gooru.shared.model.content.TaskDo instance, org.ednovo.gooru.shared.model.user.UserDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskDo.class, instance, "user", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.TaskDo instance) throws SerializationException {
    setCreatedOn(instance, streamReader.readString());
    setCreator(instance, (org.ednovo.gooru.shared.model.user.UserDo) streamReader.readObject());
    setDescription(instance, streamReader.readString());
    setEstimatedEffort(instance, streamReader.readString());
    setGooruOid(instance, streamReader.readString());
    setLastModified(instance, streamReader.readString());
    setLastUpdatedUserUid(instance, streamReader.readString());
    setPlannedEndDate(instance, streamReader.readString());
    setPlannedStartDate(instance, streamReader.readString());
    setSharing(instance, streamReader.readString());
    setStatus(instance, streamReader.readString());
    setTitle(instance, streamReader.readString());
    setTypeName(instance, streamReader.readString());
    setUser(instance, (org.ednovo.gooru.shared.model.user.UserDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.TaskDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.TaskDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.TaskDo instance) throws SerializationException {
    streamWriter.writeString(getCreatedOn(instance));
    streamWriter.writeObject(getCreator(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getEstimatedEffort(instance));
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeString(getLastModified(instance));
    streamWriter.writeString(getLastUpdatedUserUid(instance));
    streamWriter.writeString(getPlannedEndDate(instance));
    streamWriter.writeString(getPlannedStartDate(instance));
    streamWriter.writeString(getSharing(instance));
    streamWriter.writeString(getStatus(instance));
    streamWriter.writeString(getTitle(instance));
    streamWriter.writeString(getTypeName(instance));
    streamWriter.writeObject(getUser(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.TaskDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.TaskDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.TaskDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.TaskDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.TaskDo)object);
  }
  
}
