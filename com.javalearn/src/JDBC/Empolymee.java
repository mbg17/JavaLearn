package JDBC;

import java.util.Date;

public class Empolymee {

    private Integer id;
    private String ename;
    private Integer job_id;
    private Integer mgr;
    private Date date;
    private Double salsry;
    private Double bouns;
    private Integer dept_id;

    public Empolymee(int id, String ename, int job_id, int mgr, Date date, double salsry, double bouns, int dept_id) {
        this.id = id;
        this.ename = ename;
        this.job_id = job_id;
        this.mgr = mgr;
        this.date = date;
        this.salsry = salsry;
        this.bouns = bouns;
        this.dept_id = dept_id;
    }

    public Empolymee() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSalsry() {
        return salsry;
    }

    public void setSalsry(Double salsry) {
        this.salsry = salsry;
    }

    public Double getBouns() {
        return bouns;
    }

    public void setBouns(Double bouns) {
        this.bouns = bouns;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Empolymee{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", job_id=" + job_id +
                ", mgr=" + mgr +
                ", date=" + date +
                ", salsry=" + salsry +
                ", bouns=" + bouns +
                ", dept_id=" + dept_id +
                '}';
    }
}
