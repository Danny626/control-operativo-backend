package com.albo.util;

public class EnumUtil {

	private static String descripcion = "";
	private static String codigo = "";
	private static String justificacion = "";

	public static enum RegimenAduana {

		EXPORTACIONES, IMPORTACIONES, TRANSITOS, TRANSBORDOS;

		public String getCodigo() {
			switch (this) {
			case EXPORTACIONES:
				codigo = "22";
				break;
			case IMPORTACIONES:
				codigo = "23";
				break;
			case TRANSITOS:
				codigo = "24";
				break;
			case TRANSBORDOS:
				codigo = "28";
				break;
			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case EXPORTACIONES:
				descripcion = "EXPORTACIONES";
				break;
			case IMPORTACIONES:
				descripcion = "IMPORTACIONES";
				break;
			case TRANSITOS:
				descripcion = "TRANSITOS";
				break;
			case TRANSBORDOS:
				descripcion = "TRANSBORDOS";
				break;
			default:
				break;
			}
			return descripcion;
		}

		public static String getValor(String cod) {
			descripcion = "";

			if (cod.equals(EXPORTACIONES.getCodigo())) {
				descripcion = EXPORTACIONES.getDescripcion();
			}
			if (cod.equals(IMPORTACIONES.getCodigo())) {
				descripcion = IMPORTACIONES.getDescripcion();
			}
			if (cod.equals(TRANSITOS.getCodigo())) {
				descripcion = TRANSITOS.getDescripcion();
			}
			if (cod.equals(TRANSBORDOS.getCodigo())) {
				descripcion = TRANSBORDOS.getDescripcion();
			}
			return descripcion;
		}
	}

	/**
	 * *****************************
	 */
	/**
	 * Obtiene el codigo del tipo de Regimen de Aduana y la descripción
	 */
	public static enum Color {

		ROJO, AMARILLO, VERDE;

		public String getCodigo() {
			switch (this) {
			case ROJO:
				codigo = "1";
				break;
			case AMARILLO:
				codigo = "2";
				break;
			case VERDE:
				codigo = "3";
				break;
			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case ROJO:
				descripcion = "ROJO";
				break;
			case AMARILLO:
				descripcion = "AMARILLO";
				break;
			case VERDE:
				descripcion = "VERDE";
				break;
			default:
				break;
			}
			return descripcion;
		}

		public static String getValor(String cod) {
			descripcion = "";

			if (cod.equals(ROJO.getCodigo())) {
				descripcion = ROJO.getDescripcion();
			}
			if (cod.equals(AMARILLO.getCodigo())) {
				descripcion = AMARILLO.getDescripcion();
			}
			if (cod.equals(VERDE.getCodigo())) {
				descripcion = VERDE.getDescripcion();
			}
			return descripcion;
		}
	}

	/**
	 * Obtiene la operacion que se le asignara en la asignacion
	 */
	public static enum Operacion {

		CIRCUITO, PLAYA, ALMACEN, ESPECIAL;

		public String getCodigo() {
			switch (this) {
			case CIRCUITO:
				codigo = "CIR";
				break;
			case PLAYA:
				codigo = "PLA";
				break;
			case ALMACEN:
				codigo = "ALM";
				break;
			case ESPECIAL:
				codigo = "DES";
				break;
			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case CIRCUITO:
				descripcion = "CIRCUITO";
				break;
			case PLAYA:
				descripcion = "PLAYA";
				break;
			case ALMACEN:
				descripcion = "ALMACEN";
				break;
			case ESPECIAL:
				descripcion = "DEPOSITO ESPECIAL";
				break;
			default:
				break;
			}
			return descripcion;
		}

		public static String getValor(String cod) {
			descripcion = "";

			if (cod.equals(CIRCUITO.getCodigo())) {
				descripcion = CIRCUITO.getDescripcion();
			}
			if (cod.equals(PLAYA.getCodigo())) {
				descripcion = PLAYA.getDescripcion();
			}
			if (cod.equals(ALMACEN.getCodigo())) {
				descripcion = ALMACEN.getDescripcion();
			}
			if (cod.equals(ESPECIAL.getCodigo())) {
				descripcion = ESPECIAL.getDescripcion();
			}
			return descripcion;
		}
	}

