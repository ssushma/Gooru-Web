package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserRoleAssocDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static org.ednovo.gooru.shared.model.user.UserRoleDo getRole(org.ednovo.gooru.shared.model.user.UserRoleAssocDo instance) {
    return (org.ednovo.gooru.shared.model.user.UserRoleDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserRoleAssocDo.class, instance, "role");
  }
  
  private static void setRole(org.ednovo.gooru.shared.model.user.UserRoleAssocDo instance, org.ednovo.gooru.shared.model.user.UserRoleDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserRoleAssocDo.class, instance, "role", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.UserRoleAssocDo instance) throws SerializationException {
    setRole(instance, (org.ednovo.gooru.shared.model.user.UserRoleDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.UserRoleAssocDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.UserRoleAssocDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.UserRoleAssocDo instance) throws SerializationException {
    streamWriter.writeObject(getRole(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.UserRoleAssocDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.UserRoleAssocDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.UserRoleAssocDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.UserRoleAssocDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.UserRoleAssocDo)object);
  }
  
}
