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
package org.ednovo.gooru.server.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ednovo.gooru.server.AppSessionHolder;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.model.featured.CollectionFilterProperties;
import org.ednovo.gooru.shared.model.user.FilterSettings;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.model.user.V2UserDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.ResourceImageUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gwt.user.client.rpc.RemoteService;
/**
 * @fileName : BaseServiceImpl.java
 *
 * @description : This is implementation of the RemoteService.
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class BaseServiceImpl extends GwtAbstractServiceImpl implements RemoteService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7437954157376886661L;

	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

	@Resource(name = "restConstants")
	private Properties restConstants;
	
	@Resource(name = "collectionConstants")
	private Properties collectionConstants;

	public static final String GOORU_ANONYMOUS = "ANONYMOUS";

	private static final String REST_ENDPOINT = "rest.endpoint";

	private static final String SEARCH_ENDPOINT = "search.endpoint";

	private static final String REST_USERNAME = "rest.username";

	private static final String REST_PASSWORD = "rest.password";

	private static final String SEARCH_USERNAME = "search.username";

	private static final String SEARCH_PASSWORD = "search.password";

	private static final String API_KEY = "api.key";

	private static final String HOME_ENDPOINT = "home.endpoint";

	private static final String DOMAIN_NAME = "domain.name";

	private static final String DOCVIEWER_CACHE = "docViewer.cache";

	private static final String GOOGLE_ANALTICS_ADDITIONAL_ACCOUNTS = "google.analtics.additional.accounts";

	private static final String CLASSIC_ENDPOINT = "classic.endpoint";

	private static final String GOORU_SESSION_TOKEN = "gooru-session-token";
	
	private static final String GOORU_ACTIVE_USER = "gooru-active-user";

	private static final String SIGNED_USER_UID = "signed-user-uid";

	private static final String SIGNED_USER_EMAILID = "signed-user-emailid";

	private static final String COOKIE_PATH = "/";

	private static final String TOKEN = "token";

	private static final String USER_INFO_FAILED_ON_TOKEN = "Get User info failed on token : ";

	public static final int COOKIE_AGE = 1209600;
	
	private static final String PRODUCTION_SWITCH = "production.switch";
	
	private static final String GOOGLE_SIGNIN = "google.signin";
	
	private static final String PROFILE_IMAGE_RESPOSITORY_URL="profile.image.url";
	
	private static final String COLLECTION_MATH_WEEK1="collection.math.week1";
	
	private static final String COLLECTION_SCIENCE_WEEK1="collection.science.week1";
	
	private static final String COLLECTION_SOCIAL_WEEK1="collection.social.week1";
	
	private static final String COLLECTION_LANGUAGE_WEEK1="collection.language.week1";
	
	private static final String COLLECTION_MATH_WEEK2="collection.math.week2";
	
	private static final String COLLECTION_SCIENCE_WEEK2="collection.science.week2";
	
	private static final String COLLECTION_SOCIAL_WEEK2="collection.social.week2";
	
	private static final String COLLECTION_LANGUAGE_WEEK2="collection.language.week2";
	
	private static final String COLLECTION_MATH_WEEK3="collection.math.week3";
	
	private static final String COLLECTION_SCIENCE_WEEK3="collection.science.week3";
	
	private static final String COLLECTION_SOCIAL_WEEK3="collection.social.week3";
	
	private static final String COLLECTION_LANGUAGE_WEEK3="collection.language.week3";
	
	private static final String COLLECTION_MATH_WEEK4="collection.math.week4";
	
	private static final String COLLECTION_SCIENCE_WEEK4="collection.science.week4";
	
	private static final String COLLECTION_SOCIAL_WEEK4="collection.social.week4";
	
	private static final String COLLECTION_LANGUAGE_WEEK4="collection.language.week4";
	
	private static final String COLLECTION_MATH_WEEK5="collection.math.week5";
	
	private static final String COLLECTION_SCIENCE_WEEK5="collection.science.week5";
	
	private static final String COLLECTION_SOCIAL_WEEK5="collection.social.week5";
	
	private static final String COLLECTION_LANGUAGE_WEEK5="collection.language.week5";
	
	private static final String CLASSROOM_USE_CASES = "classroom.use.cases";
	
	private static final String CLASSROOM_HOW_TO_USE = "classroom.how.to.use";
	
	private static final String COLLECTION_SWITCH_DATE = "collection.switch.date";
	
	private static final String CDN_ENDPOINT = "cdn.endpoint";
	
	private static final String DATA_LOG_API_KEY = "log.api.key";
	
	private static final String WHATS_NEW_MOS_LINK = "whats.new.mos.link";
	
	private static final String WHATS_NEW_FIB_LINK = "whats.new.fib.link";
	
	private static final String MOS_LINK = "mos.link";

	private static final String GOORU_RELEASE_VERSION = "gooru.release.version";
	
	private final String qaCollectionIds = "na,e587591b-93fd-44b9-b89e-22570d87c991,na,88de3985-65eb-4123-bbae-0470b12ba50d,e56d7bd5-96f5-446d-9701-1a5ff2655909";
	/**
	 * class constructor.
	 */
	public BaseServiceImpl() {

	}

	@Override
	protected void onBeforeRequestDeserialized(String serializedRequest) {
		super.onBeforeRequestDeserialized(serializedRequest);
		AppSessionHolder.getInstance().setRequest(getThreadLocalRequest());
		AppSessionHolder.getInstance().setResponse(getThreadLocalResponse());
	}
	/**
	 * @function getLogger 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the logger object.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : Logger
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static Logger getLogger() {
		return logger;
	}
	/**
	 * @function getProductionSwitchDate 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the production switch date.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getProductionSwitchDate(){
		return restConstants.getProperty(PRODUCTION_SWITCH);
	}
	/**
	 * @function getDataApiKey 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : this will return the data api key.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getDataApiKey(){
		return restConstants.getProperty(DATA_LOG_API_KEY);
	}
	/**
	 * @function getGoogleSignin 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the google signin.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getGoogleSignin(){
		return restConstants.getProperty(GOOGLE_SIGNIN);
	}
	
	public String getWhatsNewMosLink(){
		return restConstants.getProperty(WHATS_NEW_MOS_LINK);
	}
	/**
	 * @function getWhatsNewFibLink 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the FIB link.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getWhatsNewFibLink(){
		return restConstants.getProperty(WHATS_NEW_FIB_LINK);
	}
	/**
	 * @function getMosLink 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the MOS link.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getMosLink(){
		return restConstants.getProperty(MOS_LINK);
	}
	/**
	 * @function getRestEndPoint 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the rest end point.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getRestEndPoint() {
		String restEndPoint = restConstants.getProperty(REST_ENDPOINT);
		if(getHttpRequest().getScheme().equalsIgnoreCase(MessageProperties.HTTPS)) {
			restEndPoint = restEndPoint.replaceAll(MessageProperties.HTTP, MessageProperties.HTTPS);
		}
		return restEndPoint;
	}
	/**
	 * @function getSearchEndPoint 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will return the search rest end point.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getSearchEndPoint() {
		String searchEndPoint = restConstants.getProperty(SEARCH_ENDPOINT);
		if(getHttpRequest().getScheme().equalsIgnoreCase(MessageProperties.HTTPS)) {
			searchEndPoint = searchEndPoint.replaceAll(MessageProperties.HTTP, MessageProperties.HTTPS);
		}
		return searchEndPoint;
	}
	/**
	 * @function getRestUsername 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the rest username.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getRestUsername() {
		return restConstants.getProperty(REST_USERNAME);
	}
	/**
	 * @function getRestPassword 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the rest password.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getRestPassword() {
		return restConstants.getProperty(REST_PASSWORD);
	}
	/**
	 * @function getSearchUsername 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the search user name.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getSearchUsername() {
		return restConstants.getProperty(SEARCH_USERNAME);
	}
	/**
	 * @function getSearchPassword 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the search password.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getSearchPassword() {
		return restConstants.getProperty(SEARCH_PASSWORD);
	}
	/**
	 * @function getApiKey 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the API key.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getApiKey() {
		return restConstants.getProperty(API_KEY);
	}
	/**
	 * @function getHomeEndPoint 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the home rest end point.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getHomeEndPoint() {
		String homeEndPoint = restConstants.getProperty(HOME_ENDPOINT);
		if(getHttpRequest().getScheme().equalsIgnoreCase(MessageProperties.HTTPS)) {
			homeEndPoint = homeEndPoint.replaceAll(MessageProperties.HTTP, MessageProperties.HTTPS);
			ResourceImageUtil.protocol=MessageProperties.HTTPS;
		}
		return homeEndPoint;
	}
	/**
	 * @function getHomeEndPointForEmbed 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the home rest end point for embed.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getHomeEndPointForEmbed() {
		return restConstants.getProperty(HOME_ENDPOINT);
	}
	/**
	 * @function getRestEndPointForEmbed 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will return the rest end point for embed.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getRestEndPointForEmbed() {
		return restConstants.getProperty(REST_ENDPOINT);
	}
	/**
	 * @function getDocViewerPoint 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the doc viewer end point.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getDocViewerPoint() {
		return restConstants.getProperty(DOCVIEWER_CACHE);
	}
	/**
	 * @function getProfileImageUrl 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will return the user profile image url.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getProfileImageUrl() {
		String profileImageUrl = restConstants.getProperty(PROFILE_IMAGE_RESPOSITORY_URL);
		if(getHttpRequest().getScheme().equalsIgnoreCase(MessageProperties.HTTPS)) {
			profileImageUrl = profileImageUrl.replaceAll(MessageProperties.HTTP, MessageProperties.HTTPS);
		}
		return profileImageUrl;
	}
	/**
	 * This is used to get the collections math week1.
	 */
	public String getCollectionMathWeek1() {
		return collectionConstants.getProperty(COLLECTION_MATH_WEEK1);
	}
	/**
	 * This is used to get the collections science week1.
	 */
	public String getCollectionScienceWeek1() {
		return collectionConstants.getProperty(COLLECTION_SCIENCE_WEEK1);
	}
	/**
	 * This is used to get the collections social week1.
	 */
	public String getCollectionSocialWeek1() {
		return collectionConstants.getProperty(COLLECTION_SOCIAL_WEEK1);
	}
	/**
	 * This is used to get the collections english and language week1.
	 */
	public String getCollectionLanguageWeek1() {
		return collectionConstants.getProperty(COLLECTION_LANGUAGE_WEEK1);
	}
	/**
	 * This is used to get the collections math week2.
	 */
	public String getCollectionMathWeek2() {
		return collectionConstants.getProperty(COLLECTION_MATH_WEEK2);
	}
	/**
	 * This is used to get the collections science week2.
	 */
	public String getCollectionScienceWeek2() {
		return collectionConstants.getProperty(COLLECTION_SCIENCE_WEEK2);
	}
	/**
	 * This is used to get the collections social week2.
	 */
	public String getCollectionSocialWeek2() {
		return collectionConstants.getProperty(COLLECTION_SOCIAL_WEEK2);
	}
	/**
	 * This is used to get the collections english week1.
	 */
	public String getCollectionLanguageWeek2() {
		return collectionConstants.getProperty(COLLECTION_LANGUAGE_WEEK2);
	}
	/**
	 * This is used to get the collections math week3.
	 */
	public String getCollectionMathWeek3() {
		return collectionConstants.getProperty(COLLECTION_MATH_WEEK3);
	}
	/**
	 * This is used to get the collections science week3.
	 */
	public String getCollectionScienceWeek3() {
		return collectionConstants.getProperty(COLLECTION_SCIENCE_WEEK3);
	}
	/**
	 * This is used to get the collections social week3.
	 */
	public String getCollectionSocialWeek3() {
		return collectionConstants.getProperty(COLLECTION_SOCIAL_WEEK3);
	}
	/**
	 * This is used to get the collections english week3.
	 */
	public String getCollectionLanguageWeek3() {
		return collectionConstants.getProperty(COLLECTION_LANGUAGE_WEEK3);
	}
	/**
	 * This is used to get the collections math week4.
	 */
	public String getCollectionMathWeek4() {
		return collectionConstants.getProperty(COLLECTION_MATH_WEEK4);
	}
	
	public String getCollectionScienceWeek4() {
		return collectionConstants.getProperty(COLLECTION_SCIENCE_WEEK4);
	}

	public String getCollectionSocialWeek4() {
		return collectionConstants.getProperty(COLLECTION_SOCIAL_WEEK4);
	}

	public String getCollectionLanguageWeek4() {
		return collectionConstants.getProperty(COLLECTION_LANGUAGE_WEEK4);
	}

	public String getCollectionMathWeek5() {
		return collectionConstants.getProperty(COLLECTION_MATH_WEEK5);
	}
	
	public String getCollectionScienceWeek5() {
		return collectionConstants.getProperty(COLLECTION_SCIENCE_WEEK5);
	}

	public String getCollectionSocialWeek5() {
		return collectionConstants.getProperty(COLLECTION_SOCIAL_WEEK5);
	}

	public String getCollectionLanguageWeek5() {
		return collectionConstants.getProperty(COLLECTION_LANGUAGE_WEEK5);
	}
	/**
	 * This is used to get the class room use cases.
	 */
	public String getClassRoomUseCases() {
		return collectionConstants.getProperty(CLASSROOM_USE_CASES);
	}
	/**
	 * This is used to get the class room how to use.
	 */
	public String getClassRoomHowToUse() {
		return collectionConstants.getProperty(CLASSROOM_HOW_TO_USE);
	}
	/**
	 * This is used to get the collections switched date.
	 */
	public String getCollectionSwitchDate() {
		return collectionConstants.getProperty(COLLECTION_SWITCH_DATE);
	}
	/**
	 * @function getCdnEndPoint 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the cdn rest end point.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getCdnEndPoint() {
		String cdnEndPoint = restConstants.getProperty(CDN_ENDPOINT);
		if(getHttpRequest().getScheme().equalsIgnoreCase(MessageProperties.HTTPS)) {
			cdnEndPoint = cdnEndPoint.replaceAll(MessageProperties.HTTP, MessageProperties.HTTPS);
		}
		return cdnEndPoint;
	}
	/**
	 * @function stringtoInteger 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to convert the string to integer.
	 * 
	 * @parm(s) : @param jsonObject
	 * @parm(s) : @param key
	 * @parm(s) : @return
	 * 
	 * @return : Integer
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected static Integer stringtoInteger(JSONObject jsonObject, String key) {	
		if (jsonObject != null && jsonObject.has(key)) {
			String value = null;
			try {
				value = jsonObject.getString(key);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return value != null ? Integer.parseInt(value) : null;
		} else {
			return null;
		}
	}
	/**
	 * @function generateFormFromParamters 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to generate the form parameters.
	 * 
	 * 
	 * @parm(s) : @param params
	 * @parm(s) : @return
	 * 
	 * @return : Form
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected static Form generateFormFromParamters(Map<String, String> params) {
		Form form = new Form();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			form.add(entry.getKey(), entry.getValue());
		}
		return form;
	}
	/**
	 * @function setUserFilterProperties 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to set the user filter properties.
	 * 
	 * @parm(s) : @param user
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected void setUserFilterProperties(UserDo user) {
		FilterSettings filterProperties = new FilterSettings();
		filterProperties.setRestEndPoint(getRestEndPoint());
		filterProperties.setHomeEndPoint(getHomeEndPoint());
		filterProperties.setDomainName(getDomainName());
		filterProperties.setClassicEndPoint(getClassicEndPoint());
		filterProperties.setDocViewerPoint(getDocViewerPoint());
		filterProperties.setApiKeyPoint(getApiKey());
		filterProperties.setGoogleAnalticsAdditionalAccounts(getGoogleAnalticsAdditionalAccounts());
		filterProperties.setGoogleSignin(getGoogleSignin());
		filterProperties.setProfileImageUrl(getProfileImageUrl());
		filterProperties.setCdnEndPoint(getCdnEndPoint());
		filterProperties.setDataApiKey(getDataApiKey());
		filterProperties.setGooruReleaseVersion(getGooruReleaseVersion());
		user.setSettings(filterProperties);
	}
	/**
	 * @function setCollectionFilterProperties 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to set the collection filter properties.
	 * 
	 * 
	 * @parm(s) : @param user
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected void setCollectionFilterProperties(UserDo user) {
		CollectionFilterProperties collectionFilterProperties = new CollectionFilterProperties();
		
		Calendar todayCalendar = Calendar.getInstance();
		Calendar futureCalendar = Calendar.getInstance();
		
		int TODAY_DATE = todayCalendar.get(Calendar.DAY_OF_YEAR);
		
		String[] collectionSwitchDate = getCollectionSwitchDate().split("/");
		int CURRENT_YEAR = Integer.parseInt(collectionSwitchDate[0]);
		int CURRENT_MONTH = Integer.parseInt(collectionSwitchDate[1]);
		int CURRENT_DAY = Integer.parseInt(collectionSwitchDate[2]);
		
		futureCalendar.set(CURRENT_YEAR,CURRENT_MONTH-1,CURRENT_DAY);
		int DAY_OF_YEAR=futureCalendar.get(Calendar.DAY_OF_YEAR);
		if(getRestEndPoint().contains("www")||getRestEndPoint().contains("www2")) {
			if(TODAY_DATE >= DAY_OF_YEAR && TODAY_DATE <= DAY_OF_YEAR+6) {
				collectionFilterProperties.setMathCollection(getCollectionMathWeek1());
				collectionFilterProperties.setScienceCollection(getCollectionScienceWeek1());
				collectionFilterProperties.setSocialCollection(getCollectionSocialWeek1());
				collectionFilterProperties.setLanguageCollection(getCollectionLanguageWeek1());
			} else if (TODAY_DATE >= DAY_OF_YEAR+7 && TODAY_DATE <= DAY_OF_YEAR+13) {
				collectionFilterProperties.setMathCollection(getCollectionMathWeek2());
				collectionFilterProperties.setScienceCollection(getCollectionScienceWeek2());
				collectionFilterProperties.setSocialCollection(getCollectionSocialWeek2());
				collectionFilterProperties.setLanguageCollection(getCollectionLanguageWeek2());
			} else if (TODAY_DATE >= DAY_OF_YEAR+14 && TODAY_DATE <= DAY_OF_YEAR+20) {
				collectionFilterProperties.setMathCollection(getCollectionMathWeek3());
				collectionFilterProperties.setScienceCollection(getCollectionScienceWeek3());
				collectionFilterProperties.setSocialCollection(getCollectionSocialWeek3());
				collectionFilterProperties.setLanguageCollection(getCollectionLanguageWeek3());
			} else if (TODAY_DATE >= DAY_OF_YEAR+21 && TODAY_DATE <= DAY_OF_YEAR+27) {
				collectionFilterProperties.setMathCollection(getCollectionMathWeek4());
				collectionFilterProperties.setScienceCollection(getCollectionScienceWeek4());
				collectionFilterProperties.setSocialCollection(getCollectionSocialWeek4());
				collectionFilterProperties.setLanguageCollection(getCollectionLanguageWeek4());
			} else if (TODAY_DATE >= DAY_OF_YEAR+28 && TODAY_DATE <= DAY_OF_YEAR+34) {
				collectionFilterProperties.setMathCollection(getCollectionMathWeek5());
				collectionFilterProperties.setScienceCollection(getCollectionScienceWeek5());
				collectionFilterProperties.setSocialCollection(getCollectionSocialWeek5());
				collectionFilterProperties.setLanguageCollection(getCollectionLanguageWeek5());
			} else {
				collectionFilterProperties.setMathCollection(getCollectionMathWeek1());
				collectionFilterProperties.setScienceCollection(getCollectionScienceWeek1());
				collectionFilterProperties.setSocialCollection(getCollectionSocialWeek1());
				collectionFilterProperties.setLanguageCollection(getCollectionLanguageWeek1());
			}
			
			collectionFilterProperties.setClassroomUseCases(getClassRoomUseCases());
			collectionFilterProperties.setClassroomHowToUse(getClassRoomHowToUse());
			user.setCollectionFilterProperties(collectionFilterProperties);			
		} else {
			collectionFilterProperties.setMathCollection(qaCollectionIds);
			collectionFilterProperties.setScienceCollection(qaCollectionIds);
			collectionFilterProperties.setSocialCollection(qaCollectionIds);
			collectionFilterProperties.setLanguageCollection(qaCollectionIds);
			collectionFilterProperties.setClassroomUseCases(qaCollectionIds);
			collectionFilterProperties.setClassroomHowToUse(getClassRoomHowToUse());
			user.setCollectionFilterProperties(collectionFilterProperties);
		}
	}
	/**
	 * This is used to get the domain name.
	 */
	public String getDomainName() {
		return restConstants.getProperty(DOMAIN_NAME);
	}
	/**
	 * This is used to get the classic end point.
	 */
	public String getClassicEndPoint() {
		return restConstants.getProperty(CLASSIC_ENDPOINT);
	}
	/**
	 * This is used to get the google analtics additional accounts.
	 */
	public String getGoogleAnalticsAdditionalAccounts() {
		return restConstants.getProperty(GOOGLE_ANALTICS_ADDITIONAL_ACCOUNTS);
	}
	/**
	 * This is used to get the Gooru release version.
	 */
	public String getGooruReleaseVersion() {
		return restConstants.getProperty(GOORU_RELEASE_VERSION);
	}
	/**
	 * @function getLoggedInSessionToken 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the logged user session token.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected String getLoggedInSessionToken() {
		String token = getCookie(GOORU_SESSION_TOKEN);
		if (token == null) {
			token = (String) getHttpRequest().getSession().getAttribute(GOORU_SESSION_TOKEN);
			//Fix for handling when cookie get disabled.
			if (token == null || token.equalsIgnoreCase("null")) { 
//				UserDo user = guestSignIn();
				UserDo user = v2GuestSignIn();
				token = (user != null) ? user.getToken() : token;
				getHttpRequest().getSession().setAttribute(GOORU_SESSION_TOKEN, token);
			}
			setLoggedInSessionToken(token);
		}
		return token;
	}
	/**
	 * @function getCookie 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the cookies.
	 * 
	 * 
	 * @parm(s) : @param name
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private String getCookie(String name) {
		Cookie[] cookies = getHttpRequest().getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	/**
	 * @function getGuestSessionToken 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get guest session token.
	 * 
	 * 
	 * @parm(s) : @param restEndPointFromEmbed
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected String getGuestSessionToken(String restEndPointFromEmbed){
		UserDo user = v2GuestSignInForEmbed(restEndPointFromEmbed);
		String token = (user != null) ? user.getToken() : "";
		return token;
	}
	/**
	 * @function setLoggedInSessionToken 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the logged user session token.
	 * 
	 * 
	 * @parm(s) : @param sessionToken
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected void setLoggedInSessionToken(String sessionToken) {
		Cookie cookie = new Cookie(GOORU_SESSION_TOKEN, sessionToken);
		cookie.setDomain(AppSessionHolder.getInstance().getRequest().getServerName());
		cookie.setPath(COOKIE_PATH);
		if (sessionToken != null && sessionToken.length() > 0) {
			cookie.setMaxAge(COOKIE_AGE);
		} else {
			cookie.setMaxAge(0);
		}
		getHttpResponse().addCookie(cookie);
		if (sessionToken != null) {
			getHttpRequest().getSession().setAttribute(GOORU_SESSION_TOKEN, sessionToken);
		} else {
			getHttpRequest().getSession().removeAttribute(GOORU_SESSION_TOKEN);
		}
	}
	/**
	 * @function setUserActiveStatus 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to set the user active status.
	 * 
	 * 
	 * @parm(s) : @param userStatus
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected void setUserActiveStatus(String userStatus){
		Cookie cookie = new Cookie(GOORU_ACTIVE_USER, userStatus);
		cookie.setDomain(AppSessionHolder.getInstance().getRequest().getServerName());
		cookie.setPath(COOKIE_PATH);
		cookie.setMaxAge(COOKIE_AGE);
		getHttpResponse().addCookie(cookie);
	}
	/**
	 * @function setUserInActiveStatus 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to set the user inactive status.
	 * 
	 * 
	 * @parm(s) : @param userStatus
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected void setUserInActiveStatus(String userStatus){
		Cookie cookie = new Cookie(GOORU_ACTIVE_USER, userStatus);
		cookie.setDomain(AppSessionHolder.getInstance().getRequest().getServerName());
		cookie.setPath(COOKIE_PATH);
		cookie.setMaxAge(COOKIE_AGE);
		getHttpResponse().addCookie(cookie);
	}
	/**
	 * @function setLoggedInInfo 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to set the logged info.
	 * 
	 * 
	 * @parm(s) : @param sessionToken
	 * @parm(s) : @param loggedInUserUid
	 * @parm(s) : @param loggedInEmailId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected void setLoggedInInfo(String sessionToken, String loggedInUserUid, String loggedInEmailId) {
		setLoggedInSessionToken(sessionToken);
		setLoggedInUserUid(loggedInUserUid);
		setLoggedInEmailId(loggedInEmailId);
		setUserActiveStatus("active");
	}
	/**
	 * @function deleteLoggedInInfo 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to delete the logged info.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected void deleteLoggedInInfo() {
		Cookie[] cookies = getHttpRequest().getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(GOORU_SESSION_TOKEN)) {
					cookie.setMaxAge(0);
					cookie.setPath(COOKIE_PATH);
					getHttpResponse().addCookie(cookie);
				}
				else if(cookie.getName().equals(GOORU_ACTIVE_USER)){
					setUserInActiveStatus("in-active");
				}
			}
		}
		getHttpRequest().getSession().removeAttribute(GOORU_SESSION_TOKEN);
		setLoggedInUserUid(null);
	}
	/**
	 * @function getLoggedInUserUid 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to get the logged in user Uid.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected String getLoggedInUserUid() {
		String sessionSessionToken = (String) getHttpRequest().getSession().getAttribute(GOORU_SESSION_TOKEN);
		String cookieSessionToken = getCookie(GOORU_SESSION_TOKEN);
		String loggedInUserUid = (String) getHttpRequest().getSession().getAttribute(SIGNED_USER_UID);

		boolean sessionTimedOutUser = sessionSessionToken == null && cookieSessionToken != null;
		boolean switchedUser = sessionSessionToken != null && cookieSessionToken != null && !cookieSessionToken.equals(sessionSessionToken);
		boolean inUser = sessionSessionToken != null && cookieSessionToken != null && cookieSessionToken.equals(sessionSessionToken);

		UserDo user = null;

		if (sessionTimedOutUser || switchedUser) {
//			user = getUserInfoByToken(cookieSessionToken);
			user = v2GetUserInfoByToken(cookieSessionToken);
		} else if (!inUser) {
			user = v2GuestSignIn();
		}
		if (user != null) {
			deleteLoggedInInfo();
			loggedInUserUid = user.getGooruUId();
			setLoggedInInfo(cookieSessionToken == null ? user.getToken() : cookieSessionToken, user.getGooruUId(),getLoggedInEmailId());
		}
		return loggedInUserUid;
	}
	/**
	 * @function setLoggedInUserUid 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to set the logged user Uid.
	 * 
	 * 
	 * @parm(s) : @param loggedInUserUid
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected void setLoggedInUserUid(String loggedInUserUid) {
		if (loggedInUserUid != null) {
			getHttpRequest().getSession().setAttribute(SIGNED_USER_UID, loggedInUserUid);
		} else {
			getHttpRequest().getSession().removeAttribute(SIGNED_USER_UID);
		}
	}
	/**
	 * @function getLoggedInEmailId 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the logged user email id.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected String getLoggedInEmailId() {
		String loggedInEmailId = (String) getHttpRequest().getSession().getAttribute(SIGNED_USER_EMAILID);
		return loggedInEmailId;
	}
	/**
	 * @function setLoggedInEmailId 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will set the logged user email id.
	 * 
	 * 
	 * @parm(s) : @param loggedInEmailId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected void setLoggedInEmailId(String loggedInEmailId) {
		if (loggedInEmailId != null) {
			getHttpRequest().getSession().setAttribute(SIGNED_USER_EMAILID, loggedInEmailId);
		} else {
			getHttpRequest().getSession().removeAttribute(SIGNED_USER_EMAILID);
		}
	}
	/**
	 * @function isLoggedInUserAnonymous 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method will check whether the user logged in or not.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected boolean isLoggedInUserAnonymous() {
		return getLoggedInUserUid() == null || getLoggedInUserUid().equals(GOORU_ANONYMOUS);
	}
	/**
	 * @function guestSignIn 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used for guest sign in.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : UserDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected UserDo guestSignIn() {
		UserDo user = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GUEST_SIGNIN, getApiKey());
		JsonRepresentation jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		try {
			setLoggedInSessionToken(jsonRep.getJsonObject().getString(TOKEN));
			user = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
			setLoggedInUserUid(user.getGooruUId());
			setLoggedInEmailId("");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * @function guestSignInForEmbed 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used for guest sign in for embed.
	 * 
	 * 
	 * @parm(s) : @param restEndPointFromEmbed
	 * @parm(s) : @return
	 * 
	 * @return : UserDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected UserDo guestSignInForEmbed(String restEndPointFromEmbed){
		UserDo user = null;
		String url = UrlGenerator.generateUrl(restEndPointFromEmbed, UrlToken.GUEST_SIGNIN, getApiKey());
		JsonRepresentation jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		try {
			user = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * @function getUserInfo 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the user info.
	 * 
	 * 
	 * @parm(s) : @param userUid
	 * @parm(s) : @return
	 * 
	 * @return : UserDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected UserDo getUserInfo(String userUid) {
		UserDo userDo = null;
		String sessionToken = getLoggedInSessionToken();
		if (sessionToken != null) {
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER, userUid, sessionToken);
			JsonRepresentation jsonRep = null;
			jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
			try {
				String data = jsonRep.getJsonObject().getJSONObject("data").getJSONObject("user").toString();
				userDo = JsonDeserializer.deserialize(data, UserDo.class);
//				if (userDo.getCreatedOn()!=null){
					Date prodDate = new SimpleDateFormat("dd/MM/yyyy").parse(getProductionSwitchDate());				
					Date userCreatedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(userDo.getCreatedOn());
					// if user created after production switch
					if (userCreatedDate.getTime() >= prodDate.getTime()){
						userDo.setBeforeProductionSwitch(false);
					}else{
						userDo.setBeforeProductionSwitch(true);
					}
//				}
			} catch (JSONException e) {
				e.printStackTrace();
			} 
			catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return userDo;
	}
	/**
	 * @function getUserInfoByToken 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the user info by token.
	 * 
	 * 
	 * @parm(s) : @param token
	 * @parm(s) : @return
	 * 
	 * @return : UserDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected UserDo getUserInfoByToken(String token) {
		UserDo userDo = null;
		try {
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USERBYTOKEN, getLoggedInSessionToken());
			JsonRepresentation jsonRep = null;
			jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
			String data = jsonRep.getJsonObject().toString();
			userDo = JsonDeserializer.deserialize(data, UserDo.class);
//			if (userDo.getCreatedOn()!=null){
				Date prodDate = new SimpleDateFormat("dd/MM/yyyy").parse(getProductionSwitchDate());				
				Date userCreatedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(userDo.getCreatedOn());
				// if user created after production switch
				if (userCreatedDate.getTime() >= prodDate.getTime()){
					userDo.setBeforeProductionSwitch(false);
				}else{
					userDo.setBeforeProductionSwitch(true);
				}
//			}
		} catch (Exception e) {
			getLogger().error(USER_INFO_FAILED_ON_TOKEN + token);
		}
		return userDo;
	}
	/**
	 * @function getHttpRequest 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the http request.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : HttpServletRequest
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected HttpServletRequest getHttpRequest() {
		return AppSessionHolder.getInstance().getRequest();
	}
	/**
	 * @function getHttpResponse 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the http response.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : HttpServletResponse
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected HttpServletResponse getHttpResponse() {
		return AppSessionHolder.getInstance().getResponse();
	}
	/**
	 * @function v2GuestSignIn 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the guest user sign in.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : UserDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected UserDo v2GuestSignIn() {
		UserDo user = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GUEST_SIGNIN, getApiKey());
		JsonRepresentation jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		try {
			setLoggedInSessionToken(jsonRep.getJsonObject().getString(TOKEN));
			V2UserDo v2UserDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), V2UserDo.class);
			user = v2UserDo.getUser();
			user.setToken(v2UserDo.getToken());
			setLoggedInUserUid(user.getGooruUId());
			setLoggedInEmailId("");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * @function v2GuestSignInForEmbed 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the guest user.
	 * 
	 * 
	 * @parm(s) : @param restEndPointFromEmbed
	 * @parm(s) : @return
	 * 
	 * @return : UserDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected UserDo v2GuestSignInForEmbed(String restEndPointFromEmbed){
		UserDo user = null;
		String url = UrlGenerator.generateUrl(restEndPointFromEmbed, UrlToken.V2_GUEST_SIGNIN, getApiKey());
		JsonRepresentation jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		try {
			V2UserDo v2UserDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), V2UserDo.class);
			user = v2UserDo.getUser();
			user.setToken(v2UserDo.getToken());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return user;
	}	
	/**
	 * @function v2GetUserInfoByToken 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the user info by token.
	 * 
	 * 
	 * @parm(s) : @param token
	 * @parm(s) : @return
	 * 
	 * @return : UserDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	protected UserDo v2GetUserInfoByToken(String token) {
		UserDo userDo = null;
		try {
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_USER_BY_SESSIONTOKEN, getLoggedInSessionToken(), getLoggedInSessionToken());
			JsonRepresentation jsonRep = null;
			jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
			String data = jsonRep.getJsonObject().toString();
			userDo = JsonDeserializer.deserialize(data, UserDo.class);
//			if (userDo.getCreatedOn()!=null){
				Date prodDate = new SimpleDateFormat("dd/MM/yyyy").parse(getProductionSwitchDate());				
				Date userCreatedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(userDo.getCreatedOn());
				// if user created after production switch
				if (userCreatedDate.getTime() >= prodDate.getTime()){
					userDo.setBeforeProductionSwitch(false);
				}else{
					userDo.setBeforeProductionSwitch(true);
				}
//			}
		} catch (Exception e) {
			getLogger().error(USER_INFO_FAILED_ON_TOKEN + token);
		}
		return userDo;
	}
}
