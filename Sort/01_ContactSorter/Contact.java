public class Contact implements Comparable<Contact> {
    public String firstName;
    public String lastName;

    public Contact(String f, String l) {
        firstName = f; lastName = l;
    }

    public int compareTo(Contact c) {
        int result = lastName.compareTo(c.lastName);
        if (result == 0){
            result = firstName.compareTo(c.firstName);
            return result;
        }
        else{
            return result;
        }
    }
}
