package org.ednovo.gooru.shared.model.search;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SearchFilterDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.Map getCategories(org.ednovo.gooru.shared.model.search.SearchFilterDo instance) {
    return (java.util.Map) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.SearchFilterDo.class, instance, "categories");
  }
  
  private static void setCategories(org.ednovo.gooru.shared.model.search.SearchFilterDo instance, java.util.Map value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.SearchFilterDo.class, instance, "categories", value);
  }
  
  private static java.util.Map getGradeLevels(org.ednovo.gooru.shared.model.search.SearchFilterDo instance) {
    return (java.util.Map) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.SearchFilterDo.class, instance, "gradeLevels");
  }
  
  private static void setGradeLevels(org.ednovo.gooru.shared.model.search.SearchFilterDo instance, java.util.Map value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.SearchFilterDo.class, instance, "gradeLevels", value);
  }
  
  private static java.util.List getSubjects(org.ednovo.gooru.shared.model.search.SearchFilterDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.SearchFilterDo.class, instance, "subjects");
  }
  
  private static void setSubjects(org.ednovo.gooru.shared.model.search.SearchFilterDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.SearchFilterDo.class, instance, "subjects", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.search.SearchFilterDo instance) throws SerializationException {
    setCategories(instance, (java.util.Map) streamReader.readObject());
    setGradeLevels(instance, (java.util.Map) streamReader.readObject());
    setSubjects(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.search.SearchFilterDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.search.SearchFilterDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.search.SearchFilterDo instance) throws SerializationException {
    streamWriter.writeObject(getCategories(instance));
    streamWriter.writeObject(getGradeLevels(instance));
    streamWriter.writeObject(getSubjects(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.search.SearchFilterDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.SearchFilterDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.search.SearchFilterDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.SearchFilterDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.search.SearchFilterDo)object);
  }
  
}
