package com.taxfiling.exception;

public class DuplicateEntryFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	private String details;
	private String hint;
	private String nextActions;
	private String support;

	protected DuplicateEntryFoundException() {
	}

	public DuplicateEntryFoundException(String message, String details, String hint, String nextActions,
			String support) {
		this.message = message;
		this.details = details;
		this.hint = hint;
		this.nextActions = nextActions;
		this.support = support;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getNextActions() {
		return nextActions;
	}

	public void setNextActions(String nextActions) {
		this.nextActions = nextActions;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	/*
	 * public EntityNotFoundException(String message) { super(message);
	 * System.out.println("not found"); }
	 */

}
