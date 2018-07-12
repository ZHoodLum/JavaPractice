/*
 * Created Tue Aug 28 18:29:28 CST 2007 by MyEclipse Hibernate Tool.
 */ 
package com.hibernate.beans;

import java.io.Serializable;

/**
 * A class that represents a row in the 'notice' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Notice
    extends AbstractNotice
    implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8084533983785011912L;

	/**
     * Simple constructor of Notice instances.
     */
    public Notice()
    {
    }

    /**
     * Constructor of Notice instances given a simple primary key.
     * @param id
     */
    public Notice(java.lang.Integer id)
    {
        super(id);
    }

    /* Add customized code below */

}
