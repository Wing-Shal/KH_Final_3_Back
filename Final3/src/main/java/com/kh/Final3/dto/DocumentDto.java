package com.kh.Final3.dto;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class DocumentDto {
	private int documentNo; //문서 번호
	private int projectNo; //프로젝트 번호
	private String documentTitle; //문서 제목
	private String documentContent; //문서 내용
	private String documentStatus; //문서 상태
	private Date documentWriteTime; //문서 작성일
	private Date documentLimitTime; //문서결재 마감일
	private String documentWriter; //문서 작성자 
	private String documentApprover; //문서 결재자
	private String projectName; //프로젝트이름
	private int empNo; //사원번호

}