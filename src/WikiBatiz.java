
import java.util.Scanner;

public class WikiBatiz {

    static boolean activo = true;
    static boolean reinicio = false;

    public static void main(String[] args) {
        do {
            ImprimirNombre();
            SeleccionTipoUsuario();
            Separacion();
            if (reinicio) {
                System.out.println("Regresando al menu inicial...");
                reinicio = false;
            } else {
                System.out.println("Deseas volver al menu inicial?");
                System.out.println("1.Si 2.No");
                String[] a = {"1. Si", "2. No"};
                Separacion();
                int RepetirConsulta = NumRango(a, 1, 2);
                if (RepetirConsulta == 2) {
                    activo = false;
                    System.out.println("Gracias por usar WikiBatiz");
                    Separacion();
                }
            }
        } while (activo);
    }

    public static void SeleccionTipoUsuario() {
        String[] usuarios = {"1. Administrador", "2. Usuario"};
        MostrarOpciones("Escoge tu tipo de usuario", usuarios);
        int usuarioSeleccionado = NumRango(usuarios, 1, usuarios.length);
        Separacion();
        System.out.println("Has seleccionado " + usuarios[usuarioSeleccionado - 1]);
        Separacion();
        switch (usuarioSeleccionado) {
            case 1:
                PanelAdministrador();
                break;
            case 2:
                usuarioActivo = true;
                ProcesoUsuario();
                break;
            default:
                System.out.println("Ha ocurrido un error, volviendo al menu inicial");
                reinicio = true;
                break;
        }
    }
    static boolean VienedeUnMenu = false;
    static boolean usuarioActivo = false;
    static String[] opcionesMenuUsuario = {
        "1. Actividades Deportivas y Cuturales",
        "2. Tramites",
        "3. Alumnos",
        "4. Eventos",
        "5. Tutorias"};

    public static void ProcesoUsuario() {
        do {
            MostrarOpciones("Selecciona tu consulta", opcionesMenuUsuario);
            int GotoMenu = NumRango(opcionesMenuUsuario, 1, opcionesMenuUsuario.length);
            switch (GotoMenu) {
                case 1:
                    MenuActividadesDeportivasCulturales();
                    break;
                case 2:
                    MenuTramites();
                    break;
                case 3:
                    MenuAlumnos();
                    break;
                case 4:
                    MenuEventos();
                    break;
                case 5:
                    MenuTutorias();
                    break;
                default:
                    System.out.println("Ha ocurrido un error inesperado");
                    VienedeUnMenu = true;
                    break;
            }
            Separacion();
            if (VienedeUnMenu) {
                System.out.println("Regresando al menu de consulta...");
                VienedeUnMenu = false;
            } else {
                System.out.println("Deseas realizar otra consulta?");
                System.out.println("1.Si 2.No");
                String[] a = {"1. Si", "2. No"};
                Separacion();
                int RepetirConsulta = NumRango(a, 1, 2);
                if (RepetirConsulta == 2) {
                    usuarioActivo = false;
                }
            }
        } while (usuarioActivo);
    }

    public static int menu(String[] opciones) {
        MostrarOpciones("Selecciona una opcion", opciones);
        int eleccion = NumRango(opciones, 1, opciones.length);
        if (eleccion >= opciones.length) {
            VienedeUnMenu = true;
        } else {
            return eleccion;
        };
        return 0;
    }

