package cn.liaohongdong.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
    public static void logger(Class<?> clazz, String msg, Object... obj) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.warn(msg, obj);
    }
}
