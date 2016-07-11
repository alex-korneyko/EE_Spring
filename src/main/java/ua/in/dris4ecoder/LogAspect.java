package ua.in.dris4ecoder;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class LogAspect {

    @Around("execution(* ua.in.dris4ecoder.Executor.execute())")
    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("Aspect. Before execute " + pjp.getSignature().getName());
        Object methodResult = pjp.proceed();
        System.out.println("Aspect. After execute " + pjp.getSignature().getName());

        return methodResult;
    }

}
