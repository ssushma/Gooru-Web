package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LicenseDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCode(org.ednovo.gooru.shared.model.content.LicenseDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "code");
  }
  
  private static void setCode(org.ednovo.gooru.shared.model.content.LicenseDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "code", value);
  }
  
  private static java.lang.String getDefinition(org.ednovo.gooru.shared.model.content.LicenseDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "definition");
  }
  
  private static void setDefinition(org.ednovo.gooru.shared.model.content.LicenseDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "definition", value);
  }
  
  private static java.lang.String getIcon(org.ednovo.gooru.shared.model.content.LicenseDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "icon");
  }
  
  private static void setIcon(org.ednovo.gooru.shared.model.content.LicenseDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "icon", value);
  }
  
  private static java.lang.String getName(org.ednovo.gooru.shared.model.content.LicenseDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "name");
  }
  
  private static void setName(org.ednovo.gooru.shared.model.content.LicenseDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "name", value);
  }
  
  private static java.lang.String getTag(org.ednovo.gooru.shared.model.content.LicenseDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "tag");
  }
  
  private static void setTag(org.ednovo.gooru.shared.model.content.LicenseDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "tag", value);
  }
  
  private static java.lang.String getUrl(org.ednovo.gooru.shared.model.content.LicenseDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "url");
  }
  
  private static void setUrl(org.ednovo.gooru.shared.model.content.LicenseDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.LicenseDo.class, instance, "url", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.LicenseDo instance) throws SerializationException {
    setCode(instance, streamReader.readString());
    setDefinition(instance, streamReader.readString());
    setIcon(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setTag(instance, streamReader.readString());
    setUrl(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.LicenseDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.LicenseDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.LicenseDo instance) throws SerializationException {
    streamWriter.writeString(getCode(instance));
    streamWriter.writeString(getDefinition(instance));
    streamWriter.writeString(getIcon(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getTag(instance));
    streamWriter.writeString(getUrl(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.LicenseDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.LicenseDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.LicenseDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.LicenseDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.LicenseDo)object);
  }
  
}
