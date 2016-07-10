package ua.in.dris4ecoder;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Alex Korneyko on 09.07.2016 21:16.
 */
public class LogAspect {

    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogAspect. Before execution of: " + pjp.getSignature().getName());
        Object proceed = pjp.proceed();
        System.out.println("LogAspect. After execution of: " + pjp.getSignature().getName());
        return proceed;
    }

}
