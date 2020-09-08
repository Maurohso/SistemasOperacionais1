package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	//Criando o construtor de classes
	public RedesController() {
		super();
		
	}
	
	public String os(){
		String os = System.getProperty("os.name"); //Aqui ele recebe o nome do Sistema Operacional.
		return os;
				
	}
	
	public void readProcess(String process){ // Verifica IPV4
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);  //Aqui ele lê o que ta passando em "p" e converte para string
			BufferedReader buffer = new BufferedReader(leitor);  // A variável "vetor" está recebendo o fluxo, convertendo e guardando no buffer
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
