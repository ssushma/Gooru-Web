package org.ednovo.gooru.client.mvp.classpages.event;


import com.google.gwt.event.shared.GwtEvent;


public class GetStudentJoinListEvent extends GwtEvent<GetStudentJoinListHandler>{
public static final Type<GetStudentJoinListHandler> TYPE = new Type<GetStudentJoinListHandler>();
	
	int studentJoinList;
	
	public GetStudentJoinListEvent(int studentJoinList){
		this.studentJoinList = studentJoinList;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<GetStudentJoinListHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(GetStudentJoinListHandler handler) {
		handler.getStudentJoinList(studentJoinList);
		
	}

}