	/**
	 * Obtiene el tipo de operacion para la creacion de un registro en las tablas de
	 * auditoria. INSERCION, MODIFICACION Y ANULACION CREADOS POR EL USUARIO
	 */
	public static enum AuditoriaManual {

		INSERCION, MODIFICACION, ANULACION;

		public String getDescripcion() {

			switch (this) {
			case INSERCION:
				descripcion = "REGISTRO CREADO POR EL USUARIO";
				break;
			case MODIFICACION:
				descripcion = "REGISTRO EDITADO POR EL USUARIO";
				break;
			case ANULACION:
				descripcion = "REGISTRO ANULADO POR EL USUARIO";
				break;
			}

			return descripcion;
		}
	}

	/**
	 * Obtiene el tipo de operacion para la creacion de un registro en las tablas de
	 * auditoria. INSERCION: REGISTRO CREADO POR EL SISTEMA MODIFICACION: No tiene
	 * descripcion ANULACION: No tiene descripcion
	 */
	public static enum Auditoria {

		INSERCION, MODIFICACION, REVERSION, ANULACION, IMPRESION;

		public String getDescripcion() {
			if (this == INSERCION) {
				descripcion = "REGISTRO CREADO POR EL SISTEMA";
			}

			if (this == ANULACION) {
				descripcion = "ANULACION POR BAJA ";
			}
			if (this == REVERSION) {
				descripcion = "REVERSION DE ESTADO";
			}

			if (this == MODIFICACION) {
				descripcion = "REGISTRO MODIFICADO POR EL SISTEMA";
			}

			if (this == IMPRESION) {
				descripcion = "REGISTRO IMPRESO";
			}

			return descripcion;
		}
	}

	public static enum Estado {

		INACTIVO, ACTIVO, COLOCADO;

		public String getCodigo() {
			switch (this) {
			case ACTIVO:
				descripcion = "ACT";
				break;
			case INACTIVO:
				descripcion = "INA";
				break;
			case COLOCADO:
				descripcion = "COL";
				break;
			}
			return descripcion;
		}

		public static String getValor(String cod) {
			if (cod == null) {
				return "";
			}
			if (cod.equals(ACTIVO.getCodigo())) {
				return ACTIVO.name();
			}
			if (cod.equals(INACTIVO.getCodigo())) {
				return INACTIVO.name();
			}
			if (cod.equals(COLOCADO.getCodigo())) {
				return COLOCADO.name();
			}
			return "";
		}
	}

	/**
	 * Obtiene los tipos de documentos existentes: MNF: MANIFIESTO, DUI: DUI.
	 */
	public static enum Documento {

		INVENTARIO, MANIFIESTO, REPRESENTANTE, DUI, SALIDA;

		public String getCodigo() {
			switch (this) {
			case INVENTARIO:
				codigo = "INV";
				break;
			case MANIFIESTO:
				codigo = "MNF";
				break;
			case REPRESENTANTE:
				codigo = "REP";
				break;
			case SALIDA:
				codigo = "SAL";
				break;
			case DUI:
				codigo = "DUI";
				break;
			}
			return codigo;
		}
	}

	/**
	 * Obtiene los tipos de proceso: RECEPCION: REC TRANSITO DE IMPORTACION = IMP
	 * TRANSITO DE EXPORTACION = EXP DESPACHO : DES
	 */
	public static enum Proceso {

		RECEPCION, IMPORTACION, EXPORTACION, DESPACHO;

		public String getCodigo() {
			switch (this) {
			case RECEPCION:
				codigo = "REC";
				break;
			case IMPORTACION:
				codigo = "IMP";
				break;
			case EXPORTACION:
				codigo = "EXP";
				break;
			case DESPACHO:
				codigo = "DES";
				break;
			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case RECEPCION:
				codigo = "Recepción";
				break;
			case IMPORTACION:
				codigo = "Importación";
				break;
			case EXPORTACION:
				codigo = "Exportación";
				break;
			case DESPACHO:
				codigo = "Despacho";
				break;
			}
			return codigo;
		}

