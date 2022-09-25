package com.simple.mybatis.reflection.invoker;


/**
 * The interface Invoker.
 *
 * @author SinceNovember
 * @date 2022 -09-24 23:08:01
 */
public interface Invoker {


    /**
     * Invoke object.
     *
     * @param target the target
     * @param args   the args
     * @return the object
     * @throws Exception the exception
     */
    Object invoke(Object target, Object[] args) throws Exception;


    /**
     * Gets type.
     *
     * @return the type
     */
    Class<?> getType();
}
