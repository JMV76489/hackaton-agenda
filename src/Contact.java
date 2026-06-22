public class Contact {

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }// Contact

    public String getName() {
        return name;
    }// getName

    public void setName(String name) {
        this.name = name;
    }// setName

    public String getPhoneNumber() {
        return phoneNumber;
    }// getPhoneNumber

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }// setPhoneNumber


    @Override
    public String toString() {
        return "Contact{name='" + name +
                "', phoneNumber='" + phoneNumber + "'}";
    }// tostring

}// class Contact