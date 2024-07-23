package ru.grebennik.shares_analytics.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Логируем события до выполнения любого метода
    @Before("ru.grebennik.shares_analytics.aspect.PointcutKeeper.allControllerMethods()")
    public void beforeAllMethodsAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // Получаем имя вызываемого метода
        String methodName = methodSignature.getName();

        // Записываем информацию в лог-файл
        logger.info("Start executing: {}", methodName);
    }
}
