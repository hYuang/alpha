package com.huang.alpha.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
@Slf4j
public class ServletRequestHandledEventListener implements ApplicationListener<ServletRequestHandledEvent>  {
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        log.info(event.toString());
    }
}
