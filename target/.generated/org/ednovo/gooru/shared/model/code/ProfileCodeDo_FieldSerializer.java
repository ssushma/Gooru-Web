package org.ednovo.gooru.shared.model.code;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProfileCodeDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static org.ednovo.gooru.shared.model.code.CodeDo getCode(org.ednovo.gooru.shared.model.code.ProfileCodeDo instance) {
    return (org.ednovo.gooru.shared.model.code.CodeDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.ProfileCodeDo.class, instance, "code");
  }
  
  private static void setCode(org.ednovo.gooru.shared.model.code.ProfileCodeDo instance, org.ednovo.gooru.shared.model.code.CodeDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.ProfileCodeDo.class, instance, "code", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.code.ProfileCodeDo instance) throws SerializationException {
    setCode(instance, (org.ednovo.gooru.shared.model.code.CodeDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.code.ProfileCodeDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.code.ProfileCodeDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.code.ProfileCodeDo instance) throws SerializationException {
    streamWriter.writeObject(getCode(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.code.ProfileCodeDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.code.ProfileCodeDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.code.ProfileCodeDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.code.ProfileCodeDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.code.ProfileCodeDo)object);
  }
  
}
