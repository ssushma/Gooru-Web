/**
 * 
 */
package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author janamitra
 *
 */
public class ScoreHedingView extends Composite {

	private static ScoreHedingViewUiBinder uiBinder = GWT
			.create(ScoreHedingViewUiBinder.class);

	interface ScoreHedingViewUiBinder extends UiBinder<Widget, ScoreHedingView> {
	}
	
	@UiField Label generalLabel;

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
	public ScoreHedingView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
