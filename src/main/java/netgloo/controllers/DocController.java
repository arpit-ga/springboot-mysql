package netgloo.controllers;

import java.util.Date;
import java.util.List;

import netgloo.models.DocDao;
import netgloo.models.Doctransitioninfo;
import netgloo.models.Document;
import netgloo.models.DocumentDTO;
import netgloo.models.TransDao;
import netgloo.models.User;
import netgloo.models.UserDao;
import netgloo.util.MyTypeAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping(value = "/api/rest/doc")
public class DocController {

    @Autowired
    private DocDao _docDao;

    @Autowired
    private UserDao _user;

    @Autowired
    private TransDao _transDao;

    @RequestMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAll() {
        List<Document> docList = null;
        try {
            docList = _docDao.getAll();
            /*
             * for (Document trans : docList) { Collection<Doctransitioninfo> col =
             * trans.getDoctransitioninfoCollection(); Iterator<Doctransitioninfo> itr = col.iterator(); while
             * (itr.hasNext()) { Doctransitioninfo doc = itr.next(); System.out.println("DocTransitionInfo :" + doc); }
             * 
             * }
             */
            System.out.println("docList :" + docList);

        } catch (Exception ex) {
            return ex.getMessage();
        }
        Gson gson = new GsonBuilder().registerTypeAdapter(Doctransitioninfo.class,
                new MyTypeAdapter<Doctransitioninfo>()).create();
        return gson.toJson(docList);
        // return "Doc retrived succesfully!";
    }

    @RequestMapping(value = "/save/{userID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String create(@RequestBody DocumentDTO docDTO, @PathVariable("userID") Integer userID) {

        System.out.println("docDTO :" + docDTO);
        try {

            User dbUser = _user.getById(userID);
            if (dbUser.getRole().contains("Manager")) {

                Date date = new Date();
                Integer documentID = 0;
                try {
                    Document document = new Document();
                    document.setTagAttributes(docDTO.getTagAttributes());
                    document.setCreatedDate(date);

                    documentID = _docDao.save(document);
                    if (documentID <= 0) {
                        System.out.println("error in save document");
                    }
                } catch (Exception e) {

                }
                Doctransitioninfo transInfo = new Doctransitioninfo();
                System.out.println("documentID :" + documentID);

                Document doc = _docDao.getById(documentID);
                System.out.println("documentID :" + doc.toString());
                transInfo.setDocIdf(doc);
                transInfo.setBodyAttributes(docDTO.getBodyAttributes());
                transInfo.setLanguageCode(docDTO.getLanguageCode());
                transInfo.setName(docDTO.getName());
                System.out.println("transInfo : " + transInfo.toString());
                _transDao.save(transInfo);
            } else {
                System.out.println("Only user with Manager role has a permission to add doc");
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }

        return "Doc Added Successfully!";
    }

    @RequestMapping(value = "/trans/{docid}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addTrans(@RequestBody Doctransitioninfo transInfo, @PathVariable("docid") Integer docid) {
        try {
            System.out.println("transInfo  :" + transInfo + " docID :" + docid);
            Doctransitioninfo info = new Doctransitioninfo();
            Document doc = _docDao.getById(docid);
            System.out.println("documentID :" + doc.toString());
            info.setDocIdf(doc);
            info.setBodyAttributes(transInfo.getBodyAttributes());
            info.setLanguageCode(transInfo.getLanguageCode());
            info.setName(transInfo.getName());

            System.out.println("info :" + info);
            _transDao.save(info);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Doc tansInfo Added Successfully!";
    }

    @RequestMapping(value = "/tags/{tags}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAllDoccByTags(@PathVariable("tags") String tags) {
        List<Document> docList;
        try {
            System.out.println("transInfo  :" + tags);
            docList = _docDao.getAllDocByTags(tags);
            System.out.println("docList :" + docList);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        /*
         * Gson gson = new Gson(); return gson.toJson(docList);
         */

        Gson gson = new GsonBuilder().registerTypeAdapter(Doctransitioninfo.class,
                new MyTypeAdapter<Doctransitioninfo>()).create();
        return gson.toJson(docList);

        /*
         * GsonBuilder b = new GsonBuilder(); b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY); Gson gson
         * = b.create(); return gson.toJson(docList);
         */
    }

}
