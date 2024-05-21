package com.example.hackaton.email;

public class ReservaEmailEvent {

    private String email;

    private String name;

    private String salonName;

    public ReservaEmailEvent(String email, String name, String salonName) {
        this.email = email;
        this.name = name;
        this.salonName = salonName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }
}
