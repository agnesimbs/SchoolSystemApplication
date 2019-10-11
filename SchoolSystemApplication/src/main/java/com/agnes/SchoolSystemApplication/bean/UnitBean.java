package com.agnes.SchoolSystemApplication.bean;

import com.agnes.SchoolSystemApplication.model.Student;
import com.agnes.SchoolSystemApplication.model.Unit;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;
@Local
@Stateless
public class UnitBean extends Bean<Unit> implements UnitBeanI {
@PostConstruct
public void init(){this.entityClass=Unit.class;}

    @Override
    public Unit findByUnitCode(String unitCode) {
        return this.entityManager
                .createNamedQuery("NQ_FINDBYUNITCODE",Unit.class)
                .setParameter("unitCode",unitCode)
                .getSingleResult();

    }
}
