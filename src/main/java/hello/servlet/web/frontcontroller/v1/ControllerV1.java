package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface ControllerV1 {

  void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
