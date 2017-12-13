package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.BasicEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class DAO<T extends BasicEntity>{

    @Autowired
    protected SessionFactory sessionFactory;

    @Getter
    protected Class<T> interfaceClass;

    public DAO(){
        this.interfaceClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), DAO.class);
    }

    @Transactional
    public T save(T entity){

        System.out.println("\n\nfucked UP!\n"+entity+"\n\n");

       // sessionFactory.getCurrentSession().sa

        if(entity.getEntityId()==0) {
          //  Object o = sessionFactory.getCurrentSession().save(entity);
         //   sessionFactory.getCurrentSession().beginTransaction();
         //   Integer i = (Integer) sessionFactory.getCurrentSession().save(entity);
          //  sessionFactory.getCurrentSession().getTransaction().commit();
          sessionFactory.getCurrentSession().saveOrUpdate(entity);
            return entity;
        }
        else
            sessionFactory.getCurrentSession().update(entity);
        return entity;
    }

    @Transactional
    public  void delete(T entity){
        sessionFactory.getCurrentSession()
                .delete(sessionFactory.getCurrentSession()
                        .merge(entity));
    }

    @Transactional
    public T update(T entity){
        return (T) sessionFactory.getCurrentSession().merge(entity);
    }

    @Transactional
    public T find(int entityId){
        return sessionFactory.getCurrentSession().get(getInterfaceClass(), entityId);
    }


    @Transactional
    public List<T> getAll(){
        final Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getInterfaceClass());
        Root<T> root = query.from(getInterfaceClass());
        query.select(root);
        Query<T> q=session.createQuery(query);
        List<T> list=q.getResultList();
        return list;
    } /**/

    @Transactional
    public T findOneBy(String columnName, String s){
        final Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getInterfaceClass());
        Root<T> root = query.from(getInterfaceClass());
        query.select(root).where(builder.equal(root.get(columnName), s));
        Query<T> q=session.createQuery(query);
        T t=q.getSingleResult();
        return t;
    }

    @Transactional
    public List<T> findAllBy(String columnName, String s){
        final Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getInterfaceClass());
        Root<T> root = query.from(getInterfaceClass());
        query.select(root).where(builder.like(root.get(columnName),s));
        Query<T> q=session.createQuery(query);
        List<T> list=q.getResultList();
        return list;
    } /**/


    //@Override

    public Page<T> findAnyMatching(Optional<String> filter, Pageable pageable, String columnName) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            List<T> list = findAllBy(columnName, filter.get());
            Page<T> p = new PageImpl<T>(list, pageable, list.size());
            return p;
        } else {
            List<T> list = getAll();
            Page<T> p = new PageImpl<T>(list, pageable, list.size());
            return p;
        }
    }    //@Override

    public Page<T> findAnyMatching(Optional<String> filter, Pageable pageable, String columnName, int fatherId) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            List<T> list = findAllBy(columnName, filter.get());
            Page<T> p = new PageImpl<T>(list, pageable, list.size());
            return p;
        } else {
            List<T> list = getAll();
            Page<T> p = new PageImpl<T>(list, pageable, list.size());
            return p;
        }
    }

    // @Override

    public long countAnyMatching(Optional<String> filter, String columnName) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            List<T> list = findAllBy(columnName, filter.get());
            return list.size();
        } else {
            List<T> list = getAll();//findAllBy("login", filter.get());
            return list.size();
        }
    }

    // @Override

    public long countAnyMatching(Optional<String> filter, String columnName, int fatherId) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            List<T> list = findAllBy(columnName, filter.get());
            return list.size();
        } else {
            List<T> list = getAll();//findAllBy("login", filter.get());
            return list.size();
        }
    }
}
