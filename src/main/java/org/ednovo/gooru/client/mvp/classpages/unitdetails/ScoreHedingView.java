/**
 * 
 */
package org.ednovo.gooru.client.mvp.classpages.unitdetails;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
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
	
	@UiField TextBox txtScore;

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
		txtScore.addBlurHandler(new ScoreHandler());
		txtScore.addKeyPressHandler(new HasNumbersOnly());
	}
	
	
	private class ScoreHandler implements BlurHandler{
		
		@Override
		public void onBlur(BlurEvent event) {
			String score = txtScore.getText();
			 if(score != null || score != ""){
				try{
					if(Integer.parseInt(score) >100 || Integer.parseInt(score) <=0){
						Window.alert("Give Between 1-100");
					}else{
						Window.alert("Good");
					}
				}catch(NumberFormatException numberFormatException){
					numberFormatException.printStackTrace();
				}
				
			}
		}
				
	}
	
	public class HasNumbersOnly implements KeyPressHandler {
	      
		@Override
		public void onKeyPress(KeyPressEvent event) {
				if (!Character.isDigit(event.getCharCode()) 
	                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_TAB 
	                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_BACKSPACE
	                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_SHIFT
	                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_ENTER
	                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_LEFT
	                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_RIGHT
	                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_DELETE){
	                ((TextBox) event.getSource()).cancelKey();
	            }
			  
					
		}
    }

}
