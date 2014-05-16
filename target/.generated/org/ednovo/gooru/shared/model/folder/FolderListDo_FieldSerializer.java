package org.ednovo.gooru.shared.model.folder;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class FolderListDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getCount(org.ednovo.gooru.shared.model.folder.FolderListDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderListDo.class, instance, "count");
  }
  
  private static void setCount(org.ednovo.gooru.shared.model.folder.FolderListDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderListDo.class, instance, "count", value);
  }
  
  private static java.util.List getSearchResult(org.ednovo.gooru.shared.model.folder.FolderListDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.folder.FolderListDo.class, instance, "searchResult");
  }
  
  private static void setSearchResult(org.ednovo.gooru.shared.model.folder.FolderListDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.folder.FolderListDo.class, instance, "searchResult", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.folder.FolderListDo instance) throws SerializationException {
    setCount(instance, (java.lang.Integer) streamReader.readObject());
    setSearchResult(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.folder.FolderListDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.folder.FolderListDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.folder.FolderListDo instance) throws SerializationException {
    streamWriter.writeObject(getCount(instance));
    streamWriter.writeObject(getSearchResult(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.folder.FolderListDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.folder.FolderListDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.folder.FolderListDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.folder.FolderListDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.folder.FolderListDo)object);
  }
  
}
