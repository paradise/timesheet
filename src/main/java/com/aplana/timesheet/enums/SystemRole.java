package com.aplana.timesheet.enums;

/**
 * @author eshangareev
 * @version 1.0
 */
public enum SystemRole {
    LEADER(1), SYSTEM_ENGINEER(2), OTHER(0);

    private int id;

    private SystemRole( int id ) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
