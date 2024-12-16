import javax.naming.MalformedLinkException;

public class teste {
    public static void main(String[] args) {
        Transacao t = new Transacao();
        t.quantia = 11;
        t.troco = 9;

        Transacao r = teste(t);

        System.out.println(r.quantia);
        System.out.println(r.troco);

    }

    public static Transacao teste (Transacao t){

        t.quantia = 2*t.quantia;
        t.troco = 0;


        return t;

    }
}
