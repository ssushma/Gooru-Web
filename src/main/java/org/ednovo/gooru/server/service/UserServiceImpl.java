/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.server.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.service.UserService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.ResourceDeserializer;
import org.ednovo.gooru.server.form.ResourceFormFactory;
import org.ednovo.gooru.server.request.JsonResponseRepresentation;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.exception.ServerDownException;
import org.ednovo.gooru.shared.model.code.UserDashBoardCommonInfoDO;
import org.ednovo.gooru.shared.model.content.ResourceFormatDo;
import org.ednovo.gooru.shared.model.content.SearchRatingsDo;
import org.ednovo.gooru.shared.model.user.BiographyDo;
import org.ednovo.gooru.shared.model.user.CustomFieldDo;
import org.ednovo.gooru.shared.model.user.GenderDo;
import org.ednovo.gooru.shared.model.user.IsFollowDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.model.user.ProfilePageDo;
import org.ednovo.gooru.shared.model.user.ProfileRatingsReactionsDO;
import org.ednovo.gooru.shared.model.user.ProfileV2Do;
import org.ednovo.gooru.shared.model.user.SettingDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.model.user.UserFollowDo;
import org.ednovo.gooru.shared.model.user.UserSummaryDo;
import org.ednovo.gooru.shared.model.user.UserTagsDo;
import org.ednovo.gooru.shared.model.user.UserTagsResourceDO;
import org.ednovo.gooru.shared.model.user.V2UserDo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author Search Team
 * 
 */
