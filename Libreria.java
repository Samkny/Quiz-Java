import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Libreria {
    private Connection connection;

    public Libreria() {
        connection = DatabaseConnection.getConnection();
    }

    public void aggiungiLibro(String titolo, String autore, int anno) {
        String query = "INSERT INTO libri (titolo, autore, anno) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, titolo);
            stmt.setString(2, autore);
            stmt.setInt(3, anno);
            stmt.executeUpdate();
            System.out.println("Libro aggiunto con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void visualizzaLibri() {
        String query = "SELECT * FROM libri";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String titolo = rs.getString("titolo");
                String autore = rs.getString("autore");
                int anno = rs.getInt("anno");
                System.out.printf("ID: %d, Titolo: %s, Autore: %s, Anno: %d%n", id, titolo, autore, anno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cercaLibroPerTitolo(String titolo) {
        String query = "SELECT * FROM libri WHERE titolo LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + titolo + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String risultatoTitolo = rs.getString("titolo");
                    String autore = rs.getString("autore");
                    int anno = rs.getInt("anno");
                    System.out.printf("ID: %d, Titolo: %s, Autore: %s, Anno: %d%n", id, risultatoTitolo, autore, anno);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
