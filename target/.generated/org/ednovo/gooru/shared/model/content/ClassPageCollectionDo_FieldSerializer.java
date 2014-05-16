package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ClassPageCollectionDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getClasspageId(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo.class, instance, "classpageId");
  }
  
  private static void setClasspageId(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo.class, instance, "classpageId", value);
  }
  
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo.class, instance, "gooruOid", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ClassPageCollectionDo.class, instance, "title", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ClassPageCollectionDo instance) throws SerializationException {
    setClasspageId(instance, streamReader.readString());
    setGooruOid(instance, streamReader.readString());
    setTitle(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ClassPageCollectionDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ClassPageCollectionDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ClassPageCollectionDo instance) throws SerializationException {
    streamWriter.writeString(getClasspageId(instance));
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeString(getTitle(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ClassPageCollectionDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ClassPageCollectionDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ClassPageCollectionDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ClassPageCollectionDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ClassPageCollectionDo)object);
  }
  
}
