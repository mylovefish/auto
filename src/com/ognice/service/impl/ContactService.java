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
import com.ognice.dao.ContactMapper;
import com.ognice.domain.Contact;
import com.ognice.service.IContactService;
/**
*
* 通讯录 service接口实现类
*
**/
@Service("contactService")
public class ContactService implements IContactService {
    @Resource
    private ContactMapper contactMapper;

    public Contact getContactById(Integer id) {
        return contactMapper.selectContactById(id);
    }

    public String save(Contact record) {
            if (1 == contactMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Contact> contacts = contactMapper.page(param);
        pageResult.setData(contacts);
        param.setPage(null);
        pageResult.setTotal(contactMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Contact record) {
        return contactMapper.update(record);
    }

    public int delete(Integer id) {
        return contactMapper.delete(id);
    }

    public List<Contact> all() {
		// TODO Auto-generated method stub
		return contactMapper.page(new PageSearchParam());
	}

}
