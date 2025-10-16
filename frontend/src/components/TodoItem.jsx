import { useState } from 'react';
import './TodoItem.css';

/**
 * TodoItem - Component hiển thị một todo item
 * 
 * Props:
 * - todo: Todo object
 * - onToggleComplete: Function để toggle completed
 * - onUpdateTodo: Function để cập nhật todo
 * - onDeleteTodo: Function để xóa todo
 */
function TodoItem({ todo, onToggleComplete, onUpdateTodo, onDeleteTodo }) {
  // State cho edit mode
  const [isEditing, setIsEditing] = useState(false);
  const [editTitle, setEditTitle] = useState(todo.title);
  const [editDescription, setEditDescription] = useState(todo.description || '');

  /**
   * Xử lý save khi edit
   */
  const handleSave = async () => {
    // Validate
    if (!editTitle.trim()) {
      alert('Tiêu đề không được trống!');
      return;
    }

    try {
      // Gọi update API
      await onUpdateTodo(todo.id, {
        title: editTitle.trim(),
        description: editDescription.trim() || null,
      });
      
      // Thoát edit mode
      setIsEditing(false);
    } catch (err) {
      console.error('Error updating todo:', err);
    }
  };

  /**
   * Xử lý cancel edit
   */
  const handleCancel = () => {
    // Reset về giá trị ban đầu
    setEditTitle(todo.title);
    setEditDescription(todo.description || '');
    setIsEditing(false);
  };

  /**
   * Format ngày tháng
   */
  const formatDate = (dateString) => {
    if (!dateString) return '';
    const date = new Date(dateString);
    return date.toLocaleString('vi-VN', {
      year: 'numeric',
      month: '2-digit',
      day: '2-digit',
      hour: '2-digit',
      minute: '2-digit',
    });
  };

  return (
    <div className={`todo-item ${todo.completed ? 'completed' : ''}`}>
      <div className="todo-checkbox">
        <input
          type="checkbox"
          checked={todo.completed}
          onChange={() => onToggleComplete(todo)}
          disabled={isEditing}
        />
      </div>

      <div className="todo-content">
        {isEditing ? (
          // Edit mode
          <div className="edit-form">
            <input
              type="text"
              className="edit-title"
              value={editTitle}
              onChange={(e) => setEditTitle(e.target.value)}
              placeholder="Tiêu đề..."
            />
            <textarea
              className="edit-description"
              value={editDescription}
              onChange={(e) => setEditDescription(e.target.value)}
              placeholder="Mô tả..."
              rows="2"
            />
          </div>
        ) : (
          // View mode
          <div className="view-mode">
            <h3 className="todo-title">{todo.title}</h3>
            {todo.description && (
              <p className="todo-description">{todo.description}</p>
            )}
            <div className="todo-meta">
              <span className="todo-date">
                📅 Tạo: {formatDate(todo.createdAt)}
              </span>
              {todo.updatedAt !== todo.createdAt && (
                <span className="todo-date">
                  🔄 Cập nhật: {formatDate(todo.updatedAt)}
                </span>
              )}
            </div>
          </div>
        )}
      </div>

      <div className="todo-actions">
        {isEditing ? (
          // Edit mode buttons
          <>
            <button
              className="btn-save"
              onClick={handleSave}
              title="Lưu"
            >
              ✓
            </button>
            <button
              className="btn-cancel"
              onClick={handleCancel}
              title="Hủy"
            >
              ✕
            </button>
          </>
        ) : (
          // View mode buttons
          <>
            <button
              className="btn-edit"
              onClick={() => setIsEditing(true)}
              title="Chỉnh sửa"
            >
              ✏️
            </button>
            <button
              className="btn-delete"
              onClick={() => onDeleteTodo(todo.id)}
              title="Xóa"
            >
              🗑️
            </button>
          </>
        )}
      </div>
    </div>
  );
}

export default TodoItem;
