public class PocaoVida {
    private int cura = 30;
    public void aplicar(Personagem p) {
        p.setVida(p.getVida() + cura);
        System.out.println(p.getNome() + " usou uma Poção e recuperou " + cura + " HP!");


