package entities;

import javax.persistence.*;
import java.util.List;

@Entity(name="guides")
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Guide_name",length = 15,nullable = false,unique = false)
    private String name;

    @Column(name="Guide_gender",length = 10,nullable = false,unique = false)
    private String gender;

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

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

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
}

