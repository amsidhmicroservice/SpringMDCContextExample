package com.amsidh.mvc.aspects;

import com.amsidh.mvc.decorator.MyTaskDecorator;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.task.TaskDecorator;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class TaskSchedulerInterceptor {

    private final TaskDecorator taskDecorator;

    @Pointcut("within(org.springframework.scheduling.TaskScheduler+)")
    void taskScheduler() {
        // empty
    }

    @Around("taskScheduler() && args(run,..)")
    Object around(ProceedingJoinPoint pjp, Runnable run) throws Throwable {
        Object[] args = pjp.getArgs();

        if (!(run instanceof MyTaskDecorator.MDCDecoratedRunnable)) args[0] = taskDecorator.decorate(run);

        return pjp.proceed(args);
    }

}
