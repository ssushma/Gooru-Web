package org.ednovo.gooru.client.mvp.rating.events;


import com.google.gwt.event.shared.GwtEvent;

public class PostUserReviewEvent extends GwtEvent<PostUserReviewEventHandler> {

	public static final Type<PostUserReviewEventHandler> TYPE = new Type<PostUserReviewEventHandler>();
	
	String userReview="";
	String assocGooruOId="";
	Integer score;
	 boolean isUpdate;
	 
	public PostUserReviewEvent(String assocGooruOId, String userReview, Integer score, boolean isUpdate) { 
		this.assocGooruOId = assocGooruOId;
		this.userReview = userReview;
		this.score = score;
		this.isUpdate = isUpdate;
	}

	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<PostUserReviewEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(PostUserReviewEventHandler handler) {
		handler.postReview(assocGooruOId,userReview,score,isUpdate);
	}

}
