package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProfileV2Do_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAboutMe(org.ednovo.gooru.shared.model.user.ProfileV2Do instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.ProfileV2Do.class, instance, "aboutMe");
  }
  
  private static void setAboutMe(org.ednovo.gooru.shared.model.user.ProfileV2Do instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.ProfileV2Do.class, instance, "aboutMe", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.GenderDo getGender(org.ednovo.gooru.shared.model.user.ProfileV2Do instance) {
    return (org.ednovo.gooru.shared.model.user.GenderDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.ProfileV2Do.class, instance, "gender");
  }
  
  private static void setGender(org.ednovo.gooru.shared.model.user.ProfileV2Do instance, org.ednovo.gooru.shared.model.user.GenderDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.ProfileV2Do.class, instance, "gender", value);
  }
  
  private static java.lang.String getGrade(org.ednovo.gooru.shared.model.user.ProfileV2Do instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.ProfileV2Do.class, instance, "grade");
  }
  
  private static void setGrade(org.ednovo.gooru.shared.model.user.ProfileV2Do instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.ProfileV2Do.class, instance, "grade", value);
  }
  
  private static java.lang.String getSubject(org.ednovo.gooru.shared.model.user.ProfileV2Do instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.ProfileV2Do.class, instance, "subject");
  }
  
  private static void setSubject(org.ednovo.gooru.shared.model.user.ProfileV2Do instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.ProfileV2Do.class, instance, "subject", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.UserDo getUser(org.ednovo.gooru.shared.model.user.ProfileV2Do instance) {
    return (org.ednovo.gooru.shared.model.user.UserDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.ProfileV2Do.class, instance, "user");
  }
  
  private static void setUser(org.ednovo.gooru.shared.model.user.ProfileV2Do instance, org.ednovo.gooru.shared.model.user.UserDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.ProfileV2Do.class, instance, "user", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.ProfileV2Do instance) throws SerializationException {
    setAboutMe(instance, streamReader.readString());
    setGender(instance, (org.ednovo.gooru.shared.model.user.GenderDo) streamReader.readObject());
    setGrade(instance, streamReader.readString());
    setSubject(instance, streamReader.readString());
    setUser(instance, (org.ednovo.gooru.shared.model.user.UserDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.ProfileV2Do instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.ProfileV2Do();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.ProfileV2Do instance) throws SerializationException {
    streamWriter.writeString(getAboutMe(instance));
    streamWriter.writeObject(getGender(instance));
    streamWriter.writeString(getGrade(instance));
    streamWriter.writeString(getSubject(instance));
    streamWriter.writeObject(getUser(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.ProfileV2Do_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.ProfileV2Do_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.ProfileV2Do)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.ProfileV2Do_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.ProfileV2Do)object);
  }
  
}
