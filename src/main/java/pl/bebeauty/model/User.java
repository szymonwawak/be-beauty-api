package pl.bebeauty.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    private long id;
    private String nickname;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Collection<Role> roles;
    private Collection<Comment> comments;
    private Collection<Product> products;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, name, surname, email);
    }

    @ManyToMany
    @JoinTable(name = "user_roles", catalog = "", schema = "be_beauty", joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id", nullable = false))
    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> users) {
        this.roles = users;
    }

    @OneToMany(mappedBy = "user")
    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
