package br.com.fiap.exception;

@SuppressWarnings("serial")
public class CommitErrorException extends Exception {

	public CommitErrorException() {
		super();
		
	}

	public CommitErrorException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public CommitErrorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public CommitErrorException(String arg0) {
		super(arg0);
		
	}

	public CommitErrorException(Throwable arg0) {
		super(arg0);
		
	}

	
}
