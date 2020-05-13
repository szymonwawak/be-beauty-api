package pl.bebeauty.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Feature {
    private long id;
    private String effect;
    private String description;
    private Byte accepted;
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
    @Column(name = "effect")
    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
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
        Feature feature = (Feature) o;
        return id == feature.id &&
                Objects.equals(effect, feature.effect) &&
                Objects.equals(description, feature.description) &&
                Objects.equals(accepted, feature.accepted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, effect, description, accepted);
    }

    @ManyToMany(mappedBy = "features")
    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
