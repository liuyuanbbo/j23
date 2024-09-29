package io.zjc.app.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class DataSourceMethodInterceptor implements Ordered {

    @After("execution(* io.zjc.app.service..*Service.*(..))")
    public void clearDataSource() {
        DataSourceContextHolder.clearDataSourceType();
    }

    @Before("execution(* io.zjc.app.mapper..*Mapper.*(..))")
    public void dynamicSetDataSoruce(JoinPoint joinPoint) {

        Class<?> clazz = joinPoint.getTarget().getClass();
        String className = clazz.getName();
        if (ClassUtils.isAssignable(clazz, Proxy.class)) {
            className = joinPoint.getSignature().getDeclaringTypeName();
        }
        String methodName = joinPoint.getSignature().getName();

        Object[] arguments = joinPoint.getArgs();
        String msg = "execute {" + className + "}.{" + methodName + "}({" + Arrays.toString(arguments) + "})";
        log.info(msg);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
