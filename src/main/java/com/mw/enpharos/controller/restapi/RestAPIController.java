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
public class RestAPIController {
	
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
    
    // BIZ_STAT_H 테이블 ( 1시간 )
 	@RequestMapping(value="/get/swing/hour/tps_res/{yyyymmddhh}",  method= RequestMethod.GET, produces = "application/json;application/text;charset=utf-8")
 	public List<TpsResDTO> get_1hour_tpsres(@PathVariable("yyyymmddhh") String yyyymmddhh ) {
 		
 		List<TpsResDTO> list = null;
 	
 		System.out.println("/get/swing/hour/tps_res/{yyyymmddhh} = " + yyyymmddhh );
 	
 		try {
 			/*
 			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
 			Date date = sdf.parse(yyyymmddhh);	
 			Timestamp timestamp = new Timestamp(date.getTime());
 			
 			System.out.println("date.toString() = " + date.toString());	
 			System.out.println("timestamp.toString() = " + timestamp.toString());
 			 */
 	        
 			list = tpsresdtoservice.get_1hour_tpsres(yyyymmddhh);
 			for (TpsResDTO dto : list ) {
 				dto.toString();
 			}
 			return list;
 		} catch(Exception io) {
 			System.out.println(io.toString());			
 			return list;
 		}
 	}
 	
 	// BIZ_STAT_H 테이블 ( FROM ~ TO )
 	@RequestMapping(value="/get/swing/hour/tps_res/period", method= RequestMethod.POST, produces = "application/json;application/text;charset=utf-8")
 	public List<TpsResDTO> get_1hour_tpsres_period(
 			@RequestParam(value="from") String from,
 			@RequestParam(value="to")   String to) {
 		
 		List<TpsResDTO> list = null;
 	
 		System.out.println("/get/swing/hour/tps_res/period = from = " + from );
 		System.out.println("/get/swing/hour/tps_res/period = to   = " + to );
 	
 		try { 	        
 			list = tpsresdtoservice.get_1hour_tpsres_period(from, to);
 			for (TpsResDTO dto : list ) {
 				dto.toString();
 			}
 			return list;
 		} catch(Exception io) {
 			System.out.println(io.toString());			
 			return list;
 		}
 	}
 	
 	// BIZ_STAT_H 테이블 ( FROM ~ TO )
 	@RequestMapping(value="/get/swing/hour/tps_res/period/avg", method= RequestMethod.POST, produces = "application/json;application/text;charset=utf-8")
 	public List<TpsResDTO> get_1hour_tpsres_period_avg(
 			@RequestParam(value="from") String from,
 			@RequestParam(value="to")   String to) {
 		
 		List<TpsResDTO> list = null;
 	
 		System.out.println("/get/swing/hour/tps_res/period = from = " + from );
 		System.out.println("/get/swing/hour/tps_res/period = to   = " + to );
 	
 		try { 	        
 			list = tpsresdtoservice.get_1hour_tpsres_period_avg(from, to);
 			for (TpsResDTO dto : list ) {
 				dto.toString();
 			}
 			return list;
 		} catch(Exception io) {
 			System.out.println(io.toString());			
 			return list;
 		}
 	}
 	
    // BIZ_STAT_1MIN 테이블 ( 1분 )
 	@RequestMapping(value="/get/swing/min/tps_res/{yyyymmddhhmm}", method= RequestMethod.GET, produces = "application/json;application/text;charset=utf-8")
 	public List<TpsResDTO> get_1min_tpsres(@PathVariable("yyyymmddhhmm") String yyyymmddhhmm ) {
 		
 		List<TpsResDTO> list = null;
 	
 		System.out.println("/get/swing/min/tps_res/{yyyymmddhhmm} = " + yyyymmddhhmm );
 	
 		try {
 			/*
 			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
 			Date date = sdf.parse(yyyymmddhh);	
 			Timestamp timestamp = new Timestamp(date.getTime());
 			
 			System.out.println("date.toString() = " + date.toString());	
 			System.out.println("timestamp.toString() = " + timestamp.toString());
 			 */
 	        
 			list = tpsresdtoservice.get_1min_tpsres(yyyymmddhhmm);
 			for (TpsResDTO dto : list ) {
 				dto.toString();
 			}
 			return list;
 		} catch(Exception io) {
 			System.out.println(io.toString());			
 			return list;
 		}
 	}
 	
