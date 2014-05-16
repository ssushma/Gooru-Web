package org.ednovo.gooru.player.resource.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Questions_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getQuestionAssetURI(org.ednovo.gooru.player.resource.shared.Questions instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionAssetURI");
  }
  
  private static void setQuestionAssetURI(org.ednovo.gooru.player.resource.shared.Questions instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionAssetURI", value);
  }
  
  private static java.lang.String getQuestionDescription(org.ednovo.gooru.player.resource.shared.Questions instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionDescription");
  }
  
  private static void setQuestionDescription(org.ednovo.gooru.player.resource.shared.Questions instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionDescription", value);
  }
  
  private static java.lang.String getQuestionExplanation(org.ednovo.gooru.player.resource.shared.Questions instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionExplanation");
  }
  
  private static void setQuestionExplanation(org.ednovo.gooru.player.resource.shared.Questions instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionExplanation", value);
  }
  
  private static java.lang.String getQuestionGooruOid(org.ednovo.gooru.player.resource.shared.Questions instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionGooruOid");
  }
  
  private static void setQuestionGooruOid(org.ednovo.gooru.player.resource.shared.Questions instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionGooruOid", value);
  }
  
  private static java.util.ArrayList getQuestionHints(org.ednovo.gooru.player.resource.shared.Questions instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionHints");
  }
  
  private static void setQuestionHints(org.ednovo.gooru.player.resource.shared.Questions instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionHints", value);
  }
  
  private static java.util.ArrayList getQuestionOptions(org.ednovo.gooru.player.resource.shared.Questions instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionOptions");
  }
  
  private static void setQuestionOptions(org.ednovo.gooru.player.resource.shared.Questions instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionOptions", value);
  }
  
  private static java.lang.String getQuestionText(org.ednovo.gooru.player.resource.shared.Questions instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionText");
  }
  
  private static void setQuestionText(org.ednovo.gooru.player.resource.shared.Questions instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionText", value);
  }
  
  private static java.lang.Integer getQuestionType(org.ednovo.gooru.player.resource.shared.Questions instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionType");
  }
  
  private static void setQuestionType(org.ednovo.gooru.player.resource.shared.Questions instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionType", value);
  }
  
  private static java.lang.String getQuestionUrl(org.ednovo.gooru.player.resource.shared.Questions instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionUrl");
  }
  
  private static void setQuestionUrl(org.ednovo.gooru.player.resource.shared.Questions instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.Questions.class, instance, "questionUrl", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.resource.shared.Questions instance) throws SerializationException {
    setQuestionAssetURI(instance, streamReader.readString());
    setQuestionDescription(instance, streamReader.readString());
    setQuestionExplanation(instance, streamReader.readString());
    setQuestionGooruOid(instance, streamReader.readString());
    setQuestionHints(instance, (java.util.ArrayList) streamReader.readObject());
    setQuestionOptions(instance, (java.util.ArrayList) streamReader.readObject());
    setQuestionText(instance, streamReader.readString());
    setQuestionType(instance, (java.lang.Integer) streamReader.readObject());
    setQuestionUrl(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.player.resource.shared.Questions instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.resource.shared.Questions();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.resource.shared.Questions instance) throws SerializationException {
    streamWriter.writeString(getQuestionAssetURI(instance));
    streamWriter.writeString(getQuestionDescription(instance));
    streamWriter.writeString(getQuestionExplanation(instance));
    streamWriter.writeString(getQuestionGooruOid(instance));
    streamWriter.writeObject(getQuestionHints(instance));
    streamWriter.writeObject(getQuestionOptions(instance));
    streamWriter.writeString(getQuestionText(instance));
    streamWriter.writeObject(getQuestionType(instance));
    streamWriter.writeString(getQuestionUrl(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.resource.shared.Questions_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.Questions_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.resource.shared.Questions)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.Questions_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.resource.shared.Questions)object);
  }
  
}
