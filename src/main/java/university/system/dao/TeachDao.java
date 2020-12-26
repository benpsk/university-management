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

import university.system.dto.TeachDto;
import university.system.model.Teacher;

@Repository
public class TeachDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addTeach(Teacher teach) {
		getSession().save(teach);
	}

	public TeachDto teachByID(int id) {
		Criteria cr = getSession().createCriteria(Teacher.class);
		cr.createAlias("dept", "d", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("id", id));
		cr.setProjection(
				Projections.projectionList().add(Projections.property("id"), "id").add(Projections.property("name"), "name")
						.add(Projections.property("d.id"), "deptid").add(Projections.property("d.name"), "deptname"));
		cr.setResultTransformer(Transformers.aliasToBean(TeachDto.class));
		return (TeachDto) cr.uniqueResult();
	}

	public void upTeach(Teacher teach) {
		getSession().saveOrUpdate(teach);
	}

	public void delTeach(int id) {
		Teacher teach = getSession().load(Teacher.class, id);
		if (teach != null) {
			getSession().delete(teach);
		}
	}

	@SuppressWarnings("unchecked")
	public List<TeachDto> getTeach() {
		Criteria cr = getSession().createCriteria(Teacher.class);
		cr.createAlias("dept", "d", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(
				Projections.projectionList().add(Projections.property("id"), "id").add(Projections.property("name"), "name")
						.add(Projections.property("d.id"), "deptid").add(Projections.property("d.name"), "deptname"));
		cr.setResultTransformer(Transformers.aliasToBean(TeachDto.class));
		return (List<TeachDto>) cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<TeachDto> findByDeptId(int id) {
		Criteria cr = getSession().createCriteria(Teacher.class);
		cr.createAlias("dept", "d", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("d.id", id));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name").add(Projections.property("d.name"), "deptname"));
		cr.setResultTransformer(Transformers.aliasToBean(TeachDto.class));
		return (List<TeachDto>) cr.list();
	}

}

//public Teacher teachByID(int id) {
//	Criteria cr = getSession().createCriteria(Teacher.class);
//	cr.add(Restrictions.eq("id", id));
//	return (Teacher) cr.uniqueResult();
//}
//
//public void addTeach(Teacher teach) {
//	getSession().save(teach);
//}
//
//public void upTeach(Teacher teach) {
//	getSession().update(teach);
//}
//
//@SuppressWarnings("deprecation")
//public void delTeach(int id) {
//	Serializable ide = new Integer(id);
//	Object obj = getSession().load(Teacher.class, ide);
//	if (obj != null) {
//		getSession().delete(obj);
//	}
//}
//
//@SuppressWarnings("unchecked")
//public List<Teacher> getTeach() {
//	Criteria cr = getSession().createCriteria(Teacher.class);
//	return (List<Teacher>) cr.list();
//}
