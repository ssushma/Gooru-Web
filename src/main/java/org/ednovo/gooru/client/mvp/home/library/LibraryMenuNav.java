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
package org.ednovo.gooru.client.mvp.home.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.library.events.OpenSubjectCourseEvent;
import org.ednovo.gooru.client.mvp.home.library.events.SetSubjectDoEvent;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.library.CourseDo;
import org.ednovo.gooru.shared.model.library.SubjectDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.seanchenxi.gwt.storage.client.StorageExt;
import com.seanchenxi.gwt.storage.client.StorageKey;
import com.seanchenxi.gwt.storage.client.StorageKeyFactory;
/**
 * @fileName : LibraryMenuNav.java
 *
 * @description : This class is used to display the library menu navigation.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class LibraryMenuNav extends Composite {

	@UiField HTMLPanel tabsInner, scienceCourses, mathCourses, socialCourses, elaCourses;
	
	@UiField HTMLEventPanel sciencePanel, mathPanel, socialPanel, elaPanel;
	
	@UiField Label featuredCourses;
	
	@UiField LibraryStyleBundle libraryStyleUc;
	
	@UiField Anchor aboutGooruAnr;
	
	private static final String SCIENCE = "science", MATH = "math", SOCIAL="social-sciences", LANGUAGE="language-arts", FEATURED = "featured";
	
	private static final String LIBRARY_PAGE = "page";
	
	private static final String SUBJECT = "subject";
	
	private static final String CODE_ID = "code";
	
	private static final String TABS_INNER = "tabsInner";

	private static final String ACTIVE = "active";
	
	private boolean isScienceHovered = false, isMathHovered = false, isSocialHovered = false, isLanguageHovered = false;
	
    StorageExt localStorage = StorageExt.getLocalStorage();

    StorageKey<HashMap<String, ArrayList<CourseDo>>> libraryStorageObject = StorageKeyFactory.objectKey("libraryStorageObject");

	Map<String,CourseDo> courseDoMap = new HashMap<String,CourseDo>();
    
	private Map<String, String> subjectIdList = new HashMap<String, String>();
	
    private static LibraryMenuNavUiBinder uiBinder = GWT.create(LibraryMenuNavUiBinder.class);

	interface LibraryMenuNavUiBinder extends UiBinder<Widget, LibraryMenuNav> {
	}
	/**
	 * Class constructor
	 */
	public LibraryMenuNav() {
		initWidget(uiBinder.createAndBindUi(this));
		aboutGooruAnr.setHref("http://about.goorulearning.org/");
		aboutGooruAnr.setTarget("_blank");
		aboutGooruAnr.addStyleName(libraryStyleUc.aboutGooruAnrPadding());
		aboutGooruAnr.addClickHandler(new MixPanelEventClick());
		
		featuredCourses.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
			}
		});
		
		sciencePanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isScienceHovered) {
					isScienceHovered = true;
					String codeId = getSubjectIdBySubjectName(subjectIdList, SCIENCE);
					getTaxonomyData(codeId,null);
				}
			}
		});
		mathPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isMathHovered) {
					isMathHovered = true;
					String codeId = getSubjectIdBySubjectName(subjectIdList, MATH);
					getTaxonomyData(codeId,null);
				}
			}
		});
		socialPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isSocialHovered) {
					isSocialHovered = true;
					String codeId = getSubjectIdBySubjectName(subjectIdList, SOCIAL);
					getTaxonomyData(codeId,null);
				}
			}
		});
		elaPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isLanguageHovered) {
					isLanguageHovered = true;
					String codeId = getSubjectIdBySubjectName(subjectIdList, LANGUAGE);
					getTaxonomyData(codeId,null);
				}
			}
		});
	}
	
	/**
	 * 
	 * @fileName : LibraryMenuNav.java
	 *
	 * @description : This is an inner class for ClickHandler and ClickEvent. This will be used for calling a mixpanel event.
	 *
	 * @version : 1.0
	 *
	 * @date: 13-Dec-2013
	 */
	private class MixPanelEventClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.mixpanelEvent("Library_Click_AboutGooru");
		}
	}

	/**
	 * 
	 * @param courseId 
	 * @function getTaxonomyData 
	 * 
	 * @created_date : 03-Dec-2013
	 * 
	 * @description
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void getTaxonomyData(final String subjectCode, final String courseId) {
/*		try {
  			if(Cookies.getCookie(subjectName+"-gooru-release")!=null&&!Cookies.getCookie(subjectName+"-gooru-release").contains("5.11")) {
  				if(StorageExt.getLocalStorage()!=null&&StorageExt.getLocalStorage().get(libraryStorageObject)!=null&&StorageExt.getLocalStorage().get(libraryStorageObject).get(subjectName+"Courses")!=null){
  					System.out.println("menu one");
  					StorageExt.getLocalStorage().get(libraryStorageObject).remove(subjectName+"Courses");
  				}
  			}
  			
  			if(StorageExt.getLocalStorage().get(libraryStorageObject)!=null&&StorageExt.getLocalStorage().get(libraryStorageObject).get(subjectName+"Courses")!=null) {
				System.out.println("menu two");
				setTaxonomyData(subjectName,StorageExt.getLocalStorage().get(libraryStorageObject).get(subjectName+"Courses"));
			} else {
*/				AppClientFactory.getInjector().getLibraryService().getSubjects(subjectCode, new AsyncCallback<HashMap<String, SubjectDo>>() {
					@Override
					public void onSuccess(HashMap<String, SubjectDo> subjectListDo) {
/*						try {
							System.out.println("menu three");
							StorageExt.getLocalStorage().get(libraryStorageObject).put(subjectName+"Courses", result);
							Cookies.setCookie(subjectName+"-gooru-release", AppClientFactory.getLoggedInUser().getSettings().getGooruReleaseVersion());
						} catch (SerializationException e) {
							e.printStackTrace(); 
						}
*/						
						if(subjectIdList.size()<=0) {
							setSubjectPanelIds(subjectListDo);
						}
						String subjectName = getSubjectNameBySubjectId(subjectListDo, subjectCode);
						AppClientFactory.fireEvent(new SetSubjectDoEvent(subjectName,subjectListDo.get(subjectName)));
						if(!getSubjectSelected(subjectName)) {
							setTaxonomyData(subjectName, subjectCode, courseId, subjectListDo.get(subjectName).getData());
						}
					}

					@Override
					public void onFailure(Throwable caught) {
					}
				});
