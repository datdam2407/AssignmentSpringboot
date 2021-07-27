package com.datdt.AssignmentSpringboot.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.datdt.AssignmentSpringboot.entity.Cart;
import com.datdt.AssignmentSpringboot.entity.Category;
import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.exception.NotFoundException;
import com.datdt.AssignmentSpringboot.repository.CategoryRepository;
import com.datdt.AssignmentSpringboot.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
 
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    Date currentDate = new Date();

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }
    public List<Product> getAllProduct(){
            return this.productRepository.findAll();    
    }
    // public Page<Product> getAllProduct(Optional<Integer> page, Optional<String> sortBy) {
    //     return (Page<Product>) this.productRepository.findAll(PageRequest.of(page.orElse(0), 2, Sort.Direction.ASC, sortBy.orElse("productID")));
    // }
    //get product by ID
    public ResponseEntity<Product> getProductByID(Long productID)throws NotFoundException{
        Product product = productRepository.findById(productID)
                .orElseThrow(() -> new NotFoundException(productID));
            return ResponseEntity.ok().body(product);
    }

    public List<Product> findAllProductsByCateId(long categoryID) {
        return this.productRepository.findAllProductsByCategoryID(categoryID);
    }
    public List<Product> findAllProductsActive() {
        return this.productRepository.findActiveProduct();
    }
    
    // create product follow cateID
    public Product createProduct(Product newProduct, long categoryID) throws Exception {
        Category category = categoryRepository.findCateById(categoryID);
        if (category == null) {
            throw new Exception("Category Not Found!!");
        }
        newProduct.setCreateDate(currentDate);
        newProduct.setUpdateDate(currentDate);
        newProduct.setCategory(category);
        newProduct.setCartQuantity(0);
        newProduct.setProductStatus("ACTIVE");
        return this.productRepository.save(newProduct);

    }
    //update product
    public ResponseEntity<Product> updateProduct(Long productID, Product productDetail){
        Product product = productRepository.findById(productID)
                .orElseThrow(() -> new NotFoundException(productID));     
            product.setProductName(productDetail.getProductName());
            product.setProductDiscription(productDetail.getProductDiscription());
            product.setProductImage(productDetail.getProductImage());
            product.setCategory(productDetail.getCategory());
            product.setProductStatus(productDetail.getProductStatus());
            product.setProductPrice(productDetail.getProductPrice());
            product.setUpdateDate(currentDate);
            product.setProductQuantity(productDetail.getProductQuantity());

            return ResponseEntity.ok(this.productRepository.save(product));
    }
    //Delete products
    public Map<String, Boolean> deleteProduct(Long productID){
        Product product = productRepository.findById(productID)
                .orElseThrow(() -> new NotFoundException(productID));
            this.productRepository.deleteProduct(productID);
            Map<String, Boolean> response = new HashMap<>();
            response.put("DELETED", Boolean.TRUE);
            System.out.println(product);
            return response;
    }

    //Find product by categoryID
    public List<Product> findAllProductsByCategoryID(long categoryID){
            return this.productRepository.findAllProductsByCategoryID(categoryID);
    }
    //
    public Map<String, Boolean> setCategoryOfProductIsDeleted(Product product){
            product.setCategory(null);
            this.productRepository.save(product);
            Map<String, Boolean> response = new HashMap<>();
            response.put("Set NULL", Boolean.TRUE);
            return response;
    }
    //Updating quantity from cart
    public Cart updateQuantity(HttpSession session) throws Exception {
        Cart shoppingCart = (Cart) session.getAttribute("shCart");
        if (shoppingCart == null) {
            throw new Exception("Cart Empty!!");
        }

        for (Product cartProduct : shoppingCart.getCart().values()) {
            Product product = productRepository.findProductById(cartProduct.getProductID());
            int storage = product.getProductQuantity();
            int CartQuantity = cartProduct.getCartQuantity();
            int remain = storage - CartQuantity;
            this.productRepository.updateQuantity(remain, cartProduct.getProductID());
        }
        session.removeAttribute("shCart");
        return shoppingCart;
    }
}

