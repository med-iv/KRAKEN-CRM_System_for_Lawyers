package main.services;

import main.model.CompanyService;
import main.repos.CompanyServiceRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceService {
    @Autowired
    private CompanyServiceRepository serviceRepository;

    public Long addCompanyService(String serviceName, String description) {
        CompanyService companyService = new CompanyService();
        companyService.setServiceName(serviceName);
        companyService.setDescription(description);
        serviceRepository.save(companyService);
        return companyService.getServiceId();
    }

    public void deleteCompanyService(Long companyServiceId) {
        serviceRepository.deleteById(companyServiceId);
    }

    public Optional<Long> changeCompanyService(JSONObject jo) {
        if (!jo.has("id")) {
            return Optional.empty();
        }
        Long id = Long.valueOf(jo.getString("id"));
        if (!serviceRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        CompanyService companyService = serviceRepository.findById(id).get();
        if (jo.has("serviceName")) {
            companyService.setServiceName(jo.getString("serviceName"));
        }
        if (jo.has("description")) {
            companyService.setDescription(jo.getString("description"));
        }
        serviceRepository.save(companyService);
        return Optional.of(id);
    }

    public JSONObject getAllServices() {
        JSONObject jo = new JSONObject();
        serviceRepository.findAll().forEach((service) -> {
            List<String> params = new ArrayList<>();
            Long serviceId = service.getServiceId();
            CompanyService companyService = serviceRepository.findById(serviceId).get();
            String serviceName = companyService.getServiceName();
            String description = service.getDescription();
            params.add(serviceName);
            params.add(description);
            jo.put(Long.toString(service.getServiceId()), new JSONArray(params));
        });
        return jo;
    }


}
