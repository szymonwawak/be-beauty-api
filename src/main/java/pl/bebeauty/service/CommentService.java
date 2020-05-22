package pl.bebeauty.service;

import org.springframework.stereotype.Service;
import pl.bebeauty.model.Comment;
import pl.bebeauty.model.Product;
import pl.bebeauty.repository.ProductRepository;

import java.util.List;

@Service
public class CommentService {
    private ProductRepository productRepository;

    public CommentService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void setProductTotalScore(Comment comment) {
        long productId = comment.getProduct().getId();
        Product product = productRepository.findById(productId).get();
        List<Comment> comments = product.getComments();
        double scoreSum = comments.stream().mapToDouble(Comment::getScore).sum();
        product.setAverageScore(scoreSum / comments.size());
        productRepository.save(product);
    }
}
