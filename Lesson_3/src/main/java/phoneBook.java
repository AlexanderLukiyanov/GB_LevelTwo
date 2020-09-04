import java.util.LinkedList;
import java.util.List;

public class phoneBook {


        private List<Contact> ContactList;

        public phoneBook() {
            this.ContactList = new LinkedList<>();
        }

        public void addContact(String phoneNumber, String lastName) {
            this.ContactList.add(new Contact(phoneNumber, lastName));
        }

        public void getContact(String lastName) {
            String info = lastName + ":";
            for (Contact contact : this.ContactList) {

                if (contact.getLastName().equalsIgnoreCase(lastName)) {
                    info = info + "\n" + contact.getPhoneNumber();
                }
            }
            System.out.println(info);
        }
}
