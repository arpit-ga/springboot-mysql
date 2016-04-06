package netgloo.models;

/*import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer docID;

    private Date createdDate;

    private String tagAttributes;
  
    private transient Set<DocTransitionInfo> docTransitionInfo;

    public Document() {

    }

    public Document(String tagAttributes) {
        this.tagAttributes = tagAttributes;
    }

    public Document(Integer docID) {
        this.docID = docID;
    }

    public Integer getDocID() {
        return docID;
    }

    public void setDocID(Integer docID) {
        this.docID = docID;
    }

    public String getTagAttributes() {
        return tagAttributes;
    }

    public void setTagAttributes(String tagAttributes) {
        this.tagAttributes = tagAttributes;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<DocTransitionInfo> getDocTransitionInfo() {
        return docTransitionInfo;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docIdf")
    public void setDocTransitionInfo(Set<DocTransitionInfo> docTransitionInfo) {
        this.docTransitionInfo = docTransitionInfo;
    }

    @Override
    public String toString() {
        return "Document [docID=" + docID + ", createdDate=" + createdDate + ", tagAttributes=" + tagAttributes + "]";
    }

}
*/

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonBackReference;


/**
 *
 * @author NIRAJ
 */
@Entity
@Table(name = "document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
    @NamedQuery(name = "Document.findByDocID", query = "SELECT d FROM Document d WHERE d.docID = :docID"),
    @NamedQuery(name = "Document.findByCreatedDate", query = "SELECT d FROM Document d WHERE d.createdDate = :createdDate"),
    @NamedQuery(name = "Document.findByTagAttributes", query = "SELECT d FROM Document d WHERE d.tagAttributes = :tagAttributes")})
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "docID")
    private Integer docID;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "tagAttributes")
    private String tagAttributes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docIdf")
    @JsonBackReference
    private Collection<Doctransitioninfo> doctransitioninfoCollection;

    public Document() {
    }

    public Document(Integer docID) {
        this.docID = docID;
    }

    public Integer getDocID() {
        return docID;
    }

    public void setDocID(Integer docID) {
        this.docID = docID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTagAttributes() {
        return tagAttributes;
    }

    public void setTagAttributes(String tagAttributes) {
        this.tagAttributes = tagAttributes;
    }

    @XmlTransient
    public Collection<Doctransitioninfo> getDoctransitioninfoCollection() {
        return doctransitioninfoCollection;
    }

    public void setDoctransitioninfoCollection(Collection<Doctransitioninfo> doctransitioninfoCollection) {
        this.doctransitioninfoCollection = doctransitioninfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docID != null ? docID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.docID == null && other.docID != null) || (this.docID != null && !this.docID.equals(other.docID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Document [docID=" + docID + ", createdDate=" + createdDate + ", tagAttributes=" + tagAttributes + "]";
    }

}
