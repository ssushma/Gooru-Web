package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CityDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCityId(org.ednovo.gooru.shared.model.user.CityDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.CityDo.class, instance, "cityId");
  }
  
  private static void setCityId(org.ednovo.gooru.shared.model.user.CityDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.CityDo.class, instance, "cityId", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.CountryDo getCountry(org.ednovo.gooru.shared.model.user.CityDo instance) {
    return (org.ednovo.gooru.shared.model.user.CountryDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.CityDo.class, instance, "country");
  }
  
  private static void setCountry(org.ednovo.gooru.shared.model.user.CityDo instance, org.ednovo.gooru.shared.model.user.CountryDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.CityDo.class, instance, "country", value);
  }
  
  private static java.lang.String getName(org.ednovo.gooru.shared.model.user.CityDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.CityDo.class, instance, "name");
  }
  
  private static void setName(org.ednovo.gooru.shared.model.user.CityDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.CityDo.class, instance, "name", value);
  }
  
  private static org.ednovo.gooru.shared.model.user.ProvinceDo getProvince(org.ednovo.gooru.shared.model.user.CityDo instance) {
    return (org.ednovo.gooru.shared.model.user.ProvinceDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.CityDo.class, instance, "province");
  }
  
  private static void setProvince(org.ednovo.gooru.shared.model.user.CityDo instance, org.ednovo.gooru.shared.model.user.ProvinceDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.CityDo.class, instance, "province", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.CityDo instance) throws SerializationException {
    setCityId(instance, streamReader.readString());
    setCountry(instance, (org.ednovo.gooru.shared.model.user.CountryDo) streamReader.readObject());
    setName(instance, streamReader.readString());
    setProvince(instance, (org.ednovo.gooru.shared.model.user.ProvinceDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.CityDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.CityDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.CityDo instance) throws SerializationException {
    streamWriter.writeString(getCityId(instance));
    streamWriter.writeObject(getCountry(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getProvince(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.CityDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.CityDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.CityDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.CityDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.CityDo)object);
  }
  
}