 	// BIZ_STAT_1MIN 테이블 ( FROM ~ TO )
 	@RequestMapping(value="/get/swing/min/tps_res/period", method= RequestMethod.POST, produces = "application/json;application/text;charset=utf-8")
 	public List<TpsResDTO> get_1min_tpsres_period(
 			@RequestParam(value="from") String from,
 			@RequestParam(value="to")   String to) {
 		
 		List<TpsResDTO> list = null;
 	
 		System.out.println("/get/swing/min/tps_res/period = from = " + from );
 		System.out.println("/get/swing/min/tps_res/period = to   = " + to );
 	
 		try { 	        
 			list = tpsresdtoservice.get_1min_tpsres_period(from, to);
 			for (TpsResDTO dto : list ) {
 				dto.toString();
 			}
 			return list;
 		} catch(Exception io) {
 			System.out.println(io.toString());			
 			return list;
 		}
 	}
 	
 	// BIZ_STAT_1MIN 테이블 ( FROM ~ TO )
 	@RequestMapping(value="/get/swing/min/tps_res/period/avg", method= RequestMethod.POST, produces = "application/json;application/text;charset=utf-8")
 	public List<TpsResDTO> get_1min_tpsres_period_avg(
 			@RequestParam(value="from") String from,
 			@RequestParam(value="to")   String to) {
 		
 		List<TpsResDTO> list = null;
 	
 		System.out.println("/get/swing/min/tps_res/period = from = " + from );
 		System.out.println("/get/swing/min/tps_res/period = to   = " + to );
 	
 		try { 	        
 			list = tpsresdtoservice.get_1min_tpsres_period_avg(from, to);
 			for (TpsResDTO dto : list ) {
 				dto.toString();
 			}
 			return list;
 		} catch(Exception io) {
 			System.out.println(io.toString());			
 			return list;
 		}
 	}
 	
