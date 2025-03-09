package exceptions;


public class MissingParameterException extends RuntimeException {
    private final String parameterName;

    public MissingParameterException(String parameterName) {
        super("[No presente]");
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return parameterName;
    }
}