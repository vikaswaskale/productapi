package com.error.controller.product;

public class ApplicationError extends RuntimeException {

	/**
	 * Handle Error if the product is not available for any reason
	 */
	private static final long serialVersionUID = 1L;
	private ErrorMessage errorMessage ;

	public ApplicationError(ErrorMessage errorMessage) {
 
		this.errorMessage = errorMessage;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
