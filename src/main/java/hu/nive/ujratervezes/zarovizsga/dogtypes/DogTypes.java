package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {
    MariaDbDataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     """
                             SELECT LOWER(`name`)
                                FROM `dog_types`
                                WHERE country = UPPER(?)
                             """)
        ) {
            stmt.setString(1, country);

            return dogTypesByPreparedStatement(stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Cannot select dog names", sqle);
        }
    }

    private List<String> dogTypesByPreparedStatement(PreparedStatement stmt) throws SQLException {
        List<String> dogs = new ArrayList<>();

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                dogs.add(rs.getString(1));
            }
            return dogs;
        }
    }
}
