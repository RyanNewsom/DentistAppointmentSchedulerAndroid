package model.users.entityinfo;


/**
 * Office
 */
public class Office {
    private String id;
    private ContactInfo contactInfo;

    public Office(ContactInfo contactInfo){
        this.contactInfo = contactInfo;
    }

    public String getOfficeId() {
        return id;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id='" + id + '\'' +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
