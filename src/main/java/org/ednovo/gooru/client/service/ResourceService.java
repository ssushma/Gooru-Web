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
package org.ednovo.gooru.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.player.resource.shared.GetFlagContentDO;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.exception.ServerDownException;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo;
import org.ednovo.gooru.shared.model.content.ExistsResourceDo;
import org.ednovo.gooru.shared.model.content.MetaDO;
import org.ednovo.gooru.shared.model.content.ProfanityCheckDo;
import org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo;
import org.ednovo.gooru.shared.model.content.ResourceTagsDo;
import org.ednovo.gooru.shared.model.drive.GoogleDriveDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;
import org.ednovo.gooru.shared.model.user.GoogleToken;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gwt-service/resourceService")
public interface ResourceService extends BaseService {
	
	/**
	 * Create new collection
	 * @param collectionDo instance of {@link CollectionDo} has collection meta info
	 * @param codeId taxonomy code
	 * @return serialized created {@link CollectionDo}
	 * @throws GwtException
	 */
	public CollectionDo createCollection(CollectionDo collectionDo, String codeId)  throws GwtException, ServerDownException;
	
/*	*//**
	 * Create new collection inside a parent
	 * @param collectionDo instance of {@link CollectionDo} has collection meta info
	 * @param codeId taxonomy code
	 * @return serialized created {@link CollectionDo}
	 * @throws GwtException
	 *//*
	public CollectionDo createCollectionInParent(CollectionDo collectionDo, String codeId, String parentId)  throws GwtException, ServerDownException;
*/
	/**
	 * update existing collection
	 * @param collectionDo instance of {@link CollectionDo} is to be updated
	 * @return serialized to {@link CollectionDo} after update 
	 * @throws GwtException
	 */
//	public CollectionDo updateCollection(CollectionDo collectionDo)  throws GwtException, ServerDownException;
	
	/**
	 * Delete existing collection by collectionId
	 * @param collectionId of the collection 
	 * @throws GwtException
	 */
	public void deleteCollection(String collectionId)  throws GwtException, ServerDownException;
	
	/**
	 * Create new collection item
	 * @param collectionId of the existing collection  
	 * @param resourceId of the existing resource , which is being as collection item
	 * @return serialized to {@link CollectionItemDo} after create 
	 * @throws GwtException
	 */
	public CollectionItemDo createCollectionItem(String collectionId, String resourceId)  throws GwtException, ServerDownException;
	
	/**
	 * copy as new collection item
	 * @param collectionId of the existing collection  (can be null)
	 * @param resourceId of the existing resource , which is being as collection item
	 * @return serialized to {@link CollectionItemDo} after create 
	 * @throws GwtException
	 */
	public CollectionItemDo copyCollectionItem(String collectionId, String resourceId)  throws GwtException, ServerDownException;
	
	
	/**
	 * Remove collection item from the collection 
	 * @param collectionItemId of the collection item
	 * @throws GwtException
	 */
	public void deleteCollectionItem(String collectionItemId)  throws GwtException, ServerDownException;
	
	/**
	 * Reorder the collection item
	 * @param collectionItemDo instance of {@link CollectionItemDo}
	 * @return serialized to {@link CollectionItemDo} after reorder
	 * @throws GwtException
	 */
	public CollectionItemDo reorderCollectionItem(CollectionItemDo collectionItemDo)  throws GwtException, ServerDownException; 
	
	/**
	 * Make a copy of the given collection  
	 * @param collectionDo instance of {@link CollectionDo}
	 * @param addToShelf copied collection to be on user shelf or not
	 * @param taxonomyCode of the collection
	 * @return serialized copy {@link CollectionDo} 
	 * @throws GwtException
	 */
	public CollectionDo copyCollection(CollectionDo collectionDo, String addToShelf, String taxonomyCode)  throws GwtException, ServerDownException;
	
	/**
	 * Get all collection item
	 * @param collectionDo instance of {@link CollectionDo} 
	 * @return List of serialized {@link CollectionItemDo}
	 * @throws GwtException
	 */
//	public List<CollectionItemDo> getCollectionItems(CollectionDo collectionDo)  throws GwtException, ServerDownException;

