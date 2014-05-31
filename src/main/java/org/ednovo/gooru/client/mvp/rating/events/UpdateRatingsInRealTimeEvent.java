package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateRatingsInRealTimeEvent extends GwtEvent<UpdateRatingsInRealTimeHandler> {

	public static final Type<UpdateRatingsInRealTimeHandler> TYPE = new Type<UpdateRatingsInRealTimeHandler>();
	
	private String gooruOid;
	private double average;
	private Integer count;
	
	public UpdateRatingsInRealTimeEvent(String gooruOid, double average,Integer count) {
		this.gooruOid=gooruOid;
		this.average=average;
		this.count=count;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<UpdateRatingsInRealTimeHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateRatingsInRealTimeHandler handler) {
		handler.updateRatingInRealTime(gooruOid,average,count);
	}

}
