package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AssignmentsSearchDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCollectionTaskAssocUid(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo.class, instance, "collectionTaskAssocUid");
  }
  
  private static void setCollectionTaskAssocUid(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo.class, instance, "collectionTaskAssocUid", value);
  }
  
  private static java.lang.Integer getSequence(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo.class, instance, "sequence");
  }
  
  private static void setSequence(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo.class, instance, "sequence", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.TaskDo getTask(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo instance) {
    return (org.ednovo.gooru.shared.model.content.TaskDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo.class, instance, "task");
  }
  
  private static void setTask(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo instance, org.ednovo.gooru.shared.model.content.TaskDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentsSearchDo.class, instance, "task", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.AssignmentsSearchDo instance) throws SerializationException {
    setCollectionTaskAssocUid(instance, streamReader.readString());
    setSequence(instance, (java.lang.Integer) streamReader.readObject());
    setTask(instance, (org.ednovo.gooru.shared.model.content.TaskDo) streamReader.readObject());
    
    org.ednovo.gooru.shared.model.content.TaskDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.content.AssignmentsSearchDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.AssignmentsSearchDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.AssignmentsSearchDo instance) throws SerializationException {
    streamWriter.writeString(getCollectionTaskAssocUid(instance));
    streamWriter.writeObject(getSequence(instance));
    streamWriter.writeObject(getTask(instance));
    
    org.ednovo.gooru.shared.model.content.TaskDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.AssignmentsSearchDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.AssignmentsSearchDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.AssignmentsSearchDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.AssignmentsSearchDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.AssignmentsSearchDo)object);
  }
  
}
