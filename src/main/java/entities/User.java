package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "user_name", length = 25)
  private String userName;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "user_pass")
  private String userPass;
  @Basic(optional = false)
  @NotNull
  @Column(name = "email")
  private String email;
  @JoinTable(name = "user_roles", joinColumns = {
          @JoinColumn(name = "user_name", referencedColumnName = "user_name")}, inverseJoinColumns = {
          @JoinColumn(name = "role_name", referencedColumnName = "role_name")})
  @ManyToMany
  private List<Role> roleList = new ArrayList<>();




  public List<String> getRolesAsStrings() {
    if (roleList.isEmpty()) {
      return null;
    }
    List<String> rolesAsStrings = new ArrayList<>();
    roleList.forEach((role) -> {
      rolesAsStrings.add(role.getRoleName());
    });
    return rolesAsStrings;
  }

  public User() {}

  //TODO Change when password is hashed
  public boolean verifyPassword(String pw){
    return(BCrypt.checkpw(pw,userPass));
  }

  public User(String userName, String userPass, String email) {
    this.userName = userName;
    this.userPass = BCrypt.hashpw(userPass,BCrypt.gensalt());
    this.email = email;
  }

   public User (User user){
    this.userName = user.getUserName();
   this.email = user.getEmail();
  }


@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
private List<SharedArticles> sharedArticlesList;






  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPass() {
    return this.userPass;
  }

  public void setUserPass(String userPass) {
    this.userPass = userPass;
  }

  public List<Role> getRoleList() {
    return roleList;
  }

  public void setRoleList(List<Role> roleList) {
    this.roleList = roleList;
  }

  public void addRole(Role userRole) {
    roleList.add(userRole);
  }

  public String getEmail() {return email;}

  public void setEmail(String email) {this.email = email;}

  public List<SharedArticles> getSharedArticlesList() {return sharedArticlesList;}

  public void setSharedArticlesList(List<SharedArticles> sharedArticlesList) {this.sharedArticlesList = sharedArticlesList;}

  public void addArticle(SharedArticles sharedArticles){

    sharedArticlesList.add(sharedArticles);}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getUserPass(), user.getUserPass()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getRoleList(), user.getRoleList());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUserName(), getUserPass(), getEmail(), getRoleList());
  }

  @Override
  public String toString() {
    return "User{" +
            "userName='" + userName + '\'' +
            ", userPass='" + userPass + '\'' +
            ", roleList=" + roleList +
            '}';
  }
}
