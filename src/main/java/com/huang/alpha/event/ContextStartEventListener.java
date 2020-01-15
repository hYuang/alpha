package com.huang.alpha.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStartEventListener implements ApplicationListener<ContextStartedEvent> {
    private final Log logger = LogFactory.getLog(ContextStartEventListener.class);
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        logger.info(" ContextStartedEvent  ");

    }
}
