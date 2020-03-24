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

    public JSONObject getAllEvents() {
        JSONObject jo = new JSONObject();
        historyRepository.findAll().forEach((event) -> {
            List<String> params = new ArrayList<>();
            Long serviceId = event.getServiceId();
            CompanyService companyService = companyServiceRepository.findById(serviceId).get();
            String serviceName = companyService.getServiceName();
            LocalDate date = event.getDate();
            String contract = event.getContract();
            params.add(serviceName);
            params.add(date.toString());
            params.add(contract);
            jo.put(Long.toString(event.getHistoryId()), new JSONArray(params));
        });
        return jo;
    }

}
