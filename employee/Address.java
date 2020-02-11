package fr.univparis8.iut.dut.employee;

public class Address {

    private int num;
    private String street;
    private long postcode;
    private String city;

    public Address(int num, String street, long postcode, String city) {
        this.num = num;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
    }

    public int getNum() { return num; }

    public void setNum(int num) { this.num = num; }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) { this.street = street; }

    public long getPostCode() {
        return postcode;
    }

    public void setPostcode(long postcode) { this.postcode = postcode; }

    public String getCity() {
        return city;
    }

    public void setCity(String city) { this.city = city; }

    public Address mergeWith(Address other) {
        return AddressBuilder.create()
                .withNum(other.num)
                .withStreet(other.street != null ? other.street : street)
                .withPostcode(other.postcode)
                .withCity(other.city != null ? other.city : city)
                .build();
    }


    public static final class AddressBuilder {
        private int num;
        private String street;
        private long postcode;
        private String city;

        private AddressBuilder() {
        }

        public static AddressBuilder create() {
            return new AddressBuilder();
        }

        public AddressBuilder withNum(int num) {
            this.num = num;
            return this;
        }

        public AddressBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder withPostcode(long postcode) {
            this.postcode = postcode;
            return this;
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public Address build() {
            return new Address(num, street, postcode, city);
        }
    }
}
