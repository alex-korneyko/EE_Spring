package ua.in.dris4ecoder;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ExecutorInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Interceptor. Before execution of: " + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        System.out.println("Interceptor. After execution of: " + methodInvocation.getMethod().getName());
        return result;
    }
}
