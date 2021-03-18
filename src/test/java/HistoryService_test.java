import static org.assertj.core.api.Assertions.*;

import main.model.History;
import main.repos.HistoryRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import org.springframework.boot.test.context.*;

import org.springframework.beans.factory.annotation.*;

import main.services.HistoryService;

import main.Main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;


@SpringBootTest(classes = Main.class)
public class HistoryService_test {
    @Autowired
    private HistoryService service;
    @Autowired
    private HistoryRepository historyRepository;


    @Test
    public void test_changeHistory() {
        History event1 = historyRepository.findById(1L).get();
        String description = "Аренда квартиры в Хамовниках";
        String date = "2019-12-02";

        JSONObject jo = new JSONObject();
        try {
            jo.put("id", "1");
            jo.put("description", description);
            jo.put("date", date);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        service.changeHistory(jo);


        History event2 = historyRepository.findById(1L).get();
        String nDesc = event2.getDescription();
        LocalDate nDate = event2.getDate();
        assertThat(description).isEqualTo(nDesc);
        assertThat(LocalDate.parse(date)).isEqualTo(nDate);
    }

    @Test
    public void test_getAllEvents() {
        JSONObject jo = service.getAllEvents();
        HashMap<String, HashMap<String, String>> resp = new HashMap<>();
        Iterator<String> keys = jo.keys();
        while(keys.hasNext()) {
            String key = keys.next();
            try {
                HashMap<String, String> tmp = new HashMap<>();
                JSONArray ja = new JSONArray(jo.getString(key));
                tmp.put("serviceName", ja.getString(0));
                tmp.put("date", ja.getString(1));
                tmp.put("contract", ja.getString(2));
                resp.put(key, tmp);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        HashMap<String, HashMap<String, String>> answer = new HashMap<>();

        HashMap<String, String> hm1 = new HashMap<>();
        hm1.put("serviceName", "Simple Real Estate Lease");
        hm1.put("date", "2019-12-01");
        hm1.put("contract", "file:///kvartira_butovo.docx");
        answer.put("1", hm1);

        HashMap<String, String> hm2 = new HashMap<>();
        hm2.put("serviceName", "Marriage Separation Agreement");
        hm2.put("date", "2019-09-05");
        hm2.put("contract", "file:///razvod_ivanovs.docx");
        answer.put("2", hm2);

        HashMap<String, String> hm3 = new HashMap<>();
        hm3.put("serviceName", "Bankruptcy Worksheet");
        hm3.put("date", "2019-12-31");
        hm3.put("contract", "file:///bankrot_shlyapik.docx");
        answer.put("3", hm3);

        assertThat(resp).isEqualTo(answer);
    }
}
