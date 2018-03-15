package com.jetora.common.aspect;

import com.jetora.common.exception.ResourceNotFoundException;
import com.jetora.utils.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;


/**
 * 全局异常处理器
 *
 * @author jetora
 * @date: 2018-0-12 0:00
 */
@RestControllerAdvice
public class ExceptionAspect  {
    private static final Logger log = Logger.getLogger(ExceptionAspect.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseResult<Object> handleNotExistException(ResourceNotFoundException e) {
        //return new ResponseResult<Object>(String.valueOf(HttpStatus.NOT_FOUND), e.getMessage());
        ResponseResult resultBean = new ResponseResult();
        //resultBean.setCode(Integer.getInteger(String.valueOf(HttpStatus.NOT_FOUND)));
        resultBean.setCode(String.valueOf(HttpStatus.NOT_FOUND));
        resultBean.setMsg("Resource not found...");
        return resultBean;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseResult<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ResponseResult resultBean = new ResponseResult();
        resultBean.setCode("400");
        resultBean.setMsg("Could not read json...");
        log.error("Could not read json...", e);
        return resultBean;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseResult<Object> handleValidationException(MethodArgumentNotValidException e) {
        ResponseResult resultBean = new ResponseResult();
        resultBean.setCode("400");
        resultBean.setMsg("参数检验异常！");
        log.error("参数检验异常！", e);
        return resultBean;
    }

    /**
     * 405 - Method Not Allowed。HttpRequestMethodNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseResult<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        ResponseResult resultBean = new ResponseResult();
        resultBean.setCode("405");
        resultBean.setMsg("请求方法不支持！");
        log.error("请求方法不支持！", e);
        return resultBean;
    }

    /**
     * 415 - Unsupported Media Type。HttpMediaTypeNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public ResponseResult<Object> handleHttpMediaTypeNotSupportedException(Exception e) {
        ResponseResult resultBean = new ResponseResult();
        resultBean.setCode("415");
        resultBean.setMsg("内容类型不支持！");
        log.error("内容类型不支持！", e);
        return resultBean;
    }

    /**
     * 401 - Internal Server Error
     */
    /*
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TokenException.class)
    public ResponseResult<Object> handleTokenException(Exception e) {
        ResponseResult resultBean = new ResponseResult();
        resultBean.setCode(401);
        resultBean.setMsg("Token已失效");
        log.error("Token已失效", e);
        return resultBean;
    }
    */

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseResult<Object> handleException(Exception e) {
        ResponseResult resultBean = new ResponseResult();
        resultBean.setCode("500");
        resultBean.setMsg("内部服务器错误！");
        log.error("内部服务器错误！", e);
        return resultBean;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResponseResult<Object> handleValidationException(ValidationException e) {
        ResponseResult resultBean = new ResponseResult();
        resultBean.setCode("400");
        resultBean.setMsg("参数验证失败！");
        log.error("参数验证失败！", e);
        return resultBean;
    }
}