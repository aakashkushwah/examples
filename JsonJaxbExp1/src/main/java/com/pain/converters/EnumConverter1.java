package com.pain.converters;

import org.dozer.CustomConverter;

import com.sample.pain.PaymentMethod3CodeWire;

public class EnumConverter1 implements CustomConverter{

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, @SuppressWarnings("rawtypes") Class destinationClass,
			@SuppressWarnings("rawtypes") Class sourceClass) {
		if (sourceFieldValue == null) {
			return null;
		}

		return PaymentMethod3CodeWire.fromValue(sourceFieldValue.toString());
	}
	
}
