package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Worklog;
import com.struts.util.Pager;

public class WorklogDAO extends HibernateDaoSupport implements IWorklogDAO {
	
	/**
	 * when have pageSize and pageNo parameters
	 */
	public Pager findPagerByUsername(final String username, final int pageSize,
			final int pageNo) {		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		// set query condition
		Criteria criteria = session.createCriteria(Worklog.class);
		criteria.add(Restrictions.eq("username", username));
		
		// get total count
		int rowCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		
		// get current page list
		int startIndex = pageSize * (pageNo - 1);
		criteria.addOrder(Order.desc("year"));
		criteria.addOrder(Order.desc("month"));
		criteria.addOrder(Order.desc("day"));
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(pageSize);
		List result = criteria.list();
		
		session.close();

		return new Pager(pageSize, pageNo, rowCount, result);
	}

	public Worklog findById(String id) {
		return (Worklog) getHibernateTemplate().get(Worklog.class,
				new Integer(id));
	}

	public void insert(Worklog worklog) {
		getHibernateTemplate().save(worklog);
	}

	public void update(Worklog worklog) {
		getHibernateTemplate().update(worklog);
	}

	public void delete(String id) {
		Object p = getHibernateTemplate().load(Worklog.class, new Integer(id));
		getHibernateTemplate().delete(p);
	}

}
