package DTO;

import java.util.List;

public class UserDTO {

    private String userName;
    private String password;

    private List<TripDTO> tripDTOList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
