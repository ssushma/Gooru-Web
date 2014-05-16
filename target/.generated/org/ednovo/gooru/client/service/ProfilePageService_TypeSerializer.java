package org.ednovo.gooru.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.core.client.GwtScriptOnly;

public class ProfilePageService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
  private static final Map<String, String> methodMapJava;
  private static final Map<String, String> signatureMapJava;
  
  static {
    methodMapJava = loadMethodsJava();
    signatureMapJava = loadSignaturesJava();
  }
  
  @SuppressWarnings("deprecation")
  private static Map<String, String> loadMethodsJava() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("com.google.gwt.i18n.shared.impl.DateRecord/3375188634", "com.google.gwt.i18n.shared.impl.DateRecord_FieldSerializer");
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533", "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer");
    result.put("com.google.gwt.user.client.rpc.RpcTokenException/2345075298", "com.google.gwt.user.client.rpc.RpcTokenException_FieldSerializer");
    result.put("com.google.gwt.user.client.rpc.XsrfToken/4254043109", "com.google.gwt.user.client.rpc.XsrfToken_FieldSerializer");
    result.put("java.lang.Boolean/476441737", "com.google.gwt.user.client.rpc.core.java.lang.Boolean_FieldSerializer");
    result.put("java.lang.Integer/3438268394", "com.google.gwt.user.client.rpc.core.java.lang.Integer_FieldSerializer");
    result.put("java.lang.Short/551743396", "com.google.gwt.user.client.rpc.core.java.lang.Short_FieldSerializer");
    result.put("java.lang.String/2004016611", "com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer");
    result.put("[Ljava.lang.String;/2600011424", "com.google.gwt.user.client.rpc.core.java.lang.String_Array_Rank_1_FieldSerializer");
    result.put("java.sql.Date/730999118", "com.google.gwt.user.client.rpc.core.java.sql.Date_FieldSerializer");
    result.put("java.sql.Time/1816797103", "com.google.gwt.user.client.rpc.core.java.sql.Time_FieldSerializer");
    result.put("java.sql.Timestamp/3040052672", "com.google.gwt.user.client.rpc.core.java.sql.Timestamp_FieldSerializer");
    result.put("[Ljava.util.AbstractMap;/793369879", "com.google.gwt.user.client.rpc.core.java.util.AbstractMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.ArrayList/4159755760", "com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer");
    result.put("java.util.Arrays$ArrayList/2507071751", "com.google.gwt.user.client.rpc.core.java.util.Arrays_ArrayList_FieldSerializer");
    result.put("java.util.Collections$EmptyList/4157118744", "com.google.gwt.user.client.rpc.core.java.util.Collections_EmptyList_FieldSerializer");
    result.put("java.util.Collections$EmptyMap/4174664486", "com.google.gwt.user.client.rpc.core.java.util.Collections_EmptyMap_FieldSerializer");
    result.put("java.util.Collections$EmptySet/3523698179", "com.google.gwt.user.client.rpc.core.java.util.Collections_EmptySet_FieldSerializer");
    result.put("java.util.Collections$SingletonList/1586180994", "com.google.gwt.user.client.rpc.core.java.util.Collections_SingletonList_FieldSerializer");
    result.put("java.util.Date/3385151746", "com.google.gwt.user.client.rpc.core.java.util.Date_FieldSerializer");
    result.put("java.util.HashMap/1797211028", "com.google.gwt.user.client.rpc.core.java.util.HashMap_FieldSerializer");
    result.put("[Ljava.util.HashMap;/1665718734", "com.google.gwt.user.client.rpc.core.java.util.HashMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.HashSet/3273092938", "com.google.gwt.user.client.rpc.core.java.util.HashSet_FieldSerializer");
    result.put("java.util.IdentityHashMap/1839153020", "com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_FieldSerializer");
    result.put("[Ljava.util.IdentityHashMap;/2145185757", "com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.LinkedHashMap/3008245022", "com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_FieldSerializer");
    result.put("[Ljava.util.LinkedHashMap;/3261192069", "com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.LinkedHashSet/1826081506", "com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer");
    result.put("java.util.LinkedList/3953877921", "com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer");
    result.put("[Ljava.util.Map;/1931242982", "com.google.gwt.user.client.rpc.core.java.util.Map_Array_Rank_1_FieldSerializer");
    result.put("[Ljava.util.SortedMap;/4128485282", "com.google.gwt.user.client.rpc.core.java.util.SortedMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.Stack/1346942793", "com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer");
    result.put("java.util.TreeMap/1493889780", "com.google.gwt.user.client.rpc.core.java.util.TreeMap_FieldSerializer");
    result.put("[Ljava.util.TreeMap;/317516023", "com.google.gwt.user.client.rpc.core.java.util.TreeMap_Array_Rank_1_FieldSerializer");
    result.put("java.util.TreeSet/4043497002", "com.google.gwt.user.client.rpc.core.java.util.TreeSet_FieldSerializer");
    result.put("java.util.Vector/3057315478", "com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer");
    result.put("org.ednovo.gooru.shared.exception.GwtException/3918830182", "org.ednovo.gooru.shared.exception.GwtException_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.code.CodeDo/131220112", "org.ednovo.gooru.shared.model.code.CodeDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.code.ProfileCodeDo/2448973243", "org.ednovo.gooru.shared.model.code.ProfileCodeDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.AssetDo/741085425", "org.ednovo.gooru.shared.model.content.AssetDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.AssetsDo/1716048107", "org.ednovo.gooru.shared.model.content.AssetsDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ClasspageListDo/2880821752", "org.ednovo.gooru.shared.model.content.ClasspageListDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.CollectionDo/1113381633", "org.ednovo.gooru.shared.model.content.CollectionDo_FieldSerializer");
    result.put("[Lorg.ednovo.gooru.shared.model.content.CollectionDo;/2933291424", "org.ednovo.gooru.shared.model.content.CollectionDo_Array_Rank_1_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.CollectionItemDo/1047684462", "org.ednovo.gooru.shared.model.content.CollectionItemDo_FieldSerializer");
    result.put("[Lorg.ednovo.gooru.shared.model.content.CollectionItemDo;/1184875994", "org.ednovo.gooru.shared.model.content.CollectionItemDo_Array_Rank_1_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo/1610195008", "org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo/4142923319", "org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ContentDo/2028322943", "org.ednovo.gooru.shared.model.content.ContentDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ExistsResourceDo/913369940", "org.ednovo.gooru.shared.model.content.ExistsResourceDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.LicenseDo/1844289863", "org.ednovo.gooru.shared.model.content.LicenseDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.MetaDO/613872841", "org.ednovo.gooru.shared.model.content.MetaDO_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.NewResourceDo/521016970", "org.ednovo.gooru.shared.model.content.NewResourceDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.QuestionAnswerDo/3826331090", "org.ednovo.gooru.shared.model.content.QuestionAnswerDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.QuestionHintsDo/3269184044", "org.ednovo.gooru.shared.model.content.QuestionHintsDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.RatingDo/645521867", "org.ednovo.gooru.shared.model.content.RatingDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ResourceDo/3959528004", "org.ednovo.gooru.shared.model.content.ResourceDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ResourceFormatDo/3168565264", "org.ednovo.gooru.shared.model.content.ResourceFormatDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo/2901642671", "org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ResourceSourceDo/1005435576", "org.ednovo.gooru.shared.model.content.ResourceSourceDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ResourceTypeDo/3588493868", "org.ednovo.gooru.shared.model.content.ResourceTypeDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.SearchResourceFormatDO/1182961787", "org.ednovo.gooru.shared.model.content.SearchResourceFormatDO_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.StandardFo/4145730419", "org.ednovo.gooru.shared.model.content.StandardFo_FieldSerializer");
    result.put("[Lorg.ednovo.gooru.shared.model.content.StandardFo;/3142854149", "org.ednovo.gooru.shared.model.content.StandardFo_Array_Rank_1_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.TagDo/922819357", "org.ednovo.gooru.shared.model.content.TagDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.ThumbnailDo/1082099638", "org.ednovo.gooru.shared.model.content.ThumbnailDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.TrackActivityDo/2222891005", "org.ednovo.gooru.shared.model.content.TrackActivityDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.content.checkboxSelectedDo/3067428529", "org.ednovo.gooru.shared.model.content.checkboxSelectedDo_FieldSerializer");
    result.put("[Lorg.ednovo.gooru.shared.model.content.checkboxSelectedDo;/765171861", "org.ednovo.gooru.shared.model.content.checkboxSelectedDo_Array_Rank_1_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.CustomFieldDo/3627656785", "org.ednovo.gooru.shared.model.user.CustomFieldDo_FieldSerializer");
    result.put("[Lorg.ednovo.gooru.shared.model.user.CustomFieldDo;/2422953109", "org.ednovo.gooru.shared.model.user.CustomFieldDo_Array_Rank_1_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.EntityOperationDo/2054729672", "org.ednovo.gooru.shared.model.user.EntityOperationDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.FilterSettings/1376823751", "org.ednovo.gooru.shared.model.user.FilterSettings_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.OrganizationDo/1788934167", "org.ednovo.gooru.shared.model.user.OrganizationDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.RoleEntityOperationDo/3472391463", "org.ednovo.gooru.shared.model.user.RoleEntityOperationDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.UserDo/2044292438", "org.ednovo.gooru.shared.model.user.UserDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.UserGroupDo/3259466261", "org.ednovo.gooru.shared.model.user.UserGroupDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.UserMetaDo/3021829284", "org.ednovo.gooru.shared.model.user.UserMetaDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.UserRoleAssocDo/232743541", "org.ednovo.gooru.shared.model.user.UserRoleAssocDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.UserRoleDo/1374157484", "org.ednovo.gooru.shared.model.user.UserRoleDo_FieldSerializer");
    result.put("org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo/3535035561", "org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo_FieldSerializer");
    return result;
  }
  
  @SuppressWarnings("deprecation")
  private static Map<String, String> loadSignaturesJava() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("com.google.gwt.i18n.shared.impl.DateRecord", "com.google.gwt.i18n.shared.impl.DateRecord/3375188634");
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException", "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    result.put("com.google.gwt.user.client.rpc.RpcTokenException", "com.google.gwt.user.client.rpc.RpcTokenException/2345075298");
    result.put("com.google.gwt.user.client.rpc.XsrfToken", "com.google.gwt.user.client.rpc.XsrfToken/4254043109");
    result.put("java.lang.Boolean", "java.lang.Boolean/476441737");
    result.put("java.lang.Integer", "java.lang.Integer/3438268394");
    result.put("java.lang.Short", "java.lang.Short/551743396");
    result.put("java.lang.String", "java.lang.String/2004016611");
    result.put("[Ljava.lang.String;", "[Ljava.lang.String;/2600011424");
    result.put("java.sql.Date", "java.sql.Date/730999118");
    result.put("java.sql.Time", "java.sql.Time/1816797103");
    result.put("java.sql.Timestamp", "java.sql.Timestamp/3040052672");
    result.put("[Ljava.util.AbstractMap;", "[Ljava.util.AbstractMap;/793369879");
    result.put("java.util.ArrayList", "java.util.ArrayList/4159755760");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer.concreteType(), "java.util.Arrays$ArrayList/2507071751");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptyList/4157118744");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyMap_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptyMap/4174664486");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptySet_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptySet/3523698179");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer.concreteType(), "java.util.Collections$SingletonList/1586180994");
    result.put("java.util.Date", "java.util.Date/3385151746");
    result.put("java.util.HashMap", "java.util.HashMap/1797211028");
    result.put("[Ljava.util.HashMap;", "[Ljava.util.HashMap;/1665718734");
    result.put("java.util.HashSet", "java.util.HashSet/3273092938");
    result.put("java.util.IdentityHashMap", "java.util.IdentityHashMap/1839153020");
    result.put("[Ljava.util.IdentityHashMap;", "[Ljava.util.IdentityHashMap;/2145185757");
    result.put("java.util.LinkedHashMap", "java.util.LinkedHashMap/3008245022");
    result.put("[Ljava.util.LinkedHashMap;", "[Ljava.util.LinkedHashMap;/3261192069");
    result.put("java.util.LinkedHashSet", "java.util.LinkedHashSet/1826081506");
    result.put("java.util.LinkedList", "java.util.LinkedList/3953877921");
    result.put("[Ljava.util.Map;", "[Ljava.util.Map;/1931242982");
    result.put("[Ljava.util.SortedMap;", "[Ljava.util.SortedMap;/4128485282");
    result.put("java.util.Stack", "java.util.Stack/1346942793");
    result.put("java.util.TreeMap", "java.util.TreeMap/1493889780");
    result.put("[Ljava.util.TreeMap;", "[Ljava.util.TreeMap;/317516023");
    result.put("java.util.TreeSet", "java.util.TreeSet/4043497002");
    result.put("java.util.Vector", "java.util.Vector/3057315478");
    result.put("org.ednovo.gooru.shared.exception.GwtException", "org.ednovo.gooru.shared.exception.GwtException/3918830182");
    result.put("org.ednovo.gooru.shared.model.code.CodeDo", "org.ednovo.gooru.shared.model.code.CodeDo/131220112");
    result.put("org.ednovo.gooru.shared.model.code.ProfileCodeDo", "org.ednovo.gooru.shared.model.code.ProfileCodeDo/2448973243");
    result.put("org.ednovo.gooru.shared.model.content.AssetDo", "org.ednovo.gooru.shared.model.content.AssetDo/741085425");
    result.put("org.ednovo.gooru.shared.model.content.AssetsDo", "org.ednovo.gooru.shared.model.content.AssetsDo/1716048107");
    result.put("org.ednovo.gooru.shared.model.content.ClasspageListDo", "org.ednovo.gooru.shared.model.content.ClasspageListDo/2880821752");
    result.put("org.ednovo.gooru.shared.model.content.CollectionDo", "org.ednovo.gooru.shared.model.content.CollectionDo/1113381633");
    result.put("[Lorg.ednovo.gooru.shared.model.content.CollectionDo;", "[Lorg.ednovo.gooru.shared.model.content.CollectionDo;/2933291424");
    result.put("org.ednovo.gooru.shared.model.content.CollectionItemDo", "org.ednovo.gooru.shared.model.content.CollectionItemDo/1047684462");
    result.put("[Lorg.ednovo.gooru.shared.model.content.CollectionItemDo;", "[Lorg.ednovo.gooru.shared.model.content.CollectionItemDo;/1184875994");
    result.put("org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo", "org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo/1610195008");
    result.put("org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo", "org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo/4142923319");
    result.put("org.ednovo.gooru.shared.model.content.ContentDo", "org.ednovo.gooru.shared.model.content.ContentDo/2028322943");
    result.put("org.ednovo.gooru.shared.model.content.ExistsResourceDo", "org.ednovo.gooru.shared.model.content.ExistsResourceDo/913369940");
    result.put("org.ednovo.gooru.shared.model.content.LicenseDo", "org.ednovo.gooru.shared.model.content.LicenseDo/1844289863");
    result.put("org.ednovo.gooru.shared.model.content.MetaDO", "org.ednovo.gooru.shared.model.content.MetaDO/613872841");
    result.put("org.ednovo.gooru.shared.model.content.NewResourceDo", "org.ednovo.gooru.shared.model.content.NewResourceDo/521016970");
    result.put("org.ednovo.gooru.shared.model.content.QuestionAnswerDo", "org.ednovo.gooru.shared.model.content.QuestionAnswerDo/3826331090");
    result.put("org.ednovo.gooru.shared.model.content.QuestionHintsDo", "org.ednovo.gooru.shared.model.content.QuestionHintsDo/3269184044");
    result.put("org.ednovo.gooru.shared.model.content.RatingDo", "org.ednovo.gooru.shared.model.content.RatingDo/645521867");
    result.put("org.ednovo.gooru.shared.model.content.ResourceDo", "org.ednovo.gooru.shared.model.content.ResourceDo/3959528004");
    result.put("org.ednovo.gooru.shared.model.content.ResourceFormatDo", "org.ednovo.gooru.shared.model.content.ResourceFormatDo/3168565264");
    result.put("org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo", "org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo/2901642671");
    result.put("org.ednovo.gooru.shared.model.content.ResourceSourceDo", "org.ednovo.gooru.shared.model.content.ResourceSourceDo/1005435576");
    result.put("org.ednovo.gooru.shared.model.content.ResourceTypeDo", "org.ednovo.gooru.shared.model.content.ResourceTypeDo/3588493868");
    result.put("org.ednovo.gooru.shared.model.content.SearchResourceFormatDO", "org.ednovo.gooru.shared.model.content.SearchResourceFormatDO/1182961787");
    result.put("org.ednovo.gooru.shared.model.content.StandardFo", "org.ednovo.gooru.shared.model.content.StandardFo/4145730419");
    result.put("[Lorg.ednovo.gooru.shared.model.content.StandardFo;", "[Lorg.ednovo.gooru.shared.model.content.StandardFo;/3142854149");
    result.put("org.ednovo.gooru.shared.model.content.TagDo", "org.ednovo.gooru.shared.model.content.TagDo/922819357");
    result.put("org.ednovo.gooru.shared.model.content.ThumbnailDo", "org.ednovo.gooru.shared.model.content.ThumbnailDo/1082099638");
    result.put("org.ednovo.gooru.shared.model.content.TrackActivityDo", "org.ednovo.gooru.shared.model.content.TrackActivityDo/2222891005");
    result.put("org.ednovo.gooru.shared.model.content.checkboxSelectedDo", "org.ednovo.gooru.shared.model.content.checkboxSelectedDo/3067428529");
    result.put("[Lorg.ednovo.gooru.shared.model.content.checkboxSelectedDo;", "[Lorg.ednovo.gooru.shared.model.content.checkboxSelectedDo;/765171861");
    result.put("org.ednovo.gooru.shared.model.user.CustomFieldDo", "org.ednovo.gooru.shared.model.user.CustomFieldDo/3627656785");
    result.put("[Lorg.ednovo.gooru.shared.model.user.CustomFieldDo;", "[Lorg.ednovo.gooru.shared.model.user.CustomFieldDo;/2422953109");
    result.put("org.ednovo.gooru.shared.model.user.EntityOperationDo", "org.ednovo.gooru.shared.model.user.EntityOperationDo/2054729672");
    result.put("org.ednovo.gooru.shared.model.user.FilterSettings", "org.ednovo.gooru.shared.model.user.FilterSettings/1376823751");
    result.put("org.ednovo.gooru.shared.model.user.OrganizationDo", "org.ednovo.gooru.shared.model.user.OrganizationDo/1788934167");
    result.put("org.ednovo.gooru.shared.model.user.RoleEntityOperationDo", "org.ednovo.gooru.shared.model.user.RoleEntityOperationDo/3472391463");
    result.put("org.ednovo.gooru.shared.model.user.UserDo", "org.ednovo.gooru.shared.model.user.UserDo/2044292438");
    result.put("org.ednovo.gooru.shared.model.user.UserGroupDo", "org.ednovo.gooru.shared.model.user.UserGroupDo/3259466261");
    result.put("org.ednovo.gooru.shared.model.user.UserMetaDo", "org.ednovo.gooru.shared.model.user.UserMetaDo/3021829284");
    result.put("org.ednovo.gooru.shared.model.user.UserRoleAssocDo", "org.ednovo.gooru.shared.model.user.UserRoleAssocDo/232743541");
    result.put("org.ednovo.gooru.shared.model.user.UserRoleDo", "org.ednovo.gooru.shared.model.user.UserRoleDo/1374157484");
    result.put("org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo", "org.ednovo.gooru.shared.model.user.UserTaxonomyPreferenceDo/3535035561");
    return result;
  }
  
  public ProfilePageService_TypeSerializer() {
    super(methodMapJava, null, signatureMapJava, null);
  }
  
}
