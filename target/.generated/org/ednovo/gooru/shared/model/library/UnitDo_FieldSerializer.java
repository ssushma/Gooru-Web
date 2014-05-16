package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UnitDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getCodeId(org.ednovo.gooru.shared.model.library.UnitDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "codeId");
  }
  
  private static void setCodeId(org.ednovo.gooru.shared.model.library.UnitDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "codeId", value);
  }
  
  private static java.util.ArrayList getCollection(org.ednovo.gooru.shared.model.library.UnitDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "collection");
  }
  
  private static void setCollection(org.ednovo.gooru.shared.model.library.UnitDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "collection", value);
  }
  
  private static java.lang.Integer getCount(org.ednovo.gooru.shared.model.library.UnitDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "count");
  }
  
  private static void setCount(org.ednovo.gooru.shared.model.library.UnitDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "count", value);
  }
  
  private static java.lang.String getLabel(org.ednovo.gooru.shared.model.library.UnitDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "label");
  }
  
  private static void setLabel(org.ednovo.gooru.shared.model.library.UnitDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "label", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ThumbnailDo getThumbnails(org.ednovo.gooru.shared.model.library.UnitDo instance) {
    return (org.ednovo.gooru.shared.model.content.ThumbnailDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "thumbnails");
  }
  
  private static void setThumbnails(org.ednovo.gooru.shared.model.library.UnitDo instance, org.ednovo.gooru.shared.model.content.ThumbnailDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "thumbnails", value);
  }
  
  private static java.util.ArrayList getTopic(org.ednovo.gooru.shared.model.library.UnitDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "topic");
  }
  
  private static void setTopic(org.ednovo.gooru.shared.model.library.UnitDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.UnitDo.class, instance, "topic", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.UnitDo instance) throws SerializationException {
    setCodeId(instance, (java.lang.Integer) streamReader.readObject());
    setCollection(instance, (java.util.ArrayList) streamReader.readObject());
    setCount(instance, (java.lang.Integer) streamReader.readObject());
    setLabel(instance, streamReader.readString());
    setThumbnails(instance, (org.ednovo.gooru.shared.model.content.ThumbnailDo) streamReader.readObject());
    setTopic(instance, (java.util.ArrayList) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.UnitDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.UnitDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.UnitDo instance) throws SerializationException {
    streamWriter.writeObject(getCodeId(instance));
    streamWriter.writeObject(getCollection(instance));
    streamWriter.writeObject(getCount(instance));
    streamWriter.writeString(getLabel(instance));
    streamWriter.writeObject(getThumbnails(instance));
    streamWriter.writeObject(getTopic(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.UnitDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.UnitDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.UnitDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.UnitDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.UnitDo)object);
  }
  
}
