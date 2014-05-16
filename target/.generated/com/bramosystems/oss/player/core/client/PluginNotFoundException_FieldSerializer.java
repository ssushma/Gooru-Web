package com.bramosystems.oss.player.core.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class PluginNotFoundException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static com.bramosystems.oss.player.core.client.Plugin getPlugin(com.bramosystems.oss.player.core.client.PluginNotFoundException instance) {
    return (com.bramosystems.oss.player.core.client.Plugin) ReflectionHelper.getField(com.bramosystems.oss.player.core.client.PluginNotFoundException.class, instance, "plugin");
  }
  
  private static void setPlugin(com.bramosystems.oss.player.core.client.PluginNotFoundException instance, com.bramosystems.oss.player.core.client.Plugin value) 
  {
    ReflectionHelper.setField(com.bramosystems.oss.player.core.client.PluginNotFoundException.class, instance, "plugin", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, com.bramosystems.oss.player.core.client.PluginNotFoundException instance) throws SerializationException {
    setPlugin(instance, (com.bramosystems.oss.player.core.client.Plugin) streamReader.readObject());
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.bramosystems.oss.player.core.client.PluginNotFoundException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.bramosystems.oss.player.core.client.PluginNotFoundException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.bramosystems.oss.player.core.client.PluginNotFoundException instance) throws SerializationException {
    streamWriter.writeObject(getPlugin(instance));
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.bramosystems.oss.player.core.client.PluginNotFoundException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.bramosystems.oss.player.core.client.PluginNotFoundException_FieldSerializer.deserialize(reader, (com.bramosystems.oss.player.core.client.PluginNotFoundException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.bramosystems.oss.player.core.client.PluginNotFoundException_FieldSerializer.serialize(writer, (com.bramosystems.oss.player.core.client.PluginNotFoundException)object);
  }
  
}
