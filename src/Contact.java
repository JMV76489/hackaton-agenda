public class Contact {

    private String name;
    private String lastName;
    private String phoneNumber;

    public Contact(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s",
                name,
                lastName,
                phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;

        Contact other = (Contact) obj;

        return name.equalsIgnoreCase(other.name)
                && lastName.equalsIgnoreCase(other.lastName);
    }

    @Override
    public int hashCode() {
        return (name + lastName).toLowerCase().hashCode();
    }
}