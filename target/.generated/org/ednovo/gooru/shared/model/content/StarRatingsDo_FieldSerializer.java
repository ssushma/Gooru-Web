package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class StarRatingsDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAssocGooruOid(org.ednovo.gooru.shared.model.content.StarRatingsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.StarRatingsDo.class, instance, "assocGooruOid");
  }
  
  private static void setAssocGooruOid(org.ednovo.gooru.shared.model.content.StarRatingsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.StarRatingsDo.class, instance, "assocGooruOid", value);
  }
  
  private static java.lang.String getDeleteReactionGooruOid(org.ednovo.gooru.shared.model.content.StarRatingsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.StarRatingsDo.class, instance, "deleteReactionGooruOid");
  }
  
  private static void setDeleteReactionGooruOid(org.ednovo.gooru.shared.model.content.StarRatingsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.StarRatingsDo.class, instance, "deleteReactionGooruOid", value);
  }
  
  private static java.lang.Integer getScore(org.ednovo.gooru.shared.model.content.StarRatingsDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.StarRatingsDo.class, instance, "score");
  }
  
  private static void setScore(org.ednovo.gooru.shared.model.content.StarRatingsDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.StarRatingsDo.class, instance, "score", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.StarRatingsDo instance) throws SerializationException {
    setAssocGooruOid(instance, streamReader.readString());
    setDeleteReactionGooruOid(instance, streamReader.readString());
    setScore(instance, (java.lang.Integer) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.StarRatingsDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.StarRatingsDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.StarRatingsDo instance) throws SerializationException {
    streamWriter.writeString(getAssocGooruOid(instance));
    streamWriter.writeString(getDeleteReactionGooruOid(instance));
    streamWriter.writeObject(getScore(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.StarRatingsDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.StarRatingsDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.StarRatingsDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.StarRatingsDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.StarRatingsDo)object);
  }
  
}
