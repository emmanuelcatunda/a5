package com.example.a5.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(Include.NON_NULL)
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = -318385235056441823L;
	@JsonProperty(value = "status")
	private int httpStatus = 200;

	@JsonProperty(value = "data")
	private Map<Object, Object> data;

	@JsonProperty(value = "message")
	private String message;

	@JsonProperty(value = "error")
	private Error error;

	public ApiResponse() {
		data = new HashMap<Object, Object>();
	}

	public static class ApiResponseBuilder {

		private ApiResponse apiResponse = new ApiResponse();

		public ApiResponseBuilder() {
		}

		public ApiResponseBuilder(ApiResponse apiResponse) {
			this.apiResponse = apiResponse;
		}

		public ApiResponseBuilder addEntry(Object key, Object value) {
			if (value != null)
				apiResponse.data.put(key, value);
			return this;
		}

		public ApiResponseBuilder withStatus(int httpStatus) {
			apiResponse.httpStatus = httpStatus;
			return this;
		}

		public ApiResponseBuilder withMessage(String message) {
			apiResponse.message = message;
			return this;
		}

		public ApiResponseBuilder withError(Error error) {
			apiResponse.error = error;
			return this;
		}

		public ApiResponse build() {
			return apiResponse;
		}

	}

	public static ApiResponseBuilder builder() {
		return new ApiResponseBuilder();
	}

	public static ApiResponseBuilder builder(ApiResponse apiResponse) {
		return new ApiResponseBuilder(apiResponse);
	}

	public boolean hasData() {
		return !this.data.isEmpty();
	}

	public boolean hasMessage() {
		Optional<String> optionalMessage = Optional.ofNullable(this.message);
		return optionalMessage.isPresent();
	}

	public boolean hasError() {
		Optional<Error> optionalError = Optional.ofNullable(this.error);
		return optionalError.isPresent();
	}

	public boolean hasStatus() {
		Optional<Error> optionalError = Optional.ofNullable(this.error);
		return optionalError.isPresent();
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public Map<Object, Object> getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public Error getError() {
		return error;
	}

}