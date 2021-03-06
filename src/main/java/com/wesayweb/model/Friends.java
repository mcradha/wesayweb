package com.wesayweb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Table(name = "friend_list")
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Friends implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	@OneToOne(cascade = CascadeType.ALL,     orphanRemoval=true, fetch=FetchType.LAZY )
	@JoinColumns({
	    @JoinColumn(name="friendsid", referencedColumnName="id",  insertable = false, updatable = false)
	})
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private User user;  

	@Getter
	@Setter
	@OneToOne(cascade = CascadeType.ALL,     orphanRemoval=true, fetch=FetchType.LAZY )
	@JoinColumns({
	    @JoinColumn(name="userid", referencedColumnName="id",  insertable = false, updatable = false)
	})
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private User friendUser;  

	
	
	@Getter
	@Setter
	private Long userid;
	
	@Getter
	@Setter
	private Long friendsid;

	@Getter
	@Setter
	private int addedvia;

	@Getter
	final Date addeddate = new Date();

	@Getter
	@Setter
	private int invitationacceptstatus;

	@Getter
	@Setter
	private Long invitedby;

	@Getter
	@Setter
	private int activestatus;

	@Getter
	@Setter
	private Date invitationacceptdate;

	@Getter
	@Setter
	private String requestuniqueid;

	 
}