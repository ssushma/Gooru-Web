package com.google.gwt.libideas.logging.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Level_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.libideas.logging.shared.Level instance) throws SerializationException {
    instance.isControl = streamReader.readBoolean();
    instance.name = streamReader.readString();
    instance.value = streamReader.readInt();
    
  }
  
  public static com.google.gwt.libideas.logging.shared.Level instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.libideas.logging.shared.Level();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.libideas.logging.shared.Level instance) throws SerializationException {
    streamWriter.writeBoolean(instance.isControl);
    streamWriter.writeString(instance.name);
    streamWriter.writeInt(instance.value);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.libideas.logging.shared.Level_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.libideas.logging.shared.Level_FieldSerializer.deserialize(reader, (com.google.gwt.libideas.logging.shared.Level)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.libideas.logging.shared.Level_FieldSerializer.serialize(writer, (com.google.gwt.libideas.logging.shared.Level)object);
  }
  
}
