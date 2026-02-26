import java.sql.*;

class DT2Part2{
    public static void main(String args[]) {
        try {
            Connection dbCxn = DriverManager.getConnection(
                "jdbc:mysql://localhost:53326/BoatsAndSailors",
                "root",
                "password"
            );

            String boatQuery = "select * from Boat";
            System.out.println(boatQuery);
            Statement selectFromBoat = dbCxn.createStatement();
            ResultSet rsBoat = selectFromBoat.executeQuery(boatQuery);

            while (rsBoat.next()) {
                System.out.println(
                    rsBoat.getInt(1)      // Boat_pk
                    + "  " + rsBoat.getString(2)  // Boat_model
                    + "  " + rsBoat.getString(3)  // Boat_name
                    + "  " + rsBoat.getFloat(4)   // Boat_LOA
                );

                int boatPk = rsBoat.getInt(1);
                String sailorQuery =
                    "select * from Sailor where Sailor_Boat_pk=" + boatPk + "";
                System.out.println(sailorQuery);

                Statement selectFromSailor = dbCxn.createStatement();
                ResultSet rsSailor = selectFromSailor.executeQuery(sailorQuery);

                while (rsSailor.next()) {
                    System.out.println(
                        rsSailor.getInt(1)      // Sailor_pk
                            + "  " + rsSailor.getString(2)  // Sailor_name
                            + "  " + rsSailor.getString(3)  // Sailor_role
                            + "  " + rsSailor.getDate(4)    // Sailor_DOB
                            + "  " + rsSailor.getInt(5)     // Sailor_Boat_pk
                    );
                }
            }

            dbCxn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
