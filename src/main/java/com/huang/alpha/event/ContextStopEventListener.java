package com.huang.alpha.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStopEventListener implements ApplicationListener<ContextStoppedEvent> {
    private final Log log = LogFactory.getLog(ContextStopEventListener.class);
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        log.info("ContextStoppedEvent");

    }
}
