/*
 * Created Thu Aug 23 15:30:25 CST 2007 by MyEclipse Hibernate Tool.
 */ 
package com.hibernate.beans;

import java.io.Serializable;

/**
 * A class that represents a row in the 'address' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Address
    extends AbstractAddress
    implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -884436909205017326L;

	/**
     * Simple constructor of Address instances.
     */
    public Address()
    {
    }

    /**
     * Constructor of Address instances given a simple primary key.
     * @param id
     */
    public Address(java.lang.Integer id)
    {
        super(id);
    }

    /* Add customized code below */

}
