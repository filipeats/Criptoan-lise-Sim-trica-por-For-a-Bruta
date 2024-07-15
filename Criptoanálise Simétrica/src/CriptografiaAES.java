import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaAES {
	public static String cifrar(String texto,
								String senha) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(
							 "TAP120424Junior0".getBytes("UTF-8"));
		byte[] senha32bits = MessageDigest.getInstance("SHA-256").
							digest(senha.getBytes("UTF-8"));
		SecretKey chave = new SecretKeySpec(senha32bits, "AES");
		
	    Cipher cifra = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    cifra.init(Cipher.ENCRYPT_MODE, chave, iv);
	    byte[] textoCifrado = cifra.doFinal(texto.getBytes("UTF-8"));
	    
	    return Base64.getEncoder().encodeToString(textoCifrado);
	}
	
	public static String decifrar(String textoCifrado,
								  String senha) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(
							"TAP120424Junior0".getBytes("UTF-8"));
		byte[] senha32bits = MessageDigest.getInstance("SHA-256").
							digest(senha.getBytes("UTF-8"));
		SecretKey chave = new SecretKeySpec(senha32bits, "AES");

		Cipher cifra = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cifra.init(Cipher.DECRYPT_MODE, chave, iv);
		byte[] texto = cifra.doFinal(Base64.getDecoder().
											decode(textoCifrado));

		return new String(texto);
	}
}