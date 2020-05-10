// import static org.assertj.core.api.Assertions.*;

// import main.model.CompanyService;
// import org.json.JSONArray;
// import org.json.JSONException;
// import org.json.JSONObject;
// import org.junit.jupiter.api.*;

// import org.springframework.boot.test.context.*;

// import org.springframework.beans.factory.annotation.*;

// import main.services.CompanyServiceService;

// import main.Main;

// import java.time.LocalDate;
// import java.util.HashMap;
// import java.util.Iterator;
// import java.util.Map;
// import java.util.ArrayList;


// @SpringBootTest(classes = Main.class)
// public class CompanyServiceService_test {
//     @Autowired
//     private CompanyServiceService service;
//     @Test
//     public void test_getAllServices() {
//         Map<String, ArrayList<String>> jo = service.getAllServices();
//         HashMap<String, HashMap<String, String>> resp = new HashMap<>();
//         Iterator<String> keys = jo.keys();
//         while(keys.hasNext()) {
//             String key = keys.next();
//             try {
//                 HashMap<String, String> tmp = new HashMap<>();
//                 JSONArray ja = new JSONArray(jo.getString(key));
//                 tmp.put("serviceName", ja.getString(0));
//                 resp.put(key, tmp);
//             } catch (JSONException e) {
//                 e.printStackTrace();
//             }
//         }
//         HashMap<String, HashMap<String, String>> answer = new HashMap<>();

//         HashMap<String, String> hm2 = new HashMap<>();
//         hm2.put("serviceName", "Marriage Separation Agreement");
//         answer.put("1", hm2);

//         HashMap<String, String> hm1 = new HashMap<>();
//         hm1.put("serviceName", "Simple Real Estate Lease");
//         answer.put("2", hm1);

//         HashMap<String, String> hm3 = new HashMap<>();
//         hm3.put("serviceName", "Power of Attorney");
//         answer.put("3", hm3);

//         HashMap<String, String> hm4 = new HashMap<>();
//         hm4.put("serviceName", "Bankruptcy Worksheet");
//         answer.put("4", hm4);

//         assertThat(resp).isEqualTo(answer);
//     }
// }