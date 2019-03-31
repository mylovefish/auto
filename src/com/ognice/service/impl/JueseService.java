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
import com.ognice.dao.JueseMapper;
import com.ognice.domain.Juese;
import com.ognice.service.IJueseService;
/**
*
* 角色管理 service接口实现类
*
**/
@Service("jueseService")
public class JueseService implements IJueseService {
    @Resource
    private JueseMapper jueseMapper;

    public Juese getJueseById(Integer id) {
        return jueseMapper.selectJueseById(id);
    }

    public String save(Juese record) {
            if (1 == jueseMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Juese> jueses = jueseMapper.page(param);
        pageResult.setData(jueses);
        param.setPage(null);
        pageResult.setTotal(jueseMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Juese record) {
        return jueseMapper.update(record);
    }

    public int delete(Integer id) {
        return jueseMapper.delete(id);
    }

    public List<Juese> all() {
		// TODO Auto-generated method stub
		return jueseMapper.page(new PageSearchParam());
	}

}
