package ua.in.dris4ecoder;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Alex Korneyko on 09.07.2016 20:40.
 */
public class ExecuteInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        if(!methodInvocation.getMethod().isAnnotationPresent(IsIntercepted.class)){
            return methodInvocation.proceed();
        }

        long start = System.currentTimeMillis();
        Object method = methodInvocation.proceed();
        System.out.println("Time for " + methodInvocation.getMethod().getName() + ": " + (System.currentTimeMillis() - start));

        return method;
    }
}
