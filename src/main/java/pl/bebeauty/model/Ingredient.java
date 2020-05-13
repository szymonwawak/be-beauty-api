package pl.bebeauty.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    private long id;
    private String name;
    private Byte accepted;
    private Collection<Product> products;
    private Collection<Feature> features;

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
        Ingredient that = (Ingredient) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(accepted, that.accepted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accepted);
    }

    @ManyToMany
    @JoinTable(name = "ingredient_features", catalog = "", schema = "be_beauty", joinColumns = @JoinColumn(name = "ingredients_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "features_id", referencedColumnName = "id", nullable = false))
    public Collection<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Collection<Feature> features) {
        this.features = features;
    }

    @ManyToMany(mappedBy = "ingredients")
    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
