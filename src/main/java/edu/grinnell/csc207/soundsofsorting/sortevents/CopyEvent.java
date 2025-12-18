package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T>{
    public List<Integer> indices = new ArrayList<Integer>();
    public T value;

    public CopyEvent(T value, List<Integer> indices){
        this.value = value;
        this.indices = indices;
    }


    @Override
    //Used in Merge Sort when comparing the two values and putting them into the final arr.
    public void apply(T[] arr) {
        arr[indices.get(0)] = value;
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
