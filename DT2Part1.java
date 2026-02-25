import java.sql.*;
class DevTech2Part1{
	public static void main(String args[]){
		try{
			Connection dbCxn=DriverManager.getConnection(
				"jdbc:mysql://localhost:53326/BoatsAndSailors","root","password"
			);
			
			String boatQuery = "select * from Boat";
			System.out.println(boatQuery);
			Statement selectFromBoat=dbCxn.createStatement();
			ResultSet rsBoat=selectFromBoat.executeQuery(boatQuery);
			while(rsBoat.next()) {
				System.out.println(rsBoat.getInt(1)		//Boat_pk
					+ "  " + rsBoat.getString(2) 		//Boat_model
					+ "  " + rsBoat.getString(3)		//Boat_name
					+ "  " + rsBoat.getFloat(4)			//Boat_LOA
				);
			}
			dbCxn.close();
		}catch(Exception e){ System.out.println(e);}
	}
}
