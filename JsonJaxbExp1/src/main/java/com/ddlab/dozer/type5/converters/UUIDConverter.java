package com.ddlab.dozer.type5.converters;

import java.util.UUID;

import org.dozer.CustomConverter;

// TODO: Auto-generated Javadoc
/**
 * The Class UUIDConverter is used.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class UUIDConverter implements CustomConverter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dozer.CustomConverter#convert(java.lang.Object,
	 * java.lang.Object, java.lang.Class, java.lang.Class)
	 */
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> arg2, Class<?> arg3) {

		UUID source = (UUID) sourceFieldValue;
		UUID target = new UUID(source.getMostSignificantBits(),
				source.getLeastSignificantBits());
		return target;
	}
}
