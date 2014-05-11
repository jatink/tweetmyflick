package tweetmyflickhci;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.jasper.tagplugins.jstl.core.Out;





import java.util.*;

@SuppressWarnings("serial")
public class MovieShowFilterServlet extends HttpServlet {
	 public void doGet(HttpServletRequest request,
             HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");

PrintWriter out = response.getWriter();
try
{
	out.println("<head>");
		out.println("<title>TweetMyFlick</title>");
		
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">");
 	    //out.println("body {padding-top: 60px;padding-bottom: 40px;}.sidebar-nav {padding: 9px 0;}</style>");
 		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-responsive.css\">");
 		
 		
 	
 		
 		
 		//out.println("<div id=\"fb-root\"></div><script>(function(d, s, id) {var js, fjs = d.getElementsByTagName(s)[0];if (d.getElementById(id)) return;js = d.createElement(s); js.id = id;js.src = \"//connect.facebook.net/en_US/all.js#xfbml=1\";fjs.parentNode.insertBefore(js, fjs);}(document, 'script', 'facebook-jssdk'));</script>");
 		
 		out.println("<div class=\"navbar navbar-fixed-top\"><div class=\"navbar-inner\"><div class=\"container\"><a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\"><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></a>");
 		out.println("<a class=\"brand\" href=\"#\"><FONT COLOR=\"#0099ff\">Tweet<FONT COLOR=\"#00cccc\">My<FONT COLOR=\"#009999\">Flick <FONT COLOR=\"#999999\">Beta</a>");
 	//	out.println("<ul class=\"nav\"><li ><a href=\"index.html\">Home</a></li><li><a href=\"aboutus_page.html\">About</a></li><li><a href=\"contact.html\">Contact</a></li><li><a href=\"https://sites.google.com/a/iiitd.ac.in/tweetmyflick/home\">Blog</a></li><li><a href=\"show.html\">Movie Show Recommendations</a></li></ul>");
 		out.println("<div class=\"nav-collapse\">");
 		out.println("<ul class=\"nav\"><li ><a href=\"index.html\">Home</a></li><li><a href=\"movieshows.html\">Movie Show Recommendations</a></li><li><a href=\"https://sites.google.com/a/iiitd.ac.in/tweetmyflick/home\">Blog</a></li></ul>");
 		out.println("</div>");
 		out.println("</div>");
 		out.println("</div>");
 		out.println("</div>");

	    String url = "http://bookmyshow.com";
	    String City=request.getParameter("select");  // I need this information from web page
		
	    //out.println(City);
	    String Location=request.getParameter("location"); // I need this information from web page
		
		String Filename=City+"_"+Location+"1.csv";
		ArrayList<Attributes> p = new ArrayList<Attributes>();
		//Reading CSV File and adding them to arraylist
		try { 
			   BufferedReader br = new BufferedReader(new FileReader(Filename));
		       String line = "";
		       StringTokenizer st = null;
		       
		       while ((line = br.readLine()) != null) {
		    	   st = new StringTokenizer(line, ",");
		         Attributes attr=new Attributes();
		         attr.theater=st.nextToken();
		         //attr.area=st.nextToken();
		         attr.movie=st.nextToken();
		         attr.show=st.nextToken();
		         attr.budget=st.nextToken();
		         attr.metro=st.nextToken();
		         attr.eating_joint=st.nextToken();
		         
		         p.add(attr);

		         

		         
		       }

		     } catch (Exception e) {
		    	 e.printStackTrace();
		    	 System.err.println("CSV file cannot be read : " + e);
		     }
		
		
		
		System.out.println(p.size());
		
		//Creating Filters and finding all relevant information
		ArrayList<Attributes> final_list = new ArrayList<Attributes>();
		String theater=request.getParameter("theater");  //default value select // have to get the information from web page
		String movie=request.getParameter("movie");     //default value select // have to get the information from web page
		String budget1= request.getParameter("budget");        //default value 0 // have to get the information from web page // 1 2 or 3 will we get from web page
		int budget=0;
		if(budget1.compareToIgnoreCase("select")==0)
		{
			budget=0;
			
		}
		if(budget1.compareToIgnoreCase("Less than 150")==0)
		{
			budget=1;
			
		}
		if(budget1.compareToIgnoreCase("150-250")==0)
		{
			budget=2;
			
		}
		if(budget1.compareToIgnoreCase("above 250")==0)
		{
			budget=3;
			
		}
		
