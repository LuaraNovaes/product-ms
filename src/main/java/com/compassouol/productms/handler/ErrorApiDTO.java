package com.compassouol.productms.handler;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ErrorApiDTO {
	@JsonProperty("status_code")
	private Integer statusCode;
	private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ValidationDTO> validationsError;
}
