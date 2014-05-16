package org.ednovo.gooru.player.resource.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class QuestionsHintsModel_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.resource.shared.QuestionsHintsModel instance) throws SerializationException {
    instance.hintId = (java.lang.Integer) streamReader.readObject();
    instance.hintText = streamReader.readString();
    instance.hintsequenceno = (java.lang.Integer) streamReader.readObject();
    
  }
  
  public static org.ednovo.gooru.player.resource.shared.QuestionsHintsModel instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.resource.shared.QuestionsHintsModel();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.resource.shared.QuestionsHintsModel instance) throws SerializationException {
    streamWriter.writeObject(instance.hintId);
    streamWriter.writeString(instance.hintText);
    streamWriter.writeObject(instance.hintsequenceno);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.resource.shared.QuestionsHintsModel_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.QuestionsHintsModel_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.resource.shared.QuestionsHintsModel)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.QuestionsHintsModel_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.resource.shared.QuestionsHintsModel)object);
  }
  
}
