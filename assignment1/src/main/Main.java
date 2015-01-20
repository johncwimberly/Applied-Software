package main;

import controller.*;
import views.*;
import model.*;

public class Main {
	public static void main(String args[]){
		
		Model model = new Model();
		MainFrame mainWindow = new MainFrame(model);
		MainController controller = new MainController(model, mainWindow);
		
	}
	
}
