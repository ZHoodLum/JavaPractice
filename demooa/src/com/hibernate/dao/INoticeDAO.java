package com.hibernate.dao;

import com.hibernate.beans.Notice;
import com.struts.util.Pager;

public interface INoticeDAO {

	public Pager findPager(final int pageNo, final int pageSize);

	public Notice findById(String id);

	public void insert(Notice notice);

	public void update(Notice notice);

	public void delete(String id);
}
