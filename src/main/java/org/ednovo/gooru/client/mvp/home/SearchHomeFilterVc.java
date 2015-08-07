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
package org.ednovo.gooru.client.mvp.home;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.home.HomeCBundle;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.search.SearchFilterDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class SearchHomeFilterVc extends Composite{

	private static SearchHomeFilterVcUiBinder uiBinder = GWT.create(SearchHomeFilterVcUiBinder.class);

	interface SearchHomeFilterVcUiBinder extends UiBinder<Widget, SearchHomeFilterVc> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField
	FlowPanel filterGradeFloPanel;

	@UiField
	FlowPanel filterColOneResourceTypeFloPanel;

	@UiField
	FlowPanel filterColTwoResourceTypeFloPanel;

	@UiField
	FlowPanel filterSubjectFloPanel;

	@UiField(provided = true)
	HomeCBundle res;

	private CheckBox filterCheBox;

	@UiField Label filterOptionsLbl,standardText,sourceLbl;

	/**
	 * Class constructor
	 */
	public SearchHomeFilterVc() {
		this.res = HomeCBundle.INSTANCE;
		res.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		filterOptionsLbl.setText(i18n.GL1309().toUpperCase());
		filterOptionsLbl.getElement().setId("lblFilterOptions");
		filterOptionsLbl.getElement().setAttribute("alt",i18n.GL1309().toUpperCase());
		filterOptionsLbl.getElement().setAttribute("title",i18n.GL1309().toUpperCase());

		standardText.setText(i18n.GL0724().toUpperCase());
		standardText.getElement().setId("lblStandardText");
		standardText.getElement().setAttribute("alt",i18n.GL0724().toUpperCase());
		standardText.getElement().setAttribute("title",i18n.GL0724().toUpperCase());

		sourceLbl.setText(i18n.GL0566().toUpperCase()+" ");
		sourceLbl.getElement().setId("lblSourceLbl");
		sourceLbl.getElement().setAttribute("alt",i18n.GL0566().toUpperCase()+" ");
		sourceLbl.getElement().setAttribute("title",i18n.GL0566().toUpperCase()+" ");

		filterGradeFloPanel.getElement().setId("fpnlFilterGradeFloPanel");
		filterColOneResourceTypeFloPanel.getElement().setId("fpnlFilterColOneResourceTypeFloPanel");
		filterColTwoResourceTypeFloPanel.getElement().setId("fpnlFilterColTwoResourceTypeFloPanel");
		filterSubjectFloPanel.getElement().setId("fpnlFilterSubjectFloPanel");
	}

	/**
	 * Create filter widget such as grade , subject, resource type
	 * @param filterList instance of {@link SearchFilterDo}
	 */
	public void setData(SearchFilterDo filterList) {
		Collection<String> categories = filterList.getCategories().values();
		List<String> subjects = filterList.getSubjects();

		Label gradeLabel = new Label(i18n.GL1076().toUpperCase());
		gradeLabel.setStyleName(HomeCBundle.INSTANCE.css().filterSubHeader());
		filterGradeFloPanel.clear();
		filterGradeFloPanel.add(gradeLabel);
		Iterator<Map.Entry<String, String>> gradesIterator = filterList.getGradeLevels().entrySet().iterator();
		while (gradesIterator.hasNext()) {
			Map.Entry<String, String> entry = gradesIterator.next();
			filterCheBox = new CheckBox();
			filterCheBox.setText(entry.getValue());
			filterCheBox.setStyleName("filterCheckBox");
			filterGradeFloPanel.add(filterCheBox);
		}

		Label categoryLabel = new Label(i18n.GL1310().toUpperCase());
		categoryLabel.setStyleName(HomeCBundle.INSTANCE.css().filterSubHeader());
		filterColOneResourceTypeFloPanel.clear();
		filterColTwoResourceTypeFloPanel.clear();
		filterColOneResourceTypeFloPanel.add(categoryLabel);

		int i = 0;
		for (String category : categories) {
			filterCheBox = new CheckBox();
			filterCheBox.setText(category);
			filterCheBox.setStyleName("filterCheckBox");
			if (i < 4) {
				filterColOneResourceTypeFloPanel.add(filterCheBox);
			} else {
				filterColTwoResourceTypeFloPanel.add(filterCheBox);
			}
			i++;
		}

		Label subjectLabel = new Label(i18n.GL1311().toUpperCase());
		subjectLabel.setStyleName(HomeCBundle.INSTANCE.css().filterSubHeader());
		filterSubjectFloPanel.clear();
		filterSubjectFloPanel.add(subjectLabel);
		for (String subject : subjects) {
			filterCheBox = new CheckBox();
			filterCheBox.setText(subject);
			filterCheBox.setStyleName("filterCheckBox");
			filterSubjectFloPanel.add(filterCheBox);
		}
	}

	/**
	 * Set filters for search
	 * @return search filter as Map
	 */
	public Map<String, String> getFilter() {
		Map<String, String> filterMap = new HashMap<String, String>();
		String selectedGrade = getSelectedFilter(filterGradeFloPanel);
		if (!selectedGrade.isEmpty()) {
			filterMap.put("grade", selectedGrade);
		}
		String selectedOneResourceType = getSelectedFilter(filterColOneResourceTypeFloPanel);
		String selectedTwoResourceType = getSelectedFilter(filterColTwoResourceTypeFloPanel);

		String category = "";
		if (!selectedOneResourceType.isEmpty()) {
			category += selectedOneResourceType;
		}
		if (!selectedTwoResourceType.isEmpty()) {
			if (category.length() > 0) {
				category += ",";
			}
			category += selectedTwoResourceType;
		}
		if (category.length() > 0) {
			filterMap.put("category", category);
		}
		String selectedSubject = getSelectedFilter(filterSubjectFloPanel);
		if (!selectedSubject.isEmpty()) {
			filterMap.put("subject", selectedSubject);
		}

		return filterMap;
	}

	/**
	 * Get selected filters
	 * @param filterFlowPanel to get selected filters
	 * @return selected filter name as string
	 */
	private String getSelectedFilter(FlowPanel filterFlowPanel) {
		String selectedFilter = "";
		for (Widget filterWidget : filterFlowPanel) {
			if (filterWidget instanceof CheckBox) {
				CheckBox filterCheckBox = (CheckBox) filterWidget;
				if (filterCheckBox != null && filterCheckBox.getValue()) {
					if (!selectedFilter.isEmpty()) {
						selectedFilter += ",";
					}
					selectedFilter += filterCheckBox.getText();
				}
			}
		}
		return selectedFilter;
	}

	/**
	 * set filters
	 * @param filter to get filter value
	 */
	public void setFilter(Map<String, String> filter) {
		String grade = filter.get("grade");
		setSelectedFilter(filterGradeFloPanel, grade);
		String categories = filter.get("category");
		setSelectedFilter(filterColOneResourceTypeFloPanel, categories);
		String subjects = filter.get("subject");
		setSelectedFilter(filterColOneResourceTypeFloPanel, subjects);
	}

	/**
	 * set enabled or disabled for for filters
	 * @param filterFlowPanel selected filter panel
	 * @param checkedValues selected filter values
	 */
	private void setSelectedFilter(FlowPanel filterFlowPanel, String checkedValues) {
		List<String> items = Arrays.asList(checkedValues.split("\\s*,\\s*"));
		for (Widget filterWidget : filterFlowPanel) {
			if (filterWidget instanceof CheckBox) {
				CheckBox filterCheckBox = (CheckBox) filterWidget;
				for (String item : items) {
					if (filterCheckBox != null && (filterCheckBox.getValue().equals(item))) {
						filterCheckBox.setEnabled(true);
					}
				}
			}
		}
	}
}
