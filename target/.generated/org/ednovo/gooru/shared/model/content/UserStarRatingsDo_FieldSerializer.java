package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserStarRatingsDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static double getAverage(org.ednovo.gooru.shared.model.content.UserStarRatingsDo instance) {
    return (java.lang.Double) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.UserStarRatingsDo.class, instance, "average");
  }
  
  private static void setAverage(org.ednovo.gooru.shared.model.content.UserStarRatingsDo instance, double value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.UserStarRatingsDo.class, instance, "average", value);
  }
  
  private static java.lang.Integer getCount(org.ednovo.gooru.shared.model.content.UserStarRatingsDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.UserStarRatingsDo.class, instance, "count");
  }
  
  private static void setCount(org.ednovo.gooru.shared.model.content.UserStarRatingsDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.UserStarRatingsDo.class, instance, "count", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.UserStarRatingsDo instance) throws SerializationException {
    setAverage(instance, streamReader.readDouble());
    setCount(instance, (java.lang.Integer) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.UserStarRatingsDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.UserStarRatingsDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.UserStarRatingsDo instance) throws SerializationException {
    streamWriter.writeDouble(getAverage(instance));
    streamWriter.writeObject(getCount(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.UserStarRatingsDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.UserStarRatingsDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.UserStarRatingsDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.UserStarRatingsDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.UserStarRatingsDo)object);
  }
  
}
