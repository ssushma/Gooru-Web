package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CollectionItemDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static org.ednovo.gooru.shared.model.content.CollectionDo getCollection(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (org.ednovo.gooru.shared.model.content.CollectionDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "collection");
  }
  
  private static void setCollection(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, org.ednovo.gooru.shared.model.content.CollectionDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "collection", value);
  }
  
  private static java.lang.String getCollectionItemId(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "collectionItemId");
  }
  
  private static void setCollectionItemId(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "collectionItemId", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo getCollectionQuestionItemDo(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "collectionQuestionItemDo");
  }
  
  private static void setCollectionQuestionItemDo(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "collectionQuestionItemDo", value);
  }
  
  private static java.util.List getCourse(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "course");
  }
  
  private static void setCourse(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "course", value);
  }
  
  private static java.lang.Integer getItemSequence(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "itemSequence");
  }
  
  private static void setItemSequence(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "itemSequence", value);
  }
  
  private static java.lang.String getItemType(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "itemType");
  }
  
  private static void setItemType(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "itemType", value);
  }
  
  private static java.lang.String getNarration(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "narration");
  }
  
  private static void setNarration(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "narration", value);
  }
  
  private static java.lang.String getNarrationType(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "narrationType");
  }
  
  private static void setNarrationType(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "narrationType", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.RatingDo getRating(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (org.ednovo.gooru.shared.model.content.RatingDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "rating");
  }
  
  private static void setRating(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, org.ednovo.gooru.shared.model.content.RatingDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "rating", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ResourceDo getResource(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (org.ednovo.gooru.shared.model.content.ResourceDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "resource");
  }
  
  private static void setResource(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, org.ednovo.gooru.shared.model.content.ResourceDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "resource", value);
  }
  
  private static int getResourceCount(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "resourceCount");
  }
  
  private static void setResourceCount(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "resourceCount", value);
  }
  
  private static java.util.List getStandards(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "standards");
  }
  
  private static void setStandards(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "standards", value);
  }
  
  private static java.lang.String getStart(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "start");
  }
  
  private static void setStart(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "start", value);
  }
  
  private static java.lang.Integer getStatusCode(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "statusCode");
  }
  
  private static void setStatusCode(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "statusCode", value);
  }
  
  private static java.lang.String getStop(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "stop");
  }
  
  private static void setStop(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "stop", value);
  }
  
  private static java.lang.Integer getTotalHitCount(org.ednovo.gooru.shared.model.content.CollectionItemDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "totalHitCount");
  }
  
  private static void setTotalHitCount(org.ednovo.gooru.shared.model.content.CollectionItemDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionItemDo.class, instance, "totalHitCount", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.CollectionItemDo instance) throws SerializationException {
    setCollection(instance, (org.ednovo.gooru.shared.model.content.CollectionDo) streamReader.readObject());
    setCollectionItemId(instance, streamReader.readString());
    setCollectionQuestionItemDo(instance, (org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo) streamReader.readObject());
    setCourse(instance, (java.util.List) streamReader.readObject());
    setItemSequence(instance, (java.lang.Integer) streamReader.readObject());
    setItemType(instance, streamReader.readString());
    setNarration(instance, streamReader.readString());
    setNarrationType(instance, streamReader.readString());
    setRating(instance, (org.ednovo.gooru.shared.model.content.RatingDo) streamReader.readObject());
    setResource(instance, (org.ednovo.gooru.shared.model.content.ResourceDo) streamReader.readObject());
    setResourceCount(instance, streamReader.readInt());
    setStandards(instance, (java.util.List) streamReader.readObject());
    setStart(instance, streamReader.readString());
    setStatusCode(instance, (java.lang.Integer) streamReader.readObject());
    setStop(instance, streamReader.readString());
    setTotalHitCount(instance, (java.lang.Integer) streamReader.readObject());
    
    org.ednovo.gooru.shared.model.search.ResourceSearchResultDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.content.CollectionItemDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.CollectionItemDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.CollectionItemDo instance) throws SerializationException {
    streamWriter.writeObject(getCollection(instance));
    streamWriter.writeString(getCollectionItemId(instance));
    streamWriter.writeObject(getCollectionQuestionItemDo(instance));
    streamWriter.writeObject(getCourse(instance));
    streamWriter.writeObject(getItemSequence(instance));
    streamWriter.writeString(getItemType(instance));
    streamWriter.writeString(getNarration(instance));
    streamWriter.writeString(getNarrationType(instance));
    streamWriter.writeObject(getRating(instance));
    streamWriter.writeObject(getResource(instance));
    streamWriter.writeInt(getResourceCount(instance));
    streamWriter.writeObject(getStandards(instance));
    streamWriter.writeString(getStart(instance));
    streamWriter.writeObject(getStatusCode(instance));
    streamWriter.writeString(getStop(instance));
    streamWriter.writeObject(getTotalHitCount(instance));
    
    org.ednovo.gooru.shared.model.search.ResourceSearchResultDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.CollectionItemDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.CollectionItemDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.CollectionItemDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.CollectionItemDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.CollectionItemDo)object);
  }
  
}
