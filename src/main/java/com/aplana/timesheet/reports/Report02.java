package com.aplana.timesheet.reports;

import com.aplana.timesheet.dao.JasperReportDAO;
import net.sf.jasperreports.engine.JRDataSource;

public class Report02 extends BaseReport {

    public static final String jrName = "report02";

    public static final String jrNameFile = "Отчет №2. Сводный отчет затраченного времени по проекту";

    @Override
    public String getJRName() {
        return jrName;
    }

    @Override
    public String getJRNameFile() {
        return jrNameFile;
    }

    @Override
    public JRDataSource prepareDataSource() {
        return reportDAO.getReport02Data(this);
    }

    private boolean filterProjects = true;

    private Integer projectId;

    private Integer emplDivisionId;

    private Integer employeeId;

    private Integer divisionId;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmplDivisionId() {
        return emplDivisionId;
    }

    public void setEmplDivisionId(Integer emplDivisionId) {
        this.emplDivisionId = emplDivisionId;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public Boolean getFilterProjects() {
        return filterProjects;
    }

    public void setFilterProjects(Boolean filterProjects) {
        this.filterProjects = filterProjects;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
