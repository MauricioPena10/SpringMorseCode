package com.mercadolibre.app.morsecode.controller;

import com.mercadolibre.app.morsecode.model.MorseCodeResponse;
import com.mercadolibre.app.morsecode.model.MorseCodeTranslateRequest;


import com.mercadolibre.app.morsecode.service.IMorseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
public class MorseCodeController {

    @Autowired
    private IMorseCodeService morseCodeService;

    @PostMapping("/2text")
    public ResponseEntity<MorseCodeResponse> translateToText( @RequestBody MorseCodeTranslateRequest morseCodeRequest){
        return ResponseEntity.ok(morseCodeService.translateToText(morseCodeRequest.getText()));
    }


    @PostMapping("/2morse")
    public ResponseEntity<MorseCodeResponse> translateToMorse( @RequestBody MorseCodeTranslateRequest morseCodeRequest){
        return ResponseEntity.ok(morseCodeService.translateToMorse(morseCodeRequest.getText()));
    }
}
