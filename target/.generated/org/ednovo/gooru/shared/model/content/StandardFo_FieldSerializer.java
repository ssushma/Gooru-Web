package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class StandardFo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCode(org.ednovo.gooru.shared.model.content.StandardFo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.StandardFo.class, instance, "code");
  }
  
  private static void setCode(org.ednovo.gooru.shared.model.content.StandardFo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.StandardFo.class, instance, "code", value);
  }
  
  private static java.lang.Integer getCodeId(org.ednovo.gooru.shared.model.content.StandardFo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.StandardFo.class, instance, "codeId");
  }
  
  private static void setCodeId(org.ednovo.gooru.shared.model.content.StandardFo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.StandardFo.class, instance, "codeId", value);
  }
  
  private static java.lang.String getDescription(org.ednovo.gooru.shared.model.content.StandardFo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.StandardFo.class, instance, "description");
  }
  
  private static void setDescription(org.ednovo.gooru.shared.model.content.StandardFo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.StandardFo.class, instance, "description", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.StandardFo instance) throws SerializationException {
    setCode(instance, streamReader.readString());
    setCodeId(instance, (java.lang.Integer) streamReader.readObject());
    setDescription(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.StandardFo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.StandardFo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.StandardFo instance) throws SerializationException {
    streamWriter.writeString(getCode(instance));
    streamWriter.writeObject(getCodeId(instance));
    streamWriter.writeString(getDescription(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.StandardFo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.StandardFo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.StandardFo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.StandardFo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.StandardFo)object);
  }
  
}
