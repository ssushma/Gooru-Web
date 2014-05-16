package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProvinceDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static org.ednovo.gooru.shared.model.user.CountryDo getCountry(org.ednovo.gooru.shared.model.user.ProvinceDo instance) {
    return (org.ednovo.gooru.shared.model.user.CountryDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.ProvinceDo.class, instance, "country");
  }
  
  private static void setCountry(org.ednovo.gooru.shared.model.user.ProvinceDo instance, org.ednovo.gooru.shared.model.user.CountryDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.ProvinceDo.class, instance, "country", value);
  }
  
  private static java.lang.String getName(org.ednovo.gooru.shared.model.user.ProvinceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.ProvinceDo.class, instance, "name");
  }
  
  private static void setName(org.ednovo.gooru.shared.model.user.ProvinceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.ProvinceDo.class, instance, "name", value);
  }
  
  private static java.lang.String getProvinceId(org.ednovo.gooru.shared.model.user.ProvinceDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.ProvinceDo.class, instance, "provinceId");
  }
  
  private static void setProvinceId(org.ednovo.gooru.shared.model.user.ProvinceDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.ProvinceDo.class, instance, "provinceId", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.ProvinceDo instance) throws SerializationException {
    setCountry(instance, (org.ednovo.gooru.shared.model.user.CountryDo) streamReader.readObject());
    setName(instance, streamReader.readString());
    setProvinceId(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.ProvinceDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.ProvinceDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.ProvinceDo instance) throws SerializationException {
    streamWriter.writeObject(getCountry(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getProvinceId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.ProvinceDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.ProvinceDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.ProvinceDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.ProvinceDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.ProvinceDo)object);
  }
  
}
