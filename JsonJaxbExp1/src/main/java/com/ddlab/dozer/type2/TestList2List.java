package com.ddlab.dozer.type2;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ddlab.dozer.type2.destnpkg.AddressBean;
import com.ddlab.dozer.type2.destnpkg.AddressBeanList;
import com.ddlab.dozer.type2.srcpkg.Address;
import com.ddlab.dozer.type2.srcpkg.AddressList;

/**
 * The Class TestList2List is used as a test class to perform list to list copy.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class TestList2List {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("list2ListMapping.xml");
		Mapper mapper = new DozerBeanMapper(list);

		// End of Mapping

		Address adrs = new Address();
		adrs.setId(11);
		adrs.setName("name1");

		Address adrs1 = new Address();
		adrs1.setId(22);
		adrs1.setName("name22");

		AddressList adrsList = new AddressList();

		List<Address> adList = new ArrayList<Address>();
		adList.add(adrs);
		adList.add(adrs1);

		adrsList.setAdrsList(adList);

		AddressBeanList destnAdrsBeanList = mapper.map(adrsList,
				AddressBeanList.class, "q1");
		List<AddressBean> adrsBeanList11 = destnAdrsBeanList.getAdrsList();

		for (AddressBean adBean : adrsBeanList11) {
			System.out.println("Id of AdressBean :: " + adBean.getId());
			System.out.println("Name of AdressBean :: " + adBean.getName());
		}

	}

}
