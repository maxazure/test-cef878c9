package nz.co.cocca.test.javatest.service.impl;

import com.alibaba.fastjson.JSON;
import nz.co.cocca.test.javatest.service.IUserService;
import nz.co.cocca.test.javatest.Controller;
import nz.co.cocca.test.javatest.utils.JoddHttpUtils;
import nz.co.cocca.test.javatest.vo.ResultVo;
import nz.co.cocca.test.javatest.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService {
    private final static Logger logger = LoggerFactory.getLogger(Controller.class);

    private static String USERS_URL = "https://reqres.in/api/users";

    //More counts you set, faster page loading speed you get.
    private static String PER_PAGE = "10";



    /**
    * @Description: get all users from Json
    * @Param:
    * @return: List<User>
    * @Author: Jay Liu maxazure@gmail.com
    * @Date: 2019-03-31
    **/
    @Override
    public List<User> getAllUsers() {
        List<User> users;
        ResultVo resultVo = getUserFromJsonApi(1);
        users = resultVo.getData();

        ArrayList<Integer> pageNums = getPageNumList(resultVo);

        if(pageNums != null) {
            for (int number : pageNums) {
                users.addAll(getUserFromJsonApi(number).getData());

            }
        }

        Collections.sort(users,new Comparator<User>(){
            public int compare(User arg0, User arg1) {
                return arg0.getFirstName().compareTo(arg1.getFirstName());
            }});

        return users;
    }



    /**
    * @Description: get a json data of user from API
    * @Param: PageId
    * @return: ResultVo Paging data
    * @Author: Jay Liu maxazure@gmail.com
    * @Date: 2019-03-31
    **/
    private ResultVo getUserFromJsonApi(int pageId){

        Map<String, String> paramMap = new HashMap<String,String>();

        if(pageId > 0) {
            paramMap.put("page", Integer.toString(pageId));
            paramMap.put("per_page",PER_PAGE);
        }

        String resultJson = JoddHttpUtils.getData(USERS_URL,paramMap);

        logger.info("page {}",Integer.toString(pageId));
        return JSON.parseObject(resultJson, ResultVo.class);
    }

    /**
    * @Description: figure out how many pages it has
    * @Param: ResultVo
    * @return: ArrayList {1,2,3,4...}
    * @Author: Jay Liu maxazure@gmail.com
    * @Date: 2019-03-31
    **/
    private ArrayList<Integer> getPageNumList(ResultVo resultVo){
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 2 ; i < resultVo.getTotalPages()+1; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
