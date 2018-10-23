package collections;

import collections.IRBTree;
import collections.RBNode;
import collections.RBTree;

public class RBTree<K,V> implements IRBTree<K,V> {
	
	private RBNode<K,V> root;
	private RBNode<K,V> nil;
	
    public RBTree() {
		nil=new RBNode<K,V>(null, null,RBNode.BLACK);
		root=nil;
	}
    
    
    @Override
	public RBNode<K, V> getRoot() {
		return root;
	}


   @Override
	public void setRoot(RBNode<K, V> root) {
		this.root = root;
	}

    
    public void leftRotate(RBNode<K,V> x) {
    	RBNode<K,V> y = x.getRight();
		x.setRight(y.getLeft());
		y.getLeft().setFather(x);
		y.setFather(x.getFather());
		if(x.getFather()==nil) {
			setRoot(y);
		}
		else {
			if(x==x.getFather().getLeft()) {
				x.getFather().setLeft(y);
				
			}
			else {
				x.getFather().setRight(y);
			}
		}
		
		y.setLeft(x);
		x.setFather(y);
    }
    public void rightRotate(RBNode<K,V> x) {
    	RBNode<K,V> y = x.getLeft();
		x.setLeft(y.getRight());
		y.getRight().setFather(x);
		y.setFather(x.getFather());
		if(x.getFather()==nil) {
			setRoot(y);
		}
		else {
			if(x==x.getFather().getRight()) {
				x.getFather().setRight(y);
				
			}
			else {
				x.getFather().setLeft(y);
			}
		}
		
		y.setRight(x);
		x.setFather(y);
    }
	public void leftRotatemio(RBNode<K,V> x) {
		 
		RBNode<K,V> y = x.getRight();
		x.setRight(y.getLeft());
		if(y.getLeft()!=nil) {
			y.getLeft().setFather(x);
		}
		y.setFather(x.getFather());
		if(x.getFather()==nil) {
			setRoot(y);
		}else if(x==x.getFather().getLeft()) {
			x.getFather().setLeft(y);
		}else {
			x.getFather().setRight(y);
		}
		y.setLeft(x);
		x.setFather(y);
	}
	
	public void rightRotatemio(RBNode<K,V> y) {
		RBNode<K,V> x = y.getLeft();
		y.setLeft(x.getRight());//
		if(x.getRight()!=nil) {
			x.getRight().setFather(y);
		}
		x.setFather(y.getFather());
		if(y.getFather()==nil) {
			setRoot(x);
		}else if(y==y.getFather().getRight()) {
			y.getFather().setRight(x);
		}else {
			y.getFather().setLeft(x);
		}
		x.setRight(y);
		y.setFather(x);
	}
	public RBNode<K,V> RBSearch(RBNode<K,V> searched, K k) {
		
		if((searched==nil)||((double)k==(double)searched.getKey())){
		
			return searched;
		}if((double)k<(double)searched.getKey()) {
			return RBSearch(searched.getLeft(),k);
		}
		else return RBSearch(searched.getRight(),k);
		}
		
	
	public RBNode<K,V> RBMaximum(RBNode<K,V> maximum) {
		while(maximum.getRight()!=nil) {
			maximum=maximum.getRight();
		}
		return maximum;
	}
	
	public RBNode<K,V> RBMinimum(RBNode<K,V> minimum) {
		while(minimum.getLeft()!=nil) {
			minimum=minimum.getLeft();
		}
		return minimum;
	}
	public RBNode<K,V> RBSuccessor(RBNode<K,V> successor){
		RBNode<K,V> y=nil;
		if(successor.getRight()!=nil) {
			return RBMinimum(successor.getRight());
			
		}
		y=successor.getFather();
		
		while((y!=nil)&&(successor==y.getRight())) {
			successor=y;
			y=y.getFather();
		}
		return y;
	}
	
        public RBNode<K,V> RBPredecessor(RBNode<K,V> predecessor){
		
		if(predecessor.getLeft()!=nil) {
			return RBMaximum(predecessor.getLeft());
			
		}
		RBNode<K,V> y=predecessor.getFather();
		while((y!=nil)&&(predecessor==y.getLeft())) {
			predecessor=y;
			y=y.getFather();
		}
		return y;
	}

