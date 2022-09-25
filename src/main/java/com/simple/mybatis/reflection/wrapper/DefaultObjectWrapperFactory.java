package com.simple.mybatis.reflection.wrapper;

import com.simple.mybatis.reflection.MetaObject;

/**
 * .默认对象包装工厂
 *
 * @author SinceNovember
 * @date 2022/9/27
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory{
    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
