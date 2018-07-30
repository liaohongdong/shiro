package cn.liaohongdong.utils;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonMapper {
    static Logger logger = LoggerFactory.getLogger(JsonMapper.class);
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    }

    public static <T> String obj2String(T src) {
        if (src == null) {
            return null;
        }
        try {
            return src instanceof String ? (String) src : mapper.writeValueAsString(src);
        } catch (Exception e) {
            logger.warn("parse object to string exception, error:{}", e);
            return null;
        }
    }

    public static <T> T string2Obj(String src, TypeReference<?> type) {
        if (src == null || type == null) {
            return null;
        }
        try {
            return (T) (type.getType().equals(String.class) ? src : mapper.readValue(src, type));
        } catch (Exception e) {
            logger.warn("parse string to object exception, string:{}, TypeReference<T>:{}, error:{}", src, type, e);
            return null;
        }
    }
}
