package com.simple.mybatis.reflection.property;

import java.util.Locale;

/**
 * 属性命名者
 * 属性命名器
 *
 * @author SinceNovember
 * @date 2022/9/24
 */

public class PropertyNamer {

    /**
     * 属性命名者
     */
    private PropertyNamer() {

    }

    /**
     * 方法转换为属性
     *
     * @param name 方法名
     * @return {@link String}
     */
    public static String methodToProperty(String name) {
        if (name.startsWith("is")) {
            name = name.substring(2);
        } else if (name.startsWith("get") || name.startsWith("set")) {
            name = name.substring(3);
        } else {
            throw new RuntimeException("Error parsing property name '" + name + "'.  Didn't start with 'is', 'get' or 'set'.");
        }

        /*
         * 如果只有1个字母，转换为小写
         * 如果大于1个字母，第二个字母非大写，转换为小写
         */
        if (name.length() == 1 || (name.length() > 1 && !Character.isUpperCase(name.charAt(1)))) {
            name = name.substring(0, 1).toLowerCase(Locale.ENGLISH) + name.substring(1);
        }

        return name;
    }

    /**
     * 开头判断get/set/is
     *
     * @param name 名字
     * @return boolean
     */
    public static boolean isProperty(String name) {
        return name.startsWith("get") || name.startsWith("set") || name.startsWith("is");
    }

    /**
     * 是否为 getter
     *
     * @param name 名字
     * @return boolean
     */
    public static boolean isGetter(String name) {
        return name.startsWith("get") || name.startsWith("is");
    }

    /**
     * 是setter
     * 是否为 setter
     *
     * @param name 名字
     * @return boolean
     */
    public static boolean isSetter(String name) {
        return name.startsWith("set");
    }

}
