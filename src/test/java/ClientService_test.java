// import static org.assertj.core.api.Assertions.*;

// import org.json.JSONException;
// import org.json.JSONObject;
// import org.junit.jupiter.api.*;

// import org.springframework.boot.test.context.*;

// import org.springframework.beans.factory.annotation.*;

// import main.services.ClientService;

// import main.Main;

// import java.time.LocalDate;
// import java.util.HashMap;
// import java.util.Iterator;


// @SpringBootTest(classes = Main.class)
// public class ClientService_test {
//     @Autowired
//     private ClientService service;


//     @Test
//     public void testBean() {
//         assertThat(service).isNotNull();
//         //service.addClient("Иван", "", "Медведев", "", "", "");
//     }

//     @Test
//     public void test_getAllClient() {
//         JSONObject jo = service.getAllClients();
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
//         answer.put("1", "Дмитрий Иванов");
//         answer.put("2", "Ольга Иванова");
//         answer.put("3", "Татьяна Финкельман");
//         answer.put("4", "Александр Шляпик");

//         assertThat(resp).isEqualTo(answer);
//     }

//     @Test
//     public void test_getAllEmployeesByEvent() {
//         JSONObject jo = service.getAllClientsByEvent(2L);
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
//         answer.put("1", "Дмитрий Иванов");
//         answer.put("2", "Ольга Иванова");

//         assertThat(resp).isEqualTo(answer);
//     }

//     @Test
//     public void test_getAllEmployeesByDates() {
//         LocalDate date1 = LocalDate.of(2019, 12, 1);
//         LocalDate date2 = LocalDate.of(2020, 12, 31);
//         JSONObject jo = service.getAllClientsByDates(date1 ,date2);
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
//         answer.put("3", "Татьяна Финкельман");
//         answer.put("4", "Александр Шляпик");

//         assertThat(resp).isEqualTo(answer);
//     }
// }
