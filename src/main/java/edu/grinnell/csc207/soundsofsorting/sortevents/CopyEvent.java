package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T>{
    public List<Integer> indices;
    public T value;

    @Override
    public void apply(T[] arr) {
         for(int i = 0; i < indices.size(); i++){
            arr[indices.get(i)] = value;
        }
        
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return indices;
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
}
