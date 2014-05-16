package org.ednovo.gooru.shared.model.code;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CodeDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCode(org.ednovo.gooru.shared.model.code.CodeDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.CodeDo.class, instance, "code");
  }
  
  private static void setCode(org.ednovo.gooru.shared.model.code.CodeDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.CodeDo.class, instance, "code", value);
  }
  
  private static java.lang.Integer getCodeId(org.ednovo.gooru.shared.model.code.CodeDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.CodeDo.class, instance, "codeId");
  }
  
  private static void setCodeId(org.ednovo.gooru.shared.model.code.CodeDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.CodeDo.class, instance, "codeId", value);
  }
  
  private static java.lang.Short getDepth(org.ednovo.gooru.shared.model.code.CodeDo instance) {
    return (java.lang.Short) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.CodeDo.class, instance, "depth");
  }
  
  private static void setDepth(org.ednovo.gooru.shared.model.code.CodeDo instance, java.lang.Short value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.CodeDo.class, instance, "depth", value);
  }
  
  private static java.lang.String getLabel(org.ednovo.gooru.shared.model.code.CodeDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.CodeDo.class, instance, "label");
  }
  
  private static void setLabel(org.ednovo.gooru.shared.model.code.CodeDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.CodeDo.class, instance, "label", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.code.CodeDo instance) throws SerializationException {
    setCode(instance, streamReader.readString());
    setCodeId(instance, (java.lang.Integer) streamReader.readObject());
    setDepth(instance, (java.lang.Short) streamReader.readObject());
    setLabel(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.code.CodeDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.code.CodeDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.code.CodeDo instance) throws SerializationException {
    streamWriter.writeString(getCode(instance));
    streamWriter.writeObject(getCodeId(instance));
    streamWriter.writeObject(getDepth(instance));
    streamWriter.writeString(getLabel(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.code.CodeDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.code.CodeDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.code.CodeDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.code.CodeDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.code.CodeDo)object);
  }
  
}
