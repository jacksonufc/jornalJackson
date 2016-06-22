package br.ufc.criptografia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import sun.misc.BASE64Encoder;

public class Criptografia {

	public String criptografa(String senha){
		try{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(senha.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(digest.digest());
	}catch (NoSuchAlgorithmException ns){
		ns.printStackTrace();
	}
		return senha;
	}
	
	/*
	public static void main(String[] args) {
		String senha ="1234";
		Criptografia c = new Criptografia();
		String senhaxt = c.criptografa(senha);
		
		System.out.println(senhaxt);
	}
	*/
	
}


