package com.simple.mybatis.reflection.wrapper;

import com.simple.mybatis.reflection.MetaObject;

/**
 * 对象包装工厂
 *
 * @author SinceNovember
 * @date 2022/9/25
 */
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);

}
