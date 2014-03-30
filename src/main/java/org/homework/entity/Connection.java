package org.homework.entity;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * TODO: add comment
 */
@Entity
public class Connection implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String userAgent;

    private String clientIp;

    private Date creationtDate;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public void setCreationtDate(DateTime creationtDate) {
        this.creationtDate = creationtDate != null ? creationtDate.toDate() : null;
    }

    public DateTime getCreationtDate() {
        return creationtDate != null ? new DateTime(creationtDate) : null;
    }

    public Long getId() {
        return id;
    }
}
