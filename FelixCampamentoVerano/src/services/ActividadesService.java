package services;

import modelo.DTO.ActividadesMonitorDTO;

public interface ActividadesService {
	public ActividadesMonitorDTO getActividadesByMonitor(String dni);
}
