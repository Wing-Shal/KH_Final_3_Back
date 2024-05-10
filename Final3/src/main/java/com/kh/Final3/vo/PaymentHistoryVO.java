package com.kh.Final3.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PaymentHistoryVO {
	private String paymentTime;
	private String paymentName;
	private String paymentTotal;
	private String paymentStatus;
}