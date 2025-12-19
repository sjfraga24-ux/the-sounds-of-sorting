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
        int[] idxs = new int[3];
        int highLightCount = 0;
        int max = 390; 
        g.clearRect(0, 0, width, max);
        if(notes.getNotes().length == 17){
            for(int i = 0, j = 0; j < notes.getNotes().length; i+= barWidth, j++){
                if(notes.isHighlighted(j)){
                    if(highLightCount == 1){
                        idxs[2] = j;
                        g.drawRect(i, 0, barWidth, ControlPanel.bMinorPentatonicValues[(int)(notes.getNotes()[idxs[0]])]);
                        g.drawRect(idxs[1], 0, barWidth, ControlPanel.bMinorPentatonicValues[(int)(notes.getNotes()[idxs[2]])]);
                        highLightCount=0;
                        notes.getNotes()[idxs[0]] = idxs[2];
                        notes.getNotes()[idxs[2]] = idxs[0];

                    }else{
                        idxs[0] = j;
                        idxs[1] = i;
                        highLightCount++;
                    }
                }else{
                    if(idxs[2] == 0){
                        g.drawRect(i, 0, barWidth, ControlPanel.bMinorPentatonicValues[(int)(notes.getNotes()[j])]);
                    }else{
                        if(j != idxs[0] && j!=idxs[2]){
                            g.drawRect(i, 0, barWidth, ControlPanel.bMinorPentatonicValues[(int)(notes.getNotes()[j])]);
                        }
                    }
                    
                }
            }
        }else{
             for(int i = 0, j = 0; j < notes.getNotes().length; i+= barWidth, j++){
                if(notes.isHighlighted(j)){
                    if(highLightCount == 1){
                        idxs[2] = j;
                        g.drawRect(i, 0, barWidth, ControlPanel.chromaticValues[(int)(notes.getNotes()[idxs[0]])]);
                        g.drawRect(idxs[1], 0, barWidth, ControlPanel.chromaticValues[(int)(notes.getNotes()[idxs[2]])]);
                        highLightCount=0;
                        notes.getNotes()[idxs[0]] = idxs[2];
                        notes.getNotes()[idxs[2]] = idxs[0];

                    }else{
                        idxs[0] = j;
                        idxs[1] = i;
                        highLightCount++;
                    }
                }else{
                    if(idxs[2] == 0){
                        g.drawRect(i, 0, barWidth, ControlPanel.chromaticValues[(int)(notes.getNotes()[j])]);
                    }else{
                        if(j != idxs[0] && j!=idxs[2]){
                            g.drawRect(i, 0, barWidth, ControlPanel.chromaticValues[(int)(notes.getNotes()[j])]);
                        }
                    }
                    
                }
            }
        }
        
            
    }
}