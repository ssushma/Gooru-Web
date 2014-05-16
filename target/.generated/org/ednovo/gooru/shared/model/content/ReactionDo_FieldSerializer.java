package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ReactionDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAssocGooruOid(org.ednovo.gooru.shared.model.content.ReactionDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ReactionDo.class, instance, "assocGooruOid");
  }
  
  private static void setAssocGooruOid(org.ednovo.gooru.shared.model.content.ReactionDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ReactionDo.class, instance, "assocGooruOid", value);
  }
  
  private static java.lang.String getDeleteReactionGooruOid(org.ednovo.gooru.shared.model.content.ReactionDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ReactionDo.class, instance, "deleteReactionGooruOid");
  }
  
  private static void setDeleteReactionGooruOid(org.ednovo.gooru.shared.model.content.ReactionDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ReactionDo.class, instance, "deleteReactionGooruOid", value);
  }
  
  private static java.lang.String getReactionText(org.ednovo.gooru.shared.model.content.ReactionDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ReactionDo.class, instance, "reactionText");
  }
  
  private static void setReactionText(org.ednovo.gooru.shared.model.content.ReactionDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ReactionDo.class, instance, "reactionText", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ReactionDo instance) throws SerializationException {
    setAssocGooruOid(instance, streamReader.readString());
    setDeleteReactionGooruOid(instance, streamReader.readString());
    setReactionText(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ReactionDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ReactionDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ReactionDo instance) throws SerializationException {
    streamWriter.writeString(getAssocGooruOid(instance));
    streamWriter.writeString(getDeleteReactionGooruOid(instance));
    streamWriter.writeString(getReactionText(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ReactionDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ReactionDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ReactionDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ReactionDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ReactionDo)object);
  }
  
}
