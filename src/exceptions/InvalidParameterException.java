package exceptions;

import utils.Constants;

public class InvalidParameterException extends RuntimeException {
    private final String parameterName;
    public InvalidParameterException(String parameterName) {
        super(Constants.INVALID);
        this.parameterName = parameterName;
    }
    public String getParameterName() {
        return parameterName;
    }
}