		public static String getValor(String cod) {
			descripcion = "";

			if (cod.equals(RECEPCION.getCodigo())) {
				descripcion = RECEPCION.getDescripcion();
			}
			if (cod.equals(IMPORTACION.getCodigo())) {
				descripcion = IMPORTACION.getDescripcion();
			}
			if (cod.equals(EXPORTACION.getCodigo())) {
				descripcion = EXPORTACION.getDescripcion();
			}
			if (cod.equals(DESPACHO.getCodigo())) {
				descripcion = DESPACHO.getDescripcion();
			}
			return descripcion;
		}
	}

	public static enum PesajeComents {

		PESAJE_ACOPLE, PESO_CAMION, PESO_DOCUMENTAL, PESO_ELIMINADO, PESO_ELIMINA_ACOPLE, PESO_ULTIMO_TARA, PESO_CERO;

		public String getCodigo() {
			switch (this) {
			case PESO_DOCUMENTAL:
				descripcion = "PMN";
				break;
			default:
				break;
			}
			return descripcion;
		}

		public String getDescripcion() {
			switch (this) {
			case PESO_CAMION:
				descripcion = "PESO RECUPERADO DE CAMION.";
				break;
			case PESO_DOCUMENTAL:
				descripcion = "PESO DOCUMENTAL.";
				break;
			case PESO_ELIMINADO:
				descripcion = "SE ELIMINO TODOS LOS PESOS DEL CAMION.";
				break;
			case PESO_ELIMINA_ACOPLE:
				descripcion = "ACOPLE ELIMINADO AL AGREGAR EL PESAJE.";
				break;
			case PESO_ULTIMO_TARA:
				descripcion = "ULTIMO PESO TARA RECUPERADO.";
				break;
			case PESO_CERO:
				descripcion = "PESO CERO POR SOBREDIMENSION.";
				break;
			default:
				break;
			}
			return descripcion;
		}
	}

	/**
	 * Obtiene el estado del pesaje. ASIGNADO: ASG ESPERA: ESP
	 */
	public static enum Pesaje {

		ASIGNADO, ESPERA, ANULADO, PESAJE_ACOPLE;

		public String getCodigo() {
			switch (this) {
			case ASIGNADO:
				descripcion = "ASG";
				break;
			case ESPERA:
				descripcion = "ESP";
				break;
			case ANULADO:
				descripcion = "ANU";
				break;
			case PESAJE_ACOPLE:
				descripcion = "PESAJE CON ACOPLE";
				break;
			default:
				break;
			}
			return descripcion;
		}

		public String getDescripcion() {
			switch (this) {
			case ASIGNADO:
				descripcion = "Asignado";
				break;
			case ESPERA:
				descripcion = "Espera";
				break;
			case ANULADO:
				descripcion = "Anulado";
				break;
			case PESAJE_ACOPLE:
				descripcion = "Pesaje con acople";
				break;
			default:
				break;
			}
			return descripcion;
		}

		public static String getValor(String cod) {
			String des = "";
			if (cod.equals(ASIGNADO.getCodigo())) {
				des = ASIGNADO.getDescripcion();
			}
			if (cod.equals(ESPERA.getCodigo())) {
				des = ESPERA.getDescripcion();
			}
			if (cod.equals(ANULADO.getCodigo())) {
				des = ANULADO.getDescripcion();
			}
			if (cod.equals(PESAJE_ACOPLE.getCodigo())) {
				des = PESAJE_ACOPLE.getDescripcion();
			}
			return des;
		}
	}

	/**
	 * Descripcion del pesaje que se almacenara en la observacion del pesaje padre.
	 * ACOPLE
	 */
	public static enum PesajeAcople {

		ACOPLE;

		public String getCodigo() {
			if (this == ACOPLE) {
				descripcion = "PESAJE CON ACOPLE";
			}
			return descripcion;
		}
	}

	/**
	 * Obtiene la balanza en el caso de que se ingrese valores sin sistema de
	 * pesaje. DOCUMENTAL
	 */
	public static enum Balanza {

		DOCUMENTAL;

		public String getCodigo() {
			if (this == DOCUMENTAL) {
				descripcion = "DOCUMENTAL";
			}
			return descripcion;
		}
	}

	/**
	 * Obtiene el estado de los precintos. ASIGNADO: ASG DEVOLUCION: DEV
	 * DEVDESTROZO: ROT
	 */
	public static enum Precinto {

