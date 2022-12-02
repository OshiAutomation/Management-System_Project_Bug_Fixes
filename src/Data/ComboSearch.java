/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author MN COM
 */
public class ComboSearch {

    private static ArrayList<String> stringArray;
    private static JTextField textfield;

    public static void getSearchableComboBox(final JComboBox comboBox, boolean mustSort, final String message) {

        stringArray = new ArrayList<String>();
        final int count = comboBox.getItemCount();
        for (int i = 0; i < count; i++) {
            stringArray.add(comboBox.getItemAt(i).toString());
        }
        if (mustSort) {
            Collections.sort(stringArray);
        }
        comboBox.setLightWeightPopupEnabled(true);
        comboBox.setEditable(true);

        textfield = (JTextField) comboBox.getEditor().getEditorComponent();
        textfield.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {

                int keyCode = evt.getKeyCode();
                if (!(keyCode == KeyEvent.VK_ESCAPE || keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN)) {

                    String text = textfield.getText();
                    int caret = textfield.getCaretPosition();
                    comboBox.hidePopup();
                    comboBox.removeAllItems();
                    for (int i = 0; i < stringArray.size(); i++) {

                        if (stringArray.get(i).toUpperCase().startsWith(text.substring(0, caret).toUpperCase())) {
                            comboBox.addItem(stringArray.get(i));
                        }
                    }
                    comboBox.showPopup();
                    if (comboBox.getItemCount() == 0) {
                        comboBox.addItem(message);
                    }
                    textfield.setText(text);
                    textfield.setCaretPosition(caret);
                }
            }
        });

    }
}
