import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.*;  // Assurez-vous que votre package est correct

public class GestionEtudiantsTest {

    private GestionEtudiants gestionEtudiants;  // Déclarez une instance de GestionEtudiants

    @Before
    public void setUp() {
        gestionEtudiants = new GestionEtudiants();  // Initialisez l'instance dans setUp()
    }

    @Test
    public void testAjouterEtudiant() {
        Etudiant etudiant = new Etudiant("John Doe", 20);
        gestionEtudiants.ajouterEtudiant(etudiant);
        Assert.assertEquals(1, gestionEtudiants.getEtudiants().size());
    }

    @Test
    public void testGetEtudiantParNom() {
        Etudiant etudiant = new Etudiant("John Doe", 20);
        gestionEtudiants.ajouterEtudiant(etudiant);
        Etudiant result = gestionEtudiants.getEtudiantParNom("John Doe");
        Assert.assertNotNull(result);
        Assert.assertEquals("John Doe", result.getNom());

    }
}
