package org.ednovo.gooru.shared.model.search;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CollectionSearchResultDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getCollaboratorCount(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "collaboratorCount");
  }
  
  private static void setCollaboratorCount(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "collaboratorCount", value);
  }
  
  private static java.lang.String getCreatorName(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "creatorName");
  }
  
  private static void setCreatorName(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "creatorName", value);
  }
  
  private static int getHasAddedToShelf(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "hasAddedToShelf");
  }
  
  private static void setHasAddedToShelf(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "hasAddedToShelf", value);
  }
  
  private static java.lang.Integer getOnlyResourceCount(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "onlyResourceCount");
  }
  
  private static void setOnlyResourceCount(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "onlyResourceCount", value);
  }
  
  private static int getQuestionCount(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "questionCount");
  }
  
  private static void setQuestionCount(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "questionCount", value);
  }
  
  private static int getResourceCount(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "resourceCount");
  }
  
  private static void setResourceCount(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.search.CollectionSearchResultDo.class, instance, "resourceCount", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance) throws SerializationException {
    setCollaboratorCount(instance, (java.lang.Integer) streamReader.readObject());
    setCreatorName(instance, streamReader.readString());
    setHasAddedToShelf(instance, streamReader.readInt());
    setOnlyResourceCount(instance, (java.lang.Integer) streamReader.readObject());
    setQuestionCount(instance, streamReader.readInt());
    setResourceCount(instance, streamReader.readInt());
    
    org.ednovo.gooru.shared.model.search.ResourceSearchResultDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.search.CollectionSearchResultDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.search.CollectionSearchResultDo instance) throws SerializationException {
    streamWriter.writeObject(getCollaboratorCount(instance));
    streamWriter.writeString(getCreatorName(instance));
    streamWriter.writeInt(getHasAddedToShelf(instance));
    streamWriter.writeObject(getOnlyResourceCount(instance));
    streamWriter.writeInt(getQuestionCount(instance));
    streamWriter.writeInt(getResourceCount(instance));
    
    org.ednovo.gooru.shared.model.search.ResourceSearchResultDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.search.CollectionSearchResultDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.CollectionSearchResultDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.search.CollectionSearchResultDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.search.CollectionSearchResultDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.search.CollectionSearchResultDo)object);
  }
  
}
