package com.pragma.bootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.ElementAlreadyExistsException;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.bootcamp2024.domain.model.Technology;
import com.pragma.bootcamp2024.testData.TechnologyFactory;
import com.pragma.bootcamp2024.testData.TechnologyEntityFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TechnologyAdapterTest {
    @Mock
    private ITechnologyRepository technologyRepository;

    @Mock
    private ITechnologyEntityMapper technologyEntityMapper;

    @InjectMocks
    private TechnologyAdapter technologyAdapter;

    @Test
    @DisplayName("Given a technology that doesn't exist in the repository, it should be saved successfully.")
    void saveTechnologySuccessfully() {
        // GIVEN
        Technology technology = TechnologyFactory.createTechnology();
        TechnologyEntity technologyEntity = TechnologyEntityFactory.toEntity(technology.getId(), technology.getName(), technology.getDescription());
        when(technologyRepository.findByName(technology.getName())).thenReturn(Optional.empty());
        when(technologyEntityMapper.toEntity(technology)).thenReturn(technologyEntity);

        // WHEN
        assertDoesNotThrow(() -> technologyAdapter.saveTechnology(technology));

        // THEN
        verify(technologyRepository, times(1)).findByName(technology.getName());
        verify(technologyRepository, times(1)).save(technologyEntity);
    }

    @Test
    @DisplayName("Given a technology that already exists in the repository, it should throw a TechnologyAlreadyExistsException.")
    void saveTechnologyWhenTechnologyExists() {
        // GIVEN
        Technology technology = TechnologyFactory.createTechnology();
        when(technologyRepository.findByName(technology.getName())).thenReturn(Optional.of(new TechnologyEntity()));

        // WHEN
        assertThrows(ElementAlreadyExistsException.class, () -> technologyAdapter.saveTechnology(technology));

        // THEN
        verify(technologyRepository, times(1)).findByName(technology.getName());
        verify(technologyRepository, never()).save(any());
    }
}