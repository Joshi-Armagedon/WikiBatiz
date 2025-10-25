
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

    public static int menu(String[] opciones, String[] mensajes) {
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
        "3. Maestros titulares",
        "4. Regresar al menu inicial"};
    static String[] mensajeDeportivas = {
        "[TITULO]",
        "Realiza tus inscripciones en https://forms.gle./xbSYFKxs5oMV5eCG9",
        "Maestros",
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
        "1. opcion 1",
        "2. opcion 2",
        "3. opcion 3",
        "4. Regresar al menu inicial"
    };
    static String[] mensajeTramites = {
        "1. mensaje 1",
        "2. mensaje 2",
        "3. mensaje 3",
        "Espera..."
    };

    public static void MenuActividadesDeportivasCulturales() {
        int mostrar = menu(opcionesDeportivas, mensajeDeportivas);
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
        int mostrar = menu(opcionesTramites, mensajeTramites);
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
        int mostrar = menu(opcionesAlumnos, mensajeAlumnos);
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
        int mostrar = menu(opcionesEventos, mensajeEventos);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeEventos[mostrar - 1]);
                break;
        }
    }

    ;
    public static void MenuTutorias() {
        int mostrar = menu(opcionesTutorias, mensajeTutorias);
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
