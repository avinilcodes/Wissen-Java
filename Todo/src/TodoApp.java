
import java.util.List;

import com.app.model.Todo;
import com.app.service.TodoService;
public class TodoApp {
public static void main(String[] args) {
	TodoService todoService = new TodoService();
	todoService.addTodo("go sleep");
	//todoService.displayAll();
	todoService.addTodo("eat");
	todoService.addTodo("work");
	todoService.addTodo("workout");
	todoService.editTodo(1, "dont sleep");
	//todoService.displayAll();
	//todoService.deleteTodo(1);
	//todoService.completeAll();
	//System.out.println();
	todoService.displayAll();
	todoService.completeTodo(1);
	todoService.clearCompleted();
	//todoService.deleteTodo(5);
	System.out.println();
	todoService.displayAll();
	
	List<Todo> tods= todoService.filter(t->!t.isCompleted());
	System.out.println(tods);
}
}
