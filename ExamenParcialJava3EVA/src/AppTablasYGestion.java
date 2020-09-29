import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;



public class AppTablasYGestion extends JPanel {
	
	

				private static final long serialVersionUID = 1L;
				static JFrame ventanaPrincipal;
			    
				
				public AppTablasYGestion() {
				
				
			    JMenu mArchivo = new JMenu("Archivo");
			    
			    JMenu mOpciones = new JMenu("Opciones");
			    
			    JMenuItem mSalir = new JMenuItem( "Salir" );
			    
			    mArchivo.addSeparator();
			    mArchivo.add( mSalir );
			    
			    JMenuItem mTablaM = new JMenuItem( "Tabla de multiplicar" );
			    mOpciones.add( mTablaM );
			    
			    JMenuItem mGestL = new JMenuItem( "Gestion Listas" );
			    mOpciones.add( mGestL );
			    
			    JMenuBar menuBar = new JMenuBar();
			    
			    
			    menuBar.add(mArchivo);
			    menuBar.add(mOpciones);
			    setLayout(new BorderLayout());
			    add(menuBar, BorderLayout.NORTH);
			    
			      
			    JTextArea textBoxOut = new JTextArea();
			    textBoxOut.setBackground(Color.LIGHT_GRAY);
			    add(new JScrollPane(textBoxOut), BorderLayout.CENTER);
			        
			    
			    Dialog tituloTablaDialog = new Dialog( ventanaPrincipal,"Cuadro de diálogo de la Tabla de multiplicar",true );
			    JSlider scrollSlider = new JSlider(JSlider.HORIZONTAL,1,10,1);;
			    
			    
			    
			    scrollSlider.setPaintLabels(true);
			    scrollSlider.setMajorTickSpacing(1);
			    JLabel inNum = new JLabel("nº seleccionado:");
			    JTextField intNumTextF = new JTextField("1"); 
			    intNumTextF.setEditable(false);
			    JPanel panelAceptCancel = new JPanel();
			    panelAceptCancel.setLayout(new GridLayout(2,5));
			    JButton botonForActionListener;
			    
			    
			    for (int i=1; i<=10; i++){
			        panelAceptCancel.add(botonForActionListener = new JButton(""+i));
			        botonForActionListener.addActionListener(new BotTablaMulti(intNumTextF));
			    } 
			    
			    
			    
			    JButton bAcept = new JButton( "Aceptar" );
			    JButton bCancel = new JButton( "Cancelar" );
			    JPanel panelNums = new JPanel();
			    panelNums.setLayout(new GridLayout(1,3));
			    panelNums.add(inNum);
			    panelNums.add(intNumTextF);
			    
			    JPanel panelAceptCancel2 = new JPanel();
			    panelAceptCancel2.setLayout(new GridLayout(2,1));
			    panelAceptCancel2.add(bAcept);
			    panelAceptCancel2.add(bCancel);
			    panelNums.add(panelAceptCancel2);
			    JPanel panelAceptCancelSlider = new JPanel();
			    
			    panelAceptCancelSlider.setLayout(new GridLayout(3,1));
			    panelAceptCancelSlider.add(panelAceptCancel);
			    panelAceptCancelSlider.add(scrollSlider);
			    panelAceptCancelSlider.add(panelNums);
			    tituloTablaDialog.add(panelAceptCancelSlider, "Center");
			    
			    
			    
			    scrollSlider.addChangeListener(new SelecNumTablaSlider(intNumTextF));
			    bAcept.addActionListener(new VerTablaMulti( tituloTablaDialog, intNumTextF, textBoxOut) );
			    bCancel.addActionListener(new CloseEventDialogo( tituloTablaDialog ) );
			   
			    
			    
			    Dialog tituloListaDialog = new Dialog( ventanaPrincipal,"Cuadro de dialogo de Listas",true );
			
			    
			    JLabel inElement = new JLabel("Texto del elemento a agregar:");
			    
			    
			    JTextField inElementTextF = new JTextField("");
			    
			    
			    JPanel panelElement = new JPanel();
			    
			    panelElement.setLayout(new GridLayout(1,2));
			    panelElement.add(inElement);
			    panelElement.add(inElementTextF);
			    
			    JButton bAdd = new JButton( "Agregar elemento" );
			    bAdd.setEnabled(false); 
			    JButton bDelete = new JButton( "Quitar elemento" );
			    
			    bDelete.setEnabled(false); 
			
			    JButton bDeleteAll = new JButton( "Vaciar la lista" ); 
			    
			    JPanel panelOpcionesList = new JPanel();
			    panelOpcionesList.setLayout(new GridLayout(3,1));
			    panelOpcionesList.add(bAdd);
			    panelOpcionesList.add(bDelete);
			    panelOpcionesList.add(bDeleteAll);
			    
			    JLabel tituloCuadroList = new JLabel("Cuadro de lista:");
			    List obejtoListaCuadro = new List();
			    obejtoListaCuadro.setMultipleMode(true); 
			
			    
			    for (int i=1; i<=10; i++) 
			    	obejtoListaCuadro.add("Elemento " + i);
			    
			    
			    JPanel panelSLista = new JPanel();
			    panelSLista.setLayout(new BorderLayout());
			    panelSLista.add(tituloCuadroList,BorderLayout.NORTH);
			    panelSLista.add(new JScrollPane(obejtoListaCuadro),BorderLayout.CENTER);
			    
			    JPanel panelOpLista = new JPanel();
			    panelOpLista.setLayout(new GridLayout(1,2));
			    panelOpLista.add(panelOpcionesList);
			    panelOpLista.add(panelSLista);
			    
			    JLabel panelTextSelecLista = new JLabel("Valor seleccionado en la lista:");
			    JTextField edicionSeleccionLista = new JTextField("");
			    edicionSeleccionLista.setEditable(false);
			    
			    
			    JButton bAcept2 = new JButton( "Aceptar" );
			    JButton bCancel2 = new JButton( "Cancelar" );
			    JPanel panelListAdd = new JPanel();
			    panelListAdd.setLayout(new GridLayout(1,4));
			    panelListAdd.add(panelTextSelecLista);
			    panelListAdd.add(edicionSeleccionLista);
			    panelListAdd.add(bAcept2);
			    panelListAdd.add(bCancel2);
			    tituloListaDialog.add(panelElement,BorderLayout.NORTH);
			    tituloListaDialog.add(panelOpLista,BorderLayout.CENTER);
			    tituloListaDialog.add(panelListAdd,BorderLayout.SOUTH);
			    
			   
			    inElementTextF.addCaretListener(new BotIntroducirElementoLista(inElementTextF,  bAdd));
			    bAdd.addActionListener(new AgregarElemento( inElementTextF, obejtoListaCuadro, bDeleteAll, bDelete ) );
			    bDelete.addActionListener(new EliminarElementoLista( obejtoListaCuadro, bDeleteAll, bDelete) );
			    bDeleteAll.addActionListener(new EliminarTodoLista( obejtoListaCuadro, bDeleteAll, bDelete ) );
			    obejtoListaCuadro.addItemListener(new VisualizarSeleccionLista(obejtoListaCuadro, edicionSeleccionLista, bDelete));
			    bAcept2.addActionListener(new VerElementosSelec( tituloListaDialog, obejtoListaCuadro, textBoxOut ) );
			    bCancel2.addActionListener(new CloseEventDialogo( tituloListaDialog ) );
			    
			    mSalir.addActionListener (new ActionListener(){
			        public void actionPerformed( ActionEvent event ){
			        	System.exit( 0 );
        }
     });
   
			    
			    
			    
    mTablaM.addActionListener(
      new VerPosicionDialogosList( tituloTablaDialog,350, 450,250 ) );
    mGestL.addActionListener(
      new VerPosicionDialogosList( tituloListaDialog,350, 450,250 ) );
    }
  
  
	
	
	public static void main( String args[] ) {
    ventanaPrincipal = new JFrame( "TERCER EXAMEN PARCIAL JAVA" );

    
    
   
    ventanaPrincipal.addWindowListener( new WindowAdapter() {
        public void windowClosing( WindowEvent evt ) {
        System.exit( 0 );
      }
     } );

   
    ventanaPrincipal.getContentPane().add( new AppTablasYGestion(),BorderLayout.CENTER );
    ventanaPrincipal.setSize( 550,350 );
    ventanaPrincipal.setLocation(650, 350);

    ventanaPrincipal.setVisible( true );
    }
}




