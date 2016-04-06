package netgloo.models;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TransDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public Integer save(Doctransitioninfo info) {
        System.out.println("info :" + info);
        //getSession().save(info);
        getSession().saveOrUpdate(info);
        return 1;
    }

    public void delete(Doctransitioninfo user) {
        getSession().delete(user);
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Doctransitioninfo> getAll() {
        return getSession().createQuery("from Doctransitioninfo").list();
    }

    public Doctransitioninfo getAllDoc(String email) {
        return (Doctransitioninfo) getSession().createQuery("from Doctransitioninfo ")

        .uniqueResult();
    }

    public Doctransitioninfo getById(long id) {
        return (Doctransitioninfo) getSession().load(Doctransitioninfo.class, id);
    }

    public void update(Doctransitioninfo user) {
        getSession().update(user);
        return;
    }

    public Doctransitioninfo getTransByID(Integer docid) {
        return (Doctransitioninfo) getSession().createQuery("from Doctransitioninfo where docIdf = :docid")
                .setParameter("docIdf", docid).uniqueResult();
    }

} // class UserDao
