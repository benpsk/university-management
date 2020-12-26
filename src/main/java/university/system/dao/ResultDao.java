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

import university.system.dto.ResultDto;
import university.system.model.Result;

@Repository
public class ResultDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Result result) {
		getSession().saveOrUpdate(result);
	}

	@SuppressWarnings("unchecked")
	public List<ResultDto> findAll() {
		Criteria cr = getSession().createCriteria(Result.class);
		cr.createAlias("std", "s", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.createAlias("extype", "et", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("s.name"), "studentname")
				.add(Projections.property("et.type"), "examtypename")
				.add(Projections.property("mark"), "mark").add(Projections.property("remark"), "remark")
				.add(Projections.property("qno"), "qno").add(Projections.property("correctno"), "correctno"));
		cr.setResultTransformer(Transformers.aliasToBean(ResultDto.class));
		return (List<ResultDto>) cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<ResultDto> findPass() {
		Criteria cr = getSession().createCriteria(Result.class);
		cr.add(Restrictions.eq("remark", "Pass"));
		cr.createAlias("std", "s", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.createAlias("extype", "et", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("s.name"), "studentname")
				.add(Projections.property("et.type"), "examtypename")
				.add(Projections.property("mark"), "mark").add(Projections.property("remark"), "remark")
				.add(Projections.property("qno"), "qno").add(Projections.property("correctno"), "correctno"));
		cr.setResultTransformer(Transformers.aliasToBean(ResultDto.class));
		return (List<ResultDto>) cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<ResultDto> findFail() {
		Criteria cr = getSession().createCriteria(Result.class);
		cr.add(Restrictions.eq("remark", "Fail"));
		cr.createAlias("std", "s", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.createAlias("extype", "et", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("s.name"), "studentname")
				.add(Projections.property("et.type"), "examtypename")
				.add(Projections.property("mark"), "mark").add(Projections.property("remark"), "remark")
				.add(Projections.property("qno"), "qno").add(Projections.property("correctno"), "correctno"));
		cr.setResultTransformer(Transformers.aliasToBean(ResultDto.class));
		return (List<ResultDto>) cr.list();
	}

}
