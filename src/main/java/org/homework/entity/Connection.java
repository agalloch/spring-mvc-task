package org.homework.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

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
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationDate;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getClientIp() {
        return clientIp;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }
}
