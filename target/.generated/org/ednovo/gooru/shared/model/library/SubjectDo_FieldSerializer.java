package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SubjectDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getCode(org.ednovo.gooru.shared.model.library.SubjectDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.SubjectDo.class, instance, "code");
  }
  
  private static void setCode(org.ednovo.gooru.shared.model.library.SubjectDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.SubjectDo.class, instance, "code", value);
  }
  
  private static java.util.ArrayList getData(org.ednovo.gooru.shared.model.library.SubjectDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.SubjectDo.class, instance, "data");
  }
  
  private static void setData(org.ednovo.gooru.shared.model.library.SubjectDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.SubjectDo.class, instance, "data", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.SubjectDo instance) throws SerializationException {
    setCode(instance, streamReader.readString());
    setData(instance, (java.util.ArrayList) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.SubjectDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.SubjectDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.SubjectDo instance) throws SerializationException {
    streamWriter.writeString(getCode(instance));
    streamWriter.writeObject(getData(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.SubjectDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.SubjectDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.SubjectDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.SubjectDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.SubjectDo)object);
  }
  
}
