package cn.liaohongdong.exception;

public class ShrioException extends RuntimeException {
    public ShrioException() {
        super();
    }

    public ShrioException(String message) {
        super(message);
    }

    public ShrioException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShrioException(Throwable cause) {
        super(cause);
    }

    protected ShrioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
