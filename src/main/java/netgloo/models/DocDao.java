package netgloo.models;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DocDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public Integer save(Document user) {
        
        return (Integer) _sessionFactory.openSession().save(user);
    }

    public void delete(Document user) {
        getSession().delete(user);
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Document> getAll() {

        Session session = _sessionFactory.openSession();
        Criteria cr = session.createCriteria(Document.class);
        List<Document> results = cr.list();
        return results;
    }

    public Document getAllDoc(String email) {
        return (Document) getSession().createQuery("from Document ")

        .uniqueResult();
    }

    public Document getById(Integer id) {
        System.out.println("called");
        Document doc = (Document)getSession().get(Document.class, id);
        System.out.println("doccccccc : " +doc);
        return doc;
//        return (Document) getSession().load(Document.class, id);
    }

    public void update(Document user) {
        getSession().update(user);
        return;
    }

    public List<Document> getAllDocByTags(String tags) {
        
        Session session = _sessionFactory.openSession();
        Criteria cr = session.createCriteria(Document.class);

     // To get records having salary more than 2000
        cr.add(Restrictions.like("tagAttributes","%"+tags+"%"));
        List<Document> results = cr.list();
        return results;
    }

} // class UserDao
