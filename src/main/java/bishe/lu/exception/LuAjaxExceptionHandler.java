package bishe.lu.exception;

import bishe.lu.pojo.LuJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class LuAjaxExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
	public LuJSONResult defaultErrorHandler(HttpServletRequest req,
                                               Exception e) throws Exception {

		e.printStackTrace();
		return LuJSONResult.errorException(e.getMessage());
	}
}
