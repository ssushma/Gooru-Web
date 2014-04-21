package org.ednovo.gooru.client.uc.suggestbox.widget;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;

/**
 * 
 * @fileName : Span.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Jan 29, 2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class Span extends HTML implements HasText {

    public Span() {
        super(DOM.createElement("span"));
    }

    public Span(String text) {
        this();
        setText(text);
    }
}
