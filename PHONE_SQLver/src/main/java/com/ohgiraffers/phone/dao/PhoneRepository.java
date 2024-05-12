package com.ohgiraffers.phone.dao;

import com.ohgiraffers.phone.dto.PhoneDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class PhoneRepository {

    private Properties pros = new Properties();
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rset = null;

    public PhoneRepository() {
        try {
           this.pros.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/employee/mapper/phone-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public PhoneDTO phoneFindByName(String name) {
        String query = pros.getProperty("FindByName");
        con= getConnection();
        PhoneDTO emp = new PhoneDTO();

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,name);
            rset = pstmt.executeQuery();

            if(rset.next()) {
                emp.setUserNO(rset.getInt("USER_NO"));
                emp.setUserName(rset.getString("USER_NAME"));
                emp.setUserAddress(rset.getString("USER_ADDRESS"));
                emp.setCallName(rset.getString("CALL_NAME"));
                emp.setCallNumber(rset.getString("CALL_NUMBER"));
                emp.setMainCall(rset.getString("MAIN_CALL"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
            close(con);
        }

        return emp;
    }
}
