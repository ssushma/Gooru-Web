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
package org.ednovo.gooru.client.mvp.search.event;

import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDropController;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Search Team
 * 
 */
public class RegisterSearchDropEvent extends GwtEvent<RegisterSearchDropHandler> {

	public enum DROP_AREA {

		SHELF_ADD_COLLECTION("ShelfAddCollection"), SHELF("Shelf"), COLLECTION("Collection");

		String areaName;

		/**
		 * 
		 */
		private DROP_AREA(String areaName) {
			this.areaName = areaName;
		}

		public String getAreaName() {
			return areaName;
		}
	}

	public static final Type<RegisterSearchDropHandler> TYPE = new Type<RegisterSearchDropHandler>();

	ResourceDropController dropController;

	DROP_AREA type;

	/**
	 * Class constructor
	 */
	public RegisterSearchDropEvent(ResourceDropController searchDropController, DROP_AREA dropType) {
		this.dropController = searchDropController;
		this.type = dropType;
	}

	@Override
	public Type<RegisterSearchDropHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RegisterSearchDropHandler handler) {
		handler.registerDropController(dropController, type);
	}

}
