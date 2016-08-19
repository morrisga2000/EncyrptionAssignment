package encryption_message_exercise;
import java.util.Random;
import java.util.Scanner;


public class EncryptionTextMessage {
    static byte[] keyValue =  new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String strCipherText = null;
 //   String strDecryptedText = null;



	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String strDataToEncrypt = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter a message, which will be encrypted.");
		strDataToEncrypt = sc.nextLine();
		
	run(strDataToEncrypt);
		
		
		
	}  // end main
	
	
	
	
	
	
	
	public static void run(String strDataToEncrypt)  {
		int shifter = 0;
		String decrypted = null;
		String strEncrypt = "";
		String reverse = "";
    	String piglatin = "";
        Random generator = new Random(); 
        String key = "VIGENERECIPHER";
			

		    
		      for ( int i = strDataToEncrypt.length() - 1; i >= 0; i-- )
		    	reverse = reverse + strDataToEncrypt.charAt(i);
		    System.out.println(reverse); 
		    
		    shifter = generator.nextInt(25) +1;
		    System.out.println("Caesar cipher shift is " + shifter);
		    
	//	    strCipherText = encryptVigen(reverse, key);
	//	    System.out.println(encryptVigen(reverse, key));
		     System.out.println(caesarCipher(reverse, shifter));
		     strCipherText = caesarCipher(reverse, shifter);
		    System.out.println(decrypt(strCipherText, shifter));
		    
		//    System.out.println(decryptVigen(strCipherText, key));
		    

	}  // end method called run
	
	/*
	static String encryptVigen(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
 
    static String decryptVigen(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }  */
	
	static String caesarCipher(String msg, int shift){
	    String s = "";
	    int len = msg.length();
	    for(int x = 0; x < len; x++){
	        char c = (char)(msg.charAt(x) + shift);
	        if ((Character.isLowerCase(msg.charAt(x)) && c > 'z') || (Character.isUpperCase(msg.charAt(x)) && c > 'Z'))
	            s += (char)(msg.charAt(x) - (26-shift));
	        else
	            s += (char)(msg.charAt(x) + shift);
	    }
	    return s;
	}  // end of method caesarCipher
	
	
	public static String decrypt(String cipherText, int shiftKey)
    {
        String plainText = "";
        String reverse360 = "";
        int len = cipherText.length();
	    for(int x = 0; x < len; x++){
	        char c = (char)(cipherText.charAt(x) + (26 - shiftKey));
	        if ((Character.isLowerCase(cipherText.charAt(x)) && c > 'z') || (Character.isUpperCase(cipherText.charAt(x)) && c > 'Z'))
	            plainText += (char)(cipherText.charAt(x) - (shiftKey));
	        else
	            plainText += (char)(cipherText.charAt(x) + (26 - shiftKey));
	    }
	      for ( int i = plainText.length() - 1; i >= 0; i-- )
	      {
	    	reverse360 = reverse360 + plainText.charAt(i);
	      }
	      plainText = reverse360.replace(":", " ");
                return plainText;
    } 
	
		/*  try {
			 
			           // Create key and cipher
			           Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			           Cipher cipher = Cipher.getInstance("AES");
			           // encrypt the text
			           cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			           byte[] encrypted = cipher.doFinal(strDataToEncrypt.getBytes());
			           System.err.println(new String(encrypted));

			           // decrypt the text
			           cipher.init(Cipher.DECRYPT_MODE, aesKey);
			           decrypted = new String(cipher.doFinal(encrypted));
			           System.err.println(decrypted);
			        }catch(Exception e) {
			           e.printStackTrace();
			        }

		
		System.out.println(decrypted);    */
		


	
}  //end class
