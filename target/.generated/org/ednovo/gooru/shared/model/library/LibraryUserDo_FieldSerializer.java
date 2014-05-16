package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LibraryUserDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.ArrayList getCourses(org.ednovo.gooru.shared.model.library.LibraryUserDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "courses");
  }
  
  private static void setCourses(org.ednovo.gooru.shared.model.library.LibraryUserDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "courses", value);
  }
  
  private static java.lang.String getDisplayName(org.ednovo.gooru.shared.model.library.LibraryUserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "displayName");
  }
  
  private static void setDisplayName(org.ednovo.gooru.shared.model.library.LibraryUserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "displayName", value);
  }
  
  private static java.lang.String getFirstName(org.ednovo.gooru.shared.model.library.LibraryUserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "firstName");
  }
  
  private static void setFirstName(org.ednovo.gooru.shared.model.library.LibraryUserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "firstName", value);
  }
  
  private static java.lang.String getGender(org.ednovo.gooru.shared.model.library.LibraryUserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "gender");
  }
  
  private static void setGender(org.ednovo.gooru.shared.model.library.LibraryUserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "gender", value);
  }
  
  private static java.lang.String getGooruUId(org.ednovo.gooru.shared.model.library.LibraryUserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "gooruUId");
  }
  
  private static void setGooruUId(org.ednovo.gooru.shared.model.library.LibraryUserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "gooruUId", value);
  }
  
  private static java.lang.String getIsOwner(org.ednovo.gooru.shared.model.library.LibraryUserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "isOwner");
  }
  
  private static void setIsOwner(org.ednovo.gooru.shared.model.library.LibraryUserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "isOwner", value);
  }
  
  private static java.lang.String getLastName(org.ednovo.gooru.shared.model.library.LibraryUserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "lastName");
  }
  
  private static void setLastName(org.ednovo.gooru.shared.model.library.LibraryUserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "lastName", value);
  }
  
  private static java.lang.String getPartnerName(org.ednovo.gooru.shared.model.library.LibraryUserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "partnerName");
  }
  
  private static void setPartnerName(org.ednovo.gooru.shared.model.library.LibraryUserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "partnerName", value);
  }
  
  private static java.lang.String getPartnerUrl(org.ednovo.gooru.shared.model.library.LibraryUserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "partnerUrl");
  }
  
  private static void setPartnerUrl(org.ednovo.gooru.shared.model.library.LibraryUserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "partnerUrl", value);
  }
  
  private static java.lang.String getUsername(org.ednovo.gooru.shared.model.library.LibraryUserDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "username");
  }
  
  private static void setUsername(org.ednovo.gooru.shared.model.library.LibraryUserDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.LibraryUserDo.class, instance, "username", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.LibraryUserDo instance) throws SerializationException {
    setCourses(instance, (java.util.ArrayList) streamReader.readObject());
    setDisplayName(instance, streamReader.readString());
    setFirstName(instance, streamReader.readString());
    setGender(instance, streamReader.readString());
    setGooruUId(instance, streamReader.readString());
    setIsOwner(instance, streamReader.readString());
    setLastName(instance, streamReader.readString());
    setPartnerName(instance, streamReader.readString());
    setPartnerUrl(instance, streamReader.readString());
    setUsername(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.LibraryUserDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.LibraryUserDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.LibraryUserDo instance) throws SerializationException {
    streamWriter.writeObject(getCourses(instance));
    streamWriter.writeString(getDisplayName(instance));
    streamWriter.writeString(getFirstName(instance));
    streamWriter.writeString(getGender(instance));
    streamWriter.writeString(getGooruUId(instance));
    streamWriter.writeString(getIsOwner(instance));
    streamWriter.writeString(getLastName(instance));
    streamWriter.writeString(getPartnerName(instance));
    streamWriter.writeString(getPartnerUrl(instance));
    streamWriter.writeString(getUsername(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.LibraryUserDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.LibraryUserDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.LibraryUserDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.LibraryUserDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.LibraryUserDo)object);
  }
  
}
