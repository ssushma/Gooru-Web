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

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.service.SearchService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.AutoCompleteDeSerializer;
import org.ednovo.gooru.server.deserializer.AutoSearchKeyWordDeSerializer;
import org.ednovo.gooru.server.deserializer.CollectionItemsResultDeSerializer;
import org.ednovo.gooru.server.deserializer.CollectionSearchResultDeSerializer;
import org.ednovo.gooru.server.deserializer.ResourceSearchResultDeSerializer;
import org.ednovo.gooru.server.deserializer.SearchFilterDeSerialier;
import org.ednovo.gooru.server.deserializer.ShareDeSerializer;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.ShareUrlToken;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo;
import org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.search.SearchFilterDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @fileName : SearchServiceImpl.java
 *
 * @description : This class is used to service search implementation.  
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
@Service("searchService")
@ServiceURL("/searchService")
public class SearchServiceImpl extends BaseServiceImpl implements SearchService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4286188874651640611L;
	
	private static final String RESOURCE = "resource";
	
	private static final String SCOLLECTION = "scollection";
	
	private static final String SINGLE = "single";
	
	private static final String REAL_URL = "realUrl";
	
	private static final String STANDARD = "standard";
	
	private static final String TRUE = "true";
	
	private static final String MY_STRING = "my";
	
	private static final String TYPE = "type";
	
	private static final String SHARETYPE="shareType";

	private static final String CLASSPAGE = "classpage";
	
	private static final String SHORTEN_URL = "shortenUrl";
	
	@Autowired
	private CollectionSearchResultDeSerializer collectionSearchResultDeSerializer;

	@Autowired
	private ResourceSearchResultDeSerializer resourceSearchResultDeSerializer;
	
	@Autowired
	private CollectionItemsResultDeSerializer collectionItemsResultDeSerializer;

	@Autowired
	private AutoCompleteDeSerializer autoCompleteDeSerializer;

	@Autowired
	private SearchFilterDeSerialier searchFilterDeSerialier;

	@Autowired
	private ShareDeSerializer shareDeSerializer;
	
	@Autowired
	private AutoSearchKeyWordDeSerializer autoSearchKeyWordDeSerializer;
	
	String  query;
	String collectionQuery;
	@Override
	public SearchFilterDo getSearchFilters(String type) {
		if (type.equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)) {
			type = RESOURCE;
		} else {
			type = SCOLLECTION;
		}
		String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.SEARCH_FILTER, getLoggedInSessionToken(), type);
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		return searchFilterDeSerialier.deserializeSearchFilter(jsonRep, type);
	}
	/**
	 * @description : This method is used for getting Search resource results.
	 */
	@Override
	public SearchDo<ResourceSearchResultDo> getResourceSearchResults(SearchDo<ResourceSearchResultDo> searchDo) {
		SearchDo<ResourceSearchResultDo> searchDOEmpty = new SearchDo<ResourceSearchResultDo>();
		String query1=searchDo.getSearchQuery();
		 query= query1;
		try{
			if(searchDo.getFilters()!=null){
				for (String key : searchDo.getFilters().keySet()) {
				  String value = searchDo.getFilters().get(key);
				  value = value.replaceAll("&", "%26");
				  searchDo.getFilters().put(key, value);
				 }
			}
		String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.RESOURCE_SEARCH, searchDo.getFilters(), getLoggedInSessionToken(), query, searchDo.getPageNum() + "", searchDo.getPageSize() + "", SINGLE, "false", TRUE, TRUE);
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		try{
			resourceSearchResultDeSerializer.deserialize(jsonRep, searchDo);	
		}
		catch(Exception e)
		{
			
		}
		return searchDo;
		}catch(Exception e){
		}
		return searchDOEmpty;
	}
	/**
	 *@description : This method is used for getting Search Collection results.
	 */

	@Override
	public SearchDo<CollectionSearchResultDo> getCollectionSearchResults(SearchDo<CollectionSearchResultDo> searchDo) {
		SearchDo<CollectionSearchResultDo> searchDOEmpty = new SearchDo<CollectionSearchResultDo>();
		String query1=searchDo.getSearchQuery();
		collectionQuery= query1 ;
		try{
			if(searchDo.getFilters()!=null){
			for (String key : searchDo.getFilters().keySet()) {
				  String value = searchDo.getFilters().get(key);
				  value=value.replaceAll("&", "%26");
				  searchDo.getFilters().put(key, value);
			}
		 }

		String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.SIMPLE_COLLECTION_SEARCH, searchDo.getFilters(), getLoggedInSessionToken(), collectionQuery, searchDo.getPageNum() + "", searchDo.getPageSize() + "", MY_STRING);
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		collectionSearchResultDeSerializer.deserialize(jsonRep, searchDo);
		return searchDo;
		}catch(Exception e){
		}
		return searchDOEmpty;
	}

	/*@Override
	public SearchDo<ResourceSearchResultDo> getCollectionResources(SearchDo<ResourceSearchResultDo> searchDo) {
		String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.COLLECTION_RESOURCE_LIST, getLoggedInSessionToken(), searchDo.getPageNum() + "", searchDo.getPageSize() + "", searchDo.getSearchQuery());
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		resourceSearchResultDeSerializer.deserialize(jsonRep, searchDo);
		return searchDo;
	}*/
	/**
	 * @description : This method is used for getting collection items.
	 */
	@Override
	public SearchDo<CollectionItemSearchResultDo> getCollectionItems(String collectionId) throws GwtException {
		SearchDo<CollectionItemSearchResultDo> searchDo=new SearchDo<CollectionItemSearchResultDo>();
		String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.COLLECTION_ITEMS_LIST, collectionId,getLoggedInSessionToken());
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		collectionItemsResultDeSerializer.deserializeCollectionItems(jsonRep, searchDo);
		return searchDo;
	}
	/**
	 * @description : This method is used for getting Collection of resources.
	 */

	@Override
	public SearchDo<CollectionSearchResultDo> getResourceCollections(SearchDo<CollectionSearchResultDo> searchDo) {
		String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.RESOURCE_COLLECTION_LIST, getLoggedInSessionToken(), searchDo.getPageNum() + "", searchDo.getPageSize() + "", searchDo.getSearchQuery());
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		collectionSearchResultDeSerializer.deserialize(jsonRep, searchDo);
		return searchDo;
	}

	/*@Override
	public SearchDo<String> getSuggestSearchQuery(SearchDo<String> searchDo) {
		String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.SEARCH_SUGGEST_QUERY, getLoggedInSessionToken(), searchDo.getSearchQuery(), searchDo.getPageSize() + "", searchDo.getPageNum() + "");
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		searchDo.setSearchResults(autoCompleteDeSerializer.deserializeSearchQuery(jsonRep));
		return searchDo;
	}*/
