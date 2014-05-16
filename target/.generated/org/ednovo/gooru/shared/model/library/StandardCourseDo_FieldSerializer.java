package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class StandardCourseDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCode(org.ednovo.gooru.shared.model.library.StandardCourseDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.StandardCourseDo.class, instance, "code");
  }
  
  private static void setCode(org.ednovo.gooru.shared.model.library.StandardCourseDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.StandardCourseDo.class, instance, "code", value);
  }
  
  private static java.lang.Integer getCodeId(org.ednovo.gooru.shared.model.library.StandardCourseDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.StandardCourseDo.class, instance, "codeId");
  }
  
  private static void setCodeId(org.ednovo.gooru.shared.model.library.StandardCourseDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.StandardCourseDo.class, instance, "codeId", value);
  }
  
  private static java.util.ArrayList getCourse(org.ednovo.gooru.shared.model.library.StandardCourseDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.StandardCourseDo.class, instance, "course");
  }
  
  private static void setCourse(org.ednovo.gooru.shared.model.library.StandardCourseDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.StandardCourseDo.class, instance, "course", value);
  }
  
  private static java.lang.String getLabel(org.ednovo.gooru.shared.model.library.StandardCourseDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.StandardCourseDo.class, instance, "label");
  }
  
  private static void setLabel(org.ednovo.gooru.shared.model.library.StandardCourseDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.StandardCourseDo.class, instance, "label", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ThumbnailDo getThumbnails(org.ednovo.gooru.shared.model.library.StandardCourseDo instance) {
    return (org.ednovo.gooru.shared.model.content.ThumbnailDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.StandardCourseDo.class, instance, "thumbnails");
  }
  
  private static void setThumbnails(org.ednovo.gooru.shared.model.library.StandardCourseDo instance, org.ednovo.gooru.shared.model.content.ThumbnailDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.StandardCourseDo.class, instance, "thumbnails", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.StandardCourseDo instance) throws SerializationException {
    setCode(instance, streamReader.readString());
    setCodeId(instance, (java.lang.Integer) streamReader.readObject());
    setCourse(instance, (java.util.ArrayList) streamReader.readObject());
    setLabel(instance, streamReader.readString());
    setThumbnails(instance, (org.ednovo.gooru.shared.model.content.ThumbnailDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.StandardCourseDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.StandardCourseDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.StandardCourseDo instance) throws SerializationException {
    streamWriter.writeString(getCode(instance));
    streamWriter.writeObject(getCodeId(instance));
    streamWriter.writeObject(getCourse(instance));
    streamWriter.writeString(getLabel(instance));
    streamWriter.writeObject(getThumbnails(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.StandardCourseDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.StandardCourseDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.StandardCourseDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.StandardCourseDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.StandardCourseDo)object);
  }
  
}
