package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ResourceSourceDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getActiveStatus(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "activeStatus");
  }
  
  private static void setActiveStatus(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "activeStatus", value);
  }
  
  private static java.lang.String getAttribution(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "attribution");
  }
  
  private static void setAttribution(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "attribution", value);
  }
  
  private static java.lang.String getDomainName(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "domainName");
  }
  
  private static void setDomainName(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "domainName", value);
  }
  
  private static java.lang.Integer getFrameBreaker(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "frameBreaker");
  }
  
  private static void setFrameBreaker(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "frameBreaker", value);
  }
  
  private static java.lang.String getResourceSourceId(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "resourceSourceId");
  }
  
  private static void setResourceSourceId(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "resourceSourceId", value);
  }
  
  private static java.lang.String getSourceName(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "sourceName");
  }
  
  private static void setSourceName(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "sourceName", value);
  }
  
  private static java.lang.String getType(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "type");
  }
  
  private static void setType(org.ednovo.gooru.shared.model.content.ResourceSourceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ResourceSourceDo.class, instance, "type", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ResourceSourceDo instance) throws SerializationException {
    setActiveStatus(instance, streamReader.readString());
    setAttribution(instance, streamReader.readString());
    setDomainName(instance, streamReader.readString());
    setFrameBreaker(instance, (java.lang.Integer) streamReader.readObject());
    setResourceSourceId(instance, streamReader.readString());
    setSourceName(instance, streamReader.readString());
    setType(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ResourceSourceDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ResourceSourceDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ResourceSourceDo instance) throws SerializationException {
    streamWriter.writeString(getActiveStatus(instance));
    streamWriter.writeString(getAttribution(instance));
    streamWriter.writeString(getDomainName(instance));
    streamWriter.writeObject(getFrameBreaker(instance));
    streamWriter.writeString(getResourceSourceId(instance));
    streamWriter.writeString(getSourceName(instance));
    streamWriter.writeString(getType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ResourceSourceDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ResourceSourceDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ResourceSourceDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ResourceSourceDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ResourceSourceDo)object);
  }
  
}
