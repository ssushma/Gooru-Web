package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AssetsDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static org.ednovo.gooru.shared.model.content.AssetDo getAsset(org.ednovo.gooru.shared.model.content.AssetsDo instance) {
    return (org.ednovo.gooru.shared.model.content.AssetDo) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssetsDo.class, instance, "asset");
  }
  
  private static void setAsset(org.ednovo.gooru.shared.model.content.AssetsDo instance, org.ednovo.gooru.shared.model.content.AssetDo value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssetsDo.class, instance, "asset", value);
  }
  
  private static java.lang.String getAssetKey(org.ednovo.gooru.shared.model.content.AssetsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.AssetsDo.class, instance, "assetKey");
  }
  
  private static void setAssetKey(org.ednovo.gooru.shared.model.content.AssetsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.AssetsDo.class, instance, "assetKey", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.AssetsDo instance) throws SerializationException {
    setAsset(instance, (org.ednovo.gooru.shared.model.content.AssetDo) streamReader.readObject());
    setAssetKey(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.AssetsDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.AssetsDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.AssetsDo instance) throws SerializationException {
    streamWriter.writeObject(getAsset(instance));
    streamWriter.writeString(getAssetKey(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.AssetsDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.AssetsDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.AssetsDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.AssetsDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.AssetsDo)object);
  }
  
}
