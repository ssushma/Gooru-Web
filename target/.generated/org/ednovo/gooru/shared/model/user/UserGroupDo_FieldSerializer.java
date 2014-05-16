package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserGroupDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static boolean getActiveFlag(org.ednovo.gooru.shared.model.user.UserGroupDo instance) {
    return (java.lang.Boolean) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserGroupDo.class, instance, "activeFlag");
  }
  
  private static void setActiveFlag(org.ednovo.gooru.shared.model.user.UserGroupDo instance, boolean value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserGroupDo.class, instance, "activeFlag", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.OrganizationDo getOrganization(org.ednovo.gooru.shared.model.user.UserGroupDo instance) {
    return (org.ednovo.gooru.shared.model.user.OrganizationDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserGroupDo.class, instance, "organization");
  }
  
  private static void setOrganization(org.ednovo.gooru.shared.model.user.UserGroupDo instance, org.ednovo.gooru.shared.model.user.OrganizationDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserGroupDo.class, instance, "organization", value);
  }
  
  private static java.lang.String getUserGroupType(org.ednovo.gooru.shared.model.user.UserGroupDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserGroupDo.class, instance, "userGroupType");
  }
  
  private static void setUserGroupType(org.ednovo.gooru.shared.model.user.UserGroupDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserGroupDo.class, instance, "userGroupType", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.UserGroupDo instance) throws SerializationException {
    setActiveFlag(instance, streamReader.readBoolean());
    setOrganization(instance, (org.ednovo.gooru.shared.model.user.OrganizationDo) streamReader.readObject());
    setUserGroupType(instance, streamReader.readString());
    
    org.ednovo.gooru.shared.model.user.PartyDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.user.UserGroupDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.UserGroupDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.UserGroupDo instance) throws SerializationException {
    streamWriter.writeBoolean(getActiveFlag(instance));
    streamWriter.writeObject(getOrganization(instance));
    streamWriter.writeString(getUserGroupType(instance));
    
    org.ednovo.gooru.shared.model.user.PartyDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.UserGroupDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.UserGroupDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.UserGroupDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.UserGroupDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.UserGroupDo)object);
  }
  
}
