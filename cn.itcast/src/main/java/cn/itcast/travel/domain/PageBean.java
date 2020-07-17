package cn.itcast.travel.domain;

import java.util.List;

public class PageBean<T> {
    // 总页数
    private int totalPages;
    // 总记录数
    private int totalCount;
    // 返回的数据
    private List<T> list;
    // 每页显示的行数
    private int rows = 10;
    // 当前页码
    private int currentPage;

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
