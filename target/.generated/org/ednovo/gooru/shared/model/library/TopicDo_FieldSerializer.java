package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TopicDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getCodeId(org.ednovo.gooru.shared.model.library.TopicDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.TopicDo.class, instance, "codeId");
  }
  
  private static void setCodeId(org.ednovo.gooru.shared.model.library.TopicDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.TopicDo.class, instance, "codeId", value);
  }
  
  private static java.util.ArrayList getCollection(org.ednovo.gooru.shared.model.library.TopicDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.TopicDo.class, instance, "collection");
  }
  
  private static void setCollection(org.ednovo.gooru.shared.model.library.TopicDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.TopicDo.class, instance, "collection", value);
  }
  
  private static java.lang.String getLabel(org.ednovo.gooru.shared.model.library.TopicDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.TopicDo.class, instance, "label");
  }
  
  private static void setLabel(org.ednovo.gooru.shared.model.library.TopicDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.TopicDo.class, instance, "label", value);
  }
  
  private static java.util.ArrayList getLesson(org.ednovo.gooru.shared.model.library.TopicDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.TopicDo.class, instance, "lesson");
  }
  
  private static void setLesson(org.ednovo.gooru.shared.model.library.TopicDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.TopicDo.class, instance, "lesson", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ThumbnailDo getThumbnails(org.ednovo.gooru.shared.model.library.TopicDo instance) {
    return (org.ednovo.gooru.shared.model.content.ThumbnailDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.TopicDo.class, instance, "thumbnails");
  }
  
  private static void setThumbnails(org.ednovo.gooru.shared.model.library.TopicDo instance, org.ednovo.gooru.shared.model.content.ThumbnailDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.TopicDo.class, instance, "thumbnails", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.TopicDo instance) throws SerializationException {
    setCodeId(instance, (java.lang.Integer) streamReader.readObject());
    setCollection(instance, (java.util.ArrayList) streamReader.readObject());
    setLabel(instance, streamReader.readString());
    setLesson(instance, (java.util.ArrayList) streamReader.readObject());
    setThumbnails(instance, (org.ednovo.gooru.shared.model.content.ThumbnailDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.TopicDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.TopicDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.TopicDo instance) throws SerializationException {
    streamWriter.writeObject(getCodeId(instance));
    streamWriter.writeObject(getCollection(instance));
    streamWriter.writeString(getLabel(instance));
    streamWriter.writeObject(getLesson(instance));
    streamWriter.writeObject(getThumbnails(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.TopicDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.TopicDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.TopicDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.TopicDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.TopicDo)object);
  }
  
}
