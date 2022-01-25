package DTO;

import entities.Gender;
import entities.Guide;

import java.util.List;

public class GuideDTO {

    private Long id;
    private String name;
    private Gender gender;
    private String birthYear;
    private String profil;
    private String imgUrl;

    private List<TripDTO> tripDTOList;


    public GuideDTO() {
    }

    public GuideDTO(String name, Gender gender, String birthYear, String profile, String imgUrl) {
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.profil = profile;
        this.imgUrl = imgUrl;
    }

    public GuideDTO(Guide guide) {
        if (guide.getId() != null){
            this.id = guide.getId();
        }

        this.gender = guide.getGender();
        this.birthYear = guide.getBirthYear();
        this.profil = guide.getProfile();
        this.imgUrl = guide.getImgUrl();

    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {return gender;}

    public void setGender(Gender gender) {this.gender = gender;}

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getProfile() {
        return profil;
    }

    public void setProfile(String profile) {
        this.profil = profile;
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
