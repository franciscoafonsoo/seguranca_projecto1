package myWhatsServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by sherby on 06-03-2016.
 */
public class MyWhatsSkel {

	public MyWhatsSkel() {

	}
	
	
	/**
	 * se calhar deviamos fazer uma classe para users tambem, em vez de ficheiros e assim guardamos logo a
	 * password, o grupo e merdas dessas
	 */
	
	

	/**
	 * autenticar um cliente "user"
	 * @throws IOException 
	 *
	 */

	public String login(String user, String pwd) throws IOException{

		Boolean found = false;
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(new File("users.txt")));
		while ((line=reader.readLine()) != null || (!found)) {
			String[] dataF = line.split(":");
			if (dataF[0].equals(user)) {
				if (dataF[1].equals(pwd)) {
					found = true;
				}
				else {
					return "NOK";
				}
			}
			
		}
		if ((!found))
			this.register(user, pwd);
		return "OK";
		
	}

	/**
	 * registar um client "user"
	 * @throws IOException 
	 *
	 */

	public void register(String user, String pwd) throws IOException {

		MyWhatsUser newuser = new MyWhatsUser(user, pwd);
		
		FileWriter writer = new FileWriter(new File("users.txt"));
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write(user+":"+pwd);
	}


	public void handle(String pedido, String user) {
		String[] request = pedido.split(":");
		String op = request[0];
		switch (op) {
		case "-m":
			receiveMessage(request[2], user, request[1]);
			break;
		case "-f":
			
		case "-r":
			if (request.length == 1) {
				shareMessage(user);
			}
			else if (request.length == 2) {
				shareContact(request[1], user);
			}
			else {
				shareFile(request[1], request[2], user);
			}
		}
	}

	
	/**
	 * opcao -m
	 * recebe mensagem e a autorizacao de acesso ao client "user"
	 * escreve para um ficheiro log.txt na pasta log
	 *
	 */
	
	
	public void receiveMessage(String msg, String senduser, String recvuser) {

	}

	/**
	 * opcao -f
	 *
	 * recebe um ficheiro no servidor e da autorizacao de acesso ao client "user"
	 *
	 */

	public void receiveFile(File f, String senduser, String recvuser) {

	}

	/**
	 * opcao -r 
	 *
	 * partilha o nome ficheiro/mensagem trocada por outro client "user"
	 *
	 */

	public void shareMessage(String user) {

	}

	/**
	 * opcao -r contact
	 *
	 * partilhar todas as informacoes entre user e contact
	 *
	 */

	public void shareContact(String contact, String user) {

	}
	
	
	/**
	 * 
	 * opcao -r contact file
	 * 
	 * enviar o ficheiro com nome fileName, enviado por contact
	 */
	
	public void shareFile(String contact, String fileName, String user) {
		
	}
}
