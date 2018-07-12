package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Address;
import com.struts.util.Constants;
import com.struts.util.Pager;

public class AddressDAO extends HibernateDaoSupport implements IAddressDAO {

	/**
	 * get address list
	 */
	public List findAllByUsername(final String username) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Address.class).add(
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
	
	/**
	 * when have pageSize and pageNo parameters
	 */
	public Pager findPagerByUsername(final String username, final int pageSize,
			final int pageNo) {		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		// set query condition
		Criteria criteria = session.createCriteria(Address.class);
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

	public Address findById(String id) {
		return (Address) getHibernateTemplate().get(Address.class,
				new Integer(id));
	}

	public boolean isExist(final String username, final String name) {
		List list = (List) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						List result = session.createCriteria(Address.class)
								.add(Restrictions.eq("username", username))
								.add(Restrictions.eq("name", name)).list();
						return result;
					}
				});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void insert(Address address) {
		getHibernateTemplate().save(address);
	}

	public void update(Address address) {
		getHibernateTemplate().update(address);
	}

	public void delete(String id) {
		Object p = getHibernateTemplate().load(Address.class, new Integer(id));
		getHibernateTemplate().delete(p);
	}

}
