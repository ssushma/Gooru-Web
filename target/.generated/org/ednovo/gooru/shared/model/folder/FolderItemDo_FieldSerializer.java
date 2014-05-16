package org.ednovo.gooru.shared.model.folder;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class FolderItemDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.folder.FolderItemDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderItemDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.folder.FolderItemDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderItemDo.class, instance, "gooruOid", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceFormatDo getResourceFormat(org.ednovo.gooru.shared.model.folder.FolderItemDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceFormatDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderItemDo.class, instance, "resourceFormat");
  }
  
  private static void setResourceFormat(org.ednovo.gooru.shared.model.folder.FolderItemDo instance, org.ednovo.gooru.shared.model.content.ResourceFormatDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderItemDo.class, instance, "resourceFormat", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.folder.FolderItemDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderItemDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.folder.FolderItemDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderItemDo.class, instance, "title", value);
  }
  
  private static java.lang.String getType(org.ednovo.gooru.shared.model.folder.FolderItemDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderItemDo.class, instance, "type");
  }
  
  private static void setType(org.ednovo.gooru.shared.model.folder.FolderItemDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderItemDo.class, instance, "type", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.folder.FolderItemDo instance) throws SerializationException {
    setGooruOid(instance, streamReader.readString());
    setResourceFormat(instance, (org.ednovo.gooru.shared.model.content.ResourceFormatDo) streamReader.readObject());
    setTitle(instance, streamReader.readString());
    setType(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.folder.FolderItemDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.folder.FolderItemDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.folder.FolderItemDo instance) throws SerializationException {
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeObject(getResourceFormat(instance));
    streamWriter.writeString(getTitle(instance));
    streamWriter.writeString(getType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.folder.FolderItemDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.folder.FolderItemDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.folder.FolderItemDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.folder.FolderItemDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.folder.FolderItemDo)object);
  }
  
}
