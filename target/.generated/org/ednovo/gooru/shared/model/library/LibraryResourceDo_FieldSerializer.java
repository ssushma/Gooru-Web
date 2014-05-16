package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LibraryResourceDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCategory(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "category");
  }
  
  private static void setCategory(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "category", value);
  }
  
  private static java.lang.String getCollectionItemId(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "collectionItemId");
  }
  
  private static void setCollectionItemId(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "collectionItemId", value);
  }
  
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "gooruOid", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceFormatDo getResourceFormat(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceFormatDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "resourceFormat");
  }
  
  private static void setResourceFormat(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance, org.ednovo.gooru.shared.model.content.ResourceFormatDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "resourceFormat", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceSourceDo getResourceSource(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceSourceDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "resourceSource");
  }
  
  private static void setResourceSource(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance, org.ednovo.gooru.shared.model.content.ResourceSourceDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "resourceSource", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceTypeDo getResourceType(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceTypeDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "resourceType");
  }
  
  private static void setResourceType(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance, org.ednovo.gooru.shared.model.content.ResourceTypeDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "resourceType", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ThumbnailDo getThumbnails(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) {
    return (org.ednovo.gooru.shared.model.content.ThumbnailDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "thumbnails");
  }
  
  private static void setThumbnails(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance, org.ednovo.gooru.shared.model.content.ThumbnailDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "thumbnails", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "title", value);
  }
  
  private static java.lang.String getUrl(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "url");
  }
  
  private static void setUrl(org.ednovo.gooru.shared.model.library.LibraryResourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryResourceDo.class, instance, "url", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) throws SerializationException {
    setCategory(instance, streamReader.readString());
    setCollectionItemId(instance, streamReader.readString());
    setGooruOid(instance, streamReader.readString());
    setResourceFormat(instance, (org.ednovo.gooru.shared.model.content.ResourceFormatDo) streamReader.readObject());
    setResourceSource(instance, (org.ednovo.gooru.shared.model.content.ResourceSourceDo) streamReader.readObject());
    setResourceType(instance, (org.ednovo.gooru.shared.model.content.ResourceTypeDo) streamReader.readObject());
    setThumbnails(instance, (org.ednovo.gooru.shared.model.content.ThumbnailDo) streamReader.readObject());
    setTitle(instance, streamReader.readString());
    setUrl(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.LibraryResourceDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.LibraryResourceDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.LibraryResourceDo instance) throws SerializationException {
    streamWriter.writeString(getCategory(instance));
    streamWriter.writeString(getCollectionItemId(instance));
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeObject(getResourceFormat(instance));
    streamWriter.writeObject(getResourceSource(instance));
    streamWriter.writeObject(getResourceType(instance));
    streamWriter.writeObject(getThumbnails(instance));
    streamWriter.writeString(getTitle(instance));
    streamWriter.writeString(getUrl(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.LibraryResourceDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.LibraryResourceDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.LibraryResourceDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.LibraryResourceDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.LibraryResourceDo)object);
  }
  
}