		ASIGNADO, DEVOLUCION, INUTILIZABLE, EXPORTACION;

		@Override
		public String toString() {
			switch (this) {
			case ASIGNADO:
				descripcion = "ASG";
				break;
			case DEVOLUCION:
				descripcion = "DEV";
				break;
			case INUTILIZABLE:
				descripcion = "ROT";
				break;
			case EXPORTACION:
				descripcion = "EXP";
				break;
			default:
				break;
			}
			return descripcion;
		}

		public String getJustificacion() {
			switch (this) {
			case ASIGNADO:
				justificacion = "";
				break;
			case DEVOLUCION:
				justificacion = "Devuelto";
				break;
			case INUTILIZABLE:
				justificacion = "Roto";
				break;
			case EXPORTACION:
				justificacion = "Exportación";
				break;
			default:
				break;
			}
			return justificacion;
		}
	}

	/**
	 * Obtiene el estado de la dotacion de precintos. ACTIVO: ACT INACTIVO: INA
	 */
	public static enum DotacionPrecinto {

		ACTIVO, INACTIVO;

		public String getCodigo() {
			switch (this) {
			case ACTIVO:
				descripcion = "ACT";
				break;
			case INACTIVO:
				descripcion = "INA";
				break;
			default:
				break;
			}
			return descripcion;
		}
	}

	/**
	 * Indica si la mercaderia es manifestada SI/NO.
	 */
	public static enum Manifestado {

		SI, NO;
	}

	/**
	 * Indica si el registro esta sincronizado SI/NO.
	 */
	public static enum Sincronizado {

		SI, NO;
	}

	/**
	 * Obtiene el valor de documento de embarque cuando este es vacio. SIN_VALOR:
	 * SIN DOC/EMB;
	 */
	public static enum SinDocEmb {

		SIN_VALOR;

		public String getDescripcion() {
			return "SIN DOC/EMB";
		}
	}

	public static enum TransbordoDocEmb {

		SIN_VALOR;

		public String getDescripcion() {
			return "TRANSBORDO GENERADO POR SISTEMA";
		}
	}

	/**
	 * Obtiene el tipo de aduana.
	 *
	 */
	public static enum TipoAduana {

		ORIGEN, DESTINO;

		@Override
		public String toString() {
			String codigo = "";
			switch (this) {
			case ORIGEN:
				codigo = "ORG";
				break;
			case DESTINO:
				codigo = "DST";
				break;
			default:
				break;
			}
			return codigo;
		}
	}

	public static enum ObtencionInfo {

		WEBSERVICE, MANUAL, DOCUMENTO;

		public String getCodigo() {
			String codigo = "";
			switch (this) {
			case WEBSERVICE:
				codigo = "WSC";
				break;
			case MANUAL:
				codigo = "MAN";
				break;
			case DOCUMENTO:
				codigo = "DOC";
				break;
			default:
				break;
			}
			return codigo;
		}

		public static String getValor(String cod) {
			if (cod.equals(WEBSERVICE.getCodigo())) {
				return WEBSERVICE.name();
			}
			if (cod.equals(MANUAL.getCodigo())) {
				return MANUAL.name();
			}
			if (cod.equals(DOCUMENTO.getCodigo())) {
				return DOCUMENTO.name();
			}
			return "";
		}
	}

	/**
	 * Obtiene la operacion que se le asignara en la asignacion
	 */
	public static enum obsSal {

		CONTROLDIFERIDO, REGULARIZACION;

		public String getDescripcion() {
			switch (this) {
			case CONTROLDIFERIDO:
				codigo = "CAMBIO DEBIDO AL CONTROL DIFERIDO DE LA DUI";
				break;
			case REGULARIZACION:
				codigo = "REGULARIZACION BULTOS Y PESOS DE LA DUI ANTICIPADA O INMEDIATA.";
				break;
			}
			return codigo;
		}
	}

	/**
	 * Obtiene la operacion que se le asignara en la asignacion
	 */
	public static enum MetodoWsc {

		MNF_ORIGEN_072, MNF_DESTINORECINTO_REG24, MNF_DESTINORECINTO_GIT_REG24, MNF_ORIGENRECINTO_REG24,
		MNF_DESTINORECINTO_REG23_REG28;

