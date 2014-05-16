package org.ednovo.gooru.player.resource.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GetFlagContentDO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getUserId(org.ednovo.gooru.player.resource.shared.GetFlagContentDO instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.GetFlagContentDO.class, instance, "userId");
  }
  
  private static void setUserId(org.ednovo.gooru.player.resource.shared.GetFlagContentDO instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.GetFlagContentDO.class, instance, "userId", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.resource.shared.GetFlagContentDO instance) throws SerializationException {
    instance.getAsscociatedId = (java.util.ArrayList) streamReader.readObject();
    instance.getTypeList = (java.util.ArrayList) streamReader.readObject();
    setUserId(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.player.resource.shared.GetFlagContentDO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.resource.shared.GetFlagContentDO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.resource.shared.GetFlagContentDO instance) throws SerializationException {
    streamWriter.writeObject(instance.getAsscociatedId);
    streamWriter.writeObject(instance.getTypeList);
    streamWriter.writeString(getUserId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.resource.shared.GetFlagContentDO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.GetFlagContentDO_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.resource.shared.GetFlagContentDO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.GetFlagContentDO_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.resource.shared.GetFlagContentDO)object);
  }
  
}
