package org.ednovo.gooru.shared.model.code;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LibraryCodeDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getCodeId(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "codeId");
  }
  
  private static void setCodeId(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "codeId", value);
  }
  
  private static java.lang.Integer getDepth(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "depth");
  }
  
  private static void setDepth(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "depth", value);
  }
  
  private static java.lang.Integer getFirstUnitId(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "firstUnitId");
  }
  
  private static void setFirstUnitId(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "firstUnitId", value);
  }
  
  private static java.lang.Integer getGrade(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "grade");
  }
  
  private static void setGrade(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "grade", value);
  }
  
  private static java.lang.String getLabel(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "label");
  }
  
  private static void setLabel(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "label", value);
  }
  
  private static java.util.List getNode(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance) {
    return (java.util.List) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "node");
  }
  
  private static void setNode(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance, java.util.List value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "node", value);
  }
  
  private static java.lang.Integer getParentId(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "parentId");
  }
  
  private static void setParentId(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "parentId", value);
  }
  
  private static java.lang.String getType(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "type");
  }
  
  private static void setType(org.ednovo.gooru.shared.model.code.LibraryCodeDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.code.LibraryCodeDo.class, instance, "type", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.code.LibraryCodeDo instance) throws SerializationException {
    setCodeId(instance, (java.lang.Integer) streamReader.readObject());
    setDepth(instance, (java.lang.Integer) streamReader.readObject());
    setFirstUnitId(instance, (java.lang.Integer) streamReader.readObject());
    setGrade(instance, (java.lang.Integer) streamReader.readObject());
    setLabel(instance, streamReader.readString());
    setNode(instance, (java.util.List) streamReader.readObject());
    setParentId(instance, (java.lang.Integer) streamReader.readObject());
    setType(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.code.LibraryCodeDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.code.LibraryCodeDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.code.LibraryCodeDo instance) throws SerializationException {
    streamWriter.writeObject(getCodeId(instance));
    streamWriter.writeObject(getDepth(instance));
    streamWriter.writeObject(getFirstUnitId(instance));
    streamWriter.writeObject(getGrade(instance));
    streamWriter.writeString(getLabel(instance));
    streamWriter.writeObject(getNode(instance));
    streamWriter.writeObject(getParentId(instance));
    streamWriter.writeString(getType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.code.LibraryCodeDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.code.LibraryCodeDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.code.LibraryCodeDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.code.LibraryCodeDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.code.LibraryCodeDo)object);
  }
  
}
