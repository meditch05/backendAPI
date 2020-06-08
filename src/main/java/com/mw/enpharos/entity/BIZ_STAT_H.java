package com.mw.enpharos.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
	CREATE TABLE `BOARDS` (
		`ID` 			int(11) NOT NULL AUTO_INCREMENT,
		`USER_ID` 		int(10) unsigned NOT NULL,
		`TITLE` 		varchar(45) NOT NULL,
		`CONTENT` 		varchar(255) NOT NULL,
		`CREATE_TIME`	datetime DEFAULT NULL,
		PRIMARY KEY (`ID`)
	);
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "biz_stat_h")
public class BIZ_STAT_H {
	
	// @Id
	// 에러방지를 위한 어노테이션 2개 ( Invocation of init method failed; nested exception is org.hibernate.AnnotationException: No identifier specified for entity: com.example.sbt_sample.domain.User )
	// Entity 선언시 식별자를 선언해주지 않아서 발생하는 에러임, PK 속성의 컬럼명에 지정함
	
	// Primary Key 가 없는 Oracle Table의 경우 ROWID를 Primary key 로 사용할 수 있다.
	@Id			
	@Column(name="ROWID", nullable = false)
    private String rowid; 
	
	@Column(name="TIMESLICE", nullable = false)
    private Timestamp timeslice;

	@Column(name="TX_CODE", nullable = false)
    private String txcode;
	
	@Column(name="COUNT")
    private double count;
	
	@Column(name="DURATION")
    private double duration;	

    @Override
    public String toString() {
        return "BoardInfo{"        		
                + timeslice.toString()
                + ", =" + txcode
                + ", =" + count 
                + ", =" + duration
                + ", =" + rowid
                + "}";
    }
}