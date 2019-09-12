package com.percylee.sample.beanvalidation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-29
 **/
@Slf4j
@Component
public class BeanValidProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class cls = bean.getClass();

        if (cls.getAnnotation(RestController.class) == null ||
                cls.getAnnotation(Controller.class) == null) {
            return bean;
        }


//        Field[] fields = bean.getClass().getFields();
//
//
//        for (Field field : fields) {
//            log.info(field.getName());
//            Annotation[] annotations = field.getAnnotations();
//            for (Annotation a : annotations) {
//
//            }
//        }

        return bean;
    }
}
