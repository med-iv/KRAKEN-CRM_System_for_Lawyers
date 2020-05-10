package main.services;

import main.model.Client;
import main.model.History;
import main.repos.ClientRepository;
import main.repos.HistoryRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private HistoryRepository historyRepository;

    public Long addClient(String name, String middle_name, String last_name,
                     String address, String phone_number, String email) {
        Client client = new Client();
        client.setName(name);
        client.setMiddleName(middle_name);
        client.setLastName(last_name);
        client.setAddress(address);
        client.setPhoneNumber(phone_number);
        client.setEmail(email);
        clientRepository.save(client);
        return client.getClientId();
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public Optional<Long> changeClient(JSONObject jo) {
        if (!jo.has("id")) {
            return Optional.empty();
        }
        Long id = Long.valueOf(jo.getString("id"));
        if (!clientRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        Client client = clientRepository.findById(id).get();
        if (jo.has("name")) {
            client.setName(jo.getString("name"));
        }
        if (jo.has("middleName")) {
            client.setMiddleName(jo.getString("middleName"));
        }

        if (jo.has("lastName")) {
            client.setLastName(jo.getString("lastName"));
        }

        if (jo.has("phoneNumber")) {
            client.setPhoneNumber(jo.getString("phoneNumber"));
        }

        if (jo.has("address")) {
            client.setAddress(jo.getString("address"));
        }

        if (jo.has("email")) {
            client.setEmail(jo.getString("email"));
        }

        if (jo.has("histories")) {
            List<History> histories = new ArrayList<>();
            JSONArray ja = new JSONArray(jo.getString("histories"));
            ja.toList().forEach((sEventId) -> {
                Long eventId = Long.valueOf(sEventId.toString());
                histories.add(historyRepository.findById(eventId).get());
            });
            client.setHistories(histories);
        }
        clientRepository.save(client);
        return Optional.of(id);
    }

    public JSONObject getProfile(Long clientId) {
        JSONObject jo = new JSONObject();
        Optional <Client> optClient = clientRepository.findById(clientId);
        if (!optClient.isPresent()) {
            return jo;
        }
        Client client = optClient.get();
        jo.put("name", client.getName());
        jo.put("middleName", client.getMiddleName());
        jo.put("lastName", client.getLastName());
        jo.put("address", client.getAddress());
        jo.put("phoneNumber", client.getPhoneNumber());
        jo.put("email", client.getEmail());
        return jo;
    }

    public Map<String, ArrayList<String>> getAllClients() {
        Map<String, ArrayList<String>> jo = new HashMap<String, ArrayList<String>>();
        clientRepository.findAll().forEach((client) -> {
            ArrayList<String> params = new ArrayList<>();
            String name = client.getName();
            String middle_name = client.getMiddleName();
            if (middle_name == null) {
                middle_name = "";
            }
            String last_name = client.getLastName();
            String phone_number = client.getPhoneNumber();
            if (phone_number == null) {
                phone_number = "";
            }
            String email = client.getEmail();
            if (email == null) {
                email = "";
            }
            String address = client.getAddress();
            if (address == null){
                address = "";
            }
            params.add(name);
            params.add(middle_name);
            params.add(last_name);
            params.add(phone_number);
            params.add(email);
            params.add(address);
            jo.put(Long.toString(client.getClientId()), params);
        });
        return jo;
    }

    public JSONObject getAllClientsByEvent(Long eventId) {
        JSONObject jo = new JSONObject();
        clientRepository.findByHistories_EventId(eventId).forEach((client) -> {
            String name = client.getName();
            String last_name = client.getLastName();
            jo.put(Long.toString(client.getClientId()), name + " " + last_name);
        });
        return jo;
    }

    public JSONObject getAllClientsByDates(LocalDate date1, LocalDate date2) {
        JSONObject jo = new JSONObject();
        List<Long> eventIds = new ArrayList<>();

        historyRepository.findByDateBetween(date1, date2).forEach((history) -> {
            System.out.println(history.getHistoryId());
            eventIds.add(history.getHistoryId());
        });
        //System.out.println(eventIds);

        clientRepository.findAllByHistories_EventIdIn(eventIds).forEach((employee) -> {
            String name = employee.getName();
            String last_name = employee.getLastName();
            jo.put(Long.toString(employee.getClientId()), name + " " + last_name);
        });
        return jo;
    }
}
