package org.ednovo.gooru.client.mvp.gshelf.util;

import org.ednovo.gooru.client.SimpleRunAsyncCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class ContentResourceWidgetWithMove extends Composite {

	private static ContentResourceWidgetWithMoveUiBinder uiBinder = GWT
			.create(ContentResourceWidgetWithMoveUiBinder.class);

	interface ContentResourceWidgetWithMoveUiBinder extends
			UiBinder<Widget, ContentResourceWidgetWithMove> {
	}
	
	@UiField Label lblTopArrow,lblDownArrow;
	@UiField HTMLPanel pnlArrows;
	@UiField TextBox txtMoveTextBox;
	
	public ContentResourceWidgetWithMove(int index) {
		initWidget(uiBinder.createAndBindUi(this));
		lblTopArrow.addClickHandler(new ArrowClickHandler(false));
		lblDownArrow.addClickHandler(new ArrowClickHandler(true));
		setData(index);
	}
	public void setData(int index){
		int indexVal=index+1;
		if(indexVal==1){
			lblTopArrow.setVisible(false);
		}
		txtMoveTextBox.setText(indexVal+"");
		txtMoveTextBox.getElement().setAttribute("index",index+"");
		//txtMoveTextBox.getElement().setAttribute("moveId",folderObj.getCollectionItemId()+"");
		txtMoveTextBox.addKeyPressHandler(new HasNumbersOnly()); 
		txtMoveTextBox.addKeyUpHandler(new ReorderText()); 
		//This blur handler reset the previous value when the text box value is empty.
		txtMoveTextBox.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				String enteredString=txtMoveTextBox.getText().toString().trim();
				String currentWidgetString=txtMoveTextBox.getElement().getAttribute("index").trim();
				if(enteredString.isEmpty()){
					txtMoveTextBox.setText((Integer.parseInt(currentWidgetString)+1)+"");
				}
			}
		});
	}
	/**
	 * This inner class used for disabling up and down arrow based on user entered reorder value.
	 */
	public class ReorderText implements KeyUpHandler {
		@Override
		public void onKeyUp(KeyUpEvent event) {
			String enteredString=txtMoveTextBox.getText().toString().trim();
			String currentWidgetString=txtMoveTextBox.getElement().getAttribute("index");
			if(!enteredString.isEmpty()){
				int enteredValue=Integer.parseInt(enteredString);
				int currentWidgetValue=Integer.parseInt(currentWidgetString)+1;
				if(currentWidgetValue==enteredValue){
					lblDownArrow.setVisible(true);
					lblTopArrow.setVisible(true);
				}else if(currentWidgetValue>enteredValue){
					lblDownArrow.setVisible(false);
					lblTopArrow.setVisible(true);
				}else{
					lblTopArrow.setVisible(false);
					lblDownArrow.setVisible(true);
				}
			}
		}
	}
	/**
	 * This inner class used for to restrict text box values to have only numbers
	 *
	 */
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
			if (event.getNativeEvent().getKeyCode() == 46
					|| event.getNativeEvent().getKeyCode() == 37) {
				((TextBox) event.getSource()).cancelKey();
			}
		}
	}
	/**
	 * This inner class will handle the click event on the Arrows
	 */
	class ArrowClickHandler implements ClickHandler{
		boolean isDownArrow;
		ArrowClickHandler(boolean isDownArrow){
			this.isDownArrow=isDownArrow;
		}
		@Override
		public void onClick(ClickEvent event) {
			GWT.runAsync(new SimpleRunAsyncCallback() {
				@Override
				public void onSuccess() {
					String movingPosition=txtMoveTextBox.getText().toString().trim();
					String currentWidgetPosition=txtMoveTextBox.getElement().getAttribute("index").trim();
					String moveId=txtMoveTextBox.getElement().getAttribute("moveId");
					if(!movingPosition.isEmpty()){
						int movingValue=Integer.parseInt(movingPosition);
						int currentWidgetValue=Integer.parseInt(currentWidgetPosition);
						//This one will execute when user enter a number in text field and click on either up and down arrow.
						if(movingValue!=(currentWidgetValue+1)){
							moveWidgetPosition(movingPosition,currentWidgetPosition,isDownArrow,moveId);
						}else if(movingValue==(currentWidgetValue+1)){
							//This one will execute when user directly clicks on either up and down arrow.
							if(isDownArrow){
								moveWidgetPosition((movingValue+1)+"",currentWidgetPosition,isDownArrow,moveId);
							}else{
								moveWidgetPosition((movingValue-1)+"",currentWidgetPosition,isDownArrow,moveId);
							}
						}
					}
				}
			});
		}
	}
	public Label getTopArrow(){
		return lblTopArrow;
	}
	public Label getDownArrow(){
		return lblDownArrow;
	}
	public abstract void moveWidgetPosition(String movingPosition,String currentWidgetPosition,boolean isDownArrow,String moveId);
}
