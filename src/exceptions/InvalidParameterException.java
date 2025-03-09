package exceptions;

public class InvalidParameterException extends RuntimeException {
    private final String parameterName;
    public InvalidParameterException(String parameterName) {
        super("[Invalido]");
        this.parameterName = parameterName;
    }
    public String getParameterName() {
        return parameterName;
    }
}
