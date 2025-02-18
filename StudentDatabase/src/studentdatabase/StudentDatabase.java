package studentdatabase;
import java.sql.*;
public class StudentDatabase{
    private static final String URL="jdbc:mysql://localhost:3306/student_db";
    private static final String USER="root";
    private static final String PASSWORD="jssise";
    public static void main(String args[]){
        try(Connection conn=DriverManager.getConnection(URL,USER,PASSWORD)){
            insertStudent(conn,"John",22,"ISE");
             insertStudent(conn,"peter",22,"ISE");
            searchStudent(conn,"John");
            updateStudent(conn,"John",23);
            deleteStudent(conn,"John");
        }catch(SQLException e){
            e.printStackTrace();
            
        }
    } 

    private static void insertStudent(Connection conn, String name, int age, String department)
    throws SQLException{
        String sql="INSERT INTO Student(name,age,department)VALUES(?,?,?)";
        try(PreparedStatement statement=conn.prepareStatement(sql)){
            statement.setString(1,name);
            statement.setInt(2,age);
            statement.setString(3,department);
            int rowInserted=statement.executeUpdate();
            if(rowInserted>0){
                System.out.println("A new student has been inserted successfully!");
            }
        }
        }
     
//To change body of generated methods, choose Tools | Templates.
    

    private static void searchStudent(Connection conn, String name)throws SQLException{
        String sql="SELECT*FROM student WHERE name=?";
        try(PreparedStatement statement=conn.prepareStatement(sql)){
            statement.setString(1,name);
            ResultSet result=statement.executeQuery();
            if(result.next()){
                  System.out.println("Student found: ");
                    System.out.println("Name: "+result.getString("name"));
                      System.out.println("Age: "+result.getInt("age"));
                        System.out.println("Department: "+result.getString("department"));
            }else{
                  System.out.println("No student found with the name: "+name);
            }
        }
    }

    private static void updateStudent(Connection conn, String name, int newage)throws SQLException
    {
        String sql="UPDATE student SET age=? WHERE name=?";
        try(PreparedStatement statement=conn.prepareStatement(sql)){
            statement.setInt(1,newage);
            statement.setString(2,name);
            int rowsUpdated=statement.executeUpdate();
            if(rowsUpdated>0){
                System.out.println("Students age has been updated successfully!");
            }else{
                 System.out.println("No student found with the name:"+name);
                 
                
            
        }
        }
        
    }
//To change body of generated methods, choose Tools | Templates.

    private static void deleteStudent(Connection conn, String name)throws SQLException{
        String sql="DELETE from student WHERE name=?";
        try(PreparedStatement statement=conn.prepareStatement(sql)){
            statement.setString(1,name);
            int rowsDeleted=statement.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("Student has been deleted Successfully!");
            }else{
                System.out.println("No student found with the name:"+name);
                
            }
        }
        
    }
    }
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
}
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
PrintWriter out = response.getWriter();
String username = request.getParameter("username");
out.println("<html>");
out.println("<head>");
out.println("<title>Greeting Message</title>");
out.println("</head>");
out.println("<body>");
out.println("<h2>Hello " + username + "</h2>");
out.println("<p>How Are You?</p>");
out.println("</body>");
out.println("</html>");
}



out.println("<!DOCTYPE html>");