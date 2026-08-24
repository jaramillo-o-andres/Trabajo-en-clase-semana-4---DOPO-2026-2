/**
 * Revisa si puede confundir sus aviones con aviones de los enemigos
 * Teniendo en cuenta las placas.
 *
 * @return true si existe una placa repetida entre los aviones
 *         propios y los aviones enemigos; false en caso contrario.
 */
public boolean problemaEnAire()
{
    for (Maquina maquina : maquinas) {
        if (maquina instanceof Avion) {

            Avion avionPropio = (Avion) maquina;

            for (Flota flota : flotas) {
                if (flota != this) {

                    for (Maquina maquinaEnemiga : flota.maquinas) {
                        if (maquinaEnemiga instanceof Avion) {

                            Avion avionEnemigo =
                                (Avion) maquinaEnemiga;

                            if (avionPropio.getPlaca()
                                    .equals(avionEnemigo.getPlaca())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
    }

    return false;
}
