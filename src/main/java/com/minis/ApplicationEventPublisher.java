package com.minis;

import com.apple.eawt.ApplicationEvent;

public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent applicationEvent);
}
