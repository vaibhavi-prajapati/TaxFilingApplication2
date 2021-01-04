package com.taxfiling.exception;

public class DuplicateEntryFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;
	private final String details;
	private final String hint;
	private final String nextActions;
	private final String support;

	public DuplicateEntryFoundException(String message, String details, String hint, String nextActions,
			String support) {
		this.message = message;
		this.details = details;
		this.hint = hint;
		this.nextActions = nextActions;
		this.support = support;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public String getHint() {
		return hint;
	}

	public String getNextActions() {
		return nextActions;
	}

	public String getSupport() {
		return support;
	}
}
