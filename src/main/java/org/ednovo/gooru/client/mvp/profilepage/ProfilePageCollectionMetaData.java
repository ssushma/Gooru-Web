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
package org.ednovo.gooru.client.mvp.profilepage;

import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ProfilePageCollectionMetaData.java
 *
 * @description : This file is used to set the collection metadata for folders.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ProfilePageCollectionMetaData extends Composite {

	@UiField
	Label folderTitle, folderDescription;
	
	private static ProfilePageCollectionMetaDataUiBinder uiBinder = GWT
			.create(ProfilePageCollectionMetaDataUiBinder.class);

	interface ProfilePageCollectionMetaDataUiBinder extends UiBinder<Widget, ProfilePageCollectionMetaData> {
	}
	/**
	 * This method is to call setdata method by passing {@link CollectionItemDo}  as arugument.
	 * @param collectionItemDo
	 */
	public ProfilePageCollectionMetaData(final CollectionItemDo collectionItemDo) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(collectionItemDo);
	}
	/**
	 * 
	 * @function setData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This method is used to set the collection metadata to folders.
	 * 
	 * 
	 * @parm(s) : @param collectionItemDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setData(CollectionItemDo collectionItemDo) {
		folderTitle.setText(collectionItemDo.getCollection().getTitle());
		folderDescription.setText(collectionItemDo.getCollection().getGoals());
	}

}
