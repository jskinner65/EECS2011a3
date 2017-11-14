package eecs2011a3;

public interface Position <E> {
	// returns the stored element
	// throws exception if position is not valid
	E getElement() throws IllegalStateException; 
}
