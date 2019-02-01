package com.ddlab.dozer.type4.destnpkg;

import java.util.List;

/**
 * The Class AddressBeanList is used is a destination List object which contains
 * object of type AddressBean.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class AddressBeanList {

	/** The adrs list. */
	private List<AddressBean> adrsList;

	/**
	 * Gets the adrs list.
	 * 
	 * @return the adrs list
	 */
	public List<AddressBean> getAdrsList() {
		return adrsList;
	}

	/**
	 * Sets the adrs list.
	 * 
	 * @param adrsList
	 *            the new adrs list
	 */
	public void setAdrsList(List<AddressBean> adrsList) {
		this.adrsList = adrsList;
	}

}