		public String getCodigo() {
			switch (this) {
			case MNF_ORIGEN_072:
				codigo = "MNF_ORIGEN_072";
				break;
			case MNF_DESTINORECINTO_GIT_REG24:
				codigo = "MNF_DESTRECGIT_REG24";
				break;
			case MNF_DESTINORECINTO_REG24:
				codigo = "MNF_DESTREC_REG24";
				break;
			case MNF_ORIGENRECINTO_REG24:
				codigo = "MNF_ORIREC_REG24";
				break;
			case MNF_DESTINORECINTO_REG23_REG28:
				codigo = "MNF_DESTREC_REG23_REG28";
				break;

			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case MNF_ORIGEN_072:
				descripcion = "MNF_ORIGEN072";
				break;
			case MNF_DESTINORECINTO_GIT_REG24:
				descripcion = "MNF_DESTRECGIT_REG24";
				break;
			case MNF_DESTINORECINTO_REG24:
				descripcion = "MNF_DESTINORECINTO_REG24";
				break;
			case MNF_ORIGENRECINTO_REG24:
				descripcion = "MNF_ORIGENRECINTO_REG24";
				break;
			case MNF_DESTINORECINTO_REG23_REG28:
				descripcion = "MNF_DESTINORECINTO_REG23_REG28";
				break;
			default:
				break;
			}
			return descripcion;
		}

		public static String getValor(String cod) {
			descripcion = "";

			if (cod.equals(MNF_ORIGEN_072.getCodigo())) {
				descripcion = MNF_ORIGEN_072.getDescripcion();
			}
			if (cod.equals(MNF_DESTINORECINTO_REG24.getCodigo())) {
				descripcion = MNF_DESTINORECINTO_REG24.getDescripcion();
			}
			if (cod.equals(MNF_ORIGENRECINTO_REG24.getCodigo())) {
				descripcion = MNF_ORIGENRECINTO_REG24.getDescripcion();
			}
			if (cod.equals(MNF_DESTINORECINTO_REG23_REG28.getCodigo())) {
				descripcion = MNF_DESTINORECINTO_REG23_REG28.getDescripcion();
			}

			return descripcion;
		}
	}

	public static enum E3ofSerie {

		RECIBO
	}

	public static enum FactTipo {

		R
	}

	public static enum RucTipo {

		NIT
	}

	/**
	 * Obtiene la descripción de registro realizado automáticamente.
	 */
	public static enum Automatico {

		DESC;

		@Override
		public String toString() {
			String desc = "";
			switch (this) {
			case DESC:
				desc = "GENERADO AUTOMATICAMENTE";
			}
			return desc;
		}
	}

	/**
	 * Obtiene estados de Factura
	 */
	public static enum Factura {

		APROBADO;

		public String getCodigo() {
			if (this == APROBADO) {
				descripcion = "APR";
			}
			return descripcion;
		}
	}

	/**
	 * Obtiene estados de Factura
	 */
	public static enum RespEnvioPsj {

		ENVIADO;

		public String getCodigo() {
			if (this == ENVIADO) {
				descripcion = "OK";
			}
			return descripcion;
		}
	}

	public static enum TipoIngreso {

		INCAUTADO, RETENIDO, TRANSBORDO, COURRIER;

		public String getCodigo() {
			switch (this) {
			case INCAUTADO:
				codigo = "INC";
				break;
			case RETENIDO:
				codigo = "RET";
				break;
			case TRANSBORDO:
				codigo = "TRS";
				break;
			case COURRIER:
				codigo = "COU";
				break;
			default:
				break;
			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case INCAUTADO:
				descripcion = "INCAUTADO";
				break;
			case RETENIDO:
				descripcion = "RETENIDO";
				break;
			case TRANSBORDO:
				descripcion = "TRANSBORDO";
				break;
			case COURRIER:
				descripcion = "COURRIER";
				break;
			default:
				break;
			}
			return descripcion;
		}

		public static String getValor(String cod) {
			if (cod.equals(INCAUTADO.getCodigo())) {
				return INCAUTADO.getDescripcion();
			}
			if (cod.equals(RETENIDO.getCodigo())) {
				return RETENIDO.getDescripcion();
			}
			if (cod.equals(TRANSBORDO.getCodigo())) {
				return TRANSBORDO.getDescripcion();
			}
			if (cod.equals(COURRIER.getCodigo())) {
				return COURRIER.getDescripcion();
			}
			return "";
		}
	}

