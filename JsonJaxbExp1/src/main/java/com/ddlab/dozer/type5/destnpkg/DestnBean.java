package com.ddlab.dozer.type5.destnpkg;

import java.math.BigDecimal;
import java.util.UUID;

import org.joda.time.LocalDate;

/**
 * The Class DestnBean is used as bean for destination copy.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class DestnBean {

	/** The uid. */
	private UUID uid;

	/** The joda date. */
	private LocalDate jodaDate;

	/** The big decimal. */
	private BigDecimal bigDecimal;

	/**
	 * Gets the joda date.
	 * 
	 * @return the joda date
	 */
	public LocalDate getJodaDate() {
		return jodaDate;
	}

	/**
	 * Sets the joda date.
	 * 
	 * @param jodaDate
	 *            the new joda date
	 */
	public void setJodaDate(LocalDate jodaDate) {
		this.jodaDate = jodaDate;
	}

	/**
	 * Gets the big decimal.
	 * 
	 * @return the big decimal
	 */
	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	/**
	 * Sets the big decimal.
	 * 
	 * @param bigDecimal
	 *            the new big decimal
	 */
	public void setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
	}

	/**
	 * Gets the uid.
	 * 
	 * @return the uid
	 */
	public UUID getUid() {
		return uid;
	}

	/**
	 * Sets the uid.
	 * 
	 * @param uid
	 *            the new uid
	 */
	public void setUid(UUID uid) {
		this.uid = uid;
	}

}
