package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class PartnerFolderDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.ArrayList getCollections(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "collections");
  }
  
  private static void setCollections(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "collections", value);
  }
  
  private static java.util.ArrayList getFolderItems(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "folderItems");
  }
  
  private static void setFolderItems(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "folderItems", value);
  }
  
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "gooruOid", value);
  }
  
  private static java.lang.Integer getItemCount(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "itemCount");
  }
  
  private static void setItemCount(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "itemCount", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceFormatDo getResourceFormat(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceFormatDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "resourceFormat");
  }
  
  private static void setResourceFormat(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance, org.ednovo.gooru.shared.model.content.ResourceFormatDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "resourceFormat", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceTypeDo getResourceTypeDo(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceTypeDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "resourceTypeDo");
  }
  
  private static void setResourceTypeDo(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance, org.ednovo.gooru.shared.model.content.ResourceTypeDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "resourceTypeDo", value);
  }
  
  private static java.lang.String getSharing(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "sharing");
  }
  
  private static void setSharing(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "sharing", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ThumbnailDo getThumbnails(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) {
    return (org.ednovo.gooru.shared.model.content.ThumbnailDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "thumbnails");
  }
  
  private static void setThumbnails(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance, org.ednovo.gooru.shared.model.content.ThumbnailDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "thumbnails", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "title", value);
  }
  
  private static java.lang.String getType(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "type");
  }
  
  private static void setType(org.ednovo.gooru.shared.model.library.PartnerFolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerFolderDo.class, instance, "type", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) throws SerializationException {
    setCollections(instance, (java.util.ArrayList) streamReader.readObject());
    setFolderItems(instance, (java.util.ArrayList) streamReader.readObject());
    setGooruOid(instance, streamReader.readString());
    setItemCount(instance, (java.lang.Integer) streamReader.readObject());
    setResourceFormat(instance, (org.ednovo.gooru.shared.model.content.ResourceFormatDo) streamReader.readObject());
    setResourceTypeDo(instance, (org.ednovo.gooru.shared.model.content.ResourceTypeDo) streamReader.readObject());
    setSharing(instance, streamReader.readString());
    setThumbnails(instance, (org.ednovo.gooru.shared.model.content.ThumbnailDo) streamReader.readObject());
    setTitle(instance, streamReader.readString());
    setType(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.PartnerFolderDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.PartnerFolderDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.PartnerFolderDo instance) throws SerializationException {
    streamWriter.writeObject(getCollections(instance));
    streamWriter.writeObject(getFolderItems(instance));
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeObject(getItemCount(instance));
    streamWriter.writeObject(getResourceFormat(instance));
    streamWriter.writeObject(getResourceTypeDo(instance));
    streamWriter.writeString(getSharing(instance));
    streamWriter.writeObject(getThumbnails(instance));
    streamWriter.writeString(getTitle(instance));
    streamWriter.writeString(getType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.PartnerFolderDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.PartnerFolderDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.PartnerFolderDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.PartnerFolderDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.PartnerFolderDo)object);
  }
  
}
