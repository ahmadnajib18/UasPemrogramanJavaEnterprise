package service.impl

import model.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.CategoryRepository
import service.CategoryService

@Service
class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository

    @Override
    List<Category> findAll() {
        return categoryRepository.findAll()
    }

    @Override
    Category findById(int id) {
        return categoryRepository.findById(id).orElse(null)
    }

    @Override
    Category save(Category category) {
        return categoryRepository.save(category)
    }

    @Override
    Category update(Category category, int id) {
        def record = categoryRepository.findById(id).orElseThrow {
            new RuntimeException("Category with ID $id not found")
        }

        // Perbarui nilai pada record
        record.name = category.name
        record.description = category.description

        // Simpan perubahan
        return categoryRepository.save(record)
    }

    @Override
    Category delete(int id) {
        def record = categoryRepository.findById(id)
        categoryRepository.delete(record)
        return record
    }
}
