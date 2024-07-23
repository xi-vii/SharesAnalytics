package ru.grebennik.shares_analytics.aspect;

import org.aspectj.lang.annotation.Pointcut;


//Отдельный класс для объявления всех Pointcut`ов - для удобства.
public class PointcutKeeper {

    @Pointcut("execution(* ru.grebennik.shares_analytics.controller.*.*(..))")
    public void allControllerMethods() {}
}
