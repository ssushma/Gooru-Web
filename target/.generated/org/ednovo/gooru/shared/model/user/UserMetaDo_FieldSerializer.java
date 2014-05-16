package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserMetaDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo getTaxonomyPreference(org.ednovo.gooru.shared.model.user.UserMetaDo instance) {
    return (org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserMetaDo.class, instance, "taxonomyPreference");
  }
  
  private static void setTaxonomyPreference(org.ednovo.gooru.shared.model.user.UserMetaDo instance, org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserMetaDo.class, instance, "taxonomyPreference", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.UserMetaDo instance) throws SerializationException {
    setTaxonomyPreference(instance, (org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.UserMetaDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.UserMetaDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.UserMetaDo instance) throws SerializationException {
    streamWriter.writeObject(getTaxonomyPreference(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.UserMetaDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.UserMetaDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.UserMetaDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.UserMetaDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.UserMetaDo)object);
  }
  
}
