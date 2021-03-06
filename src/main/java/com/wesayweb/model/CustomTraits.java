package com.wesayweb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "custom_traits")
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomTraits implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String traitname;

	@Getter
	@Setter
	private String traittype;

	@Getter
	@Setter
	private String traitdescripion;

	@Getter
	@Setter
	private String traiticonpath;

	@Getter
	@Setter
	private int activestatus;

	@Getter
	@Setter
	@Column(name = "deletestatus", nullable = false, columnDefinition = "int default 0")
	private int deletestatus;

	@Getter
	final Date creationdate = new Date();

	@Getter
	final Date updateondate = new Date();

	@Getter
	@Setter
	private Date approveddate;

	@Getter
	@Setter
	@Column(name = "traitidentifier", nullable = false, columnDefinition = "int default 100")
	private int traitidentifier;

	@Getter
	@Setter
	private String traituniqueid;

	@Getter
	@Setter
	@Transient
	private Long traitgivenfor;

	@Getter
	@Setter
	@Transient
	private int typeofvote;

}