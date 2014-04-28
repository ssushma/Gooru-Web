package org.ednovo.gooru.client.uc.tooltip;

import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class LibraryTopicCollectionToolTip extends Composite implements MessageProperties{
	
	
	public interface DiscoverToolTipUiBinder extends UiBinder<Widget, LibraryTopicCollectionToolTip>{
		
	}
	
	public static DiscoverToolTipUiBinder discoverToolTipUiBinder=GWT.create(DiscoverToolTipUiBinder.class);
	
	
	@UiField HTMLPanel arowPanel;
	
	@UiField HTML descPanel;
	
	@UiField FlowPanel textFlowPanel,organizePopupTextContainer;
	
	@UiField Label sourceLbl;
	
	@UiField HTML categoryLbl;

	public LibraryTopicCollectionToolTip(){
		initWidget(discoverToolTipUiBinder.createAndBindUi(this));
		arowPanel.setVisible(false);
		descPanel.setHTML(GL0532);
		categoryLbl.setHTML(GL1063);
	}
	
	public LibraryTopicCollectionToolTip(String title, String category, String source){
		initWidget(discoverToolTipUiBinder.createAndBindUi(this));
		if(category!=null){
			if(category.equalsIgnoreCase("Lesson") ||category.equalsIgnoreCase("Textbook")|| category.equalsIgnoreCase("Handout") )
			{
				category=category.replaceAll("Lesson", "Text").replaceAll("Textbook", "Text").replaceAll("Handout", "Text").replaceAll("lesson", "Text").replaceAll("textbook", "Text").replaceAll("handout", "Text");
			}
			if(category.equalsIgnoreCase("Slide"))
			{
				category=category.replaceAll("Slide","Image").replaceAll("slide","Image");
			}
			if(category.equalsIgnoreCase("Exam") || category.equalsIgnoreCase("Challenge")|| category.equalsIgnoreCase("Website")||category.equalsIgnoreCase("webpage"))
			{
				category=category.replaceAll("Exam","Webpage").replaceAll("Challenge", "Webpage").replaceAll("exam","Webpage").replaceAll("challenge", "Webpage").replaceAll("Website", "Webpage").replaceAll("website", "Webpage");
			}
		}
//		arowPanel.getElement().getStyle().setDisplay(Display.NONE);
		arowPanel.setVisible(true);
		descPanel.setVisible(true);
		descPanel.setHTML(title);
		categoryLbl.setHTML(category);
		sourceLbl.setText(source);
	}
	
	public LibraryTopicCollectionToolTip(String content){
		initWidget(discoverToolTipUiBinder.createAndBindUi(this));
    	descPanel.setVisible(false);
		arowPanel.setVisible(true);
		textFlowPanel.getElement().getStyle().setWidth(208, Unit.PX);
		categoryLbl.setHTML(content);
	}
	public LibraryTopicCollectionToolTip(String content,String position){
		initWidget(discoverToolTipUiBinder.createAndBindUi(this));
		descPanel.setVisible(false);
		arowPanel.setVisible(true);
		if (position.equalsIgnoreCase("studyView")) {
			arowPanel.getElement().setAttribute("style", "margin-left: 203px;");
			textFlowPanel.getElement().getStyle().setWidth(233, Unit.PX);
			categoryLbl.setHTML(content);
		} else {
			arowPanel.getElement().setAttribute("style", "margin-left: 19px;");
			textFlowPanel.getElement().getStyle().setWidth(164, Unit.PX);
			organizePopupTextContainer.getElement().setAttribute("style",
					"margin-left: -132px;padding: 0px;");
			categoryLbl.setHTML(content);
		}
	}
	
}
