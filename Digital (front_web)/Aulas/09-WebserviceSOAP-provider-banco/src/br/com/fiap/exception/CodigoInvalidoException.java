package br.com.fiap.exception;

@SuppressWarnings("serial")
public class CodigoInvalidoException extends Exception {

	public CodigoInvalidoException() {
		super();
		
	}

	public CodigoInvalidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public CodigoInvalidoException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CodigoInvalidoException(String message) {
		super(message);
		
	}

	public CodigoInvalidoException(Throwable cause) {
		super(cause);
		
	}

}
