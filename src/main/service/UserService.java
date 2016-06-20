package service;


import dao.UserDAO;
import model.User;
import org.json.simple.JSONObject;
import utils.ParamUtils;

import java.util.Date;
import java.util.List;

public class UserService {

    // Создаем инстанс ДАО
    private UserDAO dao = new UserDAO();

    public void remove(Integer id) throws Exception {
        dao.remove(id);
    }


    public void add(JSONObject object) throws Exception {
        User user = new User();

        if(object.containsKey("firstName")){
            user.setName((String) object.get("firstName"));
        }
        if(object.containsKey("lastName")){
            user.setLastName((String) object.get("lastName"));
        }

        if(object.containsKey("birthday")){
            user.setBirthday(ParamUtils.parseStringToDate((String) object.get("birthday")));
        }
        if(object.containsKey("photoPath")){
            user.setPhotoPath((String) object.get("photoPath"));
        }

        dao.add(user);
    }


    public User getOne(Integer id) throws Exception {
        return dao.getOne(id);
    }


    public List<User> getMany() throws Exception {
        return dao.getMany();
    }

}
