package netgloo.models;

public class DocumentDTO {

    private String tagAttributes;
    private String bodyAttributes;
    private String name;
    private String languageCode;
    private Integer docIDF;

    public String getTagAttributes() {
        return tagAttributes;
    }

    public void setTagAttributes(String tagAttributes) {
        this.tagAttributes = tagAttributes;
    }

    public String getBodyAttributes() {
        return bodyAttributes;
    }

    public void setBodyAttributes(String bodyAttributes) {
        this.bodyAttributes = bodyAttributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Integer getDocIDF() {
        return docIDF;
    }

    public void setDocIDF(Integer docIDF) {
        this.docIDF = docIDF;
    }

    @Override
    public String toString() {
        return "DocumentDTO [tagAttributes=" + tagAttributes + ", bodyAttributes=" + bodyAttributes + ", name=" + name
                + ", languageCode=" + languageCode + ", docIDF=" + docIDF + "]";
    }

}
