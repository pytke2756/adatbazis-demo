package hu.petrik.adatbazisdemo;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Adatbazis db = new Adatbazis();
            List<Dolgozo> dolgozoList = db.dolgozokListazasa();
            for (Dolgozo item : dolgozoList) {
                System.out.println(item);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
