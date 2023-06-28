package com.gaoming.service_20211015_114634.impl;

import com.gaoming.mapper.BrandMapper;
import com.gaoming.pojo.Brand;
import com.gaoming.pojo.PageBean;
import com.gaoming.service_20211015_114634.BrandService;
import com.gaoming.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    //创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        List<Brand> brands = mapper.selectAll();



        //释放资源
        sqlSession.close();

        return brands;
    }

    public PageBean<Brand> selectAll2(Brand brand) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.计算开始索引

        //5.查询当前页数据
        List<Brand> rows = mapper.selectAll2(brand);
        //6.查询总记录条数
        int totalCount = mapper.selectTotalCountByCondition(brand);
        //7.封装PageBean
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        //8.释放资源
        sqlSession.close();
        return pageBean;
    }

    @Override
    public void add(Brand brand) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.add(brand);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();



    }

    @Override
    public void deleteByIds(int[] ids) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.deleteByIds(ids);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 查询条数
        int size = pageSize;
        //5.查询当前页数据
        List<Brand> rows = mapper.selectByPage(begin, size);
        //6.查询总记录条数
        int totalCount = mapper.selectTotalCount();
        //7.封装PageBean
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        //8.释放资源
        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 查询条数
        int size = pageSize;

        //处理brand条件，实现模糊表达式
        String brandName = brand.getBrandName();
        if(brandName != null && brandName.length() > 0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if(companyName != null && companyName.length() > 0){
            brand.setCompanyName("%"+companyName+"%");
        }



        //5.查询当前页数据
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size,brand);
        //6.查询总记录条数
        int totalCount = mapper.selectTotalCountByCondition(brand);
        //7.封装PageBean
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        //8.释放资源
        sqlSession.close();
        return pageBean;
    }


    @Override
    public void update(Brand brand) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.update(brand);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();


    }

    @Override
    public  List<Brand> selectByBrandName(String brandName) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        List<Brand> brands = mapper.selectByBrandName(brandName);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();

        return brands;



    }


}
