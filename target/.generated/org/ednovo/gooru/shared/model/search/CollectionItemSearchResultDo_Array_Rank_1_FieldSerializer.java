package org.ednovo.gooru.shared.model.search;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CollectionItemSearchResultDo_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo_Array_Rank_1_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo_Array_Rank_1_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo[])object);
  }
  
}
