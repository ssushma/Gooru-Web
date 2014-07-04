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
		ideasStaticLbl.getElement().setId("lblIdeasStaticLbl");
		ideasStaticLbl.getElement().setAttribute("alt",GL1731);
		ideasStaticLbl.getElement().setAttribute("title",GL1731);
	
		questionsStaticLbl.setText(GL1732);
		questionsStaticLbl.getElement().setId("lblQuestionsStaticLbl");
		questionsStaticLbl.getElement().setAttribute("alt",GL1732);
		questionsStaticLbl.getElement().setAttribute("title",GL1732);
		
		tasksStaticLbl.setText(GL1733);
		tasksStaticLbl.getElement().setId("lblTasksStaticLbl");
		tasksStaticLbl.getElement().setAttribute("alt",GL1733);
		tasksStaticLbl.getElement().setAttribute("title",GL1733);
		
		bigIdeasPanel.getElement().setId("pnlBigIdeasPanel");
		bigIdeasLbl.getElement().setId("htmlBigIdeasLbl");
		essentialQuestionsPanel.getElement().setId("pnlEssentialQuestionsPanel");
		essentialQuestionsLbl.getElement().setId("htmlEssentialQuestionsLbl");
		performanceTaskPanel.getElement().setId("pnlPerformanceTaskPanel");
		performanceTaskLbl.getElement().setId("htmlPerformanceTaskLbl");
		
		if(strPerformance!=null&&!strPerformance.isEmpty()) {
			performanceTaskLbl.setHTML(strPerformance);
			performanceTaskLbl.getElement().setAttribute("alt",strPerformance);
			performanceTaskLbl.getElement().setAttribute("title",strPerformance);
		} else {
			performanceTaskPanel.setVisible(false);
		}
		if(strIdeas!=null&&!strIdeas.isEmpty()) {
			bigIdeasLbl.setHTML(strIdeas);
			bigIdeasLbl.getElement().setAttribute("alt",strIdeas);
			bigIdeasLbl.getElement().setAttribute("title",strIdeas);
		} else {
			bigIdeasPanel.setVisible(false);
		}
		if(strQuestions!=null&&!strQuestions.isEmpty()) {
			essentialQuestionsLbl.setHTML(strQuestions);
			essentialQuestionsLbl.getElement().setAttribute("alt",strQuestions);
			essentialQuestionsLbl.getElement().setAttribute("title",strQuestions);
		} else {
			essentialQuestionsPanel.setVisible(false);
		}
	}
}