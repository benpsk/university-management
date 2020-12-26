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

import university.system.dto.GradeDto;
import university.system.model.Grade;

@Repository
public class GradeDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addGrade(Grade grade) {
		getSession().saveOrUpdate(grade);
	}

	public void upGrade(Grade grade) {
		getSession().update(grade);
	}

	public void delGrade(int id) {
		Object obj = getSession().load(Grade.class, id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	public GradeDto getGradeByID(int id) {
		Criteria cr = getSession().createCriteria(Grade.class);
		cr.add(Restrictions.eq("id", id));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name"));
		cr.setResultTransformer(Transformers.aliasToBean(GradeDto.class));
		return (GradeDto) cr.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<GradeDto> getGrade() {
		Criteria cr = getSession().createCriteria(Grade.class);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name"));
		cr.setResultTransformer(Transformers.aliasToBean(GradeDto.class));
		return (List<GradeDto>) cr.list();
	}

}
