package Controller;
import Model.Modelo;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author miguel
 */
public class Controlador implements ActionListener{
    private Vista view;
    private Modelo model1;
    public Controlador (Vista view, Modelo model1){
        this.view=view;
        this.model1=model1;
        this.view.Btn1.addActionListener(this);
        this.view.BtnRestar.addActionListener(this);        
        this.view.BtnMulti.addActionListener(this);        
        this.view.BtnDividir.addActionListener(this);        
        this.view.BtnSalir.addActionListener(this);
    }
    public void Inicio(){
    view.setTitle("Usted va a sumar por medio de MVC");
    view.setLocationRelativeTo(null);
    view.txtN1.setText(String.valueOf(model1.getV1()));
    view.txtN2.setText(String.valueOf(model1.getV2()));
    view.txtN3.setText(String.valueOf(model1.getTotal()));        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        model1.setV1(Integer.valueOf(view.txtN1.getText()));
        model1.setV2(Integer.valueOf(view.txtN2.getText()));
        //codigo para identificar que boton se ha presionado
        if (e.getSource() == view.Btn1) {
            
        model1.sumar();
        view.txtN3.setText(String.valueOf(model1.getTotal()));
    } else if (e.getSource() == view.BtnRestar) 
    {
       model1.restar();
       view.txtN3.setText(String.valueOf(model1.getTotal()));
    } else if (e.getSource() == view.BtnMulti) {
        model1.multiplicar();
        view.txtN3.setText(String.valueOf(model1.getTotal()));
    } else if (e.getSource() == view.BtnDividir) {
        //validacion para la divicion para 0
        if(model1.getV2()==0){
            view.txtN3.setText("null div/0");
        }else{
        view.txtN3.setText(String.valueOf(model1.getTotal()));} 
    }
               
    }

    public void Cerrar(ActionEvent e){
        model1.setV1(Integer.valueOf(view.txtN1.getText()));
        model1.setV2(Integer.valueOf(view.txtN2.getText()));
        model1.restar();
        view.txtN3.setText(String.valueOf(model1.getTotal())); 
    }
}
