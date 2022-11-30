/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.Chip;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author youngboizseetinh
 */
public class ChipRepository {
    
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    private String fromTable = "FROM Chip"; //HQL
    
    public Chip getOne(String MaChip) {
        String sql = fromTable + "WHERE MaChip =: MaChip1"; 
        Query query = session.createQuery(sql, Chip.class);
        query.setParameter("MaChip1", MaChip); 
        return (Chip) query.getSingleResult();
    }
    
    public List<Chip> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }
    
    public Boolean add(Chip chip) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chip);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean update(Chip chip) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(chip);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean delete(Chip chip) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            chip.setDeleted(true);
            session.update(chip);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
