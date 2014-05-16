package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class QuestionHintsDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getHintId(org.ednovo.gooru.shared.model.content.QuestionHintsDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.QuestionHintsDo.class, instance, "hintId");
  }
  
  private static void setHintId(org.ednovo.gooru.shared.model.content.QuestionHintsDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.QuestionHintsDo.class, instance, "hintId", value);
  }
  
  private static java.lang.String getHintText(org.ednovo.gooru.shared.model.content.QuestionHintsDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.QuestionHintsDo.class, instance, "hintText");
  }
  
  private static void setHintText(org.ednovo.gooru.shared.model.content.QuestionHintsDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.QuestionHintsDo.class, instance, "hintText", value);
  }
  
  private static int getSequence(org.ednovo.gooru.shared.model.content.QuestionHintsDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.QuestionHintsDo.class, instance, "sequence");
  }
  
  private static void setSequence(org.ednovo.gooru.shared.model.content.QuestionHintsDo instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.QuestionHintsDo.class, instance, "sequence", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.QuestionHintsDo instance) throws SerializationException {
    setHintId(instance, (java.lang.Integer) streamReader.readObject());
    setHintText(instance, streamReader.readString());
    setSequence(instance, streamReader.readInt());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.QuestionHintsDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.QuestionHintsDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.QuestionHintsDo instance) throws SerializationException {
    streamWriter.writeObject(getHintId(instance));
    streamWriter.writeString(getHintText(instance));
    streamWriter.writeInt(getSequence(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.QuestionHintsDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.QuestionHintsDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.QuestionHintsDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.QuestionHintsDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.QuestionHintsDo)object);
  }
  
}
