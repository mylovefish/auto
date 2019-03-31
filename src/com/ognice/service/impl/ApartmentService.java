/**
 *
 */
package com.ognice.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.dao.ApartmentMapper;
import com.ognice.domain.Apartment;
import com.ognice.service.IApartmentService;
/**
*
* 部门管理 service接口实现类
*
**/
@Service("apartmentService")
public class ApartmentService implements IApartmentService {
    @Resource
    private ApartmentMapper apartmentMapper;

    public Apartment getApartmentById(Integer id) {
        return apartmentMapper.selectApartmentById(id);
    }

    public String save(Apartment record) {
            if (1 == apartmentMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Apartment> apartments = apartmentMapper.page(param);
        pageResult.setData(apartments);
        param.setPage(null);
        pageResult.setTotal(apartmentMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Apartment record) {
        return apartmentMapper.update(record);
    }

    public int delete(Integer id) {
        return apartmentMapper.delete(id);
    }

    public List<Apartment> all() {
		// TODO Auto-generated method stub
		return apartmentMapper.page(new PageSearchParam());
	}

}
