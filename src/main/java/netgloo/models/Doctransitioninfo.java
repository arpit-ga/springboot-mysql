package netgloo.models;

/*@Entity
 @Table(name = "doctransitioninfo")
 public class DocTransitionInfo {

 private static final long serialVersionUID = 1L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer transitionID;
 private String name;
 private String languageCode;
 private String bodyAttributes;

 private transient Document docIdf;

 public DocTransitionInfo() {

 }

 public DocTransitionInfo(Integer transitionID, String bodyAttributes, Document docIdf) {
 this.transitionID = transitionID;
 this.bodyAttributes = bodyAttributes;
 this.docIdf = docIdf;
 }

 public Integer getTransitionID() {
 return transitionID;
 }

 public void setTransitionID(Integer transitionID) {
 this.transitionID = transitionID;
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

 public String getBodyAttributes() {
 return bodyAttributes;
 }

 public void setBodyAttributes(String bodyAttributes) {
 this.bodyAttributes = bodyAttributes;
 }


 @ManyToOne
 @JoinColumn(name = "docIdf", referencedColumnName = "docID")
 public Document getDocIdf() {
 return docIdf;
 }

 public void setDocIdf(Document docIdf) {
 this.docIdf = docIdf;
 }

 @Override
 public String toString() {
 return "DocTransitionInfo [transitionID=" + transitionID + ", name=" + name + ", languageCode=" + languageCode
 + ", bodyAttributes=" + bodyAttributes + ", docIdf=" + docIdf + "]";
 }

 }
 */
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 *
 * @author NIRAJ
 */
@Entity
@Table(name = "doctransitioninfo")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Doctransitioninfo.findAll", query = "SELECT d FROM Doctransitioninfo d"),
        @NamedQuery(name = "Doctransitioninfo.findByTransitionID", query = "SELECT d FROM Doctransitioninfo d WHERE d.transitionID = :transitionID"),
        @NamedQuery(name = "Doctransitioninfo.findByBodyAttributes", query = "SELECT d FROM Doctransitioninfo d WHERE d.bodyAttributes = :bodyAttributes"),
        @NamedQuery(name = "Doctransitioninfo.findByName", query = "SELECT d FROM Doctransitioninfo d WHERE d.name = :name"),
        @NamedQuery(name = "Doctransitioninfo.findByLanguageCode", query = "SELECT d FROM Doctransitioninfo d WHERE d.languageCode = :languageCode") })
public class Doctransitioninfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transitionID")
    private Integer transitionID;
    @Column(name = "bodyAttributes")
    private String bodyAttributes;
    @Column(name = "name")
    private String name;
    @Column(name = "languageCode")
    private String languageCode;
    @JoinColumn(name = "docIdf", referencedColumnName = "docID")
    @JsonManagedReference
    @ManyToOne(optional = false)
    private Document docIdf;

    public Doctransitioninfo() {
    }

    public Doctransitioninfo(Integer transitionID) {
        this.transitionID = transitionID;
    }

    public Integer getTransitionID() {
        return transitionID;
    }

    public void setTransitionID(Integer transitionID) {
        this.transitionID = transitionID;
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

    public Document getDocIdf() {
        return docIdf;
    }

    public void setDocIdf(Document docIdf) {
        this.docIdf = docIdf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transitionID != null ? transitionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctransitioninfo)) {
            return false;
        }
        Doctransitioninfo other = (Doctransitioninfo) object;
        if ((this.transitionID == null && other.transitionID != null)
                || (this.transitionID != null && !this.transitionID.equals(other.transitionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Doctransitioninfo [transitionID=" + transitionID + ", bodyAttributes=" + bodyAttributes + ", name="
                + name + ", languageCode=" + languageCode + ", docIdf=" + docIdf + "]";
    }

   

}
