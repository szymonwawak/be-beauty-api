package pl.bebeauty.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    private long id;
    private String name;
    private String manufacturer;
    private String description;
    private Integer volume;
    private Byte averageScore;
    private Byte accepted;
    private User user;
    private Collection<Comment> comments;
    private Collection<Ingredient> ingredients;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "volume")
    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "average_score")
    public Byte getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Byte averageScore) {
        this.averageScore = averageScore;
    }

    @Basic
    @Column(name = "accepted")
    public Byte getAccepted() {
        return accepted;
    }

    public void setAccepted(Byte accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name) &&
                Objects.equals(manufacturer, product.manufacturer) &&
                Objects.equals(description, product.description) &&
                Objects.equals(volume, product.volume) &&
                Objects.equals(averageScore, product.averageScore) &&
                Objects.equals(accepted, product.accepted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, description, volume, averageScore, accepted);
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "product")
    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    @ManyToMany
    @JoinTable(name = "product_ingredients", catalog = "", schema = "be_beauty", joinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "ingredients_id", referencedColumnName = "id", nullable = false))
    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
