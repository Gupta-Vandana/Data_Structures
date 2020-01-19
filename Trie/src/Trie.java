import java.util.HashMap;

public class Trie {
	
	private Node root;
    private class Node {
    	Character ch;
    	boolean eow;
    	HashMap<Character, Node> children=new HashMap<>();
    
    Node(Character ch){
    	this.ch=ch;
    	this.eow=false;
    	this.children=new HashMap<>();
    }
    }
    
    private int numWords ;
    private int numNodes;
    public Trie() {
		// TODO Auto-generated constructor stub
    	this.root=new Node('*');
    	numNodes++;
	}
    public void addWord(String str){
    	this.addWord(this.root, str);
    }
    private void addWord(Node parent,String str){
    	if (str.length()==0){
    		parent.eow=true;
    		this.numWords++;
    		return;
    		
    	}
    	
    	char ch1=str.charAt(0);
    	String ros=str.substring(1);
        Node child= parent.children.get(ch1);
        if(child==null){
        	numNodes++;
        	child =new Node(ch1);
        	parent.children.put(ch1, child);
        	
        }
        
        	this.addWord(child,ros);
    }
    public boolean SearchWord(String str){
    	return this.SearchWord(this.root, str);
    }
    private boolean SearchWord(Node parent,String str){
    	if (str.length()==0){
    		
    		return parent.eow;
    		
    	}
    	
    	char ch1=str.charAt(0);
    	String ros=str.substring(1);
        Node child= parent.children.get(ch1);
        if(child==null){
        	return false;
        }
        return SearchWord(child,ros);
       }
    public void RemoveWord(String str){
    	 this.RemoveWord(this.root, str);
    }
    private void RemoveWord(Node parent,String str){
    	if (str.length()==0){
    		parent.eow=false;
    		this.numWords--;
    		return;
    		
    	}
    	
    	char ch1=str.charAt(0);
    	String ros=str.substring(1);
        Node child= parent.children.get(ch1);
        if(child==null){
        	return ;
        }
         RemoveWord(child,ros);
         if(child.eow==false && child.children.size()==0){
        	 parent.children.remove(ch1);
        	 this.numNodes--;
         }
        
     }
    public void display(){
    	display(this.root," ");
    }
    public void display(Node node, String osf){
    	if(node.eow){
    		System.out.println(osf);
    	}
    }
    
}