		String metro=request.getParameter("group1");   // have to get the information from web page
		String eating=request.getParameter("group2");  // have to get the information from web page
		
		//out.println(eating);
		//out.println(metro);
		for(int i=0;i<p.size();i++)
		{
			Attributes selection=p.get(i);
			
			if(theater.compareToIgnoreCase("select")==0 || (selection.theater.contains(theater)) || (theater.contains(selection.theater)))
			{
				if(movie.compareToIgnoreCase("select")==0 || (selection.movie.contains(movie)) || (movie.contains(selection.movie)))
				{
					
							switch(budget){
							case 0: final_list.add(selection);
							        break;
							        
							case 1: if(selection.budget.compareTo("150")<0)
							          {
								          final_list.add(selection);
						                   
							          }
							        break;
							case 2: if(selection.budget.compareTo("150")>0 && selection.budget.compareTo("250")<0)
					                {
						               final_list.add(selection); 
					                }
							        break;
							case 3: if(selection.budget.compareTo("250")>0)
					                {
						               final_list.add(selection);
				                    }
							        break;
							
					}
				}
			}
		}
		
		
		 out.println("<div class=\"container\">");

	     
	    
	    
	    out.println("<div class=\"row-fluid\">");
	  out.println("<div class=\"span12\">");
	 
	  out.println("<br><br><p class=\"lead\"><h2><img src=\"img/tweetmyflick.png\" height=\"54\" width=\"138\"> <FONT COLOR=\"#00cccc\"> Movie Shows for You! </p>");
	  
	    //out.println("<p class=\"lead\"><h2><img src=\"img/logo.png\" height=\"84\" width=\"168\"> &nbsp;&nbsp;&nbsp;&nbsp;Movie Shows for You! </p>");
	    out.println("<br>");
			
	    if(final_list.size()!=0)
		{
				
				out.println("<div class=\"show-timings\">");
				out.println("<pre class=\"prettyprint linenums\" style=\"margin-bottom: 10px;\">");
				out.println("<table class=\"table table-striped\">");
				
	              out.println("<thead>");
				  
	                out.println("<tr>");
	                  //out.println("<th><center><FONT SIZE=+2 FACE=\"Cursive\">#</center></th>");
	                  out.println("<th><center><FONT SIZE=+1 FACE=\"Verdana\">Movie</center></th>");
	                  out.println("<th><center><FONT SIZE=+1 FACE=\"Verdana\">Theatre</center></th>");
					  //out.println("<th><center><FONT SIZE=+1 FACE=\"Verdana\">Locality</center></th>");
	                  out.println("<th><center><FONT SIZE=+1 FACE=\"Verdana\">Show Timings</center></th>");
	                  //out.println("<th><center><FONT SIZE=+1 FACE=\"Verdana\"></center></th>");
	                  out.println("<th><center><FONT SIZE=+1 FACE=\"Verdana\">Booking</center></th>");
	                out.println("</tr>");
	              out.println("</thead>");
	              out.println("<tbody>");
	              
		}
		
		
	
	    else
		{
	    	out.println("<div class=\"show-timings\">"); 
	    	out.println("<div class=\"well\">");
	    	
	    	out.println("<p class=\"lead\"><font color=\"#999999\"><center><h3>There are no search results based on the options defined. <br> Please go <a href=\"movieshows.html\"> back </a> and refine your search</center></font></p>");
			
	    	 out.println("</div>");
		}
		
