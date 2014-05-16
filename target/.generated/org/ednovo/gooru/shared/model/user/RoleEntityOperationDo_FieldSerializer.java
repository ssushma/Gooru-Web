package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RoleEntityOperationDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static org.ednovo.gooru.shared.model.user.EntityOperationDo getEntityOperation(org.ednovo.gooru.shared.model.user.RoleEntityOperationDo instance) {
    return (org.ednovo.gooru.shared.model.user.EntityOperationDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.RoleEntityOperationDo.class, instance, "entityOperation");
  }
  
  private static void setEntityOperation(org.ednovo.gooru.shared.model.user.RoleEntityOperationDo instance, org.ednovo.gooru.shared.model.user.EntityOperationDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.RoleEntityOperationDo.class, instance, "entityOperation", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.RoleEntityOperationDo instance) throws SerializationException {
    setEntityOperation(instance, (org.ednovo.gooru.shared.model.user.EntityOperationDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.RoleEntityOperationDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.RoleEntityOperationDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.RoleEntityOperationDo instance) throws SerializationException {
    streamWriter.writeObject(getEntityOperation(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.RoleEntityOperationDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.RoleEntityOperationDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.RoleEntityOperationDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.RoleEntityOperationDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.RoleEntityOperationDo)object);
  }
  
}
