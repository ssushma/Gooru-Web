package org.ednovo.gooru.client.mvp.gshelf.util;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.SimpleAsyncCallback;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.gshelf.righttabs.MyCollectionsRightClusterPresenter;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class FolderInfoWidget extends Composite {
	
	@UiField TextBox folderTitleTxtBox;
	@UiField Label lblErrorMessage;
	@UiField HTMLPanel folderInfo,titleDetailsPnl;
	@UiField Button saveFolderBtn;
	
	FolderDo folderObj;
	private static final String FOLDER = "Folder";
	MyCollectionsRightClusterPresenter rightPresenter;

	private static FolderInfoWidgetUiBinder uiBinder = GWT
			.create(FolderInfoWidgetUiBinder.class);

	interface FolderInfoWidgetUiBinder extends
			UiBinder<Widget, FolderInfoWidget> {
	}
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);

	public FolderInfoWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		folderInfo.getElement().setId("pnlCollectionInfo");
		folderInfo.getElement().getStyle().setHeight(Window.getClientHeight(), Unit.PX);
		titleDetailsPnl.getElement().setAttribute("style", "border-bottom: 0px solid #ddd;");
		Window.addResizeHandler(new ResizeHandler() {
			
			@Override
			public void onResize(ResizeEvent event) {
				folderInfo.getElement().getStyle().setHeight(Window.getClientHeight(), Unit.PX);
				
			}
		});
	}
	
	@UiHandler("saveFolderBtn")
	public void clickSaveFolderBtn(ClickEvent clickEvent){
		if(!StringUtil.isEmpty(folderTitleTxtBox.getText())){
			if(folderTitleTxtBox.getText().length()<50){
				Map<String, String> parms = new HashMap<String, String>();
				parms.put("text",folderTitleTxtBox.getText().trim());
				AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
					@Override
					public void onSuccess(Boolean result) {
						if(result){
							SetStyleForProfanity.SetStyleForProfanityForTextBox(folderTitleTxtBox, lblErrorMessage, result);
						}else{
							lblErrorMessage.setVisible(false);
							String o1 = AppClientFactory.getPlaceManager().getRequestParameter("o1",null);
							String o2= AppClientFactory.getPlaceManager().getRequestParameter("o2",null);
							String o3= AppClientFactory.getPlaceManager().getRequestParameter("o3",null);
							if(o2==null){
								createFolder(o1);
							}else{
								updateFolder();
							}
						}
					}
				});
			}else{
				lblErrorMessage.setVisible(true);
				lblErrorMessage.setText(i18n.GL1427());
			}
			
		}else{
			lblErrorMessage.setVisible(true);
			lblErrorMessage.setText(StringUtil.generateMessage(i18n.GL0067(),"Folder"));
		}
		
		
	}
	/**
	 * To Create folder 
	 */
	protected void createFolder(String parentId) {
		AppClientFactory.getInjector().getfolderService().createFolder(folderTitleTxtBox.getText().trim(), parentId, false, new SimpleAsyncCallback<FolderDo>() {

			@Override
			public void onSuccess(FolderDo folderDo) {
				System.out.println("sucess::"+folderDo.getGooruOid());
				rightPresenter.getShelfMainPresenter().updateTitleOfTreeWidget(folderDo,true);
				rightPresenter.setTabItems(2, FOLDER, folderDo);
			}
		});
	}

	public void setData(FolderDo folderObj, MyCollectionsRightClusterPresenter rightPresenter) {
		this.folderObj=folderObj;
		this.rightPresenter=rightPresenter;
		if(folderObj!=null){
			folderTitleTxtBox.setText(folderObj.getTitle());
		}
		
	}
	/**
	 * To update the folder details.
	 */
	protected void updateFolder() {
		String folderId= AppClientFactory.getPlaceManager().getRequestParameter("o2",null);
		AppClientFactory.getInjector().getfolderService().updateFolder(folderId, folderTitleTxtBox.getText().trim(), null, null, null, new SimpleAsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				folderObj.setTitle(folderTitleTxtBox.getText());
				folderObj.setType("folder");
				rightPresenter.getShelfMainPresenter().updateTitleOfTreeWidget(folderObj,false);
				rightPresenter.setTabItems(2, FOLDER, folderObj);
			}
		});
	}

}
