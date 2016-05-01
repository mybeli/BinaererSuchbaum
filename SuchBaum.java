package algodat;

public class SuchBaum {
	 public Node start = null;
	    public Node parent = null;
	    public Node current = null;

	    class Node{
	        public Node l_child = null;
	        public Node r_child = null;
	        int value;
	        
	        public void rekAdd(int v1){
	            
	                if(v1 > this.value){
	                    // v1 kleiner als Wert des jetzigen Knotens
	                    if(this.r_child != null){
	                        //existiert ein r_child?
	                        this.r_child.rekAdd(v1);
	                    }else{
	                        // wenn r_child nicht existiert, ist neuer Knoten = r_child
	                        Node n1 = new Node();
	                        n1.value = v1;
	                        this.r_child = n1;
	                    }
	                }
	                // analog zu oben
	                if(v1 < this.value){
	                    if(this.l_child != null){
	                        this.l_child.rekAdd(v1);
	                    }else{
	                        Node n1 = new Node();
	                        n1.value = v1;
	                        this.l_child = n1;
	                    }
	                }
	            
	        }
	    }
	    
	    
		/**
		 * Inserts the element into the tree
		 */
		public void add(int v1){
	    
	    
	        if(this.start != null){
	            // wenn der Baum bereits Elemente hat
	            start.rekAdd(v1);
	           }else{
	               //wenn der Baum noch keine Elemente hat
	               Node n1 = new Node();
	               n1.value = v1;
	               start = n1;
	        }
		}
	    
	    /**
	     * finds the Maximum value of a tree
	     */
	    public Node max_finder (Node tmp){
	        while (tmp.r_child != null){   
	            tmp = tmp.r_child;
	        }
	        return tmp;
	    }
	    
		/**
		 * Removes a single instance of the specified element from this tree.
		 * @return true if an element was removed
		 */
		public boolean remove(int v1){
	        if(start == null){
	            // Leerer Baum
	        return false;
	        }      
	        if(contains(v1) == false){
	            return false;
	        }

	        if((current.l_child == null) && (current.r_child == null)){
	            //wenn zu löschendes Element keine Kinder hat
	            if(parent.l_child == current){
	                // ist current das linke Kind vom parent?
	                parent.l_child = null;
	                current = null;
	                return true;
	            }if(parent.r_child == current){
	                // ist current das rechte Kind vom parent?
	                parent.r_child = null;
	                current = null;
	                return true;
	            }else{
	                return false;
	            }
	        }

	        if((current.l_child != null) && (current.r_child != null)){
	            // wenn zu löschendes Element 2 Kinder hat
	            Node max = max_finder(current);
	                if(parent.l_child == current){
	                    // Element ist linkes Kind
	                    parent.l_child = max;
	                    max.l_child = current.l_child;
	                    max.r_child = current.r_child;
	                    current = null;
	                    return true;
	                }if(parent.r_child == current){
	                    // element ist rechtes Kind
	                    parent.r_child = max;
	                    max.l_child = current.l_child;
	                    max.r_child = current.r_child;
	                    current = null;
	                    return true;
	                }else{
	                return false;
	                }
	            }
	            if((current.l_child != null) && (current.r_child == null)){
	                // wenn zu löschendes Element ein linkes Kind besitzt
	                if(parent.l_child == current){
	                    parent.l_child = current.l_child;
	                    current = null;
	                    return true;
	                }if(parent.r_child == current){
	                    parent.r_child = current.l_child;
	                    current = null;
	                    return true;
	                }else{
	                return false;
	                }
	            }
	            if((current.l_child == null) && (current.r_child != null)){
	                //wenn zu löschendes Element ein rechtes Kind besitzt
	                 if(parent.l_child == current){
	                    parent.l_child = current.r_child;
	                    current = null;
	                    return true;
	                }if(parent.r_child == current){
	                    parent.r_child = current.r_child;
	                    current = null;
	                    return true;
	                }else{   
	                return false;
	                }
	            }

	            return true;
	    }


		/**
		 * Returns true if this collection contains the specified element and false otherwise
		 */
	    public boolean contains(int element){
	        Node tmp = start;
	        
	        while (tmp != null){
	            if (element == tmp.value){
	                return true;
	            }
	            else if (element < tmp.value){
	                //parent und current werden für remove-Methode verändert
	                parent = tmp;
	                current = tmp.l_child;
	                tmp = tmp.l_child;

	            }
	            else{
	                parent = tmp;
	                current = tmp.r_child;
	                tmp = tmp.r_child;
	            }
	        }
	        return false;
	    }

		/**
		 * Returns the number of elements in this tree
		 */
		public int size(){
	        return(size2(start));
	    }
	    
	    private int size2(Node pointer) {
	            if (pointer== null) return(0);
	            else {
	                return(size2(pointer.l_child) + 1 + size2(pointer.r_child));
	            }
	    }

		/**
		 * Returns the elements in the tree as a String, according to an in-order traversal, separated by ";"
		 * Output format could for instance be '1;3;3;7'
		 */
	     public String inOrderTraversal(){
	     return rekInOrderTraversal(start);
	     }

	     public String rekInOrderTraversal(Node tmp){


	        String bla = "";
	        if(tmp != null){
	            bla = bla + rekInOrderTraversal(tmp.l_child) + tmp.value + ";" + rekInOrderTraversal(tmp.r_child);
	        }
	        return bla;
	     }

	     /**
	     * Returns the elements in the tree as a String, according to an pre-order traversal, separated by ";"
	     */
	    public String preOrderTraversal(){
	        return rekPreOrderTraversal(start);
	    }

	    public String rekPreOrderTraversal(Node tmp){
	        String bla = "";
	        if(tmp != null){
	        bla = bla + tmp.value + ";" + rekPreOrderTraversal(tmp.l_child) + rekPreOrderTraversal(tmp.r_child);
	        }
	        return bla;
	    }


}
