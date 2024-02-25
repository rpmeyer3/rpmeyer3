public class Person
{
        private String name;
        private int age;
        private String address;
    private String telephone;

    /**
     *
     * @param sName
     * @param iAge
     */
    public Person(String sName, int iAge)
    {

            if (iAge < 0)
            {
                throw new IllegalArgumentException("Age cannot be verified");
            }
            if (sName == null || sName.length() == 0)
            {
                throw new IllegalArgumentException("Name cannot be verified");
            }
            name = sName;
            age = iAge;
            address = null;
            telephone = null;
    }

    /**
     *
     * @param sName
     * @param iAge
     * @param sAddress
     */
    public Person(String sName, int iAge, String sAddress)
    {
        this (sName, iAge);
        address = sAddress;

        /**
         *
         */
    }
    public String getName() {
        return name;
        /**
         *
         */
    }
    public void changeName(String newName) {
        name = newName;
        /**
         *
         */
    }
    public int getAge() {
        return age;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param newAddress
     */
    public void changeAddress(String newAddress) {
        address = newAddress;
    }

    /**
     *
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     *
     * @param newPhoneNumber
     */
    public void changeTelephone(String newPhoneNumber) {
        if (newPhoneNumber == null || newPhoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Telephone cannot be empty or null");
        }
        telephone = newPhoneNumber;
    }
}
