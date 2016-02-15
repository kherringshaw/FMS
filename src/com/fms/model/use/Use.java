package com.fms.model.use;



public class Use {

    private int usageId;
    private Date startDate;
    private Date endDate;
    private Facility facility;


    public int getUsageId() {
        return usageId;
    }

    public void setUsageId(int id) {
        this.usageId = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date date) {
        this.endDate = date;
    }
    
    public Facility getFacility() {
        return facility;
    }
    
    public void setFacility(Facility f) { 
        this.facility = f;
    }

}
