package main.services;

import main.model.Employee;
import main.model.History;
import main.model.Education;
import main.model.Position;
import main.repos.EmployeeRepository;
import main.repos.HistoryRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.JSONObject;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private HistoryRepository historyRepository;

    public Long addEmployee(String name, String middle_name, String last_name,
                          String address, String phone_number, String email,
                            String login, String education, String position,
                            String password, String role) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setMiddleName(middle_name);
        employee.setLastName(last_name);
        employee.setAddress(address);
        employee.setPhoneNumber(phone_number);
        employee.setEmail(email);
        employee.setEducation(education);
        employee.setPosition(position);
        employee.setLogin(login);
        employee.setPassword(password);
        employee.setUserRole(role);
        employeeRepository.save(employee);
        return employee.getEmployeeId();
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Optional<Long> changeEmployee(JSONObject jo) {
        if (!jo.has("id")) {
            return Optional.empty();
        }
        Long id = Long.valueOf(jo.getString("id"));
        if (!employeeRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
         Employee employee = employeeRepository.findById(id).get();
        if (jo.has("name")) {
            employee.setName(jo.getString("name"));
        }
        if (jo.has("middleName")) {
            employee.setMiddleName(jo.getString("middleName"));
        }

        if (jo.has("lastName")) {
            employee.setLastName(jo.getString("lastName"));
        }

        if (jo.has("phoneNumber")) {
            employee.setPhoneNumber(jo.getString("phoneNumber"));
        }

        if (jo.has("address")) {
            employee.setAddress(jo.getString("address"));
        }

        if (jo.has("email")) {
            employee.setEmail(jo.getString("email"));
        }

        if (jo.has("education")) {
            employee.setEducation(/*Education.valueOf(*/jo.getString("education"));
        }

        if (jo.has("position")) {
            employee.setPosition(/*Position.valueOf(*/jo.getString("education"));
        }

        if (jo.has("histories")) {
            List<History> histories = new ArrayList<>();
            JSONArray ja = new JSONArray(jo.getString("histories"));
            ja.toList().forEach((sEventId) -> {
                Long eventId = Long.valueOf(sEventId.toString());
                histories.add(historyRepository.findById(eventId).get());
            });
            employee.setHistories(histories);
        }
        employeeRepository.save(employee);
        return Optional.of(id);
    }

    public JSONObject getProfile(String login) {
        Employee employee = employeeRepository.findEmployeeByLogin(login);
        JSONObject jo = new JSONObject();
        jo.put("name", employee.getName());
        jo.put("middleName", employee.getMiddleName());
        jo.put("lastName", employee.getLastName());
        jo.put("address", employee.getAddress());
        jo.put("phoneNumber", employee.getPhoneNumber());
        jo.put("email", employee.getEmail());
        jo.put("educaton", employee.getEducation());
        jo.put("position", employee.getPosition());
        jo.put("userRole", employee.getUserRole());
        return jo;
    }

    public Map<String, ArrayList<String>> getAllEmployees() {
        Map<String, ArrayList<String>> jo = new HashMap<String, ArrayList<String>>();
        employeeRepository.findAll().forEach((employee) -> {
            ArrayList<String> params = new ArrayList<>();
            String name = employee.getName();
            String middle_name = employee.getMiddleName();
            if (middle_name == null) {
                middle_name = "";
            }
            String last_name = employee.getLastName();
            String phone_number = employee.getPhoneNumber();
            if (phone_number == null) {
                phone_number = "";
            }
            String email = employee.getEmail();
            if (email == null) {
                email = "";
            }
            String address = employee.getAddress();
            if (address == null) {
                address = "";
            }
            params.add(name);
            params.add(middle_name);
            params.add(last_name);
            params.add(phone_number);
            params.add(email);
            params.add(address);
            jo.put(Long.toString(employee.getEmployeeId()), params);
        });
        return jo;
    }

    public JSONObject getAllEmployeesByEvent(Long eventId) {
        JSONObject jo = new JSONObject();
        employeeRepository.findByHistories_EventId(eventId).forEach((employee) -> {
            String name = employee.getName();
            String last_name = employee.getLastName();
            String role = employee.getUserRole();
            jo.put(Long.toString(employee.getEmployeeId()), name + " " + last_name +
                    " " + role);
        });
        return jo;
    }

    public JSONObject getAllEmployeesByDates(LocalDate date1, LocalDate date2) {
        JSONObject jo = new JSONObject();
        List<Long> eventIds = new ArrayList<>();

        historyRepository.findByDateBetween(date1, date2).forEach((history) -> {
            System.out.println(history.getHistoryId());
            eventIds.add(history.getHistoryId());
        });
        //System.out.println(eventIds);

        employeeRepository.findAllByHistories_EventIdIn(eventIds).forEach((employee) -> {
            String name = employee.getName();
            String last_name = employee.getLastName();
            jo.put(Long.toString(employee.getEmployeeId()), name + " " + last_name);
        });
        return jo;
    }

    public Boolean authen(String login, String passwd) {
        Employee employee = employeeRepository.findEmployeeByLogin(login);
        if (employee != null) {
            return employee.getPassword().equals(passwd);
        } else {
            return false;
        }
    }

}
