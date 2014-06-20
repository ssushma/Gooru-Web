package org.ednovo.gooru.client.mvp.library.sausd.metadata;

import org.ednovo.gooru.shared.model.library.ProfileLibraryDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class LibraryMetaDataContentUc extends Composite implements MessageProperties{

	@UiField Label ideasStaticLbl, questionsStaticLbl, tasksStaticLbl;
	
	@UiField HTML bigIdeasLbl, essentialQuestionsLbl, performanceTaskLbl;
	
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
		ideasStaticLbl.setText(GL1731);
		questionsStaticLbl.setText(GL1732);
		tasksStaticLbl.setText(GL1733);
		bigIdeasLbl.setHTML(profileLibraryDo.getIdeas());
		essentialQuestionsLbl.setHTML(profileLibraryDo.getQuestions());
		performanceTaskLbl.setHTML(profileLibraryDo.getPerformanceTasks());
	}
	
}