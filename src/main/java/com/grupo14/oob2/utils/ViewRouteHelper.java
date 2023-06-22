package com.grupo14.oob2.utils;

public class ViewRouteHelper {
	/**** Views ****/
	// HOME
	public final static String INDEX = "home/index";
	public final static String HELLO = "home/hello";


	// USER
	public final static String USER_LOGIN = "login/index";
	public final static String USER_LOGOUT = "login/logout";

	// AULA
	public final static String AULA_DASHBOARD = "aula/dashboard";

	public final static String AULA_DASHBOARD_ABMTABLE = "aula/abmTable";

	public final static String AULA_ABM_CREATE = "aula/abmCreate";

	public final static String AULA_ABM_EDIT = "aula/abmEdit";

	public final static String AULA_ABM_SUCCESS = "aula/messageSuccess";

	public final static String AULA_DASHBOARD_SECTORES = "aula/sectoresDAula";

	public final static String AULA_DASHBOARD_SECTORES_DAULA = "aula/dAulabySectores";

	// Baños
    public final static String SHOW_BANIOS = "/banio/show";
	public final static String FORM_NEW_BANIO = "/banio/newBanioForm";

	/// Estacionamiento
	public final static String SHOW_ESTACIONAMIENTOS = "/estacionamiento/show";
	public final static String FORM_NEW_ESTACIONAMIENTO = "/estacionamiento/newEstacionamientoForm";

	/// Eventos:
	// Eventos de Estacionamiento:
	public final static String SHOW_EVENTOS = "/evento/allEventos";
	public final static String SHOW_EVENTOS_ESTACIONAMIENTO = "/evento/eventosEstacionamientos";

	// Eventos de Banio:
	public final static String SHOW_EVENTOS_BANIO = "/evento/eventosBanios";

    /**** Redirects ****/
    public final static String ROUTE = "/index";
    public final static String DEGREE_ROOT = "/degrees/";
    public final static String PERSON_ROOT = "/person";

	public final static String SHOW_EVENTOS_DAULA = "/evento/eventosDAula";
}