
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpages.classlist;

import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.CollaboratorsDo;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;


/**
 * @fileName : IsClassListView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 13-Mar-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public interface IsClassListView extends IsViewWithHandlers<ClassListUiHandlers> {
	public void setClassPageDo(ClasspageDo classpageDo);
	public void setShareUrl(Map<String, String> shortenUrl);
	/**
	 * @function setLoadingPanelVisibility 
	 * 
	 * @created_date : Mar 17, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param visibility
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	void setLoadingPanelVisibility(boolean visibility);
	/**
	 * @function displayMembersList 
	 * 
	 * @created_date : Mar 17, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param result
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
//	public void displayMembersList(
//			StudentsAssociatedListDo result);
	/**
	 * @function clearMembersListPanel 
	 * 
	 * @created_date : Mar 17, 2014
	 * 
	 * @description
	 * 
	 * 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	public void clearMembersListPanel();
	/**
	 * @function displayPendingMembersList 
	 * 
	 * @created_date : Mar 17, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param lstPendingMembers
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	void displayPendingMembersList(List<CollaboratorsDo> lstPendingMembers,boolean isNew, int totalCount,boolean increasePageNum,boolean insertAtTop);
	
	/**
	 * @function enableInvite 
	 * 
	 * @created_date : Mar 17, 2014
	 * 
	 * @description
	 * 
	 * 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	public void enableInvite();
	public void displayInvitationSuccessPopUp(int listSize);
	/**
	 * @function displayActiveMembersList 
	 * 
	 * @created_date : Apr 1, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param lstActiveMembers
	 * @param isNew
	 * @param totalCount
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	public void displayActiveMembersList(List<CollaboratorsDo> lstActiveMembers,boolean isNew, int totalCount,boolean increasePageNum);
	public void insertPendingUserAfterDeletion(CollaboratorsDo lstPendingMembers, boolean isNew,int totalCount,int intPos,boolean insertAtTop);
	public Anchor getSeeMorePendingLabel();
	public void insertActiveUserAfterDeletion(CollaboratorsDo lstPendingMembers,boolean isNew, int totalCount, int intPos);
	public Button getInviteButton();
	public Label getLblPleaseWait();
	public void createAutoSuggestBox() ;
	public void clearDataAndErrorMessages();
	public void removePendiUserWidget(MembersViewVc membersViewVc,boolean pendingFlag);
	public void getPendingMembersList();
}
