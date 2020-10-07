/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portapapeles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author David Freyre Muñoz
 * Fecha:06/10/2020
 */
public class ControllerPrincipal implements ActionListener,CaretListener{
    
    frmPrincipal frm;
    private boolean stateCutAndCopy = false;
   
    
    public ControllerPrincipal() {
        
        frm = new frmPrincipal();
        
        initComponentEvents();
        setComponentStates();
                        
        frm.setVisible(true);
        
    }//Fin del Constructor

    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource().equals(frm.getBtnExit()))
            System.exit(0);
        
        if(ae.getSource().equals(frm.getBtnCopy()))
            frm.getTxtArea().copy();
        
        if(ae.getSource().equals(frm.getBtnPaste()))
            frm.getTxtArea().paste();
        
        if(ae.getSource().equals(frm.getBtnCut()))
            frm.getTxtArea().cut();
        
    }//Fin @ActionPerformed

    
    //Idea feliz =D
    @Override
    public void caretUpdate(CaretEvent ce) {
        
    stateCutAndCopy = !(ce.getDot()==ce.getMark());
    setComponentStates();        
        
/*  //Idea no tan feliz =)    
      stateCutAndCopy=false; 
        
        if (ce.getDot()!=ce.getMark())
            stateCutAndCopy=true;
          
       setComponentStates();
*/ 
    }//Fin @CaretListener   
    
    
    private void initComponentEvents() {
        
        frm.getTxtArea().addCaretListener(this);
        
        frm.getBtnCopy().addActionListener(this);
        frm.getBtnPaste().addActionListener(this);
        frm.getBtnCut().addActionListener(this);
        frm.getBtnExit().addActionListener(this);
    }//Fin InitComponentEvent

    
    private void setComponentStates() {
        
        frm.getBtnCopy().setEnabled(stateCutAndCopy);
        frm.getBtnCut().setEnabled(stateCutAndCopy);
 
    }//Fin SetComponentStates



    
}//Fin controllerPrincipal
