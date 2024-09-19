package dgtic.core.modelo;

public class FabricaCoches {
    private static FabricaCoches fabricaCoches;

    private FabricaCoches() {}

    public static FabricaCoches getInstance() {
        if (fabricaCoches == null)
            fabricaCoches = new FabricaCoches();

        return fabricaCoches;
    }

    public ModeloCoche getModeloCoche(TipoCarro tipoCarro) throws IllegalAccessException {
        if (tipoCarro.equals(TipoCarro.DEPORTIVO)) {
            return new Deportivo();
        } else if (tipoCarro.equals(TipoCarro.FAMILIAR)) {
            return new Familiar();
        } else if (tipoCarro.equals(TipoCarro.TODOTERRENO)) {
            return new TodoTerreno();
        }
        throw new IllegalAccessException("No existe ese carro");
    }
}
