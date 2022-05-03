package com.sari3food.sari3fooooooooood;

public class ClassUser {
    String email;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamme() {
        return namme;
    }

    public void setNamme(String namme) {
        this.namme = namme;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    String namme;
    String pass;
    String work;
    Integer phone;

    public ClassUser(String email, String namme, String pass, String work, Integer phone, Integer state) {
        this.email = email;
        this.namme = namme;
        this.pass = pass;
        this.work = work;
        this.phone = phone;
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    Integer state;


}
