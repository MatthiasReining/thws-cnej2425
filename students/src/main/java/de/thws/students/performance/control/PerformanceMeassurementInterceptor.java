package de.thws.students.performance.control;

import de.thws.students.performance.boundary.PerformanceMeassurement;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@PerformanceMeassurement
@Interceptor
public class PerformanceMeassurementInterceptor {

    @AroundInvoke
    public Object measurePerformance(InvocationContext context) {

        long startTime = System.currentTimeMillis();

        try {
            var result = context.proceed();

            long durationTime = System.currentTimeMillis() - startTime;

            System.out.println(
                    "Duration time of " + context.getTarget().getClass().getName() + "#" + context.getMethod().getName()
                            + ": " + durationTime + " ms");

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
