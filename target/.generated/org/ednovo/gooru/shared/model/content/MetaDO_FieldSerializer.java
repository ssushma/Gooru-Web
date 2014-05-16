package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MetaDO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getCollaboratorCount(org.ednovo.gooru.shared.model.content.MetaDO instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.MetaDO.class, instance, "collaboratorCount");
  }
  
  private static void setCollaboratorCount(org.ednovo.gooru.shared.model.content.MetaDO instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.MetaDO.class, instance, "collaboratorCount", value);
  }
  
  private static boolean getIsCollaborator(org.ednovo.gooru.shared.model.content.MetaDO instance) {
    return (java.lang.Boolean) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.MetaDO.class, instance, "isCollaborator");
  }
  
  private static void setIsCollaborator(org.ednovo.gooru.shared.model.content.MetaDO instance, boolean value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.MetaDO.class, instance, "isCollaborator", value);
  }
  
  private static java.util.List getPermissions(org.ednovo.gooru.shared.model.content.MetaDO instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.MetaDO.class, instance, "permissions");
  }
  
  private static void setPermissions(org.ednovo.gooru.shared.model.content.MetaDO instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.MetaDO.class, instance, "permissions", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.MetaDO instance) throws SerializationException {
    setCollaboratorCount(instance, (java.lang.Integer) streamReader.readObject());
    setIsCollaborator(instance, streamReader.readBoolean());
    setPermissions(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.MetaDO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.MetaDO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.MetaDO instance) throws SerializationException {
    streamWriter.writeObject(getCollaboratorCount(instance));
    streamWriter.writeBoolean(getIsCollaborator(instance));
    streamWriter.writeObject(getPermissions(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.MetaDO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.MetaDO_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.MetaDO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.MetaDO_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.MetaDO)object);
  }
  
}
