package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import java.util.Map;

import org.ednovo.gooru.client.gin.BaseUiHandlers;

import com.google.gwt.event.shared.EventHandler;

public interface AssignmentWidgetViewUiHandler extends BaseUiHandlers,EventHandler{
	public void getPathwayItems(String classpageId, String pathwayGooruOid,String sequence,int limit,int offSet);
	public void clearAssignmentContainer();
	public Map<String, String> getGetDirection();
	
}
