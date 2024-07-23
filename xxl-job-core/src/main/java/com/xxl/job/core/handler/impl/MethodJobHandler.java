package com.xxl.job.core.handler.impl;

import com.xxl.job.core.handler.IJobHandler;

import java.lang.reflect.Method;

/**
 * @author xuxueli 2019-12-11 21:12:18
 */
public class MethodJobHandler extends IJobHandler {

    /**bean对象**/
    private final Object target;
    /**被@XxlJob注释的方法**/
    private final Method method;
    /**XxlJob注解中指定的bean中的init方法**/
    private Method initMethod;
    /**XxlJob注解中指定的bean中的destroy方法**/
    private Method destroyMethod;

    public MethodJobHandler(Object target, Method method, Method initMethod, Method destroyMethod) {
        this.target = target;
        this.method = method;

        this.initMethod = initMethod;
        this.destroyMethod = destroyMethod;
    }

    @Override
    public void execute() throws Exception {
        Class<?>[] paramTypes = method.getParameterTypes();
        if (paramTypes.length > 0) {
            method.invoke(target, new Object[paramTypes.length]);       // method-param can not be primitive-types
        } else {
            method.invoke(target);
        }
    }

    @Override
    public void init() throws Exception {
        if(initMethod != null) {
            initMethod.invoke(target);
        }
    }

    @Override
    public void destroy() throws Exception {
        if(destroyMethod != null) {
            destroyMethod.invoke(target);
        }
    }

    @Override
    public String toString() {
        return super.toString()+"["+ target.getClass() + "#" + method.getName() +"]";
    }
}
