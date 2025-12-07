Ejercicio 1:
Este código define una Activity de Android que sirve como conversor de monedas.
Al crearse (onCreate), usa view binding para acceder a los elementos de la interfaz (dos EditText, un radioGroup, RadioButton y un TextView).
Se crea un TextWatcher que se añade a los dos EditText, de forma que cada vez que el usuario escribe algo en cantidad o en el tipo de cambio, se llama a la función actualizarConversion(). Además, cuando el usuario cambia la opción del RadioGroup (por ejemplo, de dólares a euros o al revés), también se vuelve a llamar a esa función.

En actualizarConversion() se hace todo el trabajo:
1- Se leen los textos de los EditText.
2- Si alguno está vacío, se borra el resultado y se termina.
3- Se intenta convertir esos textos a números Double con toDoubleOrNull().
4- Si no son válidos, se muestra un Toast avisando al usuario y se borra el resultado.
5- Si son válidos, según qué RadioButton esté marcado, se hace una multiplicación o una división para obtener la conversión.
6- Finalmente, se muestra el resultado en el TextView, formateado con dos decimales.

Ejercicio 2:
Este ejercicio consta de tres archivos:
- Main2Activity: El cual usa view binding (ActivityMain2Binding) y una lista mutable webs de objetos Web. En el onCreate llama  a inicializarDatos() para cargar dos webs de ejemplo, también llama a configurarRecyclerView() para crear el WebAdapter, asignar el LayoutManager lineal y conectar el adapter al RecyclerView y por último
llama a configurarSwipe() para activar el gesto de deslizar a la derecha y borrar elementos. El botón btnAdd crea un objeto Web nuevo, lo añade con adapter.addWeb() y muestra un Toast.
- Web: Es un data class que representa cada elemento de la lista (nombre, enlace, descripción, email, imagen).
- WebAdapter: Extiende RecyclerView.Adapter y tiene un ViewHolder (WebViewHolder) que referencia la imagen y los textos del layout item_web, en onBindViewHolder asigna imagen, nombre y enlace, y pone un setOnClickListener para cada item y cuando
se pulsa un item, se ejecuta la lambda onItemClick (definida en Main2Activity), que muestra un AlertDialog con descripción y email. Y por último tiene el método removeAt (eliminar una web y notificar al RecyclerView) y addWeb (añadir al final). Y el configurarSwipe() crea un ItemTouchHelper.SimpleCallback que solo reacciona al swipe a la derecha
y el onSwiped  llama a adapter.removeAt(...) y muestra un Toast “Sitio eliminado”.

Ejercicio 3:
Este ejercicio consta de tres archivos:
- ListaFragment:
. Muestra un RecyclerView con una lista fija de objetos Web
. Define una interfaz OnWebSelectedListener con el método onWebSelected(web: Web).
. En onAttach, comprueba que la Activity implemente esa interfaz; si no, lanza una excepción.
. En onCreateView, configura el RecyclerView con LinearLayoutManager y un WebAdapter.
. Cuando el usuario pulsa un elemento de la lista, el adapter llama a la lambda, que a su vez llama a listener?.onWebSelected(web) y notifica a la Activity qué web se ha seleccionado
- DetalleFragment
. En onCreateView infla el layout fragment_detalle y obtiene referencias a los TextView y ImageView
. Tiene el método público mostrarWeb(web: Web), que recibe un objeto Web y actualiza la imagen, el nombre, el enlace, la descripción y el email en pantalla.
. Este fragment solo se encarga de mostrar los datos que le manda la Activity.
- Main3Activity
. Implementa ListaFragment.OnWebSelectedListener, por lo que debe definir onWebSelected(web: Web).
. En onCreate carga el layout activity_main3 y obtiene una referencia al DetalleFragment usando supportFragmentManager.findFragmentById.
. Cuando ListaFragment avisa de que se ha pulsado una web, la Activity recibe ese evento en onWebSelected y llama a detalleFragment.mostrarWeb(web) para actualizar el fragment de detalle.

El MainActivity funciona com un menú de navegación que contiene tres botones los cuales al pulsarlos abren las ventanas de cada ejercicio es decir, por ejemplo si pulsamos el botón "Ejercicio 1" te sale la pantalla del ejercicio 1.
