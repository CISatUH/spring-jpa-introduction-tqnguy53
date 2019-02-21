package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstApplication implements CommandLineRunner {


    @Autowired
    PersonRepository personRepository;
    @Autowired
    ManagerRepository managerRepository;

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setName("John");
        personRepository.save(person);

        Person personFromDb = personRepository.findFirstByName("John");
        System.out.println(personFromDb);

        Manager manager = new Manager();
        manager.setLastName("Nguyen");
        managerRepository.save(manager);

        System.out.println(toString(manager));
        Manager managerFromDb = managerRepository.findByLastName("Nguyen");
        System.out.println(toString(managerFromDb));
    }

    public String toString(Manager manager) {
        return String.format("Manager: " + manager.getFirstName() + " " + manager.getLastName());
    }

}
