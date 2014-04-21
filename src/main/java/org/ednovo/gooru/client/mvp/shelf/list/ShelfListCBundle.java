/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.mvp.shelf.list;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * @author Search Team
 *
 */
public interface ShelfListCBundle extends ClientBundle{
	
	static final ShelfListCBundle INSTANCE = GWT.create(ShelfListCBundle.class);
	
	public interface ShelfTabCss extends CssResource {

		String shelfNewCollection();
		
		String blueBorder();
		
		String shelfNewCollectionText();
		
		String shelfCollectionBtnbg();
		
		String shelfCollectionPlusIcon();
		
		String shelfCollectionAddTitle();
		
		String shelfCollection();
		
		String shelfCollectionTitle();
		
		String shelfCollectionTitleText();
		
		String shelfResourcePanel();
		
		String shelfResourceImage();
		
		String shelfResourceTitle();	
		
		String shelfContentPanel();
		
		String shelfContentWrapperPanel();
		
		String shelfGlassPanel();
		
		String shelfGlassTopPanel();
		
		String shelfBlueLbl();
		
		String shelfGreyLbl();
		
		String shelfDarkGreyLbl();

		String shelfGradientOpen();
		
		String myFoldersListIcon();
		
		// Adding Css for folders start //
		
		String myFoldersL2ListIcon();
		
		String shelfContentWrapperPanelForFolders();

		String shelfContentWrapperPanelFolderResource();
		
		String shelfContentPanelForFolders();
		
		String myFoldersL3ListIcon();
		
		String shelfBlueFolderLbl();
		
		String shelfBlueL3FolderLbl();
		
		String shelfCollectionTitleActive();
		
		String shelfFolderL2TitleActive();
		
		// Adding Css for folders end //
		
		String shelfPanel();
		
		String shelfPanelForWorkspace();
		
		String shelfPanelForShelf();
		
		String shelfBlueL3DataFolderLbl();
		
		String myFolderCollectionNavContainerHeading();
		
		String myFolderCollectionNavContainerHeadingText();
		
		String resourceCollectionPanelStyle();
		
		String resourceCollectionPanelText();
		
		String myShelfEditButton();
	}
	@Source("ShelfList.css")
	ShelfTabCss css();

}
