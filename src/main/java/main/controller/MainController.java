package main.controller;


import com.fasterxml.jackson.annotation.JsonAlias;

import org.json.JSONObject;
import java.time.LocalDate;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList  ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import main.services.EmployeeService;
import main.services.CompanyServiceService;
import main.services.HistoryService;
import main.services.ClientService;

import main.model.Education;
import main.model.Position;

@RestController
public class MainController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyServiceService companyServiceService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private ClientService clientService;


    @CrossOrigin
    @PostMapping(value = "/auth")
    @ResponseBody
    public Map<String, Boolean> auth(@RequestBody Map<String, String> req) {
        String login = req.getOrDefault("login", "");
        String password = req.getOrDefault("password", "");
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        if (employeeService.authen(login, password)) {
            response.put("ans", true);
        } else {
            response.put("ans", false);
        }
        return response;
    }

    @CrossOrigin
    @GetMapping(value = "/api/services")
    @ResponseBody
    public Map<String, ArrayList<String>> nameServices() {
        Map<String, ArrayList<String>> services = companyServiceService.getAllServices();
        return services;
    }

    @CrossOrigin
    @PostMapping(value = "/api/add_service")
    @ResponseBody
    public Long addService(@RequestBody Map<String, String> req) {
        String serviceName = req.get("name");
        String description = req.get("description");
        Long id = companyServiceService.addCompanyService(serviceName, description);
        return id;
    }

    @CrossOrigin
    @PostMapping(value = "/api/change_service")
    @ResponseBody
    public void changeService(@RequestBody Map<String, String> req) { 
        System.out.println(req);
        JSONObject jo = new JSONObject(req);
        companyServiceService.changeCompanyService(jo);
        return;
    }



    @CrossOrigin
    @PostMapping(value = "/api/add_event")
    @ResponseBody
    public Long addEvent(@RequestBody Map<String, String> req) {    
        Long serviceId = Long.parseLong(req.get("serviceId"));
        String rawDate = req.getOrDefault("date", "2019-12-31");
        LocalDate date = null;
        if (rawDate == "") {
            date = LocalDate.parse("2019-12-31");
        } else {
            date = LocalDate.parse(rawDate);
        }
        String description = req.get("description");
        Long id = historyService.addEvent(serviceId, date, description, "");
        return id;
    }

    @CrossOrigin
    @PostMapping(value = "/api/delete_event")
    @ResponseBody
    public void deleteEvent(@RequestBody Map<String, String> req) {
        System.out.println(req); 
        Long eventId = Long.parseLong(req.get("eventId"));
        historyService.deleteEvent(eventId);
        return;
    }

    @CrossOrigin
    @PostMapping(value = "/api/change_event")
    @ResponseBody
    public void changeEvent(@RequestBody Map<String, String> req) {
        System.out.println(req);    
        if (req.get("date") == "") {
            req.put("date", "2020-05-09");
        }
        JSONObject jo = new JSONObject(req);
        historyService.changeHistory(jo);
        return;
    }



    @CrossOrigin
    @GetMapping(value = "/api/events")
    @ResponseBody
    public Map<String, ArrayList<String>> events() {
        Map<String, ArrayList<String>> events = historyService.getAllEvents();
        return events;
    }


    @CrossOrigin
    @GetMapping(value = "/api/clients")
    @ResponseBody
    public Map<String, ArrayList<String>> clients() {
        Map<String, ArrayList<String>> clients = clientService.getAllClients();
        return clients;
    }

    @CrossOrigin
    @PostMapping(value = "/api/add_client")
    @ResponseBody
    public Long addClient(@RequestBody Map<String, String> req) {
        String name = req.getOrDefault("name", "");
        String middle_name = req.getOrDefault("middle_name", "");
        String last_name = req.getOrDefault("last_name", "");
        String address = req.getOrDefault("address", "");
        String phone_number = req.getOrDefault("phone_number", "");
        String email = req.getOrDefault("email", "");
        Long id = clientService.addClient(name, middle_name, last_name,
                                            address, phone_number, email);
        return id;
    }

    @CrossOrigin
    @PostMapping(value = "/api/change_client")
    @ResponseBody
    public void changeClient(@RequestBody Map<String, String> req) {
        System.out.println(req);    
        JSONObject jo = new JSONObject(req);
        clientService.changeClient(jo);
        return;
    }


    @CrossOrigin
    @GetMapping(value = "/api/employees")
    @ResponseBody
    public Map<String, ArrayList<String>> employees() {
        Map<String, ArrayList<String>> employees = employeeService.getAllEmployees();
        return employees;
    }

    @CrossOrigin
    @PostMapping(value = "/api/add_employee")
    @ResponseBody
    public Long addEmployee(@RequestBody Map<String, String> req) {
        String name = req.getOrDefault("name", "");
        String middle_name = req.getOrDefault("middle_name", "");
        String last_name = req.getOrDefault("last_name", "");
        String address = req.getOrDefault("address", "");
        String phone_number = req.getOrDefault("phone_number", "");
        String email = req.getOrDefault("email", "");
        String login = req.getOrDefault("login", "");
        String password = req.getOrDefault("password", "");
        String role = req.getOrDefault("role", "");
        Long id = employeeService.addEmployee(name, middle_name, last_name,
                                            address, phone_number, email,
                                            login, "", "", password, role);
        return id;
    }

    @CrossOrigin
    @PostMapping(value = "/api/change_employee")
    @ResponseBody
    public void changeEmployee(@RequestBody Map<String, String> req) {
        System.out.println(req);    
        JSONObject jo = new JSONObject(req);
        employeeService.changeEmployee(jo);
        return;
    }

    @CrossOrigin
    @PostMapping(value = "/api/delete_employee")
    @ResponseBody
    public void deleteEmployee(@RequestBody Map<String, String> req) {
        System.out.println(req); 
        Long employeeId = Long.parseLong(req.get("employeeId"));
        employeeService.deleteEmployee(employeeId);
        return;
    }




}