	public MetaDO getPermissions(String collectionId) throws GwtException, ServerDownException;
	
	/**
	 * Get collection by collectionId
	 * @param collectionGooruOid of the collection
	 * @param skipCollectionItem includes collection item of the collection if true else not
	 * @return serialized {@link CollectionDo}
	 * @throws GwtException
	 */
	public CollectionDo getCollection(String collectionGooruOid,boolean skipCollectionItem)  throws GwtException, ServerDownException;
	
	/**
	 * Get list of collection
	 * @param pageSize get collection by given page size 
	 * @param pageNum get collection of given page number
	 * @param scollection has value  deep or simple if deep includes collection item else not 
	 * @return List of serialized {@link CollectionDo}
	 * @throws GwtException
	 */
//	public List<CollectionDo> listCollections(Integer pageSize,Integer pageNum,String scollection)  throws GwtException, ServerDownException;
	
	/**
	 * Get user collection
	 * @return List of serialized {@link CollectionDo}
	 * @throws GwtException
	 */
	public List<CollectionDo> getUserCollection()  throws GwtException, ServerDownException;
	
	/**
	 * Create collection with collection item 
	 * @param collectionDo instance of {@link CollectionDo}
	 * @param codeId taxonomy collection for code
	 * @param resourceId of the resource
	 * @return created {@link CollectionDo} after serialize
	 * @throws GwtException
	 */
	public CollectionDo createCollectionWithItem(CollectionDo collectionDo, String codeId, String resourceId)  throws GwtException, ServerDownException;
	
	/**
	 * Update collection item
	 * @param collectionItem instance of {@link CollectionItemDo}
	 * @return serialized {@link CollectionItemDo} after update
	 * @throws GwtException
	 */
//	public CollectionItemDo updateCollectionItem(CollectionItemDo collectionItem)  throws GwtException, ServerDownException;
	
	/**
	 * Update collection meta data info
	 * @param collectionId of the collection 
	 * @param title of collection
	 * @param description of the collection
	 * @param grade of the collection
	 * @param sharing of the collection
	 * @param vocabulary of the collection
	 * @param taxonomyCode of the collection
	 * @param updateTaxonomyByCode is code if true else is codeId 
	 * @param action remove or add
	 * @return serialized {@link CollectionDo} after update
	 * @throws GwtException
	 */
	public CollectionDo updateCollectionMetadata(String collectionId, String title, String description, String grade, String sharing, String vocabulary, String taxonomyCode, String updateTaxonomyByCode,String mediaType, String action)  throws GwtException, ServerDownException;
	
	
	/**
	 * Update collection metadata item info
	 * @param collectionItemId of the collection item
	 * @param narration of the collection
	 * @param narrationType of the collection
	 * @param start of the collection
	 * @param stop of the collection
	 * @return serialized {@link CollectionItemDo} after update
	 * @throws GwtException
	 */
	public CollectionItemDo updateCollectionItemMetadata(String collectionItemId, String narration, String narrationType, String start, String stop)  throws GwtException, ServerDownException;
	
	/**
	 * Add collaborator for the collection
	 * @param gooruOid of collection
	 * @param collaboratorId user id
	 * @return serialized {@link UserDo}  of collaborator
	 * @throws GwtException
	 */
	public UserDo addCollaborator(String gooruOid,String collaboratorId)  throws GwtException, ServerDownException;
	
	/**
	 * Get added collaborator list for the collection
	 * @param gooruOid of collection 
	 * @return List of serialized collaborator
	 * @throws GwtException
	 */
	public List<UserDo> getCollaborators(String gooruOid)  throws GwtException, ServerDownException;
	
	/**
	 * Delete added collaborator for the collection
	 * @param gooruOid of the collection
	 * @param collaboratorId of the collection
	 * @return serialized {@link UserDo}  of collaborator
	 * @throws GwtException
	 */
	public UserDo deleteCollaborators(String gooruOid,String collaboratorId)  throws GwtException, ServerDownException;
	
