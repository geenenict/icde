package nl.han.icdeapp.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

//https://stackabuse.com/exception-handling-in-spring/

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="{evl_spec_na.text}")  // 404
public class EvlNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
}