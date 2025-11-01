package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T extends Comparable<? super T>> implements SortEvent<T>{
    public List<Integer> indices;

    @Override
    public void apply(T[] arr) {
        for(int i = 0; i < indices.size(); i+=2){
            arr[indices.get(i)].compareTo(arr[indices.get(i+1)]);
        }
        
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return indices;
    }

    @Override
    public boolean isEmphasized() {
       return false;
    }
    
}
