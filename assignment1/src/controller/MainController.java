package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.*;
import model.*;

public class MainController implements ActionListener {
	private Model model;
	private MainFrame view;

	public MainController(Model model, MainFrame view) {

		this.model = model;
		this.view = view;

		view.mainViewBtnListener(this);
	}

	/*
	 * Lots more will be added here once we collaborate more
	 * on the model, and better understand what actually needs
	 * to be done.
	 */
	public void actionPerformed(ActionEvent e) {
		String viewAction = e.getActionCommand();
		
		if(viewAction.equals ("Add")){
			/*need to also implement a new controller which
			 * will control all things that occur in this
			 * 'newFrame'. Then each instance of this frame
			 * will have a controller that will handle what occurs
			 */
			DetailsFrame newFrame = new DetailsFrame();
		}
		
		if(viewAction.equals("Delete")){
			/*since we do not have an actual list yet, just want
			 * to make sure this button does something unique.
			 * Will work with the view to remove lines from a 
			 * JList once something is there to remove
			 */
			System.out.println("YOU TRIED TO DELETE");
		}
		
	}
}