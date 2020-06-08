package com.mw.enpharos.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.mw.enpharos.dto.TpsDTO;
import com.mw.enpharos.dto.TpsResDTO;
import com.mw.enpharos.entity.BIZ_STAT_H;
import com.mw.enpharos.repository.BIZ_STAT_H_Mapper;
import com.mw.enpharos.service.TpsResDTOService;

import oracle.sql.TIMESTAMP;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

@RestController
@RequestMapping("/api")
public class WarroomAPIController {
	
    // @Autowired
    // private BIZ_STAT_H_Mapper h_Mapper;
    
    @Autowired
    private TpsResDTOService tpsresdtoservice;
    
    // /get/swing/hour/tps_res/{yyyymmddhh}
    // /get/swing/hour/tps_res/period
    // /get/swing/hour/tps_res/period/avg
    
    // /get/swing/min/tps_res/{yyyymmddhhmm}
    // /get/swing/min/tps_res/period
    // /get/swing/min/tps_res/period/avg
 	
 	// TEMP_PEAK_TPS_D 테이블 ( 7일전 Peak TPS )
 	@RequestMapping(value="/get/swing/day/tps/peak/7days_before", method= RequestMethod.GET, produces = "application/json;application/text;charset=utf-8")
 	public List<TpsDTO> get_day_peak_tps_7days_before() {
 		
 		List<TpsDTO> list = null;
 	
 		try { 	        
 			list = tpsresdtoservice.get_peak_tps_of_7days_before();
 			for (TpsDTO dto : list ) {
 				dto.toString();
 			}
 			return list;
 		} catch(Exception io) {
 			System.out.println(io.toString());			
 			return list;
 		}
 		
 	}
}
