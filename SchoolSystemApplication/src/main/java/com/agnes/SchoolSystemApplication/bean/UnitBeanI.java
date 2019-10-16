package com.agnes.SchoolSystemApplication.bean;

import com.agnes.SchoolSystemApplication.model.Unit;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface UnitBeanI extends BeanI<Unit>{
    Unit findByUnitCode(String unitCode);
    List<Unit> getUnitList() throws SQLException;


}
