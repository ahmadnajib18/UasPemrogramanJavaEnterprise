package repository

import model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository extends JpaRepository<Category, Integer> {
 List<Category> findAll()
 Category findById(int id)
 Category save(Category category)
 void delete(Category category)
}
