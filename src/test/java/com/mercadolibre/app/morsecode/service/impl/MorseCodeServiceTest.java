package com.mercadolibre.app.morsecode.service.impl;


import com.mercadolibre.app.morsecode.model.MorseCodeResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MorseCodeServiceTest {

    MorseCodeService service;

    @Test
    void translateToTextTest() {
        service = new MorseCodeService();
        MorseCodeResponse response = service.translateToText(".... --- .-.. .-  -- . .-.. ..");
        Assertions.assertEquals( "HOLA MELI", response.getResponse() );
    }

    @Test
    void translateToMorseTest() {
        service = new MorseCodeService();
        MorseCodeResponse response = service.translateToMorse("HOLA MELI");
        Assertions.assertEquals( ".... --- .-.. .-  -- . .-.. ..", response.getResponse() );
    }
}
