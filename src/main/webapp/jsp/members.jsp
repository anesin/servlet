<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
<%
    for (Member member : members) {
        out.write("        <tr>\n" +
                  "            <td>id = " + member.getId() + "</td>\n" +
                  "            <td>username = " + member.getUsername() + "</td>\n" +
                  "            <td>age = " + member.getAge() + "</td>\n" +
                  "        </tr>\n");
    }
%>
    </tbody>
</table>
</body>
</html>
