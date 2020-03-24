package main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "Employees")
public class Employee implements Serializable {

    @Id
    @Column(name = "Employee_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_generator")
    @SequenceGenerator(name="employee_id_generator", sequenceName = "Employee_id_seq", allocationSize=1)
    private long employee_id;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Middle_name", length = 50)
    private String middle_name;

    @Column(name = "Last_name", nullable = false, length = 50)
    private String last_name;

    @Column(name = "Phone_number", length = 50)
    private String phone_number;

    @Column(name = "Address")
    private String address;

    @Column(name = "Email", length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "Education_level")
    private Education education;

    @Enumerated(EnumType.STRING)
    @Column(name = "Position", nullable = false)
    private Position position;

    @Column(name = "Login", nullable = false, unique = true, length = 50)
    private String login;

    @Column(name = "Password", nullable = false, length = 64)
    private String password;

    @Column(name = "User_role", nullable = false, length = 64)
    private String user_role;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<History> histories = new ArrayList<History>();


    public Employee() {
    }

    public Employee(long employee_id, String name, String middle_name, String last_name,
                  String phone_number, String address, String email, Education education,
                    Position position, String login, String password) {
        this.employee_id = employee_id;
        this.name = name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;
        this.education = education;
        this.position = position;
        this.login = login;
        this.password = password;
        this.user_role = user_role;
    }

    public long getEmployeeId() {
        return employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public void setMiddleName(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return user_role;
    }

    public void setUserRole(String user_role) {
        this.user_role = user_role;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

}