 	// TEMP_PEAK_TPS_D 테이블 ( 7일전 일일 Peak TPS )
 	@RequestMapping(value="/get/swing/day/tps/peak/{yyyymmdd}", method= RequestMethod.GET, produces = "application/json;application/text;charset=utf-8")
 	public List<TpsDTO> get_day_peak_tps_7days_before(@PathVariable("yyyymmdd") String yyyymmdd ) {
 		
 		List<TpsDTO> list = null;
 	
 		try { 	        
 			list = tpsresdtoservice.get_peak_tps_of_day(yyyymmdd);
 			for (TpsDTO dto : list ) {
 				dto.toString();
 			}
 			return list;
 		} catch(Exception io) {
 			System.out.println(io.toString());			
 			return list;
 		}
 	}
    
/*
    // Read
    // 작성한 글의 id로 정보를 받음
    // @Transactional
    @RequestMapping(value="/get/swing/hour/tps_res/{yyyymmddhh}",
    				method= RequestMethod.GET,
    				produces = "application/json;application/text;charset=utf-8")
    public ResponseEntity<BIZ_STAT_H> hour_tps_res( @PathVariable("yyyymmddhh") String yyyymmddhh ) {
    	
    	System.out.println("/get/swing/hour/tps_res/{yyyymmddhh} = " + yyyymmddhh );
    	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
			Date date = sdf.parse(yyyymmddhh);

			System.out.println("date.toString() = " + date.toString());

			Timestamp timestamp = new Timestamp(date.getTime());

			System.out.println("timestamp.toString() = " + timestamp.toString());
            
            BIZ_STAT_H column = h_Mapper.findByTimeslice(timestamp);       

            return new ResponseEntity<BIZ_STAT_H>(column, HttpStatus.OK);
    	} catch(Exception io) {
    		System.out.println(io.toString());
    		
            //if (column == null) {
            //	System.out.println("데이터가 존재하지 않습니다.");
            	return new ResponseEntity<BIZ_STAT_H>(HttpStatus.NOT_FOUND);
            //}
    	}
    }
*/
    /*
    // Read
    // 작성한 글의 id로 정보를 받음
    // @Transactional
    @RequestMapping(value="/get/swing/hour/tx_code/{tx_code}",
    				method= RequestMethod.GET,
    				produces = "application/json;application/text;charset=utf-8")
    public ResponseEntity<BIZ_STAT_H> hour_tx_code( @PathVariable("tx_code") String tx_code ) {
    	
    	System.out.println("/get/swing/hour/tx_code/{tx_code} = " + tx_code );
    	
		try {
            BIZ_STAT_H column = h_Mapper.findByTxcode(tx_code);

            return new ResponseEntity<BIZ_STAT_H>(column, HttpStatus.OK);
    	} catch(Exception io) {
    		System.out.println(io.toString());
    		
            //if (column == null) {
            //	System.out.println("데이터가 존재하지 않습니다.");
            	return new ResponseEntity<BIZ_STAT_H>(HttpStatus.NOT_FOUND);
            //}
    	}
    }
    */
    

    
    /*
    @RequestMapping(value="/get/swing/hour/tps_res",
    				method= RequestMethod.GET,
    				produces = "application/json;application/text;charset=utf-8")
    public ResponseEntity<BIZ_STAT_H> hour_tps_res( @RequestParam("from") int from, @RequestParam("to") int to) {
    }
     */

    /*
    // Read
    // 작성한 글의 id로 정보를 받음
    @Transactional
    @RequestMapping(value="/board/{id}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<BIZ_STAT_H> board(@PathVariable("id") int id) {
        BIZ_STAT_H board = boardMapper.findById(id);
        if (board == null) {
            System.out.println("데이터가 존재하지 않습니다.");
            return new ResponseEntity<BIZ_STAT_H>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BIZ_STAT_H>(board, HttpStatus.OK);
    }


    // Create
    // 클라이언트에서 작성한 정보를 서버로
    @Transactional
    @RequestMapping(value = "/board/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBoard(@RequestBody BIZ_STAT_H board, UriComponentsBuilder ucBuilder) {
        if (boardMapper.findByUserId(board.getUserId()) != null) {
            System.out.println("이미 이 유저는 글을 작성했습니다.");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);  // 409
        }

        boardMapper.save(board);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
                ucBuilder.path("/board/{id}").buildAndExpand(board.getId()).toUri()
                );
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);  // 201
    }


    // Update
    // 수정 정보를 처리
    @Transactional
    @RequestMapping(value = "/board/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateBoard(@PathVariable("id") int id, @RequestBody BIZ_STAT_H board) {
    	BIZ_STAT_H storedBoard = boardMapper.findById(id);

        if (storedBoard == null) {
            System.out.println("해당 글이 존재하지 않습니다.");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        storedBoard.setTitle(board.getTitle());
        storedBoard.setContent(board.getContent());

        boardMapper.save(storedBoard);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    // DELETE
    // 정보 삭제하기
    @Transactional
    @RequestMapping(value = "/board/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<BIZ_STAT_H> deleteBoard(@PathVariable("id") int id) {
        BIZ_STAT_H storedBoard = boardMapper.findById(id);

        if (storedBoard == null) {
            System.out.println("삭제하려는 대상을 찾을 수 없습니다.");
            return new ResponseEntity<BIZ_STAT_H>(HttpStatus.NOT_FOUND);
        }

        boardMapper.deleteById(storedBoard.getId());

        return new ResponseEntity<BIZ_STAT_H>(HttpStatus.NO_CONTENT);
    }
    */
}
