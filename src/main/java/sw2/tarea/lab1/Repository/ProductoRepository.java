package sw2.tarea.lab1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw2.tarea.lab1.Entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