		ArrayList<String> shows = new ArrayList<String>();
		for(int i=0;i<final_list.size();i++)
	{
			//out.println("<br><br><p class=\"lead\"><h1>Movie shows according to your search<br>");
			
			
			 out.println("<tr>");
             //out.println("<td><center><FONT FACE=\"Verdana\">1</center></td>");
             out.println("<td><center><FONT FACE=\"Verdana\">"+final_list.get(i).movie+"</center></td>");
             out.println("<td><center><FONT FACE=\"Verdana\">"+final_list.get(i).theater+"</center></td>");
             //out.println("<td><center><FONT FACE=\"Verdana\">"+final_list.get(i).area+"</center></td>");
			  
             String str = final_list.get(i).show;
             String strarr[] = str.split("\\|");
             
             out.println("<td><center><FONT FACE=\"Verdana\">");
             int x=0;
             for(int j=0;j<strarr.length;j++)
             {
            	 
            	 if(x==5)
              	{
              		break;
              	}
            	 out.println("<div title="+strarr[j].split(" ")[1]+">"+strarr[j].split(" ")[0]+"</div>"); 
            	 //out.println("<a href=\"http://in.bookmyshow.com/movies/nowshowing/\" class=\"btn btn-primary btn-small\">Book Now &raquo;</a></div>");
            	 out.print("<br>");
            	 //out.print("<p><a class=\"btn btn-primary btn-large href=\"http://bookmyshow.com\">Book Now &raquo;</a></p>");
             	
            	 x=x+1;	
            	 
             }
         	out.println("</center></td>"); 
         	
         	/*
         	out.println("<td><center><FONT FACE=\"Verdana\">");
            int x1=0;
            for(int j=3;j<strarr.length;j++)
            {
           	 
           	 if(x1==3)
             	{
             		break;
             	}
           	 out.println("<div title="+strarr[j].split(" ")[1]+">"+strarr[j].split(" ")[0]+"</div>"); 
           	//out.println("<a href=\"http://in.bookmyshow.com/movies/nowshowing/\" class=\"btn btn-primary btn-small\">Book Now &raquo;</a>");
           	 out.print("<br>");
           	 //out.print("<p><a class=\"btn btn-primary btn-large href=\"http://bookmyshow.com\">Book Now &raquo;</a></p>");
            	
           	 x1=x1+1;	
           	 
            }
        	out.println("</center></td>"); 
         	
         	*/
             
         	 out.println("<td><center><FONT FACE=\"Verdana\">");
         	
         	 
         	 for(int j=0;j<Math.min(strarr.length,x);j++)
             {
         		out.println("<p><a href=\"http://in.bookmyshow.com/movies/nowshowing/\" class=\"btn btn-primary btn-small\">Book Now &raquo;</a></p>");
             }
         	
        	out.println("</center></td>"); 
        	
         	out.println("</tr>");
			
			
			
			
			
			
	}
		
		
		  
