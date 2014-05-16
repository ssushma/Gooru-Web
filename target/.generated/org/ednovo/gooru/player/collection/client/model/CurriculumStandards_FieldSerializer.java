package org.ednovo.gooru.player.collection.client.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CurriculumStandards_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCurriculumCode(org.ednovo.gooru.player.collection.client.model.CurriculumStandards instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.CurriculumStandards.class, instance, "curriculumCode");
  }
  
  private static void setCurriculumCode(org.ednovo.gooru.player.collection.client.model.CurriculumStandards instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.CurriculumStandards.class, instance, "curriculumCode", value);
  }
  
  private static java.lang.String getCurriculumDescription(org.ednovo.gooru.player.collection.client.model.CurriculumStandards instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.collection.client.model.CurriculumStandards.class, instance, "curriculumDescription");
  }
  
  private static void setCurriculumDescription(org.ednovo.gooru.player.collection.client.model.CurriculumStandards instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.collection.client.model.CurriculumStandards.class, instance, "curriculumDescription", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.collection.client.model.CurriculumStandards instance) throws SerializationException {
    setCurriculumCode(instance, streamReader.readString());
    setCurriculumDescription(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.player.collection.client.model.CurriculumStandards instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.collection.client.model.CurriculumStandards();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.collection.client.model.CurriculumStandards instance) throws SerializationException {
    streamWriter.writeString(getCurriculumCode(instance));
    streamWriter.writeString(getCurriculumDescription(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.collection.client.model.CurriculumStandards_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.collection.client.model.CurriculumStandards_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.collection.client.model.CurriculumStandards)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.collection.client.model.CurriculumStandards_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.collection.client.model.CurriculumStandards)object);
  }
  
}
