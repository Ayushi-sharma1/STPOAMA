package com.stpoa.ashit.stpoa;

        import java.util.HashMap;

/**
 * Created by krsin on 04-04-2018.
 */

public class Sections {
    private String chapter_no;
    private String chapter_name;
    private String section_no;
    private String section_name;
    private String subsection_no;
    private String subsection_name;
    private String description_no;
    private String description_name;

    public Sections(){}//Default Constructor

    public Sections(String chapterNo, String chapterName, String sectionNo, String sectionName, String subsectionNo, String subsectionName,
                    String descriptionNo, String descriptionName)
    {
        this.chapter_no = chapterNo;
        this.chapter_name = chapterName;
        this.section_no = sectionNo;
        this.section_name = sectionName;
        this.subsection_no = subsectionNo;
        this.subsection_name = subsectionName;
        this.description_no = descriptionNo;
        this.description_name = descriptionName;
    }

    public String getChapter_no(){return chapter_no;}
    public String getChapter_name(){return chapter_name;}
    public String getSection_no(){return section_no;}
    public String getSection_name(){return section_name;}
    public String getSubsection_no(){return subsection_no;}
    public String getSubsection_name(){return subsection_name;}
    public String getDescription(){return description_no;}
    public String getDescription_name(){return description_name;}

    public HashMap<String, Object> mapSections(){
        HashMap<String, Object> output = new HashMap<>();
        output.put("chapter_no",chapter_no);
        output.put("chapter_name",chapter_name);
        output.put("section_no",section_no);
        output.put("section_name",section_name);
        output.put("subsection_no",subsection_no);
        output.put("subsection_name",subsection_name);
        output.put("description_no",description_no);
        output.put("description_name",description_name);
        return output;
    }
}