        out.println("</tbody>");
    out.println("</table>");
out.println("</div>");

out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");

out.println("</p>");
out.println("</div>");
out.println("</div>");
out.println("</div>");
out.println("<footer>");
//out.println("<marquee direction=\"left\" scrolldelay=\"90\" scrollamount=\"6\" behavior=\"scroll\" loop=\"0\" style=\"height:24px;z-index:29;background-color:#D8D8D8;border:1px #B8CFE9 solid;\" id=\"Marquee1\" onmouseover=\"this.stop()\" onmouseout=\"this.start()\"><font style=\"font-size:13px\" color=\"#424242\" face=\"Arial\">Recent Twitter Opinion :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; Barfi </font><font style=\"font-size:13px\" color=\"#32CD32\" face=\"Arial\">88%</font><font style=\"font-size:13px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:13px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; SOTY </font><font style=\"font-size:13px\" color=\"#32CD32\" face=\"Arial\">68%</marquee>");
//out.println("<marquee direction=\"left\" scrolldelay=\"60\" scrollamount=\"6\" behavior=\"scroll\" loop=\"0\" style=\"height:72px;z-index:29;background-color:#D8D8D8;\" id=\"Marquee1\" onmouseover=\"this.stop()\" onmouseout=\"this.start()\"><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">Recent Twitter Opinion :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<img src=\"img/jthj.jpg\" alt=\"JTHJ\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Jab Tak Hai Jaan'>Jab Tak Hai Jaan</a></font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">&nbsp;73%</font><font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/sos.jpg\" alt=\"SOS\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Son of Sardaar'>Son of Sardaar</a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">68% <font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/thuppakki.jpg\" alt=\"Thuppakki\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Thuppakki'>Thuppakki</a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">78%<font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/skyfall.jpg\" alt=\"Skyfall\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Skyfall'>Skyfall</a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">88%<font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/lifeofpi.jpg\" alt=\"LifeOfPi\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Life Of Pi'>Life of Pi</a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">86%</marquee>");
//out.println("<marquee direction=\"left\" scrolldelay=\"60\" scrollamount=\"6\" behavior=\"scroll\" loop=\"0\" style=\"height:40px;z-index:29;background-color:#D8D8D8;\" id=\"Marquee1\" onmouseover=\"this.stop()\" onmouseout=\"this.start()\"><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">Recent Twitter Opinion :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<img src=\"img/jthj1.jpg\" alt=\"JTHJ\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Jab Tak Hai Jaan'><font color=\"#424242\">Jab Tak Hai Jaan</font></a></font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">&nbsp;73%</font><font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/sos1.jpg\" alt=\"SOS\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Son of Sardaar'><font color=\"#424242\">Son of Sardaar</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">68% <font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/thuppakki1.jpg\" alt=\"Thuppakki\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Thuppakki'><font color=\"#424242\">Thuppakki</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">78%<font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/skyfall1.jpg\" alt=\"Skyfall\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Skyfall'><font color=\"#424242\">Skyfall</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">88%<font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/lifeofpi1.jpg\" alt=\"LifeOfPi\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Life Of Pi'><font color=\"#424242\">Life of Pi</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">86%</marquee>");

out.println("<marquee direction=\"left\" scrolldelay=\"60\" scrollamount=\"6\" behavior=\"scroll\" loop=\"0\" style=\"height:40px;z-index:29;background-color:#D8D8D8;\" id=\"Marquee1\" onmouseover=\"this.stop()\" onmouseout=\"this.start()\"><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">Recent Twitter Opinion :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<img src=\"img/jthj1.jpg\" alt=\"JTHJ\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Jab Tak Hai Jaan'><font color=\"#424242\">Jab Tak Hai Jaan</font></a></font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">&nbsp;73%</font><font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/sos1.jpg\" alt=\"SOS\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Son of Sardaar'><font color=\"#424242\">Son of Sardaar</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">68% <font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/talaash1.jpg\" alt=\"Thuppakki\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Talaash'><font color=\"#424242\">Talaash</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">71%<font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/khiladi7861.jpg\" alt=\"Khiladi786\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Khiladi 786'><font color=\"#424242\">Khiladi 786</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">78%<font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/lifeofpi1.jpg\" alt=\"LifeOfPi\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Life Of Pi'><font color=\"#424242\">Life of Pi</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">86%</marquee>");
 
out.println("</footer>");

//out.println("<marquee direction=\"left\" scrolldelay=\"60\" scrollamount=\"6\" behavior=\"scroll\" loop=\"0\" style=\"height:72px;z-index:29;background-color:#D8D8D8;\" id=\"Marquee1\" onmouseover=\"this.stop()\" onmouseout=\"this.start()\"><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">Recent Twitter Opinion :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<img src=\"img/jthj.jpg\" alt=\"JTHJ\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Jab Tak Hai Jaan'>Jab Tak Hai Jaan</a></font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">&nbsp;68%</font><font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/sos.jpg\" alt=\"SOS\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Son of Sardaar'>Son of Sardaar</a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">68% <font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/thuppakki.jpg\" alt=\"Thuppakki\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Thuppakki'>Thuppakki</a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">78%<font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/skyfall.jpg\" alt=\"Skyfall\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Skyfall'>Skyfall</a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">88%<font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/lifeofpi.jpg\" alt=\"LifeOfPi\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Life Of Pi'>Life of Pi</a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">86%</marquee>");
out.println("</pre>");	


out.println("<script src=\"bootstrap.js\"></script>");
out.println("<script src=\"bootstrap.min.js\"></script>");
out.println("<script src=\"bootstrap-typeahead.js\"></script>");
out.println("<script src=\"jquery.js\"></script>");
		
		
}catch(Exception e)
{
	e.printStackTrace();
}
 
}
	 

	 public void doPost(HttpServletRequest request,
	               HttpServletResponse response)
	 throws ServletException, IOException {
	 doGet(request, response);
	 }

	 
}
class Attributes{
	String theater;
	//String area;
	String movie;
	String show;
	//String show2;
	String budget;
	String metro;
	String eating_joint;
}
	    
	    
	    
	