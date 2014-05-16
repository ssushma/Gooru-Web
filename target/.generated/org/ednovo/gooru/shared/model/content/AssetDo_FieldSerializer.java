package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AssetDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAssetId(org.ednovo.gooru.shared.model.content.AssetDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssetDo.class, instance, "assetId");
  }
  
  private static void setAssetId(org.ednovo.gooru.shared.model.content.AssetDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssetDo.class, instance, "assetId", value);
  }
  
  private static java.lang.String getName(org.ednovo.gooru.shared.model.content.AssetDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssetDo.class, instance, "name");
  }
  
  private static void setName(org.ednovo.gooru.shared.model.content.AssetDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssetDo.class, instance, "name", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.AssetDo instance) throws SerializationException {
    setAssetId(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.AssetDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.AssetDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.AssetDo instance) throws SerializationException {
    streamWriter.writeString(getAssetId(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.AssetDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.AssetDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.AssetDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.AssetDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.AssetDo)object);
  }
  
}
