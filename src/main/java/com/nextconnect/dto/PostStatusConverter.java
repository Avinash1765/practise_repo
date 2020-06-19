package com.nextconnect.dto;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.nextconnect.constants.StatusEnum;

@Converter(autoApply = true)
public class PostStatusConverter implements AttributeConverter<StatusEnum, String> {

	@Override
	public String convertToDatabaseColumn(StatusEnum attribute) {

		if (attribute != null) {

			return attribute.getDBStatus();
		}
		return null;
	}

	@Override
	public StatusEnum convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			for(StatusEnum obj: StatusEnum.values()) {
				if(obj.getDBStatus().equals(dbData))
					return obj;
			}
		}
		return null;
	}

}
