package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MediaUploadDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getDeleteType(org.ednovo.gooru.shared.model.user.MediaUploadDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "deleteType");
  }
  
  private static void setDeleteType(org.ednovo.gooru.shared.model.user.MediaUploadDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "deleteType", value);
  }
  
  private static java.lang.String getDeleteUrl(org.ednovo.gooru.shared.model.user.MediaUploadDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "deleteUrl");
  }
  
  private static void setDeleteUrl(org.ednovo.gooru.shared.model.user.MediaUploadDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "deleteUrl", value);
  }
  
  private static java.lang.String getImageValidationMsg(org.ednovo.gooru.shared.model.user.MediaUploadDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "imageValidationMsg");
  }
  
  private static void setImageValidationMsg(org.ednovo.gooru.shared.model.user.MediaUploadDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "imageValidationMsg", value);
  }
  
  private static java.lang.String getName(org.ednovo.gooru.shared.model.user.MediaUploadDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "name");
  }
  
  private static void setName(org.ednovo.gooru.shared.model.user.MediaUploadDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "name", value);
  }
  
  private static java.lang.String getOriginalFilename(org.ednovo.gooru.shared.model.user.MediaUploadDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "originalFilename");
  }
  
  private static void setOriginalFilename(org.ednovo.gooru.shared.model.user.MediaUploadDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "originalFilename", value);
  }
  
  private static java.lang.Long getSize(org.ednovo.gooru.shared.model.user.MediaUploadDo instance) {
    return (java.lang.Long) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "size");
  }
  
  private static void setSize(org.ednovo.gooru.shared.model.user.MediaUploadDo instance, java.lang.Long value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "size", value);
  }
  
  private static java.lang.Integer getStatusCode(org.ednovo.gooru.shared.model.user.MediaUploadDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "statusCode");
  }
  
  private static void setStatusCode(org.ednovo.gooru.shared.model.user.MediaUploadDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "statusCode", value);
  }
  
  private static java.lang.String getUploadImageSource(org.ednovo.gooru.shared.model.user.MediaUploadDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "uploadImageSource");
  }
  
  private static void setUploadImageSource(org.ednovo.gooru.shared.model.user.MediaUploadDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "uploadImageSource", value);
  }
  
  private static java.lang.String getUrl(org.ednovo.gooru.shared.model.user.MediaUploadDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "url");
  }
  
  private static void setUrl(org.ednovo.gooru.shared.model.user.MediaUploadDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.MediaUploadDo.class, instance, "url", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.MediaUploadDo instance) throws SerializationException {
    setDeleteType(instance, streamReader.readString());
    setDeleteUrl(instance, streamReader.readString());
    setImageValidationMsg(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setOriginalFilename(instance, streamReader.readString());
    setSize(instance, (java.lang.Long) streamReader.readObject());
    setStatusCode(instance, (java.lang.Integer) streamReader.readObject());
    setUploadImageSource(instance, streamReader.readString());
    setUrl(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.MediaUploadDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.MediaUploadDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.MediaUploadDo instance) throws SerializationException {
    streamWriter.writeString(getDeleteType(instance));
    streamWriter.writeString(getDeleteUrl(instance));
    streamWriter.writeString(getImageValidationMsg(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getOriginalFilename(instance));
    streamWriter.writeObject(getSize(instance));
    streamWriter.writeObject(getStatusCode(instance));
    streamWriter.writeString(getUploadImageSource(instance));
    streamWriter.writeString(getUrl(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.MediaUploadDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.MediaUploadDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.MediaUploadDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.MediaUploadDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.MediaUploadDo)object);
  }
  
}
