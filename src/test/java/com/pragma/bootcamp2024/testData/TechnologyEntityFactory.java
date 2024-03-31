package com.pragma.bootcamp2024.testData;

import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;

import static com.pragma.bootcamp2024.testData.TechnologyFactory.getRandomName;

public class TechnologyEntityFactory {
    public static TechnologyEntity createTechnologyEntity() {
        String name = getRandomName();
        String description = "Description for " + name;
        return new TechnologyEntity(null, name, description);
    }

    public static TechnologyEntity toEntity(Long id, String name, String description) {
        return new TechnologyEntity(id, name, description);
    }
}
