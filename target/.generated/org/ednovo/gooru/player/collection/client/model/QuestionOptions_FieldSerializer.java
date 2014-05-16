package org.ednovo.gooru.player.collection.client.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class QuestionOptions_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static int getQuestionAnswerId(org.ednovo.gooru.player.collection.client.model.QuestionOptions instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.QuestionOptions.class, instance, "questionAnswerId");
  }
  
  private static void setQuestionAnswerId(org.ednovo.gooru.player.collection.client.model.QuestionOptions instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.QuestionOptions.class, instance, "questionAnswerId", value);
  }
  
  private static java.lang.String getQuestionAnswerText(org.ednovo.gooru.player.collection.client.model.QuestionOptions instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.QuestionOptions.class, instance, "questionAnswerText");
  }
  
  private static void setQuestionAnswerText(org.ednovo.gooru.player.collection.client.model.QuestionOptions instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.QuestionOptions.class, instance, "questionAnswerText", value);
  }
  
  private static java.lang.String getQuestionAnswerType(org.ednovo.gooru.player.collection.client.model.QuestionOptions instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.QuestionOptions.class, instance, "questionAnswerType");
  }
  
  private static void setQuestionAnswerType(org.ednovo.gooru.player.collection.client.model.QuestionOptions instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.QuestionOptions.class, instance, "questionAnswerType", value);
  }
  
  private static java.lang.String getQuestionSequence(org.ednovo.gooru.player.collection.client.model.QuestionOptions instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.QuestionOptions.class, instance, "questionSequence");
  }
  
  private static void setQuestionSequence(org.ednovo.gooru.player.collection.client.model.QuestionOptions instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.QuestionOptions.class, instance, "questionSequence", value);
  }
  
  private static boolean getQuestionisCorrect(org.ednovo.gooru.player.collection.client.model.QuestionOptions instance) {
    return (java.lang.Boolean) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.QuestionOptions.class, instance, "questionisCorrect");
  }
  
  private static void setQuestionisCorrect(org.ednovo.gooru.player.collection.client.model.QuestionOptions instance, boolean value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.QuestionOptions.class, instance, "questionisCorrect", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.collection.client.model.QuestionOptions instance) throws SerializationException {
    setQuestionAnswerId(instance, streamReader.readInt());
    setQuestionAnswerText(instance, streamReader.readString());
    setQuestionAnswerType(instance, streamReader.readString());
    setQuestionSequence(instance, streamReader.readString());
    setQuestionisCorrect(instance, streamReader.readBoolean());
    
  }
  
  public static org.ednovo.gooru.player.collection.client.model.QuestionOptions instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.collection.client.model.QuestionOptions();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.collection.client.model.QuestionOptions instance) throws SerializationException {
    streamWriter.writeInt(getQuestionAnswerId(instance));
    streamWriter.writeString(getQuestionAnswerText(instance));
    streamWriter.writeString(getQuestionAnswerType(instance));
    streamWriter.writeString(getQuestionSequence(instance));
    streamWriter.writeBoolean(getQuestionisCorrect(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.collection.client.model.QuestionOptions_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.collection.client.model.QuestionOptions_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.collection.client.model.QuestionOptions)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.collection.client.model.QuestionOptions_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.collection.client.model.QuestionOptions)object);
  }
  
}
