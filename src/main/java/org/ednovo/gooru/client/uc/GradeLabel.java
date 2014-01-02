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
package org.ednovo.gooru.client.uc;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
/**
 * @fileName : GradeLabel.java
 *
 * @description : This class is used to display the grade labels.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class GradeLabel extends Label implements ClickHandler {
	
	private static final List<String> gradeList = new ArrayList<String>();
	
	private CollectionDo collection = null;
	
	private static final String KIDER_GARTEN = "Kindergarten";
	
	private static final String HIGHER_EDUCATION = "Higher Education";
	
	/**
	 * Class constructor
	 * @param label name of the {@link Label}
	 * @param collectionDo instance of {@link CollectionDo}
	 */
	public GradeLabel(String label, CollectionDo collectionDo){
		super(label);
		CollectionCBundle.INSTANCE.css().ensureInjected();
		addDomHandler(this, ClickEvent.getType());
		collection = collectionDo;
		this.setStyleName("gradeList");
		if(label.equals(KIDER_GARTEN)){
			this.addStyleName(CollectionCBundle.INSTANCE.css().kinderGartenGrade());
		}
		if(label.equals(HIGHER_EDUCATION)){
			this.addStyleName(CollectionCBundle.INSTANCE.css().higherEducationGrade());
		}
		if (collectionDo.getGrade() != null) {
			String genGrade = collectionDo.getGrade();
			if (genGrade.indexOf("-")>0){
				genGrade = generateGrade(genGrade);
			}
			
			String grade[] = genGrade.split(",");
			for (int i = 0; i < grade.length; i++) {
				if (label.equals(grade[i])) {
					this.getElement().getStyle().setProperty("background", "#0F76BB");
					this.getElement().getStyle().setColor("#fff");
					this.getElement().setAttribute("selected", "selected");
					if(!gradeList.contains(grade[i].toString())){
						gradeList.add(grade[i].toString());
					}
				}
			}
		}
	}
	/**
	 * This will handle the click event on the grade label.
	 */
	@Override
	public void onClick(ClickEvent event) {
		if(this.getElement().getAttribute("selected").contains("selected")){
			this.getElement().getStyle().setProperty("background", "");
			this.getElement().getStyle().setColor("#999");
			this.getElement().removeAttribute("selected");
			for(String grade : gradeList){
				if(grade.equals(this.getText())){
					gradeList.remove(grade);
					updateGrade(gradeList);
				}
			}
			
		} else {
			this.getElement().getStyle().setProperty("background", "#0F76BB");
			this.getElement().getStyle().setColor("#fff");
			this.getElement().setAttribute("selected", "selected");
			if(!gradeList.contains(this.getText())){
			gradeList.add(this.getText());
			updateGrade(gradeList);
			}
		}
		
	}
	/**
	 * @function updateGrade 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will update the grade.
	 * 
	 * 
	 * @parm(s) : @param gradeList
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void updateGrade(List<String> gradeList){
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collection.getGooruOid(), null, null, join(gradeList, ","), null, null, null,null,null,null, new SimpleAsyncCallback<CollectionDo>(){
			
			@Override
			public void onSuccess(CollectionDo result) {
				collection.setGrade(result.getGrade());
			}
		});
	}
	/**
	 * @function join 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to join the list.
	 * 
	 * @parm(s) : @param list
	 * @parm(s) : @param separator
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private String join(List<?> list,String separator){
		StringBuilder builder =null;
		if(list != null){
			builder = new StringBuilder();
			for(Object value:list){
				if(builder.length() > 0){
					builder.append(separator);
				}
				builder.append(value);
			}
		}
		return builder.toString();
	}
	
	/**
	 * @function generateGrade 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to generate the grades.
	 * 
	 * 
	 * @parm(s) : @param gradeTxt
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private String generateGrade(String gradeTxt){
		String tmpGradeTxt = "";
		if (gradeTxt.indexOf("-") > 0){
			if (gradeTxt.indexOf(",") == -1){
				tmpGradeTxt = generateGradeIfHypen(gradeTxt);
			}else{
				String gradeList[];
				gradeList = gradeTxt.split(",");
				for (int k=0; k<gradeList.length;k++){
					if (gradeList[k].indexOf("-") > 0){
						if (k==gradeList.length){
							tmpGradeTxt = tmpGradeTxt + generateGradeIfHypen(gradeList[k]);
						}else{
							tmpGradeTxt = tmpGradeTxt + generateGradeIfHypen(gradeList[k]) + ",";
						}
					}else{
						if (k==gradeList.length-1){
							tmpGradeTxt = tmpGradeTxt + gradeList[k];
						}else{
							tmpGradeTxt = tmpGradeTxt + gradeList[k] + ",";
						}
					}
				}
			}
		}
		return tmpGradeTxt;
	}
	/**
	 * @function generateGradeIfHypen 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will generate the grades with hypen.
	 * 
	 * 
	 * @parm(s) : @param grade
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private String generateGradeIfHypen(String grade){
		String gradeList[];
		StringBuilder gradeStr = new StringBuilder();
		gradeList = grade.split("-");
		if (gradeList.length>=2){
			int start = Integer.parseInt(gradeList[0].trim());
			int end = Integer.parseInt(gradeList[1].trim());
			if ( start < end){
				for (int i = start; i<=end; i++){
					if (i==end){
						gradeStr.append(i);
					}else{
						gradeStr.append(i).append(",");
					}
				}
			}
		}else{
			gradeStr.append(Integer.parseInt(gradeList[0]));
		}
		return gradeStr.toString();
	}
	
}
