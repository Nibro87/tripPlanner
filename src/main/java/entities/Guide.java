package entities;

import DTO.GuideDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name="guides")
public class Guide implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Guide_name",length = 15,nullable = false,unique = false)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="Guide_gender")
    private Gender gender;

    @Column(name="Guide_birthyear",length = 20,nullable = false,unique = false)
    private String birthYear;

    @Column(name="Guide_profil",length = 50, nullable = false,unique = false)
    private String Profile;

    @Column(name="Guide_imageurl",length = 25, nullable = false,unique = false)
    private String imgUrl;

    @OneToMany(mappedBy = "guide")
    private List<Trip> tripList;

    public Guide() {
    }

    public Guide(GuideDTO guideDTO) {
        this.name = guideDTO.getName();
        this.gender = guideDTO.getGender();
        this.birthYear = guideDTO.getBirthYear();
        Profile = guideDTO.getProfile();
        this.imgUrl = guideDTO.getImgUrl();
    }

    public Guide(String name, Gender gender, String birthYear, String profile, String imgUrl) {
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        Profile = profile;
        this.imgUrl = imgUrl;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

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
        return Profile;
    }

    public void setProfile(String profile) {
        Profile = profile;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthYear='" + birthYear + '\'' +
                ", Profile='" + Profile + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", tripList=" + tripList +
                '}';
    }
}

