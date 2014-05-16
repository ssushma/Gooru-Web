package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ResoruceCollectionDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.List getSearchResults(org.ednovo.gooru.shared.model.content.ResoruceCollectionDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResoruceCollectionDo.class, instance, "searchResults");
  }
  
  private static void setSearchResults(org.ednovo.gooru.shared.model.content.ResoruceCollectionDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResoruceCollectionDo.class, instance, "searchResults", value);
  }
  
  private static java.lang.Integer getTotalHitCount(org.ednovo.gooru.shared.model.content.ResoruceCollectionDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResoruceCollectionDo.class, instance, "totalHitCount");
  }
  
  private static void setTotalHitCount(org.ednovo.gooru.shared.model.content.ResoruceCollectionDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResoruceCollectionDo.class, instance, "totalHitCount", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ResoruceCollectionDo instance) throws SerializationException {
    setSearchResults(instance, (java.util.List) streamReader.readObject());
    setTotalHitCount(instance, (java.lang.Integer) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ResoruceCollectionDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ResoruceCollectionDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ResoruceCollectionDo instance) throws SerializationException {
    streamWriter.writeObject(getSearchResults(instance));
    streamWriter.writeObject(getTotalHitCount(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ResoruceCollectionDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ResoruceCollectionDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ResoruceCollectionDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ResoruceCollectionDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ResoruceCollectionDo)object);
  }
  
}
