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

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Search Team
 * 
 */
public abstract class ServiceRequest {

	private static final Logger logger = LoggerFactory.getLogger(ServiceProcessor.class);

	private ClientResource clientResource = null;

	private Representation representation = null;
	
	private static final String ERROR = "Error : "; 

	protected ServiceRequest() {
	}

	public JsonResponseRepresentation execute() {
		try {
			return run();
		} catch (ResourceException exception) {
			logger.error(ERROR, exception);
			//throw new RuntimeException(exception.getMessage());
			JsonResponseRepresentation jsonResponseRepresentation=new JsonResponseRepresentation();
			jsonResponseRepresentation.setStatusCode(exception.getStatus().getCode());
			return jsonResponseRepresentation;
		} catch (Exception exception) {
			logger.error(ERROR, exception);
			throw new RuntimeException(exception.getMessage());
		} finally {
			releaseClientResources();
		}
	}

	public abstract JsonResponseRepresentation run() throws Exception;

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

	public StringRepresentation runString() throws Exception{
		return new StringRepresentation("");
	}
	
	
	
	
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

	public ClientResource getClientResource() {
		return clientResource;
	}

	public void setClientResource(ClientResource clientResource) {
		this.clientResource = clientResource;
	}

	public Representation getRepresentation() {
		return representation;
	}

	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}

	public static Logger getLogger() {
		return logger;
	}
	
	public void setBody() {
		throw new RuntimeException("Not implemented");
	}
}
