package controller2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class controller2 {
	
	public String os(){
		String os = System.getProperty("os.name"); //Quando pedimos "os.name" ele sabe que queremos o nome do SO.
		String arch = System.getProperty("os.arch"); //Traz a arquitetura
		String version = System.getProperty("os.version"); // Vers�o
		return os + " - v. "+ version + " - arch. " + arch;
	}

	public void readProcess(String process){
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);  //Aqui ele l� o que ta passando em "p" e converte para string
			BufferedReader buffer = new BufferedReader(leitor);  // A vari�vel "vetor" est� recebendo o fluxo, convertendo e guardando no buffer
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void killProcess(String param){
		String cmdPid = "TASKKILL /PID";  //ESSE � S� PARA WINDOWS, TEM QUE PESQUISAR O DO LINUX
		String cmdNome = "TASKKILL /IM";
		int pid = 0;  //int pq o PID s� tem n�mero
		StringBuffer buffer = new StringBuffer();
		
		//NumberFormatException -> Exception 
		try{
			//TASKKILL /PID XXXXX
			pid = Integer.parseInt(param);  /*Caso o "param" for s� n�mero ele vai passar, por�m se n�o for ele vai dar erro. Por�m j�
			descobrimos como n�o encerrar a aplica��o em casos de erro*/
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			
		}
		catch(NumberFormatException e){
			//TASKKILL /IM nomedoprocesso.exe
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
			
		}
		
		killProcess(buffer.toString());
		
		
	}	
	
}
