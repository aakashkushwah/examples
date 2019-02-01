package com.ddlab.dozer.type5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ddlab.dozer.type5.destnpkg.DestnBean;
import com.ddlab.dozer.type5.srcpkg.SrcBean;

/**
 * The Class TestCustomConverters is used as a test class for custom conversion
 * using Dozer.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class TestCustomConverters {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("dozercustomconvertermapping.xml");
		Mapper mapper = new DozerBeanMapper(list);

		SrcBean sadtb = new SrcBean();
		sadtb.setIdKey(UUID.fromString("0ad2c124-fa67-4f76-bc7d-1097fc04417d"));
		sadtb.setAmount(1234.567);
		sadtb.setUtilDate(new Date());

		DestnBean datb = new DestnBean();

		mapper.map(sadtb, datb, "k");
		System.out.println(datb.getUid());
		System.out.println(datb.getJodaDate());
		System.out.println(datb.getBigDecimal());
	}
}
