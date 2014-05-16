package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TaskResourceAssocDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAssociationDate(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo.class, instance, "associationDate");
  }
  
  private static void setAssociationDate(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo.class, instance, "associationDate", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceDo getResource(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo.class, instance, "resource");
  }
  
  private static void setResource(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance, org.ednovo.gooru.shared.model.content.ResourceDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo.class, instance, "resource", value);
  }
  
  private static java.lang.Integer getSequence(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo.class, instance, "sequence");
  }
  
  private static void setSequence(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo.class, instance, "sequence", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.TaskDo getTask(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance) {
    return (org.ednovo.gooru.shared.model.content.TaskDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo.class, instance, "task");
  }
  
  private static void setTask(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance, org.ednovo.gooru.shared.model.content.TaskDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo.class, instance, "task", value);
  }
  
  private static java.lang.String getTaskResourceAssocUid(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo.class, instance, "taskResourceAssocUid");
  }
  
  private static void setTaskResourceAssocUid(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TaskResourceAssocDo.class, instance, "taskResourceAssocUid", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance) throws SerializationException {
    setAssociationDate(instance, streamReader.readString());
    setResource(instance, (org.ednovo.gooru.shared.model.content.ResourceDo) streamReader.readObject());
    setSequence(instance, (java.lang.Integer) streamReader.readObject());
    setTask(instance, (org.ednovo.gooru.shared.model.content.TaskDo) streamReader.readObject());
    setTaskResourceAssocUid(instance, streamReader.readString());
    
    org.ednovo.gooru.shared.model.content.TaskDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.TaskResourceAssocDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.TaskResourceAssocDo instance) throws SerializationException {
    streamWriter.writeString(getAssociationDate(instance));
    streamWriter.writeObject(getResource(instance));
    streamWriter.writeObject(getSequence(instance));
    streamWriter.writeObject(getTask(instance));
    streamWriter.writeString(getTaskResourceAssocUid(instance));
    
    org.ednovo.gooru.shared.model.content.TaskDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.TaskResourceAssocDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.TaskResourceAssocDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.TaskResourceAssocDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.TaskResourceAssocDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.TaskResourceAssocDo)object);
  }
  
}
