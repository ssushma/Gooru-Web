package org.ednovo.gooru.shared.model.folder;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class FolderDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.List getCollectionItems(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "collectionItems");
  }
  
  private static void setCollectionItems(org.ednovo.gooru.shared.model.folder.FolderDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "collectionItems", value);
  }
  
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.folder.FolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "gooruOid", value);
  }
  
  private static java.lang.String getIdeas(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "ideas");
  }
  
  private static void setIdeas(org.ednovo.gooru.shared.model.folder.FolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "ideas", value);
  }
  
  private static java.lang.Integer getItemCount(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "itemCount");
  }
  
  private static void setItemCount(org.ednovo.gooru.shared.model.folder.FolderDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "itemCount", value);
  }
  
  private static java.lang.String getPerformanceTasks(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "performanceTasks");
  }
  
  private static void setPerformanceTasks(org.ednovo.gooru.shared.model.folder.FolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "performanceTasks", value);
  }
  
  private static java.lang.String getQuestions(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "questions");
  }
  
  private static void setQuestions(org.ednovo.gooru.shared.model.folder.FolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "questions", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceFormatDo getResourceFormat(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceFormatDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "resourceFormat");
  }
  
  private static void setResourceFormat(org.ednovo.gooru.shared.model.folder.FolderDo instance, org.ednovo.gooru.shared.model.content.ResourceFormatDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "resourceFormat", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceTypeDo getResourceTypeDo(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceTypeDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "resourceTypeDo");
  }
  
  private static void setResourceTypeDo(org.ednovo.gooru.shared.model.folder.FolderDo instance, org.ednovo.gooru.shared.model.content.ResourceTypeDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "resourceTypeDo", value);
  }
  
  private static java.lang.String getSharing(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "sharing");
  }
  
  private static void setSharing(org.ednovo.gooru.shared.model.folder.FolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "sharing", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ThumbnailDo getThumbnails(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (org.ednovo.gooru.shared.model.content.ThumbnailDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "thumbnails");
  }
  
  private static void setThumbnails(org.ednovo.gooru.shared.model.folder.FolderDo instance, org.ednovo.gooru.shared.model.content.ThumbnailDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "thumbnails", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.folder.FolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "title", value);
  }
  
  private static java.lang.String getType(org.ednovo.gooru.shared.model.folder.FolderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "type");
  }
  
  private static void setType(org.ednovo.gooru.shared.model.folder.FolderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderDo.class, instance, "type", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.folder.FolderDo instance) throws SerializationException {
    setCollectionItems(instance, (java.util.List) streamReader.readObject());
    setGooruOid(instance, streamReader.readString());
    setIdeas(instance, streamReader.readString());
    setItemCount(instance, (java.lang.Integer) streamReader.readObject());
    setPerformanceTasks(instance, streamReader.readString());
    setQuestions(instance, streamReader.readString());
    setResourceFormat(instance, (org.ednovo.gooru.shared.model.content.ResourceFormatDo) streamReader.readObject());
    setResourceTypeDo(instance, (org.ednovo.gooru.shared.model.content.ResourceTypeDo) streamReader.readObject());
    setSharing(instance, streamReader.readString());
    setThumbnails(instance, (org.ednovo.gooru.shared.model.content.ThumbnailDo) streamReader.readObject());
    setTitle(instance, streamReader.readString());
    setType(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.folder.FolderDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.folder.FolderDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.folder.FolderDo instance) throws SerializationException {
    streamWriter.writeObject(getCollectionItems(instance));
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeString(getIdeas(instance));
    streamWriter.writeObject(getItemCount(instance));
    streamWriter.writeString(getPerformanceTasks(instance));
    streamWriter.writeString(getQuestions(instance));
    streamWriter.writeObject(getResourceFormat(instance));
    streamWriter.writeObject(getResourceTypeDo(instance));
    streamWriter.writeString(getSharing(instance));
    streamWriter.writeObject(getThumbnails(instance));
    streamWriter.writeString(getTitle(instance));
    streamWriter.writeString(getType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.folder.FolderDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.folder.FolderDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.folder.FolderDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.folder.FolderDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.folder.FolderDo)object);
  }
  
}
