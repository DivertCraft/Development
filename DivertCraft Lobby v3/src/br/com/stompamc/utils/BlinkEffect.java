package br.com.stompamc.utils;

public class BlinkEffect {
	
	private int i = 1;
	private String texto = "§7§lStompaMC";
	public BlinkEffect(){
		
	}
	
	public void next(){
		if (i == 1){
			texto = "§7§lVIRTUALMC";
		}
		if (i == 2){
			texto = "§6§lVIRTUALMC";
		}
		if (i == 3){
			texto = "§6§lVIRTUALMC";
		}
		if (i == 4){
			texto = "§3§lVIRTUALMC";
		}
		if (i == 5){
			texto = "§3§lVIRTUALMC";
		}
		if (i == 6){
			texto = "§6§lVIRTUALMC";
		}
		if (i == 7){
			texto = "§6§lVIRTUALMC";
		}
		if (i == 8){
			texto = "§e§lVIRTUALMC";
		}
		if (i == 9){
			texto = "§e§lVIRTUALMC";
		}
		if (i == 10){
			texto = "§d§lVIRTUALMC";
		}
		if (i == 11){
			texto = "§d§lVIRTUALMC";
		}
		if (i == 12){
			texto = "§c§lVIRTUALMC";
		}
		if (i == 13){
			texto = "§c§lVIRTUALMC";
		}
		if (i == 14){
			texto = "§6§lVIRTUALMC";
		}
		if (i == 15){
			texto = "§6§lVIRTUALMC";
		}
		if (i == 16){
			texto = "§a§lVIRTUALMC";
		}
		if (i == 17){
			texto = "§a§lVIRTUALMC";
			i = 0;
		}
		i++;
		
		
	}
	public String getText(){
		return texto;
	}

}
