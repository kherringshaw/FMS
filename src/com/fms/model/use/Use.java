package com.fms.model.use;



public class Use {

    private int usageId;
    private String startDate;
    private String endDate;
    private int facilityId;


    public int getUsageId() {
        return usageId;
    }

    public void setUsageId(int id) {
        this.usageId = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String date) {
        this.startDate = date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String date) {
        this.endDate = date;
    }
    
    public int getFacilityID() {
        return facilityID;
    }
    
    public void setFacilityID(int facID) { //possibly take a facility as an input instead
        this.facilityID = facID;
    }

}
