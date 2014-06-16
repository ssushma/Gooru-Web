package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.rating.RatingWidgetView;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.user.UserTagsResourceDO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Image;

public class ProfileUserTagsResourceWidget extends Composite {

	private static ProfileUserTagsResourceWidgetUiBinder uiBinder = GWT
			.create(ProfileUserTagsResourceWidgetUiBinder.class);

	interface ProfileUserTagsResourceWidgetUiBinder extends
			UiBinder<Widget, ProfileUserTagsResourceWidget> {
	}
	@UiField Label resourceType,resourceSource;
	@UiField HTMLPanel ratingContainer;
	@UiField Image resourceImage,resourceTypeIcon;
	@UiField HTML resourceTitle;
	RatingWidgetView ratingWidgetView;
	private String resourceTypeImage;
	List<UserTagsResourceDO> listOfTagsResource =new ArrayList<UserTagsResourceDO>();
	
	public ProfileUserTagsResourceWidget(UserTagsResourceDO userTagsResourceDO) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(userTagsResourceDO);
	}

	
	public void setData(UserTagsResourceDO userTagsResourceDO)
	{
		resourceTitle.setHTML(removeHtmlTags(userTagsResourceDO.getTitle()));
		resourceType.setText(userTagsResourceDO.getResourceFormat().getValue());
		resourceTypeImage=userTagsResourceDO.getResourceFormat().getValue();
		setPublisger(userTagsResourceDO.getPublisher());
		resourceImage.setUrl(userTagsResourceDO.getThumbnails());
		if(userTagsResourceDO.getResourceFormat()!=null){
			setResourceTypeImage(userTagsResourceDO.getResourceFormat().getValue());
		}
		setAvgRatingWidget(userTagsResourceDO.getRatings().getCount(),userTagsResourceDO.getRatings().getAverage());
		
	}
	private void setAvgRatingWidget(int ratingCount,double averageRating) {
		ratingContainer.clear();
		ratingWidgetView=new RatingWidgetView();
		ratingWidgetView.getRatingCountLabel().setText(ratingCount+"");
		ratingWidgetView.setAvgStarRating(averageRating);
		ratingContainer.add(ratingWidgetView);
	}
	public void setResourceTypeImage(String resourceType){
		if(resourceType!=null){
			resourceType=resourceType.toLowerCase();
			if(resourceType.equalsIgnoreCase("lesson")||resourceType.equalsIgnoreCase("textbook")||resourceType.equalsIgnoreCase("handout"))
			{
				resourceType=resourceType.replaceAll("lesson", "Text").replaceAll("textbook", "Text").replaceAll("handout", "Text");
			}
			if(resourceType.equalsIgnoreCase("slide"))
			{
				resourceType=resourceType.replaceAll("slide","Image");
			}
			if(resourceType.equalsIgnoreCase("exam")||resourceType.equalsIgnoreCase("challenge")||resourceType.equalsIgnoreCase("website"))
			{
				resourceType=resourceType.replaceAll("exam","Webpage").replaceAll("challenge", "Webpage").replaceAll("website", "Webpage");
			}
			//lblresourceType.setText(resourceType);
			resourceTypeIcon.setStyleName(getResourceTypeImage(resourceType));
		}
	}

	private String removeHtmlTags(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		return html;
	}

	public String getResourceTypeImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")||resourceType.equalsIgnoreCase("Videos")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceTypeInfo();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("Website")||resourceType.equalsIgnoreCase("Webpage")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceTypeInfo();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")){
			return PlayerBundle.INSTANCE.getPlayerStyle().imageResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("lesson")){
			return PlayerBundle.INSTANCE.getPlayerStyle().lessonResourceTypeInfo();

		}else if(resourceType.equalsIgnoreCase("Handout")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceTypeInfo();
		} else if(resourceType.equalsIgnoreCase("text")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("image")){
			return PlayerBundle.INSTANCE.getPlayerStyle().imageResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("audio")){
			return PlayerBundle.INSTANCE.getPlayerStyle().audioResourceTypeInfo();
		}else if(resourceType.equalsIgnoreCase("exam")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceTypeInfo();
		}
		else {
			return PlayerBundle.INSTANCE.getPlayerStyle().otherResourceTypeInfo();
		}
	}
	public void setPublisger(List<String> publisher){
	if(publisher!=null){
		 String publisherValue= "";
		for (String publisherData: publisher) {
			if(publisher.size()>1){
				publisherValue = publisherValue+publisherData+",";
			}
			else
			{
				publisherValue = publisherData;
			}
		}
		if(publisherValue.endsWith(",")){
			publisherValue=publisherValue.substring(0, publisherValue.length()-1);
		}
		resourceSource.setText(publisherValue);
	}
	}
	@UiHandler("resourceImage")
	public void onErrorResourceImage(ErrorEvent errorEvent){
		resourceImage.setUrl("images/resource_trans.png");
		resourceTypeImage=resourceTypeImage.toLowerCase();
		if(resourceTypeImage.equalsIgnoreCase("lesson")||resourceTypeImage.equalsIgnoreCase("textbook")||resourceTypeImage.equalsIgnoreCase("handout"))
		{
			resourceTypeImage=resourceTypeImage.replaceAll("lesson", "text").replaceAll("textbook", "text").replaceAll("handout", "text");
		}
		if(resourceTypeImage.equalsIgnoreCase("slide"))
		{
			resourceTypeImage=resourceTypeImage.replaceAll("slide","image");
		}
		if(resourceTypeImage.equalsIgnoreCase("exam")||resourceTypeImage.equalsIgnoreCase("website") || resourceTypeImage.equalsIgnoreCase("challenge"))
		{
			resourceTypeImage=resourceTypeImage.replaceAll("exam","webpage").replaceAll("website","webpage").replaceAll("challenge","webpage");
		}
		resourceImage.setStyleName(getResourceDefaultImage(resourceTypeImage));
	}
	
	public String getResourceDefaultImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")||resourceType.equalsIgnoreCase("Videos")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceDefault();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Website")||resourceType.equalsIgnoreCase("Exam")||resourceType.equalsIgnoreCase("Webpage")|| resourceType.equalsIgnoreCase("challenge")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceDefault();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")||resourceType.equalsIgnoreCase("Image")){
			return PlayerBundle.INSTANCE.getPlayerStyle().imageResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")||resourceType.equalsIgnoreCase("lesson")||resourceType.equalsIgnoreCase("Handout")||resourceType.equalsIgnoreCase("Text")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Audio")){
			return PlayerBundle.INSTANCE.getPlayerStyle().audioResourceDefault();
		}else if(resourceType.equalsIgnoreCase("Other")){
			return PlayerBundle.INSTANCE.getPlayerStyle().otherResourceDefault();
		}else {
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceDefault();
		}
	}
}
