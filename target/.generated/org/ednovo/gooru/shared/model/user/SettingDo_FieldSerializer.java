package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SettingDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAboutMe(org.ednovo.gooru.shared.model.user.SettingDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "aboutMe");
  }
  
  private static void setAboutMe(org.ednovo.gooru.shared.model.user.SettingDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "aboutMe", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.CityDo getCity(org.ednovo.gooru.shared.model.user.SettingDo instance) {
    return (org.ednovo.gooru.shared.model.user.CityDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "city");
  }
  
  private static void setCity(org.ednovo.gooru.shared.model.user.SettingDo instance, org.ednovo.gooru.shared.model.user.CityDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "city", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.CountryDo getCountry(org.ednovo.gooru.shared.model.user.SettingDo instance) {
    return (org.ednovo.gooru.shared.model.user.CountryDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "country");
  }
  
  private static void setCountry(org.ednovo.gooru.shared.model.user.SettingDo instance, org.ednovo.gooru.shared.model.user.CountryDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "country", value);
  }
  
  private static java.util.Date getDateOfBirth(org.ednovo.gooru.shared.model.user.SettingDo instance) {
    return (java.util.Date) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "dateOfBirth");
  }
  
  private static void setDateOfBirth(org.ednovo.gooru.shared.model.user.SettingDo instance, java.util.Date value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "dateOfBirth", value);
  }
  
  private static java.lang.String getExternalId(org.ednovo.gooru.shared.model.user.SettingDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "externalId");
  }
  
  private static void setExternalId(org.ednovo.gooru.shared.model.user.SettingDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "externalId", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.GenderDo getGender(org.ednovo.gooru.shared.model.user.SettingDo instance) {
    return (org.ednovo.gooru.shared.model.user.GenderDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "gender");
  }
  
  private static void setGender(org.ednovo.gooru.shared.model.user.SettingDo instance, org.ednovo.gooru.shared.model.user.GenderDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "gender", value);
  }
  
  private static java.lang.String getLoginType(org.ednovo.gooru.shared.model.user.SettingDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "loginType");
  }
  
  private static void setLoginType(org.ednovo.gooru.shared.model.user.SettingDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "loginType", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.ProvinceDo getProvince(org.ednovo.gooru.shared.model.user.SettingDo instance) {
    return (org.ednovo.gooru.shared.model.user.ProvinceDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "province");
  }
  
  private static void setProvince(org.ednovo.gooru.shared.model.user.SettingDo instance, org.ednovo.gooru.shared.model.user.ProvinceDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "province", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.UserDo getUser(org.ednovo.gooru.shared.model.user.SettingDo instance) {
    return (org.ednovo.gooru.shared.model.user.UserDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "user");
  }
  
  private static void setUser(org.ednovo.gooru.shared.model.user.SettingDo instance, org.ednovo.gooru.shared.model.user.UserDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "user", value);
  }
  
  private static java.lang.String getUserType(org.ednovo.gooru.shared.model.user.SettingDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "userType");
  }
  
  private static void setUserType(org.ednovo.gooru.shared.model.user.SettingDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.SettingDo.class, instance, "userType", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.SettingDo instance) throws SerializationException {
    setAboutMe(instance, streamReader.readString());
    setCity(instance, (org.ednovo.gooru.shared.model.user.CityDo) streamReader.readObject());
    setCountry(instance, (org.ednovo.gooru.shared.model.user.CountryDo) streamReader.readObject());
    setDateOfBirth(instance, (java.util.Date) streamReader.readObject());
    setExternalId(instance, streamReader.readString());
    setGender(instance, (org.ednovo.gooru.shared.model.user.GenderDo) streamReader.readObject());
    setLoginType(instance, streamReader.readString());
    setProvince(instance, (org.ednovo.gooru.shared.model.user.ProvinceDo) streamReader.readObject());
    setUser(instance, (org.ednovo.gooru.shared.model.user.UserDo) streamReader.readObject());
    setUserType(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.SettingDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.SettingDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.SettingDo instance) throws SerializationException {
    streamWriter.writeString(getAboutMe(instance));
    streamWriter.writeObject(getCity(instance));
    streamWriter.writeObject(getCountry(instance));
    streamWriter.writeObject(getDateOfBirth(instance));
    streamWriter.writeString(getExternalId(instance));
    streamWriter.writeObject(getGender(instance));
    streamWriter.writeString(getLoginType(instance));
    streamWriter.writeObject(getProvince(instance));
    streamWriter.writeObject(getUser(instance));
    streamWriter.writeString(getUserType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.SettingDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.SettingDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.SettingDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.SettingDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.SettingDo)object);
  }
  
}
