///*******************************************************************************
// * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
// * 
// *  http://www.goorulearning.org/
// * 
// *  Permission is hereby granted, free of charge, to any person obtaining
// *  a copy of this software and associated documentation files (the
// *  "Software"), to deal in the Software without restriction, including
// *  without limitation the rights to use, copy, modify, merge, publish,
// *  distribute, sublicense, and/or sell copies of the Software, and to
// *  permit persons to whom the Software is furnished to do so, subject to
// *  the following conditions:
// * 
// *  The above copyright notice and this permission notice shall be
// *  included in all copies or substantial portions of the Software.
// * 
// *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
// ******************************************************************************/
//package org.ednovo.gooru.client.mvp.player;
//
//import org.ednovo.gooru.client.gin.IsViewWithHandlers;
//
//import com.gwtplatform.mvp.client.PopupView;
//
///**
// * @author Search Team
// *
// */
//public interface IsResourcePlayView extends PopupView, IsViewWithHandlers<ResourcePlayUiHandlers> {
//	
//	/**
//	 * Set Resource info while resource play
//	 * @param gooruOid of the resource
//	 * @param token of the resource
//	 * @param playerName name of the player
//	 */
//	void setData(String gooruOid, String token, String playerName,boolean isEmbededResource,boolean isShare);
//	
//	/**
//	 * to set data for mobile resource player.
//	 * @param gooruOid of the resource
//	 * @param token of the resource
//	 * @param playerName name of the player
//	 */
//	void setMobileData(String gooruOid, String token, String playerName);
//	
//	
//	public void setUserLoginDetails(String sessionToken);
//	
//	public void refreshShelfCollectionInPlay(String collectionId);
//	
//	public void addShareWidgetInPlay(String link, String rawUrl,String title, String desc, String shortenUrl, String type, String shareType);
//	public void updateResourceView(String count,String resourceId,String type);
//}