    	public void RBInsert(K key, V value) {
    	RBNode<K,V> newNode= new RBNode<K,V>(key, value, RBNode.RED);
		RBNode<K,V> y=nil;
		RBNode<K,V> x= root;
		while(x!=nil) {
			y=x;
			if(newNode.compareTo(x)<0) {
				x=x.getLeft();
				
			}else x=x.getRight();
		}
		
		newNode.setFather(y);
		if(y==nil) {
			setRoot(newNode);
			
			
		}else if(newNode.compareTo(y)<0) {
			y.setLeft(newNode);
			
		}else y.setRight(newNode);
		newNode.setLeft(nil);
		newNode.setRight(nil);
		newNode.setColor(RBNode.RED);
		RBInsertFixUp(newNode);
		
		}
		
	
    public void RBInsertFixUp(RBNode<K,V> newNode ) {
		while(newNode.getFather().getColor()==RBNode.RED) {
			if(newNode.getFather()==newNode.getFather().getFather().getLeft()) {
				RBNode<K,V> y=newNode.getFather().getFather().getRight();
				if(y.getColor()==RBNode.RED) {
				newNode.getFather().setColor(RBNode.BLACK);
				y.setColor(RBNode.BLACK);
				newNode.getFather().getFather().setColor(RBNode.RED);
				newNode=newNode.getFather().getFather();
			}
				else 
					{
					if(newNode==newNode.getFather().getRight()) {
						newNode=newNode.getFather();
						leftRotate(newNode);
					}
				newNode.getFather().setColor(RBNode.BLACK);
				newNode.getFather().getFather().setColor(RBNode.RED);
				rightRotate(newNode.getFather().getFather());
				}
				
			}
			else {
				RBNode<K,V> y=newNode.getFather().getFather().getLeft();
				if(y.getColor()==RBNode.RED) {
				newNode.getFather().setColor(RBNode.BLACK);
				y.setColor(RBNode.BLACK);
				newNode.getFather().getFather().setColor(RBNode.RED);
				newNode=newNode.getFather().getFather();
			}
				else 
					{
					if(newNode==newNode.getFather().getLeft()) {
					newNode=newNode.getFather();
					rightRotate(newNode);
					
				}
				newNode.getFather().setColor(RBNode.BLACK);
				newNode.getFather().getFather().setColor(RBNode.RED);
				leftRotate(newNode.getFather().getFather());
			}
			}
		}
		root.setColor(RBNode.BLACK);
	}
    
