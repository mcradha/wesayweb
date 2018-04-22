package com.wesayweb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.wesayweb.model.Traits;
import com.wesayweb.model.UserTrait;
import com.wesayweb.repository.UserTraitCustomRepository;
import com.wesayweb.response.model.TraitsResponsePojo;

@Service
public class UserTraitRepositoryImpl implements UserTraitCustomRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<UserTrait> getMyTraits(long giveuserid, long targetuserid) {
		Criteria crit = em.unwrap(Session.class).createCriteria(UserTrait.class);
		crit.add(Restrictions.eq("givenbyuserid", giveuserid));
		crit.add(Restrictions.eq("targetuserid", targetuserid));
		//crit.add(Restrictions.eq("isactive", 1));
		return crit.list();
	}

	@Override
	public List<Object[]> getMyTraits(long targetuserid) {
		 return em.createNamedQuery("getmytraits").getResultList();
		 
	}

}