/*			}
		} catch (Exception e) {
		      e.printStackTrace(); 
		}
*/	}
	/**
	 * @function getSubjectSelected 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to get the selected subjects.
	 * 
	 * 
	 * @parm(s) : @param subjectName
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public boolean getSubjectSelected(String subjectName) {
		boolean isSelected = false;
		if(subjectName.equalsIgnoreCase(SCIENCE)&&scienceCourses.getWidgetCount()>0) {
			isSelected = true;
		} else if(subjectName.equalsIgnoreCase(MATH)&&mathCourses.getWidgetCount()>0) {
			isSelected = true;
		} else if(subjectName.equalsIgnoreCase(SOCIAL)&&socialCourses.getWidgetCount()>0) {
			isSelected = true;
		} else if(subjectName.equalsIgnoreCase(LANGUAGE)&&elaCourses.getWidgetCount()>0) {
			isSelected = true;
		}
		return isSelected;
	}
	
	/**
	 * @param courseId2 
	 * @function setTaxonomyData 
	 * 
	 * @created_date : 03-Dec-2013
	 * 
	 * @description
	 * 
	 * @parm(s) : @param List<LibraryCodeDo> taxonomyDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 * 
	*/
	protected void setTaxonomyData(String subjectname, final String subjectCode, String courseIdRefresh, ArrayList<CourseDo> courseDoList) {
		if (courseDoList != null) {
			for (final CourseDo courseDo : courseDoList) {
				if(courseDo.getUnit()!=null&&courseDo.getUnit().size()>0) {
					if(subjectname.equalsIgnoreCase(SCIENCE)) {
						Label courseTitle = new Label(courseDo.getLabel());
						courseTitle.setStyleName(libraryStyleUc.courseOption());
						final String courseId = courseDo.getCodeId().toString();
						courseDoMap.put(courseId, courseDo);
						courseTitle.addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								setHeaderBrowserTitle(courseDo.getLabel());
								MixpanelUtil.mixpanelEvent("Library_"+SCIENCE+"_"+courseDo.getLabel());
								Map<String,String> params = new HashMap<String, String>();
								params.put(LIBRARY_PAGE, "course-page");
								params.put(SUBJECT, subjectCode);
								params.put("courseId", courseId);
								AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME,params);
							}
						});
						scienceCourses.add(courseTitle);
					} else if(subjectname.equalsIgnoreCase(MATH)) {
						Label courseTitle = new Label(courseDo.getLabel());
						courseTitle.setStyleName(libraryStyleUc.courseOption());
						final String courseId = courseDo.getCodeId().toString();
						courseDoMap.put(courseId, courseDo);
						courseTitle.addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								setHeaderBrowserTitle(courseDo.getLabel());
								MixpanelUtil.mixpanelEvent("Library_"+MATH+"_"+courseDo.getLabel());
								Map<String,String> params = new HashMap<String, String>();
								params.put(LIBRARY_PAGE, "course-page");
								params.put(SUBJECT, subjectCode);
								params.put("courseId", courseId);
								AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME,params);
							}
						});
						mathCourses.add(courseTitle);
					} else if(subjectname.equalsIgnoreCase(SOCIAL)) {
						Label courseTitle = new Label(courseDo.getLabel());
						courseTitle.setStyleName(libraryStyleUc.courseOption());
						final String courseId = courseDo.getCodeId().toString();
						courseDoMap.put(courseId, courseDo);
						courseTitle.addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								setHeaderBrowserTitle(courseDo.getLabel());
								MixpanelUtil.mixpanelEvent("Library_"+SOCIAL+"_"+courseDo.getLabel());
								Map<String,String> params = new HashMap<String, String>();
								params.put(LIBRARY_PAGE, "course-page");
								params.put(SUBJECT, subjectCode);
								params.put("courseId", courseId);
								AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME,params);
							}
						});
						socialCourses.add(courseTitle);
					} else if(subjectname.equalsIgnoreCase(LANGUAGE)) {
						Label courseTitle = new Label(courseDo.getLabel());
						courseTitle.setStyleName(libraryStyleUc.courseOption());
						final String courseId = courseDo.getCodeId().toString();
						courseDoMap.put(courseId, courseDo);
						courseTitle.addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								setHeaderBrowserTitle(courseDo.getLabel());
								MixpanelUtil.mixpanelEvent("Library_"+LANGUAGE+"_"+courseDo.getLabel());
								Map<String,String> params = new HashMap<String, String>();
								params.put(LIBRARY_PAGE, "course-page");
								params.put(SUBJECT, subjectCode);
								params.put("courseId", courseId);
								AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME,params);
							}
						});
						elaCourses.add(courseTitle);
					}
				}
			}
		}
		if(courseIdRefresh!=null) {
			if(subjectname.equals(SCIENCE)) {
				isScienceHovered = true;
			} else if(subjectname.equals(MATH)) {
				isMathHovered = true;
			} else if(subjectname.equals(SOCIAL)) {
				isSocialHovered = true;
			} else if(subjectname.equals(LANGUAGE)) {
				isLanguageHovered = true;
			}
			setTabSelection(subjectname);
			AppClientFactory.fireEvent(new OpenSubjectCourseEvent(subjectname, courseDoMap.get(courseIdRefresh)));
		}
	}
	
	/**
	 * 
	 * @function setHeaderBrowserTitle 
	 * 
	 * @created_date : 24-Dec-2013
	 * 
	 * @description
	 * 
	 * @parm(s) : @param courseLabel
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void setHeaderBrowserTitle(String courseLabel) {
		AppClientFactory.setBrowserWindowTitle(SeoTokens.COURSE_PAGE_TITLE+courseLabel);	
	}
	
	/**
	 * 
	 * @function setSubjectPanelIds 
	 * 
	 * @created_date : 13-Dec-2013
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param subjectList
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setSubjectPanelIds(HashMap<String, SubjectDo> subjectList) {
		for (Map.Entry<String, SubjectDo> entry : subjectList.entrySet()) {
			subjectIdList.put(entry.getKey(), entry.getValue().getCode()+"");
			/*if(entry.getKey().equals(SCIENCE)) {
				sciencePanel.getElement().setAttribute(CODE_ID, entry.getValue().getCode());
				sciencePanel.getElement().setAttribute(SUBJECT, entry.getKey());
			} else if(entry.getKey().equals(MATH)) {
				mathPanel.getElement().setAttribute(CODE_ID, entry.getValue().getCode());
				mathPanel.getElement().setAttribute(SUBJECT, entry.getKey());
			} else if(entry.getKey().equals(SOCIAL)) {
				socialPanel.getElement().setAttribute(CODE_ID, entry.getValue().getCode());
				socialPanel.getElement().setAttribute(SUBJECT, entry.getKey());
			} else if(entry.getKey().equals(LANGUAGE)) {
				elaPanel.getElement().setAttribute(CODE_ID, entry.getValue().getCode());
				elaPanel.getElement().setAttribute(SUBJECT, entry.getKey());				
			}
			tabsInner.getElement().setId(TABS_INNER);*/
		}
	}
	
	/**
	 * 
	 * @function getSubjectNameBySubjectId 
	 * 
	 * @created_date : 12-Dec-2013
	 * 
	 * @description
	 * 
	 * @parm(s) : @param subjectList
	 * @parm(s) : @param subjectId
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getSubjectNameBySubjectId(HashMap<String, SubjectDo> subjectList, String subjectId) {
		for (Map.Entry<String, SubjectDo> entry : subjectList.entrySet()) {
			if(entry.getValue().getCode().equals(subjectId)) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	/**
	 * @function getSubjectIdBySubjectName 
	 * 
	 * @created_date : 17-Dec-2013
	 * 
	 * @description
	 * 
	 * @parm(s) : @param subjectList
	 * @parm(s) : @param subject
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getSubjectIdBySubjectName(Map<String,String> subjectList, String subject) {
		for (Map.Entry<String, String> entry : subjectList.entrySet()) {
			if(entry.getKey().equalsIgnoreCase(subject)) {
				return entry.getValue();
			}
		}
		return null;
	}
	/**
	 * @function setTabSelection 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This will set the selected tab selection data.
	 * 
	 * @parm(s) : @param subjectName
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setTabSelection(String subjectName) {
		clearSelectionTabs();
		if(subjectName.equals(FEATURED)) {
			featuredCourses.addStyleName(ACTIVE);
		} else if(subjectName.equals(SCIENCE)) {
			sciencePanel.addStyleName(ACTIVE);
		} else if(subjectName.equals(MATH)) {
			mathPanel.addStyleName(ACTIVE);
		} else if(subjectName.equals(SOCIAL)) {
			socialPanel.addStyleName(ACTIVE);
		} else if(subjectName.equals(LANGUAGE)) {
			elaPanel.addStyleName(ACTIVE);
		}
	}
	/**
	 * @function clearSelectionTabs 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to clear the selection tabs.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void clearSelectionTabs() {
		featuredCourses.removeStyleName(ACTIVE);
		sciencePanel.removeStyleName(ACTIVE);
		mathPanel.removeStyleName(ACTIVE);
		socialPanel.removeStyleName(ACTIVE);
		elaPanel.removeStyleName(ACTIVE);
	}
	
}
