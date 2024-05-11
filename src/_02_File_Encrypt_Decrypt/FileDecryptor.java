package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void decrypt(int key) {
		try {
			StringBuilder decryptedMessage = new StringBuilder();
			char decryptedCh;
			String message = "";
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/test.txt");
			int c;
			do{
				
				c = fr.read();
				if(c!=-1) {
					message += (char) c;
				}
			}while(c != -1);
			fr.close();
			
			System.out.println(message);

			for (int i = 0; i < message.length(); i++) {
				char current = message.charAt(i);
				if(!Character.isLetter(current)) {
					decryptedMessage.append(current);
				}
				if(Character.isLetter(current)) {
					if (Character.isUpperCase(current)) {
						if(current-key<65) {
							decryptedCh = (char) (current-key+26);
						}
						else {
							decryptedCh = (char) (current-key);
						}
					}
					else {
						if(current-key <97) {
							decryptedCh = (char) (current-key+26);
						}
						else {
							decryptedCh = (char) (current - key);
						}
					}
					System.out.println(decryptedCh);
					decryptedMessage.append(decryptedCh);

				}
			}
			JOptionPane.showMessageDialog(null, decryptedMessage.toString());


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		decrypt(4);
	}

}
