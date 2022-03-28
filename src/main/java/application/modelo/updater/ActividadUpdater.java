package application.modelo.updater;

import org.springframework.stereotype.Component;

import application.modelo.Actividad;

@Component
public class ActividadUpdater {

	public Actividad format(Actividad nueva, Actividad vieja) {
		if(nueva.getNombre() != null){vieja.setNombre(nueva.getNombre());}
		if(nueva.getDescripcion() != null){vieja.setDescripcion(nueva.getDescripcion());}
		if(nueva.getPrecio() != null){vieja.setPrecio(nueva.getPrecio());}
		if(nueva.getPromRating() != null){vieja.setPromRating(nueva.getPromRating());}
		if(nueva.getPlanes() != null){vieja.setPlanes(nueva.getPlanes());}
		if(nueva.getFechaInicio() != null){vieja.setFechaInicio(nueva.getFechaInicio());}
		if(nueva.getFechaFin() != null){vieja.setFechaFin(nueva.getFechaFin());}
		if(nueva.getPlanes() != null){vieja.setPlanes(nueva.getPlanes());}
		if(nueva.getDireccion() != null){vieja.setDireccion(nueva.getDireccion());}
		if(nueva.getMaxCupos() != 0){vieja.setMaxCupos(nueva.getMaxCupos());}
		if(nueva.getLongitud() != null){vieja.setLongitud(nueva.getLongitud());}
		if(nueva.getLatitud() != null){vieja.setLatitud(nueva.getLatitud());}
		
		return vieja;
		}
}