    static String[] opcionesDeportivas = {
        "1. Consultar horarios",
        "2. Inscripciones",
        "3. Profesores titulares",
        "4. Regresar al menu inicial"};
    static String[] mensajeDeportivas = {
         //horarios
            " ╔═════════════════════════════════════════════════════════════════════════════╗ \n" +
            " ║   Horarios      de    Actividades     Deportivas      y      Culturales     ║ \n" +
            " ╠═════════════╦═══════════╦════════════╦════════════╦════════════╦════════════╣ \n" +
            " ║ Actividades ║ Lunes     ║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Atletismo   ║10:00-13:00║09:00-13:00 ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Basquetbol  ║12:00-16:00║12:00-16:00 ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Volibol     ║12:00-16:00║12:00-16:00 ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Futbol      ║12:00-15:00║12:00-15:00 ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Tae Kwon Do ║           ║11:00-13:00 ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ║             ╠═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║             ║           ║15:00-17:00 ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Futbol      ║10:00-12:00║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ║ Americano   ╠═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║             ║15:00-17:00║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Tocho       ║11:00-13:00║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ║ Bandera     ╠═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║             ║15:00-17:00║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Artes       ║12:00-17:00║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ║ Visuales    ║ 1er piso  ║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Musica      ║09:00-17:00║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ║ Foklorica   ║ Auditorio ║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Danza       ║           ║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ║ Folklorica  ║           ║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Piano       ║           ║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Creacion    ║           ║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ║ Literaria   ║           ║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╠═════════════╬═══════════╬════════════╬════════════╬════════════╬════════════╣ \n" +
            " ║ Teatro      ║           ║ Martes     ║ Miércoles  ║ Jueves     ║ Viernes    ║ \n" +
            " ╚═════════════╩═══════════╩════════════╩════════════╩════════════╩════════════╝ \n"
            ,
         //inscripciones a actividades
        "Realiza tus inscripciones en https://forms.gle./xbSYFKxs5oMV5eCG9",
         //Profesores titulares
        "[Actividades Deportivas] \n" +
            " Atletismo: Profa. Alma Yadira Quintanar Camacho \n " +
            " Basquetbol : Prof.Miguel Angel Ramirez Calnacasco & prof. Carlos del Valle Garcia \n" +
            " Volibol: Prof. Miguel Angel Ramirez Calnasco \n" +
            " Futbol: Prof.Alfonso Morales Martinez \n" +
            " Tae Kwon Do: Arturo Wong \n " +
            " GFutbol Americano Varonil : HEAD COACH Rodrigo Galindo Nava \n" +
            " Tocho Bandera: HEAD COACH Juan Antonio Rivas Garcia \n" +
        "[Actividades Culturales] \n" +
                " Artes Visuales : Prof. Guadalupe de la Rosa Castelan \n " +
                " Musica Folklorica: Prof. Julio de la Cruz Rodriguez \n" +
                " Danza Folklorica: Prof. Emmanuel Flores Don Juan \n" +
                " Piano: Prof.Eduardo Gomez Alarcon \n" +
                " Creacion Literaria Profa. Rosa Maria Getino \n" +
                " Teatro: Prof. Alexis Badillo Ortiz \n"
            ,
        "Espera..."
    };
    static String[] opcionesTutorias = {
        "1. opcion 1",
        "2. opcion 2",
        "3. opcion 3",
        "4. Regresar al menu inicial"
    };
    static String[] mensajeTutorias = {
        "1. mensaje 1",
        "2. mensaje 2",
        "3. mensaje 3",
        "Espera..."
    };
    static String[] opcionesEventos = {
        "1. opcion 1",
        "2. opcion 2",
        "3. opcion 3",
        "4. Regresar al menu inicial"
    };
    static String[] mensajeEventos = {
        "1.mensaje 1",
        "2.mensaje 2",
        "3. mensaje 3",
        "Espera..."
    };
    static String[] opcionesAlumnos = {
        "1. opcion 1",
        "2. opcion 2",
        "3. opcion 3",
        "4. Regresar al menu inicial"
    };
    static String[] mensajeAlumnos = {
        "1. mensaje 1",
        "2. mensaje 2",
        "3. mensaje 3",
        "Espera..."
    };
    static String[] opcionesTramites = {
        "1. Solicitud de Dictamen",
        "2. Cambios de carrera o plantel",
        "3. Inscripción/ Reinscripción",
        "4. Proceso de Saberes Previos",
        "5. Trayectoria, constancias y boletas",
        "6. Bajas temporales y definitivas",
        "7. Certificados y documentacion de egreso",
        "8. Regresar al menu inicial "
    };
    static String[] mensajeTramites = {
        //1Dictamen
        "El periodo de recepción de solicitudes se lleva  " +
                "a cabo al final del proceso de inscripción de cada " +
                "semestre. " +
                "Los alumnos que hayan incumplido con lo esta- " +
                "blecido en el Reglamento General de Estudios y " +
                "deseen regularizar su situación escolar, deben " +
                "solicitar Dictamen: " +
                "Cuando el alumno aún puede terminar sus estu- " +
                "dios de nivel medio superior en los términos del " +
                "Art. 49 del Reglamento General de Estudios " +
                "(4 años y medio). " +
                "Cuando el alumno el alumno rebasa el término " +
                "establecido por el Art. 49 del Reglamento Gen- " +
                "eral de Estudios para el término de sus estudios " +
                "(más de 4 años y medio). " +
                "Para solicitarlo, deben enviar un mensaje de " +
                "correo electrónico a gestion.escolar.cecyt9@gmail.com indicando " +
                "nombre completo, número de boleta y situación " +
                "escolar"
        ,
        //2CambiodePlantelCarrera
        "La convocatoria se publica al final de cada se- " +
                "mestre en la siguiente página web: " +
                "www.dae.ipn.mx/cambiosua/"
        ,
        //3InscripcionReinscripcion
        "Las fechas y los procedimientos " +
                "se publican en la página del " +
                "CECyT y se difunden a través de " +
                "los medios oficiales del plantel. " +
                "La reinscripción NUNCA es au- " +
                "tomática y es obligación del " +
                "alumno estar atento a los co- " +
                "municados que se publican en la " +
                "página del plantel y de realizar " +
                "los trámites correspondientes en " +
                "tiempo y forma. " +
                "De igual forma, el alumno debe " +
                "informar de manera INMEDIATA " +
                "cualquier problema que tenga " +
                "con su registro de inscripción. " +
                "Toda la información que el alum- " +
                "no proporciona al plantel está " +
                "protegida por el aviso de privaci- " +
                "dad de la institución y la vera- " +
                "cidad de los datos es res- " +
                "ponsabilidad única del alumno. " +
                "Estos datos son utilizados para " +
                "la difusión de información ofi- " +
                "cial, para el trámite de becas y " +
                "otros estímulos, de documentos " +
                "de egreso y para ponerse en " +
                "contacto con sus padres y/o " +
                "tutores en casos de emergencia"
        ,
        //4SaberesPrevios
        "El proceso se lleva a cabo al inicio de " +
                "cada semestre. Las fechas y procedi- " +
                "mientos se publican en la página del " +
                "CECyT.",
        //5Trayectoria
        "El departamento de Gestión Escolar " +
                "expide, a solicitud del alumno, bo- " +
                "letas y constancias para diversor " +
                "trámites. Para solicitarlas, se debe " +
                "hacer el registro en las ligas abajo " +
                "indicadas:" +
                "• Boletas de calificaciones " +
                "https://forms.gle/bm3cfuW85rcozhid6" +
                "• Constancias de Estudio " +
                "https://forms.gle/P8b2S7SndaYynn5ZA",
        //6Bajas
        "BAJA TEMPORAL \n" +
                "Se solicita en los primeros 30 días " +
                "posteriores a la inscripción y puede " +
                "ser por 6 \n meses o por 1 año Para solicitarla, se debe escribir un " +
                "correo electrónico al departamento " +
                "solicitando la liga de registro. \n" +
                "• BAJA DEFINITIVA \n" +
                "Para solicitarla, primero se debe hacer " +
                "el registro en la siguiente liga: \n " +
                "https://forms.gle/phqbsmwKobLqEt8i7 \n" +
                "Después se debe solicitar el trámite de " +
                "una boleta global de calificaciones " +
                "(3 firmas) en la siguiente liga: \n" +
                "https://forms.gle/bm3cfuW85rcozhid6\n",
        //7Egreso
        "CERTIFICACIÓN INTEGRAL " +
                "Se lleva a cabo únicamente en el perio-" +
                "do intersemestral del mes de julio y " +
                "sirve para agilizar el proceso de certifi- " +
                "cación del alumno. El procedimiento se " +
                "publica en la página del plantel." +
                "• ENTREGA DE DOCUMENTACIÓN " +
                "DE EGRESO " +
                "Se lleva a cabo al final de cada semes- " +
                "tre para los alumnos que han concluido " +
                "satisfactoriamente sus estudios. El " +
                "procedimiento se publica en la página " +
                "del plantel",
        "Espera..."
    };

