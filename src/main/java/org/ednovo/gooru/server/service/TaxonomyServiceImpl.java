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

import java.util.List;

import org.ednovo.gooru.client.service.TaxonomyService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.TaxonomyDeSerializer;
import org.ednovo.gooru.server.request.JsonResponseRepresentation;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("taxonomyService")
@ServiceURL("/taxonomyService")
public class TaxonomyServiceImpl extends BaseServiceImpl implements TaxonomyService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6947235468580822129L;
	
//	private static final String DEFAULT = "default"; 
	
	@Autowired
	private TaxonomyDeSerializer taxonomyDeSerializer;
	
	/*@Override
	public LibraryCodeDo getTaxonomyTree(int depthLimit, String parentCodeId) {
		if (parentCodeId == null) {
			parentCodeId = DEFAULT;
		}
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_TREE, parentCodeId, getLoggedInSessionToken());
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return taxonomyDeSerializer.getTree(depthLimit, jsonRep);
	}*/

	@Override
	public List<LibraryCodeDo> getCourse() {
		JsonRepresentation jsonRep =null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.TAXONOMY_COURSE, getLoggedInSessionToken());
		getLogger().info("--- get course at settings -- "+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return taxonomyDeSerializer.getCourse(jsonRep);
	}

}
