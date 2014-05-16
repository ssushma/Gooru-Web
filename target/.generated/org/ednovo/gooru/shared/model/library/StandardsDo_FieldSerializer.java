package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class StandardsDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCode(org.ednovo.gooru.shared.model.library.StandardsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.StandardsDo.class, instance, "code");
  }
  
  private static void setCode(org.ednovo.gooru.shared.model.library.StandardsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.StandardsDo.class, instance, "code", value);
  }
  
  private static java.util.ArrayList getData(org.ednovo.gooru.shared.model.library.StandardsDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.StandardsDo.class, instance, "data");
  }
  
  private static void setData(org.ednovo.gooru.shared.model.library.StandardsDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.StandardsDo.class, instance, "data", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.StandardsDo instance) throws SerializationException {
    setCode(instance, streamReader.readString());
    setData(instance, (java.util.ArrayList) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.StandardsDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.StandardsDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.StandardsDo instance) throws SerializationException {
    streamWriter.writeString(getCode(instance));
    streamWriter.writeObject(getData(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.StandardsDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.StandardsDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.StandardsDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.StandardsDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.StandardsDo)object);
  }
  
}
