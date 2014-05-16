package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TrackActivityDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getEndTime(org.ednovo.gooru.shared.model.content.TrackActivityDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TrackActivityDo.class, instance, "endTime");
  }
  
  private static void setEndTime(org.ednovo.gooru.shared.model.content.TrackActivityDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TrackActivityDo.class, instance, "endTime", value);
  }
  
  private static java.lang.String getStartTime(org.ednovo.gooru.shared.model.content.TrackActivityDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.TrackActivityDo.class, instance, "startTime");
  }
  
  private static void setStartTime(org.ednovo.gooru.shared.model.content.TrackActivityDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.TrackActivityDo.class, instance, "startTime", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.TrackActivityDo instance) throws SerializationException {
    setEndTime(instance, streamReader.readString());
    setStartTime(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.TrackActivityDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.TrackActivityDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.TrackActivityDo instance) throws SerializationException {
    streamWriter.writeString(getEndTime(instance));
    streamWriter.writeString(getStartTime(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.TrackActivityDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.TrackActivityDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.TrackActivityDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.TrackActivityDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.TrackActivityDo)object);
  }
  
}
