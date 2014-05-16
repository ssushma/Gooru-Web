package com.bramosystems.oss.player.core.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Plugin_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getDesc(com.bramosystems.oss.player.core.client.Plugin instance) {
    return (java.lang.String) ReflectionHelper.getField(com.bramosystems.oss.player.core.client.Plugin.class, instance, "desc");
  }
  
  private static void setDesc(com.bramosystems.oss.player.core.client.Plugin instance, java.lang.String value) 
  {
    ReflectionHelper.setField(com.bramosystems.oss.player.core.client.Plugin.class, instance, "desc", value);
  }
  
  private static java.lang.String getDownloadURL(com.bramosystems.oss.player.core.client.Plugin instance) {
    return (java.lang.String) ReflectionHelper.getField(com.bramosystems.oss.player.core.client.Plugin.class, instance, "downloadURL");
  }
  
  private static void setDownloadURL(com.bramosystems.oss.player.core.client.Plugin instance, java.lang.String value) 
  {
    ReflectionHelper.setField(com.bramosystems.oss.player.core.client.Plugin.class, instance, "downloadURL", value);
  }
  
  private static com.bramosystems.oss.player.core.client.PluginVersion getVersion(com.bramosystems.oss.player.core.client.Plugin instance) {
    return (com.bramosystems.oss.player.core.client.PluginVersion) ReflectionHelper.getField(com.bramosystems.oss.player.core.client.Plugin.class, instance, "version");
  }
  
  private static void setVersion(com.bramosystems.oss.player.core.client.Plugin instance, com.bramosystems.oss.player.core.client.PluginVersion value) 
  {
    ReflectionHelper.setField(com.bramosystems.oss.player.core.client.Plugin.class, instance, "version", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, com.bramosystems.oss.player.core.client.Plugin instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.bramosystems.oss.player.core.client.Plugin instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.bramosystems.oss.player.core.client.Plugin[] values = com.bramosystems.oss.player.core.client.Plugin.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.bramosystems.oss.player.core.client.Plugin instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.bramosystems.oss.player.core.client.Plugin_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.bramosystems.oss.player.core.client.Plugin_FieldSerializer.deserialize(reader, (com.bramosystems.oss.player.core.client.Plugin)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.bramosystems.oss.player.core.client.Plugin_FieldSerializer.serialize(writer, (com.bramosystems.oss.player.core.client.Plugin)object);
  }
  
}
