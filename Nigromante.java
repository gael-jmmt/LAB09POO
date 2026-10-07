
public class Nigromante extends Personaje {
    private int mana;
    private int nivel;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, puntosVida);
        this.nivel = nivel;
        this.mana = mana;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        if (mana < 15) {
            throw new RecursoInsuficienteException("mana", mana);
        }
        mana -= 15;
        System.out.println("[" + getNombre() + "] lanza un hechizo oscuro.");
    }

    @Override
    public int calcularDanio() {
        return 80;
    }
}