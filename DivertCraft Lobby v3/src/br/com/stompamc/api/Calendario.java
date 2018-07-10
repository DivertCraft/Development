package br.com.stompamc.api;

import java.util.Calendar;

public class Calendario {
	
	public static enum Tipos{
		Segundos, Minutos, Hora, Dia, Mes, Ano

}
	
	
	public static int getData(Tipos c) {
		switch (c) {
		case Segundos:
			return Calendar.getInstance().get(13);
		case Minutos:
			return Calendar.getInstance().get(12);
		case Hora:
			return Calendar.getInstance().get(11);
		case Dia:
			return Calendar.getInstance().get(5);
		case Mes:
			return Calendar.getInstance().get(2) + 1;
		case Ano:
			return Calendar.getInstance().get(1);
		}
		return 0;
		
	}
}
