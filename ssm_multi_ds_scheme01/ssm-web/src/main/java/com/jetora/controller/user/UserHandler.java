package com.jetora.controller.user;

import com.jetora.pojo.User;
import com.jetora.service.user.UserService;
import com.jetora.common.exception.ResourceNotFoundException;
import com.jetora.utils.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@RestController
public class UserHandler {
    private static final Logger log = Logger.getLogger(UserHandler.class);
    @Autowired
    UserService userService ;
    /*
    @RequestMapping(value = "/getUserById",method = {RequestMethod.POST,RequestMethod.GET})
    public String getUserById(HttpServletRequest request,Model model){
        //参数
        Integer userId = StringUtils.notNull(request.getParameter("userId"))?Integer.parseInt(request.getParameter("userId")):1;
        User user = userService.getUserById(userId);
        model.addAttribute("user",user);
        return "test";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable("id") String userid){
        Integer userId = StringToolUtils.notNull(userid)?Integer.parseInt(userid):1;
        User user = userService.getUserById(userId);
        return user;
    }

    @GetMapping(value = "/user/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<User> employById(@PathVariable Integer id) {
        ResponseResult<User> result = new ResponseResult<User>();
        HttpStatus status = null;
        User user = userService.getUserById(id);
        if (user == null) {
            throw new ResourceNotFoundException(String.valueOf(id));
        }
        result.setCode(String.valueOf(HttpStatus.OK));
        result.setData(user);
        return result;
    }
    */
    /*
    通过 @ExceptionHandler 能将控制器的方法的异常场景分出来单独处理

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseResult<Object> handlerException(ResourceNotFoundException e) {
        ResponseResult<Object> result = new ResponseResult<Object>();
        result.setCode(String.valueOf(HttpStatus.NOT_FOUND));
        result.setDesc(e.getMessage());
        return result;
    }
    */
    /*
    @PostMapping(value = "/employ", produces = { "application/json;charset=UTF-8" })
    public int saveEmploy(@RequestBody EmployeeEntity employeeEntity) {
        return empService.save(employeeEntity);
    }
    */
    @GetMapping(value = "/user/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<User> employById(@PathVariable Integer id) {
        ResponseResult<User> result = new ResponseResult<>();
        User user = userService.getUserById(id);
        if (user == null) {
            throw new ResourceNotFoundException(String.valueOf(id));
        }
        result.setCode(String.valueOf(HttpStatus.OK));
        result.setData(user);
        return result;
    }
    @GetMapping(value = "/user/list", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<User>> getUsers(){
        ResponseResult<List<User>> result= new ResponseResult<>();
        List<User> userslist = userService.getAllUsers();
        if (userslist.isEmpty()){
            log.error("空",new ResourceNotFoundException(String.valueOf(userslist.size())));
            //throw new ResourceNotFoundException(String.valueOf(userslist.size()));
        }
        result.setCode(String.valueOf(HttpStatus.OK));
        result.setData(userslist);
        return result;
    }
    @Transactional
    @PostMapping(value = "/user/add", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<User> insertSaveUser(@RequestBody User user){
        ResponseResult<User> result = new ResponseResult<>();
        try {
            userService.insertUser(user);
            result.setCode(String.valueOf(HttpStatus.OK));
            result.setMsg("insert succeed...");
        } catch (Exception e) {
            result.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            result.setMsg("insert failed...");
            log.error("新增User失败！", e);
        }
        return result;
    }
    @PostMapping(value = "/user/update", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<User> updateSaveUser(@RequestBody User user){
        ResponseResult<User> result = new ResponseResult<>();
        try {
            userService.updateUserById(user);
            result.setCode(String.valueOf(HttpStatus.OK));
            result.setMsg("update succeed...");
        } catch(Exception e) {
            result.setCode(String.valueOf(HttpStatus.NOT_FOUND));
            result.setMsg("update failed...");
        }
        return result;
    }
    @PostMapping(value = "/user/delete/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<User> deleteSaveUser(@PathVariable Integer id){
        ResponseResult<User> result = new ResponseResult<>();
        try {
            userService.delUserById(id);
            result.setCode(String.valueOf(HttpStatus.OK));
            result.setMsg("delete succeed...");
        } catch(Exception e){
            result.setCode(String.valueOf(HttpStatus.NOT_FOUND));
            result.setMsg("delete failed...");
        }
        return result;
    }

}
