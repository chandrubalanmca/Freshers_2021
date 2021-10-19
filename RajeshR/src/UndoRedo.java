import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UndoRedo {

	public static void main(String[] args) {

		UndoManager queue = new UndoManager();
		Scanner scan = new Scanner(System.in);
		String action = "";
		List<String> user = new ArrayList<>();
		while(!(action=scan.nextLine()).equalsIgnoreCase("stop")){
		  user.add(action);
			if (action.equalsIgnoreCase("undo"))
				queue.undo();
			else if (action.equalsIgnoreCase("redo"))
				queue.redo();
			else
				queue.insertAction(action);
		}
		queue.userAction(user);
	}
}













	
