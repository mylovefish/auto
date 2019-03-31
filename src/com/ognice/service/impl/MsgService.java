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
import com.ognice.dao.MsgMapper;
import com.ognice.domain.Msg;
import com.ognice.service.IMsgService;
/**
*
* 消息管理 service接口实现类
*
**/
@Service("msgService")
public class MsgService implements IMsgService {
    @Resource
    private MsgMapper msgMapper;

    public Msg getMsgById(Integer id) {
        return msgMapper.selectMsgById(id);
    }

    public String save(Msg record) {
            if (1 == msgMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Msg> msgs = msgMapper.page(param);
        pageResult.setData(msgs);
        param.setPage(null);
        pageResult.setTotal(msgMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Msg record) {
        return msgMapper.update(record);
    }

    public int delete(Integer id) {
        return msgMapper.delete(id);
    }

    public List<Msg> all() {
		// TODO Auto-generated method stub
		return msgMapper.page(new PageSearchParam());
	}

}
