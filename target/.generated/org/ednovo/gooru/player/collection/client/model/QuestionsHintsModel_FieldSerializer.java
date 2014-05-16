package org.ednovo.gooru.player.collection.client.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class QuestionsHintsModel_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getHintId(org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel.class, instance, "hintId");
  }
  
  private static void setHintId(org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel.class, instance, "hintId", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel instance) throws SerializationException {
    setHintId(instance, (java.lang.Integer) streamReader.readObject());
    instance.hintText = streamReader.readString();
    instance.hintsequenceno = (java.lang.Integer) streamReader.readObject();
    
  }
  
  public static org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel instance) throws SerializationException {
    streamWriter.writeObject(getHintId(instance));
    streamWriter.writeString(instance.hintText);
    streamWriter.writeObject(instance.hintsequenceno);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.collection.client.model.QuestionsHintsModel)object);
  }
  
}
