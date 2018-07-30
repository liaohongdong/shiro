package cn.liaohongdong.common;


import javax.servlet.http.HttpServletRequest;

public class RequestHolder {
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
