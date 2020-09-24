package com.example.demo.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ResponseStatus
public class PagesControllers {
	
	@GetMapping(path="/{number}")
	public ResponseEntity<Object> getFinalNumber(@PathVariable("number") long number) {
		if(number <= 50 && isEven(number)) {
			return new ResponseEntity<>(factorielle(number),HttpStatus.OK);
		} else if(number > 50 && isOdd(number)) { 	
			return new ResponseEntity<>(number,HttpStatus.OK);
		} else if(isOdd(number)) {
			return new ResponseEntity<>(fibonacci(number),HttpStatus.OK);
		}
		return ResponseEntity.badRequest().body("Le nombre doit être positif");
	}
	
	private boolean isEven(long x) {
		return x % 2 == 0;
	}
	
	private boolean isOdd(long x) {
		return x % 2 == 1;
	}

	private long fibonacci (long x) {
		if (x <= 1) return x;
		else return fibonacci(x - 1) + fibonacci(x - 2);	
	}

	private long factorielle(long x) {
		if(x==0 || x==1) {
			return 1;
		}else
			return x*factorielle(x-1);
	}

}




