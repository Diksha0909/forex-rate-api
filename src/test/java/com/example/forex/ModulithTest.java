package com.example.forex;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModulithTest {

    @Test
    void verifyModules() {
        ApplicationModules.of(ForexApplication.class).verify();
    }
}
