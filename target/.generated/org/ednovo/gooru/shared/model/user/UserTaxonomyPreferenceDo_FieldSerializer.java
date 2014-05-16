package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserTaxonomyPreferenceDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.List getCode(org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo.class, instance, "code");
  }
  
  private static void setCode(org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo.class, instance, "code", value);
  }
  
  private static java.util.List getCodeId(org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo.class, instance, "codeId");
  }
  
  private static void setCodeId(org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo.class, instance, "codeId", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo instance) throws SerializationException {
    setCode(instance, (java.util.List) streamReader.readObject());
    setCodeId(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo instance) throws SerializationException {
    streamWriter.writeObject(getCode(instance));
    streamWriter.writeObject(getCodeId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo)object);
  }
  
}
