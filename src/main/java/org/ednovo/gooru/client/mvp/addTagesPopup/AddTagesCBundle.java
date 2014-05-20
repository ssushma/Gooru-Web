package org.ednovo.gooru.client.mvp.addTagesPopup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface AddTagesCBundle extends ClientBundle{
	static final AddTagesCBundle INSTANCE = GWT.create(AddTagesCBundle.class);
	public interface  AddTagesPopup extends CssResource{
		String popup();
		String popupInner();
		String popupHeader();
		String tag();
		String popupContent();
		String h5();
		String li();
		String clearfix();
		String qmark();
		String inputtype();
		String levelType();
		String sliderBg();
		String sliderLeft();
		String sliderRight();
		String sliderCircle();
		String levels();
		String levelnumbers();
		String select();
		String selectsection();
		String dropdown();
		String fRight();
		String OnButtonDeActive();
		String OffButtonsActive();
		String okcancel();
		String gwtSliderBarshell();
		
	}
	@NotStrict
	@Source("addTages.css")
	AddTagesPopup css();
}
