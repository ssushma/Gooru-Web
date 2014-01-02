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

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.service.UserService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.ResourceDeserializer;
import org.ednovo.gooru.server.form.ResourceFormFactory;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.user.BiographyDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.model.user.ProfilePageDo;
import org.ednovo.gooru.shared.model.user.ProfileV2Do;
import org.ednovo.gooru.shared.model.user.SettingDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.model.user.V2UserDo;
import org.json.JSONException;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @fileName : UserServiceImpl.java
 *
 * @description : This Class is used for User Service implementation 
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
@Service("userService")
@ServiceURL("/userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	ResourceDeserializer resourceDeserializer;

	private static final long serialVersionUID = -7268580337769405632L;
	
	private static final String BY_EMAIL_ID = "byEmailid";
	
	private static final String GOORU_CLASSIC_URL = "gooruClassicUrl";
	
	private static final String REGISTRATION_TYPE = "registrationType";
	
	private static final String CHILD = "Child";
	private static final String OPTIONALVALUE="optionalValue";
	private static final String PARTY_CUSTOM_FIELD = "partyCustomField";
	private static final String PROFILE = "profile";
	
	private static final String USER_META_ACTIVE_FLAG = "&userMetaActiveFlag=1";
	/**
	 * This method is used to get email id.
	 */
	@Override
	public UserDo getEmailId(String emailId) {
		return getEmailId(emailId, BY_EMAIL_ID);
	}
	/**
	 * This method is used to get email id.
	 */
	@Override
	public UserDo getEmailId(String emailId, String type) {
		UserDo userDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_AVAILABILITY, type, emailId, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		try {
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userDo;
	}
	/**
	 * This method is used to get register user.
	 */
	@Override
	public void registerUser(Map<String, String> params) {
		params.put(GOORU_CLASSIC_URL, URLEncoder.encode(getHomeEndPoint() + "#" + PlaceTokens.HOME));
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.REGISTER_USER, params, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		try {
			JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
	}
/**
 * 
 * @function getRegistredUserDetails 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to Get Registration User Details. 
 * 
 * 
 * @parm(s) : @param gooruUid
 * @parm(s) : @return
 * 
 * @return : UserDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public UserDo getRegistredUserDetails(String gooruUid) {
		UserDo userDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_REGISTERED_USER_DETAILS, gooruUid, getLoggedInSessionToken());
		JsonRepresentation jsonRep = null;
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		try {
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userDo;
	}

	/**
	 * 
	 * @function getUserProfileDetails 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Get User profiles Details.
	 * 
	 * 
	 * @parm(s) : @param gooruUid
	 * @parm(s) : @return
	 * 
	 * @return : SettingDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@Override
	public SettingDo getUserProfileDetails(String gooruUid) {
		SettingDo settingeDo = null;
		String userUid = getLoggedInUserUid();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_PROFILE_DETAILS, userUid, getLoggedInSessionToken());
		JsonRepresentation jsonRep = null;
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		
		try {
			settingeDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), SettingDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return settingeDo;
	}
/**
 * 
 * @function updateUserDetails 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description : This method is used to Update user details.
 * 
 * 
 * @parm(s) : @param gooruUid
 * @parm(s) : @param token
 * @parm(s) : @param params
 * @parm(s) : @return
 * 
 * @return : ProfileDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public ProfileDo updateUserDetails(String gooruUid, String token, Map<String, String> params) {
		ProfileDo profileDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_REGISTER_USER, gooruUid, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), generateFormFromParamters(params));
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
/**
 * 
 * @function resendConfirmationMail 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to Re send confirmation mail.
 * 
 * 
 * @parm(s) : @param params
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public void resendConfirmationMail(Map<String, String> params) {
		params.put(GOORU_CLASSIC_URL, URLEncoder.encode(getHomeEndPoint()));
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.SEND_CONFIRMATION_MAIL, params, getLoggedInSessionToken());
		ServiceProcessor.post(url, getRestUsername(), getRestPassword());
	}

	/*@Override
	public UserDo getUser(String userUid) {
		return getUserInfo(userUid);
	}*/
/**
 * 
 * @function forgotPassword 
 * 
 * @created_date : 02-Jan-2014
 * 
 *@description : This method is used for the purpose of Forgot Password.
 * 
 * 
 * @parm(s) : @param emailId
 * @parm(s) : @return
 * 
 * @return : Map<String,Object>
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public Map<String, Object> forgotPassword(String emailId) {
		JsonRepresentation jsonRep = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put(GOORU_CLASSIC_URL, URLEncoder.encode(getHomeEndPoint() + "#" + PlaceTokens.HOME));
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.FORGOT_PASSWORD, params, getLoggedInSessionToken(), emailId);
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		return resourceDeserializer.forgotPassword(jsonRep);
	}
/**
 * 
 * @function resetCredential 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description : This method is used to Reset Credentials.
 * 
 * 
 * @parm(s) : @param password
 * @parm(s) : @param token
 * @parm(s) : @return
 * 
 * @return : Map<String,Object>
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public Map<String, Object> resetCredential(String password, String token) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.RESET_CREDENTIAL, getLoggedInSessionToken(), password, token);
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		return resourceDeserializer.resetPassword(jsonRep);
	}
/**
 * 
 * @function updateUserViewFlag 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to UpdaTE user view Flag .
 * 
 * 
 * @parm(s) : @param gooruUid
 * @parm(s) : @param viewFlag
 * @parm(s) : @return
 * @parm(s) : @throws GwtException
 * 
 * @return : UserDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public UserDo updateUserViewFlag(String gooruUid, Integer viewFlag) throws GwtException {
		UserDo userDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_VIEW, gooruUid,getLoggedInSessionToken(), String.valueOf(viewFlag));
		JsonRepresentation jsonRep = null;
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		try {
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userDo;
	}
	/**
	 * 
	 * @function updateProfileSettings 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Update profile settings.
	 * 
	 * 
	 * @parm(s) : @param gooruUid
	 * @parm(s) : @param params
	 * @parm(s) : @return
	 * @parm(s) : @throws GwtException
	 * 
	 * @return : SettingDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */

	@Override
	public SettingDo updateProfileSettings(String gooruUid,	 Map<String, String> params) throws GwtException {
		SettingDo settingDo = null;
		String userUid = getLoggedInUserUid();
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_PROFILE_DETAILS, userUid, getLoggedInSessionToken());
		
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), generateFormFromParamters(params));
		String text="";
		try {
			text = jsonRep.getText();
			settingDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), SettingDo.class);
		} catch (Exception e) {
			throw new GwtException(text != null ? text : e.getMessage());
		}
		return settingDo;
	}

	/**
	 * 
	 * @function deserializeProfilePage 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Deserialize profile page.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : ProfilePageDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
	
	/**
	 * 
	 * @function updateUserProfileVisibility 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Update user profile visibility
	 * 
	 * 
	 * @parm(s) : @param gooruUid
	 * @parm(s) : @param optionalValue
	 * @parm(s) : @return
	 * @parm(s) : @throws GwtException
	 * 
	 * @return : ProfilePageDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
		
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		//return deserializeProfilePage(jsonRep);
		return profilePageDo;
		
	}
/** 
 * 
 * @function getUserProfilePage 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to Get User Profile.
 * 
 * 
 * @parm(s) : @param gooruUid
 * @parm(s) : @return
 * @parm(s) : @throws GwtException
 * 
 * @return : ProfilePageDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public ProfilePageDo getUserProfilePage(String gooruUid) throws GwtException {
		ProfilePageDo profilePageDo = null;
		String userUid = getLoggedInUserUid();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_PROFILE_PAGE, userUid, getLoggedInSessionToken());
		JsonRepresentation jsonRep = null;
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		try {
			profilePageDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfilePageDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return profilePageDo;
	}
/**
 * 
 * @function getUserPublicProfilePage 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to Get User Public Profile Page.
 * 
 * 
 * @parm(s) : @param gooruUid
 * @parm(s) : @return
 * @parm(s) : @throws GwtException
 * 
 * @return : ProfilePageDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public ProfilePageDo getUserPublicProfilePage(String gooruUid) throws GwtException {
		ProfilePageDo profilePageDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_PROFILE_PAGE, gooruUid, getLoggedInSessionToken());
		JsonRepresentation jsonRep = null;
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		try {
			profilePageDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfilePageDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return profilePageDo;
	}
	/**
	 * 
	 * @function updateProfileBiography 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to  Update profile Biography
	 * 
	 * 
	 * @parm(s) : @param gooruUid
	 * @parm(s) : @param biography
	 * @parm(s) : @param role
	 * @parm(s) : @param firstName
	 * @parm(s) : @param lastName
	 * @parm(s) : @param gender
	 * @parm(s) : @return
	 * @parm(s) : @throws GwtException
	 * 
	 * @return : BiographyDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		return biographyDo;
	}
/**
 * 
 * @function getUserProfileV2Details 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to Get User profiles details.
 * 
 * 
 * @parm(s) : @param gooruUid
 * @parm(s) : @param userMetaActiveFlag
 * @parm(s) : @return
 * @parm(s) : @throws GwtException
 * 
 * @return : ProfileDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */

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
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		
		try {
			profileDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfileDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return profileDo;
	}
