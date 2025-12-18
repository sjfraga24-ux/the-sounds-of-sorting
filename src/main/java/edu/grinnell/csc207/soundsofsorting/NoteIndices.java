package edu.grinnell.csc207.soundsofsorting;

import java.util.ArrayList;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    int[] indicies;
    ArrayList<Boolean> playedNote = new ArrayList<>();
    Scale scale;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        indicies = new int[n];
        for(int i =0; i < n; i++){
            indicies[i]=i;
        }
        scale = new Scale(indicies);
    }

    /**
     * A function that swaps the position of two elements of an array
     * @param <T> : the type of the elements being swapped
     * @param arr : The array that holds the elements
     * @param i : The first element being swapped
     * @param j : The second element being swapped
     */
    public static <T> void swap(int[] indicies2, int i, int j) {
        int tmp = indicies2[i];
        indicies2[i] = indicies2[j];
        indicies2[j] = tmp;
    }

    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
       int rand;
       
        for(int i = 0; i< scale.size(); i++){
            rand = (int)( Math.random()*scale.size());
            swap(indicies, i, rand);
        }
        int[] newIndicies = new int[n];
        System.arraycopy(indicies, 0, newIndicies, 0, scale.size());
        for(int i = indicies.length; i < n; i++){
            newIndicies[i] = i;
        }
        indicies = newIndicies;
        while(playedNote.size() < n){
            playedNote.add(false);
        }
        scale = new Scale(newIndicies);
    }   
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() {
        Integer[] ret = new Integer[indicies.length];
        for(int i =0; i < indicies.length; i++){
            ret[i] = indicies[i];
        }
        return ret;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        playedNote.set(index, true);
    }
    
    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        if(playedNote.get(index)==true){
            return true;
        }
        return false;
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for(int i = 0; i < playedNote.size(); i++){
            playedNote.set(i, false);
        }
    }
}
