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
package org.ednovo.gooru.server.deserializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.model.content.LicenseDo;
import org.ednovo.gooru.shared.model.content.SearchResourceFormatDO;
import org.ednovo.gooru.shared.model.content.ResourceSourceDo;
import org.ednovo.gooru.shared.model.content.ResourceTypeDo;
import org.ednovo.gooru.shared.model.content.TagDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.ResourceImageUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @author Search Team
 * 
 */
@Component
public class ResourceSearchResultDeSerializer extends SearchDeSerializer<ResourceSearchResultDo> {

	private static final String VIDEO_YOUTUBE = "video/youtube";
	
	private static final String THUMBNAILS = "thumbnails";
	
	private static final String URL = "url";
	
	private static final String ASSESSMENT_QUESTION = "assessment-question";
	
	private static final String TAG_SET = "tagSet";
	
	@Override
	public ResourceSearchResultDo deserializeRecord(JSONObject recordJsonObject) {
		ResourceSearchResultDo resourceSearchResultDo = new ResourceSearchResultDo();
		try {
			JSONObject resourceType = recordJsonObject.getJSONObject(RESOURCE_TYPE);
			resourceSearchResultDo.setResourceType(JsonDeserializer.deserialize(resourceType.toString(), ResourceTypeDo.class));
			resourceSearchResultDo.setResourceTypeString((String) resourceType.get(RESOURCE_TYPE_NAME));
			
			JSONObject resourceSourceJson = recordJsonObject.getJSONObject(RESOURCE_SOURCE);
			ResourceSourceDo resourceSourceDo=JsonDeserializer.deserialize(resourceSourceJson.toString(), ResourceSourceDo.class);
			resourceSearchResultDo.setResourceSource(resourceSourceDo);
			
			JSONObject resourceFormat = recordJsonObject.getJSONObject(RESOURCE_FORMAT);
			SearchResourceFormatDO resourceFormatDO =JsonDeserializer.deserialize(resourceFormat.toString(), SearchResourceFormatDO.class);
			resourceSearchResultDo.setResourceFormat(resourceFormatDO);
			
		} catch (JSONException e1) {
			
		}
		
		try {
			if (resourceSearchResultDo.getResourceTypeString() != null && resourceSearchResultDo.getResourceTypeString().equalsIgnoreCase(VIDEO_YOUTUBE)) {
				resourceSearchResultDo.setUrl(ResourceImageUtil.youtubeImageLink(ResourceImageUtil.getYoutubeVideoId(getJsonString(recordJsonObject, URL))));
			} else { 			
				resourceSearchResultDo.setUrl(getJsonString(recordJsonObject.getJSONObject(THUMBNAILS), URL));
			}
		} catch (JSONException e) {
			
		}
		resourceSearchResultDo.setResourceTitle(getJsonString(recordJsonObject, RESOURCE_TITLE));
		resourceSearchResultDo.setDescription(getJsonString(recordJsonObject, RESOURCE_DESCRIPTION));
		
		resourceSearchResultDo.setScollectionCount(getJsonInteger(recordJsonObject, COLLECTIONCOUNT));
		
		if(resourceSearchResultDo.getResourceType().getName().equals(ASSESSMENT_QUESTION)){
			resourceSearchResultDo.setDurationInSec(getJsonString(recordJsonObject, TIME_TO_COMPLETE_IN_SEC));
			resourceSearchResultDo.setQuestionType(getJsonString(recordJsonObject, QUESTION_TYPE_NAME));
			
		}else{
			resourceSearchResultDo.setDurationInSec(getJsonString(recordJsonObject, DURATION_IN_SEC));
		}
		
		resourceSearchResultDo.setVotesUp(stringtoInteger(recordJsonObject, VOTES_UP, 0));
		resourceSearchResultDo.setVotesDown(stringtoInteger(recordJsonObject, VOTES_DOWN, 0));
		resourceSearchResultDo.setGooruOid(getJsonString(recordJsonObject, GOORU_OID));
		resourceSearchResultDo.setCategory(getJsonString(recordJsonObject, CATEGORY));
		resourceSearchResultDo.setTotalViews(stringtoInteger(recordJsonObject, TOTALVIEWS, 0));
		resourceSearchResultDo.setNumOfPages(getJsonString(recordJsonObject, NO_OF_PAGES));
		
		resourceSearchResultDo.setAssetURI(getJsonString(recordJsonObject, ASSETURI));
		resourceSearchResultDo.setMediaType(getJsonString(recordJsonObject, MEDIA_TYPE));

		UserDo ownerDo = new UserDo();
		ownerDo.setFirstName(getJsonString(recordJsonObject, OWNER_FIRST_NAME));
		ownerDo.setLastName(getJsonString(recordJsonObject, OWNER_LAST_NAME));
		ownerDo.setUsername(getJsonString(recordJsonObject, OWNER_NAME_DISPLAY));
		resourceSearchResultDo.setOwner(ownerDo);

		try {
			if (getJsonString(recordJsonObject, TAXONOMY_DATA_SET) != null) {
				JSONObject taxonomyDataSet = new JSONObject(getJsonString(recordJsonObject, TAXONOMY_DATA_SET));
				JSONObject curriculum = taxonomyDataSet.getJSONObject(CURRICULUM);
				JSONArray standardCodes = (JSONArray) curriculum.get(CURRICULUM_CODE);
				JSONArray standardDescriptions = (JSONArray) curriculum.get(CURRICULUM_DESCRIPTION);
				List<Map<String, String>> standards = new ArrayList<Map<String, String>>();
				for (int i = 0; i < standardCodes.length(); i++) {
					Map<String, String> standard = new HashMap<String, String>();
					standard.put(STANDARD_CODE, (String) standardCodes.get(i));
					if (standardDescriptions.get(i) != null) {
						standard.put(STANDARD_DESCRIPTION, (String) standardDescriptions.get(i));
					}
					standards.add(standard);
				}
				resourceSearchResultDo.setStandards(standards);
				resourceSearchResultDo.setSubjectNames(convertJSONArrayToList(((JSONArray) taxonomyDataSet.get(TAXONOMY_SUBJECT))));
				resourceSearchResultDo.setCourseNames(convertJSONArrayToList((JSONArray) taxonomyDataSet.get(TAXONOMY_COURSE)));
				resourceSearchResultDo.setUnitNames(convertJSONArrayToList((JSONArray) taxonomyDataSet.get(TAXONOMY_UNIT)));
				resourceSearchResultDo.setTopicNames(convertJSONArrayToList((JSONArray) taxonomyDataSet.get(TAXONOMY_TOPIC)));
				resourceSearchResultDo.setLessonNames(convertJSONArrayToList((JSONArray) taxonomyDataSet.get(TAXONOMY_LESSON)));
			}
		} catch (JSONException e) {
			
		}
		resourceSearchResultDo.setAverageTime(getJsonString(recordJsonObject, AVERAGE_TIME));
		resourceSearchResultDo.setSharedCount(stringtoInteger(recordJsonObject, SHARED_COUNT, 0));
		resourceSearchResultDo.setGrade(getJsonString(recordJsonObject, GRADE));
		resourceSearchResultDo.setTags(getJsonString(recordJsonObject, TAGS));
		try {
			JSONObject license = recordJsonObject.getJSONObject(LICENSE);
			LicenseDo licenseDo=JsonDeserializer.deserialize(license.toString(), LicenseDo.class);
			resourceSearchResultDo.setLicense(licenseDo);
			if((!recordJsonObject.isNull(TAG_SET))&& recordJsonObject.get(TAG_SET) != null && !recordJsonObject.get(TAG_SET).equals("") && !recordJsonObject.get(TAG_SET).equals(null) ){
			JSONArray tagSetArray = (JSONArray) recordJsonObject.get(TAG_SET);
			Set<TagDo> tagSet= new HashSet<TagDo>();
			if(tagSetArray !=null){
				for(int i=0;i<tagSetArray.length();i++){
					tagSet.add(JsonDeserializer.deserialize(tagSetArray.get(i).toString(), TagDo.class));
				}
				resourceSearchResultDo.setTagSet(tagSet);
			}
			}
			
		} catch (JSONException e) {
			
		}

		return resourceSearchResultDo;
	}
	
}
