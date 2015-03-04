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
package org.ednovo.gooru.client.mvp.play.resource.report;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;


public interface FlagBundle extends ClientBundle{
	
	public static final FlagBundle IMAGEBUNDLEINSTANCE =  GWT.create(FlagBundle.class);
	
	@Source("images/flag-header-close-btn.png")
	@ImageOptions(repeatStyle=RepeatStyle.None)
	ImageResource closeFlagPopUpImages();
	
	@Source("org/ednovo/gooru/client/mvp/play/resource/report/player-flag-popup.css")
	FlagStyles flagstyle();
	
	public interface FlagStyles extends CssResource{
	String flagButtonselected();
	String flagbuttonDeSelected();
	String playerflagbuttoncancel();
	String playerflagbuttonsubmit();
	String playerflagtextarea();
	String endedquestionrightpart();
	String flagresourcenmenutext();
	String endedquestionmenuselected();
	String playerflagpopupheadertitle();
	String flagresourceleftpart();
	String playerflagpopupinnerwrapper();
	String downarrow();
	String playerflagcontenttext();
	String playerflagpopupwrapper();
	String playerflagcontentcontainer();
	String leftalign();
	String endedquestionmenu();
	String endedquestionwrapper();
	String endedquestionheader();
	String playerflagcollectionresourcescontentcontainer();
	String playerflagcontent();
	String flagresourcesinnerwrapper();
	String playerflagradiobutton();
	String playerflagbuttoncontainer();
	String playerflagpopupheaderCloseBtn();
	String playerflagpopupheader();
	String endedquestionheaderflagtext();
	String thankyoupopupwrapper();
	String thankyoupopupinnerwrapper();
	String thankyoubuttoncontainer();
	String playerflagcontentthankyou();
	String thankyouflagbuttonsubmit();
	String playerflagbuttoncancelGray();
	String glassStyle();
	String playerflagbuttonOk();
	String ckeckBoxPlyerStyle();
	String playerflagcontentTitle();
	
	
	}

	

}
