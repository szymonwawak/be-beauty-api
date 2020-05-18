package pl.bebeauty.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "products")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = Product.class, property = "id")
public class Product {
    private long id;
    private String name;
    private String manufacturer;
    private String description;
    private Integer volume;
    private Byte averageScore;
    private Boolean accepted;
    private String barcode;
    private User user;
    private Category category;
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
    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Basic
    @Column(name = "barcode")
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("products")
    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categories_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("products")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToMany
    @JoinTable(name = "product_ingredients", catalog = "", schema = "be_beauty", joinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "ingredients_id", referencedColumnName = "id", nullable = false))
    @JsonIgnoreProperties("products")
    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