	public static enum EstadoTurnoLLamada {

		PENDIENTE, LLAMADA, ENPROCESO, CONCLUIDO;

		public String getCodigo() {
			switch (this) {
			case PENDIENTE:
				codigo = "PEN";
				break;
			case LLAMADA:
				codigo = "LLA";
				break;
			case CONCLUIDO:
				codigo = "CON";
				break;
			case ENPROCESO:
				codigo = "EPR";
				break;
			default:
				break;
			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case PENDIENTE:
				descripcion = "Pendiente";
				break;
			case LLAMADA:
				descripcion = "LLamada";
				break;
			case CONCLUIDO:
				descripcion = "Concluido";
				break;
			case ENPROCESO:
				descripcion = "Proceso";
				break;

			default:
				break;
			}
			return descripcion;
		}

		public static String getValor(String cod) {
			if (cod.equals(PENDIENTE.getCodigo())) {
				return PENDIENTE.getDescripcion();
			}
			if (cod.equals(LLAMADA.getCodigo())) {
				return LLAMADA.getDescripcion();
			}
			if (cod.equals(CONCLUIDO.getCodigo())) {
				return CONCLUIDO.getDescripcion();
			}
			return "";
		}
	}

	public static enum EstadoLLamada {

		LLAMADOS, PENDIENTES;

		public String getCodigo() {
			switch (this) {
			case LLAMADOS:
				codigo = "LLA";
				break;
			case PENDIENTES:
				codigo = "PEN";
				break;
			default:
				break;
			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case LLAMADOS:
				descripcion = "LLAMADOS";
				break;
			case PENDIENTES:
				descripcion = "PENDIENTES";
				break;

			default:
				break;
			}
			return descripcion;
		}
	}

	public static enum TipoPeso {

		TARA, NETO, BRUTO;

		public String getCodigo() {
			switch (this) {
			case TARA:
				codigo = "TR";
				break;
			case NETO:
				codigo = "NE";
				break;
			case BRUTO:
				codigo = "BR";
				break;
			default:
				break;
			}
			return codigo;
		}
	}

	public static enum ColorLLamada {

		ANTICIPADO, SOBRECAMION, ALMACEN, PLAYA;

		public String getCodigo() {
			switch (this) {
			case ANTICIPADO:
				codigo = "ANT";
				break;
			case SOBRECAMION:
				codigo = "SBC";
				break;
			case ALMACEN:
				codigo = "ALM";
				break;
			case PLAYA:
				codigo = "PLA";
				break;
			default:
				break;
			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case ANTICIPADO:
				descripcion = "ANTICIPADO";
				break;
			case SOBRECAMION:
				descripcion = "SOBRE CAMION";
				break;
			case ALMACEN:
				descripcion = "ALMACEN";
				break;
			case PLAYA:
				descripcion = "PLAYA";
				break;
			default:
				break;
			}
			return descripcion;
		}

		public static String getValor(String cod) {
			descripcion = "";
			if (cod.equals(ANTICIPADO.getCodigo())) {
				descripcion = "fondoVerde";
			}
			if (cod.equals(SOBRECAMION.getCodigo())) {
				descripcion = "fondoRojo";
			}
			if (cod.equals(ALMACEN.getCodigo())) {
				descripcion = "fondoBlanco";
			}
			if (cod.equals(PLAYA.getCodigo())) {
				descripcion = "fondoCafe";
			}
			return descripcion;
		}
	}

	public static enum Posicion {

		INICIO, FIN, MEDIO, VACIO;
	}

	/// *FUENTE DE AUTORIZAION *///
	public static enum FuenteAutorizacion {

		VIRTUALBO, SICI;

		public String getCodigo() {
			switch (this) {
			case VIRTUALBO:
				codigo = "VIRTUALBO";
				break;
			case SICI:
				codigo = "SICI";
				break;
			default:
				break;
			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case VIRTUALBO:
				descripcion = "AUTORIZADO POR SISTEMA VIRTUALBO";
				break;
			case SICI:
				descripcion = "AUTORIZADO POR SISTEMA SICI- FACTURACION";
				break;
			default:
				break;
			}
			return descripcion;
		}
	}