	/**
	 * Copy collection item
	 * @param collectionItemId of the collection item
	 * @return Serialized copied {@link CollectionItemDo}
	 * @throws GwtException
	 */
//	public CollectionItemDo copyCollectionItem(String collectionItemId)  throws GwtException, ServerDownException;
	
	/**
	 * Get youtybe video length
	 * @param videoId of youtube
	 * @return youtube video length
	 * @throws GwtException
	 */
	public String getYoutubeDuration(String videoId)  throws GwtException, ServerDownException;
	

	
//	public List<CollectionItemsListDo> getMyUserCollections()  throws GwtException, ServerDownException;
	
	/**
	 * Add new Resource
	 * @param gooruOid
	 * @param idStr
	 * @param urlStr
	 * @param titleStr
	 * @param description
	 * @param categoryStr
	 * @param thumbnailImgSrcStr
	 * @param endTime (videoDuration)
	 * @return CollectionDO
	 * @throws GwtException
	 */
	public CollectionItemDo addNewResource(String gooruOid, String idStr, String urlStr,String titleStr, String descriptionStr, String categoryStr, String thumbnailImgSrcStr, Integer endTime,String edcuationalUse,String momentsOfLearning,List<CodeDo> standards,String hostName, List<String> tagList) throws GwtException, ServerDownException;
	
	
	/**
	 * To get meta info from specific url
	 * @param url
	 * @return ResoruceMetaInfo
	 * @throws GwtException
	 */
	ResourceMetaInfoDo getResourceMetaInfo(String url) throws GwtException, ServerDownException;
	
	/**
	 * To check whether 
	 * @param gooruOid
	 * @return ResourceDo
	 * @throws GwtException
	 */
	ExistsResourceDo checkResourceExists(String url) throws GwtException, ServerDownException;
	
	
	
	public CollectionItemDo addQuestionResource(String collectionId, String mediafileName, CollectionQuestionItemDo collectionQuestionItemDo) throws GwtException, ServerDownException;
	
	public CollectionItemDo updateQuestionResource(CollectionItemDo collectionItemDo,CollectionQuestionItemDo collectionQuestionItemDo,String thumbnailUrl) throws GwtException, ServerDownException;

	/**
	 * To update Resource Info.
	 * @param gooruOid
	 * @param resourceDo
	 * @return ResourceDo
	 * @throws GwtException
	 */
	public CollectionItemDo updateResourceInfo(CollectionItemDo collectionItemDo,List<String> tagList) throws GwtException, ServerDownException;
	
	public void removeQuestionImage(String collectionQuestionId) throws GwtException, ServerDownException;
	
    public void updateQuestionImage(String collectionItemId,String fileName) throws GwtException, ServerDownException;
	
	public List<CollectionDo> getUserCollectionList(Integer pageSize,Integer pageNum, boolean isSharable)  throws GwtException, ServerDownException;
	
	//public CollectionItemDo copyCollectionListItem(String collectionId, String resourceId,Integer pageSize,Integer pageNum)  throws GwtException, ServerDownException;
	
	public String checkShortenUrl(String url) throws GwtException, ServerDownException;
	

	
	public CollectionItemDo addNewUserResource(String jsonString,	String gooruOid)  throws GwtException, ServerDownException;
	
	public MediaUploadDo saveUserOwnResource(String filePath) throws GwtException, ServerDownException;  
	
	public CollectionItemDo updateUserOwnResource(String jsonString, String gooruOid)throws GwtException, ServerDownException; 
	public CollectionItemDo updateNarrationMetadata(String collectionItemId, String narration, String narrationType)  throws GwtException, ServerDownException;
	//For Flag existing resources
	//To create content report
  	public void createContentReport(String assocGooruOid,String targetValue,String typesvalue1,String typesvalue2,String typesvalue3, String typesvalue4,String otherDescription) throws GwtException, ServerDownException;
  	//To update content report
  	public String updateReport(String gooruOid,String freeText) throws GwtException, ServerDownException;
  	//To get content report
  	public  GetFlagContentDO getContentReport(String assocGooruOid) throws GwtException, ServerDownException;
  	//To delete content report
  	public String deleteContentReport(String gooruOid) throws GwtException, ServerDownException;

