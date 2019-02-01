package com.ddlab.dozer.type5.converters;

import org.dozer.CustomConverter;

/**
 * The Class Double2BigDecimalConverter is used as a custom Dozer converter for
 * double to BigDecimal.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class Double2BigDecimalConverter implements CustomConverter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dozer.CustomConverter#convert(java.lang.Object,
	 * java.lang.Object, java.lang.Class, java.lang.Class)
	 */
	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> arg2, Class<?> arg3) {
		System.out.println("Source Field Value :::" + sourceFieldValue);
		return null;
	}
}
