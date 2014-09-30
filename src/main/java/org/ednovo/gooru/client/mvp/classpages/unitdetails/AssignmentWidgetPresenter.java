package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class AssignmentWidgetPresenter extends PresenterWidget<IsAssignmentWidget> implements AssignmentWidgetViewUiHandler{
	
	private HTMLPanel assignmentContainer;
	private Map<String, String> getDirection = new HashMap<String, String>();
	
	@Inject
	public AssignmentWidgetPresenter(EventBus eventBus,
			IsAssignmentWidget view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		
	}
	@Override
	protected void onBind() {
		super.onBind();
	}
	@Override
	public void getPathwayItems(String classpageId,String pathwayGooruOid,String sequence,int limit,int offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, pathwayGooruOid, sequence, limit, offSet, new SimpleAsyncCallback<UnitAssignmentsDo>() {
			@Override
			
			public void onSuccess(UnitAssignmentsDo result) {
				String aid=AppClientFactory.getPlaceManager().getRequestParameter("aid", null);
				if(aid==null){
					if(result!=null){
						if(result.getSearchResults() != null){
							if(result.getSearchResults().size()>0){
							//	getAssignemntDetails(result.getSearchResults().get(0).getCollectionItemId(),classpageId,pathwayGooruOid);
							}
						}
					}
				}
				getView().displayAssignments(result);

			}
		});
		
	}
	
	public void getUnitAssignmentData(ClassDo classDo){
		getView().getClassUnitDoObj(classDo);
		String classPageId;
		classPageId= AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		
		if(classPageId==null){
			classPageId= AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		}
		String unitId = AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		getPathwayItems(classPageId,unitId,"sequence",10,0);
	}
	
	public HTMLPanel getAssignmentContainer() {
		return assignmentContainer;
	}
	
	public void setAssignmentContainer(HTMLPanel assignmentContainer) {
		this.assignmentContainer = assignmentContainer;
	}
	
	@Override
	public void clearAssignmentContainer() {
		if(assignmentContainer!=null){
			assignmentContainer.clear();
		}
	}
	public Map<String, String> getGetDirection() {
		return getDirection;
	}
	public void setGetDirection(Map<String, String> getDirection) {
		this.getDirection = getDirection;
	}
		
		
			
}
