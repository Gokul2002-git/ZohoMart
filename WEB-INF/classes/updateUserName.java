import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/updateusername")
public class updateUserName extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
                HttpSession session = req.getSession();
                int userid = (int) session.getAttribute("id");
                String name=req.getParameter("name");
                
                try {
                    
                    String dbDriver = "com.mysql.jdbc.Driver";
                    String dbURL = "jdbc:mysql:// localhost:3306/";
                    String dbName = "zohomart";
                    String dbUsername = "root";
                    String dbPassword = "Gokul@2002";
                    Class.forName(dbDriver);
                    Connection con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword);
                    PreparedStatement st = con.prepareStatement("UPDATE users SET name=? where userId=?");
                    st.setString(1, name);
                    st.setInt(2, userid);
                    st.executeUpdate();
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