	/**
	 * Obtiene el Codigo de de la igualdad
	 */
	public static enum IgualdadDias {

		IGUAL, MAYORIGUAL, MENORIGUAL, MAYOR, MENOR;

		public String getCodigo() {
			switch (this) {
			case IGUAL:
				descripcion = "0";
				break;
			case MAYORIGUAL:
				descripcion = "1";
				break;
			case MENORIGUAL:
				descripcion = "2";
				break;
			case MENOR:
				descripcion = "3";
				break;
			case MAYOR:
				descripcion = "4";
				break;

			default:
				break;
			}
			return descripcion;
		}

		public String getDescripcion() {
			switch (this) {
			case IGUAL:
				descripcion = "=";
				break;
			case MAYORIGUAL:
				descripcion = ">=";
				break;
			case MENORIGUAL:
				descripcion = "<=";
				break;
			case MENOR:
				descripcion = "<";
				break;
			case MAYOR:
				descripcion = ">";
				break;

			default:
				break;
			}
			return descripcion;
		}
	}

	/**
	 * Obtiene el Codigo de Formato de reporte
	 */
	public static enum FormatoReport {

		PDF, XLS, HTML;

		public String getCodigo() {
			switch (this) {
			case PDF:
				descripcion = "pdf";
				break;
			case XLS:
				descripcion = "xls";
				break;
			case HTML:
				descripcion = "html";
				break;

			default:
				break;
			}
			return descripcion;
		}
	}

	/**
	 * Obtiene el estado del pesaje. ASIGNADO: ASG ESPERA: ESP
	 */
	public static enum eventos {

		ARRIBO, INGRESO, PESAJE, ASIGALMACEN, DESALMACEN, SALIDA;

		public String getCodigo() {
			switch (this) {
			case ARRIBO:
				descripcion = "ARR";
				break;
			case INGRESO:
				descripcion = "ING";
				break;
			case PESAJE:
				descripcion = "PSJ";
				break;
			case ASIGALMACEN:
				descripcion = "ASA";
				break;
			case DESALMACEN:
				descripcion = "DEA";
				break;
			case SALIDA:
				descripcion = "SAC";
				break;

			default:
				break;
			}
			return descripcion;
		}

		public String getDescripcion() {
			switch (this) {
			case ARRIBO:
				descripcion = "ARRIBO";
				break;
			case INGRESO:
				descripcion = "INGRESO";
				break;
			case PESAJE:
				descripcion = "PESAJE";
				break;
			case ASIGALMACEN:
				descripcion = "ASIGNACIÓN";
				break;
			case DESALMACEN:
				descripcion = "DESCARGA";
				break;
			case SALIDA:
				descripcion = "SALIDA";
				break;

			default:
				break;
			}
			return descripcion;
		}

		public static String getValor(String cod) {
			String des = "";
			if (cod.equals(ARRIBO.getCodigo())) {
				des = ARRIBO.getDescripcion();
			}
			if (cod.equals(INGRESO.getCodigo())) {
				des = INGRESO.getDescripcion();
			}
			if (cod.equals(PESAJE.getCodigo())) {
				des = PESAJE.getDescripcion();
			}
			if (cod.equals(ASIGALMACEN.getCodigo())) {
				des = ASIGALMACEN.getDescripcion();
			}
			if (cod.equals(DESALMACEN.getCodigo())) {
				des = DESALMACEN.getDescripcion();
			}
			if (cod.equals(SALIDA.getCodigo())) {
				des = SALIDA.getDescripcion();
			}

			return des;
		}
	}

	/**
	 * Obtiene el codigo del tipo alerta.
	 */
	public static enum TipoAlerta {

