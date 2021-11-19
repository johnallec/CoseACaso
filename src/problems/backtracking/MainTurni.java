package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTurni {

	public static void main(String[] args) {
		Backtracking backtracking = new Backtracking();
		List<String> turni = Arrays.asList("Luned� mattina", "Luned� pomeriggio", "Marted� mattina", 
				"Marted� pomeriggio", "Mercoled� mattina", "Mercoled� pomeriggio", "Gioved� mattina", "Gioved� pomeriggio", 
				"Venerd� mattina", "Venerd� pomeriggio","Sabato mattina", "Sabato pomeriggio");
		List<String> persone = Arrays.asList("Salvatore","Perfusionista2","Perfusionista3","Perfusionista4");
		ArrayList<String> t = new ArrayList<String>();
		ArrayList<String> p = new ArrayList<String>();
		for(String s : turni)
			t.add(s);
		for(String s : persone)
			p.add(s);
		backtracking.turni(t, p, 4);
	}

}
