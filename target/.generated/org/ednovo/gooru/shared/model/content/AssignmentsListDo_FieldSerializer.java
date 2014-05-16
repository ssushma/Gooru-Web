package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AssignmentsListDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCategory(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "category");
  }
  
  private static void setCategory(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "category", value);
  }
  
  private static java.lang.String getClasspageId(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "classpageId");
  }
  
  private static void setClasspageId(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "classpageId", value);
  }
  
  private static java.lang.Integer getPageNum(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "pageNum");
  }
  
  private static void setPageNum(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "pageNum", value);
  }
  
  private static java.lang.Integer getPageSize(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "pageSize");
  }
  
  private static void setPageSize(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "pageSize", value);
  }
  
  private static java.lang.Integer getPos(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "pos");
  }
  
  private static void setPos(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "pos", value);
  }
  
  private static java.util.List getSearchResults(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "searchResults");
  }
  
  private static void setSearchResults(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "searchResults", value);
  }
  
  private static java.lang.Integer getTotalHitCount(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "totalHitCount");
  }
  
  private static void setTotalHitCount(org.ednovo.gooru.shared.model.content.AssignmentsListDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssignmentsListDo.class, instance, "totalHitCount", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.AssignmentsListDo instance) throws SerializationException {
    setCategory(instance, streamReader.readString());
    setClasspageId(instance, streamReader.readString());
    setPageNum(instance, (java.lang.Integer) streamReader.readObject());
    setPageSize(instance, (java.lang.Integer) streamReader.readObject());
    setPos(instance, (java.lang.Integer) streamReader.readObject());
    setSearchResults(instance, (java.util.List) streamReader.readObject());
    setTotalHitCount(instance, (java.lang.Integer) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.AssignmentsListDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.AssignmentsListDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.AssignmentsListDo instance) throws SerializationException {
    streamWriter.writeString(getCategory(instance));
    streamWriter.writeString(getClasspageId(instance));
    streamWriter.writeObject(getPageNum(instance));
    streamWriter.writeObject(getPageSize(instance));
    streamWriter.writeObject(getPos(instance));
    streamWriter.writeObject(getSearchResults(instance));
    streamWriter.writeObject(getTotalHitCount(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.AssignmentsListDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.AssignmentsListDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.AssignmentsListDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.AssignmentsListDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.AssignmentsListDo)object);
  }
  
}
