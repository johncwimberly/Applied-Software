package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.JList;

import views.*;
import model.*;

public class MainController implements ActionListener, MouseListener {
	
	private Model model;
	private MainFrame view;
	private AddPartFrame view2;
	public MainController(Model model, MainFrame view) {

		this.model = model;
		this.view = view;
		new HashMap<Part, AddPartFrame>();
		view.addTestData();
		view.mainViewBtnListener(this);
		view.mainMouseListener(this);
	}

	/*
	 * Lots more will be added here once we collaborate more
	 * on the model, and better understand what actually needs
	 * to be done.
	 */
	public void actionPerformed(ActionEvent e) {
		String viewAction = e.getActionCommand();
		
		if(viewAction.equals("Add")){
			/*need to also implement a new controller which
			 * will control all things that occur in this
			 * 'newFrame'. Then each instance of this frame
			 * will have a controller that will handle what occurs
			 */
			view.createAddPartFrame();
		}
		
		if(viewAction.equals("Delete")){
			/*since we do not have an actual list yet, just want
			 * to make sure this button does something unique.
			 * Will work with the view to remove lines from a 
			 * JList once something is there to remove
			 * 
			 */
			Part deleteMe = view.getSelectedItem();
			if(deleteMe == null){
				view.setWarningLabel(3);
				return;
			}
			view.setWarningLabel(0);
			model.deletePart(deleteMe);
			view.deleteEntry(deleteMe);
			if(model.getMapOfViews().containsKey(deleteMe)){
				model.getMapOfViews().get(deleteMe).dispose();
			}
			System.out.println("You have selected DELETE! This is the item you wish to delete: \n" + deleteMe + "\n");
			System.out.print("\n----------------\n");
			System.out.println(model.getPartList());
			
		}
		
		if(viewAction.equals("Edit")){
			
			Part editMe = view.getSelectedItem();

			if(view.getPartsList().isSelectionEmpty()){
				view.setWarningLabel(1);
			}
			else if(model.getMapOfViews().containsKey(editMe)){
				view.setWarningLabel(2);
			}
			else{
				view2 = view.createEditPartFrame(editMe);
				model.getMapOfViews().put(editMe, view2);
				view.removeWarningLabel();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JList theList = (JList) e.getSource();
		if (e.getClickCount() == 2) {
			int index = theList.locationToIndex(e.getPoint());
			if (index >= 0) {
				Object obj = theList.getModel().getElementAt(index);
				Part editMe = view.getSelectedItem();
				if(model.getMapOfViews().containsKey(editMe)){
					view.setWarningLabel(2);
				}
				else{
					view2 = view.createEditPartFrame((Part)obj);
					model.getMapOfViews().put(editMe, view2);
				}
			}
		}
		if(e.getClickCount() == 1){
			view.setWarningLabel(0);
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}