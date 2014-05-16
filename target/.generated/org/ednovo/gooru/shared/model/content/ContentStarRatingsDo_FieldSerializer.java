package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ContentStarRatingsDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static double getAverage(org.ednovo.gooru.shared.model.content.ContentStarRatingsDo instance) {
    return (java.lang.Double) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentStarRatingsDo.class, instance, "average");
  }
  
  private static void setAverage(org.ednovo.gooru.shared.model.content.ContentStarRatingsDo instance, double value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentStarRatingsDo.class, instance, "average", value);
  }
  
  private static java.lang.Integer getCount(org.ednovo.gooru.shared.model.content.ContentStarRatingsDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentStarRatingsDo.class, instance, "count");
  }
  
  private static void setCount(org.ednovo.gooru.shared.model.content.ContentStarRatingsDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentStarRatingsDo.class, instance, "count", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ContentStarRatingsDo instance) throws SerializationException {
    setAverage(instance, streamReader.readDouble());
    setCount(instance, (java.lang.Integer) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ContentStarRatingsDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ContentStarRatingsDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ContentStarRatingsDo instance) throws SerializationException {
    streamWriter.writeDouble(getAverage(instance));
    streamWriter.writeObject(getCount(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ContentStarRatingsDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ContentStarRatingsDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ContentStarRatingsDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ContentStarRatingsDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ContentStarRatingsDo)object);
  }
  
}
