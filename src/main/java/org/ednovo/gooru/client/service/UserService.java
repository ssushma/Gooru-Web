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
/**
 * 
 */
package org.ednovo.gooru.client.service;

import java.util.List;
import java.util.Map;

import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.user.BiographyDo;
import org.ednovo.gooru.shared.model.user.IsFollowDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.model.user.ProfilePageDo;
import org.ednovo.gooru.shared.model.user.SettingDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.model.user.UserFollowDo;
import org.ednovo.gooru.shared.model.user.UserTagsDo;
import org.ednovo.gooru.shared.model.user.UserTagsResourceDO;
import org.ednovo.gooru.shared.model.user.V2UserDo;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author Search Team
 * 
 */
@RemoteServiceRelativePath("gwt-service/userService")
public interface UserService extends BaseService {

	/**
	 * Get user details by userId 
	 * @param userUid of user
	 * @return serialized {@link UserDo}
	 * @throws GwtException
	 */
//	UserDo getUser(String userUid) throws GwtException;

	/**
	 * Get user details by emailId
	 * @param email of the user
	 * @return serialized {@link UserDo}
	 * @throws GwtException
	 */
	UserDo getEmailId(String email) throws GwtException;

	/**
	 * Get user details by userName or emailId
	 * @param email of the user
	 * @param type userName or emailId
	 * @return serialized {@link UserDo}
	 * @throws GwtException
	 */
	UserDo getEmailId(String email, String type) throws GwtException;

	/**
	 * Get register user details
	 * @param params has user details 
	 * @throws GwtException
	 */
	void registerUser(Map<String, String> params) throws GwtException;

	/**
	 * Get register user details by userId
	 * @param gooruUid of user
	 * @return serialized {@link UserDo}
	 * @throws GwtException
	 */
	UserDo getRegistredUserDetails(String gooruUid) throws GwtException;

	/**
	 * Get user profile details after update
	 * @param gooruUid of the user
	 * @param token session token to set for loogedIn user
	 * @param params has user details
	 * @return serialized {@link ProfileDo}
	 * @throws GwtException
	 */
	ProfileDo updateUserDetails(String gooruUid, String token, Map<String, String> params) throws GwtException;

	/**
	 * Send confirmation mail to user to update their profile
	 * @param params has details of the user
	 * @throws GwtException
	 */
	void resendConfirmationMail(Map<String, String> params) throws GwtException;

	/**
	 * Send forget possword link to user registered mail id
	 * @param emailId of the user
	 * @return user details and userId
	 * @throws GwtException 
	 */
	Map<String, Object> forgotPassword(String emailId) throws GwtException;

	/**
	 * Reset the user password  
	 * @param password to be updated
	 * @param token reset token
	 * @return user  credential
	 * @throws GwtException
	 */
	Map<String, Object> resetCredential(String password, String token) throws GwtException;
	
	/**
	 * Update user view flag when user logIn in first time
	 * @param gooruUid of the user
	 * @param viewFlag is 0 not yet signIn , 1 signedIn 
	 * @return serialized {@link UserDo}
	 * @throws GwtException
	 */
	UserDo updateUserViewFlag(String gooruUid, Integer viewFlag) throws GwtException;

	/**
	 * Get User profile details for settings page
	 * @return serialized {@link SettingDo}
	 * @throws GwtException
	 */
	SettingDo getUserProfileDetails(String gooruUid) throws GwtException;
	
	/**
	 * Get User profile details for settings page
	 * @return serialized {@link SettingDo}
	 * @throws GwtException
	 */
	V2UserDo getV2UserProfileDetails(String gooruUid) throws GwtException;

	/**
	 * Update user profile details
	 * @param gooruUid of the user
	 * @param token session token to set for loogedIn user
	 * @param params has user details
	 * @return serialized {@link ProfileDo}
	 * @throws GwtException
	 */
	SettingDo updateProfileSettings(String gooruUid, Map<String, String> params) throws GwtException;
	/**
	 * Update user profile visibilty
	 * @param gooruUid of the user
	 * @param optionalValue of the userVisibilty
	 * @param token session token to set for loogedIn user
	 * @param params has user details
	 * @return serialized {@link ProfileDo}
	 * @throws GwtException
	 */
	
	ProfilePageDo updateUserProfileVisibility(String gooruUid,String optionalValue )throws GwtException;
	
	/**
	 * Get User profile details for settings page
	 * @return serialized {@link ProfileDo}
	 * @throws GwtException
	 */
	ProfileDo getUserProfileV2Details(String gooruUid, String userMetaActiveFlag) throws GwtException;
	
	ProfilePageDo getUserProfilePage(String gooruUid) throws GwtException;
	
	BiographyDo updateProfileBiography(String gooruUid,String biography,String role,String firstName,String lastName,String gender)throws GwtException;

	ProfilePageDo getUserPublicProfilePage(String gooruUid) throws GwtException;
	
	//ProfilePageDo updateProfileBiography(String gooruUid,String biography )throws GwtException;
	/**
	 * 
	 * @function createUser 
	 * 
	 * @created_date : Sep 27, 2013
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param postData
	 * @parm(s) : @return
	 * @parm(s) : @throws GwtException
	 * 
	 * @return : V2UserDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	UserDo createUser(String postData) throws GwtException;
	
	void updateNewEmailStatus(String emailId, boolean isEmailConfirmed) throws GwtException;
	
	V2UserDo updateV2ProfileDo(String EmailId,String accountType,String firstName,String lastName,String biography,String password, String userName, String gender, boolean isSendConfirmEmail);
	
	void sendWelcomeMail(String gooruUId, String emailType) throws GwtException;
	
	void updatePartyCustomField(String gooruUid,String optionKey,String optionValue) throws GwtException;
	
	//followingUser
	List<UserFollowDo> getFollowedOnUsers(String gooruUid,String offset, String limit)throws GwtException;
	
	//followerUser
	List<UserFollowDo> getFollowedByUsers(String gooruUid,String offset, String limit)throws GwtException;
	
	void followUser(String gooruUid)throws GwtException;
	
	void unFollowUser(String gooruUid)throws GwtException;
	
	IsFollowDo isFollowedUser(String gooruUid)throws GwtException;
	
	List<UserTagsDo> getUserAddedContentTagSummary(String tagGooruOid,String offset,String limit)throws GwtException;
	
	List<UserTagsResourceDO> getResourcesByTag(String tagGooruOid,String offset,String limit)throws GwtException;
}
