import './TodoStats.css';

/**
 * TodoStats - Component hiển thị thống kê todos
 * 
 * Props:
 * - stats: Object chứa các số liệu thống kê
 *   - total: Tổng số todos
 *   - completed: Số todos đã hoàn thành
 *   - incomplete: Số todos chưa hoàn thành
 *   - completionRate: Tỷ lệ hoàn thành (%)
 */
function TodoStats({ stats }) {
  return (
    <div className="todo-stats">
      <div className="stat-card">
        <div className="stat-icon">📊</div>
        <div className="stat-content">
          <div className="stat-value">{stats.total}</div>
          <div className="stat-label">Tổng số</div>
        </div>
      </div>

      <div className="stat-card">
        <div className="stat-icon">⏳</div>
        <div className="stat-content">
          <div className="stat-value">{stats.incomplete}</div>
          <div className="stat-label">Chưa xong</div>
        </div>
      </div>

      <div className="stat-card">
        <div className="stat-icon">✅</div>
        <div className="stat-content">
          <div className="stat-value">{stats.completed}</div>
          <div className="stat-label">Hoàn thành</div>
        </div>
      </div>

      <div className="stat-card">
        <div className="stat-icon">📈</div>
        <div className="stat-content">
          <div className="stat-value">{stats.completionRate.toFixed(1)}%</div>
          <div className="stat-label">Tỷ lệ</div>
        </div>
      </div>
    </div>
  );
}

export default TodoStats;
