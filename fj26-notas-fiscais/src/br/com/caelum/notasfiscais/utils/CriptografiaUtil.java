/**
 * 
 */
package br.com.caelum.notasfiscais.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ThiagoLeão
 *
 */
public class CriptografiaUtil {
	/**
	 * 
	 * @param s
	 * @return Retorna String criptografada.
	 * @throws NoSuchAlgorithmException
	 */
	public String criptografa(String s) throws NoSuchAlgorithmException{
		 MessageDigest md = MessageDigest.getInstance("SHA-1");  
	     md.update( s.getBytes() );
	     byte[] hash = md.digest();
	     StringBuffer hexString = new StringBuffer();
	     for (int i = 0; i < hash.length; i++) {
	          if ((0xff & hash[i]) < 0x10){
	               hexString.append( "0" + Integer.toHexString((0xFF & hash[i])));
	          }
	          else{
	           hexString.append(Integer.toHexString(0xFF & hash[i]));
	          }
	     }
	     return hexString.toString();
	}

}
