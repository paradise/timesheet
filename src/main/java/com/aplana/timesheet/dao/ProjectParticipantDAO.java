package com.aplana.timesheet.dao;


import com.aplana.timesheet.dao.entity.ProjectParticipant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class ProjectParticipantDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public ProjectParticipant find(Integer id) {
		return entityManager.find(ProjectParticipant.class, id);
	}
	
}