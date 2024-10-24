package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@GetMapping("/raizCuadrada/{value}")
    public ResponseEntity<?> raizCuadrada(@PathVariable Double value) {
        System.out.println("Fnd all");
        return ResponseEntity.ok(Math.sqrt(value));
    }
	
	@GetMapping("/add/{first_value}/{last_value}")
	public ResponseEntity<?> add(@PathVariable(name = "first_value")  Double firstValue, @PathVariable(name = "last_value") Double lastValue) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(String.format("%f", firstValue + lastValue));
	}
	
	@GetMapping("/substract/{first_value}/{last_value}")
	public ResponseEntity<?> substract(@PathVariable(name = "first_value")  Double firstValue, @PathVariable(name = "last_value") Double lastValue) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(String.format("%f", firstValue - lastValue));
	}
	
	@GetMapping("/multiply/{first_value}/{last_value}")
	public ResponseEntity<?> multiply(@PathVariable(name = "first_value")  Double firstValue, @PathVariable(name = "last_value") Double lastValue) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(String.format("%f", firstValue * lastValue));
	}
	
	@GetMapping("/divide/{first_value}/{last_value}")
	public ResponseEntity<?> divide(@PathVariable(name = "first_value")  Double firstValue, @PathVariable(name = "last_value") Double lastValue) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(String.format("%f", firstValue / lastValue));
	}
	
	@GetMapping("/raizCubica/{value}")
	public ResponseEntity<?> raizCubica(@PathVariable Double value) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(Math.cbrt(value));
	}
	
	@GetMapping("/potenciaN/{base}/{exponente}")
	public ResponseEntity<?> raizN(@PathVariable(name = "base") Double base, @PathVariable(name = "exponente") Double exponente) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(Math.pow(base, exponente));
	}
	
	@GetMapping("/logE/{value}")
	public ResponseEntity<?> logE(@PathVariable(name = "value") Double value) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(Math.log(value));
	}
	
	@GetMapping("/log10/{value}")
	public ResponseEntity<?> log10(@PathVariable(name = "value") Double value) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(Math.log10(value));
	}
	
	@GetMapping("/cos/{value}")
	public ResponseEntity<?> cos(@PathVariable(name = "value") Double value) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(Math.cos(value));
	}
	
	@GetMapping("/tan/{value}")
	public ResponseEntity<?> tan(@PathVariable(name = "value") Double value) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(Math.tan(value));
	}
	
	@GetMapping("/sin/{value}")
	public ResponseEntity<?> sin(@PathVariable(name = "value") Double value) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(Math.sin(value));
	}
	
	@GetMapping("/rad/{value}")
	public ResponseEntity<?> rad(@PathVariable(name = "value") Double value) {
		System.out.println("Fnd all");
		return ResponseEntity.ok(Math.toRadians(value));
	}
}
