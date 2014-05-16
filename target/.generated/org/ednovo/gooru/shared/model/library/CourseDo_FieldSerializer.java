package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CourseDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getCodeId(org.ednovo.gooru.shared.model.library.CourseDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "codeId");
  }
  
  private static void setCodeId(org.ednovo.gooru.shared.model.library.CourseDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "codeId", value);
  }
  
  private static org.ednovo.gooru.shared.model.library.LibraryUserDo getCreator(org.ednovo.gooru.shared.model.library.CourseDo instance) {
    return (org.ednovo.gooru.shared.model.library.LibraryUserDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "creator");
  }
  
  private static void setCreator(org.ednovo.gooru.shared.model.library.CourseDo instance, org.ednovo.gooru.shared.model.library.LibraryUserDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "creator", value);
  }
  
  private static java.lang.String getLabel(org.ednovo.gooru.shared.model.library.CourseDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "label");
  }
  
  private static void setLabel(org.ednovo.gooru.shared.model.library.CourseDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "label", value);
  }
  
  private static java.lang.String getParentId(org.ednovo.gooru.shared.model.library.CourseDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "parentId");
  }
  
  private static void setParentId(org.ednovo.gooru.shared.model.library.CourseDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "parentId", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ThumbnailDo getThumbnails(org.ednovo.gooru.shared.model.library.CourseDo instance) {
    return (org.ednovo.gooru.shared.model.content.ThumbnailDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "thumbnails");
  }
  
  private static void setThumbnails(org.ednovo.gooru.shared.model.library.CourseDo instance, org.ednovo.gooru.shared.model.content.ThumbnailDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "thumbnails", value);
  }
  
  private static java.util.ArrayList getUnit(org.ednovo.gooru.shared.model.library.CourseDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "unit");
  }
  
  private static void setUnit(org.ednovo.gooru.shared.model.library.CourseDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "unit", value);
  }
  
  private static java.util.List getUser(org.ednovo.gooru.shared.model.library.CourseDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "user");
  }
  
  private static void setUser(org.ednovo.gooru.shared.model.library.CourseDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.CourseDo.class, instance, "user", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.CourseDo instance) throws SerializationException {
    setCodeId(instance, (java.lang.Integer) streamReader.readObject());
    setCreator(instance, (org.ednovo.gooru.shared.model.library.LibraryUserDo) streamReader.readObject());
    setLabel(instance, streamReader.readString());
    setParentId(instance, streamReader.readString());
    setThumbnails(instance, (org.ednovo.gooru.shared.model.content.ThumbnailDo) streamReader.readObject());
    setUnit(instance, (java.util.ArrayList) streamReader.readObject());
    setUser(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.CourseDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.CourseDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.CourseDo instance) throws SerializationException {
    streamWriter.writeObject(getCodeId(instance));
    streamWriter.writeObject(getCreator(instance));
    streamWriter.writeString(getLabel(instance));
    streamWriter.writeString(getParentId(instance));
    streamWriter.writeObject(getThumbnails(instance));
    streamWriter.writeObject(getUnit(instance));
    streamWriter.writeObject(getUser(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.CourseDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.CourseDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.CourseDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.CourseDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.CourseDo)object);
  }
  
}
