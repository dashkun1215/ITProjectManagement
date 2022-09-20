import org.example.Main;
import org.junit.Assert;
import org.junit.Test;

public class TestCode {
    @Test
    public void testCode() throws Exception {
        String message = "TEST MESSAGE";
        String text = String.valueOf(Main.Code(message));
        Assert.assertEquals("'YRXANADUVUJ", text);
    }
    @Test
    public void testDecode() throws Exception {
        String message = "H.QFYNJATGEP.AW'";
        String text = String.valueOf(Main.Decode(message));
        Assert.assertEquals("ONCE UPON A TIME", text);
    }
}
