package com.hibernate.dao;

import com.hibernate.beans.Schedule;
import com.struts.util.Pager;

public interface IScheduleDAO {

	public Pager findPagerByUsername(final String username, final int pageNo,
			final int pageSize);

	public Schedule findById(String id);

	public void insert(Schedule schedule);

	public void update(Schedule schedule);

	public void delete(String id);
}
