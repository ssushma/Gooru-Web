package org.ednovo.gooru.shared.model.player;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class FeaturedContentDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCollectionGooruOid(org.ednovo.gooru.shared.model.player.FeaturedContentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.FeaturedContentDo.class, instance, "collectionGooruOid");
  }
  
  private static void setCollectionGooruOid(org.ednovo.gooru.shared.model.player.FeaturedContentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.FeaturedContentDo.class, instance, "collectionGooruOid", value);
  }
  
  private static java.lang.String getCollectionThumbnailUrl(org.ednovo.gooru.shared.model.player.FeaturedContentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.FeaturedContentDo.class, instance, "collectionThumbnailUrl");
  }
  
  private static void setCollectionThumbnailUrl(org.ednovo.gooru.shared.model.player.FeaturedContentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.FeaturedContentDo.class, instance, "collectionThumbnailUrl", value);
  }
  
  private static java.lang.String getCollectionTitle(org.ednovo.gooru.shared.model.player.FeaturedContentDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.FeaturedContentDo.class, instance, "collectionTitle");
  }
  
  private static void setCollectionTitle(org.ednovo.gooru.shared.model.player.FeaturedContentDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.FeaturedContentDo.class, instance, "collectionTitle", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.player.FeaturedContentDo instance) throws SerializationException {
    setCollectionGooruOid(instance, streamReader.readString());
    setCollectionThumbnailUrl(instance, streamReader.readString());
    setCollectionTitle(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.player.FeaturedContentDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.player.FeaturedContentDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.player.FeaturedContentDo instance) throws SerializationException {
    streamWriter.writeString(getCollectionGooruOid(instance));
    streamWriter.writeString(getCollectionThumbnailUrl(instance));
    streamWriter.writeString(getCollectionTitle(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.player.FeaturedContentDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.player.FeaturedContentDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.player.FeaturedContentDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.player.FeaturedContentDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.player.FeaturedContentDo)object);
  }
  
}
