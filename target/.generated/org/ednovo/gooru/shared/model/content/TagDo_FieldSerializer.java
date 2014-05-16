package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TagDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static boolean getActiveFlag(org.ednovo.gooru.shared.model.content.TagDo instance) {
    return (java.lang.Boolean) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "activeFlag");
  }
  
  private static void setActiveFlag(org.ednovo.gooru.shared.model.content.TagDo instance, boolean value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "activeFlag", value);
  }
  
  private static org.ednovo.gooru.shared.model.content.ContentDo getContent(org.ednovo.gooru.shared.model.content.TagDo instance) {
    return (org.ednovo.gooru.shared.model.content.ContentDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "content");
  }
  
  private static void setContent(org.ednovo.gooru.shared.model.content.TagDo instance, org.ednovo.gooru.shared.model.content.ContentDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "content", value);
  }
  
  private static java.util.Date getCreatedOn(org.ednovo.gooru.shared.model.content.TagDo instance) {
    return (java.util.Date) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "createdOn");
  }
  
  private static void setCreatedOn(org.ednovo.gooru.shared.model.content.TagDo instance, java.util.Date value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "createdOn", value);
  }
  
  private static java.lang.String getLabel(org.ednovo.gooru.shared.model.content.TagDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "label");
  }
  
  private static void setLabel(org.ednovo.gooru.shared.model.content.TagDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "label", value);
  }
  
  private static java.lang.String getTagUid(org.ednovo.gooru.shared.model.content.TagDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "tagUid");
  }
  
  private static void setTagUid(org.ednovo.gooru.shared.model.content.TagDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "tagUid", value);
  }
  
  private static java.lang.String getType(org.ednovo.gooru.shared.model.content.TagDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "type");
  }
  
  private static void setType(org.ednovo.gooru.shared.model.content.TagDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "type", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.UserDo getUser(org.ednovo.gooru.shared.model.content.TagDo instance) {
    return (org.ednovo.gooru.shared.model.user.UserDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "user");
  }
  
  private static void setUser(org.ednovo.gooru.shared.model.content.TagDo instance, org.ednovo.gooru.shared.model.user.UserDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TagDo.class, instance, "user", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.TagDo instance) throws SerializationException {
    setActiveFlag(instance, streamReader.readBoolean());
    setContent(instance, (org.ednovo.gooru.shared.model.content.ContentDo) streamReader.readObject());
    setCreatedOn(instance, (java.util.Date) streamReader.readObject());
    setLabel(instance, streamReader.readString());
    setTagUid(instance, streamReader.readString());
    setType(instance, streamReader.readString());
    setUser(instance, (org.ednovo.gooru.shared.model.user.UserDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.TagDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.TagDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.TagDo instance) throws SerializationException {
    streamWriter.writeBoolean(getActiveFlag(instance));
    streamWriter.writeObject(getContent(instance));
    streamWriter.writeObject(getCreatedOn(instance));
    streamWriter.writeString(getLabel(instance));
    streamWriter.writeString(getTagUid(instance));
    streamWriter.writeString(getType(instance));
    streamWriter.writeObject(getUser(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.TagDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.TagDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.TagDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.TagDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.TagDo)object);
  }
  
}
