package org.ednovo.gooru.shared.model.content;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ContentReportDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getAssocGooruOid(org.ednovo.gooru.shared.model.content.ContentReportDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentReportDo.class, instance, "assocGooruOid");
  }
  
  private static void setAssocGooruOid(org.ednovo.gooru.shared.model.content.ContentReportDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentReportDo.class, instance, "assocGooruOid", value);
  }
  
  private static java.util.ArrayList getContentReportList(org.ednovo.gooru.shared.model.content.ContentReportDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentReportDo.class, instance, "contentReportList");
  }
  
  private static void setContentReportList(org.ednovo.gooru.shared.model.content.ContentReportDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentReportDo.class, instance, "contentReportList", value);
  }
  
  private static java.lang.String getDeleteContentGooruOid(org.ednovo.gooru.shared.model.content.ContentReportDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentReportDo.class, instance, "deleteContentGooruOid");
  }
  
  private static void setDeleteContentGooruOid(org.ednovo.gooru.shared.model.content.ContentReportDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentReportDo.class, instance, "deleteContentGooruOid", value);
  }
  
  private static java.lang.String getFreeText(org.ednovo.gooru.shared.model.content.ContentReportDo instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.shared.model.content.ContentReportDo.class, instance, "freeText");
  }
  
  private static void setFreeText(org.ednovo.gooru.shared.model.content.ContentReportDo instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.content.ContentReportDo.class, instance, "freeText", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.content.ContentReportDo instance) throws SerializationException {
    setAssocGooruOid(instance, streamReader.readString());
    setContentReportList(instance, (java.util.ArrayList) streamReader.readObject());
    setDeleteContentGooruOid(instance, streamReader.readString());
    setFreeText(instance, streamReader.readString());
    
  }
  
  public static org.ednovo.gooru.shared.model.content.ContentReportDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.content.ContentReportDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.content.ContentReportDo instance) throws SerializationException {
    streamWriter.writeString(getAssocGooruOid(instance));
    streamWriter.writeObject(getContentReportList(instance));
    streamWriter.writeString(getDeleteContentGooruOid(instance));
    streamWriter.writeString(getFreeText(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.content.ContentReportDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ContentReportDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.content.ContentReportDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.content.ContentReportDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.content.ContentReportDo)object);
  }
  
}
