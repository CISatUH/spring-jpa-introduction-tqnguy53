package main;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Manager {
    private int id;
    private String firstName;
    private String lastName;
    private String department;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 24)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = true, length = 24)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "DEPARTMENT", nullable = true, length = 24)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id &&
                Objects.equals(firstName, manager.firstName) &&
                Objects.equals(lastName, manager.lastName) &&
                Objects.equals(department, manager.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, department);
    }

/*  @Override
    public String toString() {
        return String.format("Manager: " + this.firstName + " " + this.lastName);
    }
*/
}