    @Override
    public RBNode<K,V> RBDelete(K key ) { 
    	RBNode<K,V> deleted= RBSearch(root, key);
    	RBNode<K,V> x = nil; 
    	RBNode<K,V> y = nil; 
		if((deleted.getLeft()==nil)||deleted.getRight()==nil) {
			y = deleted; 
		}
		else
			{
			y= RBPredecessor(deleted);
			}
		if(y.getLeft()!=nil) {
			x=y.getLeft();	
		}else {
			x=y.getRight();
		}
		x.setFather(y.getFather());
		if(y.getFather()==nil) {
			setRoot(x);
		}else {
			if(y==y.getFather().getLeft()) {
			y.getFather().setLeft(x);
			
		    }else {
			y.getFather().setRight(x);
		}
		}
		if(y!=deleted) {
			deleted.setKey(y.getKey());
			deleted.setValue(y.getValue());
			}
		
		if(y.getColor()==RBNode.BLACK) RBDeleteFixUp(x);
		return y;
	}
    public void RBDeleteFixUp(RBNode<K,V> x ) {
		while(x!=root && x.getColor()==RBNode.BLACK) {
			
			//Rama Izquierda
			if(x==x.getFather().getLeft()) {
				RBNode<K,V> w= x.getFather().getRight();
				if(w.getColor()==RBNode.RED) {
					w.setColor(RBNode.BLACK);
					w.getFather().setColor(RBNode.RED);
					leftRotate(x.getFather());
					w=x.getFather().getRight();
				}
	
				if(w.getLeft().getColor()==RBNode.BLACK && w.getRight().getColor()==RBNode.BLACK) {
					w.setColor(RBNode.RED);
					x=x.getFather();
				}
				else {
					if( w.getRight().getColor()==RBNode.BLACK ) {
						w.getLeft().setColor(RBNode.BLACK);
						w.setColor(RBNode.RED);
						rightRotate(w);
						w=x.getFather().getRight();
				}
					w.setColor(x.getFather().getColor());
					x.getFather().setColor(RBNode.BLACK);
					w.getRight().setColor(RBNode.BLACK);
					leftRotate(x.getFather());
					x=root;
				}
				
					
			}
			else if(x==x.getFather().getRight()){
				
				RBNode<K,V> w= x.getFather().getLeft();
				if(w.getColor()==RBNode.RED) {
					w.setColor(RBNode.BLACK);
					w.getFather().setColor(RBNode.RED);
					rightRotate(x.getFather());
					w=x.getFather().getLeft();
				}
	
				if(w.getRight().getColor()==RBNode.BLACK && w.getLeft().getColor()==RBNode.BLACK) {
					w.setColor(RBNode.RED);
					x=x.getFather();
				}
				else  {
					if( w.getLeft().getColor()==RBNode.BLACK ) {
						w.getRight().setColor(RBNode.BLACK);
						w.setColor(RBNode.RED);
						leftRotate(w);
						w=x.getFather().getLeft();
				}
					w.setColor(x.getFather().getColor());
					x.getFather().setColor(RBNode.BLACK);
					w.getLeft().setColor(RBNode.BLACK);
					rightRotate(x.getFather());
					x=root;
				}
				
					
			}
				
			}
		x.setColor(RBNode.BLACK);
		}
	

    
    public void preorder(RBNode<K,V> root) {
    	if(root!=nil) {
    		System.out.println(root.getKey()+" "+root.getColor());
    		preorder(root.getLeft());
    		preorder(root.getRight());
    	}
    }
	public static void main(String[] args) {
		RBTree<Double,String> rb = new RBTree<Double,String>();
		rb.RBInsert(8.0, "player1");
		rb.RBInsert(7.0, "player2");
		rb.RBInsert(12.0, "player3");
		rb.RBInsert(6.0, "player4");
		rb.RBInsert(7.5, "player5");
		rb.RBInsert(10.0, "player6");
		rb.RBInsert(14.0, "player7");
		rb.RBInsert(13.0, "player8");
		rb.RBInsert(15.0, "player9");
//		rb.RBInsert(100.0, "player1");
//		rb.RBInsert(92.0, "player2");
//		rb.RBInsert(93.0, "player3");
//		rb.RBInsert(105.0, "player4");
//		rb.RBInsert(102.0, "player5");
//		rb.RBInsert(91.0, "player6");
//		
		//rb.RBDelete(102.0);
		//rb.preorder(rb.getRoot());
	   System.out.println(rb.RBSearch(rb.getRoot(),13.0).getValue());
		System.out.println(rb.getRoot().getKey());
		System.out.println(rb.getRoot().getLeft().getKey());
		System.out.println(rb.getRoot().getRight().getKey());
		System.out.println(rb.getRoot().getLeft().getLeft().getKey());
		System.out.println(rb.getRoot().getLeft().getRight().getKey());
		System.out.println(rb.getRoot().getRight().getLeft().getKey());
		System.out.println(rb.getRoot().getRight().getLeft().getRight().getKey());
		System.out.println(rb.getRoot().getRight().getLeft().getLeft().getKey());
		System.out.println(rb.getRoot().getRight().getRight().getKey());
		System.out.println(rb.getRoot().getRight().getRight().getLeft().getKey());
//		
		
//		System.out.println();
//		System.out.println(rb.getRoot().getColor());
//		System.out.println(rb.getRoot().getLeft().getColor());
//		System.out.println(rb.getRoot().getRight().getColor());
//		System.out.println(rb.getRoot().getRight().getRight().getColor());
//		rb.RBDelete(93);
//		System.out.println(rb.RBDelete(102).getValue());
//		System.out.println(rb.getRoot().getKey());
//		System.out.println(rb.getRoot().getLeft().getKey());
//		System.out.println(rb.getRoot().getRight().getKey());
//		System.out.println(rb.getRoot().getRight().getRight().getKey());
//		
//		System.out.println(rb.getRoot().getLeft().getLeft().getKey());
//		System.out.println();
//		System.out.println(rb.getRoot().getColor());
//		System.out.println(rb.getRoot().getLeft().getColor());
//		System.out.println(rb.getRoot().getRight().getColor());
//		System.out.println(rb.getRoot().getRight().getRight().getColor());
//		System.out.println(rb.getRoot().getLeft().getLeft().getColor());
//		
//	}
	
	


	}

}

