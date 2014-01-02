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
package org.ednovo.gooru.server.request;

import org.restlet.data.ChallengeScheme;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
/**
 * @fileName : ServiceProcessor.java
 *
 * @description : This class used in making API calls using rest-let frame work.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ServiceProcessor {

	/**
	 * @function get 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used for to send the request and get the response.
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param type
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation get(final String url, final MediaType type, final String username, final String password) {

		return new ServiceRequest() {

			@Override
			public JsonRepresentation run() throws Exception {
				
				setClientResource(new ClientResource(url));
				if (username != null && username.length() > 0 && password != null && password.length() > 0) {
					getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
				}

				setRepresentation(getClientResource().get(type));

				// Get the representation as an JsonRepresentation
				return new JsonRepresentation(getRepresentation().getText());
			}
		}.execute();

	}
	
	/**
	 * @function get 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used for to send the request and get the response.
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param type
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation get(final String url, final MediaType type) {

		return new ServiceRequest() {

			@Override
			public JsonRepresentation run() throws Exception {

				setClientResource(new ClientResource(url));
				setRepresentation(getClientResource().get(type));
				// Get the representation as an JsonRepresentation
				return new JsonRepresentation(getRepresentation().getText());
			}
		}.execute();

	}
	/**
	 * @function get 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation get(final String url, String username, String password) {
		return get(url, MediaType.APPLICATION_JSON, username, password);
	}
	/**
	 * @function get 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation get(final String url) {
		return get(url, MediaType.APPLICATION_JSON);
	}
	
	/**
	 * @function post 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param type
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param form
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation post(final String url, final MediaType type, final String username, final String password, final Form form) {

		return new ServiceRequest() {

			@Override
			public JsonRepresentation run() throws Exception {
				
				setClientResource(new ClientResource(url));

				if (username != null && username.length() > 0 && password != null && password.length() > 0) {
					getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
				}
				setRepresentation(getClientResource().post(form));

				// Get the representation as an JsonRepresentation
				return new JsonRepresentation(getRepresentation().getText());
			}
		}.execute();

	}
	
	/**
	 * @function post 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param type
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param formData
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation post(final String url, final MediaType type, final String username, final String password, final String formData) {

		return new ServiceRequest() {

			@Override
			public JsonRepresentation run() throws Exception {
				
				setClientResource(new ClientResource(url));
				if (username != null && username.length() > 0 && password != null && password.length() > 0) {
					getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
				}
//				getClientResource().getRequest().setEntity();
				Representation resp = null;
				try{
//					setRepresentation(getClientResource().post(new JsonRepresentation(formData)));
					resp = getClientResource().post(new JsonRepresentation(formData));
				}catch(Exception e){
					resp = getClientResource().getResponse().getEntity();
				}
				return new JsonRepresentation(resp.getText());
			}

		}.execute();	
	}
	/**
	 * @function postString 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param type
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param formData
	 * @parm(s) : @return
	 * 
	 * @return : StringRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static StringRepresentation postString(final String url, final MediaType type, final String username, final String password, final String formData) {

		return new ServiceRequest() {

			@Override
			public JsonRepresentation run() throws Exception {
				throw new RuntimeException("Not implemented");
			}

			@Override
			public StringRepresentation runString() throws Exception {
				setClientResource(new ClientResource(url));
				if (username != null && username.length() > 0 && password != null && password.length() > 0) {
					getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
				}
//				getClientResource().getRequest().setEntity();
				setRepresentation(getClientResource().post(new JsonRepresentation(formData)));
				return new StringRepresentation(getRepresentation().getText());
			}}.executeString();	
	}
	
	/**
	 * @function post 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param form
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation post(final String url, String username, String password, Form form) {
		return post(url, MediaType.APPLICATION_JSON, username, password, form);
	}

	/**
	 * @function post 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param formData
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation post(final String url, String username, String password, String formData) {
		return post(url, MediaType.APPLICATION_JSON, username, password, formData);
	}
	/**
	 * @function postString 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param formData
	 * @parm(s) : @return
	 * 
	 * @return : StringRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static StringRepresentation postString(final String url, String username, String password, String formData) {
		return postString(url, MediaType.APPLICATION_JSON, username, password, formData);
	}
	
	/**
	 * @function post 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation post(final String url, String username, String password) {
		Form data = null;
		return post(url, MediaType.APPLICATION_JSON, username, password, data);
	}
	/**
	 * @function delete 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation delete(final String url, final String username, final String password) {
		return delete(url, MediaType.APPLICATION_JSON, username, password);
	}

	/**
	 * @param url
	 * @param username
	 * @param password
	 * @return instance of {@link JsonRepresentation}
	 */
	public static JsonRepresentation delete(final String url, final String username, final String password, final String formData) {
		return delete(url, MediaType.APPLICATION_JSON, username, password, formData);
	}

	/**
	 * @function delete 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param type
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation delete(final String url, final MediaType type, final String username, final String password) {

		return new ServiceRequest() {

			@Override
			public JsonRepresentation run() throws Exception {

				setClientResource(new ClientResource(url));
				if (username != null && username.length() > 0 && password != null && password.length() > 0) {
					getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
				}

				setRepresentation(getClientResource().delete(type));

				// Get the representation as an JsonRepresentation
				return new JsonRepresentation(getRepresentation().getText());
			}
		}.execute();
	}
	/**
	 * @function put 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param type
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param form
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation put(final String url, final MediaType type, final String username, final String password, final Form form) {

		return new ServiceRequest() {

			@Override
			public JsonRepresentation run() throws Exception {

				setClientResource(new ClientResource(url));

				if (username != null && username.length() > 0 && password != null && password.length() > 0) {
					getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
				}

				setRepresentation(getClientResource().put(form.getWebRepresentation()));

				// Get the representation as an JsonRepresentation
				return new JsonRepresentation(getRepresentation().getText());
			}
		}.execute();
	}
	/**
	 * @function delete 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param type
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param formData
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation delete(final String url, final MediaType type, final String username, final String password, final String formData) {

		return new ServiceRequest() {

			@Override
			public JsonRepresentation run() throws Exception {

				setClientResource(new ClientResource(url));

				if (username != null && username.length() > 0 && password != null && password.length() > 0) {
					getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
				}

				//setRepresentation(getClientResource().delete(formData));

				// Get the representation as an JsonRepresentation
				return new JsonRepresentation(getRepresentation().getText());
			}
		}.execute();
	}

	/**
	 * @function put 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param type
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param formData
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation put(final String url, final MediaType type, final String username, final String password, final String formData) {

		return new ServiceRequest() {

			@Override
			public JsonRepresentation run() throws Exception {

				setClientResource(new ClientResource(url));
				
				if (username != null && username.length() > 0 && password != null && password.length() > 0) {
					getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
				}

				setRepresentation(getClientResource().put(formData));

				// Get the representation as an JsonRepresentation
				return new JsonRepresentation(getRepresentation().getText());
			}
		}.execute();
	}
	/**
	 * @function put 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param form
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation put(final String url, final String username, final String password, final Form form) {
		return put(url, MediaType.APPLICATION_JSON, username, password, form);
	}
	/**
	 * @function put 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @param formData
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation put(final String url, final String username, final String password, final String formData) {
		return put(url, MediaType.APPLICATION_JSON, username, password, formData);
	}
	/**
	 * @function put 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used for to send the request and get the response.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param username
	 * @parm(s) : @param password
	 * @parm(s) : @return
	 * 
	 * @return : JsonRepresentation
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JsonRepresentation put(final String url, final String username, final String password) {
		Form form = null;
		return put(url, MediaType.APPLICATION_JSON, username, password, form);
	}
}
