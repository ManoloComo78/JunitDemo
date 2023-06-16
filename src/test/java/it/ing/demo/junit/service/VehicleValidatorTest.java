package it.ing.demo.junit.service;

import it.ing.demo.junit.util.CarValidator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VehicleValidatorTest {

    @InjectMocks
    private CarValidator carValidator;

}