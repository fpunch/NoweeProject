package com.example.noweeproject.ContactPciker;

public class Contact {
private String name;

    public Contact(String name, String phone, String photo) {
        this.name = name;
        this.phone = phone;
        this.photo = photo;
    }

    private String phone;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


}
