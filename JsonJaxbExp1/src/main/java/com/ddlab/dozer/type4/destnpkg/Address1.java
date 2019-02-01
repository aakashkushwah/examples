package com.ddlab.dozer.type4.destnpkg;

/**
 * The Class Address1 is used as a destination bean for Address1 which contains
 * Country object
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class Address1 {

	/** The door no1. */
	private int doorNo1;

	/** The st name1. */
	private String stName1;

	/** The country. */
	private Country country;

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country
	 *            the new country
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Gets the door no1.
	 * 
	 * @return the door no1
	 */
	public int getDoorNo1() {
		return doorNo1;
	}

	/**
	 * Sets the door no1.
	 * 
	 * @param doorNo1
	 *            the new door no1
	 */
	public void setDoorNo1(int doorNo1) {
		this.doorNo1 = doorNo1;
	}

	/**
	 * Gets the st name1.
	 * 
	 * @return the st name1
	 */
	public String getStName1() {
		return stName1;
	}

	/**
	 * Sets the st name1.
	 * 
	 * @param stName1
	 *            the new st name1
	 */
	public void setStName1(String stName1) {
		this.stName1 = stName1;
	}

}
