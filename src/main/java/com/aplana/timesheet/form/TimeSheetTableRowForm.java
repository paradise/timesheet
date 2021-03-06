package com.aplana.timesheet.form;

import org.apache.commons.lang3.StringEscapeUtils;

public class TimeSheetTableRowForm {
	private String cqId;
	private String description;
	private String duration;
	private String problem;
	private String other;
	private Integer projectId;
	private Integer activityTypeId;
	private Integer activityCategoryId;
	private Integer projectRoleId;

	public Integer getProjectRoleId() {
		return projectRoleId;
	}

	public void setProjectRoleId(Integer projectRoleId) {
		this.projectRoleId = projectRoleId;
	}

	public String getCqId() {
		return cqId;
	}

	public String getDescription() {
		return description;
	}

	public String getDuration() {
		return duration;
	}

	public String getProblem() {
		return problem;
	}

	public String getOther() {
		return other;
	}

	public void setCqId(String cqId) {
		this.cqId = cqId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public Integer getActivityTypeId() {
		return activityTypeId;
	}

	public Integer getActivityCategoryId() {
		return activityCategoryId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public void setActivityTypeId(Integer activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	public void setActivityCategoryId(Integer activityCategoryId) {
		this.activityCategoryId = activityCategoryId;
	}

    public String getDescriptionEscaped()
    {
        return StringEscapeUtils.escapeHtml4(this.description);
    }

    public String getProblemEscaped()
    {
        return StringEscapeUtils.escapeHtml4(this.problem);
    }
}