package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class NewResourceDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCategory(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "category");
  }
  
  private static void setCategory(org.ednovo.gooru.shared.model.content.NewResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "category", value);
  }
  
  private static java.lang.String getDescription(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "description");
  }
  
  private static void setDescription(org.ednovo.gooru.shared.model.content.NewResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "description", value);
  }
  
  private static java.util.ArrayList getEducationalUse(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "educationalUse");
  }
  
  private static void setEducationalUse(org.ednovo.gooru.shared.model.content.NewResourceDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "educationalUse", value);
  }
  
  private static java.lang.String getId(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "id");
  }
  
  private static void setId(org.ednovo.gooru.shared.model.content.NewResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "id", value);
  }
  
  private static java.util.ArrayList getMomentsOfLearning(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "momentsOfLearning");
  }
  
  private static void setMomentsOfLearning(org.ednovo.gooru.shared.model.content.NewResourceDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "momentsOfLearning", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceFormatDo getResourceFormat(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceFormatDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "resourceFormat");
  }
  
  private static void setResourceFormat(org.ednovo.gooru.shared.model.content.NewResourceDo instance, org.ednovo.gooru.shared.model.content.ResourceFormatDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "resourceFormat", value);
  }
  
  private static java.lang.Integer getStop(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "stop");
  }
  
  private static void setStop(org.ednovo.gooru.shared.model.content.NewResourceDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "stop", value);
  }
  
  private static java.lang.String getThumbnail(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "thumbnail");
  }
  
  private static void setThumbnail(org.ednovo.gooru.shared.model.content.NewResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "thumbnail", value);
  }
  
  private static java.lang.String getThumbnailImgUrl(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "thumbnailImgUrl");
  }
  
  private static void setThumbnailImgUrl(org.ednovo.gooru.shared.model.content.NewResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "thumbnailImgUrl", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.content.NewResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "title", value);
  }
  
  private static java.lang.String getUrl(org.ednovo.gooru.shared.model.content.NewResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "url");
  }
  
  private static void setUrl(org.ednovo.gooru.shared.model.content.NewResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.NewResourceDo.class, instance, "url", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.NewResourceDo instance) throws SerializationException {
    setCategory(instance, streamReader.readString());
    setDescription(instance, streamReader.readString());
    setEducationalUse(instance, (java.util.ArrayList) streamReader.readObject());
    setId(instance, streamReader.readString());
    setMomentsOfLearning(instance, (java.util.ArrayList) streamReader.readObject());
    setResourceFormat(instance, (org.ednovo.gooru.shared.model.content.ResourceFormatDo) streamReader.readObject());
    setStop(instance, (java.lang.Integer) streamReader.readObject());
    setThumbnail(instance, streamReader.readString());
    setThumbnailImgUrl(instance, streamReader.readString());
    setTitle(instance, streamReader.readString());
    setUrl(instance, streamReader.readString());
    
    org.ednovo.gooru.shared.model.content.ResourceDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.content.NewResourceDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.NewResourceDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.NewResourceDo instance) throws SerializationException {
    streamWriter.writeString(getCategory(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getEducationalUse(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeObject(getMomentsOfLearning(instance));
    streamWriter.writeObject(getResourceFormat(instance));
    streamWriter.writeObject(getStop(instance));
    streamWriter.writeString(getThumbnail(instance));
    streamWriter.writeString(getThumbnailImgUrl(instance));
    streamWriter.writeString(getTitle(instance));
    streamWriter.writeString(getUrl(instance));
    
    org.ednovo.gooru.shared.model.content.ResourceDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.NewResourceDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.NewResourceDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.NewResourceDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.NewResourceDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.NewResourceDo)object);
  }
  
}
