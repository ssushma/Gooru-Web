package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AssignmentDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static org.ednovo.gooru.shared.model.content.AttachToDo getAttachTo(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (org.ednovo.gooru.shared.model.content.AttachToDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "attachTo");
  }
  
  private static void setAttachTo(org.ednovo.gooru.shared.model.content.AssignmentDo instance, org.ednovo.gooru.shared.model.content.AttachToDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "attachTo", value);
  }
  
  private static java.lang.String getClasspageId(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "classpageId");
  }
  
  private static void setClasspageId(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "classpageId", value);
  }
  
  private static java.lang.String getCreatedDate(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "createdDate");
  }
  
  private static void setCreatedDate(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "createdDate", value);
  }
  
  private static java.lang.String getDescription(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "description");
  }
  
  private static void setDescription(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "description", value);
  }
  
  private static java.lang.String getEstimatedEffort(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "estimatedEffort");
  }
  
  private static void setEstimatedEffort(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "estimatedEffort", value);
  }
  
  private static java.lang.String getLastModifiedDate(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "lastModifiedDate");
  }
  
  private static void setLastModifiedDate(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "lastModifiedDate", value);
  }
  
  private static java.lang.String getModifiedBy(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "modifiedBy");
  }
  
  private static void setModifiedBy(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "modifiedBy", value);
  }
  
  private static java.lang.String getPlannedEndDate(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "plannedEndDate");
  }
  
  private static void setPlannedEndDate(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "plannedEndDate", value);
  }
  
  private static java.lang.String getPlannedStartDate(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "plannedStartDate");
  }
  
  private static void setPlannedStartDate(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "plannedStartDate", value);
  }
  
  private static java.lang.String getStatus(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "status");
  }
  
  private static void setStatus(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "status", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.TaskDo getTask(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (org.ednovo.gooru.shared.model.content.TaskDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "task");
  }
  
  private static void setTask(org.ednovo.gooru.shared.model.content.AssignmentDo instance, org.ednovo.gooru.shared.model.content.TaskDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "task", value);
  }
  
  private static java.lang.String getTaskUid(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "taskUid");
  }
  
  private static void setTaskUid(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "taskUid", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "title", value);
  }
  
  private static java.lang.String getTypeName(org.ednovo.gooru.shared.model.content.AssignmentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "typeName");
  }
  
  private static void setTypeName(org.ednovo.gooru.shared.model.content.AssignmentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentDo.class, instance, "typeName", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.AssignmentDo instance) throws SerializationException {
    setAttachTo(instance, (org.ednovo.gooru.shared.model.content.AttachToDo) streamReader.readObject());
    setClasspageId(instance, streamReader.readString());
    setCreatedDate(instance, streamReader.readString());
    setDescription(instance, streamReader.readString());
    setEstimatedEffort(instance, streamReader.readString());
    setLastModifiedDate(instance, streamReader.readString());
    setModifiedBy(instance, streamReader.readString());
    setPlannedEndDate(instance, streamReader.readString());
    setPlannedStartDate(instance, streamReader.readString());
    setStatus(instance, streamReader.readString());
    setTask(instance, (org.ednovo.gooru.shared.model.content.TaskDo) streamReader.readObject());
    setTaskUid(instance, streamReader.readString());
    setTitle(instance, streamReader.readString());
    setTypeName(instance, streamReader.readString());
    
    org.ednovo.gooru.shared.model.content.TaskDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.content.AssignmentDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.AssignmentDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.AssignmentDo instance) throws SerializationException {
    streamWriter.writeObject(getAttachTo(instance));
    streamWriter.writeString(getClasspageId(instance));
    streamWriter.writeString(getCreatedDate(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getEstimatedEffort(instance));
    streamWriter.writeString(getLastModifiedDate(instance));
    streamWriter.writeString(getModifiedBy(instance));
    streamWriter.writeString(getPlannedEndDate(instance));
    streamWriter.writeString(getPlannedStartDate(instance));
    streamWriter.writeString(getStatus(instance));
    streamWriter.writeObject(getTask(instance));
    streamWriter.writeString(getTaskUid(instance));
    streamWriter.writeString(getTitle(instance));
    streamWriter.writeString(getTypeName(instance));
    
    org.ednovo.gooru.shared.model.content.TaskDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.AssignmentDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.AssignmentDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.AssignmentDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.AssignmentDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.AssignmentDo)object);
  }
  
}
