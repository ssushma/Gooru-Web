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
package org.ednovo.gooru.server.request;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.engine.application.DecodeRepresentation;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.data.Encoding;
/**
 * @author Search Team
 * 
 */
public class ServiceProcessor {
   /**
    * @param url
    * @param type
    * @param username
    * @param password
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation get(final String url, final MediaType type, final String username, final String password) {
       return new ServiceRequest() {
           @Override
           public JsonResponseRepresentation run() throws Exception {
               
               setClientResource(new ClientResource(url));
               if (username != null && username.length() > 0 && password != null && password.length() > 0) {
                   getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
               }
               setMediaType(type);
               setEncodings(Encoding.GZIP);
               setRepresentation(getClientResource().get());
               Representation decodedRep = new DecodeRepresentation(getClientResource().get()); 
               // Get the representation as an JsonRepresentation
               JsonResponseRepresentation jsonResponseRepresentation=new JsonResponseRepresentation();
               jsonResponseRepresentation.setJsonRepresentation(new JsonRepresentation(decodedRep.getText()));
               return jsonResponseRepresentation;
           }
       }.execute();
   }
   
   /**
    * @param url
    * @param type
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation get(final String url, final MediaType type) {
       return new ServiceRequest() {
           @Override
           public JsonResponseRepresentation run() throws Exception {
               setClientResource(new ClientResource(url));
               setMediaType(type);
               setEncodings(Encoding.GZIP);
               setRepresentation(getClientResource().get());
               // Get the representation as an JsonRepresentation
               //return new JsonRepresentation(getRepresentation().getText());
               JsonResponseRepresentation jsonResponseRepresentation=new JsonResponseRepresentation();
               jsonResponseRepresentation.setJsonRepresentation(new JsonRepresentation(getRepresentation().getText()));
               return jsonResponseRepresentation;
           }
       }.execute();
   }
   /**
    * @param url
    * @param username
    * @param password
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation get(final String url, String username, String password) {
       return get(url, MediaType.APPLICATION_JSON, username, password);
   }
   
   /**
    * @param url
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation get(final String url) {
       return get(url, MediaType.APPLICATION_JSON);
   }
   
   /**
    * @param url
    * @param type
    * @param username
    * @param password
    * @param form
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation post(final String url, final MediaType type, final String username, final String password, final Form form) {
       return new ServiceRequest() {
           @Override
           public JsonResponseRepresentation run() throws Exception {
               
               setClientResource(new ClientResource(url));
               if (username != null && username.length() > 0 && password != null && password.length() > 0) {
                   getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
               }
               setEncodings(Encoding.GZIP);
               setRepresentation(getClientResource().post(form));
               Representation decodedRep = new DecodeRepresentation(getClientResource().post(form));
               // Get the representation as an JsonRepresentation
               JsonResponseRepresentation jsonResponseRepresentation=new JsonResponseRepresentation();
               jsonResponseRepresentation.setJsonRepresentation(new JsonRepresentation(decodedRep.getText()));
               return jsonResponseRepresentation;
           }
       }.execute();
   }
   
   /**
    * @param url
    * @param type
    * @param username
    * @param password
    * @param formData as string
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation post(final String url, final MediaType type, final String username, final String password, final String formData) {
       return new ServiceRequest() {
           @Override
           public JsonResponseRepresentation run() throws Exception {

        	   setClientResource(new ClientResource(url));
        	   if (username != null && username.length() > 0 && password != null && password.length() > 0) {
        		   getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
        	   }
        	   setEncodings(Encoding.GZIP);
        	   Representation resp = null;
        	   resp = getClientResource().post(new JsonRepresentation(formData));
        	   Representation decodedRep = new DecodeRepresentation(resp);
        	   JsonResponseRepresentation jsonResponseRepresentation=new JsonResponseRepresentation();
        	   jsonResponseRepresentation.setJsonRepresentation(new JsonRepresentation(decodedRep.getText()));
        	   return jsonResponseRepresentation;
           }
       }.execute();    
   }
   /**
    * @param url
    * @param type
    * @param username
    * @param password
    * @param formData as string
    * @return instance of {@link JsonRepresentation}
    */
   public static StringRepresentation postString(final String url, final MediaType type, final String username, final String password, final String formData) {
       return new ServiceRequest() {
           @Override
           public JsonResponseRepresentation run() throws Exception {
               throw new RuntimeException("Not implemented");
           }
           @Override
           public StringRepresentation runString() throws Exception {
               setClientResource(new ClientResource(url));
               if (username != null && username.length() > 0 && password != null && password.length() > 0) {
                   getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
               }
               setEncodings(Encoding.GZIP);
               setRepresentation(getClientResource().post(new JsonRepresentation(formData)));
               Representation decodedRep = new DecodeRepresentation(getClientResource().post(new JsonRepresentation(formData)));
               return new StringRepresentation(decodedRep.getText());
           }}.executeString();    
   }
   
   
   /**
    * @param url
    * @param username
    * @param password
    * @param form
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation post(final String url, String username, String password, Form form) {
       return post(url, MediaType.APPLICATION_JSON, username, password, form);
   }
   /**
    * @param url
    * @param username
    * @param password
    * @param form
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation post(final String url, String username, String password, String formData) {
       return post(url, MediaType.APPLICATION_JSON, username, password, formData);
   }
   
   /**
    * @param url
    * @param username
    * @param password
    * @param form
    * @return instance of {@link StringRepresentation}
    */
   public static StringRepresentation postString(final String url, String username, String password, String formData) {
       return postString(url, MediaType.APPLICATION_JSON, username, password, formData);
   }
   
   
   /**
    * @param url
    * @param username
    * @param password
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation post(final String url, String username, String password) {
       Form data = null;
       return post(url, MediaType.APPLICATION_JSON, username, password, data);
   }
   /**
    * @param url
    * @param username
    * @param password
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation delete(final String url, final String username, final String password) {
       return delete(url, MediaType.APPLICATION_JSON, username, password);
   }
   /**
    * @param url
    * @param username
    * @param password
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation delete(final String url, final String username, final String password, final String formData) {
       return delete(url, MediaType.APPLICATION_JSON, username, password, formData);
   }
   /**
    * @param url
    * @param type
    * @param username
    * @param password
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation delete(final String url, final MediaType type, final String username, final String password) {
       return new ServiceRequest() {
           @Override
           public JsonResponseRepresentation run() throws Exception {
               setClientResource(new ClientResource(url));
               if (username != null && username.length() > 0 && password != null && password.length() > 0) {
                   getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
               }
               setMediaType(type);
               setEncodings(Encoding.GZIP);
               setRepresentation(getClientResource().delete());
               Representation decodedRep = new DecodeRepresentation(getClientResource().delete());
               
               // Get the representation as an JsonRepresentation
               //return new JsonRepresentation((getRepresentation()!=null) ? getRepresentation().getText():"");
               JsonResponseRepresentation jsonResponseRepresentation=new JsonResponseRepresentation();
               jsonResponseRepresentation.setJsonRepresentation(new JsonRepresentation((getRepresentation()!=null) ? decodedRep.getText():""));
               return jsonResponseRepresentation;
           }
       }.execute();    
   }
   /**
    * @param url
    * @param type
    * @param username
    * @param password
    * @param form
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation put(final String url, final MediaType type, final String username, final String password, final Form form) {
       return new ServiceRequest() {
           @Override
           public JsonResponseRepresentation run() throws Exception {
               setClientResource(new ClientResource(url));
               if (username != null && username.length() > 0 && password != null && password.length() > 0) {
                   getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
               }
               setEncodings(Encoding.GZIP);
               setRepresentation(getClientResource().put(form.getWebRepresentation()));
               Representation decodedRep = new DecodeRepresentation(getClientResource().put(form.getWebRepresentation()));
               // Get the representation as an JsonRepresentation
               // return new JsonRepresentation(getRepresentation().getText());
               JsonResponseRepresentation jsonResponseRepresentation=new JsonResponseRepresentation();
               jsonResponseRepresentation.setJsonRepresentation(new JsonRepresentation(decodedRep.getText()));
               return jsonResponseRepresentation;
               
           }
       }.execute();
   }
   /**
    * @param url
    * @param type
    * @param username
    * @param password
    * @param form
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation delete(final String url, final MediaType type, final String username, final String password, final String formData) {
       return new ServiceRequest() {
           @Override
           public JsonResponseRepresentation run() throws Exception {
               setClientResource(new ClientResource(url));
               if (username != null && username.length() > 0 && password != null && password.length() > 0) {
                   getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
               }
//               setRepresentation(getClientResource().delete(formData));
               // Get the representation as an JsonRepresentation
               JsonResponseRepresentation jsonResponseRepresentation=new JsonResponseRepresentation();
               jsonResponseRepresentation.setJsonRepresentation(new JsonRepresentation((getRepresentation()!=null) ? getRepresentation().getText():""));
               return jsonResponseRepresentation;
           }
       }.execute();
   }
   /**
    * @param url
    * @param type
    * @param username
    * @param password
    * @param form
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation put(final String url, final MediaType type, final String username, final String password, final String formData) {
       return new ServiceRequest() {
           @Override
           public JsonResponseRepresentation run() throws Exception {
               setClientResource(new ClientResource(url));
               
               if (username != null && username.length() > 0 && password != null && password.length() > 0) {
                   getClientResource().setChallengeResponse(ChallengeScheme.HTTP_BASIC, username, password);
               }
               setEncodings(Encoding.GZIP);
               setRepresentation(getClientResource().put(formData));
               Representation decodedRep = new DecodeRepresentation(getClientResource().put(formData));
               // Get the representation as an JsonRepresentation
               JsonResponseRepresentation jsonResponseRepresentation=new JsonResponseRepresentation();
               jsonResponseRepresentation.setJsonRepresentation(new JsonRepresentation((getRepresentation()!=null) ? decodedRep.getText():""));
               return jsonResponseRepresentation;
           }
       }.execute();
   }
   /**
    * @param url
    * @param username
    * @param password
    * @param form
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation put(final String url, final String username, final String password, final Form form) {
       return put(url, MediaType.APPLICATION_JSON, username, password, form);
   }
   /**
    * @param url
    * @param username
    * @param password
    * @param formData as string
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation put(final String url, final String username, final String password, final String formData) {
       return put(url, MediaType.APPLICATION_JSON, username, password, formData);
   }
   /**
    * @param url
    * @param username
    * @param password
    * @return instance of {@link JsonRepresentation}
    */
   public static JsonResponseRepresentation put(final String url, final String username, final String password) {
       Form form = null;
       return put(url, MediaType.APPLICATION_JSON, username, password, form);
   }
	
}