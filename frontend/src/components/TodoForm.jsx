import { useState } from 'react';
import './TodoForm.css';

/**
 * TodoForm - Component form để thêm todo mới
 * 
 * Props:
 * - onAddTodo: Function callback khi submit form
 */
function TodoForm({ onAddTodo }) {
  // State cho form inputs
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [isSubmitting, setIsSubmitting] = useState(false);

  /**
   * Xử lý submit form
   */
  const handleSubmit = async (e) => {
    e.preventDefault();

    // Validate: title không được trống
    if (!title.trim()) {
      alert('Vui lòng nhập tiêu đề todo!');
      return;
    }

    try {
      setIsSubmitting(true);
      
      // Tạo todo data
      const todoData = {
        title: title.trim(),
        description: description.trim() || null,
        completed: false,
      };

      // Gọi callback prop
      await onAddTodo(todoData);

      // Reset form sau khi thêm thành công
      setTitle('');
      setDescription('');
    } catch (err) {
      console.error('Error in form submit:', err);
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <form className="todo-form" onSubmit={handleSubmit}>
      <h2>➕ Thêm Todo Mới</h2>
      
      <div className="form-group">
        <label htmlFor="title">
          Tiêu đề <span className="required">*</span>
        </label>
        <input
          type="text"
          id="title"
          placeholder="Nhập tiêu đề todo..."
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          disabled={isSubmitting}
          required
        />
      </div>

      <div className="form-group">
        <label htmlFor="description">Mô tả</label>
        <textarea
          id="description"
          placeholder="Nhập mô tả chi tiết (tùy chọn)..."
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          disabled={isSubmitting}
          rows="3"
        />
      </div>

      <button 
        type="submit" 
        className="submit-button"
        disabled={isSubmitting}
      >
        {isSubmitting ? 'Đang thêm...' : '✓ Thêm Todo'}
      </button>
    </form>
  );
}

export default TodoForm;
