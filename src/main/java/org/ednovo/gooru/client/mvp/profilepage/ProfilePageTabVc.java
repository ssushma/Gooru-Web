package org.ednovo.gooru.client.mvp.profilepage;

import org.ednovo.gooru.client.mvp.shelf.ShelfCBundle;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePageTabVc extends FocusPanel {

	private static ProfilePageTabVc selectedTabTitleVc;
	
	private static ProfilePageTabVcUiBinder uiBinder = GWT
			.create(ProfilePageTabVcUiBinder.class);

	interface ProfilePageTabVcUiBinder extends
			UiBinder<Widget, ProfilePageTabVc> {
	}
	@UiField
	Label labelLbl,labelcount;

	@UiField
	FlowPanel wrapperFloPanel;
	
	@UiField
	SimplePanel imageSimPanel;
	
	String title ="";
	
	public ProfilePageTabVc() {
		setWidget(uiBinder.createAndBindUi(this));
	}

	/** 
	 * @param enable decides to add or remove activeClass style
	 */
	public void setSelected(boolean enable) {
		if (selectedTabTitleVc != null && !selectedTabTitleVc.equals(this)) {
			selectedTabTitleVc.setSelected(false);
		}
		String activeCss;
		
		activeCss = ShelfCBundle.INSTANCE.css().profileMetaDataTabTitleActive();
		if (title.equalsIgnoreCase("share")){
			wrapperFloPanel.getElement().getStyle().setPaddingTop(9.0, Unit.PX);
/*			wrapperFloPanel.getElement().getStyle().setPaddingRight(5.4, Unit.PCT);
*/			wrapperFloPanel.getElement().getStyle().setPaddingBottom(9.0, Unit.PX);
		}
		
		if (enable) {
			wrapperFloPanel.addStyleName(activeCss);
		} else {
			wrapperFloPanel.removeStyleName(activeCss);
		}
		selectedTabTitleVc = this;
	}

	public void setEnabled(boolean enabled) {
		if(enabled) {
			wrapperFloPanel.setStyleName(ShelfCBundle.INSTANCE.css().profileMetaDataTabTitle());
		} else {
			wrapperFloPanel.setStyleName(ShelfCBundle.INSTANCE.css().profileMetaDataTabTitleDisabled());
		}
	}
	
	/**
	 * @param label name of label
	 */
	public void setLabel(String label) {
		title = label;
		/*if (title !=null &&  (title.equalsIgnoreCase("share") || title.contains("Collaborator"))){
			wrapperFloPanel.getElement().getStyle().setPaddingTop(9.0, Unit.PX);
			wrapperFloPanel.getElement().getStyle().setPaddingRight(5.4, Unit.PCT);
			wrapperFloPanel.getElement().getStyle().setPaddingBottom(9.0, Unit.PX);
		}*/
		labelLbl.setText(label);
	}

	public FlowPanel getWrapperFloPanel() {
		return wrapperFloPanel;
	}
	public void setLabelCount(String label)
	{
		labelcount.setText(label);
		
	}
	/**
	 * @param style for image panel
	 */
	public void setImageStyle(String style) {
		imageSimPanel.setStyleName(style);
	}

	

}
