package exceptions;

import utils.Constants;

public class MissingParameterException extends RuntimeException {
    public MissingParameterException(String parameterName) {
        super(Constants.MISSING);
    }
}