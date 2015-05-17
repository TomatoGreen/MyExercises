package my.puzzles.test;

import java.lang.reflect.Field;

class A {
    private final Character m_value = 'a';
    private Character t_value ='c';
    public String toString() { return "" + m_value; }

    public static void main(String[] args) {
        try {
            Field f = A.class.getDeclaredField("m_value");
            f.setAccessible(true);
            A a = new A();
            f.set(a, (char) 'b' );
            System.out.println(a);
        } catch (Exception e) {    
            e.printStackTrace();
        }
    }

	public Character getT_value() {
		return t_value;
	}

	public void setT_value(Character t_value) {
		this.t_value = t_value;
	}

	public Character getM_value() {
		return m_value;
	}
}
