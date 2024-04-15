package com.rodriguez.servicios.VerboHttp.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {
	private String error;
}
