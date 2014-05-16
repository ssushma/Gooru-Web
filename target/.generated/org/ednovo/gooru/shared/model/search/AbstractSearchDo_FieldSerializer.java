package org.ednovo.gooru.shared.model.search;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AbstractSearchDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getCollectionItemsCount(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "collectionItemsCount");
  }
  
  private static void setCollectionItemsCount(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "collectionItemsCount", value);
  }
  
  private static java.util.Map getFilters(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) {
    return (java.util.Map) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "filters");
  }
  
  private static void setFilters(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance, java.util.Map value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "filters", value);
  }
  
  private static java.lang.String getNotFriendly(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "notFriendly");
  }
  
  private static void setNotFriendly(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "notFriendly", value);
  }
  
  private static int getPageNum(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "pageNum");
  }
  
  private static void setPageNum(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "pageNum", value);
  }
  
  private static int getPageSize(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "pageSize");
  }
  
  private static void setPageSize(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "pageSize", value);
  }
  
  private static java.lang.String getQuery(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "query");
  }
  
  private static void setQuery(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "query", value);
  }
  
  private static int getSearchHits(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "searchHits");
  }
  
  private static void setSearchHits(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "searchHits", value);
  }
  
  private static java.lang.Object getSearchResults(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) {
    return (java.lang.Object) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "searchResults");
  }
  
  private static void setSearchResults(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance, java.lang.Object value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "searchResults", value);
  }
  
  private static java.lang.String getType(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "type");
  }
  
  private static void setType(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "type", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getVersion(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) {
    return (java.lang.Long) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "version");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setVersion(org.ednovo.gooru.shared.model.search.AbstractSearchDo instance, long value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.AbstractSearchDo.class, instance, "version", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) throws SerializationException {
    setCollectionItemsCount(instance, (java.lang.Integer) streamReader.readObject());
    setFilters(instance, (java.util.Map) streamReader.readObject());
    setNotFriendly(instance, streamReader.readString());
    setPageNum(instance, streamReader.readInt());
    setPageSize(instance, streamReader.readInt());
    setQuery(instance, streamReader.readString());
    setSearchHits(instance, streamReader.readInt());
    setSearchResults(instance, streamReader.readObject());
    setType(instance, streamReader.readString());
    setVersion(instance, streamReader.readLong());
    
  }
  
  public static org.ednovo.gooru.shared.model.search.AbstractSearchDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.search.AbstractSearchDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.search.AbstractSearchDo instance) throws SerializationException {
    streamWriter.writeObject(getCollectionItemsCount(instance));
    streamWriter.writeObject(getFilters(instance));
    streamWriter.writeString(getNotFriendly(instance));
    streamWriter.writeInt(getPageNum(instance));
    streamWriter.writeInt(getPageSize(instance));
    streamWriter.writeString(getQuery(instance));
    streamWriter.writeInt(getSearchHits(instance));
    streamWriter.writeObject(getSearchResults(instance));
    streamWriter.writeString(getType(instance));
    streamWriter.writeLong(getVersion(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.search.AbstractSearchDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.AbstractSearchDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.search.AbstractSearchDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.AbstractSearchDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.search.AbstractSearchDo)object);
  }
  
}