		ANULACION_ARCHIVO, CAMBIO_CONSIGNATARIO, CAMBIO_MODALIDAD, CAMBIO_DEPOSITO, CAMBIO_LOCALIZACION,
		CAMBIO_OBSERVACION, CAMBIO_BULTO_REC, CAMBIO_PESO_REC, CAMBIO_DESCRIPCION_ITEM, CAMBIO_ALMACEN_ITEM,
		CAMBIO_UBICACION_ITEM, CAMBIO_MERCANCIA_ITEM, CAMBIO_MERCANCIA_DET_ITEM, CREACION_DOC_SALIDA,
		ELIMINACION_DOC_SALIDA, ELIMINACION_ASOCIACION, FECHAS_DISTINTAS, AUTORIZACION_SALIDA, ANULACION_ENTREGA,
		CAMBIO_FECHA_ING, CAMBIO_PR_EMB, CONSOLIDADO;

		public String getCodigo() {
			switch (this) {
			case ANULACION_ARCHIVO:
				descripcion = "AAR";
				break;

			case FECHAS_DISTINTAS:
				descripcion = "FDI";
				break;
			case CAMBIO_CONSIGNATARIO:
				descripcion = "CCO";
				break;
			case CAMBIO_MODALIDAD:
				descripcion = "CMO";
				break;
			case CAMBIO_DEPOSITO:
				descripcion = "CDE";
				break;
			case CAMBIO_LOCALIZACION:
				descripcion = "CLO";
				break;
			case CAMBIO_OBSERVACION:
				descripcion = "COB";
				break;
			case CAMBIO_BULTO_REC:
				descripcion = "CBU";
				break;
			case CAMBIO_PESO_REC:
				descripcion = "CPE";
				break;
			case CAMBIO_DESCRIPCION_ITEM:
				descripcion = "CDI";
				break;
			case CAMBIO_ALMACEN_ITEM:
				descripcion = "CAI";
				break;
			case CAMBIO_UBICACION_ITEM:
				descripcion = "CUI";
				break;
			case CAMBIO_MERCANCIA_ITEM:
				descripcion = "CMI";
				break;
			case CAMBIO_MERCANCIA_DET_ITEM:
				descripcion = "CMDI";
				break;
			case CREACION_DOC_SALIDA:
				descripcion = "CDS";
				break;
			case ELIMINACION_DOC_SALIDA:
				descripcion = "EDS";
				break;

			case ELIMINACION_ASOCIACION:
				descripcion = "EAS";
				break;

			case AUTORIZACION_SALIDA:
				descripcion = "AUS";
				break;
			case ANULACION_ENTREGA:
				descripcion = "AEN";
				break;
			case CAMBIO_FECHA_ING:
				descripcion = "CFI";
				break;
			case CAMBIO_PR_EMB:
				descripcion = "CPR";
				break;
			case CONSOLIDADO:
				descripcion = "CON";
				break;
			default:

			}
			return descripcion;
		}
	}

	/**
	 * Obtiene el codigo del tipo de opcion de envio de alerta.
	 */
	public static enum TipoEnvioMsj {

		CORREO, SMS;

		public String getCodigo() {
			switch (this) {
			case CORREO:
				descripcion = "MAIL";
				break;
			case SMS:
				descripcion = "SMS";
				break;
			default:
				break;
			}
			return descripcion;
		}
	}

	public static enum bindingChar {

		CORREO, SMS;

		public String getCodigo() {
			switch (this) {
			case CORREO:
				descripcion = ";";
				break;
			case SMS:
				descripcion = "|";
				break;
			default:
				break;
			}
			return descripcion;
		}
	}

	public static enum hashtagMsj {

		ALERTA;

		public String getCodigo() {
			switch (this) {
			case ALERTA:
				descripcion = "#ALERTA";
				break;
			default:
				break;
			}
			return descripcion;
		}
	}

	public static enum ESTADO_ENVIO_PR {

		ENVIADO, NO_ENVIADO, NO_ENCONTRADO;

		public String getCodigo() {
			switch (this) {
			case ENVIADO:
				codigo = "ENV";
				break;

			case NO_ENVIADO:
				codigo = "NEN";
				break;
			case NO_ENCONTRADO:
				codigo = "NOE";
				break;
			default:
				break;
			}
			return codigo;
		}

		public String getDescripcion() {
			switch (this) {
			case ENVIADO:
				descripcion = "ENVIADO";
				break;
			case NO_ENVIADO:
				descripcion = "NO ENVIADO";
				break;

			case NO_ENCONTRADO:
				descripcion = "NIT NO REGISTRADO BD";
				break;
			default:
				break;
			}
			return descripcion;
		}

	}

}