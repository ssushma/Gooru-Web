package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GenderDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getGenderId(org.ednovo.gooru.shared.model.user.GenderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.GenderDo.class, instance, "genderId");
  }
  
  private static void setGenderId(org.ednovo.gooru.shared.model.user.GenderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.GenderDo.class, instance, "genderId", value);
  }
  
  private static java.lang.String getName(org.ednovo.gooru.shared.model.user.GenderDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.GenderDo.class, instance, "name");
  }
  
  private static void setName(org.ednovo.gooru.shared.model.user.GenderDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.GenderDo.class, instance, "name", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.GenderDo instance) throws SerializationException {
    setGenderId(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.GenderDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.GenderDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.GenderDo instance) throws SerializationException {
    streamWriter.writeString(getGenderId(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.GenderDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.GenderDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.GenderDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.GenderDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.GenderDo)object);
  }
  
}
