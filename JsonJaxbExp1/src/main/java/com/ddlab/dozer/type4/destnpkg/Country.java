package com.ddlab.dozer.type4.destnpkg;

import java.math.BigDecimal;

/**
 * The Class Country is used is as a destination bean for Country which contains
 * an object of type BigDecimal.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class Country {

	/** The name. */
	private String name;

	/** The code. */
	private int code;

	/** The bd. */
	private BigDecimal bd;

	/**
	 * Gets the bd.
	 * 
	 * @return the bd
	 */
	public BigDecimal getBd() {
		return bd;
	}

	/**
	 * Sets the bd.
	 * 
	 * @param bd
	 *            the new bd
	 */
	public void setBd(BigDecimal bd) {
		this.bd = bd;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code
	 *            the new code
	 */
	public void setCode(int code) {
		this.code = code;
	}

}