    public static void MenuActividadesDeportivasCulturales() {
        int mostrar = menu(opcionesDeportivas);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeDeportivas[mostrar - 1]);
                break;
        }
    }

    public static void MenuTramites() {
        int mostrar = menu(opcionesTramites);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeTramites[mostrar - 1]);
                break;
        }
    }

    public static void MenuAlumnos() {
        int mostrar = menu(opcionesAlumnos);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeAlumnos[mostrar - 1]);
                break;
        }
    }

    public static void MenuEventos() {
        int mostrar = menu(opcionesEventos);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeEventos[mostrar - 1]);
                break;
        }
    }

    public static void MenuTutorias() {
        int mostrar = menu(opcionesTutorias);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeTutorias[mostrar - 1]);
                break;
        }
    }

    ;


    public static void PanelAdministrador() {
        int contrasenaIngresada = 0;
        int contrasenaEsperada = -2310;
        System.out.println("Ingresa la contraseña");
        for (int i = 0; i < 3; i++) {
            Separacion();
            contrasenaIngresada = LeerNum();
            if (contrasenaIngresada == contrasenaEsperada) {
                i = 3;
            } else {
                Separacion();
                if (i != 2){
                    System.out.println("Contrase\u00F1a incorrecta - Intenta ingresarla de nuevo");
                }
            }
        }
        if (contrasenaIngresada != contrasenaEsperada) {
            System.out.println("Demasiados intentos");
            Separacion();
            reinicio = true;
        } else {
            System.out.println("Ahora eres admin");
        }
    }

    public static void MostrarOpciones(String mensaje, String[] opciones) {
        Separacion();
        System.out.println(mensaje);
        Separacion();
        for (int q = 0; q < opciones.length; q++) {
            System.out.println(opciones[q]);
        }
        Separacion();
    }

    public static int NumRango(String[] opciones, int minimo, int maximo) {
        int numIngresado = LeerNum();
        boolean bandera = (numIngresado < minimo) || (numIngresado > maximo);
        while (bandera) {
            Separacion();
            System.out.println("Ingresa un valor valido segun el menu");
            Separacion();
            for (int i = 0; i < opciones.length; i++) {
                System.out.println(opciones[i]);
            }
            Separacion();
            numIngresado = LeerNum();
            if (numIngresado >= minimo && numIngresado <= maximo) {
                bandera = false;
            }
        }
        Separacion();
        return numIngresado;
    }

    public static int LeerNum() {
        Scanner leer = new Scanner(System.in);
        int num = leer.nextInt();
        return num;
    }

    public static void Separacion() {
        for (int i = 0; i < 100; i++) {
            System.out.print("_");
        }
        System.out.println('\n');
    }

    public static void ImprimirNombre() {
        System.out.println(" ____________________________________________________________________________________________________________ ");
        System.out.println("|                                                                                                            |");
        System.out.println("|      :::       ::: ::::::::::: :::    ::: ::::::::::: :::::::::      ::: ::::::::::: ::::::::::: ::::::::: |");
        System.out.println("|     :+:       :+:     :+:     :+:   :+:      :+:     :+:    :+:   :+: :+:   :+:         :+:          :+:   |");
        System.out.println("|    +:+       +:+     +:+     +:+  +:+       +:+     +:+    +:+  +:+   +:+  +:+         +:+         +:+     |");
        System.out.println("|   +#+  +:+  +#+     +#+     +#++:++        +#+     +#++:++#+  +#++:++#++: +#+         +#+        +#+       |");
        System.out.println("|  +#+ +#+#+ +#+     +#+     +#+  +#+       +#+     +#+    +#+ +#+     +#+ +#+         +#+       +#+         |");
        System.out.println("|  #+#+# #+#+#      #+#     #+#   #+#      #+#     #+#    #+# #+#     #+# #+#         #+#      #+#           |");
        System.out.println("|  ###   ###   ########### ###    ### ########### #########  ###     ### ###     ########### #########       |");
        System.out.println("|                                                                                                            |");
        System.out.println("|____________________________________________________________________________________________________________|");
        System.out.println('\n');
    }
}
