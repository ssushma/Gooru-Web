package org.ednovo.gooru.client.mvp.library.sausd.metadata;

import org.ednovo.gooru.shared.model.library.ProfileLibraryDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class LibraryMetaDataContentUc extends Composite implements MessageProperties{

	@UiField Label ideasStaticLbl, questionsStaticLbl, tasksStaticLbl;
	
	@UiField HTML bigIdeasLbl, essentialQuestionsLbl, performanceTaskLbl;
	
	@UiField HTMLPanel bigIdeasPanel, essentialQuestionsPanel, performanceTaskPanel;
	
	private static LibraryMetaDataContentUcUiBinder uiBinder = GWT
			.create(LibraryMetaDataContentUcUiBinder.class);

	interface LibraryMetaDataContentUcUiBinder extends
			UiBinder<Widget, LibraryMetaDataContentUc> {
	}

	public LibraryMetaDataContentUc(ProfileLibraryDo profileLibraryDo) {
		initWidget(uiBinder.createAndBindUi(this));
		init(profileLibraryDo);
	}
	
	private void init(ProfileLibraryDo profileLibraryDo) {
		String strIdeas = profileLibraryDo.getIdeas();
		String strPerformance = profileLibraryDo.getPerformanceTasks();
		String strQuestions = profileLibraryDo.getQuestions();
		
		ideasStaticLbl.setText(GL1731);
		questionsStaticLbl.setText(GL1732);
		tasksStaticLbl.setText(GL1733);
		
		if(strPerformance!=null&&!strPerformance.isEmpty()) {
			performanceTaskLbl.setHTML(strPerformance);
		} else {
			performanceTaskPanel.setVisible(false);
		}
		if(strIdeas!=null&&!strIdeas.isEmpty()) {
			bigIdeasLbl.setHTML(strIdeas);
		} else {
			bigIdeasPanel.setVisible(false);
		}
		if(strQuestions!=null&&!strQuestions.isEmpty()) {
			essentialQuestionsLbl.setHTML(strQuestions);
		} else {
			essentialQuestionsPanel.setVisible(false);
		}
	}
}