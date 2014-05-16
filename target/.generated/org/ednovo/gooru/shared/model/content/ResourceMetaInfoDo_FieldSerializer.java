package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ResourceMetaInfoDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo instance) throws SerializationException {
    instance.description = streamReader.readString();
    instance.images = (java.util.List) streamReader.readObject();
    instance.title = streamReader.readString();
    instance.videoDuration = (java.lang.Integer) streamReader.readObject();
    
    org.ednovo.gooru.shared.model.content.ResourceDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo instance) throws SerializationException {
    streamWriter.writeString(instance.description);
    streamWriter.writeObject(instance.images);
    streamWriter.writeString(instance.title);
    streamWriter.writeObject(instance.videoDuration);
    
    org.ednovo.gooru.shared.model.content.ResourceDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo)object);
  }
  
}
