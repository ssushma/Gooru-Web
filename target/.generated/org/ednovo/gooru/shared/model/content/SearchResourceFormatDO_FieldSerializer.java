package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SearchResourceFormatDO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getValue(org.ednovo.gooru.shared.model.content.SearchResourceFormatDO instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.SearchResourceFormatDO.class, instance, "value");
  }
  
  private static void setValue(org.ednovo.gooru.shared.model.content.SearchResourceFormatDO instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.SearchResourceFormatDO.class, instance, "value", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.SearchResourceFormatDO instance) throws SerializationException {
    setValue(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.SearchResourceFormatDO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.SearchResourceFormatDO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.SearchResourceFormatDO instance) throws SerializationException {
    streamWriter.writeString(getValue(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.SearchResourceFormatDO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.SearchResourceFormatDO_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.SearchResourceFormatDO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.SearchResourceFormatDO_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.SearchResourceFormatDO)object);
  }
  
}
