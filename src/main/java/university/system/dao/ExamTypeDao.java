package university.system.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.system.dto.ExamTypeDto;
import university.system.model.ExamType;

@Repository
public class ExamTypeDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(ExamType etype) {
		getSession().saveOrUpdate(etype);
	}

	@SuppressWarnings("unchecked")
	public List<ExamTypeDto> findAll() {
		Criteria cr = getSession().createCriteria(ExamType.class);
		cr.createAlias("exam", "e", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(
				Projections.projectionList().add(Projections.property("id"), "id").add(Projections.property("type"), "type")
						.add(Projections.property("e.id"), "examid").add(Projections.property("e.name"), "examname"));
		cr.setResultTransformer(Transformers.aliasToBean(ExamTypeDto.class));
		return (List<ExamTypeDto>) cr.list();
	}

	public ExamTypeDto findById(int id) {
		Criteria cr = getSession().createCriteria(ExamType.class);
		cr.add(Restrictions.eq("id", id));
		cr.createAlias("exam", "e", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(
				Projections.projectionList().add(Projections.property("id"), "id").add(Projections.property("type"), "type")
						.add(Projections.property("e.id"), "examid").add(Projections.property("e.name"), "examname"));
		cr.setResultTransformer(Transformers.aliasToBean(ExamTypeDto.class));
		return (ExamTypeDto) cr.uniqueResult();
	}

	public void delete(int id) {
		ExamType et = getSession().load(ExamType.class, id);
		if (et != null) {
			getSession().delete(et);
		}
	}

	public void update(ExamType e) {
		getSession().update(e);
	}

}
