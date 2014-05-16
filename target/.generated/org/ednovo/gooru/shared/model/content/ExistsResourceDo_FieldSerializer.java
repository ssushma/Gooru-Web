package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ExistsResourceDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAssetURI(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "assetURI");
  }
  
  private static void setAssetURI(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "assetURI", value);
  }
  
  private static java.lang.String getCategory(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "category");
  }
  
  private static void setCategory(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "category", value);
  }
  
  private static java.lang.String getDescription(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "description");
  }
  
  private static void setDescription(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "description", value);
  }
  
  private static java.lang.String getExplanation(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "explanation");
  }
  
  private static void setExplanation(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "explanation", value);
  }
  
  private static java.lang.String getFolder(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "folder");
  }
  
  private static void setFolder(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "folder", value);
  }
  
  private static java.lang.String getId(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "id");
  }
  
  private static void setId(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "id", value);
  }
  
  private static java.lang.String getLabel(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "label");
  }
  
  private static void setLabel(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "label", value);
  }
  
  private static java.lang.String getNativeurl(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "nativeurl");
  }
  
  private static void setNativeurl(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "nativeurl", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceTypeDo getResourceType(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceTypeDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "resourceType");
  }
  
  private static void setResourceType(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, org.ednovo.gooru.shared.model.content.ResourceTypeDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "resourceType", value);
  }
  
  private static java.lang.String getShortenedUrlStatus(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "shortenedUrlStatus");
  }
  
  private static void setShortenedUrlStatus(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "shortenedUrlStatus", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ThumbnailDo getThumbnails(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (org.ednovo.gooru.shared.model.content.ThumbnailDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "thumbnails");
  }
  
  private static void setThumbnails(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, org.ednovo.gooru.shared.model.content.ThumbnailDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "thumbnails", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "title", value);
  }
  
  private static java.lang.String getUrl(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "url");
  }
  
  private static void setUrl(org.ednovo.gooru.shared.model.content.ExistsResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ExistsResourceDo.class, instance, "url", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) throws SerializationException {
    setAssetURI(instance, streamReader.readString());
    setCategory(instance, streamReader.readString());
    setDescription(instance, streamReader.readString());
    setExplanation(instance, streamReader.readString());
    setFolder(instance, streamReader.readString());
    setId(instance, streamReader.readString());
    setLabel(instance, streamReader.readString());
    setNativeurl(instance, streamReader.readString());
    setResourceType(instance, (org.ednovo.gooru.shared.model.content.ResourceTypeDo) streamReader.readObject());
    setShortenedUrlStatus(instance, streamReader.readString());
    setThumbnails(instance, (org.ednovo.gooru.shared.model.content.ThumbnailDo) streamReader.readObject());
    setTitle(instance, streamReader.readString());
    setUrl(instance, streamReader.readString());
    
    org.ednovo.gooru.shared.model.content.ContentDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.content.ExistsResourceDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ExistsResourceDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ExistsResourceDo instance) throws SerializationException {
    streamWriter.writeString(getAssetURI(instance));
    streamWriter.writeString(getCategory(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getExplanation(instance));
    streamWriter.writeString(getFolder(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeString(getLabel(instance));
    streamWriter.writeString(getNativeurl(instance));
    streamWriter.writeObject(getResourceType(instance));
    streamWriter.writeString(getShortenedUrlStatus(instance));
    streamWriter.writeObject(getThumbnails(instance));
    streamWriter.writeString(getTitle(instance));
    streamWriter.writeString(getUrl(instance));
    
    org.ednovo.gooru.shared.model.content.ContentDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ExistsResourceDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ExistsResourceDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ExistsResourceDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ExistsResourceDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ExistsResourceDo)object);
  }
  
}
