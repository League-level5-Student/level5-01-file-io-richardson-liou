package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	
	public static String encrypt (String message, int key) {
		StringBuilder encryptedMessage = new StringBuilder();
		char encryptedCh;
        for (int i = 0; i < message.length(); i++) {
            char current = message.charAt(i);
            if(Character.isSpace(current)) {
            	encryptedMessage.append(current);
            }
            	if(Character.isLetter(current)) {
            		int x = current;
            		System.out.println(current + " "+ x);
            		if (Character.isUpperCase(current)) {
            			if(current+key>90) {
            			encryptedCh = (char) (current+key-26);
            			}
            			else {
            				encryptedCh = (char) (current+key);
            			}
            		}
            		else {
            			if(current+key > 120) {
            				encryptedCh = (char) (current+key-26);
            			}
            			else {
            				encryptedCh = (char) (current + key);
            			}
            		}
            		
            		encryptedMessage.append(encryptedCh);
            	}


            }
        try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/test.txt");

			
			fw.write(encryptedMessage.toString());
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return encryptedMessage.toString();
	}
	
	
public static void main(String[] args) {
	System.out.println(encrypt("Hello World",4));
}
}



