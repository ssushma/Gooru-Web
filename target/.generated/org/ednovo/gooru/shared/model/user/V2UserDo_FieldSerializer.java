package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class V2UserDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAboutMe(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "aboutMe");
  }
  
  private static void setAboutMe(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "aboutMe", value);
  }
  
  private static java.lang.String getAccountType(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "accountType");
  }
  
  private static void setAccountType(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "accountType", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.CityDo getCity(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (org.ednovo.gooru.shared.model.user.CityDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "city");
  }
  
  private static void setCity(org.ednovo.gooru.shared.model.user.V2UserDo instance, org.ednovo.gooru.shared.model.user.CityDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "city", value);
  }
  
  private static org.ednovo.gooru.shared.model.code.CodeDo getCodeDo(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (org.ednovo.gooru.shared.model.code.CodeDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "codeDo");
  }
  
  private static void setCodeDo(org.ednovo.gooru.shared.model.user.V2UserDo instance, org.ednovo.gooru.shared.model.code.CodeDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "codeDo", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.CountryDo getCountry(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (org.ednovo.gooru.shared.model.user.CountryDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "country");
  }
  
  private static void setCountry(org.ednovo.gooru.shared.model.user.V2UserDo instance, org.ednovo.gooru.shared.model.user.CountryDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "country", value);
  }
  
  private static java.lang.String getCreatedOn(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "createdOn");
  }
  
  private static void setCreatedOn(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "createdOn", value);
  }
  
  private static java.lang.String getDateOfBirth(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "dateOfBirth");
  }
  
  private static void setDateOfBirth(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "dateOfBirth", value);
  }
  
  private static java.lang.String getEmailConfirmStatus(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "emailConfirmStatus");
  }
  
  private static void setEmailConfirmStatus(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "emailConfirmStatus", value);
  }
  
  private static java.lang.String getExternalId(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "externalId");
  }
  
  private static void setExternalId(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "externalId", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.GenderDo getGender(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (org.ednovo.gooru.shared.model.user.GenderDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "gender");
  }
  
  private static void setGender(org.ednovo.gooru.shared.model.user.V2UserDo instance, org.ednovo.gooru.shared.model.user.GenderDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "gender", value);
  }
  
  private static java.lang.String getGrade(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "grade");
  }
  
  private static void setGrade(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "grade", value);
  }
  
  private static java.lang.Integer getIsPublisherRequestPending(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "isPublisherRequestPending");
  }
  
  private static void setIsPublisherRequestPending(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "isPublisherRequestPending", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.UserMetaDo getMeta(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (org.ednovo.gooru.shared.model.user.UserMetaDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "meta");
  }
  
  private static void setMeta(org.ednovo.gooru.shared.model.user.V2UserDo instance, org.ednovo.gooru.shared.model.user.UserMetaDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "meta", value);
  }
  
  private static java.lang.String getPassword(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "password");
  }
  
  private static void setPassword(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "password", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.ProfileV2Do getProfile(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (org.ednovo.gooru.shared.model.user.ProfileV2Do) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "profile");
  }
  
  private static void setProfile(org.ednovo.gooru.shared.model.user.V2UserDo instance, org.ednovo.gooru.shared.model.user.ProfileV2Do value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "profile", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.ProvinceDo getProvince(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (org.ednovo.gooru.shared.model.user.ProvinceDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "province");
  }
  
  private static void setProvince(org.ednovo.gooru.shared.model.user.V2UserDo instance, org.ednovo.gooru.shared.model.user.ProvinceDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "province", value);
  }
  
  private static java.lang.String getRestEndPoint(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "restEndPoint");
  }
  
  private static void setRestEndPoint(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "restEndPoint", value);
  }
  
  private static java.lang.String getToken(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "token");
  }
  
  private static void setToken(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "token", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.UserDo getUser(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (org.ednovo.gooru.shared.model.user.UserDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "user");
  }
  
  private static void setUser(org.ednovo.gooru.shared.model.user.V2UserDo instance, org.ednovo.gooru.shared.model.user.UserDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "user", value);
  }
  
  private static java.lang.String getUserType(org.ednovo.gooru.shared.model.user.V2UserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "userType");
  }
  
  private static void setUserType(org.ednovo.gooru.shared.model.user.V2UserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.V2UserDo.class, instance, "userType", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.V2UserDo instance) throws SerializationException {
    setAboutMe(instance, streamReader.readString());
    setAccountType(instance, streamReader.readString());
    setCity(instance, (org.ednovo.gooru.shared.model.user.CityDo) streamReader.readObject());
    setCodeDo(instance, (org.ednovo.gooru.shared.model.code.CodeDo) streamReader.readObject());
    setCountry(instance, (org.ednovo.gooru.shared.model.user.CountryDo) streamReader.readObject());
    setCreatedOn(instance, streamReader.readString());
    setDateOfBirth(instance, streamReader.readString());
    setEmailConfirmStatus(instance, streamReader.readString());
    setExternalId(instance, streamReader.readString());
    setGender(instance, (org.ednovo.gooru.shared.model.user.GenderDo) streamReader.readObject());
    setGrade(instance, streamReader.readString());
    setIsPublisherRequestPending(instance, (java.lang.Integer) streamReader.readObject());
    setMeta(instance, (org.ednovo.gooru.shared.model.user.UserMetaDo) streamReader.readObject());
    setPassword(instance, streamReader.readString());
    setProfile(instance, (org.ednovo.gooru.shared.model.user.ProfileV2Do) streamReader.readObject());
    setProvince(instance, (org.ednovo.gooru.shared.model.user.ProvinceDo) streamReader.readObject());
    setRestEndPoint(instance, streamReader.readString());
    setToken(instance, streamReader.readString());
    setUser(instance, (org.ednovo.gooru.shared.model.user.UserDo) streamReader.readObject());
    setUserType(instance, streamReader.readString());
    
    org.ednovo.gooru.shared.model.user.ResponseStatusDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.user.V2UserDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.V2UserDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.V2UserDo instance) throws SerializationException {
    streamWriter.writeString(getAboutMe(instance));
    streamWriter.writeString(getAccountType(instance));
    streamWriter.writeObject(getCity(instance));
    streamWriter.writeObject(getCodeDo(instance));
    streamWriter.writeObject(getCountry(instance));
    streamWriter.writeString(getCreatedOn(instance));
    streamWriter.writeString(getDateOfBirth(instance));
    streamWriter.writeString(getEmailConfirmStatus(instance));
    streamWriter.writeString(getExternalId(instance));
    streamWriter.writeObject(getGender(instance));
    streamWriter.writeString(getGrade(instance));
    streamWriter.writeObject(getIsPublisherRequestPending(instance));
    streamWriter.writeObject(getMeta(instance));
    streamWriter.writeString(getPassword(instance));
    streamWriter.writeObject(getProfile(instance));
    streamWriter.writeObject(getProvince(instance));
    streamWriter.writeString(getRestEndPoint(instance));
    streamWriter.writeString(getToken(instance));
    streamWriter.writeObject(getUser(instance));
    streamWriter.writeString(getUserType(instance));
    
    org.ednovo.gooru.shared.model.user.ResponseStatusDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.V2UserDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.V2UserDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.V2UserDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.V2UserDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.V2UserDo)object);
  }
  
}
