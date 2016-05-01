package algodat;

public class KleineHash {
	
		String[] array;

	    int count = 0;
	    
	    // Neue Methode eingefügt
	    public int posBerechnen(String value){
	        int pos = Math.abs(value.hashCode() % array.length);
	        return pos;
	    }
		
		/**
		 * Tries to insert a String into the hash.
		 * @return true, if the String could be added
		 */
		public boolean add(String value){
			if(count != array.length){
	        	int pos = posBerechnen(value);
	        	for(int i = 0;pos <= array.length-1;i++){
	            	if(array[pos] == null){
	                	array[pos] = value;
	                	count++;
	                	return true;
	            	}else{
	            		pos = i;
	        		}
	        	}
	    	}
	    	return false;
		}
		
		/**
		 * Removes the given String from the hash
		 * @return true, if the hash contained the String
		 */
		public boolean remove(String value){
	        
	        if(value == null){
	            return false;
	        }
	        
	        for(int i = posBerechnen(value); i < array.length-1; i++){
	            if(value.equals(array[i])){
	                array[i] = null;
	                count--;
	                return true;
	            }
	            
	        }
	            return false;
		}
		
		/**
		 * Returns true, if the hash contains the given String
		 */
		public boolean contains(String value){
	        
	        if(value != null){
	        for(int i = posBerechnen(value); i < array.length-1; i++){
	            if(value.equals(array[i])){
	                return true;
	            }
	        }
	    }
	        return false;
		}

		
		/**
		 * This method return the array in which the strings are stored.
		 * DO NOT MODIFY OR REMOVE THIS METHOD. Our tests rely on it.
		 */
		public String[] getArray(){
			return array;
		}
		
		/**
		 * Constructor to initialize the hash with a given capacity
		 * DO NOT MODIFY OR REMOVE THIS METHOD. Our tests rely on it.
		 */
		public KleineHash(int capacity){
			array = new String[capacity];
		}

}
