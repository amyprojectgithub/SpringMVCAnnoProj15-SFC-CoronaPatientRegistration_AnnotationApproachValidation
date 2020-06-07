package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.PatientBO;
@Repository
public class PatientDAOImpl implements PatientDAO {
	@Autowired
	private JdbcTemplate jt;
	private static final String INSERT_PATIENT_INFO="INSERT INTO CORONA_PATIENT VALUES(PATID_SEQ.NEXTVAL,?,?,?,?)";

	@Override
	public int insert(PatientBO bo) {
     int count=0;
     count=jt.update(INSERT_PATIENT_INFO, bo.getPatName(),bo.getAge(),bo.getLocation(),bo.getHospital());
		return count;
	}

}
