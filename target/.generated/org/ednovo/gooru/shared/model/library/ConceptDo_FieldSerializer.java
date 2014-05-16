package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ConceptDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.ArrayList getCollectionItems(org.ednovo.gooru.shared.model.library.ConceptDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "collectionItems");
  }
  
  private static void setCollectionItems(org.ednovo.gooru.shared.model.library.ConceptDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "collectionItems", value);
  }
  
  private static java.lang.String getGoals(org.ednovo.gooru.shared.model.library.ConceptDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "goals");
  }
  
  private static void setGoals(org.ednovo.gooru.shared.model.library.ConceptDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "goals", value);
  }
  
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.library.ConceptDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.library.ConceptDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "gooruOid", value);
  }
  
  private static java.lang.String getId(org.ednovo.gooru.shared.model.library.ConceptDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "id");
  }
  
  private static void setId(org.ednovo.gooru.shared.model.library.ConceptDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "id", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo getMetaInfo(org.ednovo.gooru.shared.model.library.ConceptDo instance) {
    return (org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "metaInfo");
  }
  
  private static void setMetaInfo(org.ednovo.gooru.shared.model.library.ConceptDo instance, org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "metaInfo", value);
  }
  
  private static java.util.List getStandards(org.ednovo.gooru.shared.model.library.ConceptDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "standards");
  }
  
  private static void setStandards(org.ednovo.gooru.shared.model.library.ConceptDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "standards", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ThumbnailDo getThumbnails(org.ednovo.gooru.shared.model.library.ConceptDo instance) {
    return (org.ednovo.gooru.shared.model.content.ThumbnailDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "thumbnails");
  }
  
  private static void setThumbnails(org.ednovo.gooru.shared.model.library.ConceptDo instance, org.ednovo.gooru.shared.model.content.ThumbnailDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "thumbnails", value);
  }
  
  private static java.lang.String getTitle(org.ednovo.gooru.shared.model.library.ConceptDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "title");
  }
  
  private static void setTitle(org.ednovo.gooru.shared.model.library.ConceptDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "title", value);
  }
  
  private static org.ednovo.gooru.shared.model.library.LibraryUserDo getUser(org.ednovo.gooru.shared.model.library.ConceptDo instance) {
    return (org.ednovo.gooru.shared.model.library.LibraryUserDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "user");
  }
  
  private static void setUser(org.ednovo.gooru.shared.model.library.ConceptDo instance, org.ednovo.gooru.shared.model.library.LibraryUserDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.ConceptDo.class, instance, "user", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.ConceptDo instance) throws SerializationException {
    setCollectionItems(instance, (java.util.ArrayList) streamReader.readObject());
    setGoals(instance, streamReader.readString());
    setGooruOid(instance, streamReader.readString());
    setId(instance, streamReader.readString());
    setMetaInfo(instance, (org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo) streamReader.readObject());
    setStandards(instance, (java.util.List) streamReader.readObject());
    setThumbnails(instance, (org.ednovo.gooru.shared.model.content.ThumbnailDo) streamReader.readObject());
    setTitle(instance, streamReader.readString());
    setUser(instance, (org.ednovo.gooru.shared.model.library.LibraryUserDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.ConceptDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.ConceptDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.ConceptDo instance) throws SerializationException {
    streamWriter.writeObject(getCollectionItems(instance));
    streamWriter.writeString(getGoals(instance));
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeObject(getMetaInfo(instance));
    streamWriter.writeObject(getStandards(instance));
    streamWriter.writeObject(getThumbnails(instance));
    streamWriter.writeString(getTitle(instance));
    streamWriter.writeObject(getUser(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.ConceptDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.ConceptDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.ConceptDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.ConceptDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.ConceptDo)object);
  }
  
}
