package com.amsidh.mvc.decorator;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class MyTaskDecorator implements TaskDecorator {
    public static class MDCDecoratedRunnable implements Runnable {

        private final Runnable runnable;

        private final Map<String, String> contextMap;

        public MDCDecoratedRunnable(Runnable runnable) {
            super();
            this.runnable = runnable;
            this.contextMap = MDC.getCopyOfContextMap();
        }

        @Override
        public void run() {
            try {
                Optional.ofNullable(contextMap).ifPresent(MDC::setContextMap);
                runnable.run();
            } finally {
                MDC.clear();
            }
        }

    }

    @Override
    public Runnable decorate(Runnable runnable) {
        return new MDCDecoratedRunnable(runnable);
    }
}
