package exceptions;

import utils.Constants;

public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String parameterName) {
        super(Constants.INVALID);
    }
}