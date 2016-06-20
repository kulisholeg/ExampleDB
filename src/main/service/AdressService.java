package service;

import dao.AdressDAO;
import model.Adress;
import org.json.simple.JSONObject;


public class AdressService {

    AdressDAO dao = new AdressDAO();

    public void add(JSONObject object, Integer userId) throws Exception {
        Adress adress = new Adress();
        JSONObject obj = (JSONObject) object.get("address");
        if (obj.containsKey("country")) {
            adress.setCountry((String) obj.get("country"));
        }
        if (obj.containsKey("city")) {
            adress.setCity((String) obj.get("city"));
        }
        if (obj.containsKey("street")) {
            adress.setAdress((String) obj.get("street"));
        }
        if (obj.containsKey("houseNumber")) {
            adress.setHouseNumber((Long) obj.get("houseNumber"));
        }
        if (obj.containsKey("houseSuffix")) {
            adress.setHouseSuffix((String) obj.get("houseSuffix"));
        }
        if (obj.containsKey("postCode")) {
            adress.setPostCode((Long) obj.get("postCode"));
        }
        adress.setIdUser(userId);
        dao.add(adress);
    }


    public Adress getOne(Integer id) throws Exception {
        return dao.getOne(id);
    }


}
