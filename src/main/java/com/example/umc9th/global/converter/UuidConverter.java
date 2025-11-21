package com.example.umc9th.global.converter;

import com.example.umc9th.global.entity.Uuid;

public class UuidConverter {

	public static Uuid toUuid(String uuid) {
		return Uuid.builder()
			.uuid(uuid)
			.build();
	}
}
