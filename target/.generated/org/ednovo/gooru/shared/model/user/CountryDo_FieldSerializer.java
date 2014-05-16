package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CountryDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCountryId(org.ednovo.gooru.shared.model.user.CountryDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.CountryDo.class, instance, "countryId");
  }
  
  private static void setCountryId(org.ednovo.gooru.shared.model.user.CountryDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.CountryDo.class, instance, "countryId", value);
  }
  
  private static java.lang.String getName(org.ednovo.gooru.shared.model.user.CountryDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.CountryDo.class, instance, "name");
  }
  
  private static void setName(org.ednovo.gooru.shared.model.user.CountryDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.CountryDo.class, instance, "name", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.CountryDo instance) throws SerializationException {
    setCountryId(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.CountryDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.CountryDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.CountryDo instance) throws SerializationException {
    streamWriter.writeString(getCountryId(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.CountryDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.CountryDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.CountryDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.CountryDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.CountryDo)object);
  }
  
}