/**
 * @description : This method is used for getting Suggest Source .
 */
	@Override
	public SearchDo<String> getSuggestSource(SearchDo<String> searchDo) {
		String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.SEARCH_SUGGEST_SOURCE, getLoggedInSessionToken(), URLEncoder.encode(searchDo.getSearchQuery()), searchDo.getPageSize() + "", searchDo.getPageNum() + "");
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		searchDo.setSearchResults(autoCompleteDeSerializer.deserializeSource(jsonRep));
		return searchDo;
	}
	/**
	 * @description : This method is used to get Suggest Standard.
	 */

	@Override
	public SearchDo<CodeDo> getSuggestStandard(SearchDo<CodeDo> searchDo) {
		String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.SEARCH_SUGGEST_STANDARD, searchDo.getType() != null ? searchDo.getType() : STANDARD , getLoggedInSessionToken(), searchDo.getSearchQuery(), searchDo.getPageSize() + "", searchDo.getPageNum() + "");
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		searchDo.setSearchResults(autoCompleteDeSerializer.deserializeStandards(jsonRep));
		return searchDo;
	}
/**
 * @description : This method is used to get url for Shorten share .
 * 
 */
	@Override
	public Map<String, String> getShortenShareUrl(String contentGooruOid, Map<String, String> params) {
		Map<String, String> shortenUrl = new HashMap<String, String>();
			if (params.get(TYPE).equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)) {	
				if (params.get(SHARETYPE).equalsIgnoreCase("embed")){
					params.put(REAL_URL, UrlGenerator.generateUrl(getHomeEndPoint() +"/"+ ShareUrlToken.RESOURCE_PLAY_URL.getUrl()+"%26embed=true", contentGooruOid, RESOURCE));
				}else{
					params.put(REAL_URL, UrlGenerator.generateUrl(getHomeEndPoint() +"/"+ ShareUrlToken.RESOURCE_PLAY_URL.getUrl()+"%26share=true", contentGooruOid, RESOURCE));
				}
			}else if(params.get(TYPE).equalsIgnoreCase(PlaceTokens.EDIT_CLASSPAGE)) 
				params.put(REAL_URL, UrlGenerator.generateUrl(getHomeEndPoint()+"/" + ShareUrlToken.CLASSPAGE.getUrl(), contentGooruOid, CLASSPAGE));
			else {
				if (params.get(SHARETYPE).equalsIgnoreCase("embed")){
					//params.put(REAL_URL, UrlGenerator.generateUrl(getHomeEndPoint()+"/" + ShareUrlToken.COLLECTION_PLAY_URL.getUrl()+"%26embed=true", contentGooruOid));
					params.put(REAL_URL, UrlGenerator.generateUrl(getHomeEndPoint()+"/" + ShareUrlToken.COLLECTION_PLAY_EMBEDED_URL.getUrl(), contentGooruOid));
				
				}else{
					params.put(REAL_URL, UrlGenerator.generateUrl(getHomeEndPoint() +"/" + ShareUrlToken.COLLECTION_PLAY_URL.getUrl()+"%26share=true", contentGooruOid));
					}
			}
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.SHARE_SHORTEN_URL, params, contentGooruOid, getLoggedInSessionToken());
		
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		try{
		shortenUrl = shareDeSerializer.deserializeShortenUrl(jsonRep);
		}
		catch(Exception e)
		{
			
		}
		
		if(getHttpRequest().getScheme().equalsIgnoreCase(MessageProperties.HTTPS)) {
			shortenUrl.put(SHORTEN_URL, shortenUrl.get(SHORTEN_URL).replaceAll(MessageProperties.HTTP, MessageProperties.HTTPS));
		}
		return shortenUrl;
	}
