package com.ddlab.dozer.type5.srcpkg;

import java.util.Date;
import java.util.UUID;

/**
 * The Class SrcBean is used as source bean for SrcBean.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class SrcBean {

	/** The id key. */
	private UUID idKey;

	/** The util date. */
	private Date utilDate;

	/** The amount. */
	private double amount;

	/**
	 * Gets the amount.
	 * 
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 * 
	 * @param amount
	 *            the new amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the util date.
	 * 
	 * @return the util date
	 */
	public Date getUtilDate() {
		return utilDate;
	}

	/**
	 * Sets the util date.
	 * 
	 * @param utilDate
	 *            the new util date
	 */
	public void setUtilDate(Date utilDate) {
		this.utilDate = utilDate;
	}

	/**
	 * Gets the id key.
	 * 
	 * @return the id key
	 */
	public UUID getIdKey() {
		return idKey;
	}

	/**
	 * Sets the id key.
	 * 
	 * @param idKey
	 *            the new id key
	 */
	public void setIdKey(UUID idKey) {
		this.idKey = idKey;
	}

}
