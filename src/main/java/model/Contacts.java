package model;

public class Contacts {
    private int Contact_Id;
    private String Contact_Name;
    private String Email;

    public void Contacts(int contact_Id, String contact_Name, String email){
        this.Contact_Id = contact_Id;
        this.Contact_Name = contact_Name;
        this.Email = email;
    }

    public int getContact_Id() {
        return Contact_Id;
    }

    public void setContact_Id(int contact_Id) {
        Contact_Id = contact_Id;
    }

    public String getContact_Name() {
        return Contact_Name;
    }

    public void setContact_Name(String contact_Name) {
        Contact_Name = contact_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
