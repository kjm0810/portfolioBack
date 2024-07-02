package com.my.shoppingmall.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.shoppingmall.dto.ProductDto;

@Repository
public class ProductDao {
    
    private static final String NAMESPACE = "mapper.productMapper"; // Mapper namespace 정의
    
    @Autowired
    private SqlSession sqlSession;
    
    public List<ProductDto> getAllProducts() {
        return sqlSession.selectList(NAMESPACE + ".getProductAll"); // 모든 상품 조회
    }
    
    public int insertProduct(ProductDto product) {
        return sqlSession.insert(NAMESPACE + ".insertProduct", product); // 상품 추가
    }
    
    public int updateProduct(ProductDto product) {
        return sqlSession.update(NAMESPACE + ".updateProduct", product); // 상품 수정
    }
    
    public int deleteProduct(int productId) {
        return sqlSession.delete(NAMESPACE + ".deleteProduct", productId); // 상품 삭제
    }
    
    // 기타 다른 메서드들 구현 가능
    
}
