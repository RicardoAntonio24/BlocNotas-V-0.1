/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewBloc;
import models.ModelBloc;
/**
 *
 * @author Ricardo - VAIO
 */
public class ControllerBloc implements ActionListener {
    ModelBloc modelBloc;
    ViewBloc viewCBloc;
    public ControllerBloc(ViewBloc viewCBloc, ModelBloc modelBloc){
        this.viewCBloc = viewCBloc;
        this.modelBloc = modelBloc;
        this.viewCBloc.jmi_guardar.addActionListener(this);
        this.viewCBloc.jmi_leer.addActionListener(this);
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewCBloc.jmi_leer){
            leer();
        } 
        else if(e.getSource() == viewCBloc.jmi_guardar){
            escribe();
        }
    }
    /**
     * llama el metodo del model
     */
    public void leer(){
        modelBloc.leer();
        viewCBloc.jta_texto.setText(modelBloc.getMensage());
    }
    /**
     * llama un metodo del model para guardar
     */
    public void escribe(){
        modelBloc.setMensage(viewCBloc.jta_texto.getText());
        modelBloc.escribir();
    }
    private void initComponents(){
        viewCBloc.setVisible(true);
    }
}