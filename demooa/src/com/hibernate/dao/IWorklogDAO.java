package com.hibernate.dao;

import com.hibernate.beans.Worklog;
import com.struts.util.Pager;

public interface IWorklogDAO {

	public Pager findPagerByUsername(final String username, final int pageNo,
			final int pageSize);

	public Worklog findById(String id);

	public void insert(Worklog worklog);

	public void update(Worklog worklog);

	public void delete(String id);
}
