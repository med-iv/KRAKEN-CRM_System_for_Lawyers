// import static org.assertj.core.api.Assertions.*;

// import org.json.JSONException;
// import org.junit.jupiter.api.*;
// import org.springframework.boot.test.context.*;
// import org.springframework.beans.factory.annotation.*;

// import main.services.EmployeeService;
// import main.Main;

// import org.json.JSONObject;

// import java.util.Map;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Iterator;
// import java.time.LocalDate;



// @SpringBootTest(classes = Main.class)
// public class EmployeeService_test {
//     @Autowired
//     private EmployeeService service;

//     @Test
//     public void test_getAllEmployees() {
//         JSONObject jo = service.getAllEmployees();
//         System.out.println(jo);

//         HashMap<String, String> resp = new HashMap<String, String>();
//         Iterator<String> keys = jo.keys();
//         while(keys.hasNext()) {
//             String key = keys.next();
//             try {
//                 resp.put(key, String.valueOf(jo.get(key)));
//             } catch (JSONException e) {
//                 e.printStackTrace();
//             }
//         }

//         HashMap<String, String> answer = new HashMap<>();
//         answer.put("0", "admin admin");
//         answer.put("1", "Геральд Ривов");
//         answer.put("2", "Владимир Иванов");
//         answer.put("3", "Василий Кустиков");

//         assertThat(resp).isEqualTo(answer);
//     }

//     @Test
//     public void test_getAllEmployeesByEvent() {
//         JSONObject jo = service.getAllEmployeesByEvent(2L);
//         System.out.println(jo);

//         HashMap<String, String> resp = new HashMap<String, String>();
//         Iterator<String> keys = jo.keys();
//         while(keys.hasNext()) {
//             String key = keys.next();
//             try {
//                 resp.put(key, String.valueOf(jo.get(key)));
//             } catch (JSONException e) {
//                 e.printStackTrace();
//             }
//         }

//         HashMap<String, String> answer = new HashMap<>();
//         answer.put("1", "Геральд Ривов USER");

//         assertThat(resp).isEqualTo(answer);
//     }

//     @Test
//     public void test_getAllEmployeesByDates() {
//         LocalDate date1 = LocalDate.of(2019, 12, 1);
//         LocalDate date2 = LocalDate.of(2020, 12, 31);
//         JSONObject jo = service.getAllEmployeesByDates(date1 ,date2);
//         System.out.println(jo);

//         HashMap<String, String> resp = new HashMap<String, String>();
//         Iterator<String> keys = jo.keys();
//         while(keys.hasNext()) {
//             String key = keys.next();
//             try {
//                 resp.put(key, String.valueOf(jo.get(key)));
//             } catch (JSONException e) {
//                 e.printStackTrace();
//             }
//         }

//         HashMap<String, String> answer = new HashMap<>();
//         answer.put("2", "Владимир Иванов");
//         answer.put("3", "Василий Кустиков");

//         assertThat(resp).isEqualTo(answer);
//     }
// }
