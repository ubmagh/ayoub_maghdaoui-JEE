import Metier.Calcul;
import org.junit.Assert;
import org.junit.Test;


public class CalculTest {

    private Calcul calcul;

    @Test
    public void testSomme(){
        calcul= new Calcul();
        double a=5, b=10, res, expected = 15;
        res= calcul.somme( a, b);
        Assert.assertTrue( expected==res );
    }

}
