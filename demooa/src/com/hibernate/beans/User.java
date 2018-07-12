/*
 * Created Tue Aug 14 18:57:22 CST 2007 by MyEclipse Hibernate Tool.
 */
package com.hibernate.beans;

import java.io.Serializable;

/**
 * A class that represents a row in the 'user' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class User extends AbstractUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3449507678643622401L;

	/**
	 * Simple constructor of User instances.
	 */
	public User() {
	}

	/**
	 * Constructor of User instances given a simple primary key.
	 * @param id
	 */
	public User(java.lang.Integer id) {
		super(id);
	}

	/* Add customized code below */

}
