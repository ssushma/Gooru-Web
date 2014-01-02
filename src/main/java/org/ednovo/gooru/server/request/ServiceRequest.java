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

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @fileName : ServiceRequest.java
 *
 * @description :  This class used in making API calls using rest-let frame work.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class ServiceRequest {

	private static final Logger logger = LoggerFactory.getLogger(ServiceProcessor.class);

	private ClientResource clientResource = null;

	private Representation representation = null;
	
	private static final String ERROR = "Error : "; 

	protected ServiceRequest() {
	}
	/**
	 * @function name: execute
	 * 
	 * @return {@link StringRepresentation}
	 */
	public JsonRepresentation execute() {
		try {
			return run();
		} catch (ResourceException exception) {
			logger.error(ERROR, exception);
			//throw new RuntimeException(exception.getMessage());
			return new JsonRepresentation("");
		} catch (Exception exception) {
			logger.error(ERROR, exception);
			throw new RuntimeException(exception.getMessage());
		} finally {
			releaseClientResources();
		}
	}

	public abstract JsonRepresentation run() throws Exception;
	/**
	 * @function name: executeString 
	 * 
	 * @return {@link StringRepresentation}
	 */
	public StringRepresentation executeString() {
		try {
			return runString();
		} catch (ResourceException exception) {
			logger.error(ERROR, exception);
			//throw new RuntimeException(exception.getMessage());
			return new StringRepresentation("");
		} catch (Exception exception) {
			logger.error(ERROR, exception);
			throw new RuntimeException(exception.getMessage());
		} finally {
			releaseClientResources();
		}
	}
	/**
	 * @return {@link StringRepresentation}
	 * @throws Exception
	 */
	public StringRepresentation runString() throws Exception{
		return new StringRepresentation("");
	}
	
	
	/**
	 * release/closes the client resources
	 */
	protected void releaseClientResources() {
		try {
			if (clientResource != null) {
				clientResource.release();
			}
			if (representation != null) {
				representation.release();
			}
			clientResource = null;
			representation = null;
		} catch (Exception e) {
			getLogger().error(e.getMessage());
		}
	}
	/**
	 * @return the {@link ClientResource}
	 */
	public ClientResource getClientResource() {
		return clientResource;
	}
	/**
	 * @param clientResource the clientResource to set
	 */
	public void setClientResource(ClientResource clientResource) {
		this.clientResource = clientResource;
	}

	/**
	 * @return the {@link Representation}
	 */
	public Representation getRepresentation() {
		return representation;
	}
	/**
	 * @param representation the representation to set
	 */
	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
	/**
	 * @return the {@link logger}
	 */
	public static Logger getLogger() {
		return logger;
	}
	/**
	 * @throws RuntimeException
	 */
	public void setBody() {
		throw new RuntimeException("Not implemented");
	}
}
