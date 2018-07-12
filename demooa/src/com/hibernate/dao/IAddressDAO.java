package com.hibernate.dao;

import java.util.List;

import com.hibernate.beans.Address;
import com.struts.util.Pager;

public interface IAddressDAO {

	public List findAllByUsername(final String username);

	public Pager findPagerByUsername(final String username);

	public Pager findPagerByUsername(final String username, final int pageNo,
			final int pageSize);

	public Address findById(String id);

	public boolean isExist(final String username, final String name);

	public void insert(Address address);

	public void update(Address address);

	public void delete(String id);
}
