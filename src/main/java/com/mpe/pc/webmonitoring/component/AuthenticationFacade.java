package com.mpe.pc.webmonitoring.component;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
    Authentication getAuth();
}
