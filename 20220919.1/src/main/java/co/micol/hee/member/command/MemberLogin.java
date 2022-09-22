package co.micol.hee.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.hee.common.Command;
import co.micol.hee.member.service.MemberService;
import co.micol.hee.member.service.MemberVO;
import co.micol.hee.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인처리
		HttpSession session = request.getSession(); //세션을 불러온다.
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = dao.memberSelect(vo);
		
		if(vo != null) {
			//세션처리하고
			session.setAttribute("id", vo.getMemberId()); //세션객체에 아이디 담고
			session.setAttribute("author", vo.getMemberAuthor()); //세션객체에 권한 담고
			session.setAttribute("name", vo.getMemberName()); //세션객체에 이름 담고
			request.setAttribute("message", vo.getMemberName() + "님 환영합니다~");
		} else {
			//실패메세지 전달 / memberMessage.jsp
			request.setAttribute("message", "아이디 혹은 패스워드가 일치하지 않습니다.");
		}
		return "member/memberMessage";
	}

}
