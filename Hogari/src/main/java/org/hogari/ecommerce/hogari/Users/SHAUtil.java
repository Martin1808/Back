package org.hogari.ecommerce.hogari.Users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtil {

	public static String createHash(String password) {
		String resultado = password;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); //mesaggedigest genera una instancia para poder trabajar con ese algoritmo de cifrado
			md.update(password.getBytes()); //le paso a ese messagedigest el valor y convertirlo en bytes (parseando)
			byte[] resultadoEnBytes = md.digest(); //genera un cifrado almacenado en un resultadoEnBytes
			int max = resultadoEnBytes.length;
			String temporal;
			resultado ="";
			for (int i=0; i<max; i++) { //ciclo para recorrer el resultado
				temporal = Integer.toHexString(0xFF & resultadoEnBytes[i]);//convertimos a hexadecimal
				resultado += (temporal.length()<2)?0+temporal:temporal; //si es un caracter, le agreamos un 0 al principio
			}//for i
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return resultado; //le regreso al usuario la informacion
	}
	
	public static boolean verifyHash(String original, String hash) { //cuando guardemos en la BD, veremos el hash
		String resultado = createHash(original); // A mi BD no llega como 12345, si no como def919dkco2930l20d
		return resultado.equalsIgnoreCase(hash); //comparar en la BD la contrasenia previamente guardada (hash)
	}//verifyHash
	public static boolean verifyPasswd(String original, String newPassword) {
		return createHash(original).equalsIgnoreCase(createHash(newPassword));
	}//veri

}
