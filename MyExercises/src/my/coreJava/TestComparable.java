package my.coreJava;

import java.util.Iterator;
import java.util.Map;

public class TestComparable {
	private Map<String, String> testMap = null;
	private String firstName;
	private String lastName;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int compareTo(Object t) {
		TestComparable toObject = null;
		if (t instanceof TestComparable)
			toObject = (TestComparable) t;
		else
			return -1;
		if (this.lastName.equals(toObject.getLastName()))
			return this.firstName.compareTo(toObject.getFirstName());
		else
			return this.lastName.compareTo(toObject.getLastName());
	}

	/**
	 * @return the testMap
	 */
	public Map<String, String> getTestMap() {
		return testMap;
	}

	/**
	 * @param testMap
	 *            the testMap to set
	 */
	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("TestBean [");

		if (testMap != null) {
			Iterator<String> testValues = testMap.keySet().iterator();
			String testValue = "";
			while (testValues.hasNext()) {
				testValue = testValues.next();
				buffer.append("testValue=");
				buffer.append(testMap.get(testValue));
				buffer.append(" ");
			}
		}
		buffer.append("]");
		return buffer.toString();
	}

}
