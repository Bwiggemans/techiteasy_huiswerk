package nl.novi.TechItEasy.repository;

import nl.novi.TechItEasy.model.Television;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TelevisionRepository extends CrudRepository<Television, Integer> {

    Iterable<Television> findAllByBrand(String brand);
    Iterable<Television> findAllByBrandContainingIgnoreCase(String brand);

 /*   @Query("SELECT * FROM Televisions b WHERE b.brand LIKE %:s%")
    Iterable<Television> searchByBrandLike(@Param("s") String s);
  */

    @Query(value = "SELECT * FROM televisions b WHERE b.brand LIKE %:s%", nativeQuery = true) // using SQL
    Iterable<Television> searchByBrandLike(@Param("s") String s);
}
