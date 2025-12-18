package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T extends Comparable<? super T>> implements SortEvent<T>{
    public List<Integer> indices = new ArrayList<>();

    public CompareEvent(List<Integer> indices){
        this.indices = indices;
    }

    @Override
    public void apply(T[] arr) {}

    @Override
    public List<Integer> getAffectedIndices() {
        return indices;
    }

    @Override
    public boolean isEmphasized() {
       return false;
    }
    
}
