package com.simple.mybatis.reflection.invoker;

import java.lang.reflect.Field;


/**
 * getter 调用者
 *
 * @author SinceNovember
 * @date 2022/09/24
 */
public class GetFieldInvoker implements Invoker{

    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.getInt(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
