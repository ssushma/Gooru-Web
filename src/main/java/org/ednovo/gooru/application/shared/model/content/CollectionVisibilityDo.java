
/**
 * 
*/
package org.ednovo.gooru.application.shared.model.content;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 * @fileName : CollectionVisibilityDo.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Jan 27, 2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class CollectionVisibilityDo implements IsSerializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = -6635116419130714954L;

	private String classUid;
	private Boolean visibility;
	private String name;
	private Integer classId;
	
	
	
	public CollectionVisibilityDo(){}




	public String getClassUid() {
		return classUid;
	}




	public void setClassUid(String classUid) {
		this.classUid = classUid;
	}

	public Boolean getVisibility() {
		return visibility;
	}




	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Integer getClassId() {
		return classId;
	}




	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	
	
	
}
