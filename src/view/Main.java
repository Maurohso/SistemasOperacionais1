package view;

import controller.RedesController;

import controller.RedesController;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "O que deseja consultar? Escolha de acordo com a opção a seguir.");
		int Escolha = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para consultar o Adaptador Ethernet || Digite 2 para consultar o ping."));
		
		if(Escolha == 1){
			RedesController redesController = new RedesController();
			String os = redesController.os();
			System.out.println(os);
			
			String process = "ipconfig";  //Interfaces de rede da máquina
			redesController.readProcess(process);
		}
		else{
			RedesController redesController = new RedesController();
			String os = redesController.os();
			System.out.println(os);
			
			String process = "ipconfig";  //Interfaces de rede da máquina
			redesController.readProcess(process);
			
		}
		
		
		
		
	}

}
