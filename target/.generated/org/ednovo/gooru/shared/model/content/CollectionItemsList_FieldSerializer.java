package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CollectionItemsList_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCollectionId(org.ednovo.gooru.shared.model.content.CollectionItemsList instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemsList.class, instance, "collectionId");
  }
  
  private static void setCollectionId(org.ednovo.gooru.shared.model.content.CollectionItemsList instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemsList.class, instance, "collectionId", value);
  }
  
  private static java.lang.Integer getCollectionItemsListSize(org.ednovo.gooru.shared.model.content.CollectionItemsList instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemsList.class, instance, "collectionItemsListSize");
  }
  
  private static void setCollectionItemsListSize(org.ednovo.gooru.shared.model.content.CollectionItemsList instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemsList.class, instance, "collectionItemsListSize", value);
  }
  
  private static java.lang.String getCollectionTitle(org.ednovo.gooru.shared.model.content.CollectionItemsList instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemsList.class, instance, "collectionTitle");
  }
  
  private static void setCollectionTitle(org.ednovo.gooru.shared.model.content.CollectionItemsList instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemsList.class, instance, "collectionTitle", value);
  }
  
  private static java.lang.String getCollectionType(org.ednovo.gooru.shared.model.content.CollectionItemsList instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemsList.class, instance, "collectionType");
  }
  
  private static void setCollectionType(org.ednovo.gooru.shared.model.content.CollectionItemsList instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemsList.class, instance, "collectionType", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.CollectionItemsList instance) throws SerializationException {
    setCollectionId(instance, streamReader.readString());
    setCollectionItemsListSize(instance, (java.lang.Integer) streamReader.readObject());
    setCollectionTitle(instance, streamReader.readString());
    setCollectionType(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.CollectionItemsList instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.CollectionItemsList();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.CollectionItemsList instance) throws SerializationException {
    streamWriter.writeString(getCollectionId(instance));
    streamWriter.writeObject(getCollectionItemsListSize(instance));
    streamWriter.writeString(getCollectionTitle(instance));
    streamWriter.writeString(getCollectionType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.CollectionItemsList_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.CollectionItemsList_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.CollectionItemsList)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.CollectionItemsList_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.CollectionItemsList)object);
  }
  
}
