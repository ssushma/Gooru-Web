package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProfanityCheckDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ProfanityCheckDo instance) throws SerializationException {
    instance.questionID = streamReader.readString();
    instance.questionText = streamReader.readString();
    instance.questionValue = streamReader.readBoolean();
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ProfanityCheckDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ProfanityCheckDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ProfanityCheckDo instance) throws SerializationException {
    streamWriter.writeString(instance.questionID);
    streamWriter.writeString(instance.questionText);
    streamWriter.writeBoolean(instance.questionValue);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ProfanityCheckDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ProfanityCheckDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ProfanityCheckDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ProfanityCheckDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ProfanityCheckDo)object);
  }
  
}
