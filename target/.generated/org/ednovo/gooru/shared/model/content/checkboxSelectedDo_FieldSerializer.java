package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class checkboxSelectedDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getName(org.ednovo.gooru.shared.model.content.checkboxSelectedDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.checkboxSelectedDo.class, instance, "name");
  }
  
  private static void setName(org.ednovo.gooru.shared.model.content.checkboxSelectedDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.checkboxSelectedDo.class, instance, "name", value);
  }
  
  private static boolean getSelected(org.ednovo.gooru.shared.model.content.checkboxSelectedDo instance) {
    return (java.lang.Boolean) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.checkboxSelectedDo.class, instance, "selected");
  }
  
  private static void setSelected(org.ednovo.gooru.shared.model.content.checkboxSelectedDo instance, boolean value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.checkboxSelectedDo.class, instance, "selected", value);
  }
  
  private static java.lang.String getValue(org.ednovo.gooru.shared.model.content.checkboxSelectedDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.checkboxSelectedDo.class, instance, "value");
  }
  
  private static void setValue(org.ednovo.gooru.shared.model.content.checkboxSelectedDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.checkboxSelectedDo.class, instance, "value", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.checkboxSelectedDo instance) throws SerializationException {
    setName(instance, streamReader.readString());
    setSelected(instance, streamReader.readBoolean());
    setValue(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.checkboxSelectedDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.checkboxSelectedDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.checkboxSelectedDo instance) throws SerializationException {
    streamWriter.writeString(getName(instance));
    streamWriter.writeBoolean(getSelected(instance));
    streamWriter.writeString(getValue(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.checkboxSelectedDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.checkboxSelectedDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.checkboxSelectedDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.checkboxSelectedDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.checkboxSelectedDo)object);
  }
  
}
