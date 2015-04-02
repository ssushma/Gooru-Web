/**
 * 
 */
package org.ednovo.gooru.client.uc.tooltip;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


public class SearchDragToolTip extends Composite {
	

	
	@UiField
	Label desLbl;
	
	@UiField
	Image searchDragToolTipImage;

	private static SearchDragToolTipUiBinder uiBinder = GWT.create(SearchDragToolTipUiBinder.class);
	
	interface SearchDragToolTipUiBinder extends	UiBinder<Widget, SearchDragToolTip> {
	}

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public SearchDragToolTip(String description) {
		initWidget(uiBinder.createAndBindUi(this));
		searchDragToolTipImage.setUrl("images/SearchDragImages/minus.png");
		searchDragToolTipImage.getElement().setId("imgSearchDragToolTipImage");
		
		desLbl.setText(description);
		desLbl.getElement().setId("lblDesLbl");
		desLbl.getElement().setAttribute("alt", description);
		desLbl.getElement().setAttribute("title", description);
		
	}

}
