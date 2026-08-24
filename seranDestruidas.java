/**
 * Consulta las máquinas que pueden afectarse por una explosión en agua.
 * La explosión afecta a todas las máquinas (aliadas y enemigas) en el radio,
 * excepto los aviones que están volando.
 *
 * @param longitud Longitud de la explosión
 * @param latitud  Latitud de la explosión
 * @return ArrayList con las máquinas que serían destruidas
 */
public ArrayList<Object> seranDestruidas(int longitud, int latitud) {
    ArrayList<Object> afectadas = new ArrayList<>();
    int radioAfectacion = 10;

    ArrayList<Flota> todasLasFlotas = Juego.getFlotas();

    for (Flota flota : todasLasFlotas) {
        ArrayList<Maquina> maquinas = flota.getMaquinas();

        for (Maquina m : maquinas) {
            if (m instanceof Avion) {
                Avion avion = (Avion) m;
                if (avion.enAire()) {
                    continue;
                }
            }

            int distLongitud = Math.abs(m.getLongitud() - longitud);
            int distLatitud = Math.abs(m.getLatitud() - latitud);

            if (distLongitud <= radioAfectacion && distLatitud <= radioAfectacion) {
                afectadas.add(m);
            }
        }
    }

    return afectadas;
}