@Service("userService")
@ServiceURL("/userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	ResourceDeserializer resourceDeserializer;

	private static final long serialVersionUID = -7268580337769405632L;
	
	private static final String BY_EMAIL_ID = "emailId";
	
	private static final String GOORU_CLASSIC_URL = "gooruClassicUrl";
	
	private static final String REGISTRATION_TYPE = "registrationType";
	
	private static final String GOORU_BASE_URL = "gooruBaseUrl";
	
	private static final String CHILD = "Child";
	private static final String OPTIONALVALUE="optionalValue";
	private static final String PARTY_CUSTOM_FIELD = "partyCustomField";
	private static final String PROFILE = "profile";
	
	private static final String USER_META_ACTIVE_FLAG = "&userMetaActiveFlag=1";
	
	
	public static final String FIELDS="fields";
	public static final String DATASOURCE="dataSource";
	public static final String GRANULARITY="granularity";
	public static final String GROUPBY="groupBy";
	public static final String LOGICALKey="logicalOperatorPrefix";
	public static final String RATNGFIELDS="copiedCount,shareCount,countOfReaction5,countOfRating5,countOfRating4,countOfRating3,countOfRating2,countOfRating1,countOfICanExplain,countOfINeedHelp,countOfIDoNotUnderstand,countOfMeh,countOfICanUnderstand,commentCount,reviewCount";
	
	public static final String TYPE="type";
	public static final String VALUETYPE="valueType";
	public static final String FIELDNAME="fieldName";
	public static final String OPERATOR="operator";
	public static final String VALUE="value";
	
	public static final String FILTER=	"filter";
	public static final String AGGREGATIONS="aggregations";
	public static final String PAGINATION="pagination";
	public static final String OFFSETVAL=	"offset";
	public static final String LIMITVAL="limit";
	public static final String SORTBY="sortBy";
	public static final String SORTORDER="sortOrder";
	public static final String ORDERKEY="order";
	
	

	@Override
	public UserDo getEmailId(String emailId) {
		return getEmailId(emailId, BY_EMAIL_ID);
	}

	@Override
	public UserDo getEmailId(String emailId, String type) {
	  	UserDo userDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_USER_AVAILABILITY, type,getLoggedInSessionToken(), emailId);
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userDo;
	}

	@Override
	public void registerUser(Map<String, String> params) {
		params.put(GOORU_CLASSIC_URL, URLEncoder.encode(getHomeEndPoint() + "#" + PlaceTokens.HOME));
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.REGISTER_USER, params, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public UserDo getRegistredUserDetails(String gooruUid) {
		UserDo userDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_REGISTERED_USER_DETAILS, gooruUid, getLoggedInSessionToken());
		JsonRepresentation jsonRep = null;
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userDo;
	}

	@Override
	public SettingDo getUserProfileDetails(String gooruUid) {
		SettingDo settingeDo = null;
		String userUid = getLoggedInUserUid();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_PROFILE_DETAILS, userUid, getLoggedInSessionToken());
		
		JsonRepresentation jsonRep = null;
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			settingeDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), SettingDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return settingeDo;
	}
	
	@Override
	public V2UserDo getV2UserProfileDetails(String gooruUid) {
		V2UserDo settingeDo = null;
		String userUid = getLoggedInUserUid();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_PROFILE_V2_DETAILS, userUid, getLoggedInSessionToken());
		System.out.println("urlval::"+url);
		JsonRepresentation jsonRep = null;
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			settingeDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), V2UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return settingeDo;
	}

	@Override
	public ProfileDo updateUserDetails(String gooruUid, String token, Map<String, String> params) {
		ProfileDo profileDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_REGISTER_USER, gooruUid, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), generateFormFromParamters(params));
		jsonRep = jsonResponseRep.getJsonRepresentation();
		String text = null;
		try {
			text = jsonRep.getText();
			profileDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfileDo.class);
			setUserFilterProperties(profileDo.getUser());
			if (params.containsKey(REGISTRATION_TYPE) && !params.get(REGISTRATION_TYPE).equalsIgnoreCase(CHILD)) {
				setLoggedInSessionToken(token);
				setLoggedInUserUid(profileDo.getUser().getGooruUId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new GwtException(text != null ? text : e.getMessage());
		}
		return profileDo;
	}

	@Override
	public void resendConfirmationMail(Map<String, String> params) {
		params.put(GOORU_CLASSIC_URL, URLEncoder.encode(getHomeEndPoint() + "#" + PlaceTokens.HOME));
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.SEND_CONFIRMATION_MAIL, params, getLoggedInSessionToken());
		ServiceProcessor.post(url, getRestUsername(), getRestPassword());
	}

	/*@Override
	public UserDo getUser(String userUid) {
		return getUserInfo(userUid);
	}*/

	@Override
	public Map<String, Object> forgotPassword(String emailId) {
		JsonRepresentation jsonRep = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put(GOORU_CLASSIC_URL, URLEncoder.encode(getHomeEndPoint() + "#" + PlaceTokens.HOME));
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.FORGOT_PASSWORD, params, getLoggedInSessionToken(), emailId);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return resourceDeserializer.forgotPassword(jsonRep);
	}

	@Override
	public Map<String, Object> resetCredential(String formData) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_RESET_CREDENTIAL, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return resourceDeserializer.resetPassword(jsonRep,jsonResponseRep.getStatusCode(),jsonResponseRep.getErrorMessage()); 
	}

	@Override
	public UserDo updateUserViewFlag(String gooruUid, Integer viewFlag) throws GwtException {
		UserDo userDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_VIEW, gooruUid,getLoggedInSessionToken(), String.valueOf(viewFlag));
		JsonRepresentation jsonRep = null;
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userDo;
	}

	@Override
	public SettingDo updateProfileSettings(String gooruUid,	 Map<String, String> params) throws GwtException {
		SettingDo settingDo = null;
		String userUid = getLoggedInUserUid();
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_PROFILE_DETAILS, userUid, getLoggedInSessionToken());
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), generateFormFromParamters(params));
		jsonRep = jsonResponseRep.getJsonRepresentation();
		String text="";
		try {
			text = jsonRep.getText();
			settingDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), SettingDo.class);
		} catch (Exception e) {
			throw new GwtException(text != null ? text : e.getMessage());
		}
		return settingDo;
	}

	
	public ProfilePageDo deserializeProfilePage(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				
				ProfilePageDo profilePageDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfilePageDo.class);
				
				return profilePageDo;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ProfilePageDo();
	}
	
	
	@Override
	public ProfilePageDo updateUserProfileVisibility(String gooruUid,
		String optionalValue) throws GwtException {
		JsonRepresentation jsonRep = null;
		ProfilePageDo profilePageDo = new ProfilePageDo();
		profilePageDo.setOptionalValue(optionalValue);
		profilePageDo.setCategory("user_meta");
		profilePageDo.setOptionalKey("show_profile_page");
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_PROFILE_VISIBILTY, getLoggedInUserUid(), getLoggedInSessionToken());
		String formData = ResourceFormFactory.generateStringDataForm(profilePageDo,PARTY_CUSTOM_FIELD);
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		//return deserializeProfilePage(jsonRep);
		return profilePageDo;
		
	}

	@Override
	public ProfilePageDo getUserProfilePage(String gooruUid) throws GwtException {
		ProfilePageDo profilePageDo = null;
		String userUid = getLoggedInUserUid();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_PROFILE_PAGE, userUid, getLoggedInSessionToken());
		
		JsonRepresentation jsonRep = null;
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			profilePageDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfilePageDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return profilePageDo;
	}

	@Override
	public ProfilePageDo getUserPublicProfilePage(String gooruUid) throws GwtException {
		ProfilePageDo profilePageDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_PROFILE_PAGE, gooruUid, getLoggedInSessionToken());
		
		JsonRepresentation jsonRep = null;
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			if(jsonRep.getText()!=null&&!jsonRep.getText().equals("null")&&!jsonRep.getText().equals("")){
				profilePageDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfilePageDo.class);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return profilePageDo;
	}

	@Override
	public BiographyDo updateProfileBiography(String gooruUid,String biography,String role,String firstName,String lastName,String gender) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
		BiographyDo biographyDo = new BiographyDo();
		biographyDo.setAboutMe(biography);
		biographyDo.setSubject(role);
		biographyDo.setFirstName(firstName);
		biographyDo.setLastName(lastName);
		biographyDo.setGenderId(gender);
		String formData = ResourceFormFactory.generateStringDataForm(biographyDo,PROFILE);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return biographyDo;
	}


	@Override
	public ProfileDo getUserProfileV2Details(String gooruUid, String userMetaActiveFlag)
			throws GwtException {
		ProfileDo profileDo = null;
		String userUid = getLoggedInUserUid();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_PROFILE_V2_DETAILS, gooruUid, getLoggedInSessionToken());
		if(userMetaActiveFlag.equalsIgnoreCase("1")) {
			url+=USER_META_ACTIVE_FLAG;
		}
		JsonRepresentation jsonRep = null;
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			profileDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfileDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return profileDo;
	}

	@Override
	public UserDo createUser(String postData) throws GwtException {
		UserDo userDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_CREATE_USER, getLoggedInSessionToken());
		JsonRepresentation jsonRep = null;
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(),postData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			System.out.println("jsonRep.getJsonObject().toString(.."+jsonRep.getJsonObject().toString());
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return userDo;
	}

	public void updateNewEmailStatus(String emailId, boolean isEmailConfirmation) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
		String formData = "";
		formData = "{\"profile\": {\"user\": {\"emailId\":\""+emailId+"\"}},\"emailConfirmStatus\":"+isEmailConfirmation+"}";
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
	}

	@Override
	public V2UserDo updateV2ProfileDo(String EmailId,String accountType,String firstName,String lastName,String biography,String password, String userName, String gender, boolean isSendConfirmEmail) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_UPDATE_USER_PROFILE, getLoggedInUserUid(), getLoggedInSessionToken());
		V2UserDo userv2Do = new V2UserDo();
		ProfileV2Do profileV2Do = new ProfileV2Do();
		UserDo user = new UserDo();
		
		if (!userName.equalsIgnoreCase("")){
			user.setUsername(userName);
		}
		if(!firstName.equalsIgnoreCase("")){
			user.setFirstName(firstName);
		}
		if(!lastName.equalsIgnoreCase("")){
			user.setLastName(lastName);
		}
		if(!EmailId.equalsIgnoreCase("")){
			user.setEmailId(EmailId);
		}
		if (accountType.equalsIgnoreCase("")){
			user.setAccountTypeId(3);
		}
		profileV2Do.setUser(user);
		if(!biography.equalsIgnoreCase("")){
			profileV2Do.setAboutMe(biography);
		}
		userv2Do.setProfile(profileV2Do);
		userv2Do.setAccountType(accountType);
		
		if (!gender.equalsIgnoreCase("")){
			GenderDo genderDo = new GenderDo();
			genderDo.setGenderId(gender);
			profileV2Do.setGender(genderDo);
		}
		
		if(!password.equalsIgnoreCase("")){
			userv2Do.setPassword(password);
		}
		if (isSendConfirmEmail){
			userv2Do.setEmailConfirmStatus("true");
			user.setConfirmStatus(0);
		}else{
			userv2Do.setEmailConfirmStatus("false");
			user.setConfirmStatus(1);
		}
	
		String formData = ResourceFormFactory.generateStringDataForm(userv2Do,null);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try{
			userv2Do = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), V2UserDo.class);
		}
		catch(JSONException ex){
			
		}
		return userv2Do;
		
	}
	
	/*@Override
	public ProfilePageDo updateProfileBiography(String gooruUid,String biography) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
		ProfilePageDo profilePageDo = new ProfilePageDo();
		profilePageDo.setAboutMe(biography);
		String formData = ResourceFormFactory.generateStringDataForm(profilePageDo,PROFILE);
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		return profilePageDo;
	}
	*/
	
	@Override
	public void sendWelcomeMail(String gooruUId, String emailType) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(GOORU_BASE_URL, getHomeEndPoint() + "/#discover");
		params.put("type", emailType);
		String formData = ResourceFormFactory.generateStringDataForm(params,null);
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_SEND_WELCOME_MAIL, gooruUId, getLoggedInSessionToken());
		ServiceProcessor.post(url, getRestUsername(), getRestPassword(), formData);
	}

	@Override
	public void updatePartyCustomField(String gooruUid, String optionKey,
			String optionValue) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_UPDATE_PARTY_CUSTOM_FIELD, getLoggedInUserUid(), getLoggedInSessionToken());
		try{
			JSONObject updateCustomFieldObj=new JSONObject();
			JSONObject optionObject=new JSONObject();
			optionObject.put("optionalValue", optionValue);
			optionObject.put("optionalKey", optionKey);
			updateCustomFieldObj.put("partyCustomField", optionObject);
			JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), updateCustomFieldObj.toString());
			jsonRep = jsonResponseRep.getJsonRepresentation();
		}
		catch(Exception ex){}
		
	}
	//followingUser
	@Override
	public List<UserFollowDo> getFollowedOnUsers(String gooruUid,String offset, String limit) throws GwtException {
		UserFollowDo userFollowDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_FOLLOWING, gooruUid,getLoggedInSessionToken(),offset,limit);
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeFollowingUser(jsonRep);
	
	}
	//followerUser
	@Override
	public List<UserFollowDo> getFollowedByUsers(String gooruUid,String offset, String limit) throws GwtException {
		UserFollowDo userFollowDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_FOLLOWERS, gooruUid,getLoggedInSessionToken(),offset,limit);
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeFollowingUser(jsonRep);
		
	}
	public List<UserFollowDo> deserializeFollowingUser(JsonRepresentation jsonRep) {
		List<UserFollowDo> userFollowList = null;
		int totatHintCount;
		userFollowList = new ArrayList<UserFollowDo>();
		if (jsonRep != null && jsonRep.getSize() != -1) {
			UserFollowDo userFollowDo=null;
			try {
				
				JSONObject followingUserObject=jsonRep.getJsonObject();
				totatHintCount=followingUserObject.getInt("totalHitCount");
				
				JSONArray followingList=followingUserObject.getJSONArray("searchResults");
				
				for(int i=0;i<totatHintCount;i++){
					userFollowDo=new UserFollowDo();
					UserSummaryDo userSummaryDo=new UserSummaryDo();
				
					JSONObject resultObj = followingList.getJSONObject(i);
					userFollowDo.setGooruUid(resultObj.getString("gooruUid"));
					
					userFollowDo.setUsername(resultObj.getString("username"));
					userFollowDo.setProfileImageUrl(resultObj.getString("profileImageUrl"));
					
					JSONObject summaryObj = followingList.getJSONObject(i).getJSONObject("summary");
					userSummaryDo.setCollection(summaryObj.getInt("collection"));
					userSummaryDo.setFollowing(summaryObj.getInt("following"));
					userSummaryDo.setFollowers(summaryObj.getInt("followers"));
					userFollowDo.setSummary(userSummaryDo);
					
					ArrayList<CustomFieldDo> customFields = JsonDeserializer.deserialize( followingList.getJSONObject(i).getJSONArray("customFields").toString(), new TypeReference<ArrayList<CustomFieldDo>>() {});
					userFollowDo.setCustomFields(customFields);
					

					userFollowDo.setTotalHintCount(totatHintCount);
					userFollowList.add(userFollowDo);
				}
				return userFollowList;	
				} catch (JSONException e) {
				
			}
		}
	
		return userFollowList;
	}

	@Override
	public void followUser(String gooruUid) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_FOLLOW, gooruUid,getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		
		
	}

	@Override
	public void unFollowUser(String gooruUid) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_UNFOLLOW, gooruUid,getLoggedInSessionToken());
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		
			
	}

	@Override
	public IsFollowDo isFollowedUser(String gooruUid) throws GwtException {
		JsonRepresentation jsonRep = null;
		IsFollowDo isFollowDo = new IsFollowDo();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_IS_FOLLOW, gooruUid,getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		
		try{
			if (jsonRep.getText().toString().trim().contains("true")){
				isFollowDo.setIsFollow("true");
			}else{
				isFollowDo.setIsFollow("false");
			}
		}
		catch(Exception ex){}
	
		return isFollowDo;
	}

	@Override
	public List<UserTagsDo> getUserAddedContentTagSummary(String tagGooruOid,String offset, String limit)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_TAG, tagGooruOid,getLoggedInSessionToken(),offset,limit);
		getLogger().info("-- user based tags url -- "+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();	
		return deserializeTagsContent(jsonRep);
		
	}
	
	public List<UserTagsDo> deserializeTagsContent(JsonRepresentation jsonRep) {
		
		List<UserTagsDo> userTagsDoList = null;
		userTagsDoList = new ArrayList<UserTagsDo>();
		if (jsonRep != null && jsonRep.getSize() != -1) {
			UserTagsDo userTagsDo=null;
			try {
				
				JSONObject tagUserObject=jsonRep.getJsonObject();
				int totatHintCount=tagUserObject.getInt("totalHitCount");
				JSONArray tagList=tagUserObject.getJSONArray("searchResults");
				
				for(int i=0;i<totatHintCount;i++){
					userTagsDo=new UserTagsDo();
					JSONObject resultObj = tagList.getJSONObject(i);
					userTagsDo.setLabel(resultObj.getString("label"));
					
					userTagsDo.setCount(resultObj.getString("count"));
					userTagsDo.setTagGooruOid(resultObj.getString("tagGooruOid"));
					userTagsDo.setTotalHitCount(totatHintCount);
					userTagsDoList.add(userTagsDo);
				}
				
				return userTagsDoList;	
				} catch (JSONException e) {
				
			}
		}
		return userTagsDoList;
	}

	@Override
	public List<UserTagsResourceDO> getResourcesByTag(String tagGooruOid,String offset,String limit, String userIdVal)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_TAG_RESOURCE, tagGooruOid,getLoggedInSessionToken(),offset,limit,userIdVal);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();	
		return deserializeResourcesByTag(jsonRep);
	}
	public List<UserTagsResourceDO> deserializeResourcesByTag(JsonRepresentation jsonRep) {
		List<UserTagsResourceDO> userTagResourceList =new ArrayList<UserTagsResourceDO>();
		if (jsonRep != null && jsonRep.getSize() != -1) {
			UserTagsResourceDO userTagsResourceDO=null;
			try {
				
				JSONObject tagUserResourceObject=jsonRep.getJsonObject();
				int totatHintCount=tagUserResourceObject.getInt("totalHitCount");
				
				JSONArray tagUserList=tagUserResourceObject.getJSONArray("searchResult");
				
				for(int i=0;i<totatHintCount;i++){
				
					userTagsResourceDO = new UserTagsResourceDO();
					JSONObject resultObj = tagUserList.getJSONObject(i);
					
					userTagsResourceDO.setTitle(getJsonString(resultObj, "title"));
					userTagsResourceDO.setGooruOid(getJsonString(resultObj, "gooruOid"));
					userTagsResourceDO.setType(getJsonString(resultObj, "type"));
					
					JSONObject resourceFormat = resultObj.getJSONObject("resourceFormat");
					ResourceFormatDo resourceFormatDO =JsonDeserializer.deserialize(resourceFormat.toString(), ResourceFormatDo.class);
					userTagsResourceDO.setResourceFormat(resourceFormatDO);
					
					JSONObject resourceRating = resultObj.getJSONObject("ratings");
					SearchRatingsDo searchRatingsDo =JsonDeserializer.deserialize(resourceRating.toString(), SearchRatingsDo.class);
					userTagsResourceDO.setRatings(searchRatingsDo);
					
					userTagsResourceDO.setThumbnails(getJsonString(resultObj.getJSONObject("thumbnails"), "url"));
					
					try {
						userTagsResourceDO.setPublisher(JsonDeserializer.deserialize(resultObj.getJSONArray("publisher").toString(), new TypeReference<List<String>>() {
						}));
					} catch (JSONException e2) {
						e2.printStackTrace();
					}

					try {
						userTagsResourceDO.setAggregator(JsonDeserializer.deserialize(resultObj.getJSONArray("aggregator").toString(), new TypeReference<List<String>>() {
						}));
					} catch (JSONException e2) {
						e2.printStackTrace();
					}
					
					userTagsResourceDO.setTotalHintCount(totatHintCount);	
					userTagResourceList.add(userTagsResourceDO);
					
				}
			return userTagResourceList;
		} catch (JSONException e) {
			
		}
		}
		return userTagResourceList;
	}
	protected static String getJsonString(JSONObject jsonObject, String key) {
		if (jsonObject != null && !jsonObject.isNull(key) && jsonObject.has(key)) {
			String value = null;
			try {
				value = jsonObject.getString(key);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return value != null ? value : null;
		} else {
			return null;
		}
	}

	@Override
	public String getRefershToken(String gooruUid) throws GwtException ,ServerDownException{
		JsonRepresentation jsonRep = null;
		String url =UrlGenerator.generateUrl(getHomeEndPoint(), UrlToken.REFRESH_TOKEN_GDC,gooruUid);
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();	
		return deserializeRefreshToken(jsonRep);
	}
	
	public String deserializeRefreshToken(JsonRepresentation jsonRep) {
		String refreshToken = null;
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try{
			JSONObject jsonObject=jsonRep.getJsonObject();
			refreshToken = jsonObject.getString("refreshToken");
			}catch(JSONException e){}
				
		}
		return refreshToken;
	}

	@Override
	public String revokeToken(String gooruUid) throws GwtException,ServerDownException {
		JsonRepresentation jsonRep = null;
		String url =UrlGenerator.generateUrl(getHomeEndPoint(), UrlToken.REVOKE_TOKEN_GD,gooruUid);
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeRevokeToken(jsonRep);
	}
	public String deserializeRevokeToken(JsonRepresentation jsonRep) {
		String refreshToken = null;
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try{
			JSONObject jsonObject=jsonRep.getJsonObject();
			refreshToken = jsonObject.getString("refreshToken");
			}catch(JSONException e){}
				
		}
		return refreshToken;
	}

	@Override
	public String isValidResetPasswordLink(String resetToken)
			throws GwtException, ServerDownException {
		// TODO Auto-generated method stub
		JsonRepresentation jsonRep = null;
		String url =UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.RESET_TOKEN_EXPIRE,getLoggedInSessionToken(),resetToken);
		System.out.println("isValidResetPasswordLink:::"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeResetToken(jsonRep);
	}
	
	public String deserializeResetToken(JsonRepresentation jsonRep) {
		String resetToken = null;
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try{
			JSONObject jsonObject=jsonRep.getJsonObject();
			resetToken = jsonObject.getString("isValidToken");
			}catch(JSONException e){}
		}
		return resetToken;																																																																																																																																																																																																								
	}
	@Override
	public UserDashBoardCommonInfoDO getUsersPublishedCollectionsCount() {
		JsonRepresentation jsonRep = null;
		String urlDataParameterValue=createJsonPayloadObject(getLoggedInUserUid(),"1020");
		String url = UrlGenerator.generateUrl(getHomeEndPoint(), UrlToken.V2_USER_PUBLISHEDCOLLECTIONS_COUNT, "1edb25aa-5c5e-4d13-8498-15ef31a93c1f",urlDataParameterValue);
		System.out.println("getUsersPublishedCollectionsCount url::::::"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url,getRestUsername(),getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		UserDashBoardCommonInfoDO userDashBoardCommonInfoDoObj = null;
		if(jsonRep!=null){
			try {
				userDashBoardCommonInfoDoObj=JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDashBoardCommonInfoDO.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return userDashBoardCommonInfoDoObj;
	}
	public String createJsonPayloadObject(String userId,String resourceTypeId){
		JSONObject jsonDataObject=new JSONObject(); 
		try {
			jsonDataObject.put(FIELDS, "publishedCollection");
			jsonDataObject.put(DATASOURCE, "content");
			jsonDataObject.put(GRANULARITY, "");
			jsonDataObject.put(GROUPBY, "creatorUid");
			
			
			JSONArray filterArray = new JSONArray();
			JSONObject filterObject = new JSONObject();
			JSONArray fieldsArray = new JSONArray();
			JSONObject fieldsObjectOne = new JSONObject();
			JSONObject fieldsObjectTwo = new JSONObject();
			JSONObject fieldsObjectThree = new JSONObject();
			JSONObject paginationObject = new JSONObject();
			
			JSONArray agreegationsArray = new JSONArray();
			JSONObject aggregationsObject = new JSONObject();
			
			JSONArray orderArray = new JSONArray();
			
			fieldsObjectOne.put("type","selector");
			fieldsObjectOne.put("valueType","String");
			fieldsObjectOne.put("fieldName","creatorUid");
			fieldsObjectOne.put("operator","eq");
			fieldsObjectOne.put("value",userId);
			
			fieldsObjectTwo.put("type","selector");
			fieldsObjectTwo.put("valueType","String");
			fieldsObjectTwo.put("fieldName","sharing");
			fieldsObjectTwo.put("operator","eq");
			fieldsObjectTwo.put("value","public");
			
			fieldsObjectThree.put("type","selector");
			fieldsObjectThree.put("valueType","Long");
			fieldsObjectThree.put("fieldName","resourceTypeId");
			fieldsObjectThree.put("operator","eq");
			fieldsObjectThree.put("value",resourceTypeId);
			
			fieldsArray.put(fieldsObjectOne);
			fieldsArray.put(fieldsObjectTwo);
			fieldsArray.put(fieldsObjectThree);
			
			
			filterObject.put(LOGICALKey, "AND");
			filterObject.put(FIELDS, fieldsArray);
			filterArray.put(filterObject);
			
			
			aggregationsObject.put("field1", "gooruOid");
			aggregationsObject.put("formula","count");
			aggregationsObject.put("name","publishedCollection");
			aggregationsObject.put("requestValues","field1");
			
			agreegationsArray.put(aggregationsObject);
			
			paginationObject.put("offset",0);
			paginationObject.put("limit",10);
			paginationObject.put("order",orderArray);
			
			
			
			jsonDataObject.put("filter", filterArray);
			jsonDataObject.put("aggregations", agreegationsArray);
			jsonDataObject.put("pagination", paginationObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonDataObject.toString();
	}

	@Override
	public UserDashBoardCommonInfoDO getFiveStarRatedResources() {
		JsonRepresentation jsonrep = null;
		//"1edb25aa-5c5e-4d13-8498-15ef31a93c1f"   sessiontoken hardcoded
		String urlparameters = createJsonRatingsPayloadObject("title,resourceTypeId,category","content","","","AND","selector","String","countOfRating5",
				"ge","1",getLoggedInUserUid(),"eq","creatorUid","DESC");
		String url= UrlGenerator.generateUrl(getHomeEndPoint(), UrlToken.V2_USER_PUBLISHEDCOLLECTIONS_COUNT,getLoggedInSessionToken(), urlparameters);
		System.out.println("getFiveStarRatedResources url:::"+url);
		JsonResponseRepresentation jsonRespRep=ServiceProcessor.post(url,getRestUsername(),getRestPassword());
		jsonrep	=jsonRespRep.getJsonRepresentation();
		UserDashBoardCommonInfoDO userDashBoardCommonInfoDOObject = null;
		if(jsonrep!=null){
			try{
				userDashBoardCommonInfoDOObject	= JsonDeserializer.deserialize(jsonrep.getJsonObject().toString(), UserDashBoardCommonInfoDO.class);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return userDashBoardCommonInfoDOObject;
	}
	
	@Override
	public UserDashBoardCommonInfoDO getFiveStarReviewdResources() {
		// TODO Auto-generated method stub
		JsonRepresentation jsonRep = null;
		String urlparameters = createJsonRatingsPayloadObject("title,resourceTypeId,category","content","","","AND","selector","String","countOfICanExplain",
				"ge","1",getLoggedInUserUid(),"eq","creatorUid","DESC");
		String url = UrlGenerator.generateUrl(getHomeEndPoint(), UrlToken.V2_USER_PUBLISHEDCOLLECTIONS_COUNT, getLoggedInSessionToken(),urlparameters);
		System.out.println("getFiveStarReviewdResources url::::::"+url);
		JsonResponseRepresentation jsonRespRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		jsonRep	= jsonRespRep.getJsonRepresentation();
		UserDashBoardCommonInfoDO userDashBoardCommonInfoDO = null;
		if(jsonRep != null){
			try{
				userDashBoardCommonInfoDO	=	JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDashBoardCommonInfoDO.class);
			}catch(Exception e){
				
			}
			
		}
		return userDashBoardCommonInfoDO;
	}
	
	public String createJsonRatingsPayloadObject(String fields,String content,String granularity,String groupBy,String logicalKey,String selector,String stringval,
			String countofratings,String operatorval,String valueone,String creatoruserId,String eqval,String creatoruid,String desc){
		JSONObject jsondataobject= null;
		try{
		jsondataobject = new JSONObject();
		
		JSONObject filterobject = new JSONObject();
		JSONArray filterArray = new JSONArray();
		JSONArray fieldsArray = new JSONArray();
		JSONObject fieldsobjectone = new JSONObject();
		JSONObject fieldsobjecttwo = new JSONObject();
		JSONArray aggregationsArray = new JSONArray();
		JSONObject paginationobject = new JSONObject();
		JSONArray orderArray = new JSONArray();
		JSONObject orderobject = new JSONObject();
		
		jsondataobject.put(FIELDS, fields);
		jsondataobject.put(DATASOURCE, content);
		jsondataobject.put(GRANULARITY, granularity);
		jsondataobject.put(GROUPBY, groupBy);
		
		filterobject.put(LOGICALKey, logicalKey);
		
		fieldsobjectone.put(TYPE, selector);
		fieldsobjectone.put(VALUETYPE, stringval);
		fieldsobjectone.put(FIELDNAME, countofratings);
		fieldsobjectone.put(OPERATOR, operatorval);
		fieldsobjectone.put(VALUE, valueone);
		
		
		fieldsobjecttwo.put(TYPE, selector);
		fieldsobjecttwo.put(VALUETYPE, stringval);
		fieldsobjecttwo.put(FIELDNAME, creatoruid);
		fieldsobjecttwo.put(OPERATOR, eqval);
		//fieldsobjecttwo.put(VALUE, creatoruserId);
		fieldsobjecttwo.put(VALUE, "ee410cef-2a44-46ef-878d-172511e54e07");
		
		
		fieldsArray.put(fieldsobjectone);
		fieldsArray.put(fieldsobjecttwo);
		
		
		filterobject.put(FIELDS, fieldsArray);
		filterArray.put(filterobject);
		jsondataobject.put(FILTER, filterArray);
		jsondataobject.put(AGGREGATIONS, aggregationsArray);
		
		paginationobject.put(OFFSETVAL, 0);
		paginationobject.put(LIMITVAL, 10);
		
		orderobject.put(SORTBY, countofratings);
		orderobject.put(SORTORDER, desc);
		
		orderArray.put(orderobject);
		paginationobject.put(ORDERKEY, orderArray);
		
		jsondataobject.put(PAGINATION, paginationobject);
		}
 catch (JSONException e) {
			e.printStackTrace();

		}
		
		return jsondataobject.toString();
		
	}


	@Override
	public Map<String, Integer> getTheAnalyticsFlaggedMonthlyData(String fieldVal,String startDate,String endDate,String operator) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getHomeEndPoint(), UrlToken.V2_USER_PUBLISHEDCOLLECTIONS_COUNT,"1edb25aa-5c5e-4d13-8498-15ef31a93c1f",createProfileJsonPayloadObject(fieldVal,startDate,endDate,operator));
		System.out.println("url::"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeMapData(jsonRep,operator);
	}
	public String createProfileJsonPayloadObject(String fieldVal,String startDate,String endDate,String operator){
		JSONObject jsonMainDataObject=new JSONObject(); 
		try {
			jsonMainDataObject.put("fields", "");
			jsonMainDataObject.put("dataSource","rawdata");
			jsonMainDataObject.put("granularity","month");
			
			JSONArray filterArray=new JSONArray();
			JSONObject filterObj=new JSONObject();
			filterObj.put("logicalOperatorPrefix", "AND");
			
			JSONArray filterArrayVales=new JSONArray();
			
			JSONObject firstFilterVal=new JSONObject();
			firstFilterVal.put("type", "selector");
			firstFilterVal.put("valueType", "string");
			firstFilterVal.put("fieldName", "eventName");
			firstFilterVal.put("operator", operator);
			firstFilterVal.put("value", fieldVal);
			filterArrayVales.put(firstFilterVal);
			
			JSONObject secondFilterVal=new JSONObject();
			secondFilterVal.put("type", "selector");
			secondFilterVal.put("valueType", "Date");
			secondFilterVal.put("fieldName", "eventTime");
			secondFilterVal.put("operator", "ge");
			secondFilterVal.put("value", startDate);
			secondFilterVal.put("format", "yyyy-MM-dd");
			filterArrayVales.put(secondFilterVal);
			
			JSONObject thiredFilterVal=new JSONObject();
			thiredFilterVal.put("type", "selector");
			thiredFilterVal.put("valueType", "Date");
			thiredFilterVal.put("fieldName", "eventTime");
			thiredFilterVal.put("operator", "le");
			thiredFilterVal.put("value", endDate);
			thiredFilterVal.put("format", "yyyy-MM-dd");
			filterArrayVales.put(thiredFilterVal);
		
			JSONObject fourthFilterVal=new JSONObject();
			fourthFilterVal.put("type", "selector");
			fourthFilterVal.put("valueType", "String");
			fourthFilterVal.put("fieldName", "gooruUId");
			fourthFilterVal.put("operator", "eq");
			fourthFilterVal.put("value", getLoggedInUserUid());
			filterArrayVales.put(fourthFilterVal);
			
			filterObj.put("fields", filterArrayVales);
			filterArray.put(filterObj);
			jsonMainDataObject.put("filter", filterArray);
			
			JSONArray aggregationsArray=new JSONArray();
			JSONObject aggregationObj=new JSONObject();
			aggregationObj.put("field1", "eventName");
			aggregationObj.put("formula", "count");
			aggregationObj.put("name", "eventCount");
			aggregationObj.put("requestValues", "field1");
			aggregationsArray.put(aggregationObj);
			
			jsonMainDataObject.put("aggregations", aggregationsArray);
			jsonMainDataObject.put("groupBy","eventName,eventTime");
			
			JSONObject paginationObj=new JSONObject();
			paginationObj.put("offset", 0);
			paginationObj.put("limit", 10);
			JSONArray offsetArray=new JSONArray();
			paginationObj.put("order",offsetArray);
			
			jsonMainDataObject.put("pagination",paginationObj);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonMainDataObject.toString();
	}
	public Map<String, Integer> deserializeMapData(JsonRepresentation jsonRep,String operator) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		if (jsonRep != null && jsonRep.getSize() != -1) {
		try{
			JSONArray posts = jsonRep.getJsonObject().getJSONArray("content");
			for(int i=0;i<posts.length();i++){
				JSONObject obj=posts.getJSONObject(i);
				Iterator<String> keys = obj.keys();
				int j=0;
		        while( keys.hasNext() ){
		            String key = (String)keys.next();
		            if( obj.get(key) instanceof JSONArray ){
		            	int size=obj.getJSONArray(key).length();
		            	if(operator.equalsIgnoreCase("in") && size>=2){
		            		result.put(key, obj.getJSONArray(key).getJSONObject(j).getInt("eventCount")+obj.getJSONArray(key).getJSONObject(1).getInt("eventCount"));
		            	}else{
		            		result.put(key, obj.getJSONArray(key).getJSONObject(j).getInt("eventCount"));
		            	}
		            }
		            j++;
		        }
			}
		}catch(JSONException e){
			e.getStackTrace();
		}
	}
		return result;
 }

	@Override
	public ProfileRatingsReactionsDO getProfileAnalyticsRatings() {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getHomeEndPoint(), UrlToken.V2_USER_PUBLISHEDCOLLECTIONS_COUNT,"1edb25aa-5c5e-4d13-8498-15ef31a93c1f",createProfileRatingsJsonPayloadObject());
		//String url = "http://qa.goorulearning.org/insights/api/v2/query?sessionToken=1edb25aa-5c5e-4d13-8498-15ef31a93c1f&data="+createProfileRatingsJsonPayloadObject();
		System.out.println("url::"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		ProfileRatingsReactionsDO profileRatingsReactionsDO = null;
		if(jsonRep!=null){
			try {
				System.out.println(jsonRep.getJsonObject().getJSONArray("content").get(0).toString());;
				profileRatingsReactionsDO=JsonDeserializer.deserialize(jsonRep.getJsonObject().getJSONArray("content").get(0).toString(), ProfileRatingsReactionsDO.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return profileRatingsReactionsDO;
	}
	public String createProfileRatingsJsonPayloadObject(){
		JSONObject jsonMainDataObject=new JSONObject(); 
		try {
			jsonMainDataObject.put("fields",RATNGFIELDS);
			jsonMainDataObject.put("dataSource","user");
			jsonMainDataObject.put("granularity","");
			
			JSONArray filterArray=new JSONArray();
			//First Obj
			JSONObject filterObj=new JSONObject();
			filterObj.put("logicalOperatorPrefix", "AND");
				JSONArray filterArrayVales=new JSONArray();
				Map<String,String> firstFilterMap=new HashMap<String, String>();
				firstFilterMap.put("type","selector");
				firstFilterMap.put("valueType","string");
				firstFilterMap.put("fieldName","gooruUId");
				firstFilterMap.put("operator","eq");
				firstFilterMap.put("value",getLoggedInUserUid());
				JSONObject firstFilterVal=getPayLoadObj(firstFilterMap);
				filterArrayVales.put(firstFilterVal);
				filterObj.put("fields", filterArrayVales);
			filterArray.put(filterObj);
			
			jsonMainDataObject.put("filter", filterArray);
			
			JSONArray aggregationsArray=new JSONArray();
			jsonMainDataObject.put("aggregations", aggregationsArray);
			jsonMainDataObject.put("groupBy","");
			
			JSONObject paginationObj=new JSONObject();
			paginationObj.put("offset", 0);
			paginationObj.put("limit", 10);
			JSONArray offsetArray=new JSONArray();
			paginationObj.put("order",offsetArray);
			
			jsonMainDataObject.put("pagination",paginationObj);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonMainDataObject.toString();
	}
	public JSONObject getPayLoadObj(Map<String,String> payLoad){
		JSONObject objVal=null;
		try{
			objVal=new JSONObject();
			for(Map.Entry<String, String> entry : payLoad.entrySet()) {
				objVal.put(entry.getKey(), entry.getValue());
			}
		}catch(Exception e){	}
		return objVal;
	}

}
