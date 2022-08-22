package com.mercadolibre.app.morsecode.service.impl;

import com.mercadolibre.app.morsecode.model.MorseCodeResponse;
import com.mercadolibre.app.morsecode.service.IMorseCodeService;
import org.springframework.stereotype.Service;

@Service
public class MorseCodeService implements IMorseCodeService {

    char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0' };

    String[] morseCodes
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "|" };

    @Override
    public MorseCodeResponse translateToText(String text) {

        StringBuilder builder = new StringBuilder();

        String[] morseWords = text.split("\\s{2}");
        for( String morseWord : morseWords){
            String[] morseSequence = morseWord.split(" ");
            for(int i = 0;i < morseSequence.length;i++) {
                for(int j = 0;j < morseCodes.length;j++) {
                    if(morseCodes[j].equals(morseSequence[i])) {
                        builder.append(letters[j]);
                        break;
                    }
                }
            }
            builder.append(" ");
        }

        MorseCodeResponse response = new MorseCodeResponse();
        response.setCode(200);
        response.setResponse(builder.toString().trim());
        return response;
    }

    @Override
    public MorseCodeResponse translateToMorse(String text) {
        StringBuilder builder = new StringBuilder();

        text = text.toUpperCase();

        String[] words = text.split(" ");
        for( String word : words){
            char[] morseSequence = word.toCharArray();
            for(int i = 0; i < morseSequence.length;i++) {
                for(int j = 0;j < letters.length;j++) {
                    if(letters[j] == morseSequence[i]) {
                        builder.append(morseCodes[j] + " ");
                        break;
                    }
                }
            }
            builder.append(" ");
        }

        MorseCodeResponse response = new MorseCodeResponse();
        response.setCode(200);
        response.setResponse(builder.toString().trim());
        return response;
    }
}
