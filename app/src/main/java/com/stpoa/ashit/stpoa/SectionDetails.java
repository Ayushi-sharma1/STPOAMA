package com.stpoa.ashit.stpoa;

import java.util.HashMap;

/**
 * Created by krsin on 08-04-2018.
 */

public class SectionDetails {
    private String SectionNo,SectionName,SubSectionNo,SubSectionName;

    //Default constructor for DataSnapsort.getValue(SectionDetails.class);
    SectionDetails(){}

    public SectionDetails (String SectionNo, String SectionName, String SubSectionNo, String SubSectionName) {
        this.SectionNo = SectionNo;
        this.SectionName = SectionName;
        this.SubSectionNo = SubSectionNo;
        this.SubSectionName = SubSectionName;
    }

    public String getSubSectionNo() {return SubSectionNo ;}
    public String getSubSectionName() {return SubSectionName;}

    public HashMap<String , Boolean> mapSubSectionName() {
        HashMap<String , Boolean> output = new HashMap<>();
        output.put(SubSectionName,true);
        return output;
    }

    public HashMap<String , Object> mapNewSectionNoDelatil() {
        HashMap<String , Object> output = new HashMap<>();
        output.put("SectionNo",SectionNo);
        output.put("SectionName",SectionName);
        output.put("SubSectionNo",SubSectionNo);
        output.put("SubSectionName",mapSubSectionName());
        return output;
    }
}
