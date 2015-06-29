
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpage.teach;

import org.ednovo.gooru.application.client.gin.BaseUiHandlers;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;


/**
 * @fileName : TeachClassViewUiHandlers.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 26-Jun-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public interface TeachClassViewUiHandlers extends BaseUiHandlers{
	
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_BODYMENU = new Type<RevealContentHandler<?>>();

}
