package model;

/**
 * This class is the model for Contacts in the database
 */
public class Contacts {
    private int Contact_Id;
    private String Contact_Name;
    private String Email;

    /**
     * This method creates a new contact
     * @param contact_Id
     * @param contact_Name
     * @param email
     */
    public Contacts(int contact_Id, String contact_Name, String email){
        this.Contact_Id = contact_Id;
        this.Contact_Name = contact_Name;
        this.Email = email;
    }

    /**
     * Gets Contact Id
     * @return
     */
    public int getContact_Id() {
        return Contact_Id;
    }

    /**
     * Sets Contact Id
     * @param contact_Id
     */
    public void setContact_Id(int contact_Id) {
        Contact_Id = contact_Id;
    }

    /**
     * Get Contact Id
     * @return
     */
    public String getContact_Name() {
        return Contact_Name;
    }

    /**
     * Set Contact Name
     * @param contact_Name
     */
    public void setContact_Name(String contact_Name) {
        Contact_Name = contact_Name;
    }

    /**
     * Get Email
     * @return
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Set Email
     * @param email
     */
    public void setEmail(String email) {
        Email = email;
    }

    /**
     * Overrides the toString method
     * @return
     */
    @Override
    public String toString(){
        return (Integer.toString(Contact_Id) + ": " + Contact_Name);
    }
}
