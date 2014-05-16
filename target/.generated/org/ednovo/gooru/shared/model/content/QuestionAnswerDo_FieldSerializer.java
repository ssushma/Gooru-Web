package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class QuestionAnswerDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getAnswerId(org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.QuestionAnswerDo.class, instance, "answerId");
  }
  
  private static void setAnswerId(org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.QuestionAnswerDo.class, instance, "answerId", value);
  }
  
  private static java.lang.String getAnswerText(org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.QuestionAnswerDo.class, instance, "answerText");
  }
  
  private static void setAnswerText(org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.QuestionAnswerDo.class, instance, "answerText", value);
  }
  
  private static java.lang.String getAnswerType(org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.QuestionAnswerDo.class, instance, "answerType");
  }
  
  private static void setAnswerType(org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.QuestionAnswerDo.class, instance, "answerType", value);
  }
  
  private static boolean getIsCorrect(org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance) {
    return (java.lang.Boolean) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.QuestionAnswerDo.class, instance, "isCorrect");
  }
  
  private static void setIsCorrect(org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance, boolean value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.QuestionAnswerDo.class, instance, "isCorrect", value);
  }
  
  private static int getSequence(org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.QuestionAnswerDo.class, instance, "sequence");
  }
  
  private static void setSequence(org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.QuestionAnswerDo.class, instance, "sequence", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance) throws SerializationException {
    setAnswerId(instance, (java.lang.Integer) streamReader.readObject());
    setAnswerText(instance, streamReader.readString());
    setAnswerType(instance, streamReader.readString());
    setIsCorrect(instance, streamReader.readBoolean());
    setSequence(instance, streamReader.readInt());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.QuestionAnswerDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.QuestionAnswerDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.QuestionAnswerDo instance) throws SerializationException {
    streamWriter.writeObject(getAnswerId(instance));
    streamWriter.writeString(getAnswerText(instance));
    streamWriter.writeString(getAnswerType(instance));
    streamWriter.writeBoolean(getIsCorrect(instance));
    streamWriter.writeInt(getSequence(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.QuestionAnswerDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.QuestionAnswerDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.QuestionAnswerDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.QuestionAnswerDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.QuestionAnswerDo)object);
  }
  
}
