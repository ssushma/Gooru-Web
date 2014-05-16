package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LibraryCollectionItemDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCollectionItemId(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo.class, instance, "collectionItemId");
  }
  
  private static void setCollectionItemId(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo.class, instance, "collectionItemId", value);
  }
  
  private static java.lang.Integer getItemSequence(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo.class, instance, "itemSequence");
  }
  
  private static void setItemSequence(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo.class, instance, "itemSequence", value);
  }
  
  private static org.ednovo.gooru.shared.model.library.LibraryResourceDo getResource(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo instance) {
    return (org.ednovo.gooru.shared.model.library.LibraryResourceDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo.class, instance, "resource");
  }
  
  private static void setResource(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo instance, org.ednovo.gooru.shared.model.library.LibraryResourceDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo.class, instance, "resource", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo instance) throws SerializationException {
    setCollectionItemId(instance, streamReader.readString());
    setItemSequence(instance, (java.lang.Integer) streamReader.readObject());
    setResource(instance, (org.ednovo.gooru.shared.model.library.LibraryResourceDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo instance) throws SerializationException {
    streamWriter.writeString(getCollectionItemId(instance));
    streamWriter.writeObject(getItemSequence(instance));
    streamWriter.writeObject(getResource(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo)object);
  }
  
}
