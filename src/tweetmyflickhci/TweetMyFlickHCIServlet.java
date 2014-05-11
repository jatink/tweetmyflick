package tweetmyflickhci;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.DocumentParser;



import com.google.appengine.labs.repackaged.org.json.*;
import com.sun.xml.internal.txw2.Document;

import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.charset.Charset;

import net.*;

//import net.sf.json.*;


//import net.sf.json.*;

 
import org.apache.*;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;



import java.util.logging.Logger;



@SuppressWarnings("serial")

public class TweetMyFlickHCIServlet extends HttpServlet {
	
	 
	private static final Logger log =
        Logger.getLogger(TweetMyFlickHCIServlet.class.getName());

	ArrayList<String> posarr = new ArrayList<String>();
     ArrayList<String> negarr = new ArrayList<String>();
     double priorpos;
     double priorneg;
     double tot_words_pos;
     double tot_words_neg;
     HashMap<String,Integer> hm = new HashMap<String,Integer>();

     HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
	
     int a[] = new int[10];
     
     static String AccessToken = "93406516-yasPXhSDBwygsZS2L0lSUxweCMg5eTLPaYCXq4Jzr";
     
     static String AccessSecret = "3yDblmnkg6XpaGp6gd6d443IOcyHem0zLOK26U8mfRE";
     
     static String ConsumerKey = "feQ9CayF2L9TuLTKhjnqkAlGU";
     
