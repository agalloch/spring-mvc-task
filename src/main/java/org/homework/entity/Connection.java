package org.homework.entity;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity that stores connection details.
 */
@Entity
@Table(name = "T_CONNECTION")
public class Connection implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @Column(name = "USER_AGENT")
    private String userAgent;

    @Column(name = "CLIENT_IP")
    private String clientIp;

    @Column(name = "CREATION_DATE")
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
