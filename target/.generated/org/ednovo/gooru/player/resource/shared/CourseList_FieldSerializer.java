package org.ednovo.gooru.player.resource.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CourseList_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.ArrayList getCourseList(org.ednovo.gooru.player.resource.shared.CourseList instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.CourseList.class, instance, "courseList");
  }
  
  private static void setCourseList(org.ednovo.gooru.player.resource.shared.CourseList instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.CourseList.class, instance, "courseList", value);
  }
  
  private static java.lang.String getMainCourse(org.ednovo.gooru.player.resource.shared.CourseList instance) {
    return (java.lang.String) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.CourseList.class, instance, "mainCourse");
  }
  
  private static void setMainCourse(org.ednovo.gooru.player.resource.shared.CourseList instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.CourseList.class, instance, "mainCourse", value);
  }
  
  private static java.util.ArrayList getSubCodeId(org.ednovo.gooru.player.resource.shared.CourseList instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.player.resource.shared.CourseList.class, instance, "subCodeId");
  }
  
  private static void setSubCodeId(org.ednovo.gooru.player.resource.shared.CourseList instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.player.resource.shared.CourseList.class, instance, "subCodeId", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.player.resource.shared.CourseList instance) throws SerializationException {
    setCourseList(instance, (java.util.ArrayList) streamReader.readObject());
    setMainCourse(instance, streamReader.readString());
    setSubCodeId(instance, (java.util.ArrayList) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.player.resource.shared.CourseList instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.player.resource.shared.CourseList();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.player.resource.shared.CourseList instance) throws SerializationException {
    streamWriter.writeObject(getCourseList(instance));
    streamWriter.writeString(getMainCourse(instance));
    streamWriter.writeObject(getSubCodeId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.player.resource.shared.CourseList_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.CourseList_FieldSerializer.deserialize(reader, (org.ednovo.gooru.player.resource.shared.CourseList)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.player.resource.shared.CourseList_FieldSerializer.serialize(writer, (org.ednovo.gooru.player.resource.shared.CourseList)object);
  }
  
}
