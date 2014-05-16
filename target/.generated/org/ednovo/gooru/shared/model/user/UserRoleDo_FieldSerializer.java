package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserRoleDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getDescription(org.ednovo.gooru.shared.model.user.UserRoleDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserRoleDo.class, instance, "description");
  }
  
  private static void setDescription(org.ednovo.gooru.shared.model.user.UserRoleDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserRoleDo.class, instance, "description", value);
  }
  
  private static java.lang.String getName(org.ednovo.gooru.shared.model.user.UserRoleDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserRoleDo.class, instance, "name");
  }
  
  private static void setName(org.ednovo.gooru.shared.model.user.UserRoleDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserRoleDo.class, instance, "name", value);
  }
  
  private static java.lang.Short getRoleId(org.ednovo.gooru.shared.model.user.UserRoleDo instance) {
    return (java.lang.Short) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserRoleDo.class, instance, "roleId");
  }
  
  private static void setRoleId(org.ednovo.gooru.shared.model.user.UserRoleDo instance, java.lang.Short value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserRoleDo.class, instance, "roleId", value);
  }
  
  private static java.util.Set getRoleOperations(org.ednovo.gooru.shared.model.user.UserRoleDo instance) {
    return (java.util.Set) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserRoleDo.class, instance, "roleOperations");
  }
  
  private static void setRoleOperations(org.ednovo.gooru.shared.model.user.UserRoleDo instance, java.util.Set value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserRoleDo.class, instance, "roleOperations", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.UserRoleDo instance) throws SerializationException {
    setDescription(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setRoleId(instance, (java.lang.Short) streamReader.readObject());
    setRoleOperations(instance, (java.util.Set) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.UserRoleDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.UserRoleDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.UserRoleDo instance) throws SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getRoleId(instance));
    streamWriter.writeObject(getRoleOperations(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.UserRoleDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.UserRoleDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.UserRoleDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.UserRoleDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.UserRoleDo)object);
  }
  
}
