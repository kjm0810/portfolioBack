package com.my.shoppingmall.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.shoppingmall.dto.CategoryDto;

@Repository
public class CategoryDao {
    
    private static final String NAMESPACE = "mapper.categoryMapper"; // Mapper namespace 정의
    
    @Autowired
    private SqlSession sqlSession;
    
    public List<CategoryDto> getCategoryAll() {
        return sqlSession.selectList(NAMESPACE + ".getCategoryAll"); // Mapper XML에 정의된 쿼리 ID 호출
    }
    
    // 다른 메서드들 구현
}
