package main;

import controller.*;
import views.*;
import model.*;
//import controller.*;

public class Main {
	public static void main(String args[]){
		
		Model model = new Model();
		MainFrame mainWindow = new MainFrame();
		MainController controller = new MainController(model, mainWindow);
		
	}
	
}
