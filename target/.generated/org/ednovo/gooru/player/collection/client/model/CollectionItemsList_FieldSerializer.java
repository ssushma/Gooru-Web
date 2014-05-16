package org.ednovo.gooru.player.collection.client.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CollectionItemsList_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getMyCollectionItemsListSize(org.ednovo.gooru.player.collection.client.model.CollectionItemsList instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.CollectionItemsList.class, instance, "myCollectionItemsListSize");
  }
  
  private static void setMyCollectionItemsListSize(org.ednovo.gooru.player.collection.client.model.CollectionItemsList instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.CollectionItemsList.class, instance, "myCollectionItemsListSize", value);
  }
  
  private static java.lang.String getMyCollectionTitle(org.ednovo.gooru.player.collection.client.model.CollectionItemsList instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.CollectionItemsList.class, instance, "myCollectionTitle");
  }
  
  private static void setMyCollectionTitle(org.ednovo.gooru.player.collection.client.model.CollectionItemsList instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.CollectionItemsList.class, instance, "myCollectionTitle", value);
  }
  
  private static java.lang.String getMyCollectionType(org.ednovo.gooru.player.collection.client.model.CollectionItemsList instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.CollectionItemsList.class, instance, "myCollectionType");
  }
  
  private static void setMyCollectionType(org.ednovo.gooru.player.collection.client.model.CollectionItemsList instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.CollectionItemsList.class, instance, "myCollectionType", value);
  }
  
  private static java.lang.String getMycollectionGid(org.ednovo.gooru.player.collection.client.model.CollectionItemsList instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.CollectionItemsList.class, instance, "mycollectionGid");
  }
  
  private static void setMycollectionGid(org.ednovo.gooru.player.collection.client.model.CollectionItemsList instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.CollectionItemsList.class, instance, "mycollectionGid", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.collection.client.model.CollectionItemsList instance) throws SerializationException {
    setMyCollectionItemsListSize(instance, (java.lang.Integer) streamReader.readObject());
    setMyCollectionTitle(instance, streamReader.readString());
    setMyCollectionType(instance, streamReader.readString());
    setMycollectionGid(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.player.collection.client.model.CollectionItemsList instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.collection.client.model.CollectionItemsList();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.collection.client.model.CollectionItemsList instance) throws SerializationException {
    streamWriter.writeObject(getMyCollectionItemsListSize(instance));
    streamWriter.writeString(getMyCollectionTitle(instance));
    streamWriter.writeString(getMyCollectionType(instance));
    streamWriter.writeString(getMycollectionGid(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.collection.client.model.CollectionItemsList_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.collection.client.model.CollectionItemsList_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.collection.client.model.CollectionItemsList)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.collection.client.model.CollectionItemsList_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.collection.client.model.CollectionItemsList)object);
  }
  
}
