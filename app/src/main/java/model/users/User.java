package model.users;


import model.users.entityinfo.ContactInfo;

/**
 * User
 */
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private ContactInfo contactInfo;

    public User(String firstName, String lastName, ContactInfo contactInfo){
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", id='" + userId + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