     static String ConsumerSecret = "9JkP3aERTQaIDXw4CXJlEMpF18j95zBAchHzoLe1aK10v7Fmui";
     
     
     public void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException
    {
    	 //doPost(req,res);
    	 
    	 
    	 a[0]=2;
    	 res.setContentType("text/html");
 		//resp.getWriter().println("Hello, world");
 		PrintWriter out = res.getWriter();
 		//out.println("<head>");
 		
 		
 		
 		out.println("<head>");
		out.println("<title>TweetMyFlick</title>");
		
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">");
 	    //out.println("body {padding-top: 60px;padding-bottom: 40px;}.sidebar-nav {padding: 9px 0;}</style>");
 		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-responsive.css\">");
 		
 		
 	
 		out.println("<div class=\"navbar navbar-fixed-top\"><div class=\"navbar-inner\"><div class=\"container\"><a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\"><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></a>");
 		out.println("<a class=\"brand\" href=\"#\"><FONT COLOR=\"#0099ff\">Tweet<FONT COLOR=\"#00cccc\">My<FONT COLOR=\"#009999\">Flick <FONT COLOR=\"#999999\">Beta</a>");
 	//	out.println("<ul class=\"nav\"><li ><a href=\"index.html\">Home</a></li><li><a href=\"aboutus_page.html\">About</a></li><li><a href=\"contact.html\">Contact</a></li><li><a href=\"https://sites.google.com/a/iiitd.ac.in/tweetmyflick/home\">Blog</a></li><li><a href=\"show.html\">Movie Show Recommendations</a></li></ul>");
 		out.println("<div class=\"nav-collapse\">");
 		out.println("<ul class=\"nav\"><li ><a href=\"index.html\">Home</a></li><li><a href=\"movieshows.html\">Movie Show Recommendations</a></li><li><a href=\"aboutus.html\">Team</a></li><li><a href=\"https://sites.google.com/a/iiitd.ac.in/tweetmyflick/home\">Blog</a></li></ul>");
 		out.println("</div>");
 		out.println("</div>");
 		out.println("</div>");
 		out.println("</div>");
 		
 		out.println("<div class=\"container\">");
 		out.println("<div class=\"row-fluid\">");
 		out.println("<div class=\"span12\">");
 		
 		//out.println("<div id=\"fb-root\"></div><script>(function(d, s, id) {var js, fjs = d.getElementsByTagName(s)[0];if (d.getElementById(id)) return;js = d.createElement(s); js.id = id;js.src = \"//connect.facebook.net/en_US/all.js#xfbml=1\";fjs.parentNode.insertBefore(js, fjs);}(document, 'script', 'facebook-jssdk'));</script>");
 		
 		/*out.println("<div class=\"navbar navbar-fixed-top\"><div class=\"navbar-inner\"><div class=\"container\"><a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\"><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></a><a class=\"brand\" href=\"#\">TweetMyFlick Beta</a><div class=\"nav-collapse\">");
 		out.println("<a class=\"brand\" href=\"#\"><FONT COLOR=\"#0099ff\">Tweet<FONT COLOR=\"#00cccc\">My<FONT COLOR=\"#009999\">Flick <FONT COLOR=\"#999999\">Beta</a>");
 		//out.println("<ul class=\"nav\"><li ><a href=\"index.html\">Home</a></li><li><a href=\"aboutus_page.html\">About</a></li><li><a href=\"contact.html\">Contact</a></li><li><a href=\"https://sites.google.com/a/iiitd.ac.in/tweetmyflick/home\">Blog</a></li><li><a href=\"show.html\">Movie Show Recommendations</a></li></ul>");
 		out.println("<ul class=\"nav\"><li ><a href=\"index.html\">Home</a></li><li><a href=\"hci-website_1.html\">Movie Show Recommendations</a></li><li><a href=\"https://sites.google.com/a/iiitd.ac.in/tweetmyflick/home\">Blog</a></li></ul>");
 		out.println("</div>");
 		out.println("</div>");
 		out.println("</div>");
 		out.println("</div>");*/

 		
 		
 		
 		
 		String a;
 		String flickp=req.getParameter("flick");
 		//String name = req.getParameter("name");
 		//out.println(a);
 		
 		training();
 		
 		  int pos_s = 75;
	        int neg_s = 25;
 		
 		
 		// EARL
 		//out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">");
 		//out.println("body {padding-top: 60px;padding-bottom: 40px;}.sidebar-nav {padding: 9px 0;}</style>");
 		//out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-responsive.css\">");
 		
 		
 		
 		
 		//out.println("</head>");
 		
 		
 		//out.println("<div id=\"fb-root\"></div><script>(function(d, s, id) {var js, fjs = d.getElementsByTagName(s)[0];if (d.getElementById(id)) return;js = d.createElement(s); js.id = id;js.src = \"//connect.facebook.net/en_US/all.js#xfbml=1\";fjs.parentNode.insertBefore(js, fjs);}(document, 'script', 'facebook-jssdk'));</script>");
 		
 		/*out.println("<div class=\"navbar navbar-fixed-top\"><div class=\"navbar-inner\"><div class=\"container\"><a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\"><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></a><a class=\"brand\" href=\"#\">TweetMyFlick Beta</a><div class=\"nav-collapse\">");
 		out.println("<ul class=\"nav\"><li ><a href=\"index.html\">Home</a></li><li><a href=\"hci-website_1.html\">Movie Show Recommendations</a></li><li><a href=\"https://sites.google.com/a/iiitd.ac.in/tweetmyflick/home\">Blog</a></li></ul>");
 	    out.println("</div>");
 		out.println("</div>");
 		out.println("</div>");
 		out.println("</div>");*/
 	        
 		
 		
        out.println("<br><br><p class=\"lead\"><font color=\"#00cccc\"><h2> <img src=\"img/tweetmyflick.png\" height=\"54\" width=\"138\"  /> </img>" + flickp +"</h2></font></p>");
        //out.print("<p class=\"lead\"><h2>" + flickp +"</p>"); //EAR ends
        
 		
 		
 	
 		
 		a= flickp.replaceAll(" ","");
 		a= a.toLowerCase();
 		Tweetcontents arrlst = tweet_collection(a);
 		
 		req.setAttribute("tweetlst",a);
 		  
 		
 		
 			String movie = flickp;
			String search = movie.replaceAll(" ", "+");
			String search1 = movie.replaceAll(" ", "%20");
			//String historyFile = ""+movie.replace(" ", "_")+ ".txt";
			
			
			
			try
			{
			JSONObject json = readJsonFromUrl("http://api.rottentomatoes.com/api/public/v1.0/movies.json?"+"q="+search+"&page_limit=1&page=1&apikey=f6rxdbdebgy5trv6facwefk3");
			 JSONArray a1 = json.getJSONArray("movies");
	       JSONObject o1 = a1.getJSONObject(0);
	       
	       String synopsis = o1.getString("synopsis");
	        String runtime = o1.getString("runtime");
	        JSONObject o2 = o1.getJSONObject("release_dates");
	        JSONObject o3 = o1.getJSONObject("posters");
	        
	        
	        /*JSONArray a2 = o1.getJSONArray("abridged_cast");
	       
	        ArrayList<String> cast = new ArrayList<String>();
	        for(int i=0;i<a2.length();i++)
	        {
	        	JSONObject jo = a1.getJSONObject(i);
	        	cast.add(jo.getString("name"));
	        }*/
	        
	        String rel_date = o2.getString("theater");
	        String poster_url = o3.getString("detailed");
	       
	        
			
	        
	        
	        
	     // EARL   
	        out.println("<div class=\"container-fluid\">");
	        out.println("<div class=\"row-fluid\">");
	          out.println("<div class=\"span4\">");
	         
	            out.println("<div id=\"aboutmovie\" class=\"well\" style=\"height:350px;overflow:auto;\">");
	           
	         
	          
	     
	          
	            //  out.println("<h1>Movie Details</h1>");
	              
	            out.println("<center>");
	            out.println("<h3><font color=\"#808080\" face=\"verdana\">About the Movie</h3></center>");
	            out.println("<center>");
	              out.println("<img src="+poster_url);
	              out.println("</center>");
	  	        out.println("<br>");
	  	        
	  	      out.println("<h5><p align=\"left\"><font color=\"#606060\" face=\"verdana\">Duration- <font color=\"#999999\">" +runtime+ " minutes</p>");
	  	    	out.println("<h5><p align=\"left\"><font color=\"#606060\" face=\"verdana\">Release Date-<font color=\"#999999\">"+rel_date+"</p>");
	  	    out.println("<h5><p align=\"left\"><font color=\"#999999\" face=\"verdana\">" + synopsis + "</p>");
	  	        
	  	        
	  	      /*out.println("<p align=\"left\"><font size=\"4\"><font face=\"verdana\"> color=\"#606060\">"+"Movie Duration: <font face=\"verdana\"> color=\"#999999\">" + runtime + " minutes");
	  	    	out.println("<p align=\"left\"><font size=\"4\"><font face=\"verdana\"> color=\"#606060\">"+"Release Date: <font face=\"verdana\"> color=\"#999999\">" + rel_date);
	  	        
	  	        out.println("<p align=\"left\" class=\"lead\"><font face=\"verdana\"> color=\"#999999\" size=\"4\">"+synopsis);
	  	    	
	  	    	out.println("<p align=\"left\"><font size=\"4\"><font face=\"verdana\"> color=\"black\">");*/
	              
	              
	           out.println("</div>");
	         
			}catch(Exception e)
		       {
		    	   
		    	   System.out.println("Rotten Tomatoes API not working");
		    	   out.println("<div class=\"container-fluid\">");
			        out.println("<div class=\"row-fluid\">");
			          out.println("<div class=\"span4\">");
			         
			            out.println("<div id=\"aboutmovie\" class=\"well\" style=\"height:350px;overflow:auto;\">");
			            out.println("Movie information could not be retrieved at the moment !");
			            out.println("</div>");
			          
		    	   
		    	   e.printStackTrace();
		    	   log.warning("");
		       }
		       finally
		       {
		    	   
		       }    
	           
	           
	           out.println("<div class=\"well\">");
	           out.println("<center>");
	            out.println("<h3><font color=\"#808080\" face=\"verdana\">Trailer</h3>");
	  		//out.println("<iframe class=\"youtube-player\" type=\"text/html\" width=\"250\" height=\"200\" src=\"http://www.youtube.com/embed/fivOhPjX9YM\" frameborder=\"0\">");     
	  		//out.println("</iframe></center>");
            
	  		
	  		
	  		  if(flickp.compareToIgnoreCase("Thuppakki")==0)
	  		  {    out.println("<iframe class=\"youtube-player\" type=\"text/html\" width=\"250\" height=\"200\" src=\"http://www.youtube.com/embed/aW_j4pNvG98\" frameborder=\"0\">");
	  			out.println("</iframe>");
	            //out.println("</div>");
	          //out.println("</div>");
	  		  }
	  		  
	  		  else if(flickp.compareToIgnoreCase("Son of Sardaar")==0)
	  		  {    out.println("<iframe class=\"youtube-player\" type=\"text/html\" width=\"250\" height=\"200\" src=\"http://www.youtube.com/embed/rnuosKzu2Ig\" frameborder=\"0\">");
	  			out.println("</iframe>");
	            //out.println("</div>");
	          //out.println("</div>");
	  		  }
	  		  
	  		  else if(flickp.compareToIgnoreCase("Student of The Year")==0)
	  		  {    out.println("<iframe class=\"youtube-player\" type=\"text/html\" width=\"250\" height=\"200\" src=\"http://www.youtube.com/embed/fivOhPjX9YM\" frameborder=\"0\">");
	  			out.println("</iframe>");
	            //out.println("</div>");
	          //out.println("</div>");
	  		  }
	  		
	  		  else if(flickp.compareToIgnoreCase("Jab Tak Hai Jaan")==0)
	  		  {    out.println("<iframe class=\"youtube-player\" type=\"text/html\" width=\"250\" height=\"200\" src=\"http://www.youtube.com/embed/v0UXgoJ9Shg\" frameborder=\"0\">");
	  			out.println("</iframe>");
	            //out.println("</div>");
	          //out.println("</div>");
	  		  }
	         
	  		  else if(flickp.compareToIgnoreCase("Skyfall")==0)
	  		  {    out.println("<iframe class=\"youtube-player\" type=\"text/html\" width=\"250\" height=\"200\" src=\"http://www.youtube.com/embed/7dlytGZuZxw\" frameborder=\"0\">");
	  			out.println("</iframe>");
	            //out.println("</div>");
	          //out.println("</div>");
	  		  }
	  		
	  		  else if(flickp.compareToIgnoreCase("Life Of Pi")==0)
	  		  {    out.println("<iframe class=\"youtube-player\" type=\"text/html\" width=\"250\" height=\"200\" src=\"http://www.youtube.com/embed/5GbXVo9DdZo\" frameborder=\"0\">");
	  			out.println("</iframe>");
	            //out.println("</div>");
	          //out.println("</div>");
	  		  }
	  		
	  		else
	  		{
	  			String trailerurl = flickp.replace(" ", "_");
	  			out.println("<p><a href=\"http://www.rottentomatoes.com/m/"+trailerurl+"/trailers/\" class=\"btn btn-primary btn-large\">Watch Trailer &raquo;</a></p>");
	  			//out.println("Trailer can not be retrieved at the moment !");
	  		}

			 
	            out.println("</div>");
	            
	            
	            out.println("</div>");  //EARL ends
		  		
	 		  
	        
	      
	        
	  		
	       
	  		
			 

	  	
	           // out.println("<h1>Tweets</h1>");
	            
            
	        
	        
	        
	        //out.println("<div class=\"span4\">");
	      /*  out.println("<p></p>");
	        out.println("<p></p>");
	        out.println("<p></p>");
	        out.println("<p></p>");
	        
	        
	        out.println("&nbsp&nbsp<img src="+poster_url);
	        out.println("<p></p>");
	        out.println("<p></p>");
	        out.println("<p></p>");
	        
	        out.println("<p><font size=\"4\"><font color=\"black\">"+"About "+movie+" :"+synopsis);
	    	out.println("<p><font size=\"4\"><font color=\"red\">"+"Movie Duration: " + runtime + " minutes");
	    	out.println("<p><font size=\"4\"><font color=\"green\">"+"Release Date: " + rel_date);
	    	out.println("<p><font size=\"4\"><font color=\"black\">");*/
	        
	    	
	    	
	    	
	       /* out.println("About"+movie+":  "+synopsis);
	        out.println("Movie duration: "+runtime+" minutes");
	        out.println("Release Date: "+rel_date);
	        out.println("Poster url: " + poster_url);
	        out.println("Movie cast: ");*/
	        /*for(int i=0;i<cast.size();i++)
	        {
	        	out.print(cast.get(i)+", ");
	        }*/
	       
	     
	    
	        
	          
	          
	       
	    double positive =0;
 		double negative =0;
 		
 		
        
 		
 		
 		
 		try
 		{
 		for(int i =0;i<arrlst.retarr.size();i++)
 		{
 			
 			
 			String tweetsend = remove(arrlst.retarr.get(i));
 			tweetsend = remove(tweetsend);
 			
 			
 			String[] arr2=tweetsend.split(" ");
 			String finaltweet=new String();
 			for(int j=0;j<arr2.length;j++)
 			{
 				if(arr2[j].length()==0)
 				{
 					continue;
 				}
 				/*if(arr2[i].contains("!")==true)
 				{
 					arr2[i]=arr2[i].replace("!","! ");
 					str3=str3+arr2[i];
 				}*/
 				finaltweet=finaltweet+arr2[j]+" ";
 				
 			
 			}
 			//Classification cl = new Classification();
 			int polarity = classify(finaltweet);
 			
 			//int polarity = getpolarity (tweetsend,a);
 			
 			//int polarity = getpolarity(tweetsend,a);
 			
 			if(polarity==4)
 			{
 				
 				
 				positive = positive +1;
 			}
 			else if(polarity==0)
 			{
 				//out.println("<h2><SPAN style=\"BACKGROUND-COLOR: #F778A1\">Tweet: "+arrlst.retarr[i]+"</SPAN></h2>");
 				//out.println("Created At: " + arrlst.created_at[i]);
 				
 				//out.println("<h3>Negative</h3>");
 				negative = negative +1;
 			}
 			else if(polarity ==2)
 			{
 				
 			}
 			else
 			{
 				
 			}
 			
 			
 			
 			
 			
 		}
 		
 		
 		//out.println("<h2> Real Time Sentiment of " + flickp);
 		
 		//out.println("<div class=\"span4\">");	
 		
 		double pos_sent = (positive/(positive + negative)) * 100; 
 		double neg_sent = (negative/(positive + negative)) * 100;
 		
 		
 		  out.println("<script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>");
	   		out.println("<script type=\"text/javascript\">");
	   		out.println("google.load('visualization', '1.0', {'packages':['corechart']});");
	   		out.println(" google.setOnLoadCallback(drawChart);");
	   		out.println("function drawChart() {");
	   		out.println("var data = new google.visualization.DataTable();");
	   		out.println("data.addColumn('string', 'Sentiment');");
	   		out.println("data.addColumn('number', 'Percentage');");
	   		out.println("data.addRows([");
	   		out.println("['Positive', "+pos_sent+"],");
	   		out.println(" ['Negitive', "+neg_sent+"]");
	   		out.println(" ]);");
	   		out.println(" var options = {'title':'Real Time Twitter Sentiment',");
	   		out.println(" chartArea:{left:20,top:0,width:\"100%\",height:\"100%\"},"); 
	   		out.println(" colors:['#009999','red'],");
	   		out.println(" 'width':210,");
	   		out.println("'height':300};");
	   		
	   		out.println(" var chart = new google.visualization.PieChart(document.getElementById('piechart'));");
	   		out.println("chart.draw(data, options);");
	   		out.println(" }");
	   		out.println(" </script>");      
	          
	   		Random rand = new Random();
	   		int num = 50 + rand.nextInt(40);
	   		int num1 = 50 + rand.nextInt(40);
	   		int num2 = 50 + rand.nextInt(40);
	   		int num3 = 50 + rand.nextInt(40);
	   		int num4 = 50 + rand.nextInt(40);
	   		
	   		
	   		
	   		out.println("<script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>");
	   		out.println("<script type=\"text/javascript\">");
	   		out.println("google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});");
	   		out.println("google.setOnLoadCallback(drawChart);");
	   		out.println("function drawChart() {");
	   		out.println("var data = google.visualization.arrayToDataTable([");
	   		out.println("['x', 'sentiment'],");
	   		out.println("['-5'," + num+"],");
	   		out.println("['-4'," + num1+"],");
	   		out.println("['-3'," + num2+"],");
	   		out.println("['-2'," + num3+"],");
	   		out.println("['-1'," + num4+"],");
	   		out.println("]);");

	   		out.println("var options = {");
	   		out.println("title: 'Twitter sentiment last 5 days',");
	   		out.println("chartArea:{left:10,top:0,width:\"75%\",height:\"75%\"},");
	   		//out.println("hAxis.title: 'Last x days',");
	   		//out.println("vAxis.title: 'Twitter Sentiment'");
	   		
	   		out.println("};");

	   		out.println("var chart = new google.visualization.LineChart(document.getElementById('linechart'))");
	   		out.println("chart.draw(data, options);");
	   		out.println("}");
	   		out.println(" </script>");  
	   		
 		
	   		out.println("<div class=\"span4\">");
  			//out.println("<div class=\"well\">");    
  		//out.println("<div id=\"piechart\" class=\"well\">");
             // out.println("<img src=\"img\\pie.png\" height=\"300\" width=\"500\">");
              
           
     		
  		 out.println("<center>");
            out.println("<h3><font color=\"#808080\" face=\"verdana\">Aggregated Twitter Sentiment</h3>");
            out.println("</center>");
            
            out.println("<table class=\"table\">");
			
            out.println("<tbody>");
			
           
            
            
            out.println("<tr>");
            if(arrlst.retarr.size()==0)
            {
            	 out.println("<tr>"); 
            	out.println("Twitter API is having some difficulties on your search. Try agin later. <a href=\"index.html\">Go Back</a>");
            	 out.println("</tr>");
            }
            
            
            else
            {
            	out.println("<tr>"); 
            out.println("<td><center><h4><FONT FACE=\"Verdana\" color=\"#999999\">Positive Sentiment</center></td>");
            out.println("<td><center><h4><FONT FACE=\"Verdana\" color=\"#009999\">"+Math.round(pos_sent)+" %</center></td>");
                
            out.println("</tr>");
            //out.println("</thead>");
            //out.println("<tbody>");
            out.println("<tr>");
            out.println("<td><center><h4><FONT FACE=\"Verdana\" color=\"#999999\">Negative Sentiment</center></td>");
            out.println("<td><center><h4><FONT FACE=\"Verdana\" COLOR=\"#f80000\">"+Math.round(neg_sent)+" %</center></td>");
            out.println("</tr>");
          /*  out.println("<tr>");
            out.println("<td><center><h4><FONT FACE=\"Verdana\" COLOR=\"#999999\">Today</center></td>");
          
            
            
            //out.println("</div>");
            
            out.println("</tr>");*/
            
            out.println("<tr>");
            out.println("<td><center><h4><FONT FACE=\"Verdana\" COLOR=\"#999999\">Realtime</center></td>");
            out.println("<td><div id=\"piechart\"></div></td>");
            out.println("</tr>");
            
           /* out.println("<tr>");
            out.println("<td><center><h4><FONT FACE=\"Verdana\" COLOR=\"#999999\">Last 5 days</center></td>");
            out.println("<td><div id=\"linechart\"></div></td>");
            out.println("</tr>");*/
            
            
            }
           
  		  
  		  //out.println("<div class=\"well\">");
             // out.println("<h1>Graph2!</h1>");
  		 //out.println("<img src=\"img\\bar.png\" height=\"300\" width=\"500\">");    
  		  
            //out.println("</div>");
  		  
            out.println("</tbody>");
            out.println("</table>");

            
          out.println("</div>");
	
 		
          out.println("<div class=\"span4\">");
          out.println("<div class=\"well\" style=\"height:700px;overflow:auto;\">");
           //out.println("<h1>Tweets</h1>");
         // out.println("<h2>Opnion from Twitter</h2>");
          out.println("<h3><center><font color=\"#808080\" face=\"verdana\">Tweets</h1>");
          out.println("</center>");
          out.println("<table class=\"table table-striped table-hover\">");

          out.println("<tbody>"); 
 		
 		
 	//	out.println("<div class=\"span4\">");
     //   out.println("<div class=\"hero-unit\">");
 		
 	/*	out.println("<script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>");
 		out.println("<script type=\"text/javascript\">");
 		out.println("google.load('visualization', '1.0', {'packages':['corechart']});");
 		out.println(" google.setOnLoadCallback(drawChart);");
 		out.println("function drawChart() {");
 		out.println("var data = new google.visualization.DataTable();");
 		out.println("data.addColumn('string', 'Sentiment');");
 		out.println("data.addColumn('number', 'Percentage');");
 		out.println("data.addRows([");
 		out.println("['Positive', "+pos_sent+"],");
 		out.println(" ['Negative', "+neg_sent+"]");
 		out.println(" ]);");
 		out.println(" var options = {'title':'Twitter Sentiment Analysis',");
 		out.println(" 'width':800,");
 		out.println("'height':650};");
 		out.println(" var chart = new google.visualization.PieChart(document.getElementById('span4'));");
 		out.println("chart.draw(data, options);");
 		out.println(" }");
 		out.println(" </script>");*/
 		
 		
 		//out.println("</head>");
 		
 		//out.println("</div>"); 
 		
 		//out.println("&nbsp&nbsp<h2><font color=\"blue\">Thumps Up: "+Math.round(pos_sent)+" %</font></h2>");
 		//out.println("&nbsp&nbsp<h2><font color=\"blue\">Thumps Down: "+Math.round(neg_sent)+" %</font></h2>");
 		
 		//out.println("</div>");
 		
 		
 		
 		for(int i =0;i<arrlst.retarr.size();i++)
 		{
 			
 			String tweetsend = remove(arrlst.retarr.get(i));
 			int polarity = classify(tweetsend);
 			if(polarity==4)
 			{
 				//out.print("&nbsp&nbsp<h4><SPAN style=\"BACKGROUND-COLOR: #C3FDB8\">"+arrlst.retarr.get(i)+"</SPAN></h4><br>");
 				out.print("<tr>");
 				out.print("<td><center><img src=\"img/thumbsup.png\" height=\"50\" width=\"50\"></center>");
 				out.print("<h5><FONT FACE=\"Verdana\" COLOR=\"#999999\">"+arrlst.retarr.get(i)+"</td>");
                
                out.print("</tr>");
 				
 				
 				//out.println("&nbsp&nbsp<h4>Created At: " + arrlst.created_at.get(i));
 				
 				//out.println("&nbsp&nbsp<h5>Positive</h5>");
 				
 				
 			}
 			else if(polarity==0)
 			{
 				//out.print("&nbsp&nbsp<h4><SPAN style=\"BACKGROUND-COLOR: #F778A1\">"+arrlst.retarr.get(i)+"</SPAN></h4><br>");
 				//out.print("<img src=\"img\\birdie2.png\" height=\"42\" width=\"42\">");
 				
 				out.print("<tr>");
 				out.print("<td><center><img src=\"img/thumbsdown.png\" height=\"50\" width=\"50\"></center>");
 				out.print("<h5><FONT FACE=\"Verdana\" COLOR=\"#999999\">"+arrlst.retarr.get(i)+"</td>");
                
                out.print("</tr>");
 				
 				//out.println("&nbsp&nbsp<h4>Created At: " + arrlst.created_at.get(i));
 				
 				//out.println("&nbsp&nbsp<h5>Negative</h5>");
 				
 			}
 			else if(polarity ==2)
 			{
 				//out.println("&nbsp&nbsp<h4><SPAN style=\"BACKGROUND-COLOR: #ffffff\">Tweet: "+arrlst.retarr.get(i)+"</SPAN></h4>");
 				//out.println("&nbsp&nbsp<h4>Created At: " + arrlst.created_at.get(i));
 				//out.println("&nbsp&nbsp<h5>Neutral</h5>");
 			}
 			else
 			{
 				//out.print("&nbsp&nbsp<h4>Error in computation");
 			}
 			
 		}
 		
 		
 		out.print("</tbody>");
 		out.print("</table>");
 		//  out.println("<h1>Tweets</h1>");
    
 		
 		out.println("</div>");
		
 	    out.println("</div>");

 		}catch(Exception e)
 		{
 			e.printStackTrace();
 			
 			out.println("<div class=\"span4\">");
 	        out.println("<div class=\"well\" style=\"height:500px;overflow:auto;\">");
 			out.println("<h2><font color=\"black\">Calling Twitter API is having some difficulties. Why don't you try again !</font></h2>");
 			out.println("</div>");
 			
 	 	    out.println("</div>");
 		}
 	    
 		
 		//out.println("&nbsp&nbsp<h3><font color=\"blue\"><a href=\"report.html\">Report Tweets</a></font></h3>");
 		
 		out.println("<hr>");
 		
 		out.println("</p>");
 		out.println("</div>");
		
 	    out.println("</div>");


 	  //  out.println("<footer>");
 	   // out.println("&nbsp&nbsp<p>&copy; TweetMyFlick</p>");
 	    
 	     //out.println("<marquee direction=\"left\" scrolldelay=\"90\" scrollamount=\"6\" behavior=\"scroll\" loop=\"0\" style=\"height:24px;z-index:29;background-color:#D8D8D8;border:1px #B8CFE9 solid;\" id=\"Marquee1\" onmouseover=\"this.stop()\" onmouseout=\"this.start()\"><font style=\"font-size:13px\" color=\"#424242\" face=\"Arial\">Recent Twitter Opinion :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; Barfi </font><font style=\"font-size:13px\" color=\"#32CD32\" face=\"Arial\">88%</font><font style=\"font-size:13px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:13px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; SOTY </font><font style=\"font-size:13px\" color=\"#32CD32\" face=\"Arial\">68%</marquee>");
 	    
       // out.println("<marquee direction=\"left\" scrolldelay=\"60\" scrollamount=\"6\" behavior=\"scroll\" loop=\"0\" style=\"height:40px;z-index:29;background-color:#D8D8D8;\" id=\"Marquee1\" onmouseover=\"this.stop()\" onmouseout=\"this.start()\"><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">Recent Twitter Opinion :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<img src=\"img/jthj1.jpg\" alt=\"JTHJ\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Jab Tak Hai Jaan'><font color=\"#424242\">Jab Tak Hai Jaan</font></a></font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">&nbsp;73%</font><font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/sos1.jpg\" alt=\"SOS\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Son of Sardaar'><font color=\"#424242\">Son of Sardaar</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">68% <font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/talaash1.jpg\" alt=\"Talaash\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Talaash'><font color=\"#424242\">Talaash</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">71%<font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/khiladi7861.jpg\" alt=\"Khiladi786\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Khiladi 786'><font color=\"#424242\">Khiladi 786</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">78%<font style=\"font-size:20px\" color=\"#32CD32\" face=\"Arial\"> </font><font style=\"font-size:20px\" color=\"#424242\" face=\"Arial\">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src=\"img/lifeofpi1.jpg\" alt=\"LifeOfPi\" width=\"50\" height=\"80\"><a href='/tweetmyflickhci?flick=Life Of Pi'><font color=\"#424242\">Life of Pi</font></a> </font><font style=\"font-size:20px\" color=\"#009933\" face=\"Arial\">86%</marquee>");
 	    
 	  //  out.println("</footer>");

 	    out.println("</div>"); 

 	    
 	   out.println("<script  src=\"https://www.google.com/jsapi\"></script>");
 	    out.println("<script src=\"bootstrap.js\"></script>");
 	    out.println("<script src=\"bootstrap.min.js\"></script>");
 		
 		
 		 //resp.sendRedirect("/tweetmyflick.jsp?Company=" + a);
 		 
 		
 		
 		
    	 
    	 
    	 
    }

     
     
     
   //  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	//		throws IOException {
		
		
	//}
     
   
    
     
     
	
	public Tweetcontents tweet_collection(String query)
	{
		ArrayList<String> arrret = new ArrayList<String>(); 
		
		Tweetcontents tc = new Tweetcontents();
		

		
		try
         {
          int p=0;
          //PrintWriter pw = new PrintWriter("tnlhg.txt");
          String since_id=null;
          query.replace(" ", "");
          
          // OAuth for search API
          
         // OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
          //        ConsumerKey,
          //        ConsumerSecret);
          //consumer.setTokenWithSecret(AccessToken, AccessSecret);
         
   
         tc = twitteroauth(query);
          
         /* 
         while(p!=3)
         {
         
        // https://api.twitter.com/1.1/search/tweets.json?q=%23freebandnames&since_id=24012619984051000&max_id=250126199840518145&result_type=mixed&count=4
        
        	 JSONObject obj1;
        	 if(p==0) 
        {
    	   obj1= readJsonFromUrl("https://api.twitter.com/1.1/search/tweets.json?q=%23"+query+"&amp;count=100&amp;include_entities=false&amp;result_type=recent;lang=en");
    	  
        }
        else
        {
        	obj1= readJsonFromUrl("https://api.twitter.com/1.1/search/tweets.json?q=%23"+query+"&amp;count=100&amp;include_entities=false&amp;result_type=recent;lang=en;&page="+(p+1));
        }
        	
        // JSONObject obj= (JSONObject) JSONSerializer.toJSON(content);
          //Double tweet=obj.getDouble("completed_in");
          String a = obj1.getString("results");
          //a=a.replace("[","");
          //a=a.replace("]", "");
          JSONArray arr = new JSONArray(a);
          String retarr[]= new String[arr.length()];
          String tweet_id[] = new String[arr.length()];
          String created_at[] = new String[arr.length()];
         

          //FileWriter fstream = new FileWriter("ekdeewanatha.txt");
         // BufferedWriter out = new BufferedWriter(fstream);

          
          
          for(int i=0;i<arr.length();i++)
          {

              JSONObject o = arr.getJSONObject(i);
              retarr[i]=o.getString("text");
              tweet_id[i] = o.getString("id_str");
              created_at[i] = o.getString("created_at");
              
             // since_id[i] = o.getString("since_id");

             
              //pw.println(retarr[i]);
              //pw.println("");
              //System.out.println(retarr[i]+" : "+tweet_id[i]);
             
              
              arrret.add(retarr[i] + "          " +created_at[i]);
              
              //pw.println("");
              //out.write(retarr[i]+" : "+tweet_id[i]+"\n");

          }
         // since_id = tweet_id[0];
          //System.out.println("Since_id: "+since_id);
          //pw.flush();
          for(int i=0;i<retarr.length;i++)
          {
        	  tc.retarr.add(retarr[i]);
        	  tc.created_at.add(created_at[i]);
        	  tc.tweet_id.add(tweet_id[i]);
          }
          p=p+1;

        

       
         
        
         
         
             }*/

       // out.close();
         //pw.close();
         return tc;
       


     }catch(Exception e)
         {
             
    	 	e.printStackTrace();
    	 	return tc;
         }
     

 
 }
	
	 private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }

		  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		    InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONObject json  = new JSONObject(jsonText);
		      return json;
		    } finally {
		      is.close();
		    }
		  }
	
	
	public static String remove(String str) throws Exception
	{
		String[] arr=str.split(" ");
		File com=new File("Common Words.txt");
		//String path = Thread.currentThread().getContextClassLoader().getResource("/data/Common Words.txt").getFile(); 
		String str2=new String();
		for(int i=0;i<arr.length;i++)
		{
			//System.out.println(arr[i]);
			//Removing username
			
			if(arr[i].startsWith("@")==true || arr[i].contains("#")==true)
			{
				continue;
			}
			//removing RT
			if(arr[i].equalsIgnoreCase("RT")==true)
			{
				continue;
			}
			//removing one and two -letter words
			if(arr[i].length()==1 || arr[i].length()==2)
			{
				continue;
			}
			if(arr[i].startsWith("http")==true)
			{
				continue;
			}
			//removing ... dots
			if(arr[i].contains(".")==true)
			{
				arr[i]=arr[i].replace('.',' ');
				str2=str2+arr[i]+" ";
				continue;
			}
			if(arr[i].contains("!")==true)
			{
				//System.out.println(arr[i]);
				String temp=arr[i].replace("!"," ");
				//System.out.println(temp);
				
				str2=str2+temp+" ";
				continue;
			}
			if(arr[i].contains(",")==true)
			{
				arr[i]=arr[i].replace(',',' ');
				str2=str2+arr[i]+" ";
				continue;
			}
			
			String stri;
			int flag=0;
			
			BufferedReader br=new BufferedReader(new FileReader(com));
			
			while((stri=br.readLine())!=null)
			{
				//System.out.println(stri);
				if(arr[i].equalsIgnoreCase(stri)==true)
				{
					//System.out.println("reached "+arr[i]);
					flag=1;
					break;
				}
			}
			if(flag==1)
			{
				continue;
			}
			str2=str2+arr[i]+" ";
			
			//System.out.println(str2);
				
		}
		return str2;
	}
	
	
	
	
	
	public int classify(String testtweet)
	{
		// extract the features -> from bag of words
        // from the training set
        // length of individual tweet

        // C= class (+ve or -ve) ; T = tweet
        // Bayes classifier : P(C | T) = P(T | C). P(C) / P(T)
        // P(C) = total no of +ve/-ve / total
        // P(T) = P(T | C1).P(C1) + P(T | C2).P(C2)

        try
        {

       
            //int a[] = new int[10];
            //a[0] = 5;
            
        	
        	//File fle = new File("/Tweetmyflick/war/WEB-INF/data/pos.txt");
        	//File fle1 = new File("/Tweetmyflick/war/WEB-INF/data/neg.txt");
        	//RandomAccessFile raf = new RandomAccessFile(fle,"r");
        	//RandomAccessFile raf1 = new RandomAccessFile(fle1,"r");
       
        	//ServletContext context = getServletContext();
        	
			//String is = getServletContext().getRealPath("/Tweetmyflick/war/WEB-INF/data/pos.txt");
            //String is1 = getServletContext().getRealPath("/Tweetmyflick/war/WEB-INF/data/neg.txt");
        	
        	
                ArrayList<Double> prob = new ArrayList<Double>();
                 ArrayList<Double> prob1 = new ArrayList<Double>();
                 String[] testwords = testtweet.split(" ");
                 for(int i =0;i<testwords.length;i++)
                 {
                	 testwords[i] = testwords[i].toLowerCase();
                 }
                 ArrayList<String> twords = new ArrayList<String>();
                 twords.addAll(Arrays.asList(testwords));
                 
                //int var=0;
               /* for (int i=0;i<twords.size();i++)
                {

                    if(hm.containsKey(twords.get(i)) && !(hm1.containsKey(twords.get(i))))
                    {
                       double freq1= hm.get(twords.get(i));
                       //double freq2= hm1.get(twords.get(i));
                       prob.add((freq1/tot_words_pos)*priorpos);
                       prob1.add(0.0);
                    }
                    if(hm1.containsKey(twords.get(i)) && !(hm.containsKey(twords.get(i))))
                    {
                       //double freq1= hm.get(twords.get(i));
                       double freq2= hm1.get(twords.get(i));
                       //prob.add((freq1/tot_words_pos)*priorpos);
                       prob1.add((freq2/tot_words_neg)*priorneg);
                       prob.add(0.0);
                    }
                    else if(hm.containsKey(twords.get(i)) && hm1.containsKey(twords.get(i)))
                    {
                    	 double freq1= hm.get(twords.get(i));
                    	 double freq2= hm1.get(twords.get(i));
                    	 prob.add((freq1/tot_words_pos)*priorpos);
                    	 prob1.add((freq2/tot_words_neg)*priorneg);
                    	 
                    }
                    else
                    {
                    	 prob.add(0.0);
                    	 prob1.add(0.0);
                    }
                    
                    
                }*/
                 
                 
                 for (int i=0;i<twords.size();i++)
                 {

                     if(hm.containsKey(twords.get(i)))
                     {
                        double freq1= hm.get(twords.get(i));
                        //double freq2= hm1.get(twords.get(i));
                        prob.add((freq1/tot_words_pos)*priorpos);
                        //prob1.add(0.0);
                     }
                     if(hm1.containsKey(twords.get(i)))
                     {
                        //double freq1= hm.get(twords.get(i));
                        double freq2= hm1.get(twords.get(i));
                        //prob.add((freq1/tot_words_pos)*priorpos);
                        prob1.add((freq2/tot_words_neg)*priorneg);
                        //prob.add(0.0);
                     }
                 }
                 
                 
                double tot_prob_pos=1;
                double tot_prob_neg=1;
                for(int i=0;i<prob.size();i++)
                {
                    tot_prob_pos = tot_prob_pos *prob.get(i);
                    tot_prob_neg = tot_prob_neg *prob1.get(i);
                }

                if((tot_prob_pos - tot_prob_neg)/(tot_prob_pos) > 0.5)
                {
                  /*  System.out.println(testtweet);
                	System.out.println("Positive prob: " + tot_prob_pos);
                    System.out.println("Negative prob: " + tot_prob_neg);
                    System.out.println("Classified as Positive Tweet");*/
                    return 4;

                }

            else if((tot_prob_neg - tot_prob_pos)/(tot_prob_neg) > 0.5)
                {
            	 	/*System.out.println(testtweet);
            		System.out.println("Positive prob: " + tot_prob_pos);
                    System.out.println("Negative prob: " + tot_prob_neg);
                    System.out.println("Classified as Negative Tweet");*/
                    return 0;
               }
                else
                {
                	/*System.out.println(testtweet);
                	System.out.println("Positive prob: " + tot_prob_pos);
                    System.out.println("Negative prob: " + tot_prob_neg);
                    System.out.println("Can not be classified with this data");*/
                    return 2;
                }


                

        }catch(Exception e)
        {
            e.printStackTrace();
            return -1;
        }

    }
	
	public void training()
	{
		try
		{
			
			String path1 = "freq_pos.txt";
			String path2 = "freq_neg.txt";
			String path3 = "priors.txt"; 
			
			FileInputStream f = new FileInputStream(path1);
            FileInputStream f1 = new FileInputStream(path2);
            FileInputStream f2 = new FileInputStream(path3);
            DataInputStream d = new DataInputStream(f);
            DataInputStream d1 = new DataInputStream(f1);
            DataInputStream d2 = new DataInputStream(f2);
            BufferedReader br = new BufferedReader(new InputStreamReader(d));
            BufferedReader br1 = new BufferedReader(new InputStreamReader(d1));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(d2));
            
            String pos_freq;
            while((pos_freq=br.readLine())!=null)
            {
            	String pos_freq_arr[] = pos_freq.split(" ");
            	hm.put(pos_freq_arr[0],Integer.parseInt(pos_freq_arr[1]) );
            }
            
            String neg_freq;
            while((neg_freq=br1.readLine())!=null)
            {
            	String neg_freq_arr[] = neg_freq.split(" ");
            	hm1.put(neg_freq_arr[0],Integer.parseInt(neg_freq_arr[1]) );
            }
			
            priorpos = Double.parseDouble(br2.readLine());
            priorneg = Double.parseDouble(br2.readLine());
            tot_words_pos = Double.parseDouble(br2.readLine());
            tot_words_neg = Double.parseDouble(br2.readLine());
			
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
	}
	
	private static AccessToken loadAccessToken(){
	    String token = AccessToken;
	    String tokenSecret = AccessSecret;
	    return new AccessToken(token, tokenSecret);
	  }
	
	public Tweetcontents twitteroauth(String quer) throws Exception
	{
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(ConsumerKey)
		  .setOAuthConsumerSecret(ConsumerSecret)
		  .setOAuthAccessToken(AccessToken)
		  .setOAuthAccessTokenSecret(AccessSecret)
		  .setUseSSL(true);
		TwitterFactory factory = new TwitterFactory(cb.build());
		
	    
	    Tweetcontents tc = new Tweetcontents();
		
	    // The factory instance is re-useable and thread safe.
	    Twitter twitterResults = factory.getInstance();
	    Query query = new Query(quer);
	    query.setCount(100);
	    QueryResult result = twitterResults.search(query);
	
		
		List<Status> s = result.getTweets();
		ArrayList<String> retarr = new ArrayList<String>();
		ArrayList<String> tweet_id = new ArrayList<String>();
		ArrayList<String> created_at = new ArrayList<String>();
		for(int i=0;i<s.size();i++)
		{
			//System.out.println(s.get(i).getText());
			retarr.add(s.get(i).getText());
			tweet_id.add("" +s.get(i).getId());
			created_at.add(""+s.get(i).getCreatedAt());
		}
	
		 for(int i=0;i<retarr.size();i++)
         {
       	  tc.retarr.add(retarr.get(i));
       	  tc.created_at.add(created_at.get(i));
       	  tc.tweet_id.add(tweet_id.get(i));
         }
		
		 return tc;
		
	}
    
	

	
}


class Tweetcontents
{

    ArrayList<String> retarr = new ArrayList<String>(); // the tweet text to be returned
    //int polarity[]; // the sentiment
    ArrayList <String> tweet_id = new ArrayList<String>(); // the tweet id of the tweet
    ArrayList<String> created_at = new ArrayList<String>(); // the query in question

}