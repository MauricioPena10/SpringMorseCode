package com.mercadolibre.app.morsecode.service;

import com.mercadolibre.app.morsecode.model.MorseCodeResponse;
import org.springframework.stereotype.Component;

public interface IMorseCodeService {

    public MorseCodeResponse translateToText(String text);

    public MorseCodeResponse translateToMorse(String text);
}
