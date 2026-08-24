

 /**
 * Verifica si la ubicación para un ataque es adecuado
 * Un ataque es bueno si destruye elementos enemigos sin causar bajas propias
 * Los aviones en el aire no se afectan
 * 
 * @param longitud - longitud de la explosión
 * @param latitud - latitud de la explosión
 * @return true si el ataque es bueno
 */

public boolean esBuenAtaque (int lon, int lat) {
    // Se obtienen las máquinas que serían destruidas por una explosión
    ArrayList<Object> afectadas = seranDestruidas(lon, lat);

    // Se verifica si hay elementos aferfctados para el enemigo
    boolean hayEnemigos = false;

    for (Object obj : afectadas) {
        // Si el objeto pertenece a otra flota (enemigo)
        if (esEnemigo(obj)) {
            hayEnemigos = true;

        }

        // Si el objeto si es de la flota y no es un avión en vuelo
        else if (esPropio(obj) && !esAvionEnVuelo(obj)) {
            // El ataque no es bueno pues hay bajas propias
            return false;
    
        }
    }
    
    // El ataque es bueno si hay al menos un enemigo afectado y no hay bajas propias
    return hayEnemigos
}

/**
 * MÉTODOS AUXILIARES
 * 
 * 
 * Método para determinar si un objeto es enemigo
 */

private boolean esEnemigo(Object obj) {
    // Si la maquina pertenece a una flota diferente, es enemigo
    if (obj instanceof Maquina) {
        Maquina m = (Maquina) obj;
        return !m.getFlota().equals(this);
    }
    return false;
}

/**
 * Método para determinar si un objeto es propio
 */

private boolean esPropio(Objectc obj) {
    if (obj instanceof Maquina) {
        Maquina m = (Maquina) obj;
        return m.getFlota().equals(this);
    }
    return false;
}

/** 
 * Método para determinar si el objeto es un avión en vuelo
*/

private boolean esAvionEnVuelo(Object obj) {
    if (obj instanceof Avion) {
        Avion a = (Avion) obj;
        return a.estaEnMision();

    }
    return false;
}