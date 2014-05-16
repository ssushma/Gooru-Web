package org.ednovo.gooru.player.resource.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class FilterSettings_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getApiKeyPoint(org.ednovo.gooru.player.resource.shared.FilterSettings instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "apiKeyPoint");
  }
  
  private static void setApiKeyPoint(org.ednovo.gooru.player.resource.shared.FilterSettings instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "apiKeyPoint", value);
  }
  
  private static java.lang.String getClassicEndPoint(org.ednovo.gooru.player.resource.shared.FilterSettings instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "classicEndPoint");
  }
  
  private static void setClassicEndPoint(org.ednovo.gooru.player.resource.shared.FilterSettings instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "classicEndPoint", value);
  }
  
  private static java.lang.String getDocViewerPoint(org.ednovo.gooru.player.resource.shared.FilterSettings instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "docViewerPoint");
  }
  
  private static void setDocViewerPoint(org.ednovo.gooru.player.resource.shared.FilterSettings instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "docViewerPoint", value);
  }
  
  private static java.lang.String getDomainName(org.ednovo.gooru.player.resource.shared.FilterSettings instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "domainName");
  }
  
  private static void setDomainName(org.ednovo.gooru.player.resource.shared.FilterSettings instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "domainName", value);
  }
  
  private static java.lang.String getGoogleAnalticsAdditionalAccounts(org.ednovo.gooru.player.resource.shared.FilterSettings instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "googleAnalticsAdditionalAccounts");
  }
  
  private static void setGoogleAnalticsAdditionalAccounts(org.ednovo.gooru.player.resource.shared.FilterSettings instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "googleAnalticsAdditionalAccounts", value);
  }
  
  private static java.lang.String getHomeEndPoint(org.ednovo.gooru.player.resource.shared.FilterSettings instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "homeEndPoint");
  }
  
  private static void setHomeEndPoint(org.ednovo.gooru.player.resource.shared.FilterSettings instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "homeEndPoint", value);
  }
  
  private static java.lang.String getRestEndPoint(org.ednovo.gooru.player.resource.shared.FilterSettings instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "restEndPoint");
  }
  
  private static void setRestEndPoint(org.ednovo.gooru.player.resource.shared.FilterSettings instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.FilterSettings.class, instance, "restEndPoint", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.resource.shared.FilterSettings instance) throws SerializationException {
    setApiKeyPoint(instance, streamReader.readString());
    setClassicEndPoint(instance, streamReader.readString());
    setDocViewerPoint(instance, streamReader.readString());
    setDomainName(instance, streamReader.readString());
    setGoogleAnalticsAdditionalAccounts(instance, streamReader.readString());
    setHomeEndPoint(instance, streamReader.readString());
    setRestEndPoint(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.player.resource.shared.FilterSettings instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.resource.shared.FilterSettings();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.resource.shared.FilterSettings instance) throws SerializationException {
    streamWriter.writeString(getApiKeyPoint(instance));
    streamWriter.writeString(getClassicEndPoint(instance));
    streamWriter.writeString(getDocViewerPoint(instance));
    streamWriter.writeString(getDomainName(instance));
    streamWriter.writeString(getGoogleAnalticsAdditionalAccounts(instance));
    streamWriter.writeString(getHomeEndPoint(instance));
    streamWriter.writeString(getRestEndPoint(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.resource.shared.FilterSettings_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.FilterSettings_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.resource.shared.FilterSettings)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.FilterSettings_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.resource.shared.FilterSettings)object);
  }
  
}
