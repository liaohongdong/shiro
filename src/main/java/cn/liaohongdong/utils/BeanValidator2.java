package cn.liaohongdong.utils;

import cn.liaohongdong.exception.ParamException;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

public class BeanValidator2 {
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static Map<String, String> check(Object t) {
        Validator validator = factory.getValidator();
        Set set = validator.validate(t, new Class[0]);
        if (set.isEmpty()) {
            return Collections.emptyMap();
        } else {
            LinkedHashMap map = Maps.newLinkedHashMap();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation v = (ConstraintViolation) iterator.next();
                map.put(v.getPropertyPath(), v.getMessage());
            }
            if(MapUtils.isNotEmpty(map)){
                throw new ParamException(map.toString());
            }
            return map;
        }
    }

}
