
import com.app.service.TodoService;

public class TodoApp {
	public static void main(String[] args) {

		TodoService todoService = new TodoService();
		todoService.addTodo("Nag", "item-1");
		todoService.addTodo("Nag", "item-3");
		todoService.addTodo("Nag", "item-2");

		todoService.completeTodo("Nag", 3);
		todoService.completeTodo("Nag", 3);

		todoService.sort("Nag", "title").forEach(System.out::println);
	}
}