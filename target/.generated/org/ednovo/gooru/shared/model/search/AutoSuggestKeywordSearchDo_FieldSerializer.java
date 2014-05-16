package org.ednovo.gooru.shared.model.search;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AutoSuggestKeywordSearchDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getKeyword(org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo.class, instance, "keyword");
  }
  
  private static void setKeyword(org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo.class, instance, "keyword", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo instance) throws SerializationException {
    setKeyword(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo instance) throws SerializationException {
    streamWriter.writeString(getKeyword(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo)object);
  }
  
}
