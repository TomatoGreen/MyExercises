package my.puzzles.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JPMorganQ1 {

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringTokenizer st = null;
		int numberOfDays = -1;
		ArrayList<Integer> gainings = null;
		int maximum = 0, temp = 0;

		try {
			while ((s = in.readLine()) != null) {
				st = new StringTokenizer(s, " ");
				while (st.hasMoreElements()) {
					if (numberOfDays == -1) {
						numberOfDays = Integer.parseInt(st.nextElement()
								.toString());
						gainings = new ArrayList<Integer>();
					} else {
						gainings.add(Integer.parseInt(st.nextElement()
								.toString()));
					}
				}
				if (gainings != null) {
					for (int i = 0; i < gainings.size() - 1; i++) {
						temp = gainings.get(i);
						for (int j = i + 1; j < gainings.size(); j++) {
							temp += gainings.get(j);
							if (maximum < temp) {
								maximum = temp;
							}
						}
					}
				}
				System.out.println(maximum + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
