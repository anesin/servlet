package hello.servlet.basic.reponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

import static javax.servlet.http.HttpServletResponse.SC_FOUND;
import static javax.servlet.http.HttpServletResponse.SC_OK;


@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // status-line
    response.setStatus(SC_OK);

    //response headers
//    response.setHeader("Content-Type", "text/plain;charset=utf-8");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("my-header", "hello");

    content(response);
    cookie(response);
    redirect(response);

    // message body
    PrintWriter writer = response.getWriter();
    writer.write("ok");
  }


  private void content(HttpServletResponse response) {
//    response.setHeader("Content-Type", "text/plain;charset=utf-8");
    response.setContentType("text/plain");
    response.setCharacterEncoding("utf-8");
  }


  private void cookie(HttpServletResponse response) {
//    response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
    Cookie cookie = new Cookie("myCookie", "good");
    cookie.setMaxAge(600);
    response.addCookie(cookie);
  }


  private void redirect(HttpServletResponse response) throws IOException {
//    response.setStatus(SC_FOUND);
//    response.setHeader("Location", "/basic/hello-form.html");
    response.sendRedirect("/basic/hello-form.html");
  }

}
