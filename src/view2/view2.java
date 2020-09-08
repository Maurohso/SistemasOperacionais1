package view2;

import controller2.controller2;

public class view2 {

	public static void main(String[] args) {
		controller2 procController = new controller2();
		String os = procController.os();
		System.out.println(os);
		
		
	/* Abaixo vai fechar a aplicação usando o nome dela*/
	//	String param = "cmd.exe";   
	//	procController.killProcess(param);
	
	/* Aqui é pelo PID */
	String param = "11304";
	procController.killProcess(param);
	}
}
