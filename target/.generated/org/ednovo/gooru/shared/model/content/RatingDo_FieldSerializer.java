package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RatingDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getVotesDown(org.ednovo.gooru.shared.model.content.RatingDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.RatingDo.class, instance, "votesDown");
  }
  
  private static void setVotesDown(org.ednovo.gooru.shared.model.content.RatingDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.RatingDo.class, instance, "votesDown", value);
  }
  
  private static java.lang.Integer getVotesUp(org.ednovo.gooru.shared.model.content.RatingDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.RatingDo.class, instance, "votesUp");
  }
  
  private static void setVotesUp(org.ednovo.gooru.shared.model.content.RatingDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.RatingDo.class, instance, "votesUp", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.RatingDo instance) throws SerializationException {
    setVotesDown(instance, (java.lang.Integer) streamReader.readObject());
    setVotesUp(instance, (java.lang.Integer) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.RatingDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.RatingDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.RatingDo instance) throws SerializationException {
    streamWriter.writeObject(getVotesDown(instance));
    streamWriter.writeObject(getVotesUp(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.RatingDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.RatingDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.RatingDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.RatingDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.RatingDo)object);
  }
  
}
