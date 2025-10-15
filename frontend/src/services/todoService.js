import axios from 'axios';

/**
 * API Service - Xử lý tất cả các HTTP requests đến backend
 * 
 * Sử dụng axios để gọi REST API
 * Base URL: http://localhost:8080/api
 */

// Tạo axios instance với cấu hình mặc định
const API_BASE_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080/api';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
  // Timeout sau 10 giây
  timeout: 10000,
});

// Interceptor để log requests (hữu ích cho debugging)
api.interceptors.request.use(
  (config) => {
    console.log(`[API Request] ${config.method.toUpperCase()} ${config.url}`);
    return config;
  },
  (error) => {
    console.error('[API Request Error]', error);
    return Promise.reject(error);
  }
);

// Interceptor để log responses và xử lý errors
api.interceptors.response.use(
  (response) => {
    console.log(`[API Response] ${response.status} ${response.config.url}`);
    return response;
  },
  (error) => {
    console.error('[API Response Error]', error.response?.data || error.message);
    return Promise.reject(error);
  }
);

/**
 * TodoService - Object chứa các methods để tương tác với Todo API
 */
const todoService = {
  /**
   * Lấy tất cả todos
   * GET /api/todos
   * 
   * @param {Object} params - Query parameters (optional)
   * @param {Boolean} params.completed - Filter theo trạng thái completed
   * @param {String} params.search - Tìm kiếm theo title
   * @returns {Promise} Promise chứa danh sách todos
   */
  getAllTodos: (params = {}) => {
    return api.get('/todos', { params });
  },

  /**
   * Lấy todo theo ID
   * GET /api/todos/:id
   * 
   * @param {Number} id - ID của todo
   * @returns {Promise} Promise chứa todo object
   */
  getTodoById: (id) => {
    return api.get(`/todos/${id}`);
  },

  /**
   * Tạo mới todo
   * POST /api/todos
   * 
   * @param {Object} todoData - Dữ liệu todo mới
   * @param {String} todoData.title - Tiêu đề todo (required)
   * @param {String} todoData.description - Mô tả todo (optional)
   * @returns {Promise} Promise chứa todo đã tạo
   */
  createTodo: (todoData) => {
    return api.post('/todos', todoData);
  },

  /**
   * Cập nhật todo
   * PUT /api/todos/:id
   * 
   * @param {Number} id - ID của todo
   * @param {Object} todoData - Dữ liệu cập nhật
   * @returns {Promise} Promise chứa todo đã cập nhật
   */
  updateTodo: (id, todoData) => {
    return api.put(`/todos/${id}`, todoData);
  },

  /**
   * Xóa todo
   * DELETE /api/todos/:id
   * 
   * @param {Number} id - ID của todo cần xóa
   * @returns {Promise} Promise void
   */
  deleteTodo: (id) => {
    return api.delete(`/todos/${id}`);
  },

  /**
   * Đánh dấu todo là completed
   * PATCH /api/todos/:id/complete
   * 
   * @param {Number} id - ID của todo
   * @returns {Promise} Promise chứa todo đã cập nhật
   */
  completeTodo: (id) => {
    return api.patch(`/todos/${id}/complete`);
  },

  /**
   * Đánh dấu todo là chưa completed
   * PATCH /api/todos/:id/incomplete
   * 
   * @param {Number} id - ID của todo
   * @returns {Promise} Promise chứa todo đã cập nhật
   */
  incompleteTodo: (id) => {
    return api.patch(`/todos/${id}/incomplete`);
  },

  /**
   * Lấy thống kê todos
   * GET /api/todos/stats
   * 
   * @returns {Promise} Promise chứa stats object
   */
  getStats: () => {
    return api.get('/todos/stats');
  },
};

export default todoService;