class CloseEventDialogo implements ActionListener {
	Dialog objetoDialog;
	
	CloseEventDialogo( Dialog eventDialog ) {
		objetoDialog = eventDialog;
	}
	
	public void actionPerformed( ActionEvent event ) {
		objetoDialog.setVisible( false );
	}
}




class  SelecNumTablaSlider implements ChangeListener {
	JTextField objetoNumero;
        SelecNumTablaSlider(JTextField eventNumero)
        {
            objetoNumero = eventNumero;
        }
        public void stateChanged(ChangeEvent e) {
		objetoNumero.setText(""+((JSlider)e.getSource()).getValue());
	}
}





class VerPosicionDialogosList implements ActionListener {
	Dialog objetoDialog;
	int objetoOffsetDialog,objetoTamanPosX,objetoTamPosY;
	
	VerPosicionDialogosList( Dialog objetoDialogoEvent,int objetoOffsetDialogEvent,int tamPosX,int tamPosY ) {
		objetoDialog = objetoDialogoEvent;
		objetoOffsetDialog = objetoOffsetDialogEvent;
		objetoTamanPosX = tamPosX;
		objetoTamPosY = tamPosY;
	}
	
	public void actionPerformed( ActionEvent event ) {
		objetoDialog.setBounds( objetoOffsetDialog,objetoOffsetDialog,objetoTamanPosX,objetoTamPosY );
		objetoDialog.setVisible(true);    
	}
}




