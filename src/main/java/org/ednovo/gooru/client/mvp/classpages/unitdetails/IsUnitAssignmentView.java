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
package org.ednovo.gooru.client.mvp.classpages.unitdetails;
import java.util.List;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.InsightsUserDataDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.user.client.ui.HTMLPanel;

public interface IsUnitAssignmentView extends IsViewWithHandlers<UnitAssignmentUiHandlers>{
	void getSequence(UnitAssignmentsDo unitAssignmentsDo);
	void getPathwayItems();
	public void showUnitNames(ClassDo classDo,boolean clearPanel);
	public void hideMoreUnitsLink();
	public HTMLPanel getUnitPanel(); public HTMLPanel getCircleContainerPanel();
	public void showAssignment(ClasspageItemDo classpageItemDo);
	void showDashBoard();
	void showAssignments();
	public void getUnitsPanel();
	void scoreHederView(ClassUnitsListDo classUnitsListDo);
	public void resetUnitAssignmentView();
	public HTMLPanel getAssignmentPanel();
	public void setCollectionSummaryData(CollectionSummaryMetaDataDo collectionSummaryMetaDataDo);
	void clearValues();
	void setInsightUserData(List<InsightsUserDataDo> insightsUserList);

}