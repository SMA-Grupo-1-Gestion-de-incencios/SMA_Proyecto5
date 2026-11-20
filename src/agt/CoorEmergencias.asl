// Aquí se desarrollará el agente para llevar a cabo el rol Coordinador de Emergencias:
/* DESCRIPCIÓN FUNCIONAL:
    - Agente encargado de la dirección centralizada y coordinación global de la emergencia. Participará en los tres grupos 
    (del esquema de la organización) Moise: Detectar, Extinguir y Evacuar.
    - Recibe alertas de focos de incencio y cambios meteorológicos provenientes del Supervisor de Vigilancia.
    - Recibe cambios en las propiedades observables del artefacto CentroDeEmergencias
    - Recibe confirmaciones de estado y disponibilidad operativa.
    - Registra y estructura cada incidente en el artefacto 'CentroDeEmergencias'
    - Ejecuta las metas como "Avisar" y "Planear" y los esquemas de Extinción como "Apagar" y "Evacuar"
    - Distribuye órdenes hacia el Gestor de Extinción y Coordinador de Evacuación para minimizar daños globales y tiempo de respuesta.
*/

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true
    <- .print("hello world.");
       .date(Y,M,D); .time(H,Min,Sec,MilSec); // get current date & time
       +started(Y,M,D,H,Min,Sec).             // add a new belief

{ include("$jacamo/templates/common-cartago.asl") }
{ include("$jacamo/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
{ include("$moise/asl/org-obedient.asl") }