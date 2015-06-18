package org.ednovo.gooru.client.uc;

import java.util.List;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

public class Suggestions implements Suggestion{
	
	 private String suggestion;
	 
	 public Suggestions(){}

	   

	public Suggestions(String suggestion) {
		// TODO Auto-generated constructor stub
		this.suggestion = suggestion;
	}



	public Suggestions(List<String> suggestions) {
		 for (String suggestion : suggestions) {
		      add(suggestion);
		    }
	}



	@Override
	public String getDisplayString() {
		// TODO Auto-generated method stub
		return ( suggestion + new Image("/images/buttons/plus-blue.png") );
	}

	@Override
	public String getReplacementString() {
		// TODO Auto-generated method stub
		return suggestion;
	}
	 public void add(String suggestion) {
		 this.add(suggestion);
	 }
}
