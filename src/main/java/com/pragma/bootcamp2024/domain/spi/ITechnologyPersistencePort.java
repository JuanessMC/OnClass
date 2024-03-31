package com.pragma.bootcamp2024.domain.spi;

import com.pragma.bootcamp2024.domain.model.Technology;

public interface ITechnologyPersistencePort {
    void saveTechnology(Technology technology);

}
