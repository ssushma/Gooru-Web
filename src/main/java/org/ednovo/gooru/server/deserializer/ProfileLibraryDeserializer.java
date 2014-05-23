package org.ednovo.gooru.server.deserializer;

import java.util.ArrayList;

import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.model.content.ThumbnailDo;
import org.ednovo.gooru.shared.model.library.ConceptDo;
import org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo;
import org.ednovo.gooru.shared.model.library.LibraryResourceDo;
import org.ednovo.gooru.shared.model.library.PartnerConceptListDo;
import org.ednovo.gooru.shared.model.library.ProfileLibraryDo;
import org.ednovo.gooru.shared.model.library.ProfileLibraryListDo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

@Component
public class ProfileLibraryDeserializer extends DeSerializer{
	
	private static final String SEARCH_RESULTS = "searchResult";
	private static final String COUNT = "count";
	private static final String COLLECTION_ITEMS = "collectionItems";
	private static final String TITLE = "title";
	private static final String GOALS = "goals";
	private static final String GOORUOID = "gooruOid";
	private static final String THUMBNAILS = "thumbnails";
	private static final String FOLDER = "folder";
	private static final String TYPE = "type";

	public ProfileLibraryListDo deserializeFolderList(JsonRepresentation jsonRep) {
			try {
				if (jsonRep != null && jsonRep.getSize() != -1) {
					return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), new TypeReference<ProfileLibraryListDo>() {});
				}
			} catch (Exception e) {}
			return new ProfileLibraryListDo();

/*		ProfileLibraryListDo searchResults = new ProfileLibraryListDo();
		ArrayList<ProfileLibraryDo> firstLevelFolders = new ArrayList<ProfileLibraryDo>();
		Integer count;
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				JSONArray firstLevelArray = jsonRep.getJsonObject().getJSONArray(SEARCH_RESULTS);
				count = jsonRep.getJsonObject().getInt(COUNT);
				for(int i=0;i<firstLevelArray.length();i++) {
					ProfileLibraryDo folderFirstLevelDo = JsonDeserializer.deserialize(firstLevelArray.getJSONObject(i).toString(), ProfileLibraryDo.class);
					if(i==0) {
						JSONArray secondLevelArray = firstLevelArray.getJSONObject(i).getJSONArray(COLLECTION_ITEMS);
						folderFirstLevelDo.setFolderItems(getDeserializedPartnerList(secondLevelArray, i));
					}
					firstLevelFolders.add(folderFirstLevelDo);
				}
				searchResults.setCount(count);
				searchResults.setSearchResult(firstLevelFolders);
			}
			return searchResults;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ProfileLibraryListDo();
*/	}
	
