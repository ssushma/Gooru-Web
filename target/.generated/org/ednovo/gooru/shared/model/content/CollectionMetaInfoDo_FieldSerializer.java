package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CollectionMetaInfoDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.List getAcknowledgement(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo.class, instance, "acknowledgement");
  }
  
  private static void setAcknowledgement(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo.class, instance, "acknowledgement", value);
  }
  
  private static java.util.List getCourse(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo.class, instance, "course");
  }
  
  private static void setCourse(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo.class, instance, "course", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.RatingDo getRating(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instance) {
    return (org.ednovo.gooru.shared.model.content.RatingDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo.class, instance, "rating");
  }
  
  private static void setRating(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instance, org.ednovo.gooru.shared.model.content.RatingDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo.class, instance, "rating", value);
  }
  
  private static java.util.List getStandards(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo.class, instance, "standards");
  }
  
  private static void setStandards(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo.class, instance, "standards", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instance) throws SerializationException {
    setAcknowledgement(instance, (java.util.List) streamReader.readObject());
    setCourse(instance, (java.util.List) streamReader.readObject());
    setRating(instance, (org.ednovo.gooru.shared.model.content.RatingDo) streamReader.readObject());
    setStandards(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo instance) throws SerializationException {
    streamWriter.writeObject(getAcknowledgement(instance));
    streamWriter.writeObject(getCourse(instance));
    streamWriter.writeObject(getRating(instance));
    streamWriter.writeObject(getStandards(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo)object);
  }
  
}
