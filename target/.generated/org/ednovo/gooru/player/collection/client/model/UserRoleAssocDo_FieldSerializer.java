package org.ednovo.gooru.player.collection.client.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserRoleAssocDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static org.ednovo.gooru.player.collection.client.model.UserRoleDo getRole(org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo instance) {
    return (org.ednovo.gooru.player.collection.client.model.UserRoleDo) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo.class, instance, "role");
  }
  
  private static void setRole(org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo instance, org.ednovo.gooru.player.collection.client.model.UserRoleDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo.class, instance, "role", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo instance) throws SerializationException {
    setRole(instance, (org.ednovo.gooru.player.collection.client.model.UserRoleDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo instance) throws SerializationException {
    streamWriter.writeObject(getRole(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.collection.client.model.UserRoleAssocDo)object);
  }
  
}
