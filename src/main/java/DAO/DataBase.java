package DAO;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;

	import BEAN.Variable;

	public class DataBase {
		PreparedStatement ps=null;
		Statement st=null;
		ResultSet rs=null;
		Databaseconnector ob=new Databaseconnector();
		Connection con=ob.connector();
		public String insert(Variable data)
		{
			try
			{
				String q="insert into sign(name,age,email,number,password,profilephoto) values('"+data.getName()+"','"+data.getAge()+"','"+data.getEmail()+"','"+data.getNumber()+"','"+data.getPassword()+"','"+data.getImgname()+"')";
				ps=con.prepareStatement(q);
				if(ps.executeUpdate()!=0)
				{
					return "success";
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return "";
		}
		
	public ArrayList<Variable> login(Variable data) 
			{
				ArrayList<Variable>  view=new ArrayList<>();
				try
				{
					String q="select*from sign where name='"+data.getName()+"' and password='"+data.getPassword()+"'";
					st=con.createStatement();
					rs=st.executeQuery(q);
					while(rs.next())
					{
						Variable d=new Variable();
						
						d.setName(rs.getString(2));
						d.setAge(rs.getString(3));
						d.setEmail(rs.getString(4));
						d.setNumber(rs.getString(5));
						d.setPassword(rs.getString(6));
						d.setType(rs.getString(7));
						d.setId(rs.getString(1));
						d.setProfilephoto(rs.getString(8));
						System.out.println(d);
						
						view.add(d);
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				return view;
			}
		public String[] image(String id) 
			{
				int count=0;
				try
				{
					String q="select image from feed where uid='"+id+"'";
					st=con.createStatement();
					rs=st.executeQuery(q);
					while(rs.next())
					{
						count++;
					}
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				String[] a=new String[count];
				try
				{
					int i=0;
					String q="select image from feed where uid='"+id+"'";
					st=con.createStatement();
					rs=st.executeQuery(q);
					while(rs.next())
					{
						a[i]=rs.getString(1);
						i++;
					}
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				return a;
				
			}	

	public ArrayList<Variable> userData(String id) 
	{
		ArrayList<Variable>  view=new ArrayList<>();
		try
		{
			String q="select*from sign where id='"+id+"'";
			st=con.createStatement();
			rs=st.executeQuery(q);
			while(rs.next())
			{
				Variable d=new Variable();
				d.setName(rs.getString(2));
				d.setAge(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setNumber(rs.getString(5));
				d.setPassword(rs.getString(6));
				d.setType(rs.getString(7));
				d.setId(rs.getString(1));
				d.setProfilephoto(rs.getString(8));
				view.add(d);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return view;
	}
	public ArrayList<Variable> people(String id) 
	{
		ArrayList<Variable>  view=new ArrayList<>();
		try
		{
			String q="select*from sign where id!='"+id+"'";
			st=con.createStatement();
			rs=st.executeQuery(q);
			while(rs.next())
			{
				Variable d=new Variable();
				d.setName(rs.getString(2));
				d.setAge(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setNumber(rs.getString(5));
				d.setPassword(rs.getString(6));
				d.setType(rs.getString(7));
				d.setId(rs.getString(1));
				d.setProfilephoto(rs.getString(8));
				System.out.println(d);
				view.add(d);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return view;
	}

	public String feedInsert(Variable ob2) 
	{
		try
		{
			System.out.println(ob2.toString());
			String q="insert into feed(uname,uid,tag,image) values('"+ob2.getName()+"',"+ob2.getId()+",'"+ob2.getTag()+"','"+ob2.getImgname()+"')";
			ps=con.prepareStatement(q);
			if(ps.executeUpdate()!=0)
			{
				return "success";
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "";
	}

	public ArrayList<Variable> userFeed() {
		// TODO Auto-generated method stub
		ArrayList<Variable>  view=new ArrayList<>();
		try {
		String q="select*from feed ";
		st=con.createStatement();
		rs=st.executeQuery(q);
		
		while(rs.next())
		{
			
			Variable d=new Variable();
			d.setName(rs.getString(3));
			d.setImgname(rs.getString(5));
			d.setTag(rs.getString(4));
			d.setId(rs.getString(2));
			view.add(d);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return view;
	}
	public String message(Variable ob2) 
	{
		try
		{
			System.out.println(ob2.toString());
			String q="insert into message(uid,rid,uname,rname,messages) values('"+ob2.getId()+"',"+ob2.getRid()+",'"+ob2.getName()+"','"+ob2.getRname()+"','"+ob2.getMessages()+"')";
			ps=con.prepareStatement(q);
			if(ps.executeUpdate()!=0)
			{
				return "success";
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "";
	}
	public ArrayList<Variable> message(String mid) 
	{
		ArrayList<Variable>  view=new ArrayList<>();
		try
		{
			String q="select*from message where mid='"+mid+"'";
			st=con.createStatement();
			rs=st.executeQuery(q);
			while(rs.next())
			{
				Variable d=new Variable();
				d.setMid(rs.getString(1));
				d.setId(rs.getString(2));
				d.setRid(rs.getString(3));
				d.setName(rs.getString(4));
				d.setRname(rs.getString(5));
				d.setMessages(rs.getString(6));
				d.setTime(rs.getString(7));
				view.add(d);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return view;
	}
	public ArrayList<Variable> messagerecieve(String uid) 
	{
		ArrayList<Variable>  view=new ArrayList<>();
	try
	{
		String q="select * from message where rid='"+uid+"'";
		st=con.createStatement();
		rs=st.executeQuery(q);
		while(rs.next())
		{
			Variable d=new Variable();
			d.setMid(rs.getString(1));
			d.setId(rs.getString(2));
			d.setRid(rs.getString(3));
			d.setName(rs.getString(4));
			d.setRname(rs.getString(5));
			d.setMessages(rs.getString(6));
			d.setTime(rs.getString(7));
			//System.out.println(d);
			view.add(d);
			
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return view;
	}
	public String messagereply(String mid) 
	{
		
	try
	{
		String q="delete from message where mid='"+mid+"'";
		System.out.println(mid);
		ps=con.prepareStatement(q);
		if(ps.executeUpdate()!=0)
		{
			return "success";
		}
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return "";
	}
	public int checkMsg(String tag)
	{
	try
	{
		String q="select word from filterword";
		st=con.createStatement();
		rs=st.executeQuery(q);
		while(rs.next())
		{
			String w=rs.getString(1);
			if(tag.contains(w))
			{
				
				return 1;
			}
			
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return 0;
	}
	public String feeddelete(Variable ob2) 
	{
		try
		{
			System.out.println(ob2.toString());
			String q="insert into deletefeed(uname,uid,tag,image) values('"+ob2.getName()+"',"+ob2.getId()+",'"+ob2.getTag()+"','"+ob2.getImgname()+"')";
			ps=con.prepareStatement(q);
			if(ps.executeUpdate()!=0)
			{
				return "success";
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "";
	}

	public ArrayList<Variable> userdeletefeed() {
		// TODO Auto-generated method stub
		ArrayList<Variable>  view=new ArrayList<>();
		try {
		String q="select*from deletefeed ";
		st=con.createStatement();
		rs=st.executeQuery(q);
		
		while(rs.next())
		{
			
			Variable d=new Variable();
			d.setName(rs.getString(3));
			d.setImgname(rs.getString(5));
			d.setTag(rs.getString(4));
			d.setId(rs.getString(2));
			view.add(d);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return view;
	}



	}



	