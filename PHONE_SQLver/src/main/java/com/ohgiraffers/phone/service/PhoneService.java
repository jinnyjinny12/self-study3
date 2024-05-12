package com.ohgiraffers.phone.service;

import com.ohgiraffers.phone.dao.PhoneRepository;
import com.ohgiraffers.phone.dto.PhoneDTO;

public class PhoneService {

    private PhoneRepository phoneRepository;

    public PhoneService() {
        this.phoneRepository = new PhoneRepository();

    }

    public PhoneDTO phoneFindbyName(String name) throws Exception {
        if(name == null || name.equals("")) {
            return null;
        }

        PhoneDTO emp = phoneRepository.phoneFindByName(name);

        if(emp == null) {
            throw new Exception("전화번호 조회 실패");
        }
        return emp;
    }







}
