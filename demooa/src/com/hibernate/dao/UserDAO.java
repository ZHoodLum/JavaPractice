package com.hibernate.dao;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.User;
import com.struts.util.Constants;
import com.struts.util.Pager;

public class UserDAO extends HibernateDaoSupport implements IUserDAO {

	public boolean isValid(final String username, final String password) {
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(User.class).add(
						Restrictions.eq("username", username)).add(
						Restrictions.eq("password", password)).list();
				return result;
			}
		});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isExist(final String username) {
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(User.class).add(
						Restrictions.eq("username", username)).list();
				return result;
			}
		});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void insertUser(User user) {
		getHibernateTemplate().save(user);
	}
	
	public void updateUser(User user) {
		getHibernateTemplate().update(user);
	}

	public User getUser(String userid) {
		return (User) getHibernateTemplate().get(User.class,
				new Integer(userid));
	}

	public List getUsers() {
		return getHibernateTemplate().find("from User");
	}

	public void deleteUser(String userid) {
		Object p = getHibernateTemplate().load(User.class, new Integer(userid));
		getHibernateTemplate().delete(p);
	}
	
	public List findAllByUsername(final String username) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(User.class).add(
						Restrictions.eq("username", username)).list();
				return result;
			}
		});
	}
	
	/**
	 * if not pageSize and pageNo parameters, use default parameters
	 */
	public Pager findPagerByUsername(final String username) {
		return findPagerByUsername(username, Constants.pageSize, Constants.pageNo);
	}
	
	public Pager findPagerAllUser() {
		return findPagerAllUser(Constants.pageSize, Constants.pageNo);
	}
	
	public Pager findPagerAllUser(final int pageSize,
			final int pageNo) {		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		// set query condition
		Criteria criteria = session.createCriteria(User.class);
		// get total count
		int rowCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		
		// get current page list
		int startIndex = pageSize * (pageNo - 1);
		criteria.addOrder(Order.asc("username"));
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(pageSize);
		List result = criteria.list();
		
		session.close();

		return new Pager(pageSize, pageNo, rowCount, result);
	}
	
	/**
	 * when have pageSize and pageNo parameters
	 */
	public Pager findPagerByUsername(final String username, final int pageSize,
			final int pageNo) {		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		// set query condition
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		
		// get total count
		int rowCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		
		// get current page list
		int startIndex = pageSize * (pageNo - 1);
		criteria.addOrder(Order.asc("username"));
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(pageSize);
		List result = criteria.list();
		
		session.close();

		return new Pager(pageSize, pageNo, rowCount, result);
	}

	public User findById(String id) {
		return (User) getHibernateTemplate().get(User.class,
				new Integer(id));
	}
	
	public User findByUsername(final String username)
	{
		return (User) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				User result = (User)session.createCriteria(User.class).add(
						Restrictions.eq("username", username)).uniqueResult();
				return result;
			}
		});
	}
	
	public int getCounter(final String islogging)
	{
        Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		// set query condition
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("islogging", islogging));
		
		// get total count
		int count = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		return count;
	}
}
