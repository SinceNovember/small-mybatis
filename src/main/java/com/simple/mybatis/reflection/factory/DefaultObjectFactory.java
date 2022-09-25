package com.simple.mybatis.reflection.factory;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.*;

/**
 * 默认对象工厂，所有的对象都有工厂来生成
 *
 * @author SinceNovember
 * @date 2022/9/25
 */
public class DefaultObjectFactory implements ObjectFactory, Serializable {

    private static final long serialVersionUID = -8855120656740914948L;

    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public <T> T create(Class<T> type) {
        return create(type, null, null);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        // 1.解析接口
        Class<?> classToCreate = resolveInterface(type);
        return (T) instantiateClass(classToCreate, constructorArgTypes, constructorArgs);
    }

    private <T> T instantiateClass(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        try {
            Constructor<T> constructor;
            //如果没有传入constructor，调用空构造函数，核心是调用Constructor.newInstance
            if (constructorArgTypes == null || constructorArgs == null) {
                constructor = type.getDeclaredConstructor();
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
                return constructor.newInstance();
            }
            constructor = type.getDeclaredConstructor(constructorArgTypes.toArray(new Class[constructorArgTypes.size()]));
            return constructor.newInstance(constructorArgs.toArray(new Object[constructorArgs.size()]));
        } catch (Exception e) {
            // 如果出错，包装一下，重新抛出自己的异常
            StringBuilder argTypes = new StringBuilder();
            if (constructorArgTypes != null) {
                for (Class<?> argType : constructorArgTypes) {
                    argTypes.append(argType.getSimpleName());
                    argTypes.append(",");
                }
            }
            StringBuilder argValues = new StringBuilder();
            if (constructorArgs != null) {
                for (Object argValue : constructorArgs) {
                    argValues.append(argValue);
                    argValues.append(",");
                }
            }
            throw new RuntimeException("Error instantiating " + type + " with invalid types (" + argTypes + ") or values (" + argValues + "). Cause: " + e, e);
        }
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }

    /**
     * 解析接口，将 interface 转换为实际的 class 类
     *
     * @param type 类型
     * @return {@link Class}<{@link ?}>
     */
    protected Class<?> resolveInterface(Class<?> type) {
        Class<?> classToCreate;
        if (type == List.class || type == Collection.class || type == Iterable.class) {
            classToCreate = ArrayList.class;
        } else if (type == Map.class) {
            // Map->HashMap
            classToCreate = HashMap.class;
        } else if (type == SortedSet.class) {
            // SortedSet->TreeSet
            classToCreate = TreeSet.class;
        } else if (type == Set.class) {
            // Set->HashSet
            classToCreate = HashSet.class;
        } else {
            // 除此以外，就用原来的类型
            classToCreate = type;
        }
        return classToCreate;
    }
}
