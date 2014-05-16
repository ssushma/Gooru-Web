package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ThumbnailDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static boolean getDefaultImage(org.ednovo.gooru.shared.model.content.ThumbnailDo instance) {
    return (java.lang.Boolean) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ThumbnailDo.class, instance, "defaultImage");
  }
  
  private static void setDefaultImage(org.ednovo.gooru.shared.model.content.ThumbnailDo instance, boolean value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ThumbnailDo.class, instance, "defaultImage", value);
  }
  
  private static java.lang.String getDimensions(org.ednovo.gooru.shared.model.content.ThumbnailDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ThumbnailDo.class, instance, "dimensions");
  }
  
  private static void setDimensions(org.ednovo.gooru.shared.model.content.ThumbnailDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ThumbnailDo.class, instance, "dimensions", value);
  }
  
  private static java.lang.String getUrl(org.ednovo.gooru.shared.model.content.ThumbnailDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ThumbnailDo.class, instance, "url");
  }
  
  private static void setUrl(org.ednovo.gooru.shared.model.content.ThumbnailDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ThumbnailDo.class, instance, "url", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ThumbnailDo instance) throws SerializationException {
    setDefaultImage(instance, streamReader.readBoolean());
    setDimensions(instance, streamReader.readString());
    setUrl(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ThumbnailDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ThumbnailDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ThumbnailDo instance) throws SerializationException {
    streamWriter.writeBoolean(getDefaultImage(instance));
    streamWriter.writeString(getDimensions(instance));
    streamWriter.writeString(getUrl(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ThumbnailDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ThumbnailDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ThumbnailDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ThumbnailDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ThumbnailDo)object);
  }
  
}
