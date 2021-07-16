package com.datdt.AssignmentSpringboot.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "tbl_status")
public class StatusOrder implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private long statusId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_name")
    @NaturalId
    private StatusProduct name;

    public StatusOrder() {
        super();
    }

    public StatusOrder(long statusId, StatusProduct name) {
        super();
        this.statusId = statusId;
        this.name = name;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }


    public StatusProduct getName() {
        return name;
    }

    public void setName(StatusProduct name) {
        this.name = name;
    }

    @Override
	public int hashCode() {
		return Objects.hash(statusId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusOrder order = (StatusOrder) obj;
		return Objects.equals(statusId, order.statusId);
	}
    
}