/*	private ArrayList<ProfileLibraryDo> getDeserializedPartnerList(JSONArray secondLevelArray, int level) {
		ArrayList<ProfileLibraryDo> secondLevelFolders = new ArrayList<ProfileLibraryDo>();
		try {
			if(secondLevelArray.length()>0) {
				for(int j=0;j<secondLevelArray.length();j++) {
					JSONObject secondLevelJsonObject = secondLevelArray.getJSONObject(j);
					ProfileLibraryDo folderTwoLevelDo = JsonDeserializer.deserialize(secondLevelJsonObject.toString(), ProfileLibraryDo.class);
					if(!secondLevelJsonObject.isNull(COLLECTION_ITEMS)) {
						JSONArray thirdLevelArray = secondLevelJsonObject.getJSONArray(COLLECTION_ITEMS);
						ArrayList<ConceptDo> thirdLevelConcepts = new ArrayList<ConceptDo>();
						ArrayList<ProfileLibraryDo> thirdLevelFolders = new ArrayList<ProfileLibraryDo>();
						if(thirdLevelArray.length()>0) {
							for(int k=0;k<thirdLevelArray.length();k++) {
								JSONObject thirdLevelJsonObject = thirdLevelArray.getJSONObject(k);
								if(thirdLevelJsonObject.getString(TYPE).equalsIgnoreCase(FOLDER)) {
									ProfileLibraryDo folderThirdLevelDo = JsonDeserializer.deserialize(thirdLevelJsonObject.toString(), ProfileLibraryDo.class);
									JSONArray fourthLevelArray = thirdLevelJsonObject.getJSONArray(COLLECTION_ITEMS);
									ArrayList<ConceptDo> fourthLevelConcepts = new ArrayList<ConceptDo>();
									if(fourthLevelArray.length()>0) {
										for(int m=0;m<fourthLevelArray.length();m++) {
											ConceptDo conceptDo = new ConceptDo();
											JSONObject fourthLevelJsonObject = fourthLevelArray.getJSONObject(m);
											if(!fourthLevelJsonObject.isNull(GOALS)) {
												conceptDo.setGoals(fourthLevelJsonObject.getString(GOALS));
											} else {
												conceptDo.setGoals("");
											}
											
											conceptDo.setTitle(fourthLevelJsonObject.getString(TITLE));
											conceptDo.setGooruOid(fourthLevelJsonObject.getString(GOORUOID));
											conceptDo.setThumbnails(JsonDeserializer.deserialize(fourthLevelJsonObject.getJSONObject(THUMBNAILS).toString(), ThumbnailDo.class));
											if(m==0) {
												JSONArray resourceArray = fourthLevelJsonObject.getJSONArray(COLLECTION_ITEMS);
												ArrayList<LibraryCollectionItemDo> collectionItems = new ArrayList<LibraryCollectionItemDo>();
												for(int l=0;l<resourceArray.length();l++) {
													LibraryCollectionItemDo libraryCollectionItemDo = new LibraryCollectionItemDo();
													libraryCollectionItemDo.setResource(JsonDeserializer.deserialize(resourceArray.getJSONObject(l).toString(), LibraryResourceDo.class));
													collectionItems.add(libraryCollectionItemDo);
												}
												conceptDo.setCollectionItems(collectionItems);
											}
											fourthLevelConcepts.add(conceptDo);
										}
									}
									folderThirdLevelDo.setCollections(fourthLevelConcepts);
									thirdLevelFolders.add(folderThirdLevelDo);
								} else {
									thirdLevelConcepts.add(getConceptDeserialization(thirdLevelJsonObject,k));
								}
							}
							if(thirdLevelArray.getJSONObject(0).getString(TYPE).equalsIgnoreCase(FOLDER)) {
								folderTwoLevelDo.setFolderItems(thirdLevelFolders);
							} else {
								folderTwoLevelDo.setCollections(thirdLevelConcepts);
							}
						}
						if(thirdLevelArray.length()>0) {
							secondLevelFolders.add(folderTwoLevelDo);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return secondLevelFolders;
	}
	
	public ConceptDo getConceptDeserialization(JSONObject thirdLevelJsonObject, int k) {
		ConceptDo conceptDo = new ConceptDo();
		try {
			if(thirdLevelJsonObject.isNull(GOALS)) {
				
			} else {
				conceptDo.setGoals(thirdLevelJsonObject.getString(GOALS));
			}
			
			conceptDo.setTitle(thirdLevelJsonObject.getString(TITLE));
			conceptDo.setGooruOid(thirdLevelJsonObject.getString(GOORUOID));
			conceptDo.setThumbnails(JsonDeserializer.deserialize(thirdLevelJsonObject.getJSONObject(THUMBNAILS).toString(), ThumbnailDo.class));
			if(k==0) {
				JSONArray resourceArray = thirdLevelJsonObject.getJSONArray(COLLECTION_ITEMS);
				ArrayList<LibraryCollectionItemDo> collectionItems = new ArrayList<LibraryCollectionItemDo>();
				for(int l=0;l<resourceArray.length();l++) {
					LibraryCollectionItemDo libraryCollectionItemDo = new LibraryCollectionItemDo();
					libraryCollectionItemDo.setResource(JsonDeserializer.deserialize(resourceArray.getJSONObject(l).toString(), LibraryResourceDo.class));
					collectionItems.add(libraryCollectionItemDo);
				}
				conceptDo.setCollectionItems(collectionItems);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return conceptDo;
	}
*/
	
}