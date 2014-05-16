package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CustomFieldDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getOptionalKey(org.ednovo.gooru.shared.model.user.CustomFieldDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.CustomFieldDo.class, instance, "optionalKey");
  }
  
  private static void setOptionalKey(org.ednovo.gooru.shared.model.user.CustomFieldDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.CustomFieldDo.class, instance, "optionalKey", value);
  }
  
  private static java.lang.String getOptionalValue(org.ednovo.gooru.shared.model.user.CustomFieldDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.CustomFieldDo.class, instance, "optionalValue");
  }
  
  private static void setOptionalValue(org.ednovo.gooru.shared.model.user.CustomFieldDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.CustomFieldDo.class, instance, "optionalValue", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.CustomFieldDo instance) throws SerializationException {
    setOptionalKey(instance, streamReader.readString());
    setOptionalValue(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.CustomFieldDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.CustomFieldDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.CustomFieldDo instance) throws SerializationException {
    streamWriter.writeString(getOptionalKey(instance));
    streamWriter.writeString(getOptionalValue(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.CustomFieldDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.CustomFieldDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.CustomFieldDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.CustomFieldDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.CustomFieldDo)object);
  }
  
}