class VerTablaMulti implements ActionListener {
	Dialog objetoDialog;
	JTextField objetoNumero;
        JTextArea objetoTextBoxMulti;
	int i;
	
	VerTablaMulti(Dialog objetoDialogEvent, JTextField objetoTextNum, JTextArea textBoxMultip ) {
		objetoDialog = objetoDialogEvent;
		objetoNumero = objetoTextNum;
                objetoTextBoxMulti = textBoxMultip;
	}
	
	public void actionPerformed( ActionEvent evt ) {
		
		
		
		
            int numMultip = Integer.parseInt(objetoNumero.getText());
            objetoTextBoxMulti.setFont(new Font("SansSerif",Font.BOLD,18));
            objetoTextBoxMulti.setText("                    Tabla de multiplicar del Nº:"+objetoNumero.getText()+ "\n");
            System.out.println("    Tabla de multiplicar del Nº:"+objetoNumero.getText());
            
            
            for (i=1; i<=10; i++){
                objetoTextBoxMulti.append("\t"+objetoNumero.getText()+" * "+i+" = "+numMultip*i);
                if (i!=10) objetoTextBoxMulti.append("\n");
                System.out.println("\t"+objetoNumero.getText()+" * "+i+" = "+numMultip*i);
            }
            
            objetoDialog.setVisible( false );
	}
}


class  BotTablaMulti implements ActionListener {
	JTextField objetoNumero;
        BotTablaMulti(JTextField eventNumero)
        {
            objetoNumero = eventNumero;
        }
        public void actionPerformed(ActionEvent e) {
		objetoNumero.setText(""+((JButton)e.getSource()).getText());
	}
}





class BotIntroducirElementoLista implements CaretListener{
	
	JTextField objetoNuevoEnt;
	JButton objetoBotonAgregar;
	
	BotIntroducirElementoLista(JTextField nuevaEntrada, JButton botonAgregar ){
		objetoNuevoEnt = nuevaEntrada;
		objetoBotonAgregar = botonAgregar;
	}
	public void caretUpdate(CaretEvent e) {
		
		
		if (objetoNuevoEnt.getText().length() != 0){
			objetoBotonAgregar.setEnabled(true);
		}
		else 
			objetoBotonAgregar.setEnabled(false);

    }

}



class AgregarElemento implements ActionListener {
	JTextField objetoNuevoEnt;
	List objetoList;
	JButton objetoBotQuita, objetoBotVacia;

