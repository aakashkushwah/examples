package com.ddlab.dozer.type4.srcpkg;

import java.util.List;

/**
 * The Class AddressList is used as a source List object which contains objects
 * of type Address
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class AddressList {

	/** The adrs list. */
	private List<Address> adrsList;

	/**
	 * Gets the adrs list.
	 * 
	 * @return the adrs list
	 */
	public List<Address> getAdrsList() {
		return adrsList;
	}

	/**
	 * Sets the adrs list.
	 * 
	 * @param adrsList
	 *            the new adrs list
	 */
	public void setAdrsList(List<Address> adrsList) {
		this.adrsList = adrsList;
	}

}
