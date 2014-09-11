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

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.client.service.AnalyticsService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.request.JsonResponseRepresentation;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.model.analytics.CollectionProgressDataDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemsListDo;
import org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo;
import org.json.JSONException;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;


@Service("analyticsService")
@ServiceURL("/analyticsService")
public class AnalyticsServiceImpl extends BaseServiceImpl implements AnalyticsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<CollectionProgressDataDo> getCollectionProgressData() {
		JsonRepresentation jsonRep = null;
		ArrayList<CollectionProgressDataDo> collectionProgressDataList=new ArrayList<CollectionProgressDataDo>();
		String url ="http://www.goorulearning.org/insights/api/v1/classpage/fe78faa5-f7f0-4927-9282-a58a4e3deb5d/users/usage.json?sessionToken=64daf466-3711-11e4-8d6c-123141016e2a&data={%22fields%22:%22timeSpent,avgTimeSpent,resourceGooruOId,OE,questionType,category,gooruUId,userName,userData,metaData,reaction,gooruOId,title,description,options,skip%22,%22filters%22:{%22session%22:%22FS%22,%22classId%22:%226a4cdb36-c579-4994-8ea0-5130a9838cbd%22},%22paginate%22:{%22sortBy%22:%22itemSequence%22,%22sortOrder%22:%22ASC%22}}&timestamp=1410150911006";
		System.out.println("----get coll url --->>> "+url); 
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			try {
				collectionProgressDataList= (ArrayList<CollectionProgressDataDo>) JsonDeserializer.deserialize(jsonRep.getJsonObject().getJSONArray("content").toString(),new TypeReference<List<CollectionProgressDataDo>>() {});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
		}
		System.out.println("in the success");
		return collectionProgressDataList;
	}

	
}
