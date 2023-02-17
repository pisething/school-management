package com.piseth.java.school.schoolManagement.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditing {
	@CreatedDate
	@Column(name = "date_created")
	private LocalDateTime dateCreate;
	
	@LastModifiedDate
	@Column(name = "date_updated")
	private LocalDateTime dateUpdate;

}
