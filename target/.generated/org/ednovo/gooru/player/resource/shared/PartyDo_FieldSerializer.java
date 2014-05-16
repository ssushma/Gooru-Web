package org.ednovo.gooru.player.resource.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class PartyDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.Date getCreatedOn(org.ednovo.gooru.player.resource.shared.PartyDo instance) {
    return (java.util.Date) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "createdOn");
  }
  
  private static void setCreatedOn(org.ednovo.gooru.player.resource.shared.PartyDo instance, java.util.Date value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "createdOn", value);
  }
  
  private static java.util.Date getLastModifiedOn(org.ednovo.gooru.player.resource.shared.PartyDo instance) {
    return (java.util.Date) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "lastModifiedOn");
  }
  
  private static void setLastModifiedOn(org.ednovo.gooru.player.resource.shared.PartyDo instance, java.util.Date value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "lastModifiedOn", value);
  }
  
  private static java.lang.String getLastModifiedUserUid(org.ednovo.gooru.player.resource.shared.PartyDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "lastModifiedUserUid");
  }
  
  private static void setLastModifiedUserUid(org.ednovo.gooru.player.resource.shared.PartyDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "lastModifiedUserUid", value);
  }
  
  private static java.lang.String getPartyName(org.ednovo.gooru.player.resource.shared.PartyDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "partyName");
  }
  
  private static void setPartyName(org.ednovo.gooru.player.resource.shared.PartyDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "partyName", value);
  }
  
  private static java.lang.String getPartyType(org.ednovo.gooru.player.resource.shared.PartyDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "partyType");
  }
  
  private static void setPartyType(org.ednovo.gooru.player.resource.shared.PartyDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "partyType", value);
  }
  
  private static java.lang.String getPartyUid(org.ednovo.gooru.player.resource.shared.PartyDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "partyUid");
  }
  
  private static void setPartyUid(org.ednovo.gooru.player.resource.shared.PartyDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "partyUid", value);
  }
  
  private static java.lang.String getUserUid(org.ednovo.gooru.player.resource.shared.PartyDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "userUid");
  }
  
  private static void setUserUid(org.ednovo.gooru.player.resource.shared.PartyDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.PartyDo.class, instance, "userUid", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.resource.shared.PartyDo instance) throws SerializationException {
    setCreatedOn(instance, (java.util.Date) streamReader.readObject());
    setLastModifiedOn(instance, (java.util.Date) streamReader.readObject());
    setLastModifiedUserUid(instance, streamReader.readString());
    setPartyName(instance, streamReader.readString());
    setPartyType(instance, streamReader.readString());
    setPartyUid(instance, streamReader.readString());
    setUserUid(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.player.resource.shared.PartyDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.resource.shared.PartyDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.resource.shared.PartyDo instance) throws SerializationException {
    streamWriter.writeObject(getCreatedOn(instance));
    streamWriter.writeObject(getLastModifiedOn(instance));
    streamWriter.writeString(getLastModifiedUserUid(instance));
    streamWriter.writeString(getPartyName(instance));
    streamWriter.writeString(getPartyType(instance));
    streamWriter.writeString(getPartyUid(instance));
    streamWriter.writeString(getUserUid(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.resource.shared.PartyDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.PartyDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.resource.shared.PartyDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.PartyDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.resource.shared.PartyDo)object);
  }
  
}
