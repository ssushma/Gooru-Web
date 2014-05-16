package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BiographyDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAboutMe(org.ednovo.gooru.shared.model.user.BiographyDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.BiographyDo.class, instance, "aboutMe");
  }
  
  private static void setAboutMe(org.ednovo.gooru.shared.model.user.BiographyDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.BiographyDo.class, instance, "aboutMe", value);
  }
  
  private static java.lang.String getFirstName(org.ednovo.gooru.shared.model.user.BiographyDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.BiographyDo.class, instance, "firstName");
  }
  
  private static void setFirstName(org.ednovo.gooru.shared.model.user.BiographyDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.BiographyDo.class, instance, "firstName", value);
  }
  
  private static java.lang.String getGenderId(org.ednovo.gooru.shared.model.user.BiographyDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.BiographyDo.class, instance, "genderId");
  }
  
  private static void setGenderId(org.ednovo.gooru.shared.model.user.BiographyDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.BiographyDo.class, instance, "genderId", value);
  }
  
  private static java.lang.String getLastName(org.ednovo.gooru.shared.model.user.BiographyDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.BiographyDo.class, instance, "lastName");
  }
  
  private static void setLastName(org.ednovo.gooru.shared.model.user.BiographyDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.BiographyDo.class, instance, "lastName", value);
  }
  
  private static java.lang.String getSubject(org.ednovo.gooru.shared.model.user.BiographyDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.BiographyDo.class, instance, "subject");
  }
  
  private static void setSubject(org.ednovo.gooru.shared.model.user.BiographyDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.BiographyDo.class, instance, "subject", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.BiographyDo instance) throws SerializationException {
    setAboutMe(instance, streamReader.readString());
    setFirstName(instance, streamReader.readString());
    setGenderId(instance, streamReader.readString());
    setLastName(instance, streamReader.readString());
    setSubject(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.BiographyDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.BiographyDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.BiographyDo instance) throws SerializationException {
    streamWriter.writeString(getAboutMe(instance));
    streamWriter.writeString(getFirstName(instance));
    streamWriter.writeString(getGenderId(instance));
    streamWriter.writeString(getLastName(instance));
    streamWriter.writeString(getSubject(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.BiographyDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.BiographyDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.BiographyDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.BiographyDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.BiographyDo)object);
  }
  
}
