package codility.assessment.scrubmember;

public class Member {

    private String id;
    private String address;
    private String city;
    private String firstName;
    private String lastName;
    private String fullName;
    private String state;
    private String zip;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Update method to return final layout string.
     */
    public String toFinalFormatString() {
        return id + "|" + fullName + "|" + address + "|" + city + "|" + state + "|" + zip;
    }
}