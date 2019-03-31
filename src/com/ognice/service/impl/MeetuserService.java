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
import com.ognice.dao.MeetuserMapper;
import com.ognice.domain.Meetuser;
import com.ognice.service.IMeetuserService;
/**
*
*  service接口实现类
*
**/
@Service("meetuserService")
public class MeetuserService implements IMeetuserService {
    @Resource
    private MeetuserMapper meetuserMapper;

    public Meetuser getMeetuserById(Integer id) {
        return meetuserMapper.selectMeetuserById(id);
    }

    public String save(Meetuser record) {
            if (1 == meetuserMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Meetuser> meetusers = meetuserMapper.page(param);
        pageResult.setData(meetusers);
        param.setPage(null);
        pageResult.setTotal(meetuserMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Meetuser record) {
        return meetuserMapper.update(record);
    }

    public int delete(Integer id) {
        return meetuserMapper.delete(id);
    }

    public List<Meetuser> all() {
		// TODO Auto-generated method stub
		return meetuserMapper.page(new PageSearchParam());
	}

}
