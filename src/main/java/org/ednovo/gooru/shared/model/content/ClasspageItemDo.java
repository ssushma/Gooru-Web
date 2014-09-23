package org.ednovo.gooru.shared.model.content;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ClasspageItemDo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public ClasspageItemDo(){}
	
	private Long plannedEndDate;
	private Integer totalHitCount;
	private String collectionTitle;
	private String direction; // narration from API
	private String goal;
	private String thumbnailUrl;
	private String collectionId;
	private String collectionItemId;
	private String title;
	private String userNameDispaly;
	private String classpageId;
	private String status;
	private Integer sequenceNumber;
	private Boolean isRequired;
	private Integer itemSequence;
	private String estimatedTime;
	private String minimumScore;
	private String narration;
	
	private ResourceDo resource;
	
	private Integer minimumScoreByUser;
	private Integer assignmentCompleted;
	private Integer timeStudying;
	
	
	/**
	 * @return the minimumScoreByUser
	 */
	public Integer getMinimumScoreByUser() {
		return minimumScoreByUser;
	}
	/**
	 * @param minimumScoreByUser the minimumScoreByUser to set
	 */
	public void setMinimumScoreByUser(Integer minimumScoreByUser) {
		this.minimumScoreByUser = minimumScoreByUser;
	}
	/**
	 * @return the assignmentCompleted
	 */
	public Integer getAssignmentCompleted() {
		return assignmentCompleted;
	}
	/**
	 * @param assignmentCompleted the assignmentCompleted to set
	 */
	public void setAssignmentCompleted(Integer assignmentCompleted) {
		this.assignmentCompleted = assignmentCompleted;
	}
	/**
	 * @return the timeStudying
	 */
	public Integer getTimeStudying() {
		return timeStudying;
	}
	/**
	 * @param timeStudying the timeStudying to set
	 */
	public void setTimeStudying(Integer timeStudying) {
		this.timeStudying = timeStudying;
	}
	public String getUserNameDispaly() {
		return userNameDispaly;
	}
	public void setUserNameDispaly(String userNameDispaly) {
		this.userNameDispaly = userNameDispaly;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	private String profileImageUrl;
	
	/**
	 * @return the plannedEndDate
	 */
	public Long getPlannedEndDate() {
		return plannedEndDate;
	}
	/**
	 * @param plannedEndDate the plannedEndDate to set
	 */
	public void setPlannedEndDate(Long plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}
	/**
	 * @return the totalHitCount
	 */
	public Integer getTotalHitCount() {
		return totalHitCount;
	}
	/**
	 * @param totalHitCount the totalHitCount to set
	 */
	public void setTotalHitCount(Integer totalHitCount) {
		this.totalHitCount = totalHitCount;
	}
	/**
	 * @return the collectionTitle
	 */
	public String getCollectionTitle() {
		return collectionTitle;
	}
	/**
	 * @param collectionTitle the collectionTitle to set
	 */
	public void setCollectionTitle(String collectionTitle) {
		this.collectionTitle = collectionTitle;
	}
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * @return the goal
	 */
	public String getGoal() {
		return goal;
	}
	/**
	 * @param goal the goal to set
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}
	/**
	 * @return the thumbnailUrl
	 */
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	/**
	 * @param thumbnailUrl the thumbnailUrl to set
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	/**
	 * @return the collectionId
	 */
	public String getCollectionId() {
		return collectionId;
	}
	/**
	 * @param collectionId the collectionId to set
	 */
	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}
	public String getCollectionItemId() {
		return collectionItemId;
	}
	public void setCollectionItemId(String collectionItemId) {
		this.collectionItemId = collectionItemId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	public String getClasspageId() {
		return classpageId;
	}
	public void setClasspageId(String classpageId) {
		this.classpageId = classpageId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	/**
	 * @return the isRequired
	 */
	public Boolean getIsRequired() {
		return isRequired;
	}
	/**
	 * @param isRequired the isRequired to set
	 */
	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}
	/**
	 * @return the resource
	 */
	public ResourceDo getResource() {
		return resource;
	}
	/**
	 * @param resource the resource to set
	 */
	public void setResource(ResourceDo resource) {
		this.resource = resource;
	}
	public Integer getItemSequence() {
		return itemSequence;
	}
	public void setItemSequence(Integer itemSequence) {
		this.itemSequence = itemSequence;
	}
	public String getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	public String getMinimumScore() {
		return minimumScore;
	}
	public void setMinimumScore(String minimumScore) {
		this.minimumScore = minimumScore;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}

}
