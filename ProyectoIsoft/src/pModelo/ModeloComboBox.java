package pModelo;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

/**
 * Clase que se encarga de manejar un comboBox para que se pueda escribir un item a buscar y el comboBox te autocomplete
 * con items que coinciden con lo escrito hasta el momento
 * @author Francisco , Daniel , Ruben , Iban
 */
public class ModeloComboBox extends PlainDocument {
    JComboBox comboBox;
    ComboBoxModel model;
    JTextComponent editor;
    // banderas para indicar si setSelectedItem ha sido llamado
    boolean estaSeleccionada=false;
    boolean esconderPopupAlPerderFocus;
    boolean presionarRetroceso=false;
    boolean presionarRetrocesoEnSeleccion;
    
    /**
     * Constructor para iniciar el ModeloComboBox
     * @param comboBox la cual va ha recibir la propiedad de autocompletado
     */
    public ModeloComboBox(final JComboBox comboBox) {
        this.comboBox = comboBox;
        model = comboBox.getModel();
        editor = (JTextComponent) comboBox.getEditor().getEditorComponent();
        editor.setDocument(this);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!estaSeleccionada) highlightCompletedText(0);
            }
        });
        editor.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (comboBox.isDisplayable()) comboBox.setPopupVisible(true);
                presionarRetroceso=false;
                switch (e.getKeyCode()) {
                    // determina si la tecla presionada ha sido retroceso (necesario para el metodo borrar)
                    case KeyEvent.VK_BACK_SPACE : presionarRetroceso=true;
                                                  presionarRetrocesoEnSeleccion=editor.getSelectionStart()!=editor.getSelectionEnd();
                                                  break;
                }
            }
        });
        esconderPopupAlPerderFocus=System.getProperty("java.version").startsWith("1.5");
        // Mostrar el texto cuando gana focus
        editor.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                highlightCompletedText(0);
            }
            public void focusLost(FocusEvent e) {
                // Esconder texto cuando pierde focus
                if (esconderPopupAlPerderFocus) comboBox.setPopupVisible(false);
            }
        });
        // Recoge el objeto seleccionado
        Object selected = comboBox.getSelectedItem();
        if (selected!=null) setText(selected.toString());
        highlightCompletedText(0);
    }
    
    /**
     * Permite borrar letras del comboBox sin que den errores graves de seleccion de objetos en la comboBox
     */
    public void remove(int offs, int len) throws BadLocationException {
        // Retorna cuando un objeto es recogido/seleccionado
        if (estaSeleccionada) return;
        if (presionarRetroceso) {
            // El usuario ha pulsado retroceso
            // La ultima seleccion seguira activa
            if (offs>0) {
                if (presionarRetrocesoEnSeleccion) offs--;
            } else {
                // El usuario ha presionado retroceso con el cursor posicionado en el inicio
                comboBox.getToolkit().beep(); 
            }
            highlightCompletedText(offs);
        } else {
            super.remove(offs, len);
        }
    }
    
    /**
     * Permite insertar el texto correspondiente en el comboBox
     */
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // Retorna cuando un objeto es recogido/seleccionado
        if (estaSeleccionada) return;
        // Inserta la frase en el documento
        super.insertString(offs, str, a);
        // Recoge el objeto que coincide
        Object item = lookupItem(getText(0, getLength()));
        
        boolean listContainsSelectedItem = true;
        if (item == null) {
           // No se encuentra una seleccion valida, se mantiene la seleccion anterior
           item=getText(0, getLength());
           listContainsSelectedItem=false;
        }else{
        setSelectedItem(item);
        setText(item.toString());
        // Se seleciona la parte entera
        if (listContainsSelectedItem) highlightCompletedText(offs+str.length());
        }
    }
    
    private void setText(String text) {
        try {
            // Se borra todo el texto y se introduce otra vez
            super.remove(0, getLength());
            super.insertString(0, text, null);
        } catch (BadLocationException e) {
            throw new RuntimeException(e.toString());
        }
    }
    
    private void highlightCompletedText(int start) {
        editor.setCaretPosition(getLength());
        editor.moveCaretPosition(start);
    }
    
    /**
     * Selecciona el item pasado como parametro
     * @param item
     */
    private void setSelectedItem(Object item) {
        estaSeleccionada = true;
        model.setSelectedItem(item);
        estaSeleccionada = false;
    }
    
    /**
     * Se encarga de intentar buscar un item que coincida con lo escrito en el comboBox
     * @param patron
     * @return retorna el objeto seleccionado
     */
    private Object lookupItem(String patron) {
        Object selectedItem = model.getSelectedItem();
        // solo busca por un diferente item, si la seleccion no coincide
        if (selectedItem != null && startsWithIgnoreCase(selectedItem.toString(), patron)) {
            return selectedItem;
        } else {
            // itera sobre todos los items
            for (int i=0, n=model.getSize(); i < n; i++) {
                Object currentItem = model.getElementAt(i);
                // el elemento actual se inicia con el patron?
                if (startsWithIgnoreCase(currentItem.toString(), patron)) {
                    return currentItem;
                }
            }
        }
        // no hay items que coincidan con el patron, se retorna null
        return null;
    }
    
    /**
     *  comprueba si str1 coincide con str2
     * @param str1
     * @param str2
     * @return coincide
     */
    private boolean startsWithIgnoreCase(String str1, String str2) {
        return str1.toUpperCase().startsWith(str2.toUpperCase());
    }
}