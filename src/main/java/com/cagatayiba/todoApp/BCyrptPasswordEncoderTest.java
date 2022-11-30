package com.cagatayiba.todoApp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class BCyrptPasswordEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for(int i = 0; i<10 ; i++) {
			String encoded = encoder.encode("iba");
			System.out.println(encoded);
		}
		//String encoded = encoder.encode("iba");
		// TODO Auto-generated method stub

	}

}
