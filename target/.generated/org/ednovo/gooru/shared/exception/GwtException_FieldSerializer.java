package org.ednovo.gooru.shared.exception;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GwtException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.List getErrors(org.ednovo.gooru.shared.exception.GwtException instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.exception.GwtException.class, instance, "errors");
  }
  
  private static void setErrors(org.ednovo.gooru.shared.exception.GwtException instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.exception.GwtException.class, instance, "errors", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.exception.GwtException instance) throws SerializationException {
    setErrors(instance, (java.util.List) streamReader.readObject());
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.exception.GwtException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.exception.GwtException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.exception.GwtException instance) throws SerializationException {
    streamWriter.writeObject(getErrors(instance));
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.exception.GwtException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.exception.GwtException_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.exception.GwtException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.exception.GwtException_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.exception.GwtException)object);
  }
  
}
