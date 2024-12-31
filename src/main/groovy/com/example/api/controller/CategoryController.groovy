package controller

import model.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import service.CategoryService

@RestController
@RequestMapping("/categories")
class CategoryController {

    @Autowired
    CategoryService categoryService

    @GetMapping('')
        List<Category> findAll() {
        categoryService.findAll()
    }

    @GetMapping('{id}')
    Category findById(@PathVariable('id') int id) {
        return categoryService.findById(id)
    }

    @PostMapping
    Category save(@RequestBody Category category) {
        return categoryService.save(category)
    }

    @PutMapping('{id}')
    Category update(@RequestBody Category category, @PathVariable('id') int id) {
        return categoryService.update(category, id)
    }

    @DeleteMapping('{id}')
    Category delete(@PathVariable('id') int id) {
        return categoryService.delete(id)
    }
}
