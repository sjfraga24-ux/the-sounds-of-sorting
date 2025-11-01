package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
    int width;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.width = width;
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        for(int i = 0; i< width; i+= (width/notes.scale.length)){
            g.drawRect(0, i, 6, (int)notes.getNotes()[i]);
        }
            
    }
}