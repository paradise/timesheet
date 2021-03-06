package com.aplana.timesheet.form;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;

public class TimeSheetForm
{
	private Integer divisionId;
	private Integer employeeId;
	private List<TimeSheetTableRowForm> timeSheetTablePart;
	private String calDate;
	private String plan;
	private double totalDuration;
	private String beginLongDate; //Начало продолжительного(й) отпуска(болезни) 
	private String endLongDate; //Конец продолжительного(й) отпуска(болезни)
	private boolean longVacation; // Продолжительный отпуск
	private boolean longIllness; // Продолжительная болезнь

	public String getBeginLongDate() {
		return beginLongDate;
	}

	public void setBeginLongDate(String beginLongDate) {
		this.beginLongDate = beginLongDate;
	}

	public String getEndLongDate() {
		return endLongDate;
	}

	public void setEndLongDate(String endLongDate) {
		this.endLongDate = endLongDate;
	}

	public boolean isLongVacation() {
		return longVacation;
	}

	public void setLongVacation(boolean longVacation) {
		this.longVacation = longVacation;
	}

	public boolean isLongIllness() {
		return longIllness;
	}

	public void setLongIllness(boolean longIllness) {
		this.longIllness = longIllness;
	}

	public Integer getDivisionId()
	{
		return divisionId;
	}

	public void setDivisionId(Integer divisionId)
	{
		this.divisionId = divisionId;
	}
	
	public double getTotalDuration()
	{
		return totalDuration;
	}

	public void setTotalDuration(double totalDuration)
	{
		this.totalDuration = totalDuration;
	}

	public List<TimeSheetTableRowForm> getTimeSheetTablePart()
	{
		return timeSheetTablePart;
	}
	
	public String getPlan()
	{
		return plan;
	}
	
	public void setTimeSheetTablePart(List<TimeSheetTableRowForm> timeSheetTablePart)
	{
		this.timeSheetTablePart = timeSheetTablePart;
	}
	
	public void setPlan(String plan)
	{
		this.plan = plan;
	}

	public String getCalDate()
	{
		return calDate;
	}

	public Integer getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId)
	{
		this.employeeId = employeeId;
	}

	public void setCalDate(String calDate)
	{
		this.calDate = calDate;
	}

    public String getPlanEscaped()
    {
        return StringEscapeUtils.escapeHtml4(this.plan);
    }

}