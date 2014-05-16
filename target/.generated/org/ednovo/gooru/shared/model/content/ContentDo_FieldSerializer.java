package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ContentDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static org.ednovo.gooru.shared.model.user.UserDo getCreator(org.ednovo.gooru.shared.model.content.ContentDo instance) {
    return (org.ednovo.gooru.shared.model.user.UserDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentDo.class, instance, "creator");
  }
  
  private static void setCreator(org.ednovo.gooru.shared.model.content.ContentDo instance, org.ednovo.gooru.shared.model.user.UserDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentDo.class, instance, "creator", value);
  }
  
  private static java.lang.String getGooruOid(org.ednovo.gooru.shared.model.content.ContentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentDo.class, instance, "gooruOid");
  }
  
  private static void setGooruOid(org.ednovo.gooru.shared.model.content.ContentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentDo.class, instance, "gooruOid", value);
  }
  
  private static java.lang.String getSharing(org.ednovo.gooru.shared.model.content.ContentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentDo.class, instance, "sharing");
  }
  
  private static void setSharing(org.ednovo.gooru.shared.model.content.ContentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentDo.class, instance, "sharing", value);
  }
  
  private static java.util.Set getTaxonomySet(org.ednovo.gooru.shared.model.content.ContentDo instance) {
    return (java.util.Set) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentDo.class, instance, "taxonomySet");
  }
  
  private static void setTaxonomySet(org.ednovo.gooru.shared.model.content.ContentDo instance, java.util.Set value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentDo.class, instance, "taxonomySet", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.UserDo getUser(org.ednovo.gooru.shared.model.content.ContentDo instance) {
    return (org.ednovo.gooru.shared.model.user.UserDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentDo.class, instance, "user");
  }
  
  private static void setUser(org.ednovo.gooru.shared.model.content.ContentDo instance, org.ednovo.gooru.shared.model.user.UserDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentDo.class, instance, "user", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ContentDo instance) throws SerializationException {
    setCreator(instance, (org.ednovo.gooru.shared.model.user.UserDo) streamReader.readObject());
    setGooruOid(instance, streamReader.readString());
    setSharing(instance, streamReader.readString());
    setTaxonomySet(instance, (java.util.Set) streamReader.readObject());
    setUser(instance, (org.ednovo.gooru.shared.model.user.UserDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ContentDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ContentDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ContentDo instance) throws SerializationException {
    streamWriter.writeObject(getCreator(instance));
    streamWriter.writeString(getGooruOid(instance));
    streamWriter.writeString(getSharing(instance));
    streamWriter.writeObject(getTaxonomySet(instance));
    streamWriter.writeObject(getUser(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ContentDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ContentDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ContentDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ContentDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ContentDo)object);
  }
  
}
