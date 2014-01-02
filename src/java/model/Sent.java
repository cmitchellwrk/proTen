/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Chris Mitchell
 */
@Entity
@Table(name = "sent")
@NamedQueries({
    @NamedQuery(name = "Sent.findAll", query = "SELECT s FROM Sent s"),
    @NamedQuery(name = "Sent.findByRemovesntmsg", query = "SELECT s FROM Sent s WHERE s.removesntmsg = :removesntmsg"),
    @NamedQuery(name = "Sent.findById", query = "SELECT s FROM Sent s WHERE s.id = :id"),
    @NamedQuery(name = "Sent.findByReplyToId", query = "SELECT s FROM Sent s WHERE s.replyToId = :replyToId"),
    @NamedQuery(name = "Sent.findByImageurl", query = "SELECT s FROM Sent s WHERE s.imageurl = :imageurl"),
    @NamedQuery(name = "Sent.findBySendtoid", query = "SELECT s FROM Sent s WHERE s.sendtoid = :sendtoid"),
    @NamedQuery(name = "Sent.findBySendfromid", query = "SELECT s FROM Sent s WHERE s.sendfromid = :sendfromid"),
    @NamedQuery(name = "Sent.findBySentFrom", query = "SELECT s FROM Sent s WHERE s.sentFrom = :sentFrom"),
    @NamedQuery(name = "Sent.findBySentTo", query = "SELECT s FROM Sent s WHERE s.sentTo = :sentTo"),
    @NamedQuery(name = "Sent.findBySubject", query = "SELECT s FROM Sent s WHERE s.subject = :subject"),
    @NamedQuery(name = "Sent.findByMessageDate", query = "SELECT s FROM Sent s WHERE s.messageDate = :messageDate"),
    @NamedQuery(name = "Sent.findByStatus", query = "SELECT s FROM Sent s WHERE s.status = :status"),
    @NamedQuery(name = "Sent.findByNow", query = "SELECT s FROM Sent s WHERE s.now = :now")})
public class Sent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "removesntmsg")
    private boolean removesntmsg;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "reply_to_id")
    private String replyToId;
    @Basic(optional = false)
    @Column(name = "imageurl")
    private String imageurl;
    @Basic(optional = false)
    @Column(name = "sendtoid")
    private long sendtoid;
    @Basic(optional = false)
    @Column(name = "sendfromid")
    private long sendfromid;
    @Basic(optional = false)
    @Column(name = "SentFrom")
    private String sentFrom;
    @Basic(optional = false)
    @Column(name = "SentTo")
    private String sentTo;
    @Basic(optional = false)
    @Column(name = "Subject")
    private String subject;
    @Basic(optional = false)
    @Column(name = "MessageDate")
    private String messageDate;
    @Basic(optional = false)
    @Lob
    @Column(name = "msgText")
    private String msgText;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "now")
    private String now;

    public Sent() {
    }

    public Sent(String id) {
        this.id = id;
    }

    public Sent(String id, boolean removesntmsg, String replyToId, String imageurl, long sendtoid, long sendfromid, String sentFrom, String sentTo, String subject, String messageDate, String msgText, String status, String now) {
        this.id = id;
        this.removesntmsg = removesntmsg;
        this.replyToId = replyToId;
        this.imageurl = imageurl;
        this.sendtoid = sendtoid;
        this.sendfromid = sendfromid;
        this.sentFrom = sentFrom;
        this.sentTo = sentTo;
        this.subject = subject;
        this.messageDate = messageDate;
        this.msgText = msgText;
        this.status = status;
        this.now = now;
    }

    public boolean getRemovesntmsg() {
        return removesntmsg;
    }

    public void setRemovesntmsg(boolean removesntmsg) {
        this.removesntmsg = removesntmsg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReplyToId() {
        return replyToId;
    }

    public void setReplyToId(String replyToId) {
        this.replyToId = replyToId;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public long getSendtoid() {
        return sendtoid;
    }

    public void setSendtoid(long sendtoid) {
        this.sendtoid = sendtoid;
    }

    public long getSendfromid() {
        return sendfromid;
    }

    public void setSendfromid(long sendfromid) {
        this.sendfromid = sendfromid;
    }

    public String getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sent)) {
            return false;
        }
        Sent other = (Sent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sent[id=" + id + "]";
    }

}
