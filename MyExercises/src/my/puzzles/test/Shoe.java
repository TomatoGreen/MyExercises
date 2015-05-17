package my.puzzles.test;

public class Shoe implements Comparable<Shoe>{
	 private int size;
	 private String description;
	 
	 @Override
	 public int compareTo(Shoe shoe) {
	  int comp = 0;
	  
	  if (this.size == shoe.size) {
	   comp = this.description.compareTo(shoe.description);
	  }
	  else {
	   comp = shoe.size - this.size;
	  }
	   
	  return comp;
	 }
}
