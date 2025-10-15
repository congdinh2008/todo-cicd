---
name: "Bước 7: Tạo React Components"
about: Hướng dẫn tạo các React components cho Todo app
title: "[Frontend] Tạo React Components"
labels: frontend, components, step-7
assignees: ''
---

## 🎯 Mục tiêu
Tạo các React components để hiển thị và quản lý todos.

## 📋 Các công việc cần làm

### 1. Tạo App Component (src/App.jsx)
- [ ] Import dependencies và components
- [ ] Setup states:
  - todos (array)
  - loading (boolean)
  - error (string)
  - filter ('all', 'completed', 'incomplete')
  - searchQuery (string)
  - stats (object)
- [ ] Implement useEffect hooks:
  - Load todos khi mount/filter/search change
  - Load stats khi todos change
- [ ] Implement handler functions:
  - loadTodos() - Gọi API lấy todos
  - loadStats() - Gọi API lấy stats
  - handleAddTodo() - Thêm todo mới
  - handleUpdateTodo() - Cập nhật todo
  - handleDeleteTodo() - Xóa todo
  - handleToggleComplete() - Toggle completed status
- [ ] Render UI:
  - Header
  - Error message (nếu có)
  - TodoStats component
  - TodoForm component
  - Filter buttons và search box
  - TodoList component
  - Footer

### 2. Tạo TodoForm Component (src/components/TodoForm.jsx)
- [ ] Props: onAddTodo
- [ ] State: title, description, isSubmitting
- [ ] Handle submit:
  - Validate title không trống
  - Gọi onAddTodo với todo data
  - Reset form sau khi thành công
- [ ] Render form:
  - Input cho title (required)
  - Textarea cho description (optional)
  - Submit button

### 3. Tạo TodoList Component (src/components/TodoList.jsx)
- [ ] Props: todos, onToggleComplete, onUpdateTodo, onDeleteTodo
- [ ] Render:
  - Heading với số lượng todos
  - Map todos thành TodoItem components
  - Empty state nếu không có todos

### 4. Tạo TodoItem Component (src/components/TodoItem.jsx)
- [ ] Props: todo, onToggleComplete, onUpdateTodo, onDeleteTodo
- [ ] State: isEditing, editTitle, editDescription
- [ ] Implement handlers:
  - handleSave() - Save edited todo
  - handleCancel() - Cancel editing
  - formatDate() - Format datetime
- [ ] Render:
  - Checkbox để toggle complete
  - View mode: title, description, dates
  - Edit mode: input fields
  - Action buttons: edit, delete, save, cancel

### 5. Tạo TodoStats Component (src/components/TodoStats.jsx)
- [ ] Props: stats
- [ ] Render stat cards:
  - Total todos
  - Incomplete todos
  - Completed todos
  - Completion rate (%)

### 6. Tạo CSS files
- [ ] `App.css` - Styles cho App component
- [ ] `TodoForm.css` - Styles cho form
- [ ] `TodoList.css` - Styles cho list
- [ ] `TodoItem.css` - Styles cho item
- [ ] `TodoStats.css` - Styles cho stats

### 7. Thêm comments chi tiết
- [ ] Comment giải thích component purpose
- [ ] Comment giải thích props
- [ ] Comment giải thích state management
- [ ] Comment giải thích handlers
- [ ] Comment giải thích useEffect dependencies

## 📚 Kiến thức cần có
- React Hooks (useState, useEffect)
- Component props
- Event handling
- Conditional rendering
- Lists and keys
- CSS styling

## 🔗 Tài liệu tham khảo
- [React Hooks](https://react.dev/reference/react)
- [React Components](https://react.dev/learn/your-first-component)
- [Handling Events](https://react.dev/learn/responding-to-events)

## 🧪 Testing
- [ ] Components render đúng
- [ ] Có thể thêm todo mới
- [ ] Có thể edit todo
- [ ] Có thể xóa todo
- [ ] Có thể toggle complete
- [ ] Filter hoạt động
- [ ] Search hoạt động
- [ ] Stats cập nhật đúng

## ✅ Tiêu chí hoàn thành
- [ ] Tất cả components hoạt động đúng
- [ ] UI responsive và đẹp mắt
- [ ] User experience mượt mà
- [ ] Không có console errors
- [ ] Code có comments tiếng Việt đầy đủ
