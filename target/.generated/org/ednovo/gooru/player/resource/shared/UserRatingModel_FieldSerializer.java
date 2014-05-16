package org.ednovo.gooru.player.resource.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserRatingModel_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static int getResourceUserRating(org.ednovo.gooru.player.resource.shared.UserRatingModel instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.UserRatingModel.class, instance, "resourceUserRating");
  }
  
  private static void setResourceUserRating(org.ednovo.gooru.player.resource.shared.UserRatingModel instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.UserRatingModel.class, instance, "resourceUserRating", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.resource.shared.UserRatingModel instance) throws SerializationException {
    setResourceUserRating(instance, streamReader.readInt());
    
  }
  
  public static org.ednovo.gooru.player.resource.shared.UserRatingModel instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.resource.shared.UserRatingModel();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.resource.shared.UserRatingModel instance) throws SerializationException {
    streamWriter.writeInt(getResourceUserRating(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.resource.shared.UserRatingModel_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.UserRatingModel_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.resource.shared.UserRatingModel)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.UserRatingModel_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.resource.shared.UserRatingModel)object);
  }
  
}
