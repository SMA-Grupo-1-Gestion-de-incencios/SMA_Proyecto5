// CArtAgO artifact code for project proyectoSMA

package common;

import cartago.*;
import java.util.Random;

public class Mapa extends Artifact {

	void init(int tamano) {
		String[][] map = new String[tamano][tamano];
		Random rand = new Random();
		for (int i=0; i < tamano; i++){
			for (int j=0; j < tamano; j++){
				//De forma aleatoria se decide el tipo de las casillas del mapa
				if (rand.nextBoolean()) {
					map[i][j] = "rural";
				} else {
					map[i][j] = "urbano";
				}
			}
		}
		defineObsProperty("mapa", (Object) map);
	}

	//Método para obtener el tamaño del mapa
	@OPERATION
	int get_tamano() {
		ObsProperty prop = getObsProperty("mapa");
        String[][] matriz = (String[][]) prop.getValue();
		return matriz.length;
	}

	//Método para decubrir el tipo de casilla de una determinada posición
	@OPERATION
	void get_tipo_casilla(int i, int j, OpFeedbackParam<String> newValueArg) {
		ObsProperty prop = getObsProperty("mapa");
        String[][] matriz = (String[][]) prop.getValue();
		int tam = matriz.length;
		if ((i>=0 & i<tam) & (j>=0 & j<tam)){
			newValueArg.set(matriz[i][j]);
		} else {
			// Lanza el fallo hacia el agente con un mensaje y un término de error
			failed("Posición fuera del mapa", "error_posicion");
			return; //Hacer return tras failed()
		}
	}

	//Calcular la distancia de Manhattan (ruta en cuadrícula) entre dos posiciones dadas
	@OPERATION
	void distancia(int i1, int j1, int i2, int j2, OpFeedbackParam<Integer> newValueArg) {
		ObsProperty prop = getObsProperty("mapa");
        String[][] matriz = (String[][]) prop.getValue();
		int tam = matriz.length;
		if ((i1>=0 & i1<tam) & (j1>=0 & j1<tam) & (i2>=0 & i2<tam) & (j2>=0 & j2<tam)){
			int x = Math.abs(i2 - i1);
			int y = Math.abs(j2 - j1);
			newValueArg.set(x + y);
		} else {
			failed("Posición fuera del mapa", "error_posicion");
			return;
		}
	}

}

