package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Schedule;
import com.struts.util.Pager;

public class ScheduleDAO extends HibernateDaoSupport implements IScheduleDAO {
	
	/**
	 * when have pageSize and pageNo parameters
	 */
	public Pager findPagerByUsername(final String username, final int pageSize,
			final int pageNo) {		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		// set query condition
		Criteria criteria = session.createCriteria(Schedule.class);
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

	public Schedule findById(String id) {
		return (Schedule) getHibernateTemplate().get(Schedule.class,
				new Integer(id));
	}

	public void insert(Schedule schedule) {
		getHibernateTemplate().save(schedule);
	}

	public void update(Schedule schedule) {
		getHibernateTemplate().update(schedule);
	}

	public void delete(String id) {
		Object p = getHibernateTemplate().load(Schedule.class, new Integer(id));
		getHibernateTemplate().delete(p);
	}

}
