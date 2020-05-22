package pl.bebeauty.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {
    private long id;
    private Short score;
    private String opinion;
    private Product product;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "score")
    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    @Basic
    @Column(name = "opinion")
    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(score, comment.score) &&
                Objects.equals(opinion, comment.opinion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score, opinion);
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "products_id", referencedColumnName = "id", nullable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
