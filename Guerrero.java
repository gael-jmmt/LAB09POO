public class Guerrero extends Personaje {
    private int nivel;
    private String arma;
    private int armadura;

    public Guerrero(String nombre, int nivel, int puntosVida, String arma, int armadura) {
        super(nombre, puntosVida);
        this.nivel = nivel;
        this.arma = arma;
        this.armadura = armadura;
    }

    @Override
    public int getNivel() { return nivel; }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        System.out.println("[" + getNombre() + "] ataca con fuerza usando su " + arma);
    }

    @Override
    public int calcularDanio() { return 120; }
}