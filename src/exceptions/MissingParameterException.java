package exceptions;

import utils.Constants;

public class MissingParameterException extends RuntimeException {
    private final String parameterName;
    public MissingParameterException(String parameterName) {
        super(Constants.MISSING);
        this.parameterName = parameterName;
    }
    public String getParameterName() {
        return parameterName;
    }
}
