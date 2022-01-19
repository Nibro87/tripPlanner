package entities;

import javax.persistence.*;
import java.util.List;

@Entity(name="trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="Trip_name", length=25, nullable = false,unique = false )
    private String name;

    @Column(name="Trip_date", length=25, nullable = false,unique = false)
    private String date;

    @Column(name="Trip_time", length=25, nullable = false,unique = false)
    private String time;

    @Column(name="Trip_location", length=25, nullable = false,unique = false)
    private String location;

    @Column(name="Trip_duration", length=25, nullable = false,unique = false)
    private String duration;

    @Column(name="Trip_packinglist", length=25, nullable = false,unique = false)
    private String packingList;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> userList;

    @ManyToOne(fetch = FetchType.LAZY)
    private Guide guide;

    public Trip() {
    }

    public Trip(String name, String date, String time, String location, String duration, String packingList) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.duration = duration;
        this.packingList = packingList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", duration='" + duration + '\'' +
                ", packingList='" + packingList + '\'' +
                ", userList=" + userList +
                ", guide=" + guide +
                '}';
    }
}
