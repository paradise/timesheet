package com.aplana.timesheet.form.validator;


import com.aplana.timesheet.reports.*;
import com.aplana.timesheet.util.DateTimeUtil;
import com.aplana.timesheet.util.report.Report7Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

@Service
public class ReportFormValidator implements Validator {
    private static final Logger logger = LoggerFactory.getLogger(ReportFormValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(TSJasperReport.class);
    }

    @Override
    public void validate(Object o, Errors errors) {

        if (o.getClass().isAssignableFrom(Report06.class)) {
            validateReport06(o, errors);
        } else if (o.getClass().isAssignableFrom(Report05.class)) {
            validateReport05(o, errors);
        } else if (o.getClass().isAssignableFrom(Report02.class)) {
            validateReport02(o, errors);
        } else if (o.getClass().isAssignableFrom(Report04.class)) {
            validateReport04(o, errors);
        } else if (o.getClass().isAssignableFrom(Report01.class)) {
            validateReport01(o, errors);
        } else if (o.getClass().isAssignableFrom(Report03.class)) {
            validateReport03(o, errors);
        } else if (o.getClass().isAssignableFrom(Report07.class)) {
            validateReport07(o, errors);
        }

    }

    private void validateReport07(Object o, Errors errors) {
        Report07 report = (Report07) o;
        if ("".equals(report.getBeginDate()) || !DateTimeUtil.isDateValid(report.getBeginDate())) {
            errors.rejectValue("beginDate", "error.reportform.wrongbegindate");
        }

        if ("".equals(report.getEndDate()) || !DateTimeUtil.isDateValid(report.getEndDate())) {
            errors.rejectValue("endDate", "error.reportform.wrongenddate");
        }

        if (!DateTimeUtil.isPeriodValid(report.getBeginDate(), report.getEndDate())) {
            errors.rejectValue("beginDate", "error.reportform.wrongperiod");
        }

        if (report.getFilterDivisionOwner() && report.getDivisionOwner() == null) {
            errors.rejectValue("filterDivisionOwner", "error.reportform.noprojectdivision");
        }

        if (report.getDivisionEmployee() == null) {
            errors.rejectValue("divisionEmployee", "error.reportform.noemplyeedivision");
        }

        if (report.getPeriodType() != Report7Period.PERIOD_TYPE_MONTH
                && report.getPeriodType() != Report7Period.PERIOD_TYPE_HALF_YEAR
                && report.getPeriodType() != Report7Period.PERIOD_TYPE_KVARTAL
                && report.getPeriodType() != Report7Period.PERIOD_TYPE_YEAR) {
            errors.rejectValue("periodType", "error.reportform.wrongperiodtype");
        }
    }

    private void validateReport03(Object o, Errors errors) {
        Report03 form = (Report03) o;

        String beginDate = form.getBeginDate();
        if ("".equals(beginDate) || !DateTimeUtil.isDateValid(beginDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongbegindate");
        }

        String endDate = form.getEndDate();
        if ("".equals(endDate) || !DateTimeUtil.isDateValid(endDate)) {
            errors.rejectValue("endDate", "error.reportform.wrongenddate");
        }

        if (!DateTimeUtil.isPeriodValid(beginDate, endDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongperiod");
        }
    }

    private void validateReport01(Object o, Errors errors) {
        Report01 form = (Report01) o;

        List<Integer> regionIds = form.getRegionIds();
        // ничего не выбрано и не поставлена галка "Все регионы"
        if ((regionIds == null || regionIds.isEmpty()) && !form.isAllRegions()) {
            errors.rejectValue("regionIds", "error.reportform.noregion");
        }

        String beginDate = form.getBeginDate();
        if ("".equals(beginDate) || !DateTimeUtil.isDateValid(beginDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongbegindate");
        }

        String endDate = form.getEndDate();
        if ("".equals(endDate) || !DateTimeUtil.isDateValid(endDate)) {
            errors.rejectValue("endDate", "error.reportform.wrongenddate");
        }

        if (!DateTimeUtil.isPeriodValid(beginDate, endDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongperiod");
        }
    }

    private void validateReport04(Object o, Errors errors) {
        Report04 form = (Report04) o;
        String beginDate = form.getBeginDate();
        if ("".equals(beginDate) && !DateTimeUtil.isDateValid(beginDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongbegindate");
        }

        String endDate = form.getEndDate();
        if ("".equals(endDate) && !DateTimeUtil.isDateValid(endDate)) {
            errors.rejectValue("endDate", "error.reportform.wrongenddate");
        }

        if (!DateTimeUtil.isPeriodValid(beginDate, endDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongperiod");
        }
    }

    private void validateReport06(Object o, Errors errors) {
        Report06 form = (Report06) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectId", "error.reportform.noproject");

        if (form.getProjectId() == 0) {
            errors.rejectValue("projectId", "error.reportform.noproject");
        }

        String beginDate = form.getBeginDate();
        if (!"".equals(beginDate) && !DateTimeUtil.isDateValid(beginDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongbegindate");
        }

        String endDate = form.getEndDate();
        if (!"".equals(endDate) && !DateTimeUtil.isDateValid(endDate)) {
            errors.rejectValue("endDate", "error.reportform.wrongenddate");
        }

        if (!DateTimeUtil.isPeriodValid(beginDate, endDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongperiod");
        }
    }

    private void validateReport02(Object o, Errors errors) {
        Report02 form = (Report02) o;

        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectId", "error.reportform.noproject");

        String beginDate = form.getBeginDate();
        if ("".equals(beginDate) && !DateTimeUtil.isDateValid(beginDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongbegindate");
        }

        String endDate = form.getEndDate();
        if ("".equals(endDate) && !DateTimeUtil.isDateValid(endDate)) {
            errors.rejectValue("endDate", "error.reportform.wrongenddate");
        }

        if (!DateTimeUtil.isPeriodValid(beginDate, endDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongperiod");
        }
    }

    private void validateReport05(Object o, Errors errors) {
        Report05 form = (Report05) o;

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "divisionId", "error.reportform.nodivision");
//
//        if (form.getDivisionId() == 0) {
//            errors.rejectValue("divisionId", "error.reportform.nodivision");
//        }

        String beginDate = form.getBeginDate();
        if ("".equals(beginDate) && !DateTimeUtil.isDateValid(beginDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongbegindate");
        }

        String endDate = form.getEndDate();
        if ("".equals(endDate) && !DateTimeUtil.isDateValid(endDate)) {
            errors.rejectValue("endDate", "error.reportform.wrongenddate");
        }

        if (!DateTimeUtil.isPeriodValid(beginDate, endDate)) {
            errors.rejectValue("beginDate", "error.reportform.wrongperiod");
        }
    }
}
