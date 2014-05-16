package org.ednovo.gooru.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.core.client.GwtScriptOnly;

public class LibraryService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
  private static final Map<String, String> methodMapJava;
  private static final Map<String, String> signatureMapJava;
  
  static {
    methodMapJava = loadMethodsJava();
    signatureMapJava = loadSignaturesJava();
  }
  
  @SuppressWarnings("deprecation")
  private static Map<String, String> loadMethodsJava() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533", "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer");
    result.put("com.google.gwt.user.client.rpc.RpcTokenException/2345075298", "com.google.gwt.user.client.rpc.RpcTokenException_FieldSerializer");
    result.put("com.google.gwt.user.client.rpc.XsrfToken/4254043109", "com.google.gwt.user.client.rpc.XsrfToken_FieldSerializer");
    result.put("java.lang.Integer/3438268394", "com.google.gwt.user.client.rpc.core.java.lang.Integer_FieldSerializer");
    result.put("java.lang.String/2004016611", "com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer");
    result.put("[Ljava.lang.String;/2600011424", "com.google.gwt.user.client.rpc.core.java.lang.String_Array_Rank_1_FieldSerializer");
    result.put("[Ljava.util.AbstractMap;/793369879", "com.google.gwt.user.client.rpc.core.java.util.AbstractMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.ArrayList/4159755760", "com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer");
    result.put("java.util.Arrays$ArrayList/2507071751", "com.google.gwt.user.client.rpc.core.java.util.Arrays_ArrayList_FieldSerializer");
    result.put("java.util.Collections$EmptyList/4157118744", "com.google.gwt.user.client.rpc.core.java.util.Collections_EmptyList_FieldSerializer");
    result.put("java.util.Collections$EmptyMap/4174664486", "com.google.gwt.user.client.rpc.core.java.util.Collections_EmptyMap_FieldSerializer");
    result.put("java.util.Collections$SingletonList/1586180994", "com.google.gwt.user.client.rpc.core.java.util.Collections_SingletonList_FieldSerializer");
    result.put("java.util.HashMap/1797211028", "com.google.gwt.user.client.rpc.core.java.util.HashMap_FieldSerializer");
    result.put("[Ljava.util.HashMap;/1665718734", "com.google.gwt.user.client.rpc.core.java.util.HashMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.IdentityHashMap/1839153020", "com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_FieldSerializer");
    result.put("[Ljava.util.IdentityHashMap;/2145185757", "com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.LinkedHashMap/3008245022", "com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_FieldSerializer");
    result.put("[Ljava.util.LinkedHashMap;/3261192069", "com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.LinkedList/3953877921", "com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer");
    result.put("[Ljava.util.Map;/1931242982", "com.google.gwt.user.client.rpc.core.java.util.Map_Array_Rank_1_FieldSerializer");
    result.put("[Ljava.util.SortedMap;/4128485282", "com.google.gwt.user.client.rpc.core.java.util.SortedMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.Stack/1346942793", "com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer");
    result.put("java.util.TreeMap/1493889780", "com.google.gwt.user.client.rpc.core.java.util.TreeMap_FieldSerializer");
    result.put("[Ljava.util.TreeMap;/317516023", "com.google.gwt.user.client.rpc.core.java.util.TreeMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.Vector/3057315478", "com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer");
    result.put("org.ednovo.gooru.shared.exception.GwtException/3918830182", "org.ednovo.gooru.shared.exception.GwtException_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo/1610195008", "org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.RatingDo/645521867", "org.ednovo.gooru.shared.model.content.RatingDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ResourceFormatDo/3168565264", "org.ednovo.gooru.shared.model.content.ResourceFormatDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ResourceSourceDo/1005435576", "org.ednovo.gooru.shared.model.content.ResourceSourceDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ResourceTypeDo/3588493868", "org.ednovo.gooru.shared.model.content.ResourceTypeDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.StandardFo/4145730419", "org.ednovo.gooru.shared.model.content.StandardFo_FieldSerializer");
    result.put("[Lorg.ednovo.gooru.shared.model.content.StandardFo;/3142854149", "org.ednovo.gooru.shared.model.content.StandardFo_Array_Rank_1_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ThumbnailDo/1082099638", "org.ednovo.gooru.shared.model.content.ThumbnailDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.ConceptDo/841148223", "org.ednovo.gooru.shared.model.library.ConceptDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.CourseDo/72249345", "org.ednovo.gooru.shared.model.library.CourseDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.LessonDo/2677307583", "org.ednovo.gooru.shared.model.library.LessonDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo/2693661876", "org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.LibraryResourceDo/1500910684", "org.ednovo.gooru.shared.model.library.LibraryResourceDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.LibraryUserDo/2427164481", "org.ednovo.gooru.shared.model.library.LibraryUserDo_FieldSerializer");
    result.put("[Lorg.ednovo.gooru.shared.model.library.LibraryUserDo;/303781428", "org.ednovo.gooru.shared.model.library.LibraryUserDo_Array_Rank_1_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.PartnerConceptListDo/371523801", "org.ednovo.gooru.shared.model.library.PartnerConceptListDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.PartnerFolderDo/763755581", "org.ednovo.gooru.shared.model.library.PartnerFolderDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.PartnerFolderListDo/4170049844", "org.ednovo.gooru.shared.model.library.PartnerFolderListDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.StandardCourseDo/456039434", "org.ednovo.gooru.shared.model.library.StandardCourseDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.StandardsDo/723006384", "org.ednovo.gooru.shared.model.library.StandardsDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.SubjectDo/31681262", "org.ednovo.gooru.shared.model.library.SubjectDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.TopicDo/4010481256", "org.ednovo.gooru.shared.model.library.TopicDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.library.UnitDo/3146664261", "org.ednovo.gooru.shared.model.library.UnitDo_FieldSerializer");
    return result;
  }
  
  @SuppressWarnings("deprecation")
  private static Map<String, String> loadSignaturesJava() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException", "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    result.put("com.google.gwt.user.client.rpc.RpcTokenException", "com.google.gwt.user.client.rpc.RpcTokenException/2345075298");
    result.put("com.google.gwt.user.client.rpc.XsrfToken", "com.google.gwt.user.client.rpc.XsrfToken/4254043109");
    result.put("java.lang.Integer", "java.lang.Integer/3438268394");
    result.put("java.lang.String", "java.lang.String/2004016611");
    result.put("[Ljava.lang.String;", "[Ljava.lang.String;/2600011424");
    result.put("[Ljava.util.AbstractMap;", "[Ljava.util.AbstractMap;/793369879");
    result.put("java.util.ArrayList", "java.util.ArrayList/4159755760");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer.concreteType(), "java.util.Arrays$ArrayList/2507071751");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptyList/4157118744");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyMap_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptyMap/4174664486");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer.concreteType(), "java.util.Collections$SingletonList/1586180994");
    result.put("java.util.HashMap", "java.util.HashMap/1797211028");
    result.put("[Ljava.util.HashMap;", "[Ljava.util.HashMap;/1665718734");
    result.put("java.util.IdentityHashMap", "java.util.IdentityHashMap/1839153020");
    result.put("[Ljava.util.IdentityHashMap;", "[Ljava.util.IdentityHashMap;/2145185757");
    result.put("java.util.LinkedHashMap", "java.util.LinkedHashMap/3008245022");
    result.put("[Ljava.util.LinkedHashMap;", "[Ljava.util.LinkedHashMap;/3261192069");
    result.put("java.util.LinkedList", "java.util.LinkedList/3953877921");
    result.put("[Ljava.util.Map;", "[Ljava.util.Map;/1931242982");
    result.put("[Ljava.util.SortedMap;", "[Ljava.util.SortedMap;/4128485282");
    result.put("java.util.Stack", "java.util.Stack/1346942793");
    result.put("java.util.TreeMap", "java.util.TreeMap/1493889780");
    result.put("[Ljava.util.TreeMap;", "[Ljava.util.TreeMap;/317516023");
    result.put("java.util.Vector", "java.util.Vector/3057315478");
    result.put("org.ednovo.gooru.shared.exception.GwtException", "org.ednovo.gooru.shared.exception.GwtException/3918830182");
    result.put("org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo", "org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo/1610195008");
    result.put("org.ednovo.gooru.shared.model.content.RatingDo", "org.ednovo.gooru.shared.model.content.RatingDo/645521867");
    result.put("org.ednovo.gooru.shared.model.content.ResourceFormatDo", "org.ednovo.gooru.shared.model.content.ResourceFormatDo/3168565264");
    result.put("org.ednovo.gooru.shared.model.content.ResourceSourceDo", "org.ednovo.gooru.shared.model.content.ResourceSourceDo/1005435576");
    result.put("org.ednovo.gooru.shared.model.content.ResourceTypeDo", "org.ednovo.gooru.shared.model.content.ResourceTypeDo/3588493868");
    result.put("org.ednovo.gooru.shared.model.content.StandardFo", "org.ednovo.gooru.shared.model.content.StandardFo/4145730419");
    result.put("[Lorg.ednovo.gooru.shared.model.content.StandardFo;", "[Lorg.ednovo.gooru.shared.model.content.StandardFo;/3142854149");
    result.put("org.ednovo.gooru.shared.model.content.ThumbnailDo", "org.ednovo.gooru.shared.model.content.ThumbnailDo/1082099638");
    result.put("org.ednovo.gooru.shared.model.library.ConceptDo", "org.ednovo.gooru.shared.model.library.ConceptDo/841148223");
    result.put("org.ednovo.gooru.shared.model.library.CourseDo", "org.ednovo.gooru.shared.model.library.CourseDo/72249345");
    result.put("org.ednovo.gooru.shared.model.library.LessonDo", "org.ednovo.gooru.shared.model.library.LessonDo/2677307583");
    result.put("org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo", "org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo/2693661876");
    result.put("org.ednovo.gooru.shared.model.library.LibraryResourceDo", "org.ednovo.gooru.shared.model.library.LibraryResourceDo/1500910684");
    result.put("org.ednovo.gooru.shared.model.library.LibraryUserDo", "org.ednovo.gooru.shared.model.library.LibraryUserDo/2427164481");
    result.put("[Lorg.ednovo.gooru.shared.model.library.LibraryUserDo;", "[Lorg.ednovo.gooru.shared.model.library.LibraryUserDo;/303781428");
    result.put("org.ednovo.gooru.shared.model.library.PartnerConceptListDo", "org.ednovo.gooru.shared.model.library.PartnerConceptListDo/371523801");
    result.put("org.ednovo.gooru.shared.model.library.PartnerFolderDo", "org.ednovo.gooru.shared.model.library.PartnerFolderDo/763755581");
    result.put("org.ednovo.gooru.shared.model.library.PartnerFolderListDo", "org.ednovo.gooru.shared.model.library.PartnerFolderListDo/4170049844");
    result.put("org.ednovo.gooru.shared.model.library.StandardCourseDo", "org.ednovo.gooru.shared.model.library.StandardCourseDo/456039434");
    result.put("org.ednovo.gooru.shared.model.library.StandardsDo", "org.ednovo.gooru.shared.model.library.StandardsDo/723006384");
    result.put("org.ednovo.gooru.shared.model.library.SubjectDo", "org.ednovo.gooru.shared.model.library.SubjectDo/31681262");
    result.put("org.ednovo.gooru.shared.model.library.TopicDo", "org.ednovo.gooru.shared.model.library.TopicDo/4010481256");
    result.put("org.ednovo.gooru.shared.model.library.UnitDo", "org.ednovo.gooru.shared.model.library.UnitDo/3146664261");
    return result;
  }
  
  public LibraryService_TypeSerializer() {
    super(methodMapJava, null, signatureMapJava, null);
  }
  
}
