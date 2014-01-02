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
package org.ednovo.gooru.client.mvp.home.library;

import org.ednovo.gooru.shared.model.library.UnitDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : LibraryUnitMenuView.java
 *
 * @description : This class will display the library unit data.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class LibraryUnitMenuView extends Composite {

	@UiField Label unitMenuItem;
	
	private String unitId;
	
	private static LibraryUnitMenuViewUiBinder uiBinder = GWT
			.create(LibraryUnitMenuViewUiBinder.class);

	interface LibraryUnitMenuViewUiBinder extends
			UiBinder<Widget, LibraryUnitMenuView> {
	}
	/**
	 * Class constructor.
	 * @param unitDo
	 */
	public LibraryUnitMenuView(UnitDo unitDo) {
		initWidget(uiBinder.createAndBindUi(this));
		unitMenuItem.setText(unitDo.getLabel());
		setUnitId(""+unitDo.getCodeId());
	}
	/**
	 * @function getUnitMenuItemPanel 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This will return the unit menu item panel.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : Label
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public Label getUnitMenuItemPanel() {
		return unitMenuItem;
	}
	/**
	 * @function getUnitId 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method will return the unit id.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getUnitId() {
		return unitId;
	}
	/**
	 * @function setUnitId 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method will set the unit id.
	 * 
	 * @parm(s) : @param unitId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
}
