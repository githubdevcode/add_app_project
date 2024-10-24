package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/words/list")
    public ResponseEntity<?> wordsList() {
        System.out.println("Fnd all");
        Set<Character> vocals = new HashSet<>();
        vocals.add('a');
        vocals.add('e');
        vocals.add('i');
        vocals.add('o');
        vocals.add('u');
        
        char[] availableChars = new char[] {
        		'w','e','r','f','b','h','j','i','u','y','t','r','e','d','f','g','u','t','r','e','s','d','f','g','y','u','i','o','l','k','m','n','b','v','f','r','e','w','s','x','f','g','y','u','i','k',
        		'm','n','b','v','f','r','e','w','w','r','t','y','u','i','o','k','m','n','b','v','d','w','s','x','c','f','g','h','u','i','o','p','l','k','n','b','v','f','d','e','w','a','z','x','c','g',
        		'h','u','i','o','p','u','y','t','r','e','w','q','s','d','f','g','k','j','b','v','c','x'
        };
        
        List<String> foundWords = new ArrayList<>();
        int amountOfWords = new Random().nextInt(1, 10);
        for (int i = 0; i < amountOfWords; i++) {
			
        	
        	int charNumber = 0;
        	int amountOfChars = new Random().nextInt(4, 8);
        	List<Character> foundCharsArray = new ArrayList<>();
        	Boolean foundVocal = null;
        	Boolean foundLetter = null;
			for(int startIndex = new Random().nextInt(0, availableChars.length - 5); startIndex < availableChars.length - 1; startIndex++) {
				char achar = availableChars[startIndex];
//				logger.info("The char is {} the charNumber is {} the amount of chars is {} the start index is {} the available chars {} 2°", achar, charNumber, amountOfChars,
//						startIndex, availableChars.length - 1);
				if(vocals.contains(achar)) {
					if(foundVocal != null && foundVocal) {
						logger.info("Entro continue 1°");
						continue;
					}
					foundVocal = true;
					foundLetter = false;
				} else {
					if(foundLetter != null && foundLetter) {
						logger.info("Entro continue 2° found char {}", achar);
						continue;
					}
					foundLetter = true;
					foundVocal = false;
				}
				charNumber++;
				if(charNumber > amountOfChars) {
					break;
				}
				logger.info("The char is {} the charNumber is {} the amount of chars is {} the start index is {} the available chars {} 1°", achar, charNumber, amountOfChars,
						startIndex, availableChars.length - 1);
				foundCharsArray.add(achar);
			}
			
			if(foundCharsArray.size() <= 2)
				continue;
			
			StringBuilder finalWord = new StringBuilder();
			for(char currChar : foundCharsArray) {
				finalWord.append(currChar);
			}
			
			foundWords.add(finalWord.toString());
		}        
        
        return ResponseEntity.ok(foundWords);
    }
}
