package test;
import org.junit.jupiter.api.Test;
import main.Spfa;

public class TestSpfa {
    Spfa spfa = new Spfa();
    @Test
    public void testSpfa()
    {
        int s = 0;
        int n = 4;
        int a[][] = new int[4][4];
        a[0][1]=5;
        a[0][2]=3;
        a[1][2]=1;
        a[1][3]=2;
        a[2][3]=1;

        spfa.spfa(s,n,a);
    }
 }