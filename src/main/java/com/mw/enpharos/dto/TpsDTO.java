package com.mw.enpharos.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class TpsDTO {
	private String time;
	private float tps;

	// SQL 수행결과를 가져다가 DTO로 맵핑시켜주므로,
	// Resultset의 각 필드와 맵핑되는 값들로 생성자를 만들어 줘야함
	public TpsDTO(String  time, BigDecimal tps) {
    	this.time = time;
    	this.tps = tps == null ? null : tps.floatValue();
    }

	@Override
	public String toString() {
		return "TpsResDTO{" + "time = " + time + ", tps=" + tps + "}";
	}
}