package DTO;

import java.util.List;

public class GuideDTO {

    private long id;
    private String name;
    private String gender;
    private String birthYear;
    private String profile;
    private String imgUrl;

    private List<TripDTO> tripDTOList;


    public GuideDTO() {
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<TripDTO> getTripDTOList() {
        return tripDTOList;
    }

    public void setTripDTOList(List<TripDTO> tripDTOList) {
        this.tripDTOList = tripDTOList;
    }

}
