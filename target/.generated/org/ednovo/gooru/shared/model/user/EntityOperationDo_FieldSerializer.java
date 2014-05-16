package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class EntityOperationDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getEntityName(org.ednovo.gooru.shared.model.user.EntityOperationDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.EntityOperationDo.class, instance, "entityName");
  }
  
  private static void setEntityName(org.ednovo.gooru.shared.model.user.EntityOperationDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.EntityOperationDo.class, instance, "entityName", value);
  }
  
  private static java.lang.Integer getEntityOperationId(org.ednovo.gooru.shared.model.user.EntityOperationDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.EntityOperationDo.class, instance, "entityOperationId");
  }
  
  private static void setEntityOperationId(org.ednovo.gooru.shared.model.user.EntityOperationDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.EntityOperationDo.class, instance, "entityOperationId", value);
  }
  
  private static java.lang.String getOperationName(org.ednovo.gooru.shared.model.user.EntityOperationDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.EntityOperationDo.class, instance, "operationName");
  }
  
  private static void setOperationName(org.ednovo.gooru.shared.model.user.EntityOperationDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.EntityOperationDo.class, instance, "operationName", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.EntityOperationDo instance) throws SerializationException {
    setEntityName(instance, streamReader.readString());
    setEntityOperationId(instance, (java.lang.Integer) streamReader.readObject());
    setOperationName(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.EntityOperationDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.EntityOperationDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.EntityOperationDo instance) throws SerializationException {
    streamWriter.writeString(getEntityName(instance));
    streamWriter.writeObject(getEntityOperationId(instance));
    streamWriter.writeString(getOperationName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.EntityOperationDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.EntityOperationDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.EntityOperationDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.EntityOperationDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.EntityOperationDo)object);
  }
  
}
