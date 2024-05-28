package com.ksa.jodayn.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MagicServiceImpTest {

    @Spy
    private MagicServiceImp magicService;

    @Test
    public void testMagicNumberTest() {
        assert (!magicService.testMagicNumber(123));
        assert (!magicService.testMagicNumber(321));
        assert (magicService.testMagicNumber(2519));
    }

    @Test
    public void numberTest2() {
        assert (magicService.number(1000) == 2519);
        verify(magicService, times(152))
                .testMagicNumber(anyInt());
    }


}
