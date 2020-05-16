package pl.bebeauty.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bebeauty.model.Feature;

public interface FeatureRepository extends CrudRepository<Feature, Long> {
}
