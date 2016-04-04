public class MyDeque<T>{

    T[]data;
    int start,end; // start and end indices
    int size;
    
    public Deque{
	data = new T[10];
	start = 0;
	end = 0;
	size = 0;
    }

    // 0b. You need a private method to grow the array and copy over the values. 
    private void grow(){
	T[]hold = new T[size*2];
	for(int i = 0; i < size; i++){
	    hold[i] = data[start+i];
	}
	data = hold;
	start = 0;
	end = size;
	size *= 2;
    }

    private boolean isFull(){
	if(start == end){
	    return false;
	}else if(end > start){
	    if(start > 0 || end < size){
		return true;
	    }else{
		return false;
	    }
	}else{
	    return (start-end > 1);
	}
    }
        

    
}
