package main.services;

import main.model.History;
import main.model.CompanyService;
import main.repos.HistoryRepository;
import main.repos.CompanyServiceRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private CompanyServiceRepository companyServiceRepository;

    public Long addEvent(Long serviceId, LocalDate date, String description,
                          String contract) {
        History history = new History();
        history.setServiceId(serviceId);
        history.setDate(date);
        history.setDescription(description);
        history.setContract(contract);
        historyRepository.save(history);
        return history.getHistoryId();
    }

    public void deleteEvent(Long eventId) {
        historyRepository.deleteById(eventId);
    }

    public Optional<Long> changeHistory(JSONObject jo) {
        if (!jo.has("id")) {
            return Optional.empty();
        }
        Long id = Long.valueOf(jo.getString("id"));
        if (!historyRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        History companyService = historyRepository.findById(id).get();
        if (jo.has("serviceId")) {
            companyService.setServiceId(Long.valueOf(jo.getString("serviceId")));
        }
        if (jo.has("date")) {
            companyService.setDate(LocalDate.parse(jo.getString("date")));
        }
        if (jo.has("description")) {
            companyService.setDescription(jo.getString("description"));
        }

        if (jo.has("contract")) {
            companyService.setContract(jo.getString("contract"));
        }
        historyRepository.save(companyService);
        return Optional.of(id);
    }

    public Map<String, ArrayList<String>> getAllEvents() {
        Map<String, ArrayList<String>> jo = new HashMap<String, ArrayList<String>>();
        historyRepository.findAll().forEach((event) -> {
            ArrayList<String> params = new ArrayList<>();
            Long serviceId = event.getServiceId();
            CompanyService companyService = companyServiceRepository.findById(serviceId).get();
            String serviceName = companyService.getServiceName();
            LocalDate date = event.getDate();
            String description = event.getDescription();
            params.add(serviceName);
            params.add(date.toString());
            params.add(description);
            jo.put(Long.toString(event.getHistoryId()), params);
        }); 
        return jo;
    }

}