/**
 * 
 * @function createUser 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description : This method is used to Create User
 * 
 * 
 * @parm(s) : @param postData
 * @parm(s) : @return
 * @parm(s) : @throws GwtException
 * 
 * @return : UserDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public UserDo createUser(String postData) throws GwtException {
		UserDo userDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_CREATE_USER, getLoggedInSessionToken());
		JsonRepresentation jsonRep = null;
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(),postData);
		
		try {
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return userDo;
	}
/**
 * 
 * @function updateNewEmailStatus 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description : This method is used to update new emai status .
 * 
 * 
 * @parm(s) : @param emailId
 * @parm(s) : @param isEmailConfirmation
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public void updateNewEmailStatus(String emailId, boolean isEmailConfirmation) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
		String formData = "";
		formData = "{\"profile\": {\"user\": {\"emailId\":\""+emailId+"\"}},\"emailConfirmStatus\":"+isEmailConfirmation+"}";
		JsonRepresentation jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
	}
/**
 * 
 * @function updateV2ProfileDo 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to update v2 profile.
 * 
 * 
 * @parm(s) : @param EmailId
 * @parm(s) : @param accountType
 * @parm(s) : @param firstName
 * @parm(s) : @param lastName
 * @parm(s) : @param biography
 * @parm(s) : @param password
 * @parm(s) : @return
 * 
 * @return : V2UserDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public V2UserDo updateV2ProfileDo(String EmailId,String accountType,String firstName,String lastName,String biography,String password) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_UPDATE_USER_PROFILE, getLoggedInUserUid(), getLoggedInSessionToken());
		V2UserDo userv2Do = new V2UserDo();
		ProfileV2Do profileV2Do = new ProfileV2Do();
		UserDo user = new UserDo();
		
		if(!firstName.equalsIgnoreCase("")){
			user.setFirstName(firstName);
		}
		if(!lastName.equalsIgnoreCase("")){
			user.setLastName(lastName);
		}
		if(!EmailId.equalsIgnoreCase("")){
			user.setEmailId(EmailId);
		}
		user.setAccountTypeId(3);
		profileV2Do.setUser(user);
		if(!biography.equalsIgnoreCase("")){
			profileV2Do.setAboutMe(biography);
		}
		userv2Do.setProfile(profileV2Do);
		userv2Do.setAccountType(accountType);
		if(!password.equalsIgnoreCase("")){
			userv2Do.setPassword(password);
		}
		userv2Do.setEmailConfirmStatus("true");
		user.setConfirmStatus(0);
	
		String formData = ResourceFormFactory.generateStringDataForm(userv2Do,null);
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
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
	
	


}
