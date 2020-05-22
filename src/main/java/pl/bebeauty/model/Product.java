package pl.bebeauty.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    private long id;
    private String name;
    private String manufacturer;
    private String description;
    private Double averageScore;
    private String barcode;
    private Category category;
    private List<Comment> comments;
    private List<Ingredient> ingredients;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "average_score")
    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
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
                Objects.equals(averageScore, product.averageScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, description, averageScore);
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("product")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "categories_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("products")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "product_ingredients", catalog = "", schema = "be_beauty", joinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "ingredients_id", referencedColumnName = "id", nullable = false))
    @JsonIgnoreProperties("products")
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
