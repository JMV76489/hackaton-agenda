public class Contact {

    private String name;
    private String lastName;
    private String phoneNumber;

    public Contact(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }// Contact

    public String getName() {
        return name;
    }// getName

    public void setName(String name) {
        this.name = name;
    }// setName

    public String getLastName() {
        return lastName;
    }// getLastName

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }// setLastName

    public String getPhoneNumber() {
        return phoneNumber;
    }// getPhoneNumber

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }// setPhoneNumber

    @Override
    public String toString() {
        return "Contact{name='" + name +
                "', lastName='" + lastName +
                "', phoneNumber='" + phoneNumber + "'}";
    }// toString

}// class Contact