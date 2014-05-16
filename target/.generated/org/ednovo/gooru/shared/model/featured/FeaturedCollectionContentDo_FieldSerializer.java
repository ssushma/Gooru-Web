package org.ednovo.gooru.shared.model.featured;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class FeaturedCollectionContentDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.List getScollections(org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo.class, instance, "scollections");
  }
  
  private static void setScollections(org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo.class, instance, "scollections", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo instance) throws SerializationException {
    setScollections(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo instance) throws SerializationException {
    streamWriter.writeObject(getScollections(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo)object);
  }
  
}
