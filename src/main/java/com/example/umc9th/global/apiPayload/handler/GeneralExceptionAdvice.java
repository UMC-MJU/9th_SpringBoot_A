package com.example.umc9th.global.apiPayload.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GeneralExceptionAdvice {

	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<ApiResponse<Void>> handleException(
		GeneralException ex
	) {
		return ResponseEntity.status(ex.getCode().getStatus())
			.body(ApiResponse.onFailure(
				ex.getCode(),
				null
			));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ApiResponse<Map<String, String>>> handleMethodArgumentNotValidException(
		MethodArgumentNotValidException ex
	) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->
			errors.put(error.getField(), error.getDefaultMessage())
		);

		GeneralErrorCode code = GeneralErrorCode.VALID_FAIL;
		ApiResponse<Map<String, String>> errorResponse = ApiResponse.onFailure(code, errors);

		return ResponseEntity.status(code.getStatus()).body(errorResponse);
	}

	@ExceptionHandler(HandlerMethodValidationException.class)
	protected ResponseEntity<ApiResponse<Map<String, String>>> handleConstraintViolationException(
		HandlerMethodValidationException ex
	) {
		Map<String, String> errors = new HashMap<>();

		ex.getParameterValidationResults().forEach(result -> {
			String paramName = result.getMethodParameter().getParameterName();

			result.getResolvableErrors().forEach(error -> {
				String message = error.getDefaultMessage();
				errors.put(paramName, message);
			});
		});

		GeneralErrorCode code = GeneralErrorCode.VALID_FAIL;
		ApiResponse<Map<String, String>> errorResponse = ApiResponse.onFailure(code, errors);

		return ResponseEntity.status(code.getStatus()).body(errorResponse);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<String>> handleException(
		Exception ex
	) {
		log.error(ex.toString());
		BaseErrorCode code = GeneralErrorCode.INTERNAL_SERVER_ERROR;
		return ResponseEntity.status(code.getStatus())
			.body(ApiResponse.onFailure(
				code,
				ex.getMessage()
			));
	}
}
