package com.bramosystems.oss.player.core.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class PlayException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.bramosystems.oss.player.core.client.PlayException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.bramosystems.oss.player.core.client.PlayException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.bramosystems.oss.player.core.client.PlayException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.bramosystems.oss.player.core.client.PlayException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.bramosystems.oss.player.core.client.PlayException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.bramosystems.oss.player.core.client.PlayException_FieldSerializer.deserialize(reader, (com.bramosystems.oss.player.core.client.PlayException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.bramosystems.oss.player.core.client.PlayException_FieldSerializer.serialize(writer, (com.bramosystems.oss.player.core.client.PlayException)object);
  }
  
}
