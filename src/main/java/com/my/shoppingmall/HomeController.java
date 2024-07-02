package com.my.shoppingmall;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.my.shoppingmall.dao.CategoryDao;
import com.my.shoppingmall.dao.ProductDao;
import com.my.shoppingmall.dto.CategoryDto;
import com.my.shoppingmall.dto.ProductDto;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {

    private final ProductDao productDao;
    private final CategoryDao categoryDao;
    private final ObjectMapper objectMapper;

    @Autowired
    public HomeController(ProductDao productDao, CategoryDao categoryDao, ObjectMapper objectMapper) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.objectMapper = objectMapper;
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // 날짜를 타임스탬프로 변환하지 않도록 설정
        this.objectMapper.setDateFormat(new SimpleDateFormat("yyyyMMdd")); // 원하는 날짜 포맷 설정
    }

    @GetMapping(value = "/getAllProduct", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getAllProduct() {
        try {
            ArrayList<ProductDto> products = (ArrayList<ProductDto>) productDao.getAllProducts();
            return objectMapper.writeValueAsString(products);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error converting products to JSON";
        }
    }

    @GetMapping(value = "/getCategoryAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getCategoryAll() {
        try {
            ArrayList<CategoryDto> categories = (ArrayList<CategoryDto>) categoryDao.getCategoryAll();
            return objectMapper.writeValueAsString(categories);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error converting categories to JSON";
        }
    }
    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addProduct(@RequestBody ProductDto productDto) {
        try {
            int result = productDao.insertProduct(productDto);
            if (result > 0) {
                return "Product added successfully";
            } else {
                return "Failed to add product";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error adding product";
        }
    }
    @PutMapping(value = "/updateProduct/{productIdx}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String updateProduct(@PathVariable Long productIdx, @RequestBody ProductDto productDto) {
        try {
            productDto.setProductIdx(productIdx); // 경로 변수에서 상품 인덱스 가져와 설정
            int result = productDao.updateProduct(productDto);
            if (result > 0) {
                return "Product updated successfully";
            } else {
                return "Failed to update product";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating product";
        }
    }

}
