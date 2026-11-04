package dataloader;

import java.util.Arrays;

import modelo.AbstractDAO.DaoFactory;
import modelo.AbstractDAO.GrupoDAO;
import modelo.AbstractDAO.MonitorDAO;
import modelo.Entity.Grupo;
import modelo.Entity.Monitor;

public class CargaDatosCampamento {

	public static void main(String[] args) {
		DaoFactory factory = DaoFactory.getFactory();
		Monitor[] monitores = { new Monitor("11111111A", "Carlos", "García López", "600111111"),
				new Monitor("22222222B", "Laura", "Martínez Ruiz", "600222222"),
				new Monitor("33333333C", "Pedro", "Sánchez Díaz", "600333333"),
				new Monitor("44444444D", "Ana", "Fernández Gil", "600444444"),
				new Monitor("55555555E", "Miguel", "Torres Vega", "600555555"),
				new Monitor("66666666F", "Sofía", "Romero Blanco", "600666666") };
		MonitorDAO monitorDAO = factory.getMonitorDAO();
		Arrays.asList(monitores).forEach(monitorDAO::create);
		Grupo[] grupos = { new Grupo(1, "Grupo Águilas - los más aventureros del campamento"),
				new Grupo(2, "Grupo Lobos - compañerismo y trabajo en equipo"),
				new Grupo(3, "Grupo Delfines - amantes del agua y la naturaleza"),
				new Grupo(4, "Grupo Halcones - velocidad y destreza") };
		GrupoDAO grupoDAO = factory.getGrupoDAO();
		Arrays.asList(grupos).forEach(grupoDAO::create);
	}

}
