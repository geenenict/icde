package nl.han.icdeapp.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

//https://stackabuse.com/exception-handling-in-spring/

// reason i18n werkt nog niet, dit fixen!
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="#{evl_spec_na.text}")  // 404
public class EvlNotFoundException extends RuntimeException {

	// Waarom onderstaande? -> Uitzoeken en documenteren
	private static final long serialVersionUID = 1L;
}