	AgregarElemento(JTextField objetoNewEvent,List objetoLista, JButton objetoBotonVaciaEvent, JButton objetoBotQuitar ){
		objetoList = objetoLista;
		objetoNuevoEnt = objetoNewEvent;
		objetoBotVacia = objetoBotonVaciaEvent;
		objetoBotQuita = objetoBotQuitar;
	}
	public void actionPerformed( ActionEvent evt ) {
		
		if (objetoNuevoEnt.getText().length() != 0){
			objetoList.add(objetoNuevoEnt.getText());
			
			if (!objetoBotVacia.isEnabled() && objetoList.getItemCount() > 0){
				objetoBotVacia.setEnabled(true);	
			}
		}
		else 
			JOptionPane.showMessageDialog(null, "Error! introduzca un elemento, gracias.");
	}
}


class EliminarElementoLista implements ActionListener {
	
	
	List objetoLista;
	JButton obejtoBotonEliminar, objetoBotonVaciar;

	EliminarElementoLista(List objetoListaEvent, JButton botVaciarEvent, JButton botQuitaEvent){
		
		
		objetoLista = objetoListaEvent;
		objetoBotonVaciar = botVaciarEvent;
		obejtoBotonEliminar = botQuitaEvent;
	}
	public void actionPerformed( ActionEvent evt ) {
		
		int posicionLista = objetoLista.getSelectedIndex(); 
		
		if (posicionLista >= 0){ 
			objetoLista.remove(posicionLista);
			
			obejtoBotonEliminar.setEnabled(false);
			
		}
		else 
			JOptionPane.showMessageDialog(null, "Error! seleccione un elemento de la Lista, gracias");
		
		if (objetoBotonVaciar.isEnabled() && objetoLista.getItemCount() == 0){
			
			
			objetoBotonVaciar.setEnabled(false);	
		}
	}
}

class VerElementosSelec implements ActionListener {
	Dialog objetoDialog;
	List objetoLista;
        JTextArea objetoTextBoxList;
	VerElementosSelec(Dialog objetoDialogEvent, List objetoLista2, JTextArea textoBoxMultip){
		objetoDialog = objetoDialogEvent;
		objetoLista = objetoLista2;
        objetoTextBoxList = textoBoxMultip;
	}
	public void actionPerformed( ActionEvent evt ) {
		
		String tituloElemtSelec="Elementos seleccionados: \n";
		
		int i;
		
		
		
		for(i=0;i<=objetoLista.getSelectedObjects().length-1;i++){
			tituloElemtSelec+="                                   "+(String) objetoLista.getSelectedObjects()[i]+"\n";
		}
		 
               
                objetoTextBoxList.setText("");
                objetoTextBoxList.setFont(new Font("SansSerif",Font.BOLD,18));
                objetoTextBoxList.append(tituloElemtSelec);
                System.out.println(tituloElemtSelec);
                objetoDialog.setVisible( false );
	}

}

class VisualizarSeleccionLista implements ItemListener {
	List objetoListaVisual;
	JTextField objetoListaTextF;
	JButton objetoBotLista;
	
	VisualizarSeleccionLista(List obejtoLista, JTextField objetoSelList, JButton botQuitaEvent){
		objetoListaVisual = obejtoLista;
		objetoListaTextF = objetoSelList;
		objetoBotLista = botQuitaEvent;
	}
	
	public void itemStateChanged(ItemEvent e){
		
		
		if (objetoListaVisual.getSelectedItem() != null)
			objetoBotLista.setEnabled(true);
		else
			objetoBotLista.setEnabled(false);
		objetoListaTextF.setText(objetoListaVisual.getSelectedItem());
	}
}


class EliminarTodoLista implements ActionListener {
	List objetoLista;
	JButton objetoBotVacia;
	JButton objetoBotQuita;

	EliminarTodoLista(List obejtoLista,  JButton botVaciaEvent, JButton botQuitaEvent){
		objetoLista = obejtoLista;
		objetoBotVacia = botVaciaEvent;
		objetoBotQuita = botQuitaEvent;
	}
	public void actionPerformed( ActionEvent evt ) {
		
		
		objetoLista.removeAll();
		
		objetoBotVacia.setEnabled(false);	
		objetoBotQuita.setEnabled(false);
	}
}

// FIN DE PROGRAMA.