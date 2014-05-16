package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ResponseStatusDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getCode(org.ednovo.gooru.shared.model.user.ResponseStatusDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.ResponseStatusDo.class, instance, "code");
  }
  
  private static void setCode(org.ednovo.gooru.shared.model.user.ResponseStatusDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.ResponseStatusDo.class, instance, "code", value);
  }
  
  private static java.lang.String getStatus(org.ednovo.gooru.shared.model.user.ResponseStatusDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.ResponseStatusDo.class, instance, "status");
  }
  
  private static void setStatus(org.ednovo.gooru.shared.model.user.ResponseStatusDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.ResponseStatusDo.class, instance, "status", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.ResponseStatusDo instance) throws SerializationException {
    setCode(instance, (java.lang.Integer) streamReader.readObject());
    setStatus(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.ResponseStatusDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.ResponseStatusDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.ResponseStatusDo instance) throws SerializationException {
    streamWriter.writeObject(getCode(instance));
    streamWriter.writeString(getStatus(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.ResponseStatusDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.ResponseStatusDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.ResponseStatusDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.ResponseStatusDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.ResponseStatusDo)object);
  }
  
}
