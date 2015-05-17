package my.puzzles.test;

public class Box {
    private double width;
    private double length;
    private double height;
    private static double DEFAULT_HEIGHT;

    public Box(double width, double length, double height) {
    	super();
            this.width = width;
            this.length = length;
            this.height = height;
    }

    public Box(double width, double length) {
            this.width = width;
            this.length = length;
            this.height = DEFAULT_HEIGHT;
    } 
	public void swap (int x, int y) {
        int temp = x;
        x = y;
        y = temp;
	}
	   @Override

	    public boolean equals(Object o) {

	        if (this == o) return false;

	        if (o == null || getClass() != o.getClass()) return false;

	 

	        Box box = (Box) o;

	 

	        if (height != box.height) return false;

	        if (length != box.length) return false;

	        if (width != box.width) return false;

	 

	        return true;

	    }
}