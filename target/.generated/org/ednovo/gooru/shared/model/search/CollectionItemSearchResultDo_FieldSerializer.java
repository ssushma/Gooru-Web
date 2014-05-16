package org.ednovo.gooru.shared.model.search;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CollectionItemSearchResultDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCollectionId(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo.class, instance, "collectionId");
  }
  
  private static void setCollectionId(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo.class, instance, "collectionId", value);
  }
  
  private static java.lang.String getCollectionItemId(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo.class, instance, "collectionItemId");
  }
  
  private static void setCollectionItemId(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo.class, instance, "collectionItemId", value);
  }
  
  private static java.lang.Integer getItemSequence(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo.class, instance, "itemSequence");
  }
  
  private static void setItemSequence(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo.class, instance, "itemSequence", value);
  }
  
  private static java.lang.String getItemType(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo.class, instance, "itemType");
  }
  
  private static void setItemType(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo.class, instance, "itemType", value);
  }
  
  private static java.lang.String getNarration(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo.class, instance, "narration");
  }
  
  private static void setNarration(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo.class, instance, "narration", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance) throws SerializationException {
    setCollectionId(instance, streamReader.readString());
    setCollectionItemId(instance, streamReader.readString());
    setItemSequence(instance, (java.lang.Integer) streamReader.readObject());
    setItemType(instance, streamReader.readString());
    setNarration(instance, streamReader.readString());
    
    org.ednovo.gooru.shared.model.search.ResourceSearchResultDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo instance) throws SerializationException {
    streamWriter.writeString(getCollectionId(instance));
    streamWriter.writeString(getCollectionItemId(instance));
    streamWriter.writeObject(getItemSequence(instance));
    streamWriter.writeString(getItemType(instance));
    streamWriter.writeString(getNarration(instance));
    
    org.ednovo.gooru.shared.model.search.ResourceSearchResultDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo)object);
  }
  
}
