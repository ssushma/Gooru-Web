package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ClasspageSearchObjectDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getClassCode(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo.class, instance, "classCode");
  }
  
  private static void setClassCode(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo.class, instance, "classCode", value);
  }
  
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo.class, instance, "gooruOid", value);
  }
  
  private static java.lang.String getStatus(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo.class, instance, "status");
  }
  
  private static void setStatus(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo.class, instance, "status", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo.class, instance, "title", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instance) throws SerializationException {
    setClassCode(instance, streamReader.readString());
    setGooruOid(instance, streamReader.readString());
    setStatus(instance, streamReader.readString());
    setTitle(instance, streamReader.readString());
    
    org.ednovo.gooru.shared.model.content.ResourceDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo instance) throws SerializationException {
    streamWriter.writeString(getClassCode(instance));
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeString(getStatus(instance));
    streamWriter.writeString(getTitle(instance));
    
    org.ednovo.gooru.shared.model.content.ResourceDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ClasspageSearchObjectDo)object);
  }
  
}
