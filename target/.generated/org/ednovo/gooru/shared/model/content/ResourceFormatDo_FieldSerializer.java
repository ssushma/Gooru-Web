package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ResourceFormatDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getDisplayName(org.ednovo.gooru.shared.model.content.ResourceFormatDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceFormatDo.class, instance, "displayName");
  }
  
  private static void setDisplayName(org.ednovo.gooru.shared.model.content.ResourceFormatDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceFormatDo.class, instance, "displayName", value);
  }
  
  private static java.lang.String getValue(org.ednovo.gooru.shared.model.content.ResourceFormatDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceFormatDo.class, instance, "value");
  }
  
  private static void setValue(org.ednovo.gooru.shared.model.content.ResourceFormatDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceFormatDo.class, instance, "value", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ResourceFormatDo instance) throws SerializationException {
    setDisplayName(instance, streamReader.readString());
    setValue(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ResourceFormatDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ResourceFormatDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ResourceFormatDo instance) throws SerializationException {
    streamWriter.writeString(getDisplayName(instance));
    streamWriter.writeString(getValue(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ResourceFormatDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ResourceFormatDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ResourceFormatDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ResourceFormatDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ResourceFormatDo)object);
  }
  
}
