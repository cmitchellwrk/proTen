/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
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
@Table(name = "inbox")
@NamedQueries({
    @NamedQuery(name = "Inbox.findAll", query = "SELECT i FROM Inbox i"),
    @NamedQuery(name = "Inbox.findById", query = "SELECT i FROM Inbox i WHERE i.id = :id"),
    @NamedQuery(name = "Inbox.findByRemoveinmsg", query = "SELECT i FROM Inbox i WHERE i.removeinmsg = :removeinmsg"),
    @NamedQuery(name = "Inbox.findByReplyToId", query = "SELECT i FROM Inbox i WHERE i.replyToId = :replyToId"),
    @NamedQuery(name = "Inbox.findByImageurl", query = "SELECT i FROM Inbox i WHERE i.imageurl = :imageurl"),
    @NamedQuery(name = "Inbox.findBySendtoid", query = "SELECT i FROM Inbox i WHERE i.sendtoid = :sendtoid"),
    @NamedQuery(name = "Inbox.findBySendfromid", query = "SELECT i FROM Inbox i WHERE i.sendfromid = :sendfromid"),
    @NamedQuery(name = "Inbox.findBySentFrom", query = "SELECT i FROM Inbox i WHERE i.sentFrom = :sentFrom"),
    @NamedQuery(name = "Inbox.findBySentTo", query = "SELECT i FROM Inbox i WHERE i.sentTo = :sentTo"),
    @NamedQuery(name = "Inbox.findBySubject", query = "SELECT i FROM Inbox i WHERE i.subject = :subject"),
    @NamedQuery(name = "Inbox.findByMessageDate", query = "SELECT i FROM Inbox i WHERE i.messageDate = :messageDate"),
    @NamedQuery(name = "Inbox.findByStatus", query = "SELECT i FROM Inbox i WHERE i.status = :status"),
    @NamedQuery(name = "Inbox.findByNow", query = "SELECT i FROM Inbox i WHERE i.now = :now")})
public class Inbox implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id = genId();
    @Basic(optional = false)
    @Column(name = "removeinmsg")
    private boolean removeinmsg;
    @Basic(optional = false)
    @Column(name = "reply_to_id")
    private String replyToId = "-1";
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
    private String messageDate  =  SimpleDateFormatmethod();
    @Basic(optional = false)
    @Lob
    @Column(name = "msgText")
    private String msgText;
    @Basic(optional = false)
    @Column(name = "status")
    private String status = "unread";
    @Basic(optional = false)
    @Column(name = "now")
    private String now ="offline";

    public Inbox() {
    }

    public Inbox(String id) {
        this.id = id;
    }

    public Inbox(String id, boolean removeinmsg, String replyToId, String imageurl, long sendtoid, long sendfromid, String sentFrom, String sentTo, String subject, String messageDate, String msgText, String status, String now) {
        this.id = id;
        this.removeinmsg = removeinmsg;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getRemoveinmsg() {
        return removeinmsg;
    }

    public void setRemoveinmsg(boolean removeinmsg) {
        this.removeinmsg = removeinmsg;
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

    
      public String SimpleDateFormatmethod() {
        Calendar date = Calendar.getInstance();
        SimpleDateFormat dateformatter = new SimpleDateFormat(" MM/dd/yyyy hh:mm:ss a zzz");
        return (dateformatter.format(date.getTime()));

    }

    public String genId() {

        String uniqueID = UUID.randomUUID().toString();

        return uniqueID;
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
        if (!(object instanceof Inbox)) {
            return false;
        }
        Inbox other = (Inbox) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Inbox[id=" + id + "]";
    }

}
