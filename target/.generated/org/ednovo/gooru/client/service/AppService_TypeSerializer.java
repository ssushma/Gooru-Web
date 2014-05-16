package org.ednovo.gooru.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.core.client.GwtScriptOnly;

public class AppService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
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
    result.put("java.util.ArrayList/4159755760", "com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer");
    result.put("java.util.Arrays$ArrayList/2507071751", "com.google.gwt.user.client.rpc.core.java.util.Arrays_ArrayList_FieldSerializer");
    result.put("java.util.Collections$EmptyList/4157118744", "com.google.gwt.user.client.rpc.core.java.util.Collections_EmptyList_FieldSerializer");
    result.put("java.util.Collections$EmptySet/3523698179", "com.google.gwt.user.client.rpc.core.java.util.Collections_EmptySet_FieldSerializer");
    result.put("java.util.Collections$SingletonList/1586180994", "com.google.gwt.user.client.rpc.core.java.util.Collections_SingletonList_FieldSerializer");
    result.put("java.util.Date/3385151746", "com.google.gwt.user.client.rpc.core.java.util.Date_FieldSerializer");
    result.put("java.util.HashSet/3273092938", "com.google.gwt.user.client.rpc.core.java.util.HashSet_FieldSerializer");
    result.put("java.util.LinkedHashSet/1826081506", "com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer");
    result.put("java.util.LinkedList/3953877921", "com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer");
    result.put("java.util.Stack/1346942793", "com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer");
    result.put("java.util.TreeMap/1493889780", "com.google.gwt.user.client.rpc.core.java.util.TreeMap_FieldSerializer");
    result.put("java.util.TreeSet/4043497002", "com.google.gwt.user.client.rpc.core.java.util.TreeSet_FieldSerializer");
    result.put("java.util.Vector/3057315478", "com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer");
    result.put("org.ednovo.gooru.shared.exception.GwtException/3918830182", "org.ednovo.gooru.shared.exception.GwtException_FieldSerializer");
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
    result.put("java.util.ArrayList", "java.util.ArrayList/4159755760");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer.concreteType(), "java.util.Arrays$ArrayList/2507071751");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptyList/4157118744");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptySet_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptySet/3523698179");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer.concreteType(), "java.util.Collections$SingletonList/1586180994");
    result.put("java.util.Date", "java.util.Date/3385151746");
    result.put("java.util.HashSet", "java.util.HashSet/3273092938");
    result.put("java.util.LinkedHashSet", "java.util.LinkedHashSet/1826081506");
    result.put("java.util.LinkedList", "java.util.LinkedList/3953877921");
    result.put("java.util.Stack", "java.util.Stack/1346942793");
    result.put("java.util.TreeMap", "java.util.TreeMap/1493889780");
    result.put("java.util.TreeSet", "java.util.TreeSet/4043497002");
    result.put("java.util.Vector", "java.util.Vector/3057315478");
    result.put("org.ednovo.gooru.shared.exception.GwtException", "org.ednovo.gooru.shared.exception.GwtException/3918830182");
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
  
  public AppService_TypeSerializer() {
    super(methodMapJava, null, signatureMapJava, null);
  }
  
}
