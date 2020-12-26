package university.system.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.system.dto.QuestionDto;
import university.system.model.Question;

@Repository
public class QuestionDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Question q) {
		getSession().saveOrUpdate(q);
	}

	public QuestionDto findById(int id) {
		Criteria cr = getSession().createCriteria(Question.class);
		cr.add(Restrictions.eq("id", id));
		cr.createAlias("etype", "et", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("qname"), "qname").add(Projections.property("mark"), "mark")
				.add(Projections.property("et.id"), "etypeid").add(Projections.property("et.type"), "etypename"));
		cr.setResultTransformer(Transformers.aliasToBean(QuestionDto.class));
		return (QuestionDto) cr.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<QuestionDto> findAll() {
		Criteria cr = getSession().createCriteria(Question.class);
		cr.createAlias("etype", "et", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("qname"), "qname").add(Projections.property("mark"), "mark")
				.add(Projections.property("et.id"), "etypeid").add(Projections.property("et.type"), "etypename"));
		cr.setResultTransformer(Transformers.aliasToBean(QuestionDto.class));
		return (List<QuestionDto>) cr.list();
	}

	public void delete(int id) {
		Question q = getSession().load(Question.class, id);
		if (q != null) {
			getSession().delete(q);
		}
	}

	public void update(Question q) {
		getSession().update(q);
	}

	public QuestionDto lastQ() {
		Criteria cr = getSession().createCriteria(Question.class);
		cr.addOrder(Order.desc("id"));
		cr.setMaxResults(1);
		cr.createAlias("etype", "et", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("qname"), "qname").add(Projections.property("mark"), "mark")
				.add(Projections.property("et.id"), "etypeid").add(Projections.property("et.type"), "etypename"));
		cr.setResultTransformer(Transformers.aliasToBean(QuestionDto.class));
		return (QuestionDto) cr.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<QuestionDto> findByEid(int eid) {
		Criteria cr = getSession().createCriteria(Question.class);
		cr.createAlias("etype", "et", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("et.id", eid));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("qname"), "qname").add(Projections.property("mark"), "mark")
				.add(Projections.property("et.id"), "etypeid").add(Projections.property("et.type"), "etypename"));
		cr.setResultTransformer(Transformers.aliasToBean(QuestionDto.class));
		return (List<QuestionDto>) cr.list();
	}
}
