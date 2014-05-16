package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ResourceTypeDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getDescription(org.ednovo.gooru.shared.model.content.ResourceTypeDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceTypeDo.class, instance, "description");
  }
  
  private static void setDescription(org.ednovo.gooru.shared.model.content.ResourceTypeDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceTypeDo.class, instance, "description", value);
  }
  
  private static java.lang.String getName(org.ednovo.gooru.shared.model.content.ResourceTypeDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceTypeDo.class, instance, "name");
  }
  
  private static void setName(org.ednovo.gooru.shared.model.content.ResourceTypeDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceTypeDo.class, instance, "name", value);
  }
  
  private static java.lang.String getType(org.ednovo.gooru.shared.model.content.ResourceTypeDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceTypeDo.class, instance, "type");
  }
  
  private static void setType(org.ednovo.gooru.shared.model.content.ResourceTypeDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceTypeDo.class, instance, "type", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ResourceTypeDo instance) throws SerializationException {
    setDescription(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setType(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ResourceTypeDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ResourceTypeDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ResourceTypeDo instance) throws SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ResourceTypeDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ResourceTypeDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ResourceTypeDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ResourceTypeDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ResourceTypeDo)object);
  }
  
}
