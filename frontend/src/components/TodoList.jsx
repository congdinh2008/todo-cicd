import TodoItem from './TodoItem';
import './TodoList.css';

/**
 * TodoList - Component hiển thị danh sách todos
 * 
 * Props:
 * - todos: Array các todo objects
 * - onToggleComplete: Function để toggle trạng thái completed
 * - onUpdateTodo: Function để cập nhật todo
 * - onDeleteTodo: Function để xóa todo
 */
function TodoList({ todos, onToggleComplete, onUpdateTodo, onDeleteTodo }) {
  // Nếu không có todos, hiển thị empty state
  if (!todos || todos.length === 0) {
    return (
      <div className="empty-state">
        <div className="empty-icon">📋</div>
        <h3>Chưa có todo nào</h3>
        <p>Hãy thêm todo đầu tiên của bạn!</p>
      </div>
    );
  }

  return (
    <div className="todo-list">
      <h2>📋 Danh sách Todo ({todos.length})</h2>
      <div className="todo-items">
        {todos.map((todo) => (
          <TodoItem
            key={todo.id}
            todo={todo}
            onToggleComplete={onToggleComplete}
            onUpdateTodo={onUpdateTodo}
            onDeleteTodo={onDeleteTodo}
          />
        ))}
      </div>
    </div>
  );
}

export default TodoList;
