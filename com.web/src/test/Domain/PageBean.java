package test.Domain;

import java.util.List;

public class PageBean<T> {
    private int totalPages;// 总页数
    private int totalCount;// 总记录数
    private List<T> list; // 返回的数据
    private int rows = 5; // 每页显示的行数
    private int currentPage; // 当前页码

    @Override
    public String toString() {
        return "PageBean{" +
                "totalPages=" + totalPages +
                ", totalCount=" + totalCount +
                ", list=" + list +
                ", rows=" + rows +
                ", currentPage=" + currentPage +
                '}';
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
