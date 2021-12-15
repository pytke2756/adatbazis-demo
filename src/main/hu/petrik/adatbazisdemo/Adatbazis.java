package main.hu.petrik.adatbazisdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Adatbazis {
    /*adatbázisnév
    * kapcsolattípus
    * portszám
    * hostnév
    */
    private static final String url = "jdbc:mysql://localhost:3306/dolgozok";
    private static final String username = "root";
    private static final String password = "";

    /*
    * adabázisfiók felhasználónév
    * adatbázisfiók jelszó
    * */
    private Connection conn;

    public Adatbazis() throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public List<Dolgozo> dolgozokListazasa() throws SQLException {
        List<Dolgozo> dolgozoList = new ArrayList<>();
        String sql = "SELECT * FROM dolgozok";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);

        while (result.next()){
            int id = result.getInt("id");
            int kor = result.getInt("kor");
            int fizetes = result.getInt("fizetes");
            String nev = result.getString("nev");
            String nem = result.getString("nem");
            Dolgozo dolgozo = new Dolgozo(id, nev, nem, kor, fizetes);
            dolgozoList.add(dolgozo);
        }
        return dolgozoList;
    }
}
