# Management-System_Project_Bug_Fixes
--------------------------------
Data base export file added as --->
riyoma_DB.sql
My sql workbench
--------------------------------

   private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/riyoma", "root", "Dev@1234");
 --------------------------------
