package model.users.entityinfo;

/**
 * Contact Info
 */
public class ContactInfo {
    private String cellNumber;
    private PhysicalAddress physicalAddress;

    public ContactInfo(String cellNumber, PhysicalAddress physicalAddress){
        this.cellNumber = cellNumber;
        this.physicalAddress = physicalAddress;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public PhysicalAddress getPhysicalAddress() {
        return physicalAddress;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "cellNumber='" + cellNumber + '\'' +
                ", physicalAddress=" + physicalAddress +
                '}';
    }
}
