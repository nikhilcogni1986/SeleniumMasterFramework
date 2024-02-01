package pom.objects;

public class BillingAddress
{
    private String firstName;
    private String lastName;
    private String country;
    private String address1;
    private String city;
    private String state;
    private String postalCode;
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress1() {
        return address1;
    }

    public BillingAddress setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public BillingAddress setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public BillingAddress setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }
}
