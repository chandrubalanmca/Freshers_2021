import java.util.List;
import java.util.Stack;

public class UndoManager {


	static Stack<String> undo = new Stack<String>();
	static Stack<String> redo = new Stack<String>();

	public void insertAction(String value) {
		undo.push(value);
		redo.clear();
		System.out.println(value + "added");
	}

	public void undo() {
		String value = (String) undo.peek();
		undo.pop();
		redo.push(value);
		System.out.println(value + "delete row");
	}

	void redo() {
		String value = (String) redo.peek();
		redo.pop();
		undo.push(value);
		System.out.println("reinserted row");
	}

	static void getData() {
		Stack<String> reverseOrder = new Stack<String>();

		while (undo.size() > 0) {
			reverseOrder.push(undo.peek());
			undo.pop();
		}
		while (reverseOrder.size() > 0) {

			System.out.println(reverseOrder.peek());
			undo.push(reverseOrder.peek());

			reverseOrder.pop();
		}

		System.out.println();
	}

	void userAction(List<String> Q) {
		int N = Q.size();
		for (int i = 0; i < N; i++) {
			if (Q.get(i).equalsIgnoreCase("UNDO")) {
				undo();
			} else if (Q.get(i).equalsIgnoreCase("REDO")) {
				redo();
			} else if (Q.get(i).equalsIgnoreCase("STORE")) {
				getData();
			} else {
				insertAction(Q.get(i));
			}
		}
	}
}
