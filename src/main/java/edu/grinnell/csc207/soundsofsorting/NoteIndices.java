package edu.grinnell.csc207.soundsofsorting;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    Integer[] scale;
    boolean playedNote;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        scale = new Integer[n];
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
       int rand;
       
       for(int i = 0; i< scale.length; i++){
        rand = (int) Math.random()*scale.length;
        swap(scale, i, rand);
       }
       Integer[] newScale = new Integer[n];
       System.arraycopy(scale, 0, newScale, 0, scale.length-1);
       scale = newScale;
    }   
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return scale;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        Scale.playNote(index, true);
        playedNote = true;
    }
    
    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        if(playedNote){
            return true;
        }
        return false;
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        playedNote = false;
    }
}
