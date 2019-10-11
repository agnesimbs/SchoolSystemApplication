package com.agnes.SchoolSystemApplication.bean;

import com.agnes.SchoolSystemApplication.model.Unit;

import javax.ejb.Local;

@Local
public interface UnitBeanI extends BeanI<Unit>{
    Unit findByUnitCode(String unitCode);


}
