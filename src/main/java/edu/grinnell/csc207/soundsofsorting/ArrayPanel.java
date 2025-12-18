package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

//paint components built by me

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
        int barWidth = width/notes.scale.size();
        int idx = 0;
        if(notes.getNotes().length == 17){
            for(int i = 0, j = 0; j < notes.getNotes().length; i+= barWidth, j++){
                if(notes.isHighlighted(j)){
                    
                    for(int z = j+1; z < notes.getNotes().length; z++){
                        if(notes.isHighlighted(z)){
                            idx = z;
                            notes.clearAllHighlighted();
                        }
                    }
                    // g.drawRect(,0, barWidth, ControlPanel.bMinorPentatonicValues[(int)(notes.getNotes()[idx])]};
                    g.drawRect(i, 0, barWidth, ControlPanel.bMinorPentatonicValues[(int)(notes.getNotes()[idx])]);
  
                }else{
                    g.drawRect(i, 0, barWidth, ControlPanel.bMinorPentatonicValues[(int)(notes.getNotes()[j])]);
                }
            }
        }else{
            for(int i = 0, j = 0; j < notes.getNotes().length; i+= barWidth, j++){
                g.drawRect(i, 0, barWidth, ControlPanel.chromaticValues[(int)(notes.getNotes()[j])]);
            }
        }
        
            
    }
}