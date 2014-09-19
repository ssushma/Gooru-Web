package org.ednovo.gooru.client.mvp.analytics.collectionSummary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryUsersDataDo;
import org.ednovo.gooru.shared.model.analytics.UserDataDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CollectionSummaryView  extends BaseViewWithHandlers<CollectionSummaryUiHandlers> implements IsCollectionSummaryView {

	private static CollectionSummaryViewUiBinder uiBinder = GWT
			.create(CollectionSummaryViewUiBinder.class);

	interface CollectionSummaryViewUiBinder extends
			UiBinder<Widget, CollectionSummaryView> {
	}

	CollectionSummaryCBundle res;
	
	@UiField ListBox studentsListDropDown,sessionsDropDown;
	@UiField Image collectionImage;
	@UiField InlineLabel collectionTitle,collectionResourcesCount,collectionLastAccessed,lastModifiedTime;
	@UiField HTMLPanel sessionspnl;
	@UiField VerticalPanel pnlSummary;

	Map<String, String> sessionData=new HashMap<String, String>();
	
	String collectionId=null;
	
	public CollectionSummaryView() {
		this.res = CollectionSummaryCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		setData();
	}
	void setData(){
		sessionspnl.setVisible(false);
		studentsListDropDown.addChangeHandler(new StudentsListChangeHandler());
		sessionsDropDown.addChangeHandler(new StudentsSessionsChangeHandler());
	}
    public class StudentsListChangeHandler implements ChangeHandler{
		@Override
		public void onChange(ChangeEvent event) {
			int selectedIndex=studentsListDropDown.getSelectedIndex();
			if(selectedIndex==0){
				sessionspnl.setVisible(false);
				//String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
				final String classpageId="6a4cdb36-c579-4994-8ea0-5130a9838cbd";
				getUiHandlers().setTeacherData(collectionId,classpageId);
			}else{
               // String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid");
                final String classpageId="6a4cdb36-c579-4994-8ea0-5130a9838cbd";
				getUiHandlers().loadUserSessions(collectionId, classpageId, studentsListDropDown.getValue(selectedIndex));
				sessionspnl.setVisible(true);
			}
		}
    }
    public class StudentsSessionsChangeHandler implements ChangeHandler{
		@Override
		public void onChange(ChangeEvent event) {
				int selectedIndex=sessionsDropDown.getSelectedIndex();
				 // String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid");
                final String classpageId="6a4cdb36-c579-4994-8ea0-5130a9838cbd";
                setSessionStartTime(selectedIndex);
				getUiHandlers().setIndividualData(collectionId, classpageId, studentsListDropDown.getValue(selectedIndex),sessionsDropDown.getValue(selectedIndex));
		}
    }
	@Override
	public void setUsersData(ArrayList<CollectionSummaryUsersDataDo> result) {
		studentsListDropDown.clear();
		studentsListDropDown.addItem("All");
		for (CollectionSummaryUsersDataDo collectionSummaryUsersDataDo : result) {
			studentsListDropDown.addItem(collectionSummaryUsersDataDo.getUserName(),collectionSummaryUsersDataDo.getGooruUId());
		}
		sessionspnl.setVisible(false);
	}

	@Override
	public void setCollectionMetaData(
			ArrayList<CollectionSummaryMetaDataDo> result) {
		if(result.size()!=0){
			collectionId=result.get(0).getGooruOId();
			collectionTitle.setText(result.get(0).getTitle());
			collectionLastAccessed.setText(AnalyticsUtil.getCreatedTime(Long.toString(result.get(0).getLastModified())));
			collectionImage.setUrl(result.get(0).getThumbnail());
		}
	}

	@Override
	public void setCollectionResourcesData(ArrayList<UserDataDo> result) {
		
	}
	@Override
	public void setUserSessionsData(
			ArrayList<CollectionSummaryUsersDataDo> result) {
		sessionsDropDown.clear();
		for (CollectionSummaryUsersDataDo collectionSummaryUsersDataDo : result) {
			sessionData.put(collectionSummaryUsersDataDo.getSessionId(), AnalyticsUtil.getCreatedTime(Long.toString(collectionSummaryUsersDataDo.getTimeStamp())));
			int day=collectionSummaryUsersDataDo.getFrequency();
			sessionsDropDown.addItem(day+AnalyticsUtil.getOrdinalSuffix(day)+" Session",collectionSummaryUsersDataDo.getSessionId());
		}
		setSessionStartTime(0);
	}
	@Override
	public void setInSlot(Object slot, Widget content) {
		pnlSummary.clear();
		if (content != null) {
			 if(slot==CollectionSummaryPresenter.TEACHER_STUDENT_SLOT){
				 pnlSummary.setVisible(true);
				 pnlSummary.add(content);
			}else{
				pnlSummary.setVisible(false);
			}
		}else{
			pnlSummary.setVisible(false);
		}
	}
	public void setSessionStartTime(int selectedIndex) {
		  lastModifiedTime.setText(sessionData.get(sessionsDropDown.getValue(selectedIndex)).toString());
	}
}
