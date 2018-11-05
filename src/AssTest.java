
public class AssTest {
	public static void main(String [] args) {
	}
	public void speech(String username) {
		try {
			String s = "python F:/Git stuff/Personal-Planner-Java/src/test.py "+username;
			Process p = Runtime.getRuntime().exec(s);
			System.out.println(s);
		}
		catch(Exception e) {System.out.println(e);}
	}
}