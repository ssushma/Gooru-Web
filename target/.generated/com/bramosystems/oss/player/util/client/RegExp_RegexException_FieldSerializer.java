package com.bramosystems.oss.player.util.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RegExp_RegexException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.bramosystems.oss.player.util.client.RegExp.RegexException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.bramosystems.oss.player.util.client.RegExp.RegexException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.bramosystems.oss.player.util.client.RegExp.RegexException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.bramosystems.oss.player.util.client.RegExp.RegexException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.bramosystems.oss.player.util.client.RegExp_RegexException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.bramosystems.oss.player.util.client.RegExp_RegexException_FieldSerializer.deserialize(reader, (com.bramosystems.oss.player.util.client.RegExp.RegexException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.bramosystems.oss.player.util.client.RegExp_RegexException_FieldSerializer.serialize(writer, (com.bramosystems.oss.player.util.client.RegExp.RegexException)object);
  }
  
}
