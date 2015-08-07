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
package org.ednovo.gooru.client.mvp.shelf.collection;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.client.mvp.shelf.ShelfCBundle;
import org.ednovo.gooru.client.uc.LabelUc;
import org.ednovo.gooru.client.uc.StatisticsItemUc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * @author Search Team
 * 
 */
public class CollectionStatisticsTabVc extends FlowPanel {

	private FlowPanel showAddsFloPanel;

	private FlowPanel showViewsFloPanel;

	private FlowPanel showLikesFloPanel;

	private FlowPanel showAvgTimeFloPanel;

	private LabelUc statisticsLblUc;
	
	MessageProperties i18n = GWT.create(MessageProperties.class);

	/**
	 * Class constructor, creates new objects for
	 * adds,views,likes,shares,averageTime
	 * 
	 * @param collection
	 *            instance of the {@link CollectionDo}
	 */
	public CollectionStatisticsTabVc(CollectionDo collection) {
		showAddsFloPanel = new FlowPanel();
		showViewsFloPanel = new FlowPanel();
		showLikesFloPanel = new FlowPanel();
		showAvgTimeFloPanel = new FlowPanel();
		setData(collection);
	}

	/**
	 * shows collection statistics information
	 * 
	 * @param collection
	 *            instance of the {@link CollectionDo}
	 */
	public void setData(CollectionDo collection) {
		statisticsLblUc = new LabelUc(i18n.GL1491()+i18n.GL_SPL_SEMICOLON()+" ");
		statisticsLblUc.setStyleName(ShelfCBundle.INSTANCE.css().headerLabel());
		this.add(statisticsLblUc);
		showAddsFloPanel.add(new StatisticsItemUc(ShelfCBundle.INSTANCE.css().addsImageStyle(), i18n.GL1493(), "50"));
		this.add(showAddsFloPanel);
		showViewsFloPanel.add(new StatisticsItemUc(ShelfCBundle.INSTANCE.css().viewsImageStyle(), i18n.GL0934(), collection.getViews()));
		this.add(showViewsFloPanel);
		showLikesFloPanel.add(new StatisticsItemUc(ShelfCBundle.INSTANCE.css().likesImageStyle(), i18n.GL0729().toLowerCase(), "49"));
		this.add(showLikesFloPanel);
		showAvgTimeFloPanel.add(new StatisticsItemUc(ShelfCBundle.INSTANCE.css().avgTimeImageStyle(), i18n.GL1492(), collection.getEstimatedTime()));
		this.add(showAvgTimeFloPanel);
	}

}
