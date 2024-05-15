package abc.im;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import BEAN.Variable;
import DAO.DataBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class Controlle
*/
@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		HttpSession ses=request.getSession();
		DataBase dao=new DataBase();
		System.out.println();
		String action =request.getParameter("action");
		System.out.println(action);
		if(action.equals("reg"))
		{
			String Age=request.getParameter("age");
			String Email=request.getParameter("email");
			String Number=request.getParameter("number");
			String password=request.getParameter("pass");
			Variable bean=new Variable();
			//bean.setName(name);
			
			
			
			
			
			Part file=request.getPart("img");
			String imageFilename=file.getSubmittedFileName();
			
			
			System.out.println("filename :"+imageFilename);

			String uploadPath="C:\\Users\\JOMY\\Desktop\\sample\\src\\main\\webapp\\feed\\"+imageFilename;
			System.out.println("upload path"+uploadPath);

			try
			{

			FileOutputStream fos=new FileOutputStream(uploadPath);
			InputStream is=file.getInputStream();
			FileInputStream ffile=new FileInputStream(imageFilename);
			//String q="insert into image ";
			//String q="insert into image";

			byte[] data=new  byte[is.available()];
			is.read(data);
			fos.write(data);
			}
			catch(Exception e )
			{
			System.out.println(e);
			}
			
			
			
			
			
			bean.setName(request.getParameter("name"));
			bean.setAge(request.getParameter("age"));
			bean.setEmail(request.getParameter("email"));
			bean.setNumber(request.getParameter("number"));
			bean.setImgname(imageFilename);
			bean.setPassword(password);
			System.out.println(bean.toString());
			String result=dao.insert(bean);
			if(result.equals("success"))                                                                                                         
			{
				response.sendRedirect("Sign_In.html");
			}
			else
			{
				response.sendRedirect("Error.html");
			}
		}
		else if(action.equals("login"))
		{
			String name =request.getParameter("name");
			String password=request.getParameter("pass");
		Variable d=new Variable();
		d.setName(name);
		d.setPassword(password);
		System.out.println(d);
		ArrayList<Variable> sign=dao.login(d);
		//ArrayList<Variable> sign=dao.login(bean);

		if(sign.size()!=0)
		{
		for(Variable data:sign)
		{
		if(data.getType().equals("admin"))		
		{
			ses.setAttribute("person", sign);
			request.getRequestDispatcher("adminHome.jsp").forward(request, response);
		}
		else if(data.getType().equals("user"))
		{
			String id=data.getId();
			String[] img=dao.image(id);
			String name1=data.getName();
			ses.setAttribute("id", id);
			ses.setAttribute("name", name1);
			ses.setAttribute("person", sign);
			ses.setAttribute("img", img);
			request.getRequestDispatcher("User_Home.jsp").forward(request, response);
		}
		
		
		}
		}
		else
		{
			response.sendRedirect("LoginInvalid.html");
		}
		}
		else if(action.equals("userHome"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			ArrayList<Variable> person=dao.userData(id);
			
				ses.setAttribute("person", person);
				request.getRequestDispatcher("User_Home.jsp").forward(request, response);
			
			
		}
		else if(action.equals("adminHome"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			ArrayList<Variable> person=dao.userData(id);
			
				ses.setAttribute("person", person);
				request.getRequestDispatcher("adminHome.jsp").forward(request, response);
			
			
		}
		else if(action.equals("usercreatepost"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			ArrayList<Variable> person=dao.userData(id);
				ses.setAttribute("person", person);
				request.getRequestDispatcher("userCreatePost.jsp").forward(request, response);
			
		}
		else if(action.equals("userfeed"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			ArrayList<Variable> person=dao.userData(id);
			ArrayList<Variable> feed=dao.userFeed();
			ses.setAttribute("person", person);
			ses.setAttribute("feed", feed);
			request.getRequestDispatcher("userFeed.jsp").forward(request, response);
			
		}
		else if(action.equals("adminfeed"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			ArrayList<Variable> person=dao.userData(id);
			ArrayList<Variable> feed=dao.userFeed();
			ses.setAttribute("person", person);
			ses.setAttribute("feed", feed);
			request.getRequestDispatcher("adminFeeds.jsp").forward(request, response);
			
		}
		else if(action.equals("userpeople"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			ArrayList<Variable> person=dao.people(id);
			
			ses.setAttribute("person", person);
			
			request.getRequestDispatcher("userPeople.jsp").forward(request, response);
			
		}
		else if(action.equals("adminpeople"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			
			ArrayList<Variable> person=dao.people(id);
			System.out.println(person.size());
			ses.setAttribute("person", person);
			request.getRequestDispatcher("adminPeople.jsp").forward(request, response);
			
		}
		else if(action.equals("usermessage"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			ArrayList<Variable> person=dao.userData(id);
			ArrayList<Variable> message=dao.messagerecieve(id);
			ses.setAttribute("person", person);
			ses.setAttribute("message", message);
			request.getRequestDispatcher("userMessage.jsp").forward(request, response);
	
			
		}
		else if(action.equals("message"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			String rid=request.getParameter("rid");
			String rname=request.getParameter("rname");
			String messages=request.getParameter("messages");
			System.out.println(id+" "+uname+" "+rid+" "+rname+" "+messages);
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			ses.setAttribute("rid", rid);
			ses.setAttribute("rname", rname);
			ArrayList<Variable> person=dao.message(id);
			ses.setAttribute("person", person);
			request.getRequestDispatcher("message.jsp").forward(request, response);
	
			
		}
		
		else if(action.equals("messageSend"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			String rid=request.getParameter("rid");
			String rname=request.getParameter("rname");
			String messages=request.getParameter("messages");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			ses.setAttribute("rid", rid);
			ses.setAttribute("rname", rname);
			Variable ob=new Variable();
			ob.setId(id);
			ob.setMessages(messages);
			ob.setName(uname);
			ob.setRname(rname);
			ob.setRid(rid);
			String result=dao.message(ob);
			System.out.println(result);
			if(result.equals("success"))
			{
				ArrayList<Variable> person=dao.people(id);
				ses.setAttribute("person", person);
			request.getRequestDispatcher("userPeople.jsp").forward(request, response);
			}
			
		}
		else if(action.equals("replymessage"))
		{
			String mid=request.getParameter("mid");
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			String rid=request.getParameter("rid");
			String rname=request.getParameter("rname");
			String messages=request.getParameter("messages");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			ses.setAttribute("rid", rid);
			ses.setAttribute("rname", rname);
			ses.setAttribute("mid", mid);
			request.getRequestDispatcher("replaymessage.jsp").forward(request, response);
			/*Variable ob=new Variable();
			ob.setId(id);
			ob.setMessages(messages);
			ob.setName(uname);
			ob.setRname(rname);
			ob.setRid(rid);
			String result=dao.message(ob);
			System.out.println(result);
			if(result.equals("success"))
			{
				String results=dao.messagereply(mid);
				ArrayList<Variable> person=dao.people(id);
				System.out.println(results);
				ses.setAttribute("person", person);
			request.getRequestDispatcher("userMessage.jsp").forward(request, response);
			}*/
			
		}
		else if (action.equals("replymessagesend"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			String rid=request.getParameter("rid");
			String rname=request.getParameter("rname");
			String messages=request.getParameter("messages");
			String mid=request.getParameter("mid");
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			Variable ob=new Variable();
			ob.setId(id);
			ob.setMessages(messages);
			ob.setName(uname);
			ob.setRname(rname);
			ob.setRid(rid);
			String result=dao.message(ob);
			System.out.println(result);
			if(result.equals("success"))
			{
				String results=dao.messagereply(mid);
				ArrayList<Variable> person=dao.userData(id);
				ses.setAttribute("person", person);
			request.getRequestDispatcher("User_Home.jsp").forward(request, response);
			}
		}
		
		else if(action.equals("feed"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			String tag=request.getParameter("tag");
			Variable ob=new Variable();
			ob.setName(uname);
			ob.setId(id);
			ob.setTag(tag);
			Part file=request.getPart("img");
			String imageFilename=file.getSubmittedFileName();
			System.out.println("image file : "+imageFilename);
			ob.setImgname(imageFilename);
			int n=dao.checkMsg(tag.toLowerCase());
			if(n==1)
			{	
				ses.setAttribute("id", id);
				ses.setAttribute("name", uname);
				Variable obj=new Variable();
				obj.setId(id);
				obj.setName(uname);
				String result=dao.feeddelete(ob);
				if(result.equals("success"))
				{
					ArrayList<Variable> person=dao.people(id);
					ses.setAttribute("person", person);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
				}
				
			}
			else
			{
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			System.out.println(ob);
			System.out.println("inside SErvlet");
			//String name=request.getParameter("name");
			//System.out.println(name);
			
			ob.setImgname(imageFilename);
			System.out.println("filename :"+imageFilename);

			String uploadPath="C:\\Users\\JOMY\\Desktop\\sample\\src\\main\\webapp\\feed/"+imageFilename;
			System.out.println("upload path "+uploadPath);

			try
			{

			FileOutputStream fos=new FileOutputStream(uploadPath);
			InputStream is=file.getInputStream();
			FileInputStream ffile=new FileInputStream(imageFilename);
			//String q="insert into image ";
			//String q="insert into image";

			byte[] data=new  byte[is.available()];
			is.read(data);
			fos.write(data);
			}
			catch(Exception e )
			{
			System.out.println(e);
			}
			String result=dao.feedInsert(ob);
			if(result.equals("success"))
			{
			ArrayList<Variable> person=dao.userData(id);
			ses.setAttribute("person", person);
			request.getRequestDispatcher("User_Home.jsp").forward(request, response);
			//request.getRequestDispatcher("User_Home.jsp").forward(request, response);
			}
			}
		}
		else if(action.equals("deletedposts"))
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			/*String tag=request.getParameter("tag");
			String Imgname=request.getParameter("Imgname");*/
			ses.setAttribute("id", id);
			ses.setAttribute("name", uname);
			/*ses.setAttribute("tag", tag);
			ses.setAttribute("imgname", Imgname);*/
			ArrayList<Variable> person=dao.userData(id);
			ArrayList<Variable> feed=dao.userdeletefeed();
			ses.setAttribute("person", person);
			ses.setAttribute("feed", feed);
			request.getRequestDispatcher("adminFeeds.jsp").forward(request, response);
			
		}
		
		
		
			
		
		
		
		
		
		}
	

}



