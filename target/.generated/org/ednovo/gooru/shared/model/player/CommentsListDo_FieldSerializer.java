package org.ednovo.gooru.shared.model.player;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CommentsListDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.ArrayList getSearchResults(org.ednovo.gooru.shared.model.player.CommentsListDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsListDo.class, instance, "searchResults");
  }
  
  private static void setSearchResults(org.ednovo.gooru.shared.model.player.CommentsListDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsListDo.class, instance, "searchResults", value);
  }
  
  private static int getTotalHitCount(org.ednovo.gooru.shared.model.player.CommentsListDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.player.CommentsListDo.class, instance, "totalHitCount");
  }
  
  private static void setTotalHitCount(org.ednovo.gooru.shared.model.player.CommentsListDo instance, int value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.player.CommentsListDo.class, instance, "totalHitCount", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.player.CommentsListDo instance) throws SerializationException {
    setSearchResults(instance, (java.util.ArrayList) streamReader.readObject());
    setTotalHitCount(instance, streamReader.readInt());
    
  }
  
  public static org.ednovo.gooru.shared.model.player.CommentsListDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.player.CommentsListDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.player.CommentsListDo instance) throws SerializationException {
    streamWriter.writeObject(getSearchResults(instance));
    streamWriter.writeInt(getTotalHitCount(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.player.CommentsListDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.player.CommentsListDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.player.CommentsListDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.player.CommentsListDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.player.CommentsListDo)object);
  }
  
}