  	/**
  	 * 
  	 * @function checkProfanity 
  	 * 
  	 * @created_date : Jan 3, 2014
  	 * 
  	 * @description
  	 * 		This method is used to check the user inputs whether has as bad words.
  	 * 
  	 * @parm(s) : @param parms
  	 * @parm(s) : @return
  	 * @parm(s) : @throws GwtException
  	 * 
  	 * @return : boolean
  	 *
  	 * @throws : <Mentioned if any exceptions>
  	 *
  	 * 
  	 *
  	 *
  	 */
  	public Boolean checkProfanity(Map<String, String> parms)  throws GwtException, ServerDownException;
  	
	public List<ProfanityCheckDo> checkProfanityForList(List<ProfanityCheckDo> parms)  throws GwtException, ServerDownException;
	
	public FolderListDo getFolderWorkspace(int offset, int limit,String sharingType, String collectionType) throws GwtException, ServerDownException;

	public CollectionDo updateCollectionInfo(CollectionDo collectionDo,
			String teacherTips) throws GwtException, ServerDownException;
	
	public CollectionDo updateCollectionLanguageObjective(CollectionDo collectionDo,
			String languageObjective) throws GwtException, ServerDownException;
	
	public CollectionDo updateCollectionDepthOfKnowledge(CollectionDo collectionDo,
			String depthOfKnowledge, Boolean selectedVal) throws GwtException, ServerDownException;
	
	public CollectionDo updateCollectionInstructionalMethod(CollectionDo collectionDo,
			String instructionMethod, Boolean selectedVal) throws GwtException, ServerDownException;
	
	public CollectionDo updateCollectionLearningSkills(CollectionDo collectionDo,
			String depthOfKnowledge, Boolean selectedVal) throws GwtException, ServerDownException;
	
	
	public CollectionDo updateCollectionAudience(CollectionDo collectionDo,
			String audience, Boolean selectedVal) throws GwtException, ServerDownException;

	public CollectionDo getCollectionInfoV2API(String collectionId)
			throws GwtException, ServerDownException;
	
	public void deleteTaxonomyResource(String resourceId,Integer codeId)throws GwtException, ServerDownException;
	
	public void UpdateResourceTaxonomy(String resourceId,Set<CodeDo> taxonomyObj)throws GwtException, ServerDownException;
	
	public List<ResourceTagsDo> addTagsToResource(String resourceId, String addedTags)throws GwtException, ServerDownException;
	
	public List<ResourceTagsDo> getTagsToResource(String resourceId)throws GwtException, ServerDownException;
	
	public void deleteTagsServiceRequest(String resourceId, String addedTags)throws GwtException, ServerDownException;

	public GoogleDriveDo getGoogleDriveFilesList(String folderId,String nextPageToken) throws GwtException, ServerDownException;
	
	public GoogleDriveDo updateFileShareToAnyoneWithLink(String driveFileId) throws GwtException, ServerDownException;

	/**
	 * @function refreshGoogleAccessToken 
	 * 
	 * @created_date : Jul 17, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param refreshToken
	 * @throws GwtException
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	public GoogleToken refreshGoogleAccessToken(String refreshToken) throws GwtException, ServerDownException;

	//List<DriveDo> getfolderList(String id)throws GwtException, ServerDownException;

	//DriveDo updatePermissions(DriveDo driveObject)throws GwtException, ServerDownException;
	
	public CollectionItemDo v2UpdateQuestionResource(CollectionItemDo collectionItemDo,CollectionQuestionItemDo collectionQuestionItemDo,String thumbnailUrl) throws GwtException, ServerDownException;

	public CollectionDo updateCollectionSettingForComments(String collectionId,
			String title, String description, String grade, String sharing,
			String vocabulary, String taxonomyCode,
			String updateTaxonomyByCode, String mediaType, String action,
			String comments);
	
	public String getUserShelfDetails(String userUid) throws GwtException, ServerDownException;
		 
}
