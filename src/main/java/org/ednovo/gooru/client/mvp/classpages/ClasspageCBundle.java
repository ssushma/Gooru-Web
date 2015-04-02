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
package org.ednovo.gooru.client.mvp.classpages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;


/**
 * 
 * @fileName : ClasspageCBundle.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 06-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public interface ClasspageCBundle extends ClientBundle{
	
	static final ClasspageCBundle INSTANCE = GWT.create(ClasspageCBundle.class);
	
	public interface  ClasspageCss extends CssResource{
		
		String teachWrapper();
		
		String myClassPageImage();

		String myClassPageImageText();

		String myClassPageImageTitle();
		
		String myClassPageCollectionAddTitle();
		
		String myClassPageCollectionPlusIcon();

		String myClassPageCollectionBtnbg();
		
		
		String myClassPageInnerWrapper();

		String myClassPageInnerWrapperMain();

		String myClassPageInnerWrapperMainTwo();

		String myClassPageNewAddedWrapper();
		
		String myClassPageContentContainer();

		String myClassPageInnerContentContainer();

		String myClassPageWelcomeText();

		String myClassPageWelcomeDescribtion();

		String myClassPageGetStarted();

		String myClassPageClickingTitle();

		String myClassPageCreateClasspageContainer();

		String myClassPageCreatePlusIcon();

		String myClassPageCreateClasspageText();
		
		String mainClassPageTextTitle();
		
		String mainClasspageMainCreateNewClasspage();
		
		String noClasspages();
		
		String myClassPageListWrapper();
		
		String startNewClasspage();
		
		String startClasspageContainer();
		
		String arrowImage();
		
		String noClasspageMsgContainer();
		
		String container();
		
		String loadingImageForClasspage();
		
		String classPageScrollPanel();
		
		/* No Classpage */
		String classpageDesc();


		String firstDiv();
		String secondDiv(); 
		String thirdDiv();
		String imageCss();

		String classpageTitleText();

		String classpageResourceThumbnail();

		String classpageText();
		String classpageTextOptions();
		String classpageTextSupport();
		
		String classpageContainer();
		
		String classpageBottomBlueText();
		
		String classpageBottomText();

		String imgTextContainer();

		String imgTextContainerCustomize();
		
		String supportLink();
		
		String teachNoClasspageDesc();
		
		String classpageCreateDesc();
		
		String classpageShareDesc();
		
		String classpageImg();
		
		String shareImg();
		
		String classpageFooterTextContainer();
		
		String addClasspage();

	}
	@Source("classpage.css")
	ClasspageCss css();

}
