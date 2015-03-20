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
package org.ednovo.gooru.client.mvp.play.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

/**
 * 
 * @author BLR Team
 *
 */

public interface ResourcePlayerCBundle extends ClientBundle{
	
	static final ResourcePlayerCBundle INSTANCE = GWT.create(ResourcePlayerCBundle.class);
	
	@NotStrict
	@Source("responsiveplayer_1.css")
	ResourcePlayerCss getResponsive1Style();
	
	@NotStrict
	@Source("responsiveplayer_2.css")
	ResourcePlayerCss getResponsive2Style();

	@NotStrict
	@Source("responsiveplayer_3.css")
	ResourcePlayerCss getResponsive3Style();
	
	@NotStrict
	@Source("responsiveplayer_4.css")
	ResourcePlayerCss getResponsive4Style();
	
	public interface ResourcePlayerCss extends CssResource{
		
		public String fixedDivMain();
		public String playerResourceTitle();
		public String flagButtonOrange();
		
		@ClassName("add-button-normal")
		public String add_button_normal();
		
		@ClassName("info-button-normal")
		public String info_button_normal();
		public String rPlayerMenu();
		@ClassName("close-button")
		public String close_button();
		public String flagButtonNormal();
		public String resourcePlayer();
		public String tabs();
			
			
	}
	@NotStrict
	@Source("responsiveplayer.css")
	ResourcePlayerCss css();

	
	
}

