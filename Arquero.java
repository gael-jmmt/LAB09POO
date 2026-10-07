public class Arquero extends Personaje {
    private int flechasDisponibles;
    private int nivel;
    private String arma;
    private int agilidad;

    public Arquero(String nombre, int nivel, int puntosVida, String arma, int flechasDisponibles, int agilidad) {
        super(nombre, puntosVida);
        this.nivel = nivel;
        this.arma = arma;
        this.flechasDisponibles = flechasDisponibles;
        this.agilidad = agilidad;
    }

    @Override
    public int getNivel() { return nivel; }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (flechasDisponibles <= 0) throw new RecursoInsuficienteException("flechas", flechasDisponibles);
        
        flechasDisponibles--;
        System.out.println("[" + getNombre() + "] dispara una flecha. Flechas restantes: " + flechasDisponibles);
    }

    @Override
    public int calcularDanio() { return 50; }
}