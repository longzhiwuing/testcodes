package com.lzwing.testcode.utils.paramcheck;


import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
 
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;
 
public class BeanValidator {
    // Validator工厂
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
 
    // Map<String,String> 中 key表示错误的字段，value表示错误信息
 
    /**
     * 校验单个对象
     *
     * @param t
     * @param groups
     * @param <T>
     * @return
     */
    public static <T> Map<String, String> validate(T t, Class... groups) {
        Validator validator = validatorFactory.getValidator();
        // 传入参数，并获取校验结果
        Set validatorErrors = validator.validate(t, groups);
        // 若校验为空，说明校验通过,返回空集合
        if (validatorErrors.isEmpty()) {
            return Collections.emptyMap();
        } else {
            LinkedHashMap<String, String> errors = Maps.newLinkedHashMap();
            // 对校验错误信息进行遍历
            Iterator iterator = validatorErrors.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation violation = (ConstraintViolation) iterator.next();
                // 放入key,value
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            return errors;
        }
    }
 
    /**
     * 校验多个对象
     *
     * @param collection
     * @return
     */
    public static Map<String, String> validateList(Collection<?> collection) {
        // 判断是否为空，为空时抛出异常
        Preconditions.checkNotNull(collection);
        Iterator iterator = collection.iterator();
        Map errors;
        do {
            if (!iterator.hasNext()) {
                return Collections.emptyMap();
            }
            // 取到当前值
            Object object = iterator.next();
            errors = validate(object, new Class[0]);
        } while (errors.isEmpty());
        return errors;
    }
    public static Map<String, String> validateObject(Object first, Object... objects) {
 
        if (objects != null && objects.length > 0) {
            return validateList(Lists.asList(first, objects));
        } else {
            return validate(first, new Class[0]);
        }
    }
    public static void check(Object param) throws RuntimeException {
        Map<String, String> errors = validateObject(param);
        if (MapUtils.isNotEmpty(errors)) {
            throw new RuntimeException(errors.toString());
        }
 
    }
}