/**
 * @description : This method is used for getting Google sign in .
 */
	@Override
	public String getGoogleSignin(String parms) {
		
		parms = parms.replaceAll("#", "%23");
		parms = parms.replaceAll("!", "%21");
		parms = parms.replaceAll("&", "%26");
				
		String gSigninUrl = getGoogleSignin() + "&domain=gmail.com&callback=" + parms;
		return gSigninUrl;
	}
	
	/**
	 * @description : This method is used for getting Google sign in .
	 */
	@Override
	public String getGoogleSignin(String placeToken, Map<String, String> parms) {
		
		String callback = StringUtil.generateMessage(getHomeEndPoint() + "#" +placeToken, parms);
		
		callback = callback.replaceAll("#", "%23");
		callback = callback.replaceAll("!", "%21");
		callback = callback.replaceAll("&", "%26");
		
		String gSigninUrl = getGoogleSignin() + "&domain=gmail.com&callback=" + callback;
		return gSigninUrl;
	}
	/**
	 * @description : This method is used for getting Collection play direct link .
	 */
	@Override
	public String getCollectionPlayDirectLink(String params){
		String directLink="";
		directLink = getHomeEndPoint() + params;
		return directLink;
	}
/**
 * @description : This method is used for getting Home end point .
 */
	@Override
	public String getHomeEndPointUrl(){
		return  getHomeEndPoint();
	}
	/**
	 * @description : This method is used for getting Suggest Search Result For Resource No Result
	 */
@Override
public SearchDo<ResourceSearchResultDo> getSuggestSearchResultForResourceNoResult(SearchDo<ResourceSearchResultDo> searchDo){
		SearchDo<ResourceSearchResultDo> searchDOEmpty = new SearchDo<ResourceSearchResultDo>();
		try{
		String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.SEARCH_SUGGEST_NO_RESULT, searchDo.getFilters(), getLoggedInSessionToken(), query);
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		resourceSearchResultDeSerializer.deserialize(jsonRep, searchDo);
		return searchDo;
		}catch(Exception e){
		}
		return searchDOEmpty;
	}
/**
 * @description : This method is used for getting Suggested auto Key word.
 */
@Override
public SearchDo<AutoSuggestKeywordSearchDo> getSuggestedAutokeyword(
		SearchDo<AutoSuggestKeywordSearchDo> searchDo) throws GwtException {
	String pageSize="5";
	String pageNumber="1";
	String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.SEARCH_AUTO_SUGGEST_KEYWORD, getLoggedInSessionToken(),searchDo.getSearchQuery(),pageSize,searchDo.getType(),pageNumber);
	
	JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
	searchDo.setSearchResults(autoSearchKeyWordDeSerializer.deserializeAutoKeyword(jsonRep));
	return searchDo;

}

/*@Override
public SearchDo<CollectionSearchResultDo> getSuggestedSearchResultForCollectionNoResult(
		SearchDo<CollectionSearchResultDo> searchDo) throws GwtException {
	SearchDo<CollectionSearchResultDo> searchDOEmpty = new SearchDo<CollectionSearchResultDo>();
	try{
	String url = UrlGenerator.generateUrl(getSearchEndPoint(), UrlToken.SEARCH_SUGGEST_COLLECTION_NO_RESULT, searchDo.getFilters(), getLoggedInSessionToken(), collectionQuery);
	JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
	collectionSearchResultDeSerializer.deserialize(jsonRep, searchDo);
	return searchDo;
	}catch(Exception e){
	}
	return searchDOEmpty;
}*/
	
}
