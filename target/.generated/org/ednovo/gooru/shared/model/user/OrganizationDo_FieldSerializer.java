package org.ednovo.gooru.shared.model.user;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class OrganizationDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getOrganizationCode(org.ednovo.gooru.shared.model.user.OrganizationDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.user.OrganizationDo.class, instance, "organizationCode");
  }
  
  private static void setOrganizationCode(org.ednovo.gooru.shared.model.user.OrganizationDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.user.OrganizationDo.class, instance, "organizationCode", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.user.OrganizationDo instance) throws SerializationException {
    setOrganizationCode(instance, streamReader.readString());
    
    org.ednovo.gooru.shared.model.user.PartyDo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.ednovo.gooru.shared.model.user.OrganizationDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.user.OrganizationDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.user.OrganizationDo instance) throws SerializationException {
    streamWriter.writeString(getOrganizationCode(instance));
    
    org.ednovo.gooru.shared.model.user.PartyDo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.user.OrganizationDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.OrganizationDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.user.OrganizationDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.user.OrganizationDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.user.OrganizationDo)object);
  }
  
}
