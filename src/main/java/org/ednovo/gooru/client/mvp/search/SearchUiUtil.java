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
package org.ednovo.gooru.client.mvp.search;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.SeparatorUc;
import org.ednovo.gooru.client.uc.StandardSgItemVc;
import org.ednovo.gooru.client.uc.UcCBundle;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

/**
 * 
 * @fileName : SearchUiUtil.java
 *
 * @description : To render the metadata.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SearchUiUtil {

	public static final String STANDARD_CODE = "code";

	public static final String STANDARD_DESCRIPTION = "description";
	/**
	 * 
	 * @function renderStandards 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is to render the standards.
	 * 
	 * 
	 * @parm(s) : @param standardsContainer
	 * @parm(s) : @param searchResultDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public static void renderStandards(FlowPanel standardsContainer, ResourceSearchResultDo searchResultDo) {
		if (searchResultDo.getStandards() != null) {
			List<Map<String, String>> standards = searchResultDo.getStandards();
			Iterator<Map<String, String>> iterator = standards.iterator();
			int count = 0;
			FlowPanel toolTipwidgets = new FlowPanel();
			while (iterator.hasNext()) {
				Map<String, String> standard = iterator.next();
				String stdCode = standard.get(STANDARD_CODE);
				String stdDec = standard.get(STANDARD_DESCRIPTION);
				if (count > 2) {
					if (count < 18){
						StandardSgItemVc standardItem = new StandardSgItemVc(stdCode, stdDec);
						toolTipwidgets.add(standardItem);
					}
				} else {
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label(stdCode), new Label(stdDec), standards);
					toolTipUc.setStyleName(UcCBundle.INSTANCE.css().searchStandard());
					standardsContainer.add(toolTipUc);
				}
				count++;
			}
			if (standards.size()>18){
				final Label left = new Label("+"+(standards.size() - 18));
				toolTipwidgets.add(left);
			}
			if (searchResultDo.getStandards().size() > 3) {
				Integer moreStandardsCount = searchResultDo.getStandards().size() - 3;
				DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label("+" + moreStandardsCount), toolTipwidgets, standards);
				toolTipUc.setStyleName(SearchResultWrapperCBundle.INSTANCE.css().blueLink());
				standardsContainer.add(toolTipUc);
			}
		}
	}
	/*public static void renderPPPStandards(FlowPanel standardsContainer,CollectionItemDo collectionItemDo) {
		if (collectionItemDo.getStandards() != null) {
			List<Map<String, String>> standards = collectionItemDo.getStandards();
			Iterator<Map<String, String>> iterator = standards.iterator();
			int count = 0;
			FlowPanel toolTipwidgets = new FlowPanel();
			while (iterator.hasNext()) {
				Map<String, String> standard = iterator.next();
				String stdCode = standard.get(STANDARD_CODE);
				String stdDec = standard.get(STANDARD_DESCRIPTION);
				if (count > 2) {
					StandardSgItemVc standardItem = new StandardSgItemVc(stdCode, stdDec);
					toolTipwidgets.add(standardItem);
				} else {
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label(stdCode), new Label(stdDec));
					toolTipUc.setStyleName(UcCBundle.INSTANCE.css().searchStandard());
					standardsContainer.add(toolTipUc);
				}
				count++;
			}
			if (collectionItemDo.getStandards().size() > 3) {
				Integer moreStandardsCount = collectionItemDo.getStandards().size() - 3;
				DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label("+" + moreStandardsCount), toolTipwidgets);
				toolTipUc.setStyleName(SearchResultWrapperCBundle.INSTANCE.css().blueLink());
				standardsContainer.add(toolTipUc);
			}
		}
	}*/
	
	
	/**
	 * 
	 * @function renderMetaData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :To call render metadata by sending flowpanel and data as input.
	 * 
	 * 
	 * @parm(s) : @param flowPanel
	 * @parm(s) : @param data
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public static void renderMetaData(FlowPanel flowPanel, String data) {
		renderMetaData(flowPanel, data, null, -1);
	}

	/*public static void renderMetaData(FlowPanel flowPanel, String data, int wrapLength) {
		renderMetaData(flowPanel, data, null, wrapLength);
	}*/
	/**
	 * 
	 * @function renderMetaData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :To call render metadata by sending flowpanel,data and suffix as input.
	 * 
	 * 
	 * @parm(s) : @param flowPanel
	 * @parm(s) : @param data
	 * @parm(s) : @param suffix
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public static void renderMetaData(FlowPanel flowPanel, String data, String suffix) {
		renderMetaData(flowPanel, data, suffix, -1);
	}

	/*public static void renderMetaData(FlowPanel flowPanel, List<String> datas) {
		renderMetaData(flowPanel, datas, -1);
	}*/
	/**
	 * 
	 * @function renderMetaData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :To call render metadata by sending flowpanel,data,suffix and wrapLength as input.
	 * 
	 * 
	 * @parm(s) : @param flowPanel
	 * @parm(s) : @param datas
	 * @parm(s) : @param wrapLength
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public static void renderMetaData(FlowPanel flowPanel, List<String> datas, int wrapLength) {
		if (datas == null) {
			return;
		}
		renderMetaData(flowPanel, datas.size() > 0 ? datas.get(0) : null, null, wrapLength);
		FlowPanel toolTipwidgets = new FlowPanel();
		FlowPanel toolTipwidget1 = new FlowPanel();
		for (int count = 0; count < datas.size(); count++) {
			Label label = new Label(datas.get(count));
			label.setStyleName(SearchResultWrapperCBundle.INSTANCE.css().moreMetaLbl());
			if(count==0){
				toolTipwidget1.add(label);
			}else{
				toolTipwidgets.add(label);
			}
			
		}
		if (datas != null && datas.size() > 1) {
			Integer moreCount = datas.size() - 1;
			DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label("+" + moreCount), toolTipwidgets);
			toolTipUc.setStyleName(SearchResultWrapperCBundle.INSTANCE.css().blueLinkPad());
			flowPanel.add(toolTipUc);
		}
	}
	/**
	 * 
	 * @function renderMetaData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :To call render metadata by sending flowpanel,data,suffix and wrapLength as input and if wrapLength>0 need to set data and if suffix is not null appending suffix to data,adding data to label
	 * .and calling renderMetaData by passing flowPanel and label as arguments.
	 * 
	 * 
	 * @parm(s) : @param flowPanel
	 * @parm(s) : @param data
	 * @parm(s) : @param suffix
	 * @parm(s) : @param wrapLength
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public static void renderMetaData(FlowPanel flowPanel, String data, String suffix, int wrapLength) {
		if (suffix != null || StringUtil.hasValidString(data)) {
			if (wrapLength > 0) {
				data = StringUtil.truncateText(data, wrapLength);
			}
			if (suffix != null) {
				data += suffix;
			}
			Label label = new Label(data);
			label.setStyleName(CssTokens.FLOAT_LEFT);
			renderMetaData(flowPanel, label);
		}
	}
	/**
	 * 
	 * @function renderMetaData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :To call render metadata by sending flowpanel,data,suffix and wrapLength as input and if wrapLength>0 need to set data and if suffix is not null appending suffix to data,adding data to label
	 * .and calling renderMetaData by passing flowPanel and label as arguments.
	 * 
	 * 
	 * @parm(s) : @param flowPanel
	 * @parm(s) : @param data
	 * @parm(s) : @param suffix
	 * @parm(s) : @param wrapLength
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public static void renderSourceMetadata(FlowPanel flowPanel,String data,String suffix, int wrapLength){
		if (suffix != null || StringUtil.hasValidString(data)) {
			if (wrapLength > 0) {
				data = StringUtil.truncateText(data, wrapLength);
			}
			if (suffix != null) {
				data += suffix;
			}
			HTMLPanel label = new HTMLPanel(data);
			label.setStyleName(CssTokens.FLOAT_LEFT);
			renderMetaData(flowPanel, label);
		}
	}
	/**
	 * 
	 * @function renderMetaData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :To call render metadata by passing flowpanel and widget as inputs.
	 * 
	 * 
	 * @parm(s) : @param flowPanel
	 * @parm(s) : @param widget
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public static void renderMetaData(FlowPanel flowPanel, IsWidget widget) {
		if (flowPanel.iterator().hasNext()) {
			flowPanel.add(new SeparatorUc());
		}
		flowPanel.add(widget);
	}



	

}
