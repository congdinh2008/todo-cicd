import { useState, useEffect } from 'react';
import todoService from './services/todoService';
import TodoList from './components/TodoList';
import TodoForm from './components/TodoForm';
import TodoStats from './components/TodoStats';
import './App.css';

/**
 * App - Component chính của ứng dụng Todo
 * 
 * Quản lý state và logic chính:
 * - Danh sách todos
 * - Thêm, sửa, xóa todos
 * - Filter và search
 * - Thống kê
 */
function App() {
  // State cho danh sách todos
  const [todos, setTodos] = useState([]);
  
  // State cho loading và error
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  
  // State cho filter và search
  const [filter, setFilter] = useState('all'); // 'all', 'completed', 'incomplete'
  const [searchQuery, setSearchQuery] = useState('');
  
  // State cho stats
  const [stats, setStats] = useState({
    total: 0,
    completed: 0,
    incomplete: 0,
    completionRate: 0,
  });

  /**
   * Load todos khi component mount hoặc khi filter/search thay đổi
   */
  useEffect(() => {
    loadTodos();
  }, [filter, searchQuery]);

  /**
   * Load stats khi todos thay đổi
   */
  useEffect(() => {
    loadStats();
  }, [todos]);

  /**
   * Hàm load todos từ API
   */
  const loadTodos = async () => {
    try {
      setLoading(true);
      setError(null);
      
      // Tạo params cho API call
      const params = {};
      
      // Nếu có search query, gọi API search
      if (searchQuery.trim()) {
        params.search = searchQuery.trim();
      }
      // Nếu filter theo completed/incomplete
      else if (filter === 'completed') {
        params.completed = true;
      } else if (filter === 'incomplete') {
        params.completed = false;
      }
      
      // Gọi API
      const response = await todoService.getAllTodos(params);
      setTodos(response.data);
    } catch (err) {
      console.error('Error loading todos:', err);
      setError('Không thể tải danh sách todos. Vui lòng thử lại.');
    } finally {
      setLoading(false);
    }
  };

  /**
   * Hàm load stats từ API
   */
  const loadStats = async () => {
    try {
      const response = await todoService.getStats();
      setStats(response.data);
    } catch (err) {
      console.error('Error loading stats:', err);
    }
  };

  /**
   * Hàm thêm todo mới
   */
  const handleAddTodo = async (todoData) => {
    try {
      setError(null);
      await todoService.createTodo(todoData);
      // Reload todos sau khi thêm
      await loadTodos();
    } catch (err) {
      console.error('Error creating todo:', err);
      setError('Không thể tạo todo. Vui lòng thử lại.');
      throw err;
    }
  };

  /**
   * Hàm cập nhật todo
   */
  const handleUpdateTodo = async (id, todoData) => {
    try {
      setError(null);
      await todoService.updateTodo(id, todoData);
      // Reload todos sau khi cập nhật
      await loadTodos();
    } catch (err) {
      console.error('Error updating todo:', err);
      setError('Không thể cập nhật todo. Vui lòng thử lại.');
      throw err;
    }
  };

  /**
   * Hàm xóa todo
   */
  const handleDeleteTodo = async (id) => {
    // Xác nhận trước khi xóa
    if (!window.confirm('Bạn có chắc muốn xóa todo này?')) {
      return;
    }

    try {
      setError(null);
      await todoService.deleteTodo(id);
      // Reload todos sau khi xóa
      await loadTodos();
    } catch (err) {
      console.error('Error deleting todo:', err);
      setError('Không thể xóa todo. Vui lòng thử lại.');
    }
  };

  /**
   * Hàm toggle trạng thái completed của todo
   */
  const handleToggleComplete = async (todo) => {
    try {
      setError(null);
      if (todo.completed) {
        await todoService.incompleteTodo(todo.id);
      } else {
        await todoService.completeTodo(todo.id);
      }
      // Reload todos sau khi toggle
      await loadTodos();
    } catch (err) {
      console.error('Error toggling todo:', err);
      setError('Không thể cập nhật trạng thái todo. Vui lòng thử lại.');
    }
  };

  return (
    <div className="app">
      <header className="app-header">
        <h1>📝 Todo App</h1>
        <p>Quản lý công việc hiệu quả</p>
      </header>

      <main className="app-main">
        {/* Hiển thị error nếu có */}
        {error && (
          <div className="error-message">
            {error}
            <button onClick={() => setError(null)}>✕</button>
          </div>
        )}

        {/* Thống kê */}
        <TodoStats stats={stats} />

        {/* Form thêm todo mới */}
        <TodoForm onAddTodo={handleAddTodo} />

        {/* Filter và Search */}
        <div className="controls">
          <div className="filter-buttons">
            <button
              className={filter === 'all' ? 'active' : ''}
              onClick={() => setFilter('all')}
            >
              Tất cả ({stats.total})
            </button>
            <button
              className={filter === 'incomplete' ? 'active' : ''}
              onClick={() => setFilter('incomplete')}
            >
              Chưa xong ({stats.incomplete})
            </button>
            <button
              className={filter === 'completed' ? 'active' : ''}
              onClick={() => setFilter('completed')}
            >
              Hoàn thành ({stats.completed})
            </button>
          </div>

          <div className="search-box">
            <input
              type="text"
              placeholder="🔍 Tìm kiếm todo..."
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
            />
          </div>
        </div>

        {/* Danh sách todos */}
        {loading ? (
          <div className="loading">Đang tải...</div>
        ) : (
          <TodoList
            todos={todos}
            onToggleComplete={handleToggleComplete}
            onUpdateTodo={handleUpdateTodo}
            onDeleteTodo={handleDeleteTodo}
          />
        )}
      </main>

      <footer className="app-footer">
        <p>© 2024 Todo App - Spring Boot + React + PostgreSQL</p>
      </footer>
    </div>
  );
}

export default App;
