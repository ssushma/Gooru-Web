package org.ednovo.gooru.client.mvp.profilepage;

import org.ednovo.gooru.client.mvp.shelf.ShelfCBundle;

import com.google.gwt.core.client.GWT;
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
		wrapperFloPanel.getElement().setId("fpnlWrapperFloPanel");
		imageSimPanel.getElement().setId("spnlImageSimPanel");
		labelcount.getElement().setId("labelcount");
		labelLbl.getElement().setId("labelLbl");
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
		labelLbl.setText(label);
		labelLbl.getElement().setAttribute("alt",label);
		labelLbl.getElement().setAttribute("title",label);
	}

	public FlowPanel getWrapperFloPanel() {
		return wrapperFloPanel;
	}
	public void setLabelCount(String label)
	{
		labelcount.setText(label);
		labelcount.getElement().setAttribute("alt",label);
		labelcount.getElement().setAttribute("title",label);
	}
	public Label getLabelCount()
	{
		return labelcount;
		
	}
	/**
	 * @param style for image panel
	 */
	public void setImageStyle(String style) {
		imageSimPanel.setStyleName(style);
	}

	

}
