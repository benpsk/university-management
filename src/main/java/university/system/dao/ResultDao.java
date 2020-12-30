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
		cr.setProjection(Projections.projectionList().add(Projections.groupProperty("s.id").as("studentid"))
				.add(Projections.sum("mark").as("mark")).add(Projections.property("s.name"), "studentname")
				.add(Projections.property("s.rollno"), "rollno").add(Projections.groupProperty("et.id"), "examtypeid")
				.add(Projections.property("et.type"), "examtypename"));

		cr.setResultTransformer(Transformers.aliasToBean(ResultDto.class));
		return (List<ResultDto>) cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<ResultDto> findByEtypeId(Integer eid, Integer gid) {
		Criteria cr = getSession().createCriteria(Result.class);
		cr.createAlias("std", "s", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.createAlias("s.grade", "grade", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.createAlias("extype", "et", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("et.id", eid));
		cr.add(Restrictions.eq("grade.id", gid));
		cr.setProjection(Projections.projectionList().add(Projections.groupProperty("s.id").as("studentid"))
				.add(Projections.sum("mark").as("mark")).add(Projections.property("s.name"), "studentname")
				.add(Projections.property("s.rollno"), "rollno").add(Projections.groupProperty("et.id"), "examtypeid")
				.add(Projections.property("et.type"), "examtypename"));
		cr.setResultTransformer(Transformers.aliasToBean(ResultDto.class));
		return (List<ResultDto>) cr.list();
	}

	public ResultDto findByStdid(int id) {
		Criteria cr = getSession().createCriteria(Result.class);
		cr.createAlias("std", "s", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.createAlias("extype", "et", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("s.id", id));

		cr.setProjection(Projections.projectionList().add(Projections.groupProperty("s.id").as("studentid"))
				.add(Projections.sum("mark").as("mark")).add(Projections.property("s.name"), "studentname")
				.add(Projections.property("s.rollno"), "rollno").add(Projections.groupProperty("et.id"), "examtypeid")
				.add(Projections.property("et.type"), "examtypename"));
		cr.setResultTransformer(Transformers.aliasToBean(ResultDto.class));
		return (ResultDto) cr.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ResultDto> findStd(int id) {
		Criteria cr = getSession().createCriteria(Result.class);
		cr.createAlias("std", "s", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.createAlias("question", "q", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.createAlias("answers", "a", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("s.id", id));
		cr.setProjection(Projections.projectionList().add(Projections.property("mark"), "mark")
				.add(Projections.property("q.id"), "questionid").add(Projections.property("q.qname"), "questionname")
				.add(Projections.property("a.id"), "answerid").add(Projections.property("a.ans"), "answername"));
		cr.setResultTransformer(Transformers.aliasToBean(ResultDto.class));
		return (List<ResultDto>) cr.list();
	}

}
