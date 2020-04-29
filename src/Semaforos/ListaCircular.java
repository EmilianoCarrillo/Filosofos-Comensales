package Semaforos;
import java.util.ArrayList;

public class ListaCircular<E> extends ArrayList<E>{
	
    private static final long serialVersionUID = 1L;

    public E get(int index){
        if (index < 0)
            index = size()-1;
        else if (index >= size())
            index = 0;

        return super.get(index);
    }
    
    public E set(int index, E element){
    	if (index < 0)
            index = size()-1;
        else if (index >= size())
            index = 0;
    	
		return super.set(index, element);
    }
    
}