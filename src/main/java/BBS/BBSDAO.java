package BBS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BBSDAO {
    private static String dburl="jdbc:mysql://localhost:3307/SODA";
    private static String dbID="root";
    private static String dbpassword="kkjjss103@";
    Connection conn = null;
    PreparedStatement ps=null;
    ResultSet rs=null;


    public String getDate(){

        String SQL="SELECT NOW()";
        try {
            PreparedStatement pstmt =conn.prepareStatement(SQL);
            rs=pstmt.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";//데이터 베이스 오류
    }
    public int getNext(){
        String SQL="SELECT ID FROM BBS ORDER BY ID DESC ";
        try {
            PreparedStatement pstmt =conn.prepareStatement(SQL);
            rs=pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1)+1;
            }
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;//데이터 베이스 오류
    }

    public int adduser(BBS bbs){
        int insertCount=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dburl, dbID, dbpassword);//나으 데이터베이스에 접근
            String sql = "INSERT INTO BBS VALUES (?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setInt(1,getNext());
            ps.setString(2,bbs.getName());
            ps.setString(3,bbs.getTitle());
            ps.setString(4,getDate());

            insertCount = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return insertCount;
    }

    public List<BBS> getUsers(){
        List<BBS> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            //클래스를 찾을수 없을때 예외 처리
            e.printStackTrace();
        }
        String sql="SELECT * FROM bbs";
        try (Connection conn =DriverManager.getConnection(dburl,dbID,dbpassword);
             PreparedStatement ps=conn.prepareStatement(sql)){
            try (ResultSet rs=ps.executeQuery(sql)){
                while (rs.next()){
                    int id=rs.getInt(1);
                    String name=rs.getString(2);
                    String title=rs.getString(3);
                    String Date=rs.getString(4);
                    BBS bbs=new BBS(id,name,title,Date);
                    list.add(bbs);
                }
            }catch (Exception e){
                e.printStackTrace();
            }